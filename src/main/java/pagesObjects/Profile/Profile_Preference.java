package pagesObjects.Profile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile_Preference {

    private AndroidDriver driver;

    public Profile_Preference(
        AndroidDriver driver) {

    this.driver = driver;

    PageFactory.initElements(
            new AppiumFieldDecorator(driver),
            this);
}



     @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Profile\n" + "Tab 4 of 4\"]")
    public WebElement Profile_Page;

    @AndroidBy(xpath = "//android.widget.Button[@index='5']")
    public WebElement Dietary_preference;

    @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    public WebElement Dietary_Page;

    @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.view.View[1]")
    public WebElement Age_Specific;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"     Elderly (Soft Diet)\"]")
    public WebElement Elderly_softDiet;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Allergen-Specific\"]")
    public WebElement Allergen_Specific;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"     Celery Allergy\"]")
    public WebElement Celery_Allergy;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Back\"]")
    public WebElement Back_Button;

    @AndroidBy(xpath = "(//android.widget.Button[@content-desc=\"Delete\"])[1]")
    public WebElement Delete_Dietary_preference;


    @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button[2]")
    public WebElement Religion_Filter;

    @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.view.View[1]")
    public WebElement Baha_Faith;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"     Birth of Bahaullah\"]")
    public WebElement Birth_of_Bahaullah;

    @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.view.View[4]")
    public WebElement Hinduism;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"     Diwali\"]")
    public WebElement Diwali;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"     Navratri\"]")
    public WebElement Navratri;

    @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button[3]")
    public WebElement Allergies;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Crustacean\"]")
    public WebElement Crustacean;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Eggs\"]")
    public WebElement Eggs;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Fish\"]")
    public WebElement Fish;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Milk\"]")
    public WebElement Milk;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Peanuts\"]")
    public WebElement Peanuts;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Sesame\"]")
    public WebElement Sesame;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Shellfish\"]")
    public WebElement Shellfish;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Soybeans\"]")
    public WebElement Soybeans;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Tree Nuts\"]")
    public WebElement Tree_Nuts;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Wheat\"]")
    public WebElement Wheat;

    @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button[4]")
    public WebElement Custom_Include;

    @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
    public WebElement Enter_Include;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Save\"]")
    public WebElement Save_Include;

    @AndroidBy(xpath = "//android.widget.Button[@content-desc=\"Cancel\"]")
    public WebElement Cancel_Include;

    @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button[5]")
    public WebElement Custom_Exclude;

    @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
    public WebElement Enter_Exclusion;


    
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
    


    public void Click_Profile_Tab(){
        Assert.assertTrue(Profile_Page.isDisplayed(), "Search button is not visible");
        clickWithWait(Profile_Page);
    }

    public void Click_Dietary_Preferences(){
        Assert.assertTrue(Dietary_preference.isDisplayed(), "Search button is not visible");
        clickWithWait(Dietary_preference);
        Assert.assertTrue(Dietary_Page.isDisplayed(), "Search button is not visible");
    }

    public void Select_Age_specific(){
        Assert.assertTrue(Age_Specific.isDisplayed(), "Search button is not visible");
        clickWithWait(Age_Specific);
    }
    public void Select_ElderlySoftDiet(){
        Assert.assertTrue(Elderly_softDiet.isDisplayed(), "Search button is not visible");
        clickWithWait(Elderly_softDiet);
    }
    public void Select_AllergenSpecific(){
        Assert.assertTrue(Allergen_Specific.isDisplayed(), "Search button is not visible");
        clickWithWait(Allergen_Specific);
    }
    public void Select_Celery_Allergy(){
        Assert.assertTrue(Celery_Allergy.isDisplayed(), "Search button is not visible");
        clickWithWait(Celery_Allergy);
    }
    public void Click_Back_Button(){
        Assert.assertTrue(Back_Button.isDisplayed(), "Search button is not visible");
        clickWithWait(Back_Button);
    }
    public void Delete_Dietary_preference(){
        Assert.assertTrue(Delete_Dietary_preference.isDisplayed(), "Search button is not visible");
        clickWithWait(Delete_Dietary_preference);
    }
    public void Click_Religion_Filter(){
        Assert.assertTrue(Religion_Filter.isDisplayed(), "Search button is not visible");
        clickWithWait(Religion_Filter);
    }

    public void Click_Baha_Religion(){
        Assert.assertTrue(Baha_Faith.isDisplayed(), "Search button is not visible");
        clickWithWait(Baha_Faith);
    }
    public void Click_Birth_of_Bahaullah(){
        Assert.assertTrue(Birth_of_Bahaullah.isDisplayed(), "Search button is not visible");
        clickWithWait(Birth_of_Bahaullah);
    }
    public void Click_Hinduism(){
        Assert.assertTrue(Hinduism.isDisplayed(), "Search button is not visible");
        clickWithWait(Hinduism);
    }
    public void Click_Diwali(){
        Assert.assertTrue(Diwali.isDisplayed(), "Search button is not visible");
        clickWithWait(Diwali);
    }
    public void Click_Navratri(){
        Assert.assertTrue(Navratri.isDisplayed(), "Search button is not visible");
        clickWithWait(Navratri);
    }

    public void Click_Allergies(){
        clickWithWait(Allergies);
    }
    public void Click_Eggs(){
        clickWithWait(Eggs);
    }
    public void Click_Custom_Include(){
        clickWithWait(Custom_Include);
        clickWithWait(Enter_Include);

    }
    public void Enter_Include(String ingredient){
        Enter_Include.sendKeys(ingredient);

    }
    public void Click_Save(){
        clickWithWait(Save_Include);
    }
    public void Click_Cancel(){
        clickWithWait(Cancel_Include);
    }
    public void Click_Custom_Exclusion(){
        clickWithWait(Custom_Exclude);
        clickWithWait(Enter_Exclusion);
    }
    public void Enter_exclude(String Ingredient){
        Enter_Exclusion.sendKeys(Ingredient);
    }
}
