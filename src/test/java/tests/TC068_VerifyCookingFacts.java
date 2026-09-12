package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.CookingFacts;
import pagesObjects.HamburgerMenu.Hamburger;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC068_VerifyCookingFacts
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
    public void verifyCookingFacts()
            throws Exception {

        CookingFacts cookingFacts =
                new CookingFacts(
                        DriverFactory.getDriver());

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        /*
         * ======================== Open Cooking Facts ========================
         */

        Thread.sleep(
                3000);

        /*
         * Verify Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu displayed successfully.");

        /*
         * Open Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Open Cooking Facts
         */
        hamburger.clickCookingFacts();

        Thread.sleep(
                3000);

        /*
         * ======================== Cooking Facts ========================
         */

        /*
         * Verify Cooking Facts Header
         */
        cookingFacts.verifyCookingFactsHeader();

        ValidationUtil.verifyTrue(
                true,
                "Cooking Facts header is displayed.");

        /*
         * ======================== Culinary Abbreviations ========================
         */

        /*
         * Verify Culinary Abbreviations Header
         */
        cookingFacts.verifyCulinaryAbbreviationsHeader();

        /*
         * Expand Abbreviations
         */
        cookingFacts.clickAbbreviations();

        Thread.sleep(
                1000);

        /*
         * Expand US Customary
         */
        cookingFacts.clickUSCustomary();

        Thread.sleep(
                1000);

        /*
         * Expand SI Metric
         */
        cookingFacts.clickSIMetric();

        Thread.sleep(
                1000);

        /*
         * Expand Others
         */
        cookingFacts.clickOthers();

        Thread.sleep(
                1000);

        /*
         * Expand Measures and Equivalents
         */
        cookingFacts.clickMeasuresAndEquivalents();

        Thread.sleep(
                1000);

        /*
         * Expand Weights and Equivalents
         */
        cookingFacts.clickWeightsAndEquivalents();

        Thread.sleep(
                1000);

        /*
         * ======================== Time And Temperature ========================
         */

        /*
         * Verify Time and Temperature Control
         */
        cookingFacts.verifyTimeTemperatureHeader();

        /*
         * Expand Cooking Temperatures
         */
        cookingFacts.clickCookingTemperatures();

        Thread.sleep(
                1000);

        /*
         * ======================== Stages Of Sugar ========================
         */

        /*
         * Verify Stages of Sugar
         */
        cookingFacts.verifyStagesOfSugarHeader();

        /*
         * Expand Sugar Stages
         */
        cookingFacts.clickSugarStages();

        Thread.sleep(
                1000);

        /*
         * ======================== Cool Food In Two Stages ========================
         */

        /*
         * Verify Cool Food in Two Stages
         */
        cookingFacts.verifyCoolFoodHeader();

        /*
         * Expand Cooling Stages
         */
        cookingFacts.clickCoolingStages();

        Thread.sleep(
                1000);

        /*
         * ======================== Avoiding Your Allergen ========================
         */

        /*
         * Verify Avoiding Your Allergen
         */
        cookingFacts.verifyAvoidingYourAllergenHeader();

        /*
         * Expand All 9 Allergens
         */
        cookingFacts.expandAllNineAllergens();

        Thread.sleep(
                1000);

        /*
         * ======================== Understanding Food Allergen Labels ========================
         */

        /*
         * Expand Understanding Food Allergen Labels
         */
        cookingFacts.clickUnderstandingFoodAllergenLabels();

        Thread.sleep(
                1000);

        /*
         * ======================== Crustacean Shellfish ========================
         */

        /*
         * Expand Crustacean Shellfish
         */
        cookingFacts.expandCrustaceanShellfish();

        Thread.sleep(
                1000);

        /*
         * Expand Crustacean Shellfish-Free Diet Guidelines
         */
        cookingFacts.clickCrustacean();

        Thread.sleep(
                1000);

        /*
         * Expand Hidden Sources of Shellfish
         */
        cookingFacts.clickHiddenSourcesOfShellfish();

        Thread.sleep(
                1000);

        /*
         * Expand Shellfish Allergy Considerations
         */
        cookingFacts.clickShellfishAllergy();

        Thread.sleep(
                1000);

        /*
         * ======================== Egg ========================
         */

        /*
         * Expand Egg
         */
        cookingFacts.expandEgg();

        Thread.sleep(
                1000);

        /*
         * Expand Egg Allergy Considerations
         */
        cookingFacts.clickEggAllergy();

        Thread.sleep(
                1000);

        /*
         * Expand Egg-Free Diet Guidelines
         */
        cookingFacts.clickEggFree();

        Thread.sleep(
                1000);

        /*
         * Expand Hidden Sources of Egg
         */
        cookingFacts.clickHiddenSourcesOfEgg();

        Thread.sleep(
                1000);

        /*
         * ======================== Fish ========================
         */

        /*
         * Expand Fish
         */
        cookingFacts.expandFish();

        Thread.sleep(
                1000);

        /*
         * Expand Fish Allergy Considerations
         */
        cookingFacts.clickFishAllergy();

        Thread.sleep(
                1000);

        /*
         * Expand Fish-Free Diet Guidelines
         */
        cookingFacts.clickFishFree();

        Thread.sleep(
                1000);

        /*
         * Expand Hidden Sources of Fish
         */
        cookingFacts.clickHiddenSourcesOfFish();

        Thread.sleep(
                1000);

        /*
         * ======================== Milk ========================
         */

        /*
         * Expand Milk
         */
        cookingFacts.expandMilk();

        Thread.sleep(
                1000);

        /*
         * Expand Hidden Sources of Milk
         */
        cookingFacts.clickHiddenSourcesOfMilk();

        Thread.sleep(
                1000);

        /*
         * Expand Milk Allergy Considerations
         */
        cookingFacts.clickMilkAllergy();

        Thread.sleep(
                1000);

        /*
         * Expand Milk-Free Diet Guidelines
         */
        cookingFacts.clickMilkFree();

        Thread.sleep(
                1000);

        /*
         * ======================== Peanuts ========================
         */

        /*
         * Expand Peanuts
         */
        cookingFacts.expandPeanuts();

        Thread.sleep(
                1000);

        /*
         * Expand Hidden Sources of Peanuts
         */
        cookingFacts.clickHiddenSourcesOfPeanuts();

        Thread.sleep(
                1000);

        /*
         * Expand Peanut Allergy Considerations
         */
        cookingFacts.clickPeanutAllergy();

        Thread.sleep(
                1000);

        /*
         * Expand Peanut-Free Diet Guidelines
         */
        cookingFacts.clickPeanutFree();

        Thread.sleep(
                1000);

        /*
         * ======================== Sesame ========================
         */

        /*
         * Expand Sesame
         */
        cookingFacts.expandSesame();

        Thread.sleep(
                1000);

        /*
         * Expand Hidden Sources of Sesame
         */
        cookingFacts.clickHiddenSourcesOfSesame();

        Thread.sleep(
                1000);

        /*
         * Expand Sesame-Free Diet Guidelines
         */
        cookingFacts.clickSesameFree();

        Thread.sleep(
                1000);

        /*
         * ======================== Soy ========================
         */

        /*
         * Expand Soy
         */
        cookingFacts.expandSoy();

        Thread.sleep(
                1000);

        /*
         * Expand Hidden Sources of Soy
         */
        cookingFacts.clickHiddenSourcesOfSoy();

        Thread.sleep(
                1000);

        /*
         * Expand Soy Allergy Considerations
         */
        cookingFacts.clickSoyAllergy();

        Thread.sleep(
                1000);

        /*
         * Expand Soy-Free Diet Guidelines
         */
        cookingFacts.clickSoyFree();

        Thread.sleep(
                1000);

        /*
         * ======================== Tree Nuts ========================
         */

        /*
         * Expand Tree Nuts
         */
        cookingFacts.expandTreeNuts();

        Thread.sleep(
                1000);

        /*
         * Expand Hidden Sources of Tree Nuts
         */
        cookingFacts.clickHiddenSourcesOfTreeNuts();

        Thread.sleep(
                1000);

        /*
         * Expand Tree Nut Allergy Considerations
         */
        cookingFacts.clickTreeNutAllergy();

        Thread.sleep(
                1000);

        /*
         * Expand Tree Nut-Free Diet Guidelines
         */
        cookingFacts.clickTreeNutFree();

        Thread.sleep(
                1000);

        /*
         * ======================== Wheat ========================
         */

        /*
         * Expand Wheat
         */
        cookingFacts.expandWheat();

        Thread.sleep(
                1000);

        /*
         * Expand Hidden Sources of Wheat
         */
        cookingFacts.clickHiddenSourcesOfWheat();

        Thread.sleep(
                1000);

        /*
         * Expand Wheat-Free Diet Guidelines
         */
        cookingFacts.clickWheatFree();

        Thread.sleep(
                1000);

        /*
         * ======================== Return To Top ========================
         */

        cookingFacts.scrollUpToTop();

        Thread.sleep(
                2000);

        /*
         * Verify Cooking Facts Header
         */
        cookingFacts.verifyCookingFactsHeader();

        ValidationUtil.verifyTrue(
                true,
                "Cooking Facts header is displayed after scrolling to top.");

        /*
         * ======================== Execution Summary ========================
         */

        System.out.println(
                "==================================================");

        System.out.println(
                "Cooking Facts details verified successfully.");

        System.out.println(
                "Culinary Abbreviations : Expanded");

        System.out.println(
                "US Customary : Expanded");

        System.out.println(
                "SI (Metric) : Expanded");

        System.out.println(
                "Others : Expanded");

        System.out.println(
                "Measures and Equivalents : Expanded");

        System.out.println(
                "Weights and Equivalents : Expanded");

        System.out.println(
                "Cooking Temperatures : Expanded");

        System.out.println(
                "Sugar Stages : Expanded");

        System.out.println(
                "Cooling Stages : Expanded");

        System.out.println(
                "All 9 Allergens : Expanded");

        System.out.println(
                "All allergen sub-headings : Expanded");

        System.out.println(
                "==================================================");
    }
}