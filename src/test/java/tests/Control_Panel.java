package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.ControlPanel;
import pagesObjects.HamburgerMenu.Hamburger;

public class Control_Panel extends BaseTest {

    @Test
    public void verifyControlPanelFunctionality()
            throws InterruptedException {

        System.out.println(
                "==================================================");

        System.out.println(
                "Executing Test Case : verifyControlPanelFunctionality");

        System.out.println(
                "==================================================");

        /*
         * Wait For Home Dashboard
         */
        Thread.sleep(9000);

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        ControlPanel controlPanel =
                new ControlPanel(
                        DriverFactory.getDriver());

        /*
         * Open Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);

        /*
         * Open Control Panel
         */
        controlPanel.openControlPanel();

        Thread.sleep(5000);

        /*
         * Open Change Status
         */
        controlPanel.clickDots();

        Thread.sleep(1000);

        controlPanel.clickChangeStatus();

        Thread.sleep(3000);

        /*
         * Verify Submitted Recipes
         */
        controlPanel.clickSubmittedTab();

        Thread.sleep(3000);

        controlPanel.openSubmittedRecipe();

        Thread.sleep(3000);

        hamburger.clickBackButton();

        Thread.sleep(2000);

        /*
         * Verify Verified Recipes
         */
        controlPanel.clickVerifiedTab();

        Thread.sleep(3000);

        controlPanel.openVerifiedRecipe();

        Thread.sleep(3000);

        hamburger.clickBackButton();

        Thread.sleep(2000);

        /*
         * Verify Rejected Recipes
         */
        controlPanel.clickRejectedTab();

        Thread.sleep(3000);

        controlPanel.openRejectedRecipe();

        Thread.sleep(3000);

        hamburger.clickBackButton();

        Thread.sleep(2000);

        /*
         * Verify Delete Pending Tab
         */
        controlPanel.clickDeletePendingTab();

        Thread.sleep(3000);

        /*
         * Verify Group Search
         */
        controlPanel.clickGroupIcon();

        Thread.sleep(2000);

        controlPanel.enterGroupName(
                "Mohit-Testing-01-july");

        controlPanel.clickGroupSearchButton();

        Thread.sleep(3000);

        controlPanel.selectGroup();

        Thread.sleep(3000);

        /*
         * Remove Group
         */
        controlPanel.clickRemoveGroup();

        Thread.sleep(3000);

        /*
         * Back To Home
         */
        hamburger.clickBackButton();

        Thread.sleep(2000);

        System.out.println(
                "==================================================");

        System.out.println(
                "Completed Test Case : verifyControlPanelFunctionality");

        System.out.println(
                "==================================================");
    }
}