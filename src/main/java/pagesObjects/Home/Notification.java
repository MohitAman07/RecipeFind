package pagesObjects.Home;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.WaitUtil;

public class Notification {

    private AndroidDriver driver;
    private WaitUtil waitUtil;

    public Notification(
            AndroidDriver driver) {

        this.driver =
                driver;

        this.waitUtil =
                new WaitUtil(
                        driver);

        PageFactory.initElements(
                new AppiumFieldDecorator(
                        driver),
                this);
    }

    /*
     * Notification Bell
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Notifications']")
    private WebElement notificationBell;

    /*
     * Notification Heading
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Notifications']")
    private WebElement notificationHeading;

    /*
     * Notification Scroll View
     */
    @AndroidFindBy(xpath = "//android.widget.ScrollView")
    private WebElement notificationScrollView;

    /*
     * Dynamic Notification
     */
    private WebElement notification(
            String message) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'"
                                + message
                                + "')]"));
    }

    /*
     * Notification Badge
     */
    private WebElement notificationBadge() {

        List<WebElement> badges =
                driver.findElements(
                        AppiumBy.xpath(
                                "//android.view.View[@content-desc]"));

        for (WebElement badge : badges) {

            String value =
                    badge.getAttribute(
                            "content-desc");

            if (value != null
                    && value.matches("\\d+")) {

                return badge;
            }
        }

        return null;
    }

    /*
     * Notification Bell
     */
    public boolean isNotificationBellDisplayed() {

        return notificationBell.isDisplayed();
    }

    /*
     * Notification Heading
     */
    public boolean isNotificationHeadingDisplayed() {

        return notificationHeading.isDisplayed();
    }

    /*
     * Verify Notification
     */
    public boolean isNotificationDisplayed(
            String message) {

        try {

            return notification(
                    message)
                            .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Verify Notification Badge
     */
    public boolean isNotificationBadgeDisplayed() {

        try {

            WebElement badge =
                    notificationBadge();

            return badge != null
                    && badge.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

        /*
     * Get Notification Badge Count
     */
    public int getNotificationBadgeCount() {

        try {

            WebElement badge =
                    notificationBadge();

            if (badge == null) {

                return 0;
            }

            int count =
                    Integer.parseInt(
                            badge.getAttribute(
                                    "content-desc"));

            System.out.println(
                    "Notification Badge Count : "
                            + count);

            return count;

        }

        catch (Exception e) {

            System.out.println(
                    "Notification badge not available.");

            return 0;
        }
    }

    /*
     * Verify Notification Badge Increased
     */
    public boolean isNotificationBadgeIncreased(
            int previousCount) {

        return getNotificationBadgeCount()
                > previousCount;
    }

    /*
     * Open Notification Panel
     */
    public void clickNotificationBell() {

        waitUtil.clickWithWait(
                notificationBell);

        System.out.println(
                "Notification panel opened.");
    }

    /*
     * Click Notification
     */
    public void clickNotification(
            String message) {

        waitUtil.clickWithWait(
                notification(
                        message));

        System.out.println(
                "Notification clicked.");
    }

    /*
     * Close Notification Panel
     */
    public void clickDismissButton() {

        Dimension size =
                driver.manage()
                        .window()
                        .getSize();

        int x =
                size.getWidth() / 2;

        int y =
                (int) (size.getHeight() * 0.92);

        PointerInput finger =
                new PointerInput(
                        PointerInput.Kind.TOUCH,
                        "finger");

        Sequence tap =
                new Sequence(
                        finger,
                        1);

        tap.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        x,
                        y));

        tap.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        tap.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(
                Collections.singletonList(
                        tap));

        System.out.println(
                "Notification panel closed.");
    }

        /*
     * Get Latest Notification
     */
    public String getLatestNotification() {

        List<WebElement> notifications =
                driver.findElements(
                        AppiumBy.xpath(
                                "//android.widget.ScrollView/android.view.View"));

        if (notifications.isEmpty()) {

            return "";
        }

        return notifications
                .get(0)
                .getAttribute(
                        "content-desc");
    }

    /*
     * Notification Count
     */
    public int getNotificationCount() {

        return driver.findElements(
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.view.View"))
                .size();
    }

    /*
     * Scroll Notifications
     */
    public void scrollNotifications() {

        Dimension size =
                DriverFactory.getDriver()
                        .manage()
                        .window()
                        .getSize();

        int startX =
                size.getWidth() / 2;

        int startY =
                (int) (size.getHeight() * 0.75);

        int endY =
                (int) (size.getHeight() * 0.30);

        PointerInput finger =
                new PointerInput(
                        PointerInput.Kind.TOUCH,
                        "finger");

        Sequence swipe =
                new Sequence(
                        finger,
                        1);

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        startX,
                        startY));

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(
                                700),
                        PointerInput.Origin.viewport(),
                        startX,
                        endY));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        DriverFactory.getDriver()
                .perform(
                        List.of(
                                swipe));

        System.out.println(
                "Notifications scrolled successfully.");
    }

        /*
     * Get All Notifications
     */
    public List<String> getAllNotifications() {

        List<String> notificationList =
                new ArrayList<>();

        String previousLastNotification =
                "";

        while (true) {

            List<WebElement> notifications =
                    driver.findElements(
                            AppiumBy.xpath(
                                    "//android.widget.ScrollView/android.view.View"));

            for (WebElement notification : notifications) {

                String content =
                        notification.getAttribute(
                                "content-desc");

                if (content != null
                        && !content.isBlank()
                        && !notificationList.contains(
                                content)) {

                    notificationList.add(
                            content);
                }
            }

            if (notificationList.isEmpty()) {

                break;
            }

            String currentLastNotification =
                    notificationList.get(
                            notificationList.size() - 1);

            if (currentLastNotification.equals(
                    previousLastNotification)) {

                break;
            }

            previousLastNotification =
                    currentLastNotification;

            scrollNotifications();

            try {

                Thread.sleep(
                        1500);

            }

            catch (InterruptedException e) {

                Thread.currentThread()
                        .interrupt();

                break;
            }
        }

        System.out.println(
                "Total Notifications : "
                        + notificationList.size());

        return notificationList;
    }

}