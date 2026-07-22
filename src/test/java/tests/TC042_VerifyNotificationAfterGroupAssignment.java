package tests;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.GroupManagement;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.Notification;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC042_VerifyNotificationAfterGroupAssignment extends BaseTest {

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

        super.setUp(method);
    }

    @Test
    public void verifyNotificationAfterGroupAssignment()
            throws Exception {

        /*
         * Test Data
         */
        String groupName1 =
                "Automation Group 1 "
                        + System.currentTimeMillis();

        Thread.sleep(10);

        String groupName2 =
                "Automation Group 2 "
                        + System.currentTimeMillis();

        Thread.sleep(10);

        String groupName3 =
                "Automation Group 3 "
                        + System.currentTimeMillis();

        String groupDescription =
                "Automation Group Description";

        String groupDomain =
                "www.google.com";

        String adminUser =
                ConfigReader.getProperty(
                        "groupadmin.email");

        /*
         * Initialize Page Objects
         */
        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        GroupManagement groupManagement =
                new GroupManagement(
                        DriverFactory.getDriver());

        Notification notification =
                new Notification(
                        DriverFactory.getDriver());

        /*
         * Verify Notification Bell
         */
        ValidationUtil.verifyTrue(
                notification.isNotificationBellDisplayed(),
                "Notification Bell displayed successfully.");

        /*
         * Capture Existing Notification Badge Count
         */
        int previousNotificationCount = 0;

        if (notification.isNotificationBadgeDisplayed()) {

            previousNotificationCount =
                    notification.getNotificationBadgeCount();

            System.out.println(
                    "Notification Badge Count : "
                            + previousNotificationCount);

        } else {

            System.out.println(
                    "Notification badge not available.");
        }

        /*
         * Navigate To Group Management
         */
        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(3000);

        hamburger.clickGroupManagement();

        Thread.sleep(3000);

                /*
         * Create Group 1
         */
        groupManagement.hideKeyboard();

        groupManagement.enterGroupName(
                groupName1);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDescription(
                groupDescription);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDomain(
                groupDomain);

        groupManagement.hideKeyboard();

        groupManagement.enterAssignAdmin(
                adminUser);

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        groupManagement.clickTickButton();

        Thread.sleep(2000);

        groupManagement.clickAdminUser(
                adminUser);

        Thread.sleep(2000);

        groupManagement.clickCreateGroup();

        Thread.sleep(5000);

        System.out.println(
                "Group 1 created successfully.");

        /*
         * Create Group 2
         */
        groupManagement.hideKeyboard();

        groupManagement.enterGroupName(
                groupName2);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDescription(
                groupDescription);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDomain(
                groupDomain);

        groupManagement.hideKeyboard();

        groupManagement.enterAssignAdmin(
                adminUser);

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        groupManagement.clickTickButton();

        Thread.sleep(2000);

        groupManagement.clickAdminUser(
                adminUser);

        Thread.sleep(2000);

        groupManagement.clickCreateGroup();

        Thread.sleep(5000);

        System.out.println(
                "Group 2 created successfully.");

        /*
         * Create Group 3
         */
        groupManagement.hideKeyboard();

        groupManagement.enterGroupName(
                groupName3);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDescription(
                groupDescription);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDomain(
                groupDomain);

        groupManagement.hideKeyboard();

        groupManagement.enterAssignAdmin(
                adminUser);

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        groupManagement.clickTickButton();

        Thread.sleep(2000);

        groupManagement.clickAdminUser(
                adminUser);

        Thread.sleep(2000);

        groupManagement.clickCreateGroup();

        Thread.sleep(5000);

        System.out.println(
                "Group 3 created successfully.");

                /*
         * Logout Super Admin
         */
        Thread.sleep(3000);

        hamburger.clickBackButton();

        Thread.sleep(3000);

        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(2000);

        hamburger.clickSignOut();

        Thread.sleep(8000);

        /*
         * Login As Group Admin
         */
        authenticateUser(
                ConfigReader.getProperty(
                        "groupadmin.email"),
                ConfigReader.getProperty(
                        "groupadmin.password"));

        ensureApplicationReady();

        Thread.sleep(5000);

        /*
         * Reinitialize Page Objects
         */
        hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        notification =
                new Notification(
                        DriverFactory.getDriver());

        /*
         * Verify Notification Bell
         */
        ValidationUtil.verifyTrue(
                notification.isNotificationBellDisplayed(),
                "Notification Bell displayed successfully.");

        /*
         * Verify Notification Badge Increased
         */
        if (notification.isNotificationBadgeDisplayed()) {

            int currentNotificationCount =
                    notification.getNotificationBadgeCount();

            System.out.println(
                    "Notification Badge Count : "
                            + currentNotificationCount);

            ValidationUtil.verifyTrue(
                    currentNotificationCount
                            > previousNotificationCount,
                    "Notification badge count increased after assigning groups.");

        } else {

            ValidationUtil.verifyTrue(
                    false,
                    "Notification badge not displayed.");
        }

        /*
         * Open Notification Panel
         */
        notification.clickNotificationBell();

        Thread.sleep(3000);

        /*
         * Verify Notification Screen
         */
        ValidationUtil.verifyTrue(
                notification.isNotificationHeadingDisplayed(),
                "Notification panel opened successfully.");

        /*
         * Fetch Latest Notification
         */
        String latestNotification =
                notification.getLatestNotification();

        ValidationUtil.verifyFalse(
                latestNotification.isBlank(),
                "Latest Notification : "
                        + latestNotification);

        /*
         * Fetch All Notifications
         */
        List<String> notifications =
                notification.getAllNotifications();

        ValidationUtil.verifyTrue(
                notifications.size() > 0,
                "Notifications fetched successfully.");

        /*
         * Verify Latest Notification Exists
         */
        ValidationUtil.verifyTrue(
                notifications.contains(
                        latestNotification),
                "Latest notification exists in notification list.");

        /*
        * Verify Group 1 Notification
        */
        String group1Notification =
                notifications.stream()
                        .filter(notificationText ->
                                notificationText.contains(groupName1))
                        .findFirst()
                        .orElse("");

        ValidationUtil.verifyFalse(
                group1Notification.isBlank(),
                "Notification received for Group 1 :\n"
                        + group1Notification);

        /*
        * Verify Group 2 Notification
        */
        String group2Notification =
                notifications.stream()
                        .filter(notificationText ->
                                notificationText.contains(groupName2))
                        .findFirst()
                        .orElse("");

        ValidationUtil.verifyFalse(
                group2Notification.isBlank(),
                "Notification received for Group 2 :\n"
                        + group2Notification);

            /*
            * Verify Group 3 Notification
            */
            String group3Notification =
                    notifications.stream()
                            .filter(notificationText ->
                                    notificationText.contains(groupName3))
                            .findFirst()
                            .orElse("");

            ValidationUtil.verifyFalse(
                    group3Notification.isBlank(),
                    "Notification received for Group 3 :\n"
                            + group3Notification);

        /*
         * Close Notification Panel
         */
        notification.clickDismissButton();

        Thread.sleep(3000);

        /*
         * Logout Group Admin
         */
        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(2000);

        hamburger.clickSignOut();

        Thread.sleep(5000);

        System.out.println(
                "TC042_VerifyNotificationAfterGroupAssignment executed successfully.");
    }
}