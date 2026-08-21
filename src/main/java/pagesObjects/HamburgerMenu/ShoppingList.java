package pagesObjects.HamburgerMenu;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
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

//     /*
//      * Dynamic Contributor
//      */
//     private WebElement contributor(
//             String contributorName) {

//         return driver.findElement(
//                 AppiumBy.xpath(
//                         "//android.view.View[contains(@content-desc,'"
//                                 + contributorName
//                                 + "')]"));
//     }

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

//     /*
//      * Expand Contributor
//      */
//     public void expandContributor(
//             String contributorName) {

//         WebElement contributorElement =
//                 contributor(
//                         contributorName);

//         Assert.assertTrue(
//                 contributorElement.isDisplayed(),
//                 contributorName
//                         + " contributor is not displayed.");

//         waitUtil.clickWithWait(
//                 contributorElement);

//         System.out.println(
//                 "Contributor selected : "
//                         + contributorName);
//     }

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

/*--Group will be visible only when contributor recipe is selected in group */

/*
 * Dynamic Contributor
 */
private WebElement contributor(
        String contributorName) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='"
                            + contributorName
                            + ", Collapsed']"));
}

/*
 * Dynamic Expanded Contributor
 */
private WebElement expandedContributor(
        String contributorName) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='"
                            + contributorName
                            + ", Expanded']"));
}

/*
 * Expand Contributor
 */
public void expandContributor(
        String contributorName) {

    try {

        WebElement expandedContributor =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.view.View[@content-desc='"
                                        + contributorName
                                        + ", Expanded']"));

        if (expandedContributor.isDisplayed()) {

            System.out.println(
                    "Contributor already expanded : "
                            + contributorName);

            return;
        }

    }

    catch (Exception e) {

        /*
         * Contributor is collapsed.
         * Continue with expansion.
         */
    }

    WebElement collapsedContributor =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10))
                    .until(
                            ExpectedConditions
                                    .visibilityOfElementLocated(
                                            AppiumBy.xpath(
                                                    "//android.view.View[@content-desc='"
                                                            + contributorName
                                                            + ", Collapsed']")));

    waitUtil.clickWithWait(
            collapsedContributor);

    System.out.println(
            "Contributor expanded : "
                    + contributorName);
}

/*
 * Dynamic Contributor Recipe
 */
private WebElement contributorRecipe(
        String recipeName) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='"
                            + recipeName
                            + "']"));
}



/*
 * Scroll Contributor Recipe Into View
 */
public void scrollToContributorRecipe(
        String recipeName) {

    try {

        /*
         * Check If Recipe Is Already Visible
         */
        try {

            WebElement recipeElement =
                    driver.findElement(
                            AppiumBy.xpath(
                                    "//android.view.View[@content-desc='"
                                            + recipeName
                                            + "']"));

            if (recipeElement.isDisplayed()) {

                System.out.println(
                        "Recipe already visible : "
                                + recipeName);

                return;
            }

        }

        catch (Exception e) {

            /*
             * Recipe is not visible.
             * Continue scrolling.
             */
        }

        /*
         * Find Scroll View
         */
        WebElement scrollView =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.widget.ScrollView"));

        /*
         * Scroll Down Slowly
         */
        for (int i = 0; i < 8; i++) {

            /*
             * Check Recipe Before Scrolling
             */
            try {

                WebElement recipeElement =
                        driver.findElement(
                                AppiumBy.xpath(
                                        "//android.view.View[@content-desc='"
                                                + recipeName
                                                + "']"));

                if (recipeElement.isDisplayed()) {

                    System.out.println(
                            "Recipe found : "
                                    + recipeName);

                    return;
                }

            }

            catch (Exception e) {

                /*
                 * Recipe not visible yet.
                 */
            }

            /*
             * Scroll ScrollView
             */
            Map<String, Object> scrollObject =
                    new HashMap<>();

            scrollObject.put(
                    "elementId",
                    ((RemoteWebElement) scrollView).getId());

            scrollObject.put(
                    "direction",
                    "down");

            scrollObject.put(
                    "percent",
                    0.30);

            scrollObject.put(
                    "speed",
                    300);

            driver.executeScript(
                    "mobile: scrollGesture",
                    scrollObject);

            System.out.println(
                    "Scrolling recipe list : "
                            + recipeName
                            + " | Attempt : "
                            + (i + 1));

            /*
             * Allow Batch Loading
             */
            Thread.sleep(
                    1200);
        }

        System.out.println(
                "Recipe found after scrolling : "
                        + recipeName);
    }

    catch (Exception e) {

        System.out.println(
                "Unable to scroll recipe into view : "
                        + recipeName);

        throw new RuntimeException(
                "Recipe could not be found after scrolling : "
                        + recipeName,
                e);
    }
}

// /*
//  * Select Contributor Recipe
//  */
// public void selectContributorRecipe(
//         String contributorName,
//         String recipeName) {

//     /*
//      * Expand Contributor If Required
//      */
//     expandContributor(
//             contributorName);

//     /*
//      * Scroll Recipe Into View
//      */
//     scrollToContributorRecipe(
//             recipeName);

//     /*
//      * Select Recipe
//      */
//     WebElement recipeElement =
//             new WebDriverWait(
//                     driver,
//                     Duration.ofSeconds(10))
//                     .until(
//                             ExpectedConditions
//                                     .visibilityOfElementLocated(
//                                             AppiumBy.xpath(
//                                                     "//android.view.View[@content-desc='"
//                                                             + recipeName
//                                                             + "']")));

//     waitUtil.clickWithWait(
//             recipeElement);

//     System.out.println(
//             "Contributor recipe selected : "
//                     + recipeName
//                     + " for "
//                     + contributorName);
// }

/*
 * Collapse Contributor
 */
public void collapseContributor(
        String contributorName) {

    try {

        WebElement expandedContributor =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10))
                        .until(
                                ExpectedConditions
                                        .presenceOfElementLocated(
                                                AppiumBy.xpath(
                                                        "//android.view.View[@content-desc='"
                                                                + contributorName
                                                                + ", Expanded']")));

        /*
         * Scroll Only If Required
         */
        if (!expandedContributor.isDisplayed()) {

            Map<String, Object> scrollObject =
                    new HashMap<>();

            scrollObject.put(
                    "elementId",
                    ((RemoteWebElement) expandedContributor).getId());

            scrollObject.put(
                    "direction",
                    "up");

            scrollObject.put(
                    "percent",
                    0.30);

            scrollObject.put(
                    "speed",
                    300);

            driver.executeScript(
                    "mobile: scrollGesture",
                    scrollObject);

            Thread.sleep(
                    1000);
        }

        /*
         * Collapse Contributor
         */
        waitUtil.clickWithWait(
                expandedContributor);

        System.out.println(
                "Contributor collapsed : "
                        + contributorName);
    }

    catch (Exception e) {

        System.out.println(
                "Unable to collapse contributor : "
                        + contributorName);

        throw new RuntimeException(
                "Contributor could not be collapsed : "
                        + contributorName,
                e);
    }
}

/*
 * Expand Member
 */
public void expandMember(
        String memberName) {

    try {

        WebElement expandedMember =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.view.View[@content-desc='"
                                        + memberName
                                        + ", Expanded']"));

        if (expandedMember.isDisplayed()) {

            System.out.println(
                    "Member already expanded : "
                            + memberName);

            return;
        }

    }

    catch (Exception e) {

        /*
         * Member is collapsed.
         * Continue with expansion.
         */
    }

    WebElement collapsedMember =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10))
                    .until(
                            ExpectedConditions
                                    .visibilityOfElementLocated(
                                            AppiumBy.xpath(
                                                    "//android.view.View[@content-desc='"
                                                            + memberName
                                                            + ", Collapsed']")));

    waitUtil.clickWithWait(
            collapsedMember);

    System.out.println(
            "Member expanded : "
                    + memberName);
}

/*
 * Scroll Recipe Into View
 */
public void scrollToMemberRecipe(
        String recipeName) {

    try {

        /*
         * Check If Recipe Is Already Visible
         */
        try {

            WebElement recipeElement =
                    driver.findElement(
                            AppiumBy.xpath(
                                    "//android.view.View[@content-desc='"
                                            + recipeName
                                            + "']"));

            if (recipeElement.isDisplayed()) {

                System.out.println(
                        "Recipe already visible : "
                                + recipeName);

                return;
            }

        }

        catch (Exception e) {

            /*
             * Recipe is not visible.
             * Continue scrolling.
             */
        }

        /*
         * Find Scroll View
         */
        WebElement scrollView =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.widget.ScrollView"));

        /*
         * Scroll Down Slowly
         */
        for (int i = 0; i < 8; i++) {

            /*
             * Check Recipe Before Scrolling
             */
            try {

                WebElement recipeElement =
                        driver.findElement(
                                AppiumBy.xpath(
                                        "//android.view.View[@content-desc='"
                                                + recipeName
                                                + "']"));

                if (recipeElement.isDisplayed()) {

                    System.out.println(
                            "Recipe found : "
                                    + recipeName);

                    return;
                }

            }

            catch (Exception e) {

                /*
                 * Recipe not visible yet.
                 */
            }

            /*
             * Scroll ScrollView
             */
            Map<String, Object> scrollObject =
                    new HashMap<>();

            scrollObject.put(
                    "elementId",
                    ((RemoteWebElement) scrollView).getId());

            scrollObject.put(
                    "direction",
                    "down");

            scrollObject.put(
                    "percent",
                    0.30);

            scrollObject.put(
                    "speed",
                    300);

            driver.executeScript(
                    "mobile: scrollGesture",
                    scrollObject);

            System.out.println(
                    "Scrolling recipe list : "
                            + recipeName
                            + " | Attempt : "
                            + (i + 1));

            /*
             * Allow Batch Loading
             */
            Thread.sleep(
                    1200);
        }

        
        System.out.println(
                "Recipe found after scrolling : "
                        + recipeName);

    }

    catch (Exception e) {

        System.out.println(
                "Unable to scroll recipe into view : "
                        + recipeName);

        throw new RuntimeException(
                "Recipe could not be found after scrolling : "
                        + recipeName,
                e);
    }
}

/*
 * Select Contributor Recipe
 */
public void selectContributorRecipe(
        String contributorName,
        String recipeName) {

    /*
     * Scroll Contributor Into View
     */
    scrollToContributor(
            contributorName);

    /*
     * Expand Contributor If Required
     */
    expandContributor(
            contributorName);

    /*
     * Scroll Contributor Into View
     */
    scrollToContributor(
            contributorName);

    /*
     * Scroll Recipe Into View
     */
    scrollToContributorRecipe(
            recipeName);

    /*
     * Select Recipe
     */
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

    waitUtil.clickWithWait(
            recipeElement);

    System.out.println(
            "Contributor recipe selected : "
                    + recipeName
                    + " for "
                    + contributorName);
}

/*
 * Scroll Contributor Into View
 */
public void scrollToContributor(
        String contributorName) {

    /*
     * Check Collapsed Contributor
     */
    try {

        WebElement collapsedContributor =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.view.View[@content-desc='"
                                        + contributorName
                                        + ", Collapsed']"));

        if (collapsedContributor.isDisplayed()) {

            System.out.println(
                    "Contributor already visible : "
                            + contributorName);

            return;
        }

    }

    catch (Exception e) {

        /*
         * Contributor is not currently visible.
         * Continue checking expanded state.
         */
    }

    /*
     * Check Expanded Contributor
     */
    try {

        WebElement expandedContributor =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.view.View[@content-desc='"
                                        + contributorName
                                        + ", Expanded']"));

        if (expandedContributor.isDisplayed()) {

            System.out.println(
                    "Expanded contributor already visible : "
                            + contributorName);

            return;
        }

    }

    catch (Exception e) {

        /*
         * Contributor is not currently visible.
         * Continue scrolling.
         */
    }

    /*
     * Scroll Only If Contributor Is Not Visible
     */
    try {

        WebElement scrollView =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.widget.ScrollView"));

        /*
         * Scroll Down Slowly
         */
        for (int i = 0; i < 8; i++) {

            /*
             * Check Collapsed Contributor
             */
            try {

                WebElement collapsedContributor =
                        driver.findElement(
                                AppiumBy.xpath(
                                        "//android.view.View[@content-desc='"
                                                + contributorName
                                                + ", Collapsed']"));

                if (collapsedContributor.isDisplayed()) {

                    System.out.println(
                            "Contributor found after scrolling : "
                                    + contributorName);

                    return;
                }

            }

            catch (Exception e) {

                /*
                 * Contributor not visible yet.
                 */
            }

            /*
             * Check Expanded Contributor
             */
            try {

                WebElement expandedContributor =
                        driver.findElement(
                                AppiumBy.xpath(
                                        "//android.view.View[@content-desc='"
                                                + contributorName
                                                + ", Expanded']"));

                if (expandedContributor.isDisplayed()) {

                    System.out.println(
                            "Expanded contributor found after scrolling : "
                                    + contributorName);

                    return;
                }

            }

            catch (Exception e) {

                /*
                 * Contributor not visible yet.
                 */
            }

            /*
             * Scroll ScrollView
             */
            Map<String, Object> scrollObject =
                    new HashMap<>();

            scrollObject.put(
                    "elementId",
                    ((RemoteWebElement) scrollView).getId());

            scrollObject.put(
                    "direction",
                    "down");

            scrollObject.put(
                    "percent",
                    0.30);

            scrollObject.put(
                    "speed",
                    300);

            driver.executeScript(
                    "mobile: scrollGesture",
                    scrollObject);

            System.out.println(
                    "Scrolling contributor list : "
                            + contributorName
                            + " | Attempt : "
                            + (i + 1));

            /*
             * Allow Batch Loading
             */
            Thread.sleep(
                    1200);
        }

        throw new RuntimeException(
                "Contributor could not be found after scrolling : "
                        + contributorName);
    }

    catch (Exception e) {

        System.out.println(
                "Unable to scroll contributor into view : "
                        + contributorName);

        throw new RuntimeException(
                "Contributor could not be found after scrolling : "
                        + contributorName,
                e);
    }
}
}