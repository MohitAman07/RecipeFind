package pagesObjects.Signup;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleAccountPage {

    private AndroidDriver driver;

    public GoogleAccountPage(AndroidDriver driver) {
        this.driver = driver;
    }

    /*
     * Verify Choose Account Screen
     */
    public boolean isDisplayed() {

    try {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(driver -> {

            List<WebElement> accounts =
                    driver.findElements(
                            AppiumBy.id(
                                    "com.google.android.gms:id/container"));

            System.out.println(
                    "Google containers found : "
                            + accounts.size());

            return accounts.size() > 0;
        });

        return true;
    }
    catch (Exception e) {

        return false;
    }
}

    /*
     * Select First Available Account
     */
    public void selectExistingAccount() {

        List<WebElement> accounts =
                driver.findElements(
                        AppiumBy.id(
                                "com.google.android.gms:id/container"));

        if (!accounts.isEmpty()) {

            accounts.get(0).click();

            System.out.println(
                    "Existing account selected.");
        }
    }

    /*
     * Select Configured Account
     */
   public boolean selectConfiguredAccount(String email) {

    try {

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"" + email + "\")"))
                .click();

        return true;
    }
    catch (Exception e) {

        return false;
    }
}

    /*
     * Click Add Another Account
     */
    public void clickAddAnotherAccount() {

                List<WebElement> accounts =
                        driver.findElements(
                                AppiumBy.id(
                                        "com.google.android.gms:id/container"));

                System.out.println(
                        "Google containers found : "
                                + accounts.size());

                /*
                * Second container = Add another account
                */
                if (accounts.size() >= 2) {

                        accounts.get(1).click();

                        System.out.println(
                                "Add another account clicked.");
                }
                else {

                        throw new RuntimeException(
                                "Add another account container not found.");
                }
                }

    public boolean waitForChooseAccountScreen() {

    try {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(driver -> {

            List<WebElement> accounts =
                    driver.findElements(
                            AppiumBy.id(
                                    "com.google.android.gms:id/container"));

            return accounts.size() > 0;
        });

        return true;
    }
    catch (Exception e) {

        return false;
    }
}
}