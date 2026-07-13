package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC008_retrydemo extends BaseTest {

    @Test
    public void retryDemo() throws InterruptedException {

        Thread.sleep(3000);

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        Assert.assertTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is not displayed.");

        System.out.println(
                "Hamburger menu displayed successfully.");

        // Force failure to verify Retry Analyzer
        Assert.assertTrue(
                false,
                "Intentional failure to verify Retry Analyzer.");
    }
}