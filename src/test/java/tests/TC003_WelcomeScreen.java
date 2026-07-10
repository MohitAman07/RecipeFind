package tests;

import base.BaseTest;

import driver.DriverFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObjects.Home.HomeDashboard;
import pagesObjects.Home.RecipeSearch;

public class TC003_WelcomeScreen extends BaseTest {

    @Test
    public void verifyWelcomeScreenComponents()
            throws InterruptedException {

        /*
         * Wait for dashboard to stabilize
         */
        Thread.sleep(3000);

        HomeDashboard dashboard =
                new HomeDashboard(
                        DriverFactory.getDriver());

        RecipeSearch recipeSearch =
                new RecipeSearch(
                        DriverFactory.getDriver());

        /*
         * Verify Welcome Message
         */
                Assert.assertTrue(
                dashboard.isWelcomeMessageVisible(),
                "Welcome message is not displayed.");

        System.out.println(
                "Welcome Message : "
                        + dashboard.getWelcomeMessage());

        /*
         * Verify Welcome Sub Message
         */
        Assert.assertTrue(
                dashboard.isWelcomeSubMessageVisible(),
                "Welcome sub message is not displayed.");

        System.out.println(
                "Welcome sub message displayed successfully.");

        /*
         * Verify Search Field Visibility
         */
        Assert.assertTrue(
                recipeSearch.isSearchFieldVisible(),
                "Search field is not displayed.");

        System.out.println(
                "Search field displayed successfully.");

        /*
         * Verify Search Filter Button Visibility
         */
        Assert.assertTrue(
                recipeSearch.isSearchFilterButtonVisible(),
                "Search filter button is not displayed.");

        System.out.println(
                "Search filter button displayed successfully.");

        /*
         * Verify Search Button Visibility
         */
        Assert.assertTrue(
                recipeSearch.isSearchButtonVisible(),
                "Search button is not displayed.");

        System.out.println(
                "Search button displayed successfully.");

        /*
         * Verify Home Button Visibility
         */
        Assert.assertTrue(
                dashboard.isHomeButtonVisible(),
                "Home button is not displayed.");

        System.out.println(
                "Home button displayed successfully.");

        /*
         * Verify Cookbook Button Visibility
         */
        Assert.assertTrue(
                dashboard.isCookbookButtonVisible(),
                "Cookbook button is not displayed.");

        System.out.println(
                "Cookbook button displayed successfully.");

        /*
         * Click Cookbook Button
         */
        dashboard.clickCookbookButton();

        Thread.sleep(2000);

        System.out.println(
                "Cookbook button clicked successfully.");

        /*
         * Verify Contribute Button Visibility
         */
        Assert.assertTrue(
                dashboard.isContributeButtonVisible(),
                "Contribute button is not displayed.");

        System.out.println(
                "Contribute button displayed successfully.");

        /*
         * Click Contribute Button
         */
        dashboard.clickContributeButton();

        Thread.sleep(2000);

        System.out.println(
                "Contribute button clicked successfully.");

        /*
         * Verify Profile Button Visibility
         */
        Assert.assertTrue(
                dashboard.isProfileButtonVisible(),
                "Profile button is not displayed.");

        System.out.println(
                "Profile button displayed successfully.");

        /*
         * Click Profile Button
         */
        dashboard.clickProfileButton();

        Thread.sleep(2000);

        System.out.println(
                "Profile button clicked successfully.");

        /*
         * Verify Home Button Before Navigation
         */
        Assert.assertTrue(
                dashboard.isHomeButtonVisible(),
                "Home button is not displayed while navigating back.");

        /*
         * Navigate Back To Home
         */
        dashboard.clickHomeButton();

        Thread.sleep(2000);

        System.out.println(
                "Returned back to Home screen successfully.");
    }
}