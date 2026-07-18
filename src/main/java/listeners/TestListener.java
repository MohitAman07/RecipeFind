package listeners;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import reports.PDFReportGenerator;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import reports.ExtentManager;
import utils.ConsoleColor;
import utils.LogUtil;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static final ThreadLocal<ExtentTest> test =
        new ThreadLocal<>();

    private static final ConcurrentHashMap<String, ExtentTest> testMap =
        new ConcurrentHashMap<>();

    private static int passedCount = 0;
    private static int failedCount = 0;
    private static int skippedCount = 0;

    private static final List<String[]> executionSummary =
            new ArrayList<>();

    @Override
public void onTestStart(ITestResult result) {

    String key =
            result.getMethod().getQualifiedName();

    ExtentTest extentTest =
            testMap.computeIfAbsent(
                    key,
                    k -> ExtentManager.getInstance()
                            .createTest(result.getName()));

    test.set(extentTest);

    /*
     * Log Execution Started only once
     */
    if (result.getAttribute("ExecutionStarted") == null) {

        extentTest.log(
                Status.INFO,
                "Execution Started");

        result.setAttribute(
                "ExecutionStarted",
                true);
    }
}

    @Override
public void onTestSuccess(ITestResult result) {

    String testCase =
            result.getTestClass()
                    .getRealClass()
                    .getSimpleName();

    System.out.println(
            "[" + LogUtil.getCurrentTime() + "] "
                    + testCase
                    + " ["
                    + ConsoleColor.GREEN
                    + "PASSED"
                    + ConsoleColor.RESET
                    + "]");

    String key =
            result.getMethod()
                    .getQualifiedName();

    ExtentTest extentTest =
            testMap.get(key);

    if (extentTest != null) {

        extentTest.pass(
                "Test Passed Successfully.");
    }

    testMap.remove(key);
}

   @Override
public void onTestFailure(ITestResult result) {

    String testCase =
            result.getTestClass()
                    .getRealClass()
                    .getSimpleName();

    String key =
            result.getMethod()
                    .getQualifiedName();

    ExtentTest extentTest =
            testMap.get(key);

    Object retry =
            result.getAttribute("RetryCount");

    int retryCount =
            retry == null
                    ? 0
                    : (int) retry;

    /*
     * Retry in Progress
     */
    if (retryCount > 0
            && retryCount <= RetryAnalyzer.getMaxRetryCount()) {

        System.out.println(
                "[" + LogUtil.getCurrentTime() + "] "
                        + testCase
                        + " ["
                        + ConsoleColor.YELLOW
                        + "RETRYING "
                        + retryCount
                        + "/"
                        + RetryAnalyzer.getMaxRetryCount()
                        + ConsoleColor.RESET
                        + "]");

        if (extentTest != null) {

            extentTest.log(
                    Status.INFO,
                    "Retry Attempt "
                            + retryCount
                            + " of "
                            + RetryAnalyzer.getMaxRetryCount());
        }

        /*
         * If another retry will happen,
         * don't mark the test as failed yet.
         */
        if (retryCount < RetryAnalyzer.getMaxRetryCount()) {

            return;
        }
    }

    /*
     * Final Failure
     */
    System.out.println(
            "[" + LogUtil.getCurrentTime() + "] "
                    + testCase
                    + " ["
                    + ConsoleColor.RED
                    + "FAILED"
                    + ConsoleColor.RESET
                    + "]");

    if (extentTest != null) {

        extentTest.fail(
                "Failed After "
                        + RetryAnalyzer.getMaxRetryCount()
                        + " Retry Attempts.");

        if (result.getThrowable() != null) {

            extentTest.fail(
                    result.getThrowable().getMessage());
        }
    }

    String screenshot =
            ScreenshotUtil.captureScreenshot(
                    result.getName());

    try {

        if (extentTest != null) {

            extentTest.addScreenCaptureFromPath(
                    screenshot);
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    testMap.remove(key);
}

    @Override
public void onTestSkipped(ITestResult result) {

    /*
     * Ignore retry-generated skips
     */
    if (result.getAttribute("RetryCount") != null) {
        return;
    }

    String testCase =
            result.getTestClass()
                    .getRealClass()
                    .getSimpleName();

    System.out.println(
            "[" + LogUtil.getCurrentTime() + "] "
                    + testCase
                    + " ["
                    + ConsoleColor.PURPLE
                    + "SKIPPED"
                    + ConsoleColor.RESET
                    + "]");

    String key =
            result.getMethod()
                    .getQualifiedName();

    ExtentTest extentTest =
            testMap.get(key);

    if (extentTest != null) {

        extentTest.skip(
                "Test Skipped.");

        testMap.remove(key);
    }
}

    @Override
public void onFinish(ITestContext context) {

    ExtentManager.getInstance().flush();

    PDFReportGenerator.generate(context);

    Map<String, String> results =
            new LinkedHashMap<>();

    /*
     * Passed Tests
     */
    context.getPassedTests()
            .getAllResults()
            .forEach(result ->
                    results.put(
                            result.getTestClass()
                                    .getRealClass()
                                    .getSimpleName(),
                            "PASSED"));

    /*
     * Failed Tests
     */
    context.getFailedTests()
            .getAllResults()
            .forEach(result ->
                    results.put(
                            result.getTestClass()
                                    .getRealClass()
                                    .getSimpleName(),
                            "FAILED"));

    /*
     * Skipped Tests
     */
    context.getSkippedTests()
            .getAllResults()
            .forEach(result -> {

                String testCase =
                        result.getTestClass()
                                .getRealClass()
                                .getSimpleName();

                if (!results.containsKey(testCase)) {

                    results.put(
                            testCase,
                            "SKIPPED");
                }
            });

    int passed = 0;
    int failed = 0;
    int skipped = 0;

    System.out.println();
    System.out.println("==============================================================");
    System.out.println("                 TEST EXECUTION SUMMARY");
    System.out.println("==============================================================");
    System.out.println();

    for (Map.Entry<String, String> entry : results.entrySet()) {

        String symbol;

        switch (entry.getValue()) {

            case "PASSED":
                symbol = "[PASS]";
                passed++;
                break;

            case "FAILED":
                symbol = "[FAIL]";
                failed++;
                break;

            default:
                symbol = "[SKIP]";
                skipped++;
                break;
        }

        System.out.printf(
                "%-7s %-40s %s%n",
                symbol,
                entry.getKey(),
                entry.getValue());
    }

    System.out.println();
    System.out.println("--------------------------------------------------------------");

    System.out.printf(
            "Passed  : %d%n",
            passed);

    System.out.printf(
            "Failed  : %d%n",
            failed);

    System.out.printf(
            "Skipped : %d%n",
            skipped);

    System.out.printf(
            "Total   : %d%n",
            passed + failed + skipped);

    System.out.println("==============================================================");
}
}