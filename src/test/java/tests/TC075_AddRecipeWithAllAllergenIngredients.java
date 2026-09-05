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

public class TC075_AddRecipeWithAllAllergenIngredients
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
    public void addRecipeWithAllAllergenIngredients()
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
                "Automation Allergen Recipe "
                        + randomNumber;

        String cookingTime =
                "15";

        String servingTime =
                "10";

        String servingLimit =
                "4";

        String recipeSummary =
                "This is an automation test recipe with all allergen ingredients.";

        String recipeStep =
                "1 Kg Crustacean, 1 Kg Egg, 1 Kg Fish, 1 Kg Milk, "
                        + "1 Kg Peanut, 1 Kg Sesame, 1 Kg Shellfish, "
                        + "1 Kg Soybean, 1 Kg Tree Nut, 1 Kg Wheat";

        String proTipText =
                "Handle allergen ingredients carefully.";

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
         * Verify Recipe Steps & Ingredients
         */
        addRecipe.verifyRecipeStepsIngredientsHeader();

        addRecipe.verifyRecipeStep(
                recipeStep);

        addRecipe.verifyExtractedItemsVerification();

        /*
         * Common Ingredient Details
         */
        String quantity =
                "1.0";

        String unit =
                "Kilogram";

        String note =
                "Automation Test Note";

        /*
         * All Allergen Ingredients
         *
         * These ingredients are present
         * in the Recipe Step and should
         * be extracted by AI.
         */
        String[] allergenIngredients = {
                "Crustacean",
                "Egg",
                "Fish",
                "Milk",
                "Peanut",
                "Sesame",
                "Shellfish",
                "Soybean",
                "Tree Nut",
                "Wheat"
        };

        /*
         * Enter All AI Extracted
         * Allergen Ingredients
         */
        for (String ingredientName :
                allergenIngredients) {

            System.out.println(
                    "Processing allergen ingredient : "
                            + ingredientName);

            addRecipe.enterIngredientDetails(
                    ingredientName,
                    quantity,
                    unit,
                    note);
        }

        /*
         * Verify New Ingredient Addition
         *
         * Salt is intentionally not included
         * in the Recipe Step.
         *
         * This verifies that when AI does not
         * extract an ingredient:
         *
         * 1. Ingredient is not found.
         * 2. Add Ingredient button is clicked.
         * 3. Form scrolls down to the new row.
         * 4. New ingredient is entered.
         * 5. Quantity is entered.
         * 6. Unit is selected.
         * 7. Note is entered.
         */
        String newIngredientName =
                "Salt";

        String newIngredientQuantity =
                "2.0";

        String newIngredientUnit =
                "Kilogram";

        String newIngredientNote =
                "New ingredient automation test.";

        System.out.println(
                "==================================================");

        System.out.println(
                "Testing new ingredient addition : "
                        + newIngredientName);

        addRecipe.enterIngredientDetails(
                newIngredientName,
                newIngredientQuantity,
                newIngredientUnit,
                newIngredientNote);

        System.out.println(
                "New ingredient addition completed : "
                        + newIngredientName);

        System.out.println(
                "==================================================");

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
         * Navigate To Home
         */
        homeDashboard.clickHomeButton();

        Thread.sleep(
                3000);

        /*
         * Logout
         */
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
                "Add Recipe With All Allergen Ingredients "
                        + "test completed successfully.");

        System.out.println(
                "Recipe : "
                        + recipeName);

        System.out.println(
                "AI Extracted Allergen Ingredients :");

        for (String ingredientName :
                allergenIngredients) {

            System.out.println(
                    "1 Kg "
                            + ingredientName);
        }

        System.out.println(
                "Manually Added Ingredient : "
                        + newIngredientName);

        System.out.println(
                "Quantity : "
                        + newIngredientQuantity);

        System.out.println(
                "Unit : "
                        + newIngredientUnit);

        System.out.println(
                "Note : "
                        + newIngredientNote);

        System.out.println(
                "==================================================");

        Thread.sleep(
                500);
    }
}