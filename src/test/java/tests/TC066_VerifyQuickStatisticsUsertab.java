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

public class TC066_VerifyQuickStatisticsUsertab
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
    public void verifyQuickStatisticsUserTab()
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
         * ======================== User Tab ========================
         */

        /*
         * Click User Tab
         */
        quickStatics.clickUserTab();

        Thread.sleep(
                2000);

        /*
         * ======================== Account Section ========================
         */

        /*
         * Verify Account Header
         */
        quickStatics.verifyAccountHeader();

        /*
         * Verify Total New Users
         */
        String totalNewUsers =
                quickStatics.getTotalNewUserCount();

        ValidationUtil.verifyTrue(
                totalNewUsers != null
                        && !totalNewUsers.isBlank(),
                "Total new users count is displayed.");

        /*
         * Verify Monthly User Growth
         */
        String monthlyUserGrowth =
                quickStatics.getMonthlyUserGrowth();

        ValidationUtil.verifyTrue(
                monthlyUserGrowth != null
                        && !monthlyUserGrowth.isBlank(),
                "Monthly user growth is displayed.");

        /*
         * ======================== Subscription Section ========================
         */

        /*
         * Verify Subscription Header
         */
        quickStatics.verifySubscriptionsHeader();

        /*
         * Verify Active Subscriptions
         */
        String activeSubscriptions =
                quickStatics.getActiveSubscriptionCount();

        ValidationUtil.verifyTrue(
                activeSubscriptions != null
                        && !activeSubscriptions.isBlank(),
                "Active subscription count is displayed.");

        /*
         * Verify Expired Subscriptions
         */
        String expiredSubscriptions =
                quickStatics.getExpiredSubscriptionCount();

        ValidationUtil.verifyTrue(
                expiredSubscriptions != null
                        && !expiredSubscriptions.isBlank(),
                "Expired subscription count is displayed.");

        /*
         * Verify Auto Renew Enabled
         */
        String autoRenewEnabled =
                quickStatics.getAutoRenewEnabledCount();

        ValidationUtil.verifyTrue(
                autoRenewEnabled != null
                        && !autoRenewEnabled.isBlank(),
                "Auto renew enabled count is displayed.");

        /*
         * Verify Auto Renew Disabled
         */
        String autoRenewDisabled =
                quickStatics.getAutoRenewDisabledCount();

        ValidationUtil.verifyTrue(
                autoRenewDisabled != null
                        && !autoRenewDisabled.isBlank(),
                "Auto renew disabled count is displayed.");

        /*
         * Verify Monthly Subscription Growth
         */
        String monthlySubscriptionGrowth =
                quickStatics.getMonthlySubscriptionGrowth();

        ValidationUtil.verifyTrue(
                monthlySubscriptionGrowth != null
                        && !monthlySubscriptionGrowth.isBlank(),
                "Monthly subscription growth is displayed.");

        /*
         * ======================== Social And Community ========================
         */

        /*
         * Mandatory Coordinate Scroll Down
         * To Social And Community
         */
        quickStatics.scrollDownToSocialCommunity();

        /*
         * Verify Social And Community Header
         */
        quickStatics.verifySocialCommunityHeader();

        /*
         * Verify Users With Followers
         */
        String usersWithFollowers =
                quickStatics.getUsersWithFollowersCount();

        ValidationUtil.verifyTrue(
                usersWithFollowers != null
                        && !usersWithFollowers.isBlank(),
                "Users with followers count is displayed.");

        /*
         * Verify Highest Followers
         */
        String highestFollowers =
                quickStatics.getHighestFollowersPerson();

        ValidationUtil.verifyTrue(
                highestFollowers != null
                        && !highestFollowers.isBlank(),
                "Highest followers information is displayed.");

        /*
         * Verify Top Contributor
         */
        String topContributor =
                quickStatics.getTopContributor();

        ValidationUtil.verifyTrue(
                topContributor != null
                        && !topContributor.isBlank(),
                "Top contributor information is displayed.");

        /*
         * Verify Most Liked Contributor
         */
        String mostLikedContributor =
                quickStatics.getMostLikedContributor();

        ValidationUtil.verifyTrue(
                mostLikedContributor != null
                        && !mostLikedContributor.isBlank(),
                "Most liked contributor information is displayed.");

        /*
         * Verify Total Groups
         */
        String totalGroups =
                quickStatics.getTotalGroupsCount();

        ValidationUtil.verifyTrue(
                totalGroups != null
                        && !totalGroups.isBlank(),
                "Total groups count is displayed.");

        /*
         * Verify Group With Most Recipes
         */
        String groupWithMostRecipes =
                quickStatics.getGroupWithMostRecipes();

        ValidationUtil.verifyTrue(
                groupWithMostRecipes != null
                        && !groupWithMostRecipes.isBlank(),
                "Group with most recipes information is displayed.");

        /*
         * ======================== Return To Top ========================
         */

        /*
         * Scroll Back To Top
         */
        quickStatics.scrollUpToTop();

        Thread.sleep(
                2000);

        /*
         * Verify Analytics Header After Scroll Up
         */
        quickStatics.verifyAnalyticsHeader();

        /*
         * ======================== Navigate Back ========================
         */

        /*
         * Navigate Back From Quick Statistics
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
                "Quick Statistics User Tab verified successfully.");

        System.out.println(
                "Analytics Header : Verified");

        System.out.println(
                "Last Updated : "
                        + lastUpdated);

        System.out.println(
                "Total New Users : "
                        + totalNewUsers);

        System.out.println(
                "Monthly User Growth : "
                        + monthlyUserGrowth);

        System.out.println(
                "Active Subscriptions : "
                        + activeSubscriptions);

        System.out.println(
                "Expired Subscriptions : "
                        + expiredSubscriptions);

        System.out.println(
                "Auto Renew Enabled : "
                        + autoRenewEnabled);

        System.out.println(
                "Auto Renew Disabled : "
                        + autoRenewDisabled);

        System.out.println(
                "Monthly Subscription Growth : "
                        + monthlySubscriptionGrowth);

        System.out.println(
                "Users With Followers : "
                        + usersWithFollowers);

        System.out.println(
                "Highest Followers : "
                        + highestFollowers);

        System.out.println(
                "Top Contributor : "
                        + topContributor);

        System.out.println(
                "Most Liked Contributor : "
                        + mostLikedContributor);

        System.out.println(
                "Total Groups : "
                        + totalGroups);

        System.out.println(
                "Group With Most Recipes : "
                        + groupWithMostRecipes);

        System.out.println(
                "==================================================");
    }
}