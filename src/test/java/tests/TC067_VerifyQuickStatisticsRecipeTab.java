package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.HamburgerMenu.QuickStatics;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC067_VerifyQuickStatisticsRecipeTab
        extends BaseTest {

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
    public void verifyQuickStatisticsRecipeTab()
            throws Exception {

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        QuickStatics quickStatics =
                new QuickStatics(
                        DriverFactory.getDriver());

        /*
         * Allow Home Dashboard To Stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Open Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is  displayed.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Open Quick Statistics
         */
        hamburger.clickQuickStatistics();

        Thread.sleep(
                5000);

        /*
         * Verify Analytics Header
         */
        quickStatics.verifyAnalyticsHeader();

        /*
         * Verify Last Updated
         */
        String lastUpdated =
                quickStatics.getLastUpdatedDate();

        ValidationUtil.verifyTrue(
                lastUpdated != null
                        && !lastUpdated.isBlank(),
                "Last updated date is  displayed.");

        /*
         * Open Recipe Tab
         */
        quickStatics.clickRecipeTab();

        Thread.sleep(
                2000);

        /*
         * Verify Content Status Section
         */
        quickStatics.verifyContentStatusHeader();

        /*
         * Verify Top Exported Recipe
         */
        String topExportedRecipe =
                quickStatics.getTopExportedRecipe();

        ValidationUtil.verifyTrue(
                topExportedRecipe != null
                        && !topExportedRecipe.isBlank(),
                "Top exported recipe is  displayed.");

        /*
         * Verify Community Count
         */
        String communityCount =
                quickStatics.getCommunityCount();

        ValidationUtil.verifyTrue(
                communityCount != null
                        && !communityCount.isBlank(),
                "Community count is  displayed.");

        /*
         * Verify AI Count
         */
        String aiCount =
                quickStatics.getAICount();

        ValidationUtil.verifyTrue(
                aiCount != null
                        && !aiCount.isBlank(),
                "AI count is  displayed.");

        /*
         * Verify Published Recipes Count
         */
        String publishedRecipesCount =
                quickStatics.getPublishedRecipesCount();

        ValidationUtil.verifyTrue(
                publishedRecipesCount != null
                        && !publishedRecipesCount.isBlank(),
                "Published recipes count is  displayed.");

        /*
         * Verify Pending Recipes Count
         */
        String pendingRecipesCount =
                quickStatics.getPendingRecipesCount();

        ValidationUtil.verifyTrue(
                pendingRecipesCount != null
                        && !pendingRecipesCount.isBlank(),
                "Pending recipes count is  displayed.");

        /*
         * Verify Pending Delete Recipes Count
         */
        String pendingDeleteRecipesCount =
                quickStatics.getPendingDeleteRecipesCount();

        ValidationUtil.verifyTrue(
                pendingDeleteRecipesCount != null
                        && !pendingDeleteRecipesCount.isBlank(),
                "Pending delete recipes count is  displayed.");

        /*
         * Verify Monthly Recipe Growth
         */
        String monthlyRecipeGrowth =
                quickStatics.getMonthlyRecipeGrowth();

        ValidationUtil.verifyTrue(
                monthlyRecipeGrowth != null
                        && !monthlyRecipeGrowth.isBlank(),
                "Monthly recipe growth is  displayed.");

        /*
         * Mandatory Coordinate Scroll Down
         * To Engagement
         */
        quickStatics.scrollDownToEngagement();

        /*
         * Verify Engagement Section
         */
        quickStatics.verifyEngagementHeader();

        /*
         * Verify Top Liked Recipe
         */
        String topLikedRecipe =
                quickStatics.getTopLikedRecipe();

        ValidationUtil.verifyTrue(
                topLikedRecipe != null
                        && !topLikedRecipe.isBlank(),
                "Top liked recipe is  displayed.");

        /*
         * Verify Top Commented Recipe
         */
        String topCommentedRecipe =
                quickStatics.getTopCommentedRecipe();

        ValidationUtil.verifyTrue(
                topCommentedRecipe != null
                        && !topCommentedRecipe.isBlank(),
                "Top commented recipe is  displayed.");

        /*
         * Verify Top Favorite Recipe
         */
        String topFavoriteRecipe =
                quickStatics.getTopFavoriteRecipe();

        ValidationUtil.verifyTrue(
                topFavoriteRecipe != null
                        && !topFavoriteRecipe.isBlank(),
                "Top favorite recipe is  displayed.");

        /*
         * Verify Recipes With Likes Count
         */
        String recipesWithLikesCount =
                quickStatics.getRecipesWithLikesCount();

        ValidationUtil.verifyTrue(
                recipesWithLikesCount != null
                        && !recipesWithLikesCount.isBlank(),
                "Recipes with likes count is  displayed.");

        /*
         * Verify Recipes With Comments Count
         */
        String recipesWithCommentsCount =
                quickStatics.getRecipesWithCommentsCount();

        ValidationUtil.verifyTrue(
                recipesWithCommentsCount != null
                        && !recipesWithCommentsCount.isBlank(),
                "Recipes with comments count is  displayed.");

        /*
         * Verify Recipes With Favorites Count
         */
        String recipesWithFavoritesCount =
                quickStatics.getRecipesWithFavoritesCount();

        ValidationUtil.verifyTrue(
                recipesWithFavoritesCount != null
                        && !recipesWithFavoritesCount.isBlank(),
                "Recipes with favorites count is  displayed.");

        /*
         * Mandatory Coordinate Scroll Down
         * To Exports/Share
         */
        quickStatics.scrollDownToExportsShare();

        /*
         * Verify Exports/Share Section
         */
        quickStatics.verifyExportsShareHeader();

        /*
         * Verify Total Recipe Exports
         */
        String totalRecipeExports =
                quickStatics.getTotalRecipeExports();

        ValidationUtil.verifyTrue(
                totalRecipeExports != null
                        && !totalRecipeExports.isBlank(),
                "Total recipe exports count is  displayed.");

        /*
         * Verify Most Exported Recipe
         */
        String mostExportedRecipe =
                quickStatics.getMostExportedRecipe();

        ValidationUtil.verifyTrue(
                mostExportedRecipe != null
                        && !mostExportedRecipe.isBlank(),
                "Most exported recipe is  displayed.");

        /*
         * Verify Exports This Month
         */
        String exportsThisMonth =
                quickStatics.getExportsThisMonth();

        ValidationUtil.verifyTrue(
                exportsThisMonth != null
                        && !exportsThisMonth.isBlank(),
                "Exports this month count is  displayed.");

        /*
         * Scroll Up To Analytics
         */
        quickStatics.scrollUpToAnalytics();

        Thread.sleep(
                2000);

        /*
         * Verify Analytics Header
         */
        quickStatics.verifyAnalyticsHeader();

        /*
         * Navigate Back From Analytics
         */
        quickStatics.clickBackButton();

        Thread.sleep(
                2000);

        /*
         * Open Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Logout Super User
         */
        hamburger.clickSignOut();

        Thread.sleep(
                8000);

        System.out.println(
                "==================================================");

        System.out.println(
                "Quick Statistics Recipe tab verified successfully.");

        System.out.println(
                "Last Updated : "
                        + lastUpdated);

        System.out.println(
                "Top Exported Recipe : "
                        + topExportedRecipe);

        System.out.println(
                "Community : "
                        + communityCount);

        System.out.println(
                "AI : "
                        + aiCount);

        System.out.println(
                "Published Recipes : "
                        + publishedRecipesCount);

        System.out.println(
                "Pending Recipes : "
                        + pendingRecipesCount);

        System.out.println(
                "Pending Delete Recipes : "
                        + pendingDeleteRecipesCount);

        System.out.println(
                "Monthly Recipe Growth : "
                        + monthlyRecipeGrowth);

        System.out.println(
                "Top Liked Recipe : "
                        + topLikedRecipe);

        System.out.println(
                "Top Commented Recipe : "
                        + topCommentedRecipe);

        System.out.println(
                "Top Favorite Recipe : "
                        + topFavoriteRecipe);

        System.out.println(
                "Recipes With Likes : "
                        + recipesWithLikesCount);

        System.out.println(
                "Recipes With Comments : "
                        + recipesWithCommentsCount);

        System.out.println(
                "Recipes With Favorites : "
                        + recipesWithFavoritesCount);

        System.out.println(
                "Total Recipe Exports : "
                        + totalRecipeExports);

        System.out.println(
                "Most Exported Recipe : "
                        + mostExportedRecipe);

        System.out.println(
                "Exports This Month : "
                        + exportsThisMonth);

        System.out.println(
                "==================================================");
    }
}