package pagesObjects.HamburgerMenu;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.TapByCoordinates;

public class Feedback {
    
    private AndroidDriver driver;

    public Feedback(AndroidDriver driver) {

        this.driver = driver;
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Open navigation menu\"]")
    public WebElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Feedback\"]")
    public WebElement Feedback;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Amazing\"]")
    public WebElement Emoji;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Terrible\"]")
    public WebElement Emoji2;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Submit\"]")
    public WebElement Submit;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Cancel\"]")
    public WebElement Cancel;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"How much will you rate your experience with RecipeFind app?\n" +
            "Please select a rating\"]")
    public WebElement Error;
    //@AndroidFindBy(xpath = "")

    private void clickWithWait(
        WebElement element) {

    WebDriverWait wait =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10));

    wait.until(
            ExpectedConditions.visibilityOf(
                    element));

    wait.until(
            ExpectedConditions.elementToBeClickable(
                    element));

    element.click();
}


    public void OpenHamburgerMenu() {
        clickWithWait(hamburgerMenu);
    }

    public void OpenFeedbackPage() {
        clickWithWait(Feedback);
    }

    public void selectEmoji() {
        clickWithWait(Emoji);
    }

    public void SelectEmoji02(){
        clickWithWait(Emoji2);
    }

    public void enter_field01(String text){
        WebElement elementToTap = driver.findElement(By.xpath("//android.widget.EditText[@index='2']"));
        Assert.assertTrue(elementToTap.isDisplayed(), "Element to tap by coordinates is not visible");
        new TapByCoordinates(driver).tapElementAt(elementToTap, 0.12, 0.37);
        elementToTap.click();
        elementToTap.sendKeys(text);
    }
    public void enter_field02(String text){
        WebElement elementToTap = driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
        Assert.assertTrue(elementToTap.isDisplayed(), "Element to tap by coordinates is not visible");
        new TapByCoordinates(driver).tapElementAt(elementToTap, 0.25, 0.58);
        elementToTap.click();
        elementToTap.sendKeys(text);
    }
    public void enter_field03(String text){
        WebElement elementToTap = driver.findElement(By.xpath("//android.widget.EditText[@index='4']"));
        Assert.assertTrue(elementToTap.isDisplayed(), "Element to tap by coordinates is not visible");
        new TapByCoordinates(driver).tapElementAt(elementToTap, 0.25, 0.70);
        elementToTap.click();
        elementToTap.sendKeys(text);
    }
    public void clickSubmit() {
        clickWithWait(Submit);
    }
    public void clickCancel() {
        clickWithWait(Cancel);
    }

    public boolean FieldIsRequiredErrorVisible() {

        return Error.isDisplayed();
    }

    public String getError_This_field_is_required() {

        return Error.getText();
    }
}
