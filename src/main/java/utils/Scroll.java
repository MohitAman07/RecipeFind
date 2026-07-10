package utils;

import org.openqa.selenium.JavascriptExecutor;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class Scroll {

    private AndroidDriver driver;

    public Scroll(AndroidDriver driver) {

        this.driver = driver;
    }

    public void SwipeLeft() {

        ((JavascriptExecutor) driver)
                .executeScript(
                        "mobile: swipeGesture",
                        ImmutableMap.of(
                                "left", 400,
                                "top", 400,
                                "width", 550,
                                "height", 550,
                                "direction", "left",
                                "percent", 0.80));
    }

    public void ScrollDown() {

        ((JavascriptExecutor) driver)
                .executeScript(
                        "mobile: swipeGesture",
                        ImmutableMap.of(
                                "left", 100,
                                "top", 500,
                                "width", 800,
                                "height", 1000,
                                "direction", "up",
                                "percent", 0.40));
    }

    public void ScrollMore(
            int scrollTimes) {

        for (int i = 0;
             i < scrollTimes;
             i++) {

            ScrollDown();
        }
    }

    public void ScrollUp() {

        ((JavascriptExecutor) driver)
                .executeScript(
                        "mobile: swipeGesture",
                        ImmutableMap.of(
                                "left", 100,
                                "top", 500,
                                "width", 800,
                                "height", 1000,
                                "direction", "down",
                                "percent", 0.40));
    }
}