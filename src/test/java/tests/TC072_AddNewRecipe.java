package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Contribute.AddRecipeDashboard.AddRecipe;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.HomeDashboard;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC072_AddNewRecipe
        extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    @Override
    public void setUp(
            Method method) {

        loginEmail =
                ConfigReader.getProperty(
                        "superadmin.email");

        loginPassword =
                ConfigReader.getProperty(
                        "superadmin.password");

        super.setUp(
                method);
    }

    @Test
    public void addNewRecipe()
            throws Exception {

        AddRecipe addRecipe =
                new AddRecipe(
                        DriverFactory.getDriver());

        HomeDashboard homeDashboard =
                new HomeDashboard(
                        DriverFactory.getDriver());

        Hamburger hamburger=new Hamburger(DriverFactory.getDriver());

        /*
         * Allow Home Dashboard To Stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Open Contribute
         */
        homeDashboard.clickContributeButton();

        Thread.sleep(
                2000);

        /*
         * Recipe Details
         */
        String recipeName =
                "Automation Test Recipe";

        String cookingTime =
                "15";

        String servingTime =
                "10";

        String servingLimit =
                "4";

        String recipeSummary =
                "This is an automation test recipe.";

        String recipeStep =
                "1 Kg Sugar";

        String proTipText =
                "Serve immediately for the best taste.";

        /*
         * Recipe Classification
         */
        String cuisineName =
                "South Asian";

        String dietaryName =
                "Vegetarian";

        String occasionName =
                "Diwali";

        String difficultyName =
                "Beginner";

        String attributeName =
                "Comfort food";

        /*
         * Recipe Source Details
         */
        String link =
                "https://example.com";

        String sourcedFrom =
                "Automation Test Source";

        /*
         * Complete Add Recipe Flow
         *
         * This method also opens
         * the Add Recipe section.
         */
        addRecipe.createRecipe(
                recipeName,
                cookingTime,
                servingTime,
                servingLimit,
                recipeSummary,
                recipeStep,
                proTipText,
                cuisineName,
                dietaryName,
                occasionName,
                difficultyName,
                attributeName,
                link,
                sourcedFrom);

        Thread.sleep(
                2000);

        /*
         * Verify Recipe Steps & Ingredients Header
         */
        addRecipe.verifyRecipeStepsIngredientsHeader();

        /*
         * Verify Recipe Step
         */
        addRecipe.verifyRecipeStep(
                recipeStep);

        /*
         * Verify Extracted Items Verification
         */
        addRecipe.verifyExtractedItemsVerification();

        /*
         * Ingredient Details
         */
        String ingredientName =
                "Sugar";

        String quantity =
                "1.0";

        String unit =
                "Kilogram";

        String note =
                "Automation Test Note";

        /*
         * Enter Ingredient
         *
         * Handles extracted and
         * non-extracted cases.
         */
        addRecipe.enterIngredient(
                ingredientName);

        /*
         * Enter Quantity
         */
        addRecipe.enterIngredientQuantity(
                quantity);

        /*
         * Click Ingredient Unit
         */
        addRecipe.clickIngredientUnit();

        Thread.sleep(
                500);

        /*
         * Select Ingredient Unit
         */
        addRecipe.selectIngredientUnit(
                unit);

        /*
         * Enter Note
         */
        addRecipe.enterIngredientNote(
                note);

        /*
         * Proceed From Ingredient Verification
         */
        addRecipe.clickIngredientsProceed();

        Thread.sleep(
                2000);

        /*
         * Submit Recipe From Final Review
         */
        addRecipe.clickSubmitRecipe();

        Thread.sleep(500);

        homeDashboard.clickHomeButton();  

        Thread.sleep(3000);

        /*
         * Open Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is  displayed.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Logout Super User
         */
        hamburger.clickSignOut();

        System.out.println(
                "==================================================");

        System.out.println(
                "Add New Recipe test completed successfully.");

        System.out.println(
                "Recipe created : "
                        + recipeName);

        System.out.println(
                "Recipe step : "
                        + recipeStep);

        System.out.println(
                "Ingredient : "
                        + ingredientName);

        System.out.println(
                "Quantity : "
                        + quantity);

        System.out.println(
                "Unit : "
                        + unit);

        System.out.println(
                "Note : "
                        + note);

        System.out.println(
                "==================================================");

            Thread.sleep(500);

        
    }
}