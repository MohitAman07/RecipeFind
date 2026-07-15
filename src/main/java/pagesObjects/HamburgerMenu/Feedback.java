package pagesObjects.HamburgerMenu;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import utils.FeedbackScrollUtil;
import utils.TapByCoordinates;
import utils.WaitUtil;

public class Feedback {

    private AndroidDriver driver;
    private WaitUtil waitUtil;
    private FeedbackScrollUtil scroll;

    public Feedback(AndroidDriver driver) {

        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
        this.scroll = new FeedbackScrollUtil(driver);


        PageFactory.initElements(
                new AppiumFieldDecorator(driver),
                this);
    }




    /*
    * Feedback Page Title
    */
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"How much will you rate your experience with RecipeFind app?\"]")
    public WebElement FeedbackPageTitle;

    /*
     * Rating Emojis
     */

    // Emoji 5 - Amazing
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Amazing\"]")
    public WebElement Emoji5;

    // Emoji 1 - Terrible
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Terrible\"]")
    public WebElement Emoji1;

    // Emoji 2
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"How much will you rate your experience with RecipeFind app?\"]/android.view.View[2]")
    public WebElement Emoji2;

    // Emoji 3
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"How much will you rate your experience with RecipeFind app?\"]/android.view.View[3]")
    public WebElement Emoji3;

    // Emoji 4
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"How much will you rate your experience with RecipeFind app?\"]/android.view.View[4]")
    public WebElement Emoji4;

    /*
    * Validation Message - Please select a rating
    */
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"How much will you rate your experience with RecipeFind app?\nPlease select a rating\"]")
    public WebElement SelectRatingValidation;

    /*
     * Buttons
     */

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Submit\"]")
    public WebElement Submit;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Cancel\"]")
    public WebElement Cancel;

    /*
    * What did you like most in the app?
    */
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='What did you like most in the app?\nWrite your message here']")
    public WebElement LikeMostField;

    /*
    * How likely did you recommend the app to other?
    */
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
    public WebElement RecommendAppField;

    /*
    * What can we do to improve?
    */
   @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[3]")
    public WebElement ImprovementField;

    /*
     * Validation Message
     */

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"How much will you rate your experience with RecipeFind app?\nPlease select a rating\"]")
    public WebElement Error;

    /*
     * Common Click Method
     */

    private void clickWithWait(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    // /*
    //  * Emoji Selection
    //  */

    // public void selectEmoji1() {
    //     clickWithWait(Emoji1);
    // }

    // public void selectEmoji2() {
    //     clickWithWait(Emoji2);
    // }

    // public void selectEmoji3() {
    //     clickWithWait(Emoji3);
    // }

    // public void selectEmoji4() {
    //     clickWithWait(Emoji4);
    // }

    // public void selectEmoji5() {
    //     clickWithWait(Emoji5);
    // }

    // Generic Method 
    public void selectEmoji(int emojiNumber) {

        switch (emojiNumber) {
            case 1:
                clickWithWait(Emoji1);
                break;

            case 2:
                clickWithWait(Emoji2);
                break;

            case 3:
                clickWithWait(Emoji3);
                break;

            case 4:
                clickWithWait(Emoji4);
                break;

            case 5:
                clickWithWait(Emoji5);
                break;

            default:
                throw new IllegalArgumentException("Invalid emoji number. Please select a value between 1 and 5.");
        }
    }

    /*
     * Feedback Fields
     */

    public void enter_field01(String text) {

        WebElement elementToTap = driver.findElement(
                By.xpath("//android.widget.EditText[@index='2']"));

        Assert.assertTrue(elementToTap.isDisplayed(),
                "Element to tap by coordinates is not visible");

        new TapByCoordinates(driver)
                .tapElementAt(elementToTap, 0.12, 0.37);

        elementToTap.click();
        elementToTap.sendKeys(text);
    }

    public void enter_field02(String text) {

        WebElement elementToTap = driver.findElement(
                By.xpath("//android.widget.EditText[@index='3']"));

        Assert.assertTrue(elementToTap.isDisplayed(),
                "Element to tap by coordinates is not visible");

        new TapByCoordinates(driver)
                .tapElementAt(elementToTap, 0.25, 0.58);

        elementToTap.click();
        elementToTap.sendKeys(text);
    }

    public void enter_field03(String text) {

        WebElement elementToTap = driver.findElement(
                By.xpath("//android.widget.EditText[@index='4']"));

        Assert.assertTrue(elementToTap.isDisplayed(),
                "Element to tap by coordinates is not visible");

        new TapByCoordinates(driver)
                .tapElementAt(elementToTap, 0.25, 0.70);

        elementToTap.click();
        elementToTap.sendKeys(text);
    }

// public void scrollUntilVisible(WebElement element) {

//     int maxScrolls = 8;

//     while (maxScrolls-- > 0) {

//         try {

//             if (element.isDisplayed()) {
//                 return;
//             }

//         } catch (Exception ignored) {
//         }

//         scroll.ScrollDown();
//     }

//     throw new RuntimeException(
//             "Unable to locate element after scrolling.");
// }

/*
 * Click Submit
 */
public void clickSubmit() {

    scroll.ScrollToBottom();

    waitUtil.clickWithWait(
            Submit);
}

/*
 * Click Cancel
 */
public void clickCancel() {

    scroll.ScrollToBottom();

    waitUtil.clickWithWait(
            Cancel);
}
    /*
     * Validation
     */

    public boolean FieldIsRequiredErrorVisible() {
        return Error.isDisplayed();
    }

    public String getError_This_field_is_required() {
        return Error.getText();
    }

    /*
    * Verify Feedback Page is displayed
    */
    public boolean isFeedbackPageVisible() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOf(FeedbackPageTitle));
            return FeedbackPageTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /*
    * Verify "What did you like most" field is displayed
    */
    public boolean isLikeMostFieldVisible() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOf(LikeMostField));
            return LikeMostField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /*
    * Enter text in "What did you like most" field
    */
    public void enterLikeMost(String text) {

    clickWithWait(LikeMostField);

    LikeMostField.clear();

    LikeMostField.sendKeys(text);

    try {

        driver.hideKeyboard();

    } catch (Exception e) {

            try {

                driver.navigate().back();

            } catch (Exception ignored) {
            }
        }
    }

    /*
    * Get text from "What did you like most" field
    */
    public String getLikeMostText() {
        return LikeMostField.getText();
    }

    /*
    * Verify "Recommend App" field is displayed
    */
    public boolean isRecommendAppFieldVisible() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOf(RecommendAppField));
            return RecommendAppField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /*
    * Enter text in "Recommend App" field
    */
    public void enterRecommendApp(String text) {

    clickWithWait(RecommendAppField);

    RecommendAppField.clear();

    RecommendAppField.sendKeys(text);

    try {

        driver.hideKeyboard();

    } catch (Exception e) {

        driver.navigate().back();
    }
}
    /*
    * Get text from "Recommend App" field
    */
    public String getRecommendAppText() {
        return RecommendAppField.getText();
    }

    /*
    * Verify "What can we do to improve?" field is displayed
    */
    public boolean isImprovementFieldVisible() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOf(ImprovementField));
            return ImprovementField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /*
    * Enter text in "What can we do to improve?" field
    */
    public void enterImprovement(String text) {

    clickWithWait(ImprovementField);

    ImprovementField.clear();

    ImprovementField.sendKeys(text);

    try {

        driver.hideKeyboard();

    } catch (Exception e) {

        driver.navigate().back();
    }
}

    /*
    * Get text from "What can we do to improve?" field
    */
    public String getImprovementText() {
        return ImprovementField.getText();
    }

    /*
    * Verify "Please select a rating" validation is displayed
    */
    public boolean isSelectRatingValidationVisible() {

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(SelectRatingValidation));

            return SelectRatingValidation.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /*
    * Get "Please select a rating" validation message
    */
    /*
 * Get "Please select a rating" validation text
 */
    public String getSelectRatingValidationText() {

        String contentDesc = SelectRatingValidation.getAttribute("contentDescription");

        if (contentDesc.contains("\n")) {

            return contentDesc.split("\n")[1].trim();
        }

        return contentDesc.trim();
    }
}