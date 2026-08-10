package pagesObjects.Profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.TapByCoordinates;
import utils.WaitUtil;
import org.testng.Assert;

public class Following_Tab {

    private final AndroidDriver driver;
    private final WaitUtil waitUtil;

    // ======================== Constructor ======================== //

    public Following_Tab(AndroidDriver driver) {

        this.driver = driver;

        this.waitUtil = new WaitUtil(driver);

        PageFactory.initElements(
                new AppiumFieldDecorator(driver),
                this
        );
    }

    // ======================== Locators ======================== //

    @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
    private WebElement Profile_Tab;
    //android.view.View[@index='3']

    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private WebElement Following_Tab;

    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    private WebElement follow_button;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"You are following 1 people\"]")
    private WebElement Verify_Following_count_1;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Quick E.\r\n"
            + "Cranbury library\r\n"
            + "101\r\n"
            + "Recipes\r\n"
            + "2\r\n"
            + "Followers\"]")
    private WebElement Open_profile;


    // ======================== Profile Tab ======================== //

    /**
     * Click on Profile tab
     */
    public void Click_Profile_Tab() {

          Assert.assertTrue(
                Profile_Tab.isDisplayed(),
                "For Self option is not displayed.");

        waitUtil.clickWithWait(
                 Profile_Tab);

        System.out.println(
                "profile tab clicked.");
    }


    // ======================== Following Tab ======================== //

    /**
     * Click on Following tab
     */
    
public void Click_Following_Tab() {
        WebElement elementToTap = driver.findElement(By.xpath("//android.view.View[@index='3']"));
        Assert.assertTrue(elementToTap.isDisplayed(), "Element to tap by coordinates is not visible");
        new TapByCoordinates(driver).tapElementAt(elementToTap, 0.98, 0.45);
    }


    // ======================== Follow Button ======================== //

    /**
     * Click on Follow button
     */
    public void Click_Follow_Button() {

          Assert.assertTrue(
                follow_button.isDisplayed(),
                "For follow button is not displayed.");

        waitUtil.clickWithWait(
                 follow_button);

        System.out.println(
                "Follow Button clicked.");

       
    }


    // ======================== Verify Following Count ======================== //

    /**
     * Verify that following count is 1
     */
    public void Verify_Following_count() {

         Assert.assertTrue(
         Verify_Following_count_1.isDisplayed(),
                "For Self option is not displayed.");

       
        System.out.println(
                "Follow Button clicked.");
        }

    // ======================== Open Profile ======================== //

    /**
     * Open Quick E. profile
     */
    public void Open_Profile() {

        Assert.assertTrue(
         Open_profile.isDisplayed(),
                "profile is not displayed.");

        waitUtil.clickWithWait(
                  Open_profile);

        System.out.println(
                "profile is clicked.");

      
    }


    /**
     * Open profile using dynamic profile content description
     *
     * Example:
     * Open_Profile("Quick E.", "Cranbury library", "101", "2");
     */
    public void Open_Profile(
            String userName,
            String profileName,
            String recipeCount,
            String followerCount) {

        String contentDescription =
                userName + "\r\n"
                + profileName + "\r\n"
                + recipeCount + "\r\n"
                + "Recipes\r\n"
                + followerCount + "\r\n"
                + "Followers";

        String xpath =
                "//android.widget.ImageView[@content-desc=\""
                + contentDescription
                + "\"]";

        WebElement profile = driver.findElement(
                By.xpath(xpath)
        );
    }
}



    

    







    

