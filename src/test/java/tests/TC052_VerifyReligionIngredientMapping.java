package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Home.HomeDashboard;
import pagesObjects.Profile.Preferences_Tab;
import utils.ValidationUtil;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC052_VerifyReligionIngredientMapping
        extends BaseTest {

    @Test
    public void verifyReligionIngredientMapping()
            throws Exception {

        HomeDashboard home =
                new HomeDashboard(
                        DriverFactory.getDriver());

        Preferences_Tab preferencesTab =
                new Preferences_Tab(
                        DriverFactory.getDriver());

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        String religion =
                "Buddhism";

        /*
         * Verify Profile Button
         */
        ValidationUtil.verifyTrue(
                home.isProfileButtonVisible(),
                "Profile button displayed successfully.");

        /*
         * Click Profile Button
         */
        home.clickProfileButton();

        Thread.sleep(
                3000);

        /*
         * Verify Preferences Tab
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferencesTabDisplayed(),
                "Preferences Tab displayed successfully.");

        /*
         * Click Preferences Tab
         */
        preferencesTab.clickPreferencesTab();

        Thread.sleep(
                3000);

        /*
         * Verify Preferences Section
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferencesSectionDisplayed(),
                "Preferences Section displayed successfully.");

        /*
         * Select Religion
         */
        preferencesTab.selectReligion(
                religion);

        Thread.sleep(
                3000);

        hamburger.clickBackButton();

        Thread.sleep(
                3000);

        /*
         * Verify Ingredient Inclusion
         */
        ValidationUtil.verifyTrue(
                preferencesTab.verifyReligionIngredientInclusion(
                        religion),
                "Ingredient Inclusion populated successfully.");

        Thread.sleep(
                2000);

        /*
         * Verify Ingredient Exclusion
         */
        ValidationUtil.verifyTrue(
                preferencesTab.verifyReligionIngredientExclusion(
                        religion),
                "Ingredient Exclusion populated successfully.");

        Thread.sleep(
                2000);

        /*
         * Print Visible Ingredient Inclusion
         */
        preferencesTab.printVisibleIngredientInclusion();


        /*
         * Print Visible Ingredient Exclusion
         */
        preferencesTab.printVisibleIngredientExclusion();

        System.out.println(
                "==================================================");

        System.out.println(
                "TC052_VerifyReligionIngredientMapping executed successfully.");

        System.out.println(
                "==================================================");
    }
}