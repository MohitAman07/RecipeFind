package tests;

import java.util.List;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.Notification;
import utils.ValidationUtil;

public class TC040_VerifyNotificationScreen extends BaseTest {

    @Test
    public void verifyNotificationScreen() throws InterruptedException {

        Notification notification =
                new Notification(
                        DriverFactory.getDriver());

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        /*
         * Verify Notification Bell
         */
        ValidationUtil.verifyTrue(
                notification.isNotificationBellDisplayed(),
                "Notification Bell is displayed.");

        /*
         * Verify Notification Badge (Optional)
         */
        if (notification.isNotificationBadgeDisplayed()) {

            int badgeCount =
                    notification.getNotificationBadgeCount();

            ValidationUtil.verifyTrue(
                    badgeCount > 0,
                    "Notification Badge Count : "
                            + badgeCount);

        } else {

            System.out.println(
                    "Notification Badge is not displayed. No unread notifications available.");
        }

        /*
         * Open Notification Panel
         */
        notification.clickNotificationBell();

        /*
         * Verify Notification Heading
         */
        ValidationUtil.verifyTrue(
                notification.isNotificationHeadingDisplayed(),
                "Notification panel opened successfully.");

        /*
         * Verify Notification Count
         */
        int notificationCount =
                notification.getNotificationCount();

        ValidationUtil.verifyTrue(
                notificationCount > 0,
                "Notifications are available.");

        /*
         * Verify Latest Notifications
         */
        List<String> latestNotifications =
                notification.getLatestNotifications();

        ValidationUtil.verifyTrue(
                latestNotifications.size() > 0,
                "Latest notifications are available.");

        /*
         * Verify All Notifications
         */
        List<String> notifications =
                notification.getAllNotifications();

        ValidationUtil.verifyTrue(
                notifications.size() > 0,
                "Notifications retrieved successfully.");

        /*
         * Verify All Latest Notifications Exist
         */
        for (String latestNotification : latestNotifications) {

            ValidationUtil.verifyTrue(
                    notifications.contains(
                            latestNotification),
                    "Latest notification exists in the notification list: "
                            + latestNotification);
        }

        /*
         * Close Notification Panel
         */
        Thread.sleep(3000);

        notification.clickDismissButton();

        Thread.sleep(3000);

        /*
         * Logout
         */
        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        hamburger.clickSignOut();
    }
}