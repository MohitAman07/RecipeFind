package pagesObjects.Profile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Profile_Ingredients {

    private AndroidDriver driver;

    public Profile_Ingredients(AndroidDriver driver) {

        this.driver = driver;

        PageFactory.initElements(
                new AppiumFieldDecorator(driver),
                this);
    }

    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Ingredients\n"
                    + "Tab 2 of 3\"]")
    public WebElement Ingredient_Tab;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"alcohol\"]")
    public WebElement Alcohol;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"carbohydrate\"]")
    public WebElement Carbohydrate;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Exclusion\"]")
    public WebElement Click_Exclusion;

    /*
     * Click Ingredients Tab
     */
    public void clickIngredientsTab() {

        Ingredient_Tab.click();

        System.out.println(
                "Ingredients tab clicked.");
    }

    /*
     * Click Alcohol
     */
    public void clickAlcohol() {

        Alcohol.click();

        System.out.println(
                "Alcohol clicked.");
    }

    /*
     * Click Carbohydrate
     */
    public void clickCarbohydrate() {

        Carbohydrate.click();

        System.out.println(
                "Carbohydrate clicked.");
    }

    /*
     * Click Exclusion
     */
    public void clickExclusion() {

        Click_Exclusion.click();

        System.out.println(
                "Exclusion clicked.");
    }
}