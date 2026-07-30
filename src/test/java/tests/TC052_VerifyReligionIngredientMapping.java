package tests;

import java.util.List;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.HomeDashboard;
import pagesObjects.Profile.Preferences_Tab;
import utils.ValidationUtil;

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
         * Get Ingredient Inclusion
         */
        List<String> actualIngredientInclusion =
                preferencesTab.getAllIngredientInclusion();

        ValidationUtil.verifyTrue(
                !actualIngredientInclusion.isEmpty(),
                "Ingredient Inclusion populated successfully.");

        /*
         * Get Ingredient Exclusion
         */
        List<String> actualIngredientExclusion =
                preferencesTab.getAllIngredientExclusion();

        ValidationUtil.verifyTrue(
                !actualIngredientExclusion.isEmpty(),
                "Ingredient Exclusion populated successfully.");

        /*
         * Print Ingredient Inclusion
         */
        System.out.println(
                "\n==================================================");

        System.out.println(
                "Ingredient Inclusion");

        System.out.println(
                "--------------------------------------------------");

        actualIngredientInclusion.forEach(
                System.out::println);

        /*
         * Print Ingredient Exclusion
         */
        System.out.println(
                "\n==================================================");

        System.out.println(
                "Ingredient Exclusion");

        System.out.println(
                "--------------------------------------------------");

        actualIngredientExclusion.forEach(
                System.out::println);

        System.out.println(
                "\n==================================================");

        System.out.println(
                "TC052_VerifyReligionIngredientMapping executed successfully.");

        System.out.println(
                "==================================================");
    }
}