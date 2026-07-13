package pagesObjects.Contribute.AddRecipeDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.WaitUtil;

public class AddRecipe {

    private final AndroidDriver driver;
private final WaitUtil waitUtil;

public AddRecipe(AndroidDriver driver) {

    this.driver = driver;

    this.waitUtil = new WaitUtil(driver);

    PageFactory.initElements(
            new AppiumFieldDecorator(driver),
            this);
}

    /*
 * ==========================================================
 * Contribute Dashboard
 * ==========================================================
 */

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Contribute\nTab 3 of 4\"]")
private WebElement contributeTab;

@AndroidFindBy(
        xpath = "//android.widget.ScrollView/android.view.View[3]/android.view.View")
private WebElement image;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Gallery\"]")
private WebElement gallery;

@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Media grid\"]/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View")
private WebElement recipeImage;

@AndroidFindBy(
        xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View[3]/android.widget.Button")
private WebElement imageDone;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Crop\"]")
private WebElement cropButton;

/*
 * ==========================================================
 * Recipe Details
 * ==========================================================
 */

@AndroidFindBy(
        xpath = "//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")
private WebElement recipeName;

@AndroidFindBy(
        xpath = "(//android.widget.ScrollView/android.view.View[5]/android.widget.EditText[@text=\"0\"])[1]")
private WebElement prepTime;

@AndroidFindBy(
        xpath = "(//android.widget.ScrollView/android.view.View[5]/android.widget.EditText[@text=\"0\"])[2]")
private WebElement cookTime;

@AndroidFindBy(
        xpath = "(//android.widget.ScrollView/android.view.View[5]/android.widget.EditText[@text=\"0\"])[3]")
private WebElement servings;

@AndroidFindBy(
        xpath = "//android.widget.ScrollView/android.widget.EditText")
private WebElement summary;

/*
 * ==========================================================
 * Image Upload
 * ==========================================================
 */

public void clickContributeTab() {

    Assert.assertTrue(
            contributeTab.isDisplayed(),
            "Contribute tab is not displayed.");

    waitUtil.clickWithWait(
            contributeTab);
}

public void clickImage() {

    Assert.assertTrue(
            image.isDisplayed(),
            "Image button is not displayed.");

    waitUtil.clickWithWait(
            image);
}

public void clickGallery() {

    Assert.assertTrue(
            gallery.isDisplayed(),
            "Gallery option is not displayed.");

    waitUtil.clickWithWait(
            gallery);
}

public void selectRecipeImage() {

    Assert.assertTrue(
            recipeImage.isDisplayed(),
            "Recipe image is not displayed.");

    waitUtil.clickWithWait(
            recipeImage);
}

public void clickImageDone() {

    Assert.assertTrue(
            imageDone.isDisplayed(),
            "Done button is not displayed.");

    waitUtil.clickWithWait(
            imageDone);
}

public void clickCropButton() {

    Assert.assertTrue(
            cropButton.isDisplayed(),
            "Crop button is not displayed.");

    waitUtil.clickWithWait(
            cropButton);
}

/*
 * ==========================================================
 * Recipe Details
 * ==========================================================
 */

public void clickRecipeName() {

    Assert.assertTrue(
            recipeName.isDisplayed(),
            "Recipe Name field is not displayed.");

    waitUtil.clickWithWait(
            recipeName);

    recipeName.clear();
}

public void enterRecipeName(
        String recipe) {

    recipeName.sendKeys(
            recipe);
}

public void clickPrepTime() {

    Assert.assertTrue(
            prepTime.isDisplayed(),
            "Prep Time field is not displayed.");

    waitUtil.clickWithWait(
            prepTime);
}

public void enterPrepTime(
        String prep) {

    prepTime.sendKeys(
            prep);
}

public void clickCookTime() {

    Assert.assertTrue(
            cookTime.isDisplayed(),
            "Cook Time field is not displayed.");

    waitUtil.clickWithWait(
            cookTime);
}

public void enterCookTime(
        String cook) {

    cookTime.sendKeys(
            cook);
}

public void clickServings() {

    Assert.assertTrue(
            servings.isDisplayed(),
            "Servings field is not displayed.");

    waitUtil.clickWithWait(
            servings);
}

public void enterServings(
        String serving) {

    servings.sendKeys(
            serving);
}

public void clickSummary() {

    Assert.assertTrue(
            summary.isDisplayed(),
            "Summary field is not displayed.");

    waitUtil.clickWithWait(
            summary);
}

public void enterSummary(
        String text) {

    summary.sendKeys(
            text);
}

/*
 * ==========================================================
 * Recipe Steps
 * ==========================================================
 */

@AndroidFindBy(
        xpath = "//android.widget.ScrollView/android.view.View[9]/android.view.View/android.view.View/android.widget.EditText")
private WebElement recipeStep1;

@AndroidFindBy(
        xpath = "//android.widget.Button[@index='2']")
private WebElement validateStep1;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Add Step\"]")
private WebElement addStep;

@AndroidFindBy(
        xpath = "//android.widget.ScrollView/android.view.View[8]/android.view.View/android.view.View/android.widget.EditText[2]")
private WebElement recipeStep2;

@AndroidFindBy(
        xpath = "//android.widget.EditText[@text=\"Heat oil to medium high\"]/android.widget.Button[3]")
private WebElement validateStep2;

/*
 * ==========================================================
 * Pro Tip & Keywords
 * ==========================================================
 */

@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Pro Tip\"]/android.widget.Button")
private WebElement proTip;

@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Pro Tip\"]/android.widget.EditText")
private WebElement proTipField;

@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Pro Tip\"]/android.widget.EditText")
private WebElement keywords;

/*
 * ==========================================================
 * Recipe Step Methods
 * ==========================================================
 */

public void clickRecipeStep1() {

    Assert.assertTrue(
            recipeStep1.isDisplayed(),
            "Recipe Step 1 is not displayed");

    waitUtil.clickWithWait(
            recipeStep1);
}

public void enterRecipeStep1(
        String step) {

    recipeStep1.clear();

    recipeStep1.sendKeys(
            step);
}

public void validateStep1() {

    Assert.assertTrue(
            validateStep1.isDisplayed(),
            "Step 1 validation is not displayed");

    waitUtil.clickWithWait(
            validateStep1);
}

public void clickAddStep() {

    Assert.assertTrue(
            addStep.isDisplayed(),
            "Add Step button is not displayed");

    waitUtil.clickWithWait(
            addStep);
}

public void clickRecipeStep2() {

    Assert.assertTrue(
            recipeStep2.isDisplayed(),
            "Recipe Step 2 is not displayed");

    waitUtil.clickWithWait(
            recipeStep2);
}

public void enterRecipeStep2(
        String step) {

    recipeStep2.clear();

    recipeStep2.sendKeys(
            step);
}

public void validateStep2() {

    Assert.assertTrue(
            validateStep2.isDisplayed(),
            "Step 2 validation is not displayed");

    waitUtil.clickWithWait(
            validateStep2);
}

/*
 * ==========================================================
 * Pro Tip
 * ==========================================================
 */

public void openProTip() {

    Assert.assertTrue(
            proTip.isDisplayed(),
            "Pro Tip button is not displayed");

    waitUtil.clickWithWait(
            proTip);
}

public void clickProTipField() {

    Assert.assertTrue(
            proTipField.isDisplayed(),
            "Pro Tip field is not displayed");

    waitUtil.clickWithWait(
            proTipField);
}

public void enterProTip(
        String tip) {

    proTipField.sendKeys(
            tip);
}

/*
 * ==========================================================
 * Keywords
 * ==========================================================
 */

public void clickKeywords() {

    Assert.assertTrue(
            keywords.isDisplayed(),
            "Keywords field is not displayed");

    waitUtil.clickWithWait(
            keywords);
}

/*
 * ==========================================================
 * Cuisine & Dietary
 * ==========================================================
 */

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Caribbean\"]")
private WebElement selectCuisines;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Caribbean\"]")
private WebElement dietary;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Cardiovascular\"]")
private WebElement selectDietary;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Cardiovascular\"]")
private WebElement religion;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Islam\"]")
private WebElement selectReligion;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Difficulty\"]")
private WebElement difficulty;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Beginner\"]")
private WebElement selectDifficulty;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Confirm\"]")
private WebElement confirmKeywords;

/*
 * ==========================================================
 * Add Links
 * ==========================================================
 */

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Confirm\"]")
private WebElement addLinks;

@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Add Links\nHere you can add only 1 link per recipe\"]/android.widget.EditText")
private WebElement addLinksField;

/*
 * ==========================================================
 * Sourced From
 * ==========================================================
 */

@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Sourced From\"]/android.widget.Button")
private WebElement sourcedFrom;

@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Sourced From\"]/android.widget.Button")
private WebElement sourcedField;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Proceed\"]")
private WebElement proceed01;

/*
 * ==========================================================
 * Cuisine & Dietary Methods
 * ==========================================================
 */

public void clickSelectCuisine() {

    Assert.assertTrue(
            selectCuisines.isDisplayed(),
            "Cuisine option is not displayed");

    waitUtil.clickWithWait(
            selectCuisines);
}

public void clickDietary() {

    Assert.assertTrue(
            dietary.isDisplayed(),
            "Dietary option is not displayed");

    waitUtil.clickWithWait(
            dietary);
}

public void clickSelectDietary() {

    Assert.assertTrue(
            selectDietary.isDisplayed(),
            "Dietary selection is not displayed");

    waitUtil.clickWithWait(
            selectDietary);
}

public void clickReligion() {

    Assert.assertTrue(
            religion.isDisplayed(),
            "Religion option is not displayed");

    waitUtil.clickWithWait(
            religion);
}

public void clickSelectReligion() {

    Assert.assertTrue(
            selectReligion.isDisplayed(),
            "Religion selection is not displayed");

    waitUtil.clickWithWait(
            selectReligion);
}

public void clickDifficulty() {

    Assert.assertTrue(
            difficulty.isDisplayed(),
            "Difficulty option is not displayed");

    waitUtil.clickWithWait(
            difficulty);
}

public void clickSelectDifficulty() {

    Assert.assertTrue(
            selectDifficulty.isDisplayed(),
            "Difficulty selection is not displayed");

    waitUtil.clickWithWait(
            selectDifficulty);
}

public void clickConfirmKeywords() {

    Assert.assertTrue(
            confirmKeywords.isDisplayed(),
            "Confirm button is not displayed");

    waitUtil.clickWithWait(
            confirmKeywords);
}

/*
 * ==========================================================
 * Add Links
 * ==========================================================
 */

public void clickAddLinks() {

    Assert.assertTrue(
            addLinks.isDisplayed(),
            "Add Links button is not displayed");

    waitUtil.clickWithWait(
            addLinks);
}

public void enterAddLinks() {

    Assert.assertTrue(
            addLinksField.isDisplayed(),
            "Add Links field is not displayed");

    waitUtil.clickWithWait(
            addLinksField);
}

public void enterLinkText(
        String link) {

    addLinksField.clear();

    addLinksField.sendKeys(
            link);
}

/*
 * ==========================================================
 * Sourced From
 * ==========================================================
 */

public void clickSourcedFrom() {

    Assert.assertTrue(
            sourcedFrom.isDisplayed(),
            "Sourced From button is not displayed");

    waitUtil.clickWithWait(
            sourcedFrom);
}

public void enterSourcedField() {

    Assert.assertTrue(
            sourcedField.isDisplayed(),
            "Sourced Field is not displayed");

    waitUtil.clickWithWait(
            sourcedField);
}

public void enterSourcedText(
        String source) {

    sourcedField.clear();

    sourcedField.sendKeys(
            source);
}

/*
 * ==========================================================
 * Navigation
 * ==========================================================
 */

public void clickProceed() {

    Assert.assertTrue(
            proceed01.isDisplayed(),
            "Proceed button is not displayed");

    waitUtil.clickWithWait(
            proceed01);
}

/*
 * ==========================================================
 * Verification
 * ==========================================================
 */

@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Thinly slice the potaties.Soak slices in cold water for 20 to 30 min.\"]")
private WebElement verifyStep1;

/*
 * ==========================================================
 * Ingredients
 * ==========================================================
 */

@AndroidFindBy(
        xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.Button[1]")
private WebElement addIngredient;

@AndroidFindBy(
        xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[1]/android.widget.EditText")
private WebElement enterIngredient;

@AndroidFindBy(
        xpath = "//android.widget.EditText[@text=\"0.0\"]")
private WebElement enterQuantity;

@AndroidFindBy(
        xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[3]/android.widget.Button")
private WebElement viewUnitList;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Gram\"]")
private WebElement selectGram;

@AndroidFindBy(
        xpath = "//android.view.View[@index='0']")
private WebElement deleteIngredient;

/*
 * ==========================================================
 * Verification
 * ==========================================================
 */

public boolean verifyStep01Displayed() {

    Assert.assertTrue(
            verifyStep1.isDisplayed(),
            "Step 1 is not displayed");

    return verifyStep1.isDisplayed();
}

/*
 * ==========================================================
 * Ingredients
 * ==========================================================
 */

public void clickAddIngredient() {

    Assert.assertTrue(
            addIngredient.isDisplayed(),
            "Add Ingredient button is not displayed");

    waitUtil.clickWithWait(
            addIngredient);
}

public void enterIngredient() {

    Assert.assertTrue(
            enterIngredient.isDisplayed(),
            "Ingredient field is not displayed");

    waitUtil.clickWithWait(
            enterIngredient);
}

public void typeIngredient(
        String ingredient) {

    enterIngredient.clear();

    enterIngredient.sendKeys(
            ingredient);
}

public void enterQuantity() {

    Assert.assertTrue(
            enterQuantity.isDisplayed(),
            "Quantity field is not displayed");

    waitUtil.clickWithWait(
            enterQuantity);
}

public void typeQuantity(
        String quantity) {

    enterQuantity.clear();

    enterQuantity.sendKeys(
            quantity);
}

public void clickUnitList() {

    Assert.assertTrue(
            viewUnitList.isDisplayed(),
            "Unit List is not displayed");

    waitUtil.clickWithWait(
            viewUnitList);
}

public void selectGram() {

    waitUtil.clickWithWait(
            selectGram);
}

public void clickDeleteIngredient() {

    Assert.assertTrue(
            deleteIngredient.isDisplayed(),
            "Delete Ingredient button is not displayed");

    waitUtil.clickWithWait(
            deleteIngredient);
}

/*
 * ==========================================================
 * Utensils
 * ==========================================================
 */

@AndroidFindBy(
        xpath = "//android.widget.Button[@index='6']")
private WebElement addUtensils;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Baking Sheet\"]")
private WebElement selectUtensils;

@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Add custom utensil\"]")
private WebElement addCustomUtensils;

@AndroidFindBy(
        xpath = "//android.widget.EditText[@index='0']")
private WebElement addCustomEnterField;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Add\"]")
private WebElement addUtensilsButton;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Confirm\"]")
private WebElement utensilsConfirm;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Next\"]")
private WebElement next;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Proceed\"]")
private WebElement proceed;

@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Submit Recipe\"]")
private WebElement submitRecipe;

/*
 * ==========================================================
 * Utensils
 * ==========================================================
 */

public void clickAddUtensils() {

    Assert.assertTrue(
            addUtensils.isDisplayed(),
            "Add Utensils button is not displayed");

    waitUtil.clickWithWait(
            addUtensils);
}

public void selectUtensils() {

    Assert.assertTrue(
            selectUtensils.isDisplayed(),
            "Utensil is not displayed");

    waitUtil.clickWithWait(
            selectUtensils);
}

public void clickAddCustomUtensils() {

    Assert.assertTrue(
            addCustomUtensils.isDisplayed(),
            "Add Custom Utensils option is not displayed");

    waitUtil.clickWithWait(
            addCustomUtensils);
}

public void enterCustomUtensils(
        String utensil) {

    Assert.assertTrue(
            addCustomEnterField.isDisplayed(),
            "Custom Utensil field is not displayed");

    waitUtil.clickWithWait(
            addCustomEnterField);

    addCustomEnterField.clear();

    addCustomEnterField.sendKeys(
            utensil);
}

public void clickAddButton() {

    Assert.assertTrue(
            addUtensilsButton.isDisplayed(),
            "Add button is not displayed");

    waitUtil.clickWithWait(
            addUtensilsButton);
}

public void clickUtensilsConfirm() {

    Assert.assertTrue(
            utensilsConfirm.isDisplayed(),
            "Confirm button is not displayed");

    waitUtil.clickWithWait(
            utensilsConfirm);
}

public void clickNext() {

    Assert.assertTrue(
            next.isDisplayed(),
            "Next button is not displayed");

    waitUtil.clickWithWait(
            next);
}

public void clickProceed02() {

    Assert.assertTrue(
            proceed.isDisplayed(),
            "Proceed button is not displayed");

    waitUtil.clickWithWait(
            proceed);
}

/*
 * ==========================================================
 * Submit Recipe
 * ==========================================================
 */

public void clickSubmitRecipe() {

    Assert.assertTrue(
            submitRecipe.isDisplayed(),
            "Submit Recipe button is not displayed");

    waitUtil.clickWithWait(
            submitRecipe);
}

}

