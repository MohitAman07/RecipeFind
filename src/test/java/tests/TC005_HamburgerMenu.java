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
        Assert.assertTrue(
                hamburger.isFeedbackVisible(),
                "Feedback option is not displayed.");

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
        Assert.assertTrue(
                hamburger.isContactUsVisible(),
                "Contact Us option is not displayed.");

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
        Assert.assertTrue(
                hamburger.isLegalVisible(),
                "Legal option is not displayed.");

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
         * Sign Out
         */
        Assert.assertTrue(
                hamburger.isSignOutVisible(),
                "Sign Out option is not displayed.");

        System.out.println(
                "Sign Out option displayed successfully.");

        /*
         * Uncomment below only when testing logout flow
         */
        // hamburger.clickSignOut();
        // Thread.sleep(3000);

        System.out.println(
                "==================================================");

        System.out.println(
                "Completed Test Case : verifyHamburgerMenu");

        System.out.println(
                "==================================================");
    }
}