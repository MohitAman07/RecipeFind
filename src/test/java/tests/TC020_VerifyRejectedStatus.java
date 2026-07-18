package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.ControlPanel;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC020_VerifyRejectedStatus extends BaseTest {

    @Test
    public void verifyRejectedStatus() throws InterruptedException {

        String recipeName = "Chocolate Banana Smoothie";

        Hamburger hamburger =
                new Hamburger(DriverFactory.getDriver());

        ControlPanel controlPanel =
                new ControlPanel(DriverFactory.getDriver());

        System.out.println(
                "========== Verify Rejected Status ==========");

        /*
         * Open Hamburger Menu
         */
        Assert.assertTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is not displayed.");

        hamburger.clickHamburgerMenu();

        /*
         * Open Control Panel
         */
        hamburger.clickControlPanel();

        /*
         * Open All Tab
         */
        Thread.sleep(5000);
        controlPanel.clickAllTab();

        /*
         * Open Change Status
         */
        controlPanel.clickRecipeMenu(recipeName);

        /*
         * Change To Rejected
         */
        controlPanel.clickRejectedStatus();

        /*
         * Verify Rejected Tab
         */
        controlPanel.clickRejectedTab();

        Thread.sleep(5000);

        Assert.assertTrue(
                controlPanel.isRecipeDisplayed(recipeName),
                "Recipe is not displayed in Rejected tab.");

        /*
         * Navigate Back
         */
        Thread.sleep(3000);
        hamburger.clickBackButton();

        System.out.println(
                "========== Rejected Status Verified Successfully ==========");
    }
}