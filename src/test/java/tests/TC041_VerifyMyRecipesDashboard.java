package tests;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Contribute.MyRecipiesDashboard.MyRecipes;
import pagesObjects.Home.HomeDashboard;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC041_VerifyMyRecipesDashboard extends BaseTest {

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
    public void verifyMyRecipesDashboard() {

        HomeDashboard home =
                new HomeDashboard(
                        DriverFactory.getDriver());

        MyRecipes myRecipes =
                new MyRecipes(
                        DriverFactory.getDriver());

        /*
         * Navigate to My Recipes Dashboard
         */
        ValidationUtil.verifyTrue(
                home.isContributeButtonVisible(),
                "Contribute button is displayed.");

        home.clickContributeButton();

        ValidationUtil.verifyTrue(
                myRecipes.isMyRecipesTabDisplayed(),
                "My Recipes tab is displayed.");

        myRecipes.clickMyRecipesTab();

        /*
         * Verify Dashboard UI
         */
        ValidationUtil.verifyTrue(
                myRecipes.isSearchFieldDisplayed(),
                "Search field is displayed.");

        ValidationUtil.verifyTrue(
                myRecipes.isSortButtonDisplayed(),
                "Sort button is displayed.");

        ValidationUtil.verifyTrue(
                myRecipes.isAllTabDisplayed(),
                "All tab is displayed.");

        ValidationUtil.verifyTrue(
                myRecipes.isSubmittedTabDisplayed(),
                "Submitted tab is displayed.");

        ValidationUtil.verifyTrue(
                myRecipes.isVerifiedTabDisplayed(),
                "Verified tab is displayed.");

        ValidationUtil.verifyTrue(
                myRecipes.isRejectedTabDisplayed(),
                "Rejected tab is displayed.");

        ValidationUtil.verifyTrue(
                myRecipes.isDeletePendingTabDisplayed(),
                "Delete Pending tab is displayed.");

        /*
         * Verify Sort Options
         */
        myRecipes.clickSort();

        ValidationUtil.verifyTrue(
                myRecipes.isNewestDisplayed(),
                "Newest option is displayed.");

        ValidationUtil.verifyTrue(
                myRecipes.isOldestDisplayed(),
                "Oldest option is displayed.");

        ValidationUtil.verifyTrue(
                myRecipes.isNameDisplayed(),
                "Name option is displayed.");

        /*
         * Close Sort Popup
         */
        DriverFactory.getDriver()
                .navigate()
                .back();

        /*
         * Scroll and Load All Recipes
         */
        List<String> recipes =
                myRecipes.getAllRecipes();

        ValidationUtil.verifyTrue(
                recipes.size() > 0,
                "All recipes loaded successfully.");

        /*
         * Search Recipe
         */
        myRecipes.enterSearchText(
                "Grilled Chicken Salad");

        myRecipes.hideKeyboard();

        ValidationUtil.verifyTrue(
                myRecipes.isRecipeDisplayed(
                        "Grilled Chicken Salad"),
                "Recipe is displayed.");

        /*
         * Verify Recipe Actions
         */
        ValidationUtil.verifyTrue(
                myRecipes.isNutritionPanelDisplayed(
                        "Grilled Chicken Salad"),
                "Nutrition Panel is displayed.");

        ValidationUtil.verifyTrue(
                myRecipes.isDeleteNutritionPanelDisplayed(
                        "Grilled Chicken Salad"),
                "Delete Nutrition Panel is displayed.");

        /*
         * Open Recipe
         */
        myRecipes.openRecipe(
                "Grilled Chicken Salad");
    }
}