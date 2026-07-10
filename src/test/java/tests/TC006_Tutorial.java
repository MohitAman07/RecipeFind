package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.HamburgerMenu.Tutorials;

public class TC006_Tutorial extends BaseTest {

    @Test
    public void verifyTutorialFunctionality()
            throws InterruptedException {

        System.out.println(
                "==================================================");

        System.out.println(
                "Executing Test Case : verifyTutorialFunctionality");

        System.out.println(
                "==================================================");

        /*
         * Wait for Home Dashboard to stabilize
         */
        Thread.sleep(3000);

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        Tutorials tutorials =
                new Tutorials(
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
         * Verify Tutorial Option
         */
        Assert.assertTrue(
                hamburger.isTutorialVisible(),
                "Tutorial option is not displayed.");

        System.out.println(
                "Tutorial option displayed successfully.");

        /*
         * Click Tutorial
         */
        hamburger.clickTutorial();

        Thread.sleep(5000);

        System.out.println(
                "Tutorial option clicked successfully.");

        /*
         * Verify Tutorial Screen
         */
        Assert.assertTrue(
                tutorials.isTutorialScreenVisible(),
                "Tutorial screen is not displayed.");

        System.out.println(
                "Tutorial screen displayed successfully.");

        /*
         * Fetch Tutorial Cards
         */
        int totalCards =
                tutorials.getAllTutorialCards();

        Assert.assertTrue(
                totalCards > 0,
                "No tutorial cards found.");

        System.out.println(
                "Total Tutorial Cards : "
                        + totalCards);

        /*
         * Navigate Back to Home
         */
        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed.");

        hamburger.clickBackButton();

        Thread.sleep(2000);

        System.out.println(
                "Back button clicked successfully.");

        System.out.println(
                "==================================================");

        System.out.println(
                "Completed Test Case : verifyTutorialFunctionality");

        System.out.println(
                "==================================================");
    }
}