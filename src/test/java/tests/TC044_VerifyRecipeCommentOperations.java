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
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC044_VerifyRecipeCommentOperations extends BaseTest {

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
    public void verifyRecipeCommentOperations()
            throws Exception {

        String recipeName =
                "Basmati Rice";

        String comment =
                "Automation Comment "
                        + System.currentTimeMillis();

        String updatedComment =
                comment
                        + " Updated";

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

        System.out.println(
                "Recipe searched : "
                        + recipeName);

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
         * Verify Recipe Author
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isAuthorDisplayed(),
                "Recipe author displayed successfully.");

        System.out.println(
                recipeDetails.getAuthorName());

        /*
         * Verify Favourite Button
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isFavouriteButtonDisplayed(),
                "Favourite button displayed successfully.");

        /*
         * Scroll To Bottom
         */
        Thread.sleep(3000);
        recipeDetails.scrollToBottom();

        Thread.sleep(
                3000);

                /*
         * Get Initial Like Count
         */
        String likeCount =
                recipeDetails.getLikeCount();

        System.out.println(
                "Current Like Count : "
                        + likeCount);

        /*
         * Verify Like Button
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isLikeButtonDisplayed(),
                "Like button displayed successfully.");

        /*
         * Get Initial Comment Count
         */
        String commentCount =
                recipeDetails.getCommentCount();

        System.out.println(
                "Current Comment Count : "
                        + commentCount);

        /*
         * Verify Comment Button
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isCommentButtonDisplayed(),
                "Comment button displayed successfully.");


        Thread.sleep(
                2000);

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
         * Edit Comment
         */
        recipeDetails.editComment(
                comment,
                updatedComment);

        Thread.sleep(
                3000);

        /*
         * Verify Updated Comment
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isCommentDisplayed(
                        updatedComment),
                "Updated comment displayed successfully.");

        System.out.println(
                recipeDetails.getComment(
                        updatedComment));

                /*
         * Click Delete Comment
         */
        recipeDetails.clickDeleteComment(
                updatedComment);

        Thread.sleep(
                2000);

        /*
         * Cancel Delete
         */
        recipeDetails.clickCancelDelete();

        Thread.sleep(
                2000);

        /*
         * Verify Updated Comment Still Exists
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isCommentDisplayed(
                        updatedComment),
                "Comment still exists after clicking Cancel.");

        System.out.println(
                recipeDetails.getComment(
                        updatedComment));

        /*
         * Delete Comment Again
         */
        recipeDetails.clickDeleteComment(
                updatedComment);

        Thread.sleep(
                2000);

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
                        updatedComment),
                "Comment deleted successfully.");

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
         * Open Hamburger Menu
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

        /*
         * Sign Out
         */
        hamburger.clickSignOut();

        Thread.sleep(
                5000);

        System.out.println(
                "==================================================");

        System.out.println(
                "TC044_VerifyRecipeCommentOperations executed successfully.");

        System.out.println(
                "==================================================");
    }
}