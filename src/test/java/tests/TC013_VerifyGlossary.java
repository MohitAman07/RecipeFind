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

        /*
         * Wait for dashboard to stabilize
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
         * Bring Glossary Content Below Logo
         */
        glossary.bringGlossaryContentIntoView();

        /*
         * Fetch All Glossary Terms
         */
        glossary.getAllGlossaryTerms();

        /*
         * Scroll Back To Top
         */
        glossary.scrollGlossaryToTop();

        System.out.println(
                "Glossary verification completed successfully.");
    }
}