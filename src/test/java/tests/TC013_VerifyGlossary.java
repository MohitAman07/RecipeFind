package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Glossary;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC013_VerifyGlossary extends BaseTest {

    @Test
    public void verifyGlossaryFunctionality()
            throws InterruptedException {

        System.out.println(
                "==================================================");

        System.out.println(
                "Executing Test Case : verifyGlossaryFunctionality");

        System.out.println(
                "==================================================");

        /*
         * Wait for Dashboard to Stabilize
         */
        Thread.sleep(3000);

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        Glossary glossary =
                new Glossary(
                        DriverFactory.getDriver());

        /*
         * Verify Hamburger Menu
         */
        Assert.assertTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is not displayed.");

        System.out.println(
                "Hamburger menu displayed successfully.");

        /*
         * Open Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        System.out.println(
                "Hamburger menu clicked successfully.");

        Thread.sleep(1000);

        /*
         * Verify Glossary Menu
         */
        Assert.assertTrue(
                hamburger.isGlossaryVisible(),
                "Glossary menu is not displayed.");

        System.out.println(
                "Glossary menu displayed successfully.");

        /*
         * Open Glossary
         */
        hamburger.clickGlossary();

        System.out.println(
                "Glossary menu clicked successfully.");

        Thread.sleep(2000);

        /*
         * Verify Glossary Screen
         */
        Assert.assertTrue(
                glossary.isGlossaryScreenVisible(),
                "Glossary screen is not displayed.");

        System.out.println(
                "Glossary screen displayed successfully.");

        /*
         * Bring Glossary Content Below Header
         */
        glossary.bringGlossaryContentIntoView();

        /*
         * Verify All Glossary Terms
         */
        glossary.getAllGlossaryTerms();

        /*
         * Scroll Back To Top
         */
        glossary.scrollGlossaryToTop();

        /*
         * Verify Back Button
         */
        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed.");

        System.out.println(
                "Back button displayed successfully.");

        /*
         * Navigate Back
         */
        hamburger.clickBackButton();

        System.out.println(
                "Back button clicked successfully.");

        Thread.sleep(2000);

        /*
         * Verify Home Screen
         */
        Assert.assertTrue(
                hamburger.isHamburgerMenuVisible(),
                "Home screen is not displayed after navigating back from Glossary.");

        System.out.println(
                "Successfully navigated back to Home Screen.");

        System.out.println(
                "==================================================");

        System.out.println(
                "Completed Test Case : verifyGlossaryFunctionality");

        System.out.println(
                "==================================================");
    }
}