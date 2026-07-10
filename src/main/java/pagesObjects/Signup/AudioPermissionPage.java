package pagesObjects.Signup;
 
import java.time.Duration;
 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
 
public class AudioPermissionPage {
 
    AndroidDriver driver;
 
    public AudioPermissionPage(AndroidDriver driver) {
        this.driver = driver;
    }
 
    public boolean isDisplayed() {
 
    try {
 
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));
 
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.id(
                                "com.android.permissioncontroller:id/grant_dialog")));
 
        return true;
    }
    catch (Exception e) {
 
        return false;
    }
}
 
public void allowWhileUsingApp() {
 
    driver.findElement(
            AppiumBy.id(
                    "com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
            .click();
    }
}