package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Contribute.MyRecipiesDashboard.RecipeDetailsPage;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.Notification;
import pagesObjects.Home.RecipeSearch;
import pagesObjects.Home.RecipeSearchResult;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC045_VerifyCommentNotification extends BaseTest {

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
    public void verifyCommentNotification()
            throws Exception {

        String recipeName =
                "Basmati Rice";

        String superAdminName =
                "Aman";

        String comment =
                "Automation Notification "
                        + System.currentTimeMillis();

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        RecipeSearch recipeSearch =
                new RecipeSearch(
                        DriverFactory.getDriver());

        RecipeSearchResult searchResult =
                new RecipeSearchResult(
                        DriverFactory.getDriver());

        RecipeDetailsPage recipeDetails =
                new RecipeDetailsPage(
                        DriverFactory.getDriver());

        Notification notification =
                new Notification(
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
         * Verify Community Tab
         */
        ValidationUtil.verifyTrue(
                searchResult.isCommunityTabVisible(),
                "Community tab displayed successfully.");

        /*
         * Open Community Tab
         */
        searchResult.clickCommunityTab();

        Thread.sleep(
                3000);

        /*
         * Verify Recipe Card
         */
        ValidationUtil.verifyTrue(
                searchResult.isRecipeDisplayed(
                        recipeName),
                recipeName
                        + " recipe displayed successfully.");

        /*
         * Open Recipe
         */

        Thread.sleep(3000);
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

        /*
         * Verify Posted Comment
         */
        ValidationUtil.verifyTrue(
                recipeDetails.isCommentDisplayed(
                        comment),
                "Comment posted successfully.");

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

        recipeSearch.hideKeyboard();

        Thread.sleep(
                2000);

        /*
         * Logout Super Admin
         */
        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(
                2000);

        hamburger.clickSignOut();

        Thread.sleep(
                8000);

        /*
         * Login As Group Admin
         */
        authenticateUser(
                ConfigReader.getProperty(
                        "groupadmin.email"),
                ConfigReader.getProperty(
                        "groupadmin.password"));

        ensureApplicationReady();

        Thread.sleep(
                5000);

        /*
         * Reinitialize Page Objects
         */
        hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        notification =
                new Notification(
                        DriverFactory.getDriver());

        /*
         * Verify Notification Bell
         */
        ValidationUtil.verifyTrue(
                notification.isNotificationBellDisplayed(),
                "Notification Bell displayed successfully.");

        /*
         * Open Notification Panel
         */
        notification.clickNotificationBell();

        Thread.sleep(
                3000);

        /*
         * Verify Notification Screen
         */
        ValidationUtil.verifyTrue(
                notification.isNotificationHeadingDisplayed(),
                "Notification panel opened successfully.");

        /*
         * Verify Comment Notification
         */
        boolean commentNotificationFound =
                notification.isCommentNotificationAvailable(
                        superAdminName,
                        recipeName);

        /*
        * Print Latest Notification
        */
        String latestNotification =
                notification.getLatestNotification();

        System.out.println(
                "Latest Notification :");

System.out.println(
        latestNotification);

        /*
         * Comment Notification Received
         */

        
        if (commentNotificationFound) {

            ValidationUtil.verifyTrue(
                    true,
                    "Comment notification received successfully.");
        }

        /*
         * Retry Required
         */
        else {

            System.out.println(
                    "Comment notification not found.");

            System.out.println(
                    "Retrying by regenerating notification...");

                /*
             * Close Notification Panel
             */
            notification.clickDismissButton();

            Thread.sleep(
                    2000);

            /*
             * Logout Group Admin
             */
            hamburger.clickHamburgerMenu();

            hamburger.hideKeyboardIfVisible();

            Thread.sleep(
                    2000);

            hamburger.clickSignOut();

            Thread.sleep(
                    8000);

            /*
             * Login As Super Admin Again
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
             * Search Recipe Again
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
             * Open Community Tab
             */
            searchResult.clickCommunityTab();

            Thread.sleep(
                    3000);

            /*
             * Open Recipe
             */
            searchResult.openRecipe(
                    recipeName);

            Thread.sleep(
                    4000);

            /*
             * Scroll To Bottom
             */
            recipeDetails.scrollToBottom();

            Thread.sleep(
                    3000);

            /*
             * Open Comment Dashboard
             */
            recipeDetails.clickCommentButton();

            Thread.sleep(
                    3000);

            /*
             * Generate Fresh Comment Notification
             */
            recipeDetails.postComment(
                    "Retry Comment "
                            + System.currentTimeMillis());

            Thread.sleep(
                    3000);

            System.out.println(
                    "Fresh comment notification generated.");

            /*
             * Navigate Back To Home Dashboard
             */
            hamburger.clickBackButton();

            Thread.sleep(
                    2000);

            hamburger.clickBackButton();

            Thread.sleep(
                    2000);

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
            hamburger.clickHamburgerMenu();

            hamburger.hideKeyboardIfVisible();

            Thread.sleep(
                    2000);

            hamburger.clickSignOut();

            Thread.sleep(
                    8000);

            /*
             * Login As Group Admin Again
             */
            authenticateUser(
                    ConfigReader.getProperty(
                            "groupadmin.email"),
                    ConfigReader.getProperty(
                            "groupadmin.password"));

            ensureApplicationReady();

            Thread.sleep(
                    5000);

            /*
             * Reinitialize Page Objects
             */
            hamburger =
                    new Hamburger(
                            DriverFactory.getDriver());

            notification =
                    new Notification(
                            DriverFactory.getDriver());

            /*
             * Verify Notification Bell
             */
            ValidationUtil.verifyTrue(
                    notification.isNotificationBellDisplayed(),
                    "Notification Bell displayed successfully.");

            /*
             * Open Notification Panel
             */
            notification.clickNotificationBell();

            Thread.sleep(
                    3000);

            /*
             * Verify Notification Screen
             */
            ValidationUtil.verifyTrue(
                    notification.isNotificationHeadingDisplayed(),
                    "Notification panel opened successfully.");

            /*
             * Verify Comment Notification After Retry
             */
            ValidationUtil.verifyTrue(
                    notification.isCommentNotificationAvailable(
                            superAdminName,
                            recipeName),
                    "Comment notification received after retry.");

        } // End else

        /*
         * Close Notification Panel
         */
        Thread.sleep(
                2000);

        notification.clickDismissButton();

        Thread.sleep(
                2000);

        /*
         * Logout Group Admin
         */
        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(
                2000);

        hamburger.clickSignOut();

        Thread.sleep(
                5000);

        System.out.println(
                "==================================================");

        System.out.println(
                "TC045_VerifyCommentNotification executed successfully.");

        System.out.println(
                "==================================================");
    }
}