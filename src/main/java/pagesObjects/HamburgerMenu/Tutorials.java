package pagesObjects.HamburgerMenu;

import java.util.Map;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.WaitUtil;

public class Tutorials {

    private AndroidDriver driver;

    private WaitUtil waitUtil;

    public Tutorials(AndroidDriver driver) {

        this.driver = driver;

        this.waitUtil =
                new WaitUtil(
                        driver);
    }

    /*
     * Home
     */
    public boolean isHomeVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Home"))
                .isEmpty();
    }

    public void clickHome() {

        WebElement home =
                driver.findElement(
                        AppiumBy.accessibilityId(
                                "Home"));

        waitUtil.waitForElementVisible(
                home);

        waitUtil.clickWithWait(
                home);

        System.out.println(
                "Home selected from Tutorial menu.");
    }

    /*
     * Cookbook
     */
    public boolean isCookbookVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Cookbook"))
                .isEmpty();
    }

    public void clickCookbook() {

        WebElement cookbook =
                driver.findElement(
                        AppiumBy.accessibilityId(
                                "Cookbook"));

        waitUtil.waitForElementVisible(
                cookbook);

        waitUtil.clickWithWait(
                cookbook);

        System.out.println(
                "Cookbook selected from Tutorial menu.");
    }

    /*
     * Contribute
     */
    public boolean isContributeVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Contribute"))
                .isEmpty();
    }

    public void clickContribute() {

        WebElement contribute =
                driver.findElement(
                        AppiumBy.accessibilityId(
                                "Contribute"));

        waitUtil.waitForElementVisible(
                contribute);

        waitUtil.clickWithWait(
                contribute);

        System.out.println(
                "Contribute selected from Tutorial menu.");
    }

    /*
     * Profile
     */
    public boolean isProfileVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Profile"))
                .isEmpty();
    }

    public void clickProfile() {

        WebElement profile =
                driver.findElement(
                        AppiumBy.accessibilityId(
                                "Profile"));

        waitUtil.waitForElementVisible(
                profile);

        waitUtil.clickWithWait(
                profile);

        System.out.println(
                "Profile selected from Tutorial menu.");
    }

    /*
     * Engagement
     */
    public boolean isEngagementVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Engagement"))
                .isEmpty();
    }

    public void clickEngagement() {

        WebElement engagement =
                driver.findElement(
                        AppiumBy.accessibilityId(
                                "Engagement"));

        waitUtil.waitForElementVisible(
                engagement);

        waitUtil.clickWithWait(
                engagement);

        System.out.println(
                "Engagement selected from Tutorial menu.");
    }

    /*
     * Exports
     */
    public boolean isExportsVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Exports"))
                .isEmpty();
    }

    public void clickExports() {

        WebElement exports =
                driver.findElement(
                        AppiumBy.accessibilityId(
                                "Exports"));

        waitUtil.waitForElementVisible(
                exports);

        waitUtil.clickWithWait(
                exports);

        System.out.println(
                "Exports selected from Tutorial menu.");
    }


    /*
     * Swipe Tutorial Menu
     *
     * Used to make a Tutorial submenu
     * item visible.
     */
    public void swipeTutorialMenu(
            int swipeCount) {

        for (int i = 1;
                i <= swipeCount;
                i++) {

            driver.executeScript(
                    "mobile: swipeGesture",
                    Map.of(
                            "left", 100,
                            "top", 500,
                            "width", 500,
                            "height", 1500,
                            "direction", "up",
                            "percent", 0.60));

            System.out.println(
                    "Tutorial list swiped."
                            + " | Swipe : "
                            + i
                            + "/"
                            + swipeCount);
        }
    }

    /*
     * Swipe Selected Tutorial Screen
     *
     * Used after selecting a Tutorial
     * submenu item.
     */
    /*
 * Swipe Selected Tutorial Screen
 *
 * Performs a vertical screen swipe on the
 * selected Tutorial screen.
 */
/*
 * Swipe Selected Tutorial Screen
 *
 * Performs horizontal left swipes on the
 * selected Tutorial screen.
 */
public void swipeSelectedTutorialScreen(
        int swipeCount) {

    waitUtil.sleep(
            3000);

    for (int i = 1;
            i <= swipeCount;
            i++) {

        driver.executeScript(
                "mobile: swipeGesture",
                Map.of(
                        "left", 100,
                        "top", 500,
                        "width", 500,
                        "height", 500,
                        "direction", "left",
                        "percent", 0.60));

        System.out.println(
                "Selected Tutorial card swiped."
                        + " | Swipe : "
                        + i
                        + "/"
                        + swipeCount);

        waitUtil.sleep(
                500);
    }
}
}