package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Home.HomeDashboard;
import pagesObjects.Profile.Preferences_Tab;
import utils.ValidationUtil;

public class TC049_VerifyPreferencesTab
        extends BaseTest {

    @Test
    public void verifyPreferencesTabDetails()
            throws Exception {

        HomeDashboard home =
                new HomeDashboard(
                        DriverFactory.getDriver());

        Preferences_Tab preferencesTab =
                new Preferences_Tab(
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
                "Preferences section displayed successfully.");

        System.out.println(
                preferencesTab.getPreferencesDetails());

                        /*
         * Verify Dietary Preference Option
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceOptionDisplayed(
                        "Dietary Preference"),
                "Dietary Preference displayed successfully.");

        /*
         * Verify Religion Option
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceOptionDisplayed(
                        "Religion"),
                "Religion displayed successfully.");

        /*
         * Verify Allergies Option
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceOptionDisplayed(
                        "Allergies"),
                "Allergies displayed successfully.");

        /*
         * Verify Ingredient Inclusion Option
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceOptionDisplayed(
                        "Ingredient Inclusion"),
                "Ingredient Inclusion displayed successfully.");

        /*
         * Verify Ingredient Exclusion Option
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceOptionDisplayed(
                        "Ingredient Exclusion"),
                "Ingredient Exclusion displayed successfully.");

        /*
         * Verify Custom Include Option
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceOptionDisplayed(
                        "Custom Include"),
                "Custom Include displayed successfully.");

        /*
         * Verify Custom Exclude Option
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceOptionDisplayed(
                        "Custom Exclude"),
                "Custom Exclude displayed successfully.");

        /*
         * Verify All Preference Add Buttons
         */
        ValidationUtil.verifyTrue(
                preferencesTab.areAllPreferenceButtonsDisplayed(),
                "All Preference Add Buttons displayed successfully.");

                        /*
         * Verify Dietary Preference List
         */
        preferencesTab.verifyDietaryCategories();

        Thread.sleep(
                2000);

        /*
         * Verify Religion List
         */
        preferencesTab.verifyReligionList();

        Thread.sleep(
                2000);

        /*
         * Verify Allergy List
         */
        preferencesTab.verifyAllergyList();

        Thread.sleep(
                2000);

        /*
         * Select Buddhism Religion
         */
        preferencesTab.selectReligion(
                religion);

        Thread.sleep(
                3000);

        /*
         * Print Religion Mapping
         */
        preferencesTab.printReligionMapping(
                religion);

        /*
         * Verify Religion Mapping Exists
         */
        ValidationUtil.verifyTrue(
                preferencesTab.hasReligionMapping(
                        religion),
                "Religion mapping verified successfully.");

                        /*
         * Verify Ingredient Inclusion
         */
        ValidationUtil.verifyTrue(
                preferencesTab.verifyReligionIngredientInclusion(
                        religion),
                "Ingredient Inclusion populated successfully.");

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
         * Delete All Ingredient Inclusion
         */
        preferencesTab.deleteAllIngredientInclusion();

        Thread.sleep(
                3000);

        /*
         * Delete All Ingredient Exclusion
         */
        preferencesTab.deleteAllIngredientExclusion();

        Thread.sleep(
                3000);

        /*
         * Scroll To Top
         */
        preferencesTab.scrollToTop();

        Thread.sleep(
                2000);

        System.out.println(
                "==================================================");

        System.out.println(
                "TC049_VerifyPreferencesTab executed successfully.");

        System.out.println(
                "==================================================");
    }
}