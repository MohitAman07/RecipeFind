package tests;

import base.BaseTest;

import driver.DriverFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObjects.Home.RecipeSearch;
import pagesObjects.Home.RecipeSearchResult;

import java.util.Set;

public class TC004_Searchfield extends BaseTest {

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

        Thread.sleep(3000);

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

        /*
         * Verify AI Generated Tab
         */
        Assert.assertTrue(
                searchResult.isAIGeneratedTabVisible(),
                "AI Generated tab is not displayed.");

        System.out.println(
                "AI Generated tab displayed successfully.");

        /*
         * Click AI Generated Tab
         */
        searchResult.clickAIGeneratedTab();

        Thread.sleep(3000);

        System.out.println(
                "AI Generated tab clicked successfully.");

        /*
         * Fetch AI Generated Recipes
         */
        Set<String> aiRecipes =
                searchResult.getAllAIGeneratedResults();

        System.out.println(
                "==================================================");

        System.out.println(
                "AI Generated Recipes");

        System.out.println(
                "==================================================");

        for (String recipe : aiRecipes) {

            System.out.println(recipe);

            System.out.println(
                    "------------------------------------------------");
        }

        System.out.println(
                "Total AI Generated Recipes : "
                        + aiRecipes.size());

        System.out.println(
                "==================================================");

        System.out.println(
                "Completed Test Case : verifySearchFieldFunctionality");

        System.out.println(
                "==================================================");
    }
}