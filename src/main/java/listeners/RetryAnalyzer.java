package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;

    private static final int MAX_RETRY_COUNT = 2;

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < MAX_RETRY_COUNT) {

            retryCount++;

            result.setAttribute(
                    "RetryCount",
                    retryCount);

            result.setAttribute(
                    "WillRetry",
                    true);

            System.out.println(
                    "Retrying "
                            + result.getMethod().getMethodName()
                            + " ("
                            + retryCount
                            + "/"
                            + MAX_RETRY_COUNT
                            + ")");

            return true;
        }

        /*
         * No more retries.
         */
        result.setAttribute(
                "WillRetry",
                false);

        return false;
    }

    public static int getMaxRetryCount() {

        return MAX_RETRY_COUNT;
    }
}