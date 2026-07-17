package pagesObjects.HamburgerMenu;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Sequence;

public class Hamburger {

    private AndroidDriver driver;

    public Hamburger(AndroidDriver driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

public void swipeOnTutorial() {

    try {

        WebElement tutorial = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("Tutorial")));

        Point location = tutorial.getLocation();
        Dimension size = tutorial.getSize();

        int startX = location.getX() + (size.getWidth() / 2);
        int startY = location.getY() + (size.getHeight() / 2);

        int endX = startX;
        int endY = startY - 150; // Small upward swipe

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), startX, startY));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(300),
                PointerInput.Origin.viewport(), endX, endY));

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));

        System.out.println("Keyboard hidden using swipe.");

    } catch (Exception e) {

        System.out.println("Keyboard already hidden.");
    }
}

public void hideKeyboardIfVisible() {

    try {

        swipeOnTutorial();

    } catch (Exception e) {

        System.out.println("Unable to hide keyboard.");
    }
}

        /*
        * Control Panel
        */
        @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Control Panel\"]")
        private WebElement control_panel;

        /*
        * Create Shopping List
        */
        @AndroidFindBy(xpath = "//android.view.View[@content-desc='Create Shopping List, Collapsed']")
        private WebElement createShoppingListCollapsed;

        @AndroidFindBy(xpath = "//android.view.View[@content-desc='Create Shopping List, Expanded']")
        private WebElement createShoppingListExpanded;

        /*
        * For Self
        */
        @AndroidFindBy(xpath = "//android.view.View[@content-desc='For Self']")
        private WebElement forSelf;

        /*
        * For Group
        */
        @AndroidFindBy(xpath = "//android.view.View[@content-desc='For Group']")
        private WebElement forGroup;

        /*
        * Group Management
        */
        @AndroidFindBy(accessibility = "Group Managements")
        private WebElement groupManagement;

    /*
     * Hamburger Menu Button
     */
    public boolean isHamburgerMenuVisible() {

    try {

        new WebDriverWait(driver, Duration.ofSeconds(110))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("Open navigation menu")));

        return true;

    } catch (Exception e) {

        return false;
    }
}

public void clickHamburgerMenu() {

    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.accessibilityId("Open navigation menu")));

    driver.findElement(
            AppiumBy.accessibilityId("Open navigation menu"))
            .click();

    System.out.println("Hamburger menu clicked.");
}
    /*
     * Tutorial
     */
    public boolean isTutorialVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Tutorial"))
                .isEmpty();
    }

public void clickTutorial() {

    hideKeyboardIfVisible();

    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.accessibilityId("Tutorial")));

    driver.findElement(
            AppiumBy.accessibilityId("Tutorial"))
            .click();

    System.out.println("Tutorial clicked.");
}

    /*
     * FAQs
     */
    public boolean isFAQsVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "FAQs"))
                .isEmpty();
    }

    public void clickFAQs() {

        hideKeyboardIfVisible();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("FAQs")));

        driver.findElement(
                AppiumBy.accessibilityId(
                        "FAQs"))
                .click();

        System.out.println(
                "FAQs clicked.");
    }

    /*
     * Glossary
     */
    public boolean isGlossaryVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Glossary"))
                .isEmpty();
    }

    public void clickGlossary() {

        hideKeyboardIfVisible();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("Glossary")));

        driver.findElement(
                AppiumBy.accessibilityId(
                        "Glossary"))
                .click();

        System.out.println(
                "Glossary clicked.");
    }

    /*
     * Feedback
     */
    public boolean isFeedbackVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Feedback"))
                .isEmpty();
    }

    public void clickFeedback() {

        hideKeyboardIfVisible();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("Feedback")));

        driver.findElement(
                AppiumBy.accessibilityId(
                        "Feedback"))
                .click();

        System.out.println(
                "Feedback clicked.");
    }

    /*
     * Share
     */
    public boolean isShareVisible() {


        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Share"))
                .isEmpty();
    }

    public void clickShare() {

        hideKeyboardIfVisible();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("Share")));

        driver.findElement(
                AppiumBy.accessibilityId(
                        "Share"))
                .click();

        System.out.println(
                "Share clicked.");
    }

    /*
     * Contact Us
     */
    public boolean isContactUsVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Contact Us"))
                .isEmpty();
    }

    public void clickContactUs() {

        hideKeyboardIfVisible();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("Contact Us")));

        driver.findElement(
                AppiumBy.accessibilityId(
                        "Contact Us"))
                .click();

        System.out.println(
                "Contact Us clicked.");
    }

        /*
    * Close Android Share Sheet
    */
        public void closeShareSheet() {

        try {

            String currentPackage =
                    driver.getCurrentPackage();

            System.out.println(
                    "Current Package : "
                            + currentPackage);

            if ("com.android.intentresolver"
                    .equals(currentPackage)) {

                driver.navigate().back();

                System.out.println(
                        "Share sheet closed successfully.");

                Thread.sleep(2000);
            }
        }
        catch (Exception e) {

            System.out.println(
                    "Unable to close share sheet : "
                            + e.getMessage());
        }
    }

    /*
     * Legal
     */
    public boolean isLegalVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Legal"))
                .isEmpty();
    }

public void clickLegal() {

    hideKeyboardIfVisible();

    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.accessibilityId("Legal")));

    driver.findElement(
            AppiumBy.accessibilityId(
                    "Legal"))
            .click();

    System.out.println(
            "Legal clicked.");
}

    /*
     * Sign Out
     * Small devices may require scrolling
     */
    public boolean isSignOutVisible() {

        if (!driver.findElements(
                AppiumBy.accessibilityId(
                        "Sign Out"))
                .isEmpty()) {

            return true;
        }

        scrollHamburgerMenu();

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Sign Out"))
                .isEmpty();
    }

public void clickSignOut() {

    hideKeyboardIfVisible();

    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.accessibilityId("Sign Out")));

    if (driver.findElements(
            AppiumBy.accessibilityId(
                    "Sign Out"))
            .isEmpty()) {

        scrollHamburgerMenu();
    }

    driver.findElement(
            AppiumBy.accessibilityId(
                    "Sign Out"))
            .click();

    System.out.println(
            "Sign Out clicked.");
}

    /*
     * Scroll Hamburger Menu
     */
    private void scrollHamburgerMenu() {

        hideKeyboardIfVisible();

        try {

            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable("
                                    + "new UiSelector().scrollable(true))"
                                    + ".scrollForward()"));

            System.out.println(
                    "Hamburger menu scrolled.");
        }
        catch (Exception e) {

            System.out.println(
                    "Unable to scroll hamburger menu.");
        }
    }


    /*
    * Back Button
    */
    public boolean isBackButtonVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Back"))
                .isEmpty();
    }

    public void clickBackButton() {

    driver.findElement(
            AppiumBy.accessibilityId(
                    "Back"))
            .click();

    System.out.println(
            "Back button clicked.");

    try {

        Thread.sleep(2000);

    } catch (InterruptedException e) {

        Thread.currentThread().interrupt();
    }
}

    /*
    control pannel 
    */

    public boolean isControlPanelVisible() 
    {

        return control_panel.isDisplayed();
    }

        public void clickControlPanel() {

    hideKeyboardIfVisible();

    new WebDriverWait(driver, Duration.ofSeconds(20))
            .until(ExpectedConditions.visibilityOf(
                    control_panel));

    control_panel.click();

    System.out.println(
            "Control Panel clicked.");
}

         /*
        * Create Shopping List - Collapsed
        */
        public boolean isCreateShoppingListCollapsedVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Create Shopping List, Collapsed']"))
                .isEmpty();
        }

        /*
        * Create Shopping List - Expanded
        */
        public boolean isCreateShoppingListExpandedVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Create Shopping List, Expanded']"))
                .isEmpty();
        }

        /*
 * Expand Create Shopping List
 */
public void expandCreateShoppingList() {

    hideKeyboardIfVisible();

    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(
                    createShoppingListCollapsed));

    createShoppingListCollapsed.click();

    System.out.println(
            "Create Shopping List expanded.");
}

/*
 * Collapse Create Shopping List
 */
public void collapseCreateShoppingList() {

    hideKeyboardIfVisible();

    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(
                    createShoppingListExpanded));

    createShoppingListExpanded.click();

    System.out.println(
            "Create Shopping List collapsed.");
}
        /*
        * For Self
        */
        public boolean isForSelfVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='For Self']"))
                .isEmpty();
        }

    public void clickForSelf() {

    hideKeyboardIfVisible();

    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(
                    forSelf));

    forSelf.click();

    System.out.println(
            "For Self clicked.");
}

        /*
        * For Group
        */
        public boolean isForGroupVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='For Group']"))
                .isEmpty();
        }

        public void clickForGroup() {

        hideKeyboardIfVisible();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        forGroup));

        forGroup.click();

        System.out.println(
                "For Group clicked.");
        }

/*
 * Group Management
 */
        public boolean isGroupManagementVisible() {

        return groupManagement.isDisplayed();
        }

        public void clickGroupManagement() {
                
        hideKeyboardIfVisible();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        groupManagement));

        groupManagement.click();

        System.out.println(
                "Group Management clicked.");
        }


     /*
     * Check if Hamburger Menu is Open
     */
    public boolean isHamburgerMenuOpen() {

    return !driver.findElements(
            AppiumBy.accessibilityId(
                    "Tutorial"))
            .isEmpty();
}

        /*
        * Close Hamburger Menu
        */
        public void closeHamburgerMenu() {

        if (isHamburgerMenuOpen()) {

                driver.pressKey(
                        new KeyEvent(
                                AndroidKey.BACK));

                System.out.println(
                        "Hamburger menu closed.");
        }
}

}