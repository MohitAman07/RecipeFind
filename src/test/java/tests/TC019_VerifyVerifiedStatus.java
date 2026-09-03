package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.ControlPanel;
import pagesObjects.HamburgerMenu.Hamburger;
import utils.ValidationUtil;

public class TC019_VerifyVerifiedStatus extends BaseTest {

    @Test
    public void verifyVerifiedStatus() throws InterruptedException {

        String recipeName = "Chocolate Banana Smoothie";

        Hamburger hamburger =
                new Hamburger(DriverFactory.getDriver());

        ControlPanel controlPanel =
                new ControlPanel(DriverFactory.getDriver());

        System.out.println(
                "========== Verify Verified Status ==========");

        /*
         * Allow Home Dashboard To Stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Open Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu displayed successfully.");

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
        
        controlPanel.enterSearchText(recipeName);
        controlPanel.hideKeyboard();

        Thread.sleep(3000);

        /*
         * Open Change Status
         */
        controlPanel.clickRecipeMenu(recipeName);

        /*
         * Change To Verified
         */
        controlPanel.clickVerifiedStatus();

        /*
         * Verify Verified Tab
         */
        controlPanel.clickVerifiedTab();

        Thread.sleep(5000);

        Assert.assertTrue(
                controlPanel.isRecipeDisplayed(recipeName),
                "Recipe is not displayed in Verified tab.");

        /*
         * Navigate Back
         */
        Thread.sleep(3000);
        hamburger.clickBackButton();

        System.out.println(
                "========== Verified Status Verified Successfully ==========");
    }
}