package tests;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Contribute.AddRecipeDashboard.AddRecipe;
import pagesObjects.Contribute.MyRecipiesDashboard.MyRecipes;
import pagesObjects.Contribute.MyRecipiesDashboard.NutritionFactsPage;
import pagesObjects.Contribute.MyRecipiesDashboard.RecipeDetailsPage;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.HomeDashboard;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC077_VerifyNutritionPanelAfterServingChange
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
    public void verifyNutritionPanelAfterServingChange()
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

        RecipeDetailsPage recipeDetailsPage =
                new RecipeDetailsPage(
                        DriverFactory.getDriver());

        /*
         * Generate Unique Recipe Name
         */
        int randomNumber =
                100 + new Random().nextInt(
                        900);

        String recipeName =
                "Automation Nutrition Recipe "
                        + randomNumber;

        String cookingTime =
                "15";

        String servingTime =
                "10";

        String servingLimit =
                "4";

        String changedServing =
                "8";

        String recipeSummary =
                "This is an automation test recipe for Nutrition Facts serving validation.";

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
         * Open Newly Created Recipe
         *
         * Navigate To Recipe Details Page
         */
        myRecipes.openRecipe(
                recipeName);

        Thread.sleep(
                3000);

        /*
         * Verify Nutrition Facts Panel
         *
         * Initial Serving : 4
         */
        ValidationUtil.verifyTrue(
                nutritionFactsPage
                        .verifyCurrentNutritionFacts(
                                recipeName,
                                servingLimit),
                "Nutrition Facts panel is displayed for "
                        + servingLimit
                        + " servings.");

        /*
         * Store Nutrition Values
         * Before Serving Change
         */
        Map<String, String> nutritionBeforeChange =
                new LinkedHashMap<>();

        nutritionBeforeChange.put(
                "Serving Size",
                nutritionFactsPage.getServingSizeValue());

        nutritionBeforeChange.put(
                "Calories",
                nutritionFactsPage.getCaloriesValue());

        nutritionBeforeChange.put(
                "Total Fat",
                nutritionFactsPage.getTotalFatValue());

        nutritionBeforeChange.put(
                "Saturated Fat",
                nutritionFactsPage.getSaturatedFatValue());

        nutritionBeforeChange.put(
                "Trans Fat",
                nutritionFactsPage.getTransFatValue());

        nutritionBeforeChange.put(
                "Cholesterol",
                nutritionFactsPage.getCholesterolValue());

        nutritionBeforeChange.put(
                "Sodium",
                nutritionFactsPage.getSodiumValue());

        nutritionBeforeChange.put(
                "Total Carbohydrate",
                nutritionFactsPage.getTotalCarbohydrateValue());

        nutritionBeforeChange.put(
                "Dietary Fiber",
                nutritionFactsPage.getDietaryFiberValue());

        nutritionBeforeChange.put(
                "Total Sugars",
                nutritionFactsPage.getTotalSugarsValue());

        nutritionBeforeChange.put(
                "Added Sugars",
                nutritionFactsPage.getAddedSugarsValue());

        nutritionBeforeChange.put(
                "Protein",
                nutritionFactsPage.getProteinValue());

        /*
         * Print Nutrition Values
         * Before Serving Change
         */
        System.out.println(
                "==================================================");

        System.out.println(
                "Nutrition Facts Before Serving Change");

        for (Map.Entry<String, String> entry :
                nutritionBeforeChange.entrySet()) {

            System.out.println(
                    entry.getKey()
                            + " : "
                            + entry.getValue());
        }

        System.out.println(
                "==================================================");

        recipeDetailsPage.scrollToTop();

    Thread.sleep(
            1000);

    recipeDetailsPage.scrollToTop();

    Thread.sleep(
            1000);

    recipeDetailsPage.scrollToTop();

    Thread.sleep(
            2000);

        /*
         * Verify Edit Recipe Is Displayed
         */
        ValidationUtil.verifyTrue(
                recipeDetailsPage.isEditRecipeDisplayed(),
                "Edit Recipe option is displayed.");

        /*
         * Click Edit Recipe
         */
        recipeDetailsPage.clickEditRecipe();

        Thread.sleep(
                3000);

        /*
        * Change Serving Limit
        */
        recipeDetailsPage.enterEditServingLimit(
                changedServing);

        Thread.sleep(
                1000);

        /*
         * Scroll Down To Save Button
         *
         * Existing Add Recipe form
         * coordinate scroll method is used.
         */
        addRecipe.scrollAddRecipeFormDown();

        Thread.sleep(
                2000);


        addRecipe.scrollAddRecipeFormDown();

        Thread.sleep(
                2000);

        /*
         * Click Save
         */
        DriverFactory.getDriver()
                .findElement(
                        org.openqa.selenium.By.xpath(
                                "//android.widget.Button[@content-desc=\"Save\"]"))
                .click();

        System.out.println(
                "Recipe changes saved.");

        Thread.sleep(
                4000);

        /*
         * Scroll Down To Nutrition Facts
         *
         * Existing Recipe Details
         

        /*
         * Verify Nutrition Facts Panel
         *
         * Updated Serving : 8
         */
        ValidationUtil.verifyTrue(
                nutritionFactsPage
                        .verifyCurrentNutritionFacts(
                                recipeName,
                                changedServing),
                "Nutrition Facts panel is displayed for "
                        + changedServing
                        + " servings after serving change.");

        /*
         * Store Nutrition Values
         * After Serving Change
         */
        Map<String, String> nutritionAfterChange =
                new LinkedHashMap<>();

        nutritionAfterChange.put(
                "Serving Size",
                nutritionFactsPage.getServingSizeValue());

        nutritionAfterChange.put(
                "Calories",
                nutritionFactsPage.getCaloriesValue());

        nutritionAfterChange.put(
                "Total Fat",
                nutritionFactsPage.getTotalFatValue());

        nutritionAfterChange.put(
                "Saturated Fat",
                nutritionFactsPage.getSaturatedFatValue());

        nutritionAfterChange.put(
                "Trans Fat",
                nutritionFactsPage.getTransFatValue());

        nutritionAfterChange.put(
                "Cholesterol",
                nutritionFactsPage.getCholesterolValue());

        nutritionAfterChange.put(
                "Sodium",
                nutritionFactsPage.getSodiumValue());

        nutritionAfterChange.put(
                "Total Carbohydrate",
                nutritionFactsPage.getTotalCarbohydrateValue());

        nutritionAfterChange.put(
                "Dietary Fiber",
                nutritionFactsPage.getDietaryFiberValue());

        nutritionAfterChange.put(
                "Total Sugars",
                nutritionFactsPage.getTotalSugarsValue());

        nutritionAfterChange.put(
                "Added Sugars",
                nutritionFactsPage.getAddedSugarsValue());

        nutritionAfterChange.put(
                "Protein",
                nutritionFactsPage.getProteinValue());

        /*
         * Print Nutrition Values
         * After Serving Change
         */
        System.out.println(
                "==================================================");

        System.out.println(
                "Nutrition Facts After Serving Change");

        for (Map.Entry<String, String> entry :
                nutritionAfterChange.entrySet()) {

            System.out.println(
                    entry.getKey()
                            + " : "
                            + entry.getValue());
        }

        System.out.println(
                "==================================================");

        /*
         * Compare Nutrition Values
         */
        boolean nutritionChanged =
                false;

        for (String nutritionName :
                nutritionBeforeChange.keySet()) {

            String beforeValue =
                    nutritionBeforeChange.get(
                            nutritionName);

            String afterValue =
                    nutritionAfterChange.get(
                            nutritionName);

            if (beforeValue == null
                    && afterValue == null) {

                continue;
            }

            if (beforeValue == null
                    || !beforeValue.equals(
                            afterValue)) {

                System.out.println(
                        nutritionName
                                + " changed from "
                                + beforeValue
                                + " to "
                                + afterValue);

                nutritionChanged =
                        true;
            } else {

                System.out.println(
                        nutritionName
                                + " remained unchanged : "
                                + beforeValue);
            }
        }

        /*
         * Verify Nutrition Recalculation
         */
        ValidationUtil.verifyTrue(
                nutritionChanged,
                "Nutrition Facts are recalculated after serving value is changed from "
                        + servingLimit
                        + " to "
                        + changedServing
                        + ".");

        System.out.println(
                "==================================================");

        System.out.println(
                "Nutrition Facts Serving Change Validation Completed");

        System.out.println(
                "Recipe : "
                        + recipeName);

        System.out.println(
                "Original Servings : "
                        + servingLimit);

        System.out.println(
                "Updated Servings : "
                        + changedServing);

        System.out.println(
                "Nutrition Values Changed : "
                        + nutritionChanged);

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
                "Verify Nutrition Panel After Serving Change test completed successfully.");

        System.out.println(
                "Recipe created : "
                        + recipeName);

        System.out.println(
                "Nutrition Facts Before : "
                        + servingLimit
                        + " servings");

        System.out.println(
                "Nutrition Facts After : "
                        + changedServing
                        + " servings");

        System.out.println(
                "Nutrition Recalculation : Verified");

        System.out.println(
                "==================================================");

        Thread.sleep(
                500);
    }
}