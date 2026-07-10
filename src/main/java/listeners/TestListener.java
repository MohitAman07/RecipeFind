package listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = ExtentManager.getInstance()
                .createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.log(Status.PASS,
                "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.log(Status.FAIL,
                result.getThrowable());

        String screenshot =
                ScreenshotUtil.captureScreenshot(
                        result.getName());

        try {

            test.addScreenCaptureFromPath(
                    screenshot);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager.getInstance().flush();
    }
}