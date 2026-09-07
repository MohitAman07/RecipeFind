package tests;

import java.lang.reflect.Method;
import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Contribute.AddRecipeDashboard.AddRecipe;
import pagesObjects.Contribute.MyRecipiesDashboard.MyRecipes;
import pagesObjects.Contribute.MyRecipiesDashboard.NutritionFactsPage;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.HomeDashboard;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC076_VerifyNutritionFactsPanel
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
    public void verifyNutritionFactsPanel()
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

        NutritionFactsPage nutritionFactsPage =
                new NutritionFactsPage(
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
                3000);

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
                3000);

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

        System.out.println(
                "==================================================");

        /*
         * Proceed From Ingredients
         */
        addRecipe.clickIngredientsProceed();

        Thread.sleep(
                3000);

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
                3000);

        /*
         * Verify Newly Created Recipe
         */
        ValidationUtil.verifyTrue(
                myRecipes.isRecipeDisplayed(
                        recipeName),
                "Newly created recipe is displayed in My Recipes.");

        System.out.println(
                "Newly created recipe displayed : "
                        + recipeName);

        /*
         * Click Newly Created Recipe
         *
         * Navigate To Recipe Details Page
         */
        myRecipes.openRecipe(
                recipeName);

        Thread.sleep(
                3000);

        /*
         * Verify Complete Nutrition Facts Panel
         *
         * This validation handles:
         *
         * 1. Nutrition Facts Header
         * 2. Recipe Name With Servings
         * 3. Serving Size
         * 4. Calories
         * 5. Total Fat
         * 6. Saturated Fat
         * 7. Trans Fat
         * 8. Cholesterol
         * 9. Sodium
         * 10. Total Carbohydrate
         * 11. Dietary Fiber
         * 12. Total Sugars
         * 13. Added Sugars
         * 14. Protein
         * 15. Ingredients
         * 16. Contains / Allergens
         *
         * Nutrition values are read dynamically
         * from the current UI.
         *
         * Allergens are calculated dynamically
         * from the current Ingredients section.
         */
        ValidationUtil.verifyTrue(
                nutritionFactsPage
                        .verifyCurrentNutritionFacts(
                                recipeName,
                                servingLimit),
                "Complete Nutrition Facts panel is displayed and populated correctly.");

        System.out.println(
                "==================================================");

        System.out.println(
                "Nutrition Facts Panel Validation Completed");

        System.out.println(
                "Recipe : "
                        + recipeName);

        System.out.println(
                "Servings : "
                        + servingLimit);

        /*
         * Get Current Ingredients For Logging
         */
        String currentIngredients =
                nutritionFactsPage
                        .getCurrentIngredients();

        System.out.println(
                "Current Nutrition Facts Ingredients : "
                        + currentIngredients);

        /*
         * Get Expected Allergens For Logging
         */
        String expectedAllergens =
                nutritionFactsPage
                        .getExpectedAllergens(
                                currentIngredients);

        System.out.println(
                "Expected Allergens : "
                        + expectedAllergens);

        /*
         * Get Actual Allergens For Logging
         */
        String currentAllergens =
                nutritionFactsPage
                        .getCurrentContainsAllergens();

        System.out.println(
                "Actual Allergens : "
                        + currentAllergens);

        System.out.println(
                "==================================================");

        /*
         * Logout
         */
        homeDashboard.clickHomeButton();

        Thread.sleep(
                3000);

        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is displayed.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                3000);

        hamburger.clickSignOut();

        System.out.println(
                "==================================================");

        System.out.println(
                "Verify Nutrition Facts Panel test completed successfully.");

        System.out.println(
                "Recipe created : "
                        + recipeName);

        System.out.println(
                "Nutrition Facts : Verified");

        System.out.println(
                "Allergens : Verified");

        System.out.println(
                "==================================================");

        Thread.sleep(
                500);
    }
}