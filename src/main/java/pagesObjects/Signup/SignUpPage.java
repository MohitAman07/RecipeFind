package pagesObjects.Signup;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public SignUpPage(AndroidDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(30));
    }

    /*
     * Verify Sign Up Screen
     */
        public boolean isSignUpDisplayed() {

        try {

                WebDriverWait wait =
                        new WebDriverWait(driver, Duration.ofSeconds(30));

                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.accessibilityId(
                                        "Continue with Google")));

                return true;
        }
        catch (Exception e) {

                return false;
        }
        }

    /*
     * Click Continue With Google
     */
    public void clickContinueWithGoogle() {

        System.out.println(
                "Attempting to click Continue with Google.");

        WebElement googleButton =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.accessibilityId(
                                        "Continue with Google")));

        googleButton.click();

        System.out.println(
                "Continue with Google clicked successfully.");
    }

    /*
     * Click Continue With Facebook
     */
    public void clickContinueWithFacebook() {

        System.out.println(
                "Attempting to click Continue with Facebook.");

        WebElement facebookButton =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.accessibilityId(
                                        "Continue with Facebook")));

        facebookButton.click();

        System.out.println(
                "Continue with Facebook clicked successfully.");
    }

    /*
     * Verify Google Button Displayed
     */
    public boolean isGoogleButtonDisplayed() {

        return driver.findElements(
                AppiumBy.accessibilityId(
                        "Continue with Google"))
                .size() > 0;
    }

    /*
     * Verify Facebook Button Displayed
     */
    public boolean isFacebookButtonDisplayed() {

        return driver.findElements(
                AppiumBy.accessibilityId(
                        "Continue with Facebook"))
                .size() > 0;
    }
}