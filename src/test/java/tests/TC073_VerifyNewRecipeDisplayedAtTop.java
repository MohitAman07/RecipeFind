package tests;

import java.lang.reflect.Method;
import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Contribute.AddRecipeDashboard.AddRecipe;
import pagesObjects.Contribute.MyRecipiesDashboard.MyRecipes;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.HomeDashboard;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC073_VerifyNewRecipeDisplayedAtTop
        extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    @Override
    public void setUp(Method method) {

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
    public void verifyNewRecipeDisplayedAtTop()
            throws Exception {

        AddRecipe addRecipe =
                new AddRecipe(
                        DriverFactory.getDriver());

        HomeDashboard homeDashboard =
                new HomeDashboard(
                        DriverFactory.getDriver());

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        MyRecipes myRecipes =
                new MyRecipes(
                        DriverFactory.getDriver());

        /*
         * Generate Unique Recipe Name
         */
        int randomNumber =
                100 + new Random().nextInt(
                        900);

        String recipeName =
                "Automation Test Recipe "
                        + randomNumber;

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

        String link =
                "https://example.com";

        String sourcedFrom =
                "Automation Test Source";

        /*
         * Navigate To Add Recipe
         */
        Thread.sleep(
                3000);

        homeDashboard.clickContributeButton();

        Thread.sleep(
                2000);

        /*
         * Create Recipe
         *
         * createRecipe() already clicks
         * Add Recipe internally.
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
         * Recipe Steps & Ingredients
         */
        addRecipe.verifyRecipeStepsIngredientsHeader();

        addRecipe.verifyRecipeStep(
                recipeStep);

        addRecipe.verifyExtractedItemsVerification();

        String ingredientName =
                "Sugar";

        String quantity =
                "1.0";

        String unit =
                "Kilogram";

        String note =
                "Automation Test Note";

        /*
         * Enter Ingredient Details
         */
        addRecipe.enterIngredientDetails(
                ingredientName,
                quantity,
                unit,
                note);

        /*
         * Proceed From Ingredients
         */
        addRecipe.clickIngredientsProceed();

        Thread.sleep(
                2000);

        /*
         * Submit Recipe
         */
        addRecipe.clickSubmitRecipe();

        Thread.sleep(
                3000);


        /*
         * Sort Recipes By Newest
         */
        myRecipes.clickSort();

        Thread.sleep(
                1000);

        myRecipes.selectNewest();

        Thread.sleep(
                2000);

        /*
         * Verify Newly Created Recipe
         * Is Displayed
         */
        ValidationUtil.verifyTrue(
                myRecipes.isRecipeDisplayed(
                        recipeName),
                "Newly created recipe is displayed in My Recipes.");

        System.out.println(
                "Newly created recipe displayed on the top: "
                        + recipeName);

        /*
         * Logout
         */
        homeDashboard.clickHomeButton();

        Thread.sleep(
                2000);

        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is displayed.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        hamburger.clickSignOut();

        System.out.println(
                "==================================================");

        System.out.println(
                "Verify New Recipe Displayed At Top test completed successfully.");

        System.out.println(
                "Recipe created : "
                        + recipeName);

        System.out.println(
                "Sort option : Newest");

        System.out.println(
                "==================================================");

        Thread.sleep(
                500);
    }
}