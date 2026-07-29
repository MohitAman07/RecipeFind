package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Home.HomeDashboard;
import pagesObjects.Profile.Preferences_Tab;
import utils.ValidationUtil;

public class TC049_VerifyDietaryPreference
        extends BaseTest {

    @Test
    public void verifyDietaryPreference()
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
         * Verify Dietary Preference Categories
         */
        preferencesTab.verifyDietaryPreferenceList();

        Thread.sleep(
                2000);

        /*
         * Close Dietary Preference List
         */
        DriverFactory.getDriver()
                .navigate()
                .back();

        Thread.sleep(
                2000);

        System.out.println(
                "==================================================");

        System.out.println(
                "TC049_VerifyDietaryPreference executed successfully.");

        System.out.println(
                "==================================================");
    }
}