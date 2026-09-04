package tests;

import java.lang.reflect.Method;
import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Contribute.AddRecipeDashboard.AddRecipe;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.HomeDashboard;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC074_VerifyInvalidReferenceUrlError
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
    public void verifyInvalidReferenceUrlError()
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

        /*
         * Invalid Reference URL
         */
        String invalidUrl =
                "Htttps: dsfsd";

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
                invalidUrl,
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


        /*
         * Verify Invalid Reference URL Error
         */
        addRecipe.verifyInvalidReferenceUrlError(
                invalidUrl);


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
                "Invalid Reference URL validation test completed successfully.");

        System.out.println(
                "Recipe : "
                        + recipeName);

        System.out.println(
                "Invalid URL : "
                        + invalidUrl);

        System.out.println(
                "==================================================");

        Thread.sleep(
                500);
    }
}