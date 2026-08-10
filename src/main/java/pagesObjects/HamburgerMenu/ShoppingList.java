package pagesObjects.HamburgerMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.WaitUtil;

public class ShoppingList {

    private AndroidDriver driver;
    private WaitUtil waitUtil;

    public ShoppingList(AndroidDriver driver) {

        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);

        PageFactory.initElements(
                new AppiumFieldDecorator(driver),
                this);
    }

    /*
     * Create Shopping List
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Create Shopping List, Collapsed']")
    private WebElement createShoppingList;

    /*
     * For Self
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='For Self']")
    private WebElement createListForSelf;

    /*
     * For Group
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='For Group']")
    private WebElement createListForGroup;

    /*
     * AI Suggestions
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='AI Suggestions']")
    private WebElement aiSuggestionsDropdown;

    /*
     * Community
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Community']")
    private WebElement communityDropdown;

    /*
     * Next Button
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Next']")
    private WebElement nextButton;

    /*
     * Unit Dropdown
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Metric']")
    private WebElement unitDropdown;

    /*
     * Order For Field
     */
    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement orderForField;

    /*
     * Export Button
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Export']")
    private WebElement exportButton;

    /*
     * Drive
     */
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.android.intentresolver:id/suggested_apps_container']/android.widget.LinearLayout[2]")
    private WebElement selectDrive;

    /*
     * Upload File
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.google.android.apps.docs:id/save_button']")
    private WebElement uploadFile;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Back\"]")
    private WebElement BackButton;

   @AndroidFindBy(xpath = "//android.view.View[@content-desc='For Group']")
    private WebElement forGroup;

     @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mohit recipes insights 2\"]")
    private WebElement SelectGroup;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mohit Aman, Collapsed\"]")
    private WebElement Contributor_01;

     @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Normaluser2 noadmin privilage, Collapsed\"]")
    private WebElement Contributor_02;

     @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"sona Naroliya, Collapsed\"]")
    private WebElement Contributor_03;




    public void clickForGroup() {
        forGroup.click();
    }

    /**
     * Select Group Name
     * Example:
     * selectGroupName("Mohit recipes insights 2");
     */
//    public void selectGroupName(String groupName) {

//     String xpath =
//             "//android.view.View[contains(@content-desc,'"
//                     + groupName
//                     + "')]";

//     driver.findElement(By.xpath(xpath)).click();
// }

    /**
     * Expand Contributor if required
     */
    public void expandContributor(String contributorName) {

        String xpath =
                "//android.view.View[contains(@content-desc,'"
                        + contributorName
                        + "']";

        driver.findElement(By.xpath(xpath)).click();
    }

    /**
     * Select Recipe Under Contributor
     * Example:
     * selectRecipe("Paneer Butter Masala");
     * 
     /*
     * Dynamic Recipe
     */
    private WebElement recipe(String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='"
                                + recipeName
                                + "']"));
    }

    /*
     * Dynamic Unit
     */
    private WebElement unit(String unitName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='"
                                + unitName
                                + "']"));
    }

    /*
     * Dynamic Export Type
     */
    private WebElement exportType(String fileType) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='"
                                + fileType
                                + "']"));
    }

    /*
     * Create Shopping List
     */
    public void clickCreateShoppingList() {

        Assert.assertTrue(
                createShoppingList.isDisplayed(),
                "Create Shopping List is not displayed.");

        waitUtil.clickWithWait(
                createShoppingList);

        System.out.println(
                "Create Shopping List clicked.");
    }

    /*
     * Select For Self
     */
    public void selectForSelf() {

        Assert.assertTrue(
                createListForSelf.isDisplayed(),
                "For Self option is not displayed.");

        waitUtil.clickWithWait(
                createListForSelf);

        System.out.println(
                "For Self selected.");
    }

    /*
     * Select For Group
     */
    public void selectForGroup() {

        Assert.assertTrue(
                createListForGroup.isDisplayed(),
                "For Group option is not displayed.");

        waitUtil.clickWithWait(
                createListForGroup);

        System.out.println(
                "For Group selected.");
    }

    /*
     * Expand AI Suggestions
     */
    public void clickAISuggestionsDropdown() {

        Assert.assertTrue(
                aiSuggestionsDropdown.isDisplayed(),
                "AI Suggestions dropdown is not displayed.");

        waitUtil.clickWithWait(
                aiSuggestionsDropdown);

        System.out.println(
                "AI Suggestions expanded.");
    }

    /*
     * Expand Community
     */
    public void clickCommunityDropdown() {

        Assert.assertTrue(
                communityDropdown.isDisplayed(),
                "Community dropdown is not displayed.");

        waitUtil.clickWithWait(
                communityDropdown);

        System.out.println(
                "Community expanded.");
    }

    /*
     * Select Recipe
     */
    public void selectRecipe(
            String recipeName) {

        WebElement recipeElement =
                recipe(recipeName);

        Assert.assertTrue(
                recipeElement.isDisplayed(),
                recipeName + " recipe is not displayed.");

        waitUtil.clickWithWait(
                recipeElement);

        System.out.println(
                "Recipe selected : "
                        + recipeName);
    }

    /*
     * Click Next
     */
    public void clickNextButton() {

        Assert.assertTrue(
                nextButton.isDisplayed(),
                "Next button is not displayed.");

        waitUtil.clickWithWait(
                nextButton);

        System.out.println(
                "Next button clicked.");
    }

    /*
     * Select Unit
     */
    public void selectUnit(
            String unitName) {

        Assert.assertTrue(
                unitDropdown.isDisplayed(),
                "Unit dropdown is not displayed.");

        waitUtil.clickWithWait(
                unitDropdown);

        WebElement unitElement =
                unit(unitName);

        Assert.assertTrue(
                unitElement.isDisplayed(),
                unitName + " unit is not displayed.");

        waitUtil.clickWithWait(
                unitElement);

        System.out.println(
                "Unit selected : "
                        + unitName);
    }

    /*
     * Enter Order Quantity
     */
    public void enterOrderFor(
            String quantity) {

        Assert.assertTrue(
                orderForField.isDisplayed(),
                "Order For field is not displayed.");

        waitUtil.clickWithWait(
                orderForField);

        orderForField.clear();

        orderForField.sendKeys(
                quantity);

        System.out.println(
                "Order quantity entered : "
                        + quantity);
    }

    /*
     * Click Export
     */
    public void clickExportButton() {

        Assert.assertTrue(
                exportButton.isDisplayed(),
                "Export button is not displayed.");

        waitUtil.clickWithWait(
                exportButton);

        System.out.println(
                "Export button clicked.");
    }

    /*
     * Select Export Type
     */
    public void selectExportType(
            String fileType) {

        WebElement exportOption =
                exportType(fileType);

        Assert.assertTrue(
                exportOption.isDisplayed(),
                fileType + " option is not displayed.");

        waitUtil.clickWithWait(
                exportOption);

        System.out.println(
                fileType + " selected.");
    }

    /*
     * Select Drive
     */
    public void selectDrive() {

        Assert.assertTrue(
                selectDrive.isDisplayed(),
                "Drive option is not displayed.");

        waitUtil.clickWithWait(
                selectDrive);

        System.out.println(
                "Drive selected.");
    }

    /*
     * Upload File
     */
    public void uploadFileToDrive() {

        Assert.assertTrue(
                uploadFile.isDisplayed(),
                "Upload button is not displayed.");

        waitUtil.clickWithWait(
                uploadFile);

        System.out.println(
                "File uploaded successfully.");
    }
     public void clickBackButton() {

        Assert.assertTrue(
                BackButton.isDisplayed(),
                "Back button is not displayed.");

        waitUtil.clickWithWait(
                BackButton);

        System.out.println(
                "Back button clicked.");
    }

    public void SelectGroup() {

        Assert.assertTrue(
                SelectGroup.isDisplayed(),
                "Create Shopping List is not displayed.");

        waitUtil.clickWithWait(
                SelectGroup);

        System.out.println(
                "Group name clicked.");
    }
    
    public void Selectcontributor_01() {

        Assert.assertTrue(
                Contributor_01.isDisplayed(),
                "Create Shopping List is not displayed.");

        waitUtil.clickWithWait(
                Contributor_01);

        System.out.println(
                "Contributor_01 clicked.");
    }
    
    public void Selectcontributor_02() {

        Assert.assertTrue(
                Contributor_02.isDisplayed(),
                "Create Shopping List is not displayed.");

        waitUtil.clickWithWait(
                Contributor_02);

        System.out.println(
                "Contributor_02 clicked.");
    }
    
    public void SelectContributor_03() {

        Assert.assertTrue(
                Contributor_03.isDisplayed(),
                "Create Shopping List is not displayed.");

        waitUtil.clickWithWait(
                Contributor_03);

        System.out.println(
                "Contributor_03 clicked.");
    }

    /*
     * Complete Shopping List Flow
     */
    public void createShoppingListAndExport(
            String recipeName,
            String unitName,
            String quantity,
            String exportType) {

        clickCreateShoppingList();

        selectForSelf();

        selectRecipe(recipeName);

        clickNextButton();

        selectUnit(unitName);

        enterOrderFor(quantity);

        clickExportButton();

        selectExportType(exportType);

        selectDrive();

        uploadFileToDrive();
    }
}