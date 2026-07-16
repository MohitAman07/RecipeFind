package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.ControlPanel;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC021_VerifyDeletePendingStatus extends BaseTest {

    @Test
    public void verifyDeletePendingStatus() throws InterruptedException {

        String recipeName = "Chocolate Banana Smoothie";

        Hamburger hamburger =
                new Hamburger(DriverFactory.getDriver());

        ControlPanel controlPanel =
                new ControlPanel(DriverFactory.getDriver());

        System.out.println(
                "========== Verify Delete Pending Status ==========");

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
         * Change Status To Delete Pending
         */
        controlPanel.clickDeletePendingStatus();

        /*
         * Open Delete Pending Tab
         */
        controlPanel.clickDeletePendingTab();

        Thread.sleep(5000);

        /*
         * Verify Recipe
         */
        Assert.assertTrue(
                controlPanel.isRecipeDisplayed(recipeName),
                "Recipe is not displayed in Delete Pending tab.");

        /*
         * Navigate Back
         */
        hamburger.clickBackButton();

        System.out.println(
                "========== Delete Pending Status Verified Successfully ==========");
    }
}