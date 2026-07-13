package utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class WaitUtil {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public WaitUtil(AndroidDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20));
    }

    public void clickWithWait(WebElement element) {

        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {

            try {

                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                element));

                element.click();

                return;

            } catch (Exception e) {

                attempts++;

                System.out.println(
                        "Click Attempt "
                                + attempts
                                + " Failed. Retrying...");

                sleep(5000);
            }
        }

        throw new RuntimeException(
                "Unable To Click Element After "
                        + maxAttempts
                        + " Attempts.");
    }

    public void sleep(long milliseconds) {

        try {

            Thread.sleep(milliseconds);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}