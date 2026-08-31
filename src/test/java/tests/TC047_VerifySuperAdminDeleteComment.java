package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Contribute.MyRecipiesDashboard.MyRecipes;
import pagesObjects.Contribute.MyRecipiesDashboard.RecipeDetailsPage;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.HomeDashboard;
import pagesObjects.Home.RecipeSearch;
import pagesObjects.Home.RecipeSearchResult;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC047_VerifySuperAdminDeleteComment extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    @Override
    public void setUp(
            Method method) {

        loginEmail =
                ConfigReader.getProperty(
                        "groupadmin.email");

        loginPassword =
                ConfigReader.getProperty(
                        "groupadmin.password");

        super.setUp(
                method);
    }

    @Test
    public void verifySuperAdminDeleteGroupAdminComment()
            throws Exception {

        String recipeName =
                "Basmati Rice";

        String comment =
                "Automation Delete Comment "
                        + System.currentTimeMillis();

        HomeDashboard home =
                new HomeDashboard(
                        DriverFactory.getDriver());

        MyRecipes myRecipes =
                new MyRecipes(
                        DriverFactory.getDriver());

        RecipeDetailsPage recipeDetails =
                new RecipeDetailsPage(
                        DriverFactory.getDriver());

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        RecipeSearch recipeSearch =
                new RecipeSearch(
                        DriverFactory.getDriver());

        RecipeSearchResult searchResult =
                new RecipeSearchResult(
                        DriverFactory.getDriver());

        /*
         * Verify Contribute Button
         */
        ValidationUtil.verifyTrue(
                home.isContributeButtonVisible(),
                "Contribute button displayed successfully.");

        /*
         * Open Contribute
         */
        home.clickContributeButton();

        Thread.sleep(
                3000);

        /*
         * Open My Recipes
         */
        myRecipes.clickMyRecipesTab();

        Thread.sleep(
                3000);

        /*
         * Verify Search Field
         */
        ValidationUtil.verifyTrue(
                myRecipes.isSearchFieldDisplayed(),
                "Search field displayed successfully.");

        /*
         * Search Recipe
         */
        myRecipes.enterSearchText(
                recipeName);

        myRecipes.hideKeyboard();

        Thread.sleep(
                2000);

        /*
         * Verify Recipe Displayed
         */
        ValidationUtil.verifyTrue(
                myRecipes.isRecipeDisplayed(
                        recipeName),
                recipeName
                        + " displayed successfully.");

        /*
         * Open Recipe
         */
        myRecipes.openRecipe(
                recipeName);

        Thread.sleep(
                4000);

        /*
         * Verify Recipe Details Page
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isRecipeDisplayed(
                        recipeName),
                "Recipe Details page opened successfully.");

        /*
         * Capture Group Admin Name
         */
        String groupAdminName =
                recipeDetails.getAuthorName();

        System.out.println(
                "Group Admin Name : "
                        + groupAdminName);

        /*
         * Scroll To Bottom
         */
        recipeDetails.scrollToBottom();

        Thread.sleep(
                3000);

        /*
         * Verify Comment Button
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isCommentButtonDisplayed(),
                "Comment button displayed successfully.");

        /*
         * Open Comment Dashboard
         */
        recipeDetails.clickCommentButton();

        Thread.sleep(
                3000);

        /*
         * Verify Comment Field
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isCommentFieldDisplayed(),
                "Comment field displayed successfully.");

        /*
         * Post Comment
         */
        recipeDetails.postComment(
                comment);

        Thread.sleep(
                3000);

        System.out.println(
                "Posted Comment : "
                        + comment);

        /*
         * Verify Posted Comment
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isCommentDisplayed(
                        comment),
                "Posted comment displayed successfully.");

        System.out.println(
                recipeDetails.getComment(
                        comment));

        /*
         * Navigate Back To Recipe Details
         */
        hamburger.clickBackButton();

        Thread.sleep(
                2000);

        /*
         * Navigate Back To My Recipes
         */
        hamburger.clickBackButton();

        Thread.sleep(
                2000);

        /*
         * Logout Group Admin
         */
        Thread.sleep(3000);

        /*
         * Verify Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is displayed.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        hamburger.clickSignOut();

        Thread.sleep(
                8000);

        /*
         * Login As Super Admin
         */
        authenticateUser(
                ConfigReader.getProperty(
                        "superadmin.email"),
                ConfigReader.getProperty(
                        "superadmin.password"));

        ensureApplicationReady();

        Thread.sleep(
                5000);

        /*
         * Reinitialize Page Objects
         */
        hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        recipeSearch =
                new RecipeSearch(
                        DriverFactory.getDriver());

        searchResult =
                new RecipeSearchResult(
                        DriverFactory.getDriver());

        recipeDetails =
                new RecipeDetailsPage(
                        DriverFactory.getDriver());

        /*
         * Verify Search Field
         */
        ValidationUtil.verifyTrue(
                recipeSearch.isSearchFieldVisible(),
                "Search field displayed successfully.");

        /*
         * Search Recipe
         */
        recipeSearch.enterRecipeName(
                recipeName);

        recipeSearch.hideKeyboard();

        Thread.sleep(
                2000);

        recipeSearch.clickSearchButton();

        Thread.sleep(
                4000);

        /*
         * Verify Search Results
         */
        ValidationUtil.verifyTrue(
                searchResult.isSearchResultsHeaderVisible(),
                "Search Results displayed successfully.");

        /*
         * Open Community Tab
         */
        searchResult.clickCommunityTab();

        Thread.sleep(
                3000);

        /*
         * Verify Recipe Displayed
         */
        ValidationUtil.verifyTrue(
                searchResult.isRecipeDisplayed(
                        recipeName),
                recipeName
                        + " recipe displayed successfully.");

        /*
         * Open Recipe
         */
        searchResult.openRecipe(
                recipeName);

        Thread.sleep(
                4000);

        /*
         * Verify Recipe Details Page
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isRecipeDisplayed(
                        recipeName),
                "Recipe Details page opened successfully.");

        /*
         * Scroll To Bottom
         */
        recipeDetails.scrollToBottom();

        Thread.sleep(
                3000);

        /*
         * Verify Comment Button
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isCommentButtonDisplayed(),
                "Comment button displayed successfully.");

        /*
         * Open Comment Dashboard
         */
        recipeDetails.clickCommentButton();

        Thread.sleep(
                3000);

        /*
         * Verify Group Admin Comment
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isCommentDisplayed(
                        comment),
                "Group Admin comment displayed successfully.");

        System.out.println(
                "Group Admin Comment :");

        System.out.println(
                recipeDetails.getComment(
                        comment));

        /*
         * Delete Group Admin Comment
         */
        recipeDetails.deleteCommentThroughSuperRole(
                groupAdminName,
                comment);

        Thread.sleep(
                2000);

        /*
         * Verify Delete Comment Popup
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isDeleteCommentPopupDisplayed(),
                "Delete Comment popup displayed successfully.");

        /*
         * Confirm Delete
         */
        recipeDetails.clickConfirmDelete();

        Thread.sleep(
                3000);

        /*
         * Verify Comment Deleted
         */
        ValidationUtil.verifyFalse(
                recipeDetails.isCommentDisplayed(
                        comment),
                "Group Admin comment deleted successfully.");

        System.out.println(
                "Comment deleted successfully.");

        /*
         * Navigate Back To Recipe Details
         */
        hamburger.clickBackButton();

        Thread.sleep(
                2000);

        /*
         * Navigate Back To Search Results
         */
        hamburger.clickBackButton();

        Thread.sleep(
                2000);

        /*
         * Navigate Back To Home Dashboard
         */
        hamburger.clickBackButton();

        Thread.sleep(
                3000);

        recipeSearch.clearSearchField();

        recipeSearch.deselectSearchField();

        recipeSearch.hideKeyboard();

        Thread.sleep(
                2000);

        /*
         * Logout Super Admin
         */
        Thread.sleep(3000);

        /*
         * Verify Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is displayed.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        hamburger.clickSignOut();

        Thread.sleep(
                5000);

        System.out.println(
                "==================================================");

        System.out.println(
                "TC047_VerifySuperAdminDeleteGroupAdminComment executed successfully.");

        System.out.println(
                "==================================================");
    }
}