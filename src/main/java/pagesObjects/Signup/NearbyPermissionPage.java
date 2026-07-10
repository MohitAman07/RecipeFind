package pagesObjects.Signup;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class NearbyPermissionPage {

    AndroidDriver driver;

    public NearbyPermissionPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayed() {

    try {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.id(
                                "com.android.permissioncontroller:id/permission_allow_button")));

        return true;
    }
    catch (Exception e) {

        return false;
    }
}

public void allow() {

    driver.findElement(
            AppiumBy.id(
                    "com.android.permissioncontroller:id/permission_allow_button"))
            .click();
    }
}