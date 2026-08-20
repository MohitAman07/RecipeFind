package pagesObjects.HamburgerMenu;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
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
     * For Self
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc='For Self']")
    private WebElement createListForSelf;

    /*
     * For Group
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc='For Group']")
    private WebElement createListForGroup;

    /*
     * AI Suggestions
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc='AI Suggestions']")
    private WebElement aiSuggestionsDropdown;

    /*
     * Community
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc='Community']")
    private WebElement communityDropdown;

    /*
     * Next Button
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Next']")
    private WebElement nextButton;

    /*
     * Unit Dropdown
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Metric']")
    private WebElement unitDropdown;


/*
 * Dynamic Order For Field
 */
private WebElement orderForField(
        String recipeName) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[contains(@content-desc,'"
                            + recipeName
                            + "')]/following::android.widget.EditText[1]"));
}

    /*
     * Export Button
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Export']")
    private WebElement exportButton;

    /*
     * Drive
     */
    @AndroidFindBy(
            xpath = "//android.widget.LinearLayout[@resource-id='com.android.intentresolver:id/suggested_apps_container']/android.widget.LinearLayout[2]")
    private WebElement selectDrive;

    /*
     * Upload File
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@resource-id='com.google.android.apps.docs:id/save_button']")
    private WebElement uploadFile;

    /*
     * Back Button
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Back']")
    private WebElement backButton;
    
    /*
     * Dynamic Group
     */
    private WebElement group(
            String groupName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='"
                                + groupName
                                + "']"));
    }

    /*
     * Dynamic Contributor
     */
    private WebElement contributor(
            String contributorName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'"
                                + contributorName
                                + "')]"));
    }

    /*
     * Dynamic Recipe
     */
    private WebElement recipe(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='"
                                + recipeName
                                + "']"));
    }

    /*
 * Verify Recipe Displayed
 */
public boolean isRecipeDisplayed(
        String recipeName) {

    try {

        WebElement recipeElement =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10))
                        .until(
                                ExpectedConditions
                                        .visibilityOfElementLocated(
                                                AppiumBy.xpath(
                                                        "//android.view.View[@content-desc='"
                                                                + recipeName
                                                                + "']")));

        return recipeElement.isDisplayed();

    }

    catch (Exception e) {

        System.out.println(
                "Recipe not displayed : "
                        + recipeName);

        return false;
    }
}

/*
 * Dynamic Unit
 */
private WebElement unit(
        String unitName) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.widget.Button[@content-desc='"
                            + unitName
                            + "']"));
}

    /*
 * Dynamic Export Type
 */
private WebElement exportType(
        String fileType) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Export Shopping List']"
                            + "/following::android.widget.Button[@content-desc='"
                            + fileType
                            + "'][1]"));
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
     * Select Group
     */
    public void selectGroup(
            String groupName) {

        WebElement groupElement =
                group(
                        groupName);

        Assert.assertTrue(
                groupElement.isDisplayed(),
                groupName
                        + " group is not displayed.");

        waitUtil.clickWithWait(
                groupElement);

        System.out.println(
                "Group selected : "
                        + groupName);
    }

    /*
     * Expand Contributor
     */
    public void expandContributor(
            String contributorName) {

        WebElement contributorElement =
                contributor(
                        contributorName);

        Assert.assertTrue(
                contributorElement.isDisplayed(),
                contributorName
                        + " contributor is not displayed.");

        waitUtil.clickWithWait(
                contributorElement);

        System.out.println(
                "Contributor selected : "
                        + contributorName);
    }

    /*
     * Select Recipe
     */
    public void selectRecipe(
            String recipeName) {

        WebElement recipeElement =
                recipe(
                        recipeName);

        Assert.assertTrue(
                recipeElement.isDisplayed(),
                recipeName
                        + " recipe is not displayed.");

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

    waitUtil.clickWithWait(
            unitDropdown);

    waitUtil.sleep(
            1000);

    WebElement unitElement =
            unit(
                    unitName);

    waitUtil.clickWithWait(
            unitElement);


    waitUtil.sleep(
            1000);

    System.out.println(
            "Unit selected : "
                    + unitName);
}

    /*
 * Enter Order Quantity
 */
public void enterOrderFor(
        String recipeName,
        String quantity) {

    WebElement orderField =
            orderForField(
                    recipeName);

    Assert.assertTrue(
            orderField.isDisplayed(),
            "Order For field is not displayed.");

    waitUtil.clickWithWait(
            orderField);

    waitUtil.sleep(
            1000);

    orderField.clear();

    waitUtil.sleep(
            500);

    orderField.sendKeys(
            quantity);

    waitUtil.sleep(
            1000);

    try {

        driver.hideKeyboard();

    }

    catch (Exception e) {

    }

    System.out.println(
            "Order quantity entered : "
                    + quantity);
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

    /*
     * Click Back Button
     */
    public void clickBackButton() {

        Assert.assertTrue(
                backButton.isDisplayed(),
                "Back button is not displayed.");

        waitUtil.clickWithWait(
                backButton);

        System.out.println(
                "Back button clicked.");
    }

    /*
 * Complete Shopping List Flow
 */
public void createShoppingListAndExport(
        String recipeName,
        String unitName,
        String quantity,
        String exportType) {

    selectForSelf();

    selectRecipe(
            recipeName);

    clickNextButton();

    selectUnit(
            unitName);

    enterOrderFor(
            recipeName,
            quantity);

    /*
     * Open Export Dropdown
     */
    clickExportButton();

    /*
     * Select Export Option
     */
    selectExportOption(
            exportType);

    /*
     * Close Export Dropdown
     */
    clickOutsideExportDropdown();

    /*
     * Download
     */
    clickDownloadButton();

    System.out.println(
            exportType
                    + " exported successfully.");
}


/*
 * Click Outside Share Window
 */
public void clickOutsideShareWindow() {

    try {

        Dimension screenSize =
                driver.manage()
                        .window()
                        .getSize();

        int screenWidth =
                screenSize.getWidth();

        int screenHeight =
                screenSize.getHeight();

        int x =
                screenWidth / 2;

        /*
         * Tap above the Share Sheet
         */
        int y =
                screenHeight / 4;

        PointerInput finger =
                new PointerInput(
                        PointerInput.Kind.TOUCH,
                        "finger");

        Sequence tap =
                new Sequence(
                        finger,
                        1);

        tap.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        x,
                        y));

        tap.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        tap.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(
                List.of(tap));

        waitUtil.sleep(
                1000);

        System.out.println(
                "Clicked outside Share Window.");

    }

    catch (Exception e) {

        System.out.println(
                "Unable to click outside Share Window.");
    }
}

/*--------New implementation for the export for version V4.1.6----------- */

/*
 * Export Dropdown
 */
@AndroidFindBy(
        xpath = "(//android.view.View[@content-desc='Recipes'])[2]")
private WebElement exportDropdown;

/*
 * Recipes Export Option
 */
@AndroidFindBy(
        xpath = "(//android.view.View[@content-desc='Recipes'])[3]")
private WebElement recipesExportOption;

/*
 * Shopping List Export Option
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc='Shopping List']")
private WebElement shoppingListExportOption;

/*
 * Download Button
 */
@AndroidFindBy(
        xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Button[2]")
private WebElement downloadButton;

/*
 * Share Button
 */
@AndroidFindBy(
        xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Button[3]")
private WebElement shareButton;

/*
 * Verify Recipes PDF Saved Message
 */
public boolean isRecipesPdfSavedMessageDisplayed() {

    try {

        WebElement message =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10))
                        .until(
                                ExpectedConditions
                                        .presenceOfElementLocated(
                                                AppiumBy.xpath(
                                                        "//*[@content-desc='Recipes PDF saved in Downloads > RecipeFind folder'"
                                                        + " or @text='Recipes PDF saved in Downloads > RecipeFind folder']")));

        return message.isDisplayed();

    }

    catch (Exception e) {

        System.out.println(
                "Recipes PDF saved message not displayed.");

        return false;
    }
}

/*
 * Verify Shopping List Saved Message
 */
public boolean isShoppingListSavedMessageDisplayed() {

    try {

        WebElement message =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10))
                        .until(
                                ExpectedConditions
                                        .presenceOfElementLocated(
                                                AppiumBy.xpath(
                                                        "//*[@content-desc='Shopping List PDF + CSV saved in Downloads > RecipeFind folder'"
                                                        + " or @text='Shopping List PDF + CSV saved in Downloads > RecipeFind folder']")));

        return message.isDisplayed();

    }

    catch (Exception e) {

        System.out.println(
                "Shopping List PDF + CSV saved message not displayed.");

        return false;
    }
}

/*
 * Verify Recipes And Shopping List Saved Message
 */
public boolean isRecipesAndShoppingListSavedMessageDisplayed() {

    try {

        WebElement message =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10))
                        .until(
                                ExpectedConditions
                                        .presenceOfElementLocated(
                                                AppiumBy.xpath(
                                                        "//*[@content-desc='Recipes PDF + Shopping List PDF + CSV saved in Downloads > RecipeFind folder'"
                                                        + " or @text='Recipes PDF + Shopping List PDF + CSV saved in Downloads > RecipeFind folder']")));

        return message.isDisplayed();

    }

    catch (Exception e) {

        System.out.println(
                "Recipes PDF + Shopping List PDF + CSV saved message not displayed.");

        return false;
    }
}

/*
 * Click Export Dropdown
 */
public void clickExportButton() {

    waitUtil.clickWithWait(
            exportDropdown);

    System.out.println(
            "Export dropdown opened.");
}

/*
 * Select Export Option
 */
public void selectExportOption(
        String optionName) {

    WebElement exportOption;

    if (optionName.equalsIgnoreCase(
            "Recipes")) {

        exportOption =
                recipesExportOption;

    } else if (optionName.equalsIgnoreCase(
            "Shopping List")) {

        exportOption =
                shoppingListExportOption;

    } else {

        throw new IllegalArgumentException(
                "Invalid export option : "
                        + optionName);
    }

    waitUtil.clickWithWait(
            exportOption);

    System.out.println(
            optionName
                    + " export option selected.");
}

/*
 * Click Outside Export Dropdown
 */
public void clickOutsideExportDropdown() {

    try {

        Dimension screenSize =
                driver.manage()
                        .window()
                        .getSize();

        int screenWidth =
                screenSize.getWidth();

        int screenHeight =
                screenSize.getHeight();

        int x =
                screenWidth / 2;

        int y =
                screenHeight / 2;

        PointerInput finger =
                new PointerInput(
                        PointerInput.Kind.TOUCH,
                        "finger");

        Sequence tap =
                new Sequence(
                        finger,
                        1);

        tap.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        x,
                        y));

        tap.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        tap.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(
                List.of(tap));

        System.out.println(
                "Clicked outside Export dropdown.");

    }

    catch (Exception e) {

        System.out.println(
                "Unable to close Export dropdown.");
    }
}

/*
 * Click Download
 */
public void clickDownloadButton() {

    waitUtil.clickWithWait(
            downloadButton);

    System.out.println(
            "Download button clicked.");
}

/*
 * Click Share
 */
public void clickShareButton() {

    waitUtil.clickWithWait(
            shareButton);

    System.out.println(
            "Share button clicked.");
}


}