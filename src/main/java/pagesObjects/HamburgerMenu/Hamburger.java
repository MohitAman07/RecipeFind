package pagesObjects.HamburgerMenu;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Hamburger {

    private AndroidDriver driver;

    public Hamburger(AndroidDriver driver) {

        this.driver = driver;
    }

    /*
     * Hamburger Menu Button
     */
    public boolean isHamburgerMenuVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "Open navigation menu"))
                .isEmpty();
    }

    public void clickHamburgerMenu() {

        driver.findElement(
                AppiumBy.accessibilityId(
                        "Open navigation menu"))
                .click();

        System.out.println(
                "Hamburger menu clicked.");
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

        driver.findElement(
                AppiumBy.accessibilityId(
                        "Tutorial"))
                .click();

        System.out.println(
                "Tutorial clicked.");
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
    }

   


}