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

public class TC068_VerifyCookingFacts extends BaseTest {

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
         * Allow Home Dashboard To Stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Open Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu displayed successfully.");

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
         * Verify Cooking Facts Header
         */
        cookingFacts.verifyCookingFactsHeader();

        /*
         * Verify Culinary Abbreviations &
         * Measures / Equivalents
         */
        cookingFacts.verifyCulinaryAbbreviationsHeader();

        /*
         * Verify Abbreviations
         */
        cookingFacts.clickAbbreviations();

        Thread.sleep(
                1000);

        /*
         * Verify Measures And Equivalents
         */
        cookingFacts.clickMeasuresAndEquivalents();

        Thread.sleep(
                1000);

        /*
         * Verify Weights And Equivalents
         */
        cookingFacts.clickWeightsAndEquivalents();

        Thread.sleep(
                1000);

        /*
         * Verify Time And Temperature Control
         */
        cookingFacts.verifyTimeTemperatureHeader();

        /*
         * Verify Cooking Temperatures
         */
        cookingFacts.clickCookingTemperatures();

        Thread.sleep(
                1000);

        /*
         * Verify Stages Of Sugar
         */
        cookingFacts.verifyStagesOfSugarHeader();

        /*
         * Verify Sugar Stages
         */
        cookingFacts.clickSugarStages();

        Thread.sleep(
                1000);

        /*
         * Verify Cool Food In Two Stages
         */
        cookingFacts.verifyCoolFoodHeader();

        /*
         * Verify Cooling Stages
         */
        cookingFacts.clickCoolingStages();

        Thread.sleep(
                1000);

        /*
         * Verify Avoiding Your Allergen
         */
        cookingFacts.verifyAvoidingYourAllergenHeader();

        /*
         * Verify Crustacean Shellfish-Free
         * Diet Guidelines
         */
        cookingFacts.clickCrustacean();

        Thread.sleep(
                1000);

        /*
         * Verify Egg Allergy Considerations
         */
        cookingFacts.clickEggAllergy();

        Thread.sleep(
                1000);

        /*
         * Verify Egg-Free Diet Guidelines
         */
        cookingFacts.clickEggFree();

        Thread.sleep(
                1000);

        /*
         * Verify Fish Allergy Considerations
         */
        cookingFacts.clickFishAllergy();

        Thread.sleep(
                1000);

        /*
         * Verify Fish-Free Diet Guidelines
         */
        cookingFacts.clickFishFree();

        Thread.sleep(
                1000);

        /*
         * Verify Hidden Sources Of Egg
         */
        cookingFacts.clickHiddenSourcesOfEgg();

        Thread.sleep(
                1000);

        /*
         * Verify Hidden Sources Of Fish
         */
        cookingFacts.clickHiddenSourcesOfFish();

        Thread.sleep(
                1000);

        /*
         * Verify Hidden Sources Of Milk
         */
        cookingFacts.clickHiddenSourcesOfMilk();

        Thread.sleep(
                1000);

        /*
         * Verify Hidden Sources Of Peanuts
         */
        cookingFacts.clickHiddenSourcesOfPeanuts();

        Thread.sleep(
                1000);

        /*
         * Verify Hidden Sources Of Sesame
         */
        cookingFacts.clickHiddenSourcesOfSesame();

        Thread.sleep(
                1000);

        /*
         * Verify Hidden Sources Of Shellfish
         */
        cookingFacts.clickHiddenSourcesOfShellfish();

        Thread.sleep(
                1000);

        /*
         * Verify Hidden Sources Of Soy
         */
        cookingFacts.clickHiddenSourcesOfSoy();

        Thread.sleep(
                1000);

        /*
         * Verify Hidden Sources Of Tree Nuts
         */
        cookingFacts.clickHiddenSourcesOfTreeNuts();

        Thread.sleep(
                1000);

        /*
         * Verify Hidden Sources Of Wheat
         */
        cookingFacts.clickHiddenSourcesOfWheat();

        Thread.sleep(
                1000);

        /*
         * Verify Milk Allergy Considerations
         */
        cookingFacts.clickMilkAllergy();

        Thread.sleep(
                1000);

        /*
         * Verify Milk-Free Diet Guidelines
         */
        cookingFacts.clickMilkFree();

        Thread.sleep(
                1000);

        /*
         * Verify Peanut Allergy Considerations
         */
        cookingFacts.clickPeanutAllergy();

        Thread.sleep(
                1000);

        /*
         * Verify Peanut-Free Diet Guidelines
         */
        cookingFacts.clickPeanutFree();

        Thread.sleep(
                1000);

        /*
         * Verify Sesame-Free Diet Guidelines
         */
        cookingFacts.clickSesameFree();

        Thread.sleep(
                1000);

        /*
         * Verify Shellfish Allergy Considerations
         */
        cookingFacts.clickShellfishAllergy();

        Thread.sleep(
                1000);

        /*
         * Verify Soy Allergy Considerations
         */
        cookingFacts.clickSoyAllergy();

        Thread.sleep(
                1000);

        /*
         * Verify Soy-Free Diet Guidelines
         */
        cookingFacts.clickSoyFree();

        Thread.sleep(
                1000);

        /*
         * Verify Tree Nut Allergy Considerations
         */
        cookingFacts.clickTreeNutAllergy();

        Thread.sleep(
                1000);

        /*
         * Verify Tree Nut-Free Diet Guidelines
         */
        cookingFacts.clickTreeNutFree();

        Thread.sleep(
                1000);

        /*
         * Verify Understanding Food Allergen Labels
         */
        cookingFacts.clickUnderstandingFoodAllergenLabels();

        Thread.sleep(
                1000);

        /*
         * Verify Wheat-Free Diet Guidelines
         */
        cookingFacts.clickWheatFree();

        Thread.sleep(
                1000);

        /*
         * Scroll To Top
         */
        cookingFacts.scrollUpToTop();

        Thread.sleep(
                2000);

        /*
         * Verify Cooking Facts Header
         */
        cookingFacts.verifyCookingFactsHeader();

        System.out.println(
                "==================================================");

        System.out.println(
                "Cooking Facts details verified successfully.");

        System.out.println(
                "All Cooking Facts sections and accordions verified.");

        System.out.println(
                "==================================================");

    }
}