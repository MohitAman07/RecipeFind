package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Home.HomeDashboard;
import pagesObjects.Profile.Preferences_Tab;
import utils.ValidationUtil;

public class TC051_VerifyAllergies
        extends BaseTest {

    @Test
    public void verifyAllergies()
            throws Exception {

        HomeDashboard home =
                new HomeDashboard(
                        DriverFactory.getDriver());

        Preferences_Tab preferencesTab =
                new Preferences_Tab(
                        DriverFactory.getDriver());


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
         * Verify Allergies Option
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceOptionDisplayed(
                        "Allergies"),
                "Allergies displayed successfully.");

        /*
         * Verify Allergies Add Button
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceAddButtonDisplayed(
                        3),
                "Allergies Add Button displayed successfully.");

        /*
         * Open Allergies List
         */
        preferencesTab.clickAllergies();

        Thread.sleep(
                2000);

        /*
         * Verify Allergy List
         */
        preferencesTab.verifyAllergyList();

        Thread.sleep(
                2000);

        /*
         * Close Allergy Popup
         */
        preferencesTab.closeSelectionPopup();

        Thread.sleep(
                2000);


        System.out.println(
                "==================================================");

        System.out.println(
                "TC051_VerifyAllergies executed successfully.");

        System.out.println(
                "==================================================");
    }
}