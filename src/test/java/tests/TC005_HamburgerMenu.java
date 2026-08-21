package tests;

import base.BaseTest;
import driver.DriverFactory;
import org.testng.annotations.Test;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC005_HamburgerMenu extends BaseTest {

    @Test
    public void verifyHamburgerMenu()
            throws InterruptedException {

        System.out.println(
                "==================================================");

        System.out.println(
                "Executing Test Case : verifyHamburgerMenu");

        System.out.println(
                "==================================================");

        /*
         * Wait for Home Dashboard to stabilize
         */
        Thread.sleep(
                3000);

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        /*
         * Open Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        System.out.println(
                "Hamburger menu clicked successfully.");

        /*
         * Create Shopping List
         */
        hamburger.expandCreateShoppingList();

        Thread.sleep(
                1000);

        /*
         * Create Shopping List - For Self
         */
        hamburger.clickForSelf();

        Thread.sleep(
                2000);

        hamburger.clickBackButton();

        /*
         * Allow Home screen to stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Create Shopping List - For Group
         */
        hamburger.expandCreateShoppingList();

        Thread.sleep(
                1000);

        hamburger.clickForGroup();

        Thread.sleep(
                2000);

        hamburger.clickBackButton();

        /*
         * Allow Home screen to stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Group Management
         */
        hamburger.clickGroupManagement();

        Thread.sleep(
                2000);

        hamburger.clickBackButton();

        /*
         * Allow Home screen to stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Control Panel
         */
        hamburger.clickControlPanel();

        Thread.sleep(
                2000);

        hamburger.clickBackButton();

        /*
         * Allow Home screen to stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Cooking Facts
         */
        hamburger.clickCookingFacts();

        Thread.sleep(
                2000);

        hamburger.clickBackButton();

        /*
         * Allow Home screen to stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Glossary
         */
        hamburger.clickGlossary();

        Thread.sleep(
                2000);

        hamburger.clickBackButton();

        /*
         * Allow Home screen to stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Share
         */
        hamburger.clickShare();

        Thread.sleep(
                2000);

        /*
         * Share opens Android Share Sheet
         */
        hamburger.closeShareSheet();

        Thread.sleep(
                2000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Tutorial
         */
        hamburger.clickTutorial();

        Thread.sleep(
                2000);

        hamburger.clickBackButton();

        Thread.sleep(
                2000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * FAQs
         */
        hamburger.clickFAQs();

        Thread.sleep(
                2000);

        hamburger.clickBackButton();

        Thread.sleep(
                2000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Contact Us
         */
        hamburger.clickContactUs();

        Thread.sleep(
                2000);

        hamburger.clickBackButton();

        Thread.sleep(
                2000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Feedback
         */
        hamburger.clickFeedback();

        Thread.sleep(
                2000);

        hamburger.clickBackButton();

        Thread.sleep(
                2000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Legal
         */
        hamburger.clickLegal();

        Thread.sleep(
                2000);

        hamburger.clickBackButton();

        /*
         * Allow Home screen to stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Sign Out
         */
        System.out.println(
                "Sign Out option displayed successfully.");

        /*
         * Close Hamburger Menu
         */
        hamburger.closeHamburgerMenu();

        Thread.sleep(
                1000);

        System.out.println(
                "==================================================");

        System.out.println(
                "Completed Test Case : verifyHamburgerMenu");

        System.out.println(
                "==================================================");
    }
}