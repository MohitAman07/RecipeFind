package tests;

import base.BaseTest;
import driver.DriverFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.RecipeSearch;
import pagesObjects.Home.RecipeSearchResult;

import java.util.Set;

public class TC004_Searchfield extends BaseTest {

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());
    @Test
    public void verifySearchFieldFunctionality()
            throws InterruptedException {

        System.out.println(
                "==================================================");

        System.out.println(
                "Executing Test Case : verifySearchFieldFunctionality");

        System.out.println(
                "==================================================");

        /*
         * Wait for Home Dashboard to stabilize
         */
        Thread.sleep(3000);

        RecipeSearch recipeSearch =
                new RecipeSearch(
                        DriverFactory.getDriver());

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        /*
         * Verify Search Field Visibility
         */
        Assert.assertTrue(
                recipeSearch.isSearchFieldVisible(),
                "Search field is not displayed.");

        System.out.println(
                "Search field displayed successfully.");

        /*
         * Enter Recipe Name
         */
        recipeSearch.enterRecipeName(
                "Chicken");

        recipeSearch.hideKeyboard();

        Thread.sleep(2000);

        System.out.println(
                "Recipe name entered successfully.");

        /*
         * Verify Search Button Visibility
         */
        Assert.assertTrue(
                recipeSearch.isSearchButtonVisible(),
                "Search button is not displayed.");

        System.out.println(
                "Search button displayed successfully.");

        /*
         * Click Search Button
         */
        recipeSearch.clickSearchButton();

        Thread.sleep(3000);

        System.out.println(
                "Search button clicked successfully.");

        /*
         * Search Results Page
         */
        RecipeSearchResult searchResult =
                new RecipeSearchResult(
                        DriverFactory.getDriver());

        /*
         * Verify Search Results Header
         */
        Assert.assertTrue(
                searchResult.isSearchResultsHeaderVisible(),
                "Search Results header is not displayed.");

        System.out.println(
                "Search Results Header : "
                        + searchResult.getSearchResultsHeader());

        /*
         * Verify Results Text
         */
        Assert.assertTrue(
                searchResult.isResultsTextVisible(),
                "Results text is not displayed.");

        System.out.println(
                "Results Text : "
                        + searchResult.getResultsText());

        /*
         * Verify Community Tab
         */
        Assert.assertTrue(
                searchResult.isCommunityTabVisible(),
                "Community tab is not displayed.");

        System.out.println(
                "Community tab displayed successfully.");

        /*
         * Click Community Tab
         */
        searchResult.clickCommunityTab();

        Thread.sleep(3000);

        System.out.println(
                "Community tab clicked successfully.");

        /*
         * Fetch Community Recipes
         */
        Set<String> communityRecipes =
                searchResult.getAllCommunityResults();

        System.out.println(
                "==================================================");

        System.out.println(
                "Community Recipes");

        System.out.println(
                "==================================================");

        for (String recipe : communityRecipes) {

            System.out.println(recipe);

            System.out.println(
                    "------------------------------------------------");
        }

        System.out.println(
                "Total Community Recipes : "
                        + communityRecipes.size());

        
        hamburger.clickBackButton();
        /*
         * Clear Search Field
         */
        recipeSearch.clearSearchField();

        /*
        * Deselect Search Field
        */
        recipeSearch.deselectSearchField();


        /*
         * Hide Keyboard (removes focus if keyboard appears)
         */
        recipeSearch.hideKeyboard();

        Thread.sleep(1000);

        System.out.println(
                "==================================================");

        System.out.println(
                "Completed Test Case : verifySearchFieldFunctionality");

        System.out.println(
                "==================================================");
    }
}