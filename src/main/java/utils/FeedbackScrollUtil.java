package utils;

import org.openqa.selenium.JavascriptExecutor;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class FeedbackScrollUtil {

    private final AndroidDriver driver;

    public FeedbackScrollUtil(
            AndroidDriver driver) {

        this.driver = driver;
    }

    /*
     * ==========================================================
     * Small Scroll
     * ==========================================================
     */
    public void ScrollDown() {

        try {

            ((JavascriptExecutor) driver)
                    .executeScript(
                            "mobile: swipeGesture",
                            ImmutableMap.of(
                                    "left", 100,
                                    "top", 1100,
                                    "width", 850,
                                    "height", 900,
                                    "direction", "up",
                                    "percent", 0.18));

            Thread.sleep(800);

        } catch (Exception e) {

            System.out.println(
                    "Unable to scroll Feedback page : "
                            + e.getMessage());
        }
    }

    /*
     * ==========================================================
     * Small Scroll Multiple Times
     * ==========================================================
     */
    public void ScrollMore(
            int scrollTimes) {

        for (int i = 0; i < scrollTimes; i++) {

            ScrollDown();
        }
    }

    /*
     * ==========================================================
     * Scroll To Bottom
     * ==========================================================
     */
    public void ScrollToBottom() {

        try {

            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));

        } catch (Exception e) {

            System.out.println(
                    "Unable to scroll to bottom : "
                            + e.getMessage());
        }
    }

    /*
     * ==========================================================
     * Scroll To Top
     * ==========================================================
     */
    public void ScrollToTop() {

        try {

            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(10)"));

        } catch (Exception e) {

            System.out.println(
                    "Unable to scroll to top : "
                            + e.getMessage());
        }
    }

    /*
     * ==========================================================
     * Scroll Until Submit
     * ==========================================================
     */
    public void ScrollToSubmit() {

        ScrollToBottom();
    }

    /*
     * ==========================================================
     * Scroll Until Cancel
     * ==========================================================
     */
    public void ScrollToCancel() {

        ScrollToBottom();
    }
}