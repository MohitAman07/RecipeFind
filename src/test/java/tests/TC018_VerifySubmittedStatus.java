package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.ControlPanel;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC018_VerifySubmittedStatus extends BaseTest {

    @Test
    public void verifySubmittedStatus() throws InterruptedException {

        String recipeName = "Chocolate Banana Smoothie";

        Hamburger hamburger =
                new Hamburger(DriverFactory.getDriver());

        ControlPanel controlPanel =
                new ControlPanel(DriverFactory.getDriver());

        System.out.println(
                "========== Verify Submitted Status ==========");

        /*
         * Open Hamburger Menu
         */
        Thread.sleep(3000);
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
         * Change To Submitted
         */
        controlPanel.clickSubmittedStatus();

        /*
         * Verify Submitted Tab
         */
        controlPanel.clickSubmittedTab();
        Thread.sleep(5000);

        Assert.assertTrue(
                controlPanel.isRecipeDisplayed(recipeName),
                "Recipe is not displayed in Submitted tab.");

        /*
         * Navigate Back
         */
        Thread.sleep(3000);
        hamburger.clickBackButton();

        System.out.println(
                "========== Submitted Status Verified Successfully ==========");
    }
}