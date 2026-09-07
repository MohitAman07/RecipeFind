package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.HomeDashboard;

public class RetryAnalyzer
        implements IRetryAnalyzer {

    private int retryCount =
            0;

    private static final int MAX_RETRY_COUNT =
            0;

    @Override
    public boolean retry(
            ITestResult result) {

        if (retryCount < MAX_RETRY_COUNT) {

            retryCount++;

            result.setAttribute(
                    "RetryCount",
                    retryCount);

            result.setAttribute(
                    "WillRetry",
                    true);

            System.out.println(
                    "==================================================");

            System.out.println(
                    "Retry required for : "
                            + result.getMethod()
                                    .getMethodName());

            System.out.println(
                    "Retrying "
                            + result.getMethod()
                                    .getMethodName()
                            + " ("
                            + retryCount
                            + "/"
                            + MAX_RETRY_COUNT
                            + ")");

            /*
             * Logout and close the current
             * application session before retry.
             */
            resetApplicationForRetry();

            System.out.println(
                    "Application reset completed.");

            System.out.println(
                    "Starting retry from fresh session.");

            System.out.println(
                    "==================================================");

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


    /*
     * Reset Application Before Retry
     */
    private void resetApplicationForRetry() {

        try {

            if (DriverFactory.getDriver() != null) {

                HomeDashboard homeDashboard =
                        new HomeDashboard(
                                DriverFactory.getDriver());

                Hamburger hamburger =
                        new Hamburger(
                                DriverFactory.getDriver());

                /*
                 * Try to return to Home screen
                 * before attempting logout.
                 */
                try {

                    homeDashboard.clickHomeButton();

                    Thread.sleep(
                            1500);

                    System.out.println(
                            "Home button clicked before retry logout.");

                }

                catch (Exception e) {

                    System.out.println(
                            "Home button could not be clicked. "
                                    + "Continuing with logout.");
                }

                /*
                 * Check Hamburger menu.
                 */
                try {

                    if (hamburger.isHamburgerMenuVisible()) {

                        hamburger.clickHamburgerMenu();

                        Thread.sleep(
                                1000);

                        hamburger.clickSignOut();

                        Thread.sleep(
                                1500);

                        System.out.println(
                                "Application logged out before retry.");
                    }

                    else {

                        System.out.println(
                                "Hamburger menu not visible. "
                                        + "Continuing driver cleanup.");
                    }
                }

                catch (Exception e) {

                    System.out.println(
                            "Hamburger logout failed : "
                                    + e.getMessage());
                }
            }
        }

        catch (Exception e) {

            System.out.println(
                    "Retry application reset failed : "
                            + e.getMessage());
        }

        finally {

            /*
             * Always close the existing
             * driver before retry.
             */
            try {

                DriverFactory.quitDriver();

                System.out.println(
                        "Driver closed before retry.");

            }

            catch (Exception e) {

                System.out.println(
                        "Driver cleanup failed : "
                                + e.getMessage());
            }
        }
    }


    /*
     * Get Maximum Retry Count
     */
    public static int getMaxRetryCount() {

        return MAX_RETRY_COUNT;
    }
}