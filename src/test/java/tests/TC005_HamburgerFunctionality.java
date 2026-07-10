package tests;
import base.BaseTest;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObjects.HamburgerMenu.Hamburger;

public class TC005_HamburgerFunctionality extends BaseTest {

    @Test
    public void verifyHamburgerMenuFunctionality()
            throws InterruptedException {

        System.out.println(
                "==================================================");

        System.out.println(
                "Executing Test Case : verifyHamburgerMenuFunctionality");

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
         * Click Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);

        System.out.println(
                "Hamburger menu clicked successfully.");

        System.out.println(
                "==================================================");

        System.out.println(
                "Completed Test Case : verifyHamburgerMenuFunctionality");

        System.out.println(
                "==================================================");
    }
}