package utils;
 
import java.time.Duration;
 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
 
public class ClickWithWait {
 
    private AndroidDriver driver;
 
    private WebDriverWait wait;
 
    public ClickWithWait() {
 
        this.driver =
                DriverFactory.getDriver();
 
        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20));
    }
 
    /*
     * Wait Until Element Is Clickable
     */
    public void clickWithWait(
            WebElement element) {
 
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
                        "Click attempt "
                                + attempts
                                + " failed. Retrying...");
 
                try {
 
                    Thread.sleep(2000);
 
                } catch (InterruptedException ie) {
 
                    Thread.currentThread().interrupt();
                }
            }
        }
 
        /*
         * JavaScript Fallback
         */
        try {
 
            System.out.println(
                    "Using JavaScript click...");
 
            ((JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].click();",
                            element);
 
        } catch (Exception e) {
 
            throw new RuntimeException(
                    "Unable to click element after retries.",
                    e);
        }
    }
 
    /*
     * Wait Until Visible
     */
    public WebElement waitForVisibility(
            WebElement element) {
 
        return wait.until(
                ExpectedConditions.visibilityOf(
                        element));
    }
 
    /*
     * Wait Until Clickable
     */
    public WebElement waitForClickable(
            WebElement element) {
 
        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        element));
    }
 
    /*
     * Wait Until Invisible
     */
    public boolean waitForInvisibility(
            WebElement element) {
 
        return wait.until(
                ExpectedConditions.invisibilityOf(
                        element));
    }
 
    /*
     * Static Wait
     */
    public void sleep(
            long milliseconds) {
 
        try {
 
            Thread.sleep(
                    milliseconds);
 
        } catch (InterruptedException e) {
 
            Thread.currentThread()
                    .interrupt();
        }
    }
}
 
