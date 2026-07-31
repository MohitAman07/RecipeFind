package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.HomeDashboard;
import pagesObjects.Profile.Preferences_Tab;
import utils.ValidationUtil;

public class TC053_VerifyIngredientChipDeletion
        extends BaseTest {

    @Test
    public void verifyIngredientChipDeletion()
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
         * Verify Ingredient Inclusion Populated
         */
        ValidationUtil.verifyTrue(
                !preferencesTab.getAllIngredientInclusion()
                        .isEmpty(),
                "Ingredient Inclusion populated successfully.");

        /*
         * Verify Ingredient Exclusion Populated
         */
        ValidationUtil.verifyTrue(
                !preferencesTab.getAllIngredientExclusion()
                        .isEmpty(),
                "Ingredient Exclusion populated successfully.");

        /*
         * Delete Ingredient Inclusion
         */
        preferencesTab.deleteAllIngredientInclusion();

        Thread.sleep(
                2000);

        /*
         * Delete Ingredient Exclusion
         */
        preferencesTab.deleteAllIngredientExclusion();

        Thread.sleep(
                2000);


        System.out.println(
                "==================================================");

        System.out.println(
                "TC053_VerifyIngredientChipDeletion executed successfully.");

        System.out.println(
                "==================================================");
    }
}