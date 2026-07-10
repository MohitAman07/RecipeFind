package pagesObjects.Signup;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleLoginPage {

    AndroidDriver driver;

    public GoogleLoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

   public boolean isEmailScreenDisplayed() {

    return !driver.findElements(
            AppiumBy.id("identifierId"))
            .isEmpty();
}

        public void enterEmail(String email) {

                WebDriverWait wait =
                        new WebDriverWait(driver, Duration.ofSeconds(30));

                WebElement emailField =
                        wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                        AppiumBy.id("identifierId")));

                emailField.click();

                emailField.clear();

                emailField.sendKeys(email);

                System.out.println("Email entered : " + email);
}

    public void clickEmailNext() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "//android.widget.Button[@text='Next']")))
                .click();
    }

    public void enterPassword(String password) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement passwordField =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.className(
                                        "android.widget.EditText")));

        passwordField.sendKeys(password);
        }

    public void clickPasswordNext() {

        driver.findElement(
                AppiumBy.xpath(
                        "(//android.widget.Button[@text='Next'])[2]"))
                .click();
    }

    public boolean isIAgreeDisplayed() {

        return driver.findElements(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"I agree\")"))
                .size() > 0;
    }

    public void clickIAgree() {

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"I agree\")"))
                .click();
    }
}