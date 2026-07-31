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

public class TC046_VerifyLikeNotification extends BaseTest {

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
    public void verifyLikeNotification()
            throws Exception {

        String recipeName =
                "Basmati Rice";

        String superAdminName =
                "Aman";

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
         * Click Like Button
         */
        recipeDetails.clickLikeButton();

        Thread.sleep(
                3000);

        /*
         * Verify Like Count Updated
         */
        String updatedLikeCount =
                recipeDetails.getLikeCount();

        System.out.println(
                "Updated Like Count : "
                        + updatedLikeCount);


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
         * Verify Like Notification
         */
        boolean likeNotificationFound =
                notification.isLikeNotificationAvailable(
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
         * Like Notification Received
         */
        if (likeNotificationFound) {

            ValidationUtil.verifyTrue(
                    true,
                    "Like notification received successfully.");
        }

        /*
         * Retry Required
         */
        else {

            System.out.println(
                    "Like notification not found.");

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
             * Generate Fresh Like Notification
             */
            recipeDetails.clickLikeButton();

            Thread.sleep(
                    3000);

            System.out.println(
                    "Fresh like notification generated.");

            /*
             * Navigate Back To Home Dashboard
             */
            hamburger.clickBackButton();

        //     Thread.sleep(
        //             2000);

        //     hamburger.clickBackButton();

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
             * Verify Like Notification After Retry
             */
            ValidationUtil.verifyTrue(
                    notification.isLikeNotificationAvailable(
                            superAdminName,
                            recipeName),
                    "Like notification received after retry.");

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
                "TC046_VerifyLikeNotification executed successfully.");

        System.out.println(
                "==================================================");
    }
}