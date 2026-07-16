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
        Assert.assertTrue(
                hamburger.isControlPanelVisible(),
                "Control Panel is not displayed.");

        hamburger.clickControlPanel();

        Thread.sleep(5000);

        /*
         * Open All Tab
         */
        controlPanel.clickAllTab();

        /*
         * Verify Recipe
         */
        Assert.assertTrue(
                controlPanel.isRecipeDisplayed(recipeName),
                "Recipe is not displayed.");

        /*
         * Open Change Status
         */
        controlPanel.clickRecipeMenu(recipeName);

        Assert.assertTrue(
                controlPanel.isChangeStatusScreenDisplayed(),
                "Change Status screen is not displayed.");

        /*
         * Change Status To Rejected
         */
        controlPanel.clickRejectedStatus();

        /*
         * Open Rejected Tab
         */
        controlPanel.clickRejectedTab();

        Thread.sleep(5000);

        /*
         * Verify Recipe
         */
        Assert.assertTrue(
                controlPanel.isRecipeDisplayed(recipeName),
                "Recipe is not displayed in Rejected tab.");

        /*
         * Navigate Back
         */
        hamburger.clickBackButton();

        System.out.println(
                "========== Rejected Status Verified Successfully ==========");
    }
}