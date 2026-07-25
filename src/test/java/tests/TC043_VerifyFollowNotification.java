package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.Notification;
import pagesObjects.Home.RecipeSearch;
import pagesObjects.Home.RecipeSearchResult;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC043_VerifyFollowNotification extends BaseTest {

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

        super.setUp(method);
    }

    @Test
    public void verifyFollowNotification()
            throws Exception {

        String recipeName =
                "Basmati Rice";

        String superAdminName =
                "Aman Mohit";

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        RecipeSearch recipeSearch =
                new RecipeSearch(
                        DriverFactory.getDriver());

        RecipeSearchResult searchResult =
                new RecipeSearchResult(
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

        Thread.sleep(2000);

        recipeSearch.clickSearchButton();

        Thread.sleep(4000);

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

        Thread.sleep(3000);

        /*
         * Verify Recipe Card
         */
        ValidationUtil.verifyTrue(
                searchResult.isRecipeDisplayed(
                        recipeName),
                recipeName
                        + " recipe displayed successfully.");

        /*
         * Verify Follow Button
         */
        ValidationUtil.verifyTrue(
                searchResult.isFollowButtonDisplayed(
                        recipeName),
                "Follow button displayed successfully.");

        /*
         * Click Follow Button
         */
        searchResult.clickFollowButton(
                recipeName);

        Thread.sleep(3000);

        System.out.println(
                "Follow button clicked successfully.");

            /*
         * Back To Home Dashboard
         */
        hamburger.clickBackButton();

        Thread.sleep(3000);

        recipeSearch.hideKeyboard();

        Thread.sleep(2000);

        /*
         * Logout Super Admin
         */
        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(2000);

        hamburger.clickSignOut();

        Thread.sleep(8000);

        /*
         * Login As Group Admin
         */
        authenticateUser(
                ConfigReader.getProperty(
                        "groupadmin.email"),
                ConfigReader.getProperty(
                        "groupadmin.password"));

        ensureApplicationReady();

        Thread.sleep(5000);

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

        Thread.sleep(3000);

        /*
         * Verify Notification Screen
         */
        ValidationUtil.verifyTrue(
                notification.isNotificationHeadingDisplayed(),
                "Notification panel opened successfully.");

        /*
         * Verify Follow Notification
         */
        boolean followNotificationFound =
                notification.isFollowNotificationAvailable(
                        superAdminName);

        /*
         * Notification Received
         */
        if (followNotificationFound) {

            ValidationUtil.verifyTrue(
                    true,
                    "Follow notification received successfully.");
        }

        /*
         * Retry Required
         */
        else {

            System.out.println(
                    "Follow notification not found.");

            System.out.println(
                    "Retrying by regenerating notification...");

                /*
             * Close Notification Panel
             */
            notification.clickDismissButton();

            Thread.sleep(2000);

            /*
             * Logout Group Admin
             */
            hamburger.clickHamburgerMenu();

            hamburger.hideKeyboardIfVisible();

            Thread.sleep(2000);

            hamburger.clickSignOut();

            Thread.sleep(8000);

            /*
             * Login As Super Admin Again
             */
            authenticateUser(
                    ConfigReader.getProperty(
                            "superadmin.email"),
                    ConfigReader.getProperty(
                            "superadmin.password"));

            ensureApplicationReady();

            Thread.sleep(5000);

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

            /*
             * Search Recipe Again
             */
            ValidationUtil.verifyTrue(
                    recipeSearch.isSearchFieldVisible(),
                    "Search field displayed successfully.");

            recipeSearch.enterRecipeName(
                    recipeName);

            recipeSearch.hideKeyboard();

            Thread.sleep(2000);

            recipeSearch.clickSearchButton();

            Thread.sleep(4000);

            /*
             * Open Community Tab
             */
            searchResult.clickCommunityTab();

            Thread.sleep(3000);

            /*
             * Verify Recipe Card
             */
            ValidationUtil.verifyTrue(
                    searchResult.isRecipeDisplayed(
                            recipeName),
                    recipeName
                            + " recipe displayed successfully.");

            /*
             * First Click
             * (If already following -> Unfollow)
             * (If not following -> Follow)
             */
            searchResult.clickFollowButton(
                    recipeName);

            Thread.sleep(2000);

            /*
             * Second Click
             * Generates a fresh Follow notification.
             */
            searchResult.clickFollowButton(
                    recipeName);

            Thread.sleep(3000);

            System.out.println(
                    "Fresh follow notification generated.");

            /*
             * Back To Home Dashboard
             */
            hamburger.clickBackButton();

            Thread.sleep(3000);

            /*
             * Clear Search Field
             */
            recipeSearch.clearSearchField();

            recipeSearch.deselectSearchField();

            recipeSearch.hideKeyboard();

            Thread.sleep(2000);

            /*
             * Logout Super Admin
             */
            hamburger.clickHamburgerMenu();

            hamburger.hideKeyboardIfVisible();

            Thread.sleep(2000);

            hamburger.clickSignOut();

            Thread.sleep(8000);

                /*
             * Login As Group Admin Again
             */
            authenticateUser(
                    ConfigReader.getProperty(
                            "groupadmin.email"),
                    ConfigReader.getProperty(
                            "groupadmin.password"));

            ensureApplicationReady();

            Thread.sleep(5000);

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

            Thread.sleep(3000);

            /*
             * Verify Notification Screen
             */
            ValidationUtil.verifyTrue(
                    notification.isNotificationHeadingDisplayed(),
                    "Notification panel opened successfully.");

            /*
             * Verify Follow Notification After Retry
             */
            ValidationUtil.verifyTrue(
                    notification.isFollowNotificationAvailable(
                            superAdminName),
                    "Follow notification received after retry.");

        } // End else

        /*
         * Close Notification Panel
         */
        Thread.sleep(2000);

        notification.clickDismissButton();

        Thread.sleep(2000);

        /*
         * Logout Group Admin
         */
        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(2000);

        hamburger.clickSignOut();

        Thread.sleep(5000);

        System.out.println(
                "==================================================");

        System.out.println(
                "TC043_VerifyFollowNotification executed successfully.");

        System.out.println(
                "==================================================");
    }
}