package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.Notification;
import pagesObjects.Profile.Following_Tab;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC065_VerifyFollowNotification
        extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    @Override
    public void setUp(
            Method method) {

        loginEmail =
                ConfigReader.getProperty(
                        "superadmin.email");

        loginPassword =
                ConfigReader.getProperty(
                        "superadmin.password");

        super.setUp(
                method);
    }

    @Test
    public void verifyFollowNotification()
            throws Exception {

        String personName =
                "Rupsy S.";

        String expectedNotification =
                "Aman Mohit is following you";

        int maxAttempts =
                3;

        /*
         * Reusable Page Objects
         */
        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        Following_Tab following =
                new Following_Tab(
                        DriverFactory.getDriver());

        /*
         * Allow Home Dashboard To Stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Open Profile Tab
         */
        following.Click_Profile_Tab();

        Thread.sleep(
                2000);

        /*
         * Open Following Tab
         */
        following.Click_Following_Tab();

        Thread.sleep(
                2000);

        /*
         * Refresh Following List
         */
        following.refreshFollowingList();

        Thread.sleep(
                3000);

        /*
         * Follow Person
         *
         * Person tile is used only as an anchor.
         * Only the Follow button is clicked.
         */
        following.followPerson(
                personName);

        Thread.sleep(
                2000);

        /*
         * Verify Following Count
         */
        following.Verify_Following_count();

        Thread.sleep(
                2000);

        /*
         * Open Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu displayed successfully.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Logout Super User
         */
        hamburger.clickSignOut();

        Thread.sleep(
                8000);

        boolean notificationFound =
                false;

        /*
         * Notification Verification Loop
         */
        for (int attempt = 1;
                attempt <= maxAttempts;
                attempt++) {

            System.out.println(
                    "==================================================");

            System.out.println(
                    "Follow notification verification attempt : "
                            + attempt);

            System.out.println(
                    "==================================================");

            /*
             * Login As Rupsy S.
             */
            authenticateUser(
                    ConfigReader.getProperty(
                            "normaluser.email"),
                    ConfigReader.getProperty(
                            "normaluser.password"));

            ensureApplicationReady();

            Thread.sleep(
                    5000);

            /*
             * Reinitialize Notification
             */
            Notification notification =
                    new Notification(
                            DriverFactory.getDriver());

            /*
             * Verify Notification Bell
             */
            ValidationUtil.verifyTrue(
                    notification.isNotificationBellDisplayed(),
                    "Notification Bell is not displayed.");

            /*
             * Open Notification Panel
             */
            notification.clickNotificationBell();

            Thread.sleep(
                    3000);

            /*
             * Get Latest Notification
             */
            String latestNotification =
                    notification.getLatestNotification();

            System.out.println(
                    "Latest Notification : "
                            + latestNotification);

            System.out.println(
                    "Expected Notification : "
                            + expectedNotification);

            /*
             * Verify Latest Notification
             */
            if (latestNotification != null
                    && latestNotification.contains(
                            expectedNotification)) {

                notificationFound =
                        true;

                System.out.println(
                        "Expected follow notification found.");

                /*
                 * Close Notification Panel
                 */
                notification.clickDismissButton();

                break;
            }

            System.out.println(
                    "Expected notification not found.");

            /*
             * Close Notification Panel
             */
            notification.clickDismissButton();

            Thread.sleep(
                    2000);

            /*
             * Logout Rupsy S.
             */
            hamburger =
                    new Hamburger(
                            DriverFactory.getDriver());

            hamburger.clickHamburgerMenu();

            Thread.sleep(
                    2000);

            hamburger.clickSignOut();

            Thread.sleep(
                    8000);

            /*
             * Login As Super User Again
             */
            authenticateUser(
                    ConfigReader.getProperty(
                            "superadmin.email"),
                    ConfigReader.getProperty(
                            "superadmin.password"));

            ensureApplicationReady();

            Thread.sleep(
                    5000);

            /*
             * Reinitialize Page Objects
             */
            hamburger =
                    new Hamburger(
                            DriverFactory.getDriver());

            following =
                    new Following_Tab(
                            DriverFactory.getDriver());

            /*
             * Open Profile Tab
             */
            following.Click_Profile_Tab();

            Thread.sleep(
                    2000);

            /*
             * Open Following Tab
             */
            following.Click_Following_Tab();

            Thread.sleep(
                    2000);

            /*
             * Refresh Following List
             */
            following.refreshFollowingList();

            Thread.sleep(
                    3000);

            /*
             * Follow Person Again
             */
            following.followPerson(
                    personName);

            Thread.sleep(
                    2000);

            /*
             * Open Hamburger Menu
             */
            hamburger.clickHamburgerMenu();

            Thread.sleep(
                    2000);

            /*
             * Logout Super User
             */
            hamburger.clickSignOut();

            Thread.sleep(
                    8000);
        }

        /*
         * Final Notification Validation
         */
        ValidationUtil.verifyTrue(
                notificationFound,
                "Expected follow notification was not generated after "
                        + maxAttempts
                        + " attempts. Expected : "
                        + expectedNotification);

        System.out.println(
                "==================================================");

        System.out.println(
                "Follow notification verified successfully.");

        System.out.println(
                "Person followed : "
                        + personName);

        System.out.println(
                "Expected Notification : "
                        + expectedNotification);

        System.out.println(
                "==================================================");
    }
}