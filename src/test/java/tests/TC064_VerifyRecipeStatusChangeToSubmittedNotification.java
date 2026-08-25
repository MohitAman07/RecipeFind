package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.ControlPanel;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.Notification;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC064_VerifyRecipeStatusChangeToSubmittedNotification
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
    public void verifyRecipeStatusChangeToSubmittedNotification()
            throws Exception {

        String recipeName =
                "Basmati Rice";

        String newStatus =
                "submitted";

        String expectedNotification =
                "Status of your "
                        + recipeName
                        + " changed to "
                        + newStatus;

        /*
         * Maximum Notification Attempts
         */
        int maxAttempts =
                2;

        boolean notificationFound =
                false;

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        ControlPanel controlPanel =
                new ControlPanel(
                        DriverFactory.getDriver());

        /*
         * Open Hamburger Menu
         */
        Thread.sleep(
                3000);

        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is  displayed.");

        Thread.sleep(
                3000);

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Open Control Panel
         */
        hamburger.clickControlPanel();

        Thread.sleep(
                5000);

        /*
         * Open All Tab
         */
        controlPanel.clickAllTab();

        Thread.sleep(
                3000);

        /*
         * Search Recipe
         */
        controlPanel.enterSearchText(
                recipeName);

        controlPanel.hideKeyboard();

        Thread.sleep(
                5000);

        /*
         * Verify Recipe
         */
        ValidationUtil.verifyTrue(
                controlPanel.isRecipeDisplayed(
                        recipeName),
                "Recipe is  displayed in Control Panel.");

        /*
         * Open Change Status
         */
        controlPanel.clickRecipeMenu(
                recipeName);

        Thread.sleep(
                2000);

        /*
         * Change To Submitted
         */
        controlPanel.clickSubmittedStatus();

        Thread.sleep(
                5000);

        /*
         * Verify Submitted Tab
         */
        controlPanel.clickSubmittedTab();

        Thread.sleep(
                5000);

        ValidationUtil.verifyTrue(
                controlPanel.isRecipeDisplayed(
                        recipeName),
                "Recipe is  displayed in Submitted tab.");

        System.out.println(
                "Recipe status changed to "
                        + newStatus
                        + ".");

        /*
         * Navigate Back
         */
        Thread.sleep(
                3000);

        hamburger.clickBackButton();

        Thread.sleep(
                3000);

        /*
         * Open Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                3000);

        /*
         * Logout Super User
         */
        hamburger.clickSignOut();

        Thread.sleep(
                8000);

        /*
         * Notification Verification Loop
         */
        for (int attempt = 1;
                attempt <= maxAttempts;
                attempt++) {

            System.out.println(
                    "==================================================");

            System.out.println(
                    "Notification Verification Attempt : "
                            + attempt);

            System.out.println(
                    "==================================================");

            /*
             * Login As Test User
             */
            authenticateUser(
                    ConfigReader.getProperty(
                            "gmail.email"),
                    ConfigReader.getProperty(
                            "gmail.password"));

            ensureApplicationReady();

            Thread.sleep(
                    5000);

            /*
             * Initialize Notification
             */
            Notification notification =
                    new Notification(
                            DriverFactory.getDriver());

            /*
             * Verify Notification Bell
             */
            ValidationUtil.verifyTrue(
                    notification.isNotificationBellDisplayed(),
                    "Notification Bell is  displayed.");

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

            /*
             * Verify Expected Notification
             */
            if (!latestNotification.isBlank()
                    && latestNotification
                            .toLowerCase()
                            .contains(
                                    expectedNotification
                                            .toLowerCase())) {

                notificationFound =
                        true;

                System.out.println(
                        "Expected notification found.");

                System.out.println(
                        "Expected Notification : "
                                + expectedNotification);

                /*
                 * Dismiss Notification Panel
                 */
                notification.clickDismissButton();

                Thread.sleep(
                        2000);

                break;
            }

            /*
             * Expected Notification  Found
             */
            System.out.println(
                    "Expected notification  found.");

            /*
             * Dismiss Notification Panel
             */
            notification.clickDismissButton();

            Thread.sleep(
                    2000);

            /*
             * No More Retry
             */
            if (attempt ==
                    maxAttempts) {

                break;
            }

            /*
             * Logout Test User
             */
            Thread.sleep(
                    3000);

            hamburger =
                    new Hamburger(
                            DriverFactory.getDriver());

            hamburger.clickHamburgerMenu();

            Thread.sleep(
                    3000);

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

            controlPanel =
                    new ControlPanel(
                            DriverFactory.getDriver());

            /*
             * Open Hamburger Menu
             */
            hamburger.clickHamburgerMenu();

            Thread.sleep(
                    2000);

            /*
             * Open Control Panel
             */
            hamburger.clickControlPanel();

            Thread.sleep(
                    5000);

            /*
             * Open All Tab
             */
            controlPanel.clickAllTab();

            Thread.sleep(
                    3000);

            /*
             * Search Recipe
             *
             * Same search flow as first attempt
             */
            controlPanel.enterSearchText(
                    recipeName);

            controlPanel.hideKeyboard();

            Thread.sleep(
                    5000);

            /*
             * Verify Recipe
             */
            ValidationUtil.verifyTrue(
                    controlPanel.isRecipeDisplayed(
                            recipeName),
                    "Recipe is  displayed in Control Panel.");

            /*
             * Open Change Status
             */
            controlPanel.clickRecipeMenu(
                    recipeName);

            Thread.sleep(
                    2000);

            /*
             * Change To Submitted
             */
            controlPanel.clickSubmittedStatus();

            Thread.sleep(
                    5000);

            /*
             * Verify Submitted Tab
             */
            controlPanel.clickSubmittedTab();

            Thread.sleep(
                    5000);

            ValidationUtil.verifyTrue(
                    controlPanel.isRecipeDisplayed(
                            recipeName),
                    "Recipe is  displayed in Submitted tab.");

            System.out.println(
                    "Recipe status changed to Submitted.");

            /*
             * Logout Super User
             */
            Thread.sleep(
                    3000);

            hamburger.clickBackButton();

            Thread.sleep(
                    3000);

            hamburger.clickHamburgerMenu();

            Thread.sleep(
                    3000);

            hamburger.clickSignOut();

            Thread.sleep(
                    8000);
        }

        /*
         * Final Notification Validation
         */
        ValidationUtil.verifyTrue(
                notificationFound,
                "Expected notification was  generated after "
                        + maxAttempts
                        + " attempts. Expected : "
                        + expectedNotification);

        
        Thread.sleep(
                3000);

        /*
         * Open Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                3000);

        /*
         * Logout Super User
         */
        hamburger.clickSignOut();
        

        System.out.println(
                "==================================================");

        System.out.println(
                "Recipe status change notification verified successfully.");

        System.out.println(
                "Recipe : "
                        + recipeName);

        System.out.println(
                "New Status : "
                        + newStatus);

        System.out.println(
                "Expected Notification : "
                        + expectedNotification);

        System.out.println(
                "==================================================");
    }
}