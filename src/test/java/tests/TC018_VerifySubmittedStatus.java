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
        hamburger.clickHamburgerMenu();

        /*
         * Open Control Panel
         */
        hamburger.clickControlPanel();

        /*
         * Open All Tab
         */
        Thread.sleep(3000);
        controlPanel.clickAllTab();

        /*
         * Open Change Status
         */
        controlPanel.clickRecipeMenu(recipeName);

        Assert.assertTrue(
                controlPanel.isChangeStatusScreenDisplayed(),
                "Change Status screen is not displayed.");

        /*
         * Change To Submitted
         */
        controlPanel.clickSubmittedStatus();

        /*
         * Verify Submitted Tab
         */
        controlPanel.clickSubmittedTab();

        Assert.assertTrue(
                controlPanel.isRecipeDisplayed(recipeName),
                "Recipe is not displayed in Submitted tab.");

        /*
         * Navigate Back
         */
        hamburger.clickBackButton();

        System.out.println(
                "========== Submitted Status Verified Successfully ==========");
    }
}