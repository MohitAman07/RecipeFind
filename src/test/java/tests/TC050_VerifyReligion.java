package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Home.HomeDashboard;
import pagesObjects.Profile.Preferences_Tab;
import utils.ValidationUtil;

public class TC050_VerifyReligion
        extends BaseTest {

    @Test
    public void VerifyReligion()
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
         * Verify Dietary Preference Option
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceOptionDisplayed(
                        "Dietary Preference"),
                "Dietary Preference displayed successfully.");

        /*
         * Verify Dietary Preference Add Button
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceAddButtonDisplayed(
                        1),
                "Dietary Preference Add Button displayed successfully.");

        /*
         * Open Dietary Preference List
         */
        preferencesTab.clickDietaryPreference();

        Thread.sleep(
                2000);

        /*
         * Verify Dietary Preference List
         */
        preferencesTab.verifyDietaryPreferenceList();

        Thread.sleep(
                2000);

        /*
         * Close Dietary Preference Popup
         */
        preferencesTab.closeSelectionPopup();

        Thread.sleep(
                2000);

        /*
         * Verify Religion Option
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceOptionDisplayed(
                        "Religion"),
                "Religion displayed successfully.");

        /*
         * Verify Religion Add Button
         */
        ValidationUtil.verifyTrue(
                preferencesTab.isPreferenceAddButtonDisplayed(
                        2),
                "Religion Add Button displayed successfully.");

        /*
         * Open Religion List
         */
        preferencesTab.clickReligion();

        Thread.sleep(
                2000);

        /*
         * Verify Religion List
         */
        preferencesTab.verifyReligionList();

        Thread.sleep(
                2000);

        /*
         * Close Religion Popup
         */
        preferencesTab.closeSelectionPopup();


        System.out.println(
                "==================================================");

        System.out.println(
                "TC050_VerifyReligion executed successfully.");

        System.out.println(
                "==================================================");
    }
}