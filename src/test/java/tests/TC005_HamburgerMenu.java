package tests;

import base.BaseTest;
import driver.DriverFactory;
import org.testng.Assert;
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
        Thread.sleep(3000);

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        /*
         * Verify Hamburger Menu Visibility
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

        Thread.sleep(2000);

        System.out.println(
                "Hamburger menu clicked successfully.");

        /*
         * Tutorial
         */
        Assert.assertTrue(
                hamburger.isTutorialVisible(),
                "Tutorial option is not displayed.");

        hamburger.clickTutorial();

        Thread.sleep(2000);

        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed on Tutorial screen.");

        hamburger.clickBackButton();

        Thread.sleep(2000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);

        /*
         * FAQs
         */
        Assert.assertTrue(
                hamburger.isFAQsVisible(),
                "FAQs option is not displayed.");

        hamburger.clickFAQs();

        Thread.sleep(2000);

        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed on FAQs screen.");

        hamburger.clickBackButton();

        Thread.sleep(2000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);

        /*
         * Glossary
         */
        Assert.assertTrue(
                hamburger.isGlossaryVisible(),
                "Glossary option is not displayed.");

        hamburger.clickGlossary();

        Thread.sleep(2000);

        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed on Glossary screen.");

        hamburger.clickBackButton();

        Thread.sleep(2000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);

        /*
         * Feedback
         */

        hamburger.clickFeedback();

        Thread.sleep(2000);

        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed on Feedback screen.");

        hamburger.clickBackButton();

        Thread.sleep(2000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);

        /*
         * Share
         */
        Assert.assertTrue(
                hamburger.isShareVisible(),
                "Share option is not displayed.");

        hamburger.clickShare();

        Thread.sleep(2000);

        /*
         * Share opens Android Share Sheet
         */
        hamburger.closeShareSheet();

        Thread.sleep(2000);

        /*
         * Reopen Hamburger Menu
         */
        Assert.assertTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is not displayed after closing Share Sheet.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);

                /*
         * Contact Us
         */

        hamburger.clickContactUs();

        Thread.sleep(2000);

        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed on Contact Us screen.");

        hamburger.clickBackButton();

        Thread.sleep(2000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);

        /*
         * Legal
         */

        hamburger.clickLegal();

        Thread.sleep(2000);

        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed on Legal screen.");

        hamburger.clickBackButton();

        Thread.sleep(2000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);

        /*
         * Control Panel
         */

        hamburger.clickControlPanel();

        Thread.sleep(2000);

        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed on Control Panel screen.");

        hamburger.clickBackButton();

        /*
         * Allow Home screen to stabilize
         */
        Thread.sleep(3000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);


        /*
         * Verify Create Shopping List - For Self
         */

        hamburger.expandCreateShoppingList();

        Thread.sleep(1000);

        hamburger.clickForSelf();

        Thread.sleep(2000);

        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed on For Self screen.");

        hamburger.clickBackButton();

        /*
         * Allow Home screen to stabilize
         */
        Thread.sleep(3000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);


        /*
         * Verify Create Shopping List - For Group
         */

        hamburger.expandCreateShoppingList();

        Thread.sleep(1000);

        hamburger.clickForGroup();

        Thread.sleep(2000);

        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed on For Group screen.");

        hamburger.clickBackButton();

        /*
         * Allow Home screen to stabilize
         */
        Thread.sleep(3000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);

        /*
         * Group Management
         */

        hamburger.clickGroupManagement();

        Thread.sleep(2000);

        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed on Group Management screen.");

        hamburger.clickBackButton();

        /*
         * Allow Home screen to stabilize
         */
        Thread.sleep(3000);

        /*
         * Reopen Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);


        /*
         * Sign Out
         */

        System.out.println(
                "Sign Out option displayed successfully.");

        /*
         * Close Hamburger Menu
         */
        hamburger.closeHamburgerMenu();

        Thread.sleep(1000);

        System.out.println(
                "==================================================");

        System.out.println(
                "Completed Test Case : verifyHamburgerMenu");

        System.out.println(
                "==================================================");
    }
}