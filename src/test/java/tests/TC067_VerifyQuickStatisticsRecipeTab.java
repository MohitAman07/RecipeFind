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
         * ======================== Open Quick Statistics ========================
         */

        /*
         * Allow Home Dashboard To Stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Verify Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is displayed.");

        /*
         * Open Hamburger Menu
         */
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
         * ======================== Analytics ========================
         */

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
                "Last updated date is displayed.");

        /*
         * ======================== Recipe Tab ========================
         */

        /*
         * Click Recipe Tab
         */
        quickStatics.clickRecipeTab();

        Thread.sleep(
                2000);

        /*
         * ======================== Content Status ========================
         */

        /*
         * Verify Content Status Header
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
                "Top exported recipe is displayed.");

        /*
         * Verify Community Count
         */
        String communityCount =
                quickStatics.getCommunityCount();

        ValidationUtil.verifyTrue(
                communityCount != null
                        && !communityCount.isBlank(),
                "Community count is displayed.");

        /*
         * Verify Verified Recipes Count
         */
        String verifiedRecipesCount =
                quickStatics.getVerifiedRecipesCount();

        ValidationUtil.verifyTrue(
                verifiedRecipesCount != null
                        && !verifiedRecipesCount.isBlank(),
                "Verified recipes count is displayed.");

        /*
         * Verify Pending Recipes Count
         */
        String pendingRecipesCount =
                quickStatics.getPendingRecipesCount();

        ValidationUtil.verifyTrue(
                pendingRecipesCount != null
                        && !pendingRecipesCount.isBlank(),
                "Pending recipes count is displayed.");

        /*
         * Verify AI Recipes Count
         */
        String aiCount =
                quickStatics.getAICount();

        ValidationUtil.verifyTrue(
                aiCount != null
                        && !aiCount.isBlank(),
                "AI recipes count is displayed.");

        /*
         * Verify Shared Recipes Count
         */
        String sharedCount =
                quickStatics.getSharedCount();

        ValidationUtil.verifyTrue(
                sharedCount != null
                        && !sharedCount.isBlank(),
                "Shared recipes count is displayed.");

        /*
         * Verify Monthly Recipe Growth
         */
        String monthlyRecipeGrowth =
                quickStatics.getMonthlyRecipeGrowth();

        ValidationUtil.verifyTrue(
                monthlyRecipeGrowth != null
                        && !monthlyRecipeGrowth.isBlank(),
                "Monthly recipe growth is displayed.");

        /*
         * ======================== Engagement ========================
         */

        /*
         * Mandatory Coordinate Scroll Down
         * To Engagement
         */
        quickStatics.scrollDownToEngagement();

        /*
         * Verify Engagement Header
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
                "Top liked recipe is displayed.");

        /*
         * Verify Top Commented Recipe
         */
        String topCommentedRecipe =
                quickStatics.getTopCommentedRecipe();

        ValidationUtil.verifyTrue(
                topCommentedRecipe != null
                        && !topCommentedRecipe.isBlank(),
                "Top commented recipe is displayed.");

        /*
         * Verify Top Favorite Recipe
         */
        String topFavoriteRecipe =
                quickStatics.getTopFavoriteRecipe();

        ValidationUtil.verifyTrue(
                topFavoriteRecipe != null
                        && !topFavoriteRecipe.isBlank(),
                "Top favorite recipe is displayed.");

        /*
         * Verify Recipes With Likes Count
         */
        String recipesWithLikesCount =
                quickStatics.getRecipesWithLikesCount();

        ValidationUtil.verifyTrue(
                recipesWithLikesCount != null
                        && !recipesWithLikesCount.isBlank(),
                "Recipes with likes count is displayed.");

        /*
         * Verify Recipes With Comments Count
         */
        String recipesWithCommentsCount =
                quickStatics.getRecipesWithCommentsCount();

        ValidationUtil.verifyTrue(
                recipesWithCommentsCount != null
                        && !recipesWithCommentsCount.isBlank(),
                "Recipes with comments count is displayed.");

        /*
         * Verify Recipes With Favorites Count
         */
        String recipesWithFavoritesCount =
                quickStatics.getRecipesWithFavoritesCount();

        ValidationUtil.verifyTrue(
                recipesWithFavoritesCount != null
                        && !recipesWithFavoritesCount.isBlank(),
                "Recipes with favorites count is displayed.");

        /*
         * ======================== Exports / Share ========================
         */

        /*
         * Mandatory Coordinate Scroll Down
         * To Exports/Share
         */
        quickStatics.scrollDownToExportsShare();

        /*
         * Verify Exports/Share Header
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
                "Total recipe exports count is displayed.");

        /*
         * Verify Most Exported Recipe
         */
        String mostExportedRecipe =
                quickStatics.getMostExportedRecipe();

        ValidationUtil.verifyTrue(
                mostExportedRecipe != null
                        && !mostExportedRecipe.isBlank(),
                "Most exported recipe is displayed.");

        /*
         * Verify Exports This Month
         */
        String exportsThisMonth =
                quickStatics.getExportsThisMonth();

        ValidationUtil.verifyTrue(
                exportsThisMonth != null
                        && !exportsThisMonth.isBlank(),
                "Exports this month count is displayed.");

        /*
         * ======================== Return To Analytics ========================
         */

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
         * ======================== Navigate Back ========================
         */

        /*
         * Navigate Back From Analytics
         */
        quickStatics.clickBackButton();

        Thread.sleep(
                2000);

        /*
         * ======================== Logout ========================
         */

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

        /*
         * ======================== Execution Summary ========================
         */

        System.out.println(
                "==================================================");

        System.out.println(
                "Quick Statistics Recipe Tab verified successfully.");

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
                "Verified Recipes : "
                        + verifiedRecipesCount);

        System.out.println(
                "Pending Recipes : "
                        + pendingRecipesCount);

        System.out.println(
                "AI Recipes : "
                        + aiCount);

        System.out.println(
                "Shared Recipes : "
                        + sharedCount);

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