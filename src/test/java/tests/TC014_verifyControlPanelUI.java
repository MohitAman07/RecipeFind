package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pagesObjects.HamburgerMenu.ControlPanel;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC014_verifyControlPanelUI extends BaseTest {

    @Test
    public void verifyControlPanelUI() throws InterruptedException {

        String recipeName = "Chocolate Banana Smoothie";

        Hamburger hamburger =
                new Hamburger(DriverFactory.getDriver());

        ControlPanel controlPanel =
                new ControlPanel(DriverFactory.getDriver());

        System.out.println(
                "========== Verify Control Panel UI ==========");

        /*
         * Verify Hamburger Menu
         */
        Assert.assertTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is not displayed.");

        hamburger.clickHamburgerMenu();

        /*
         * Verify Control Panel
         */
        Assert.assertTrue(
                hamburger.isControlPanelVisible(),
                "Control Panel is not displayed.");

        hamburger.clickControlPanel();

        /*
         * Verify Search Field
         */
        Assert.assertTrue(
                controlPanel.isSearchFieldDisplayed(),
                "Search field is not displayed.");

        /*
         * Verify Groups Section
         */
        Assert.assertTrue(
                controlPanel.isGroupsDisplayed(),
                "Groups section is not displayed.");

        /*
         * Verify Sort Button
         */
        Assert.assertTrue(
                controlPanel.isSortButtonDisplayed(),
                "Sort button is not displayed.");

        /*
         * Verify All Tab
         */
        controlPanel.clickAllTab();

        Assert.assertTrue(
                controlPanel.isAllTabDisplayed(),
                "All tab is not displayed.");

        /*
         * Verify Submitted Tab
         */
        controlPanel.clickSubmittedTab();

        Assert.assertTrue(
                controlPanel.isSubmittedTabDisplayed(),
                "Submitted tab is not displayed.");

        /*
         * Verify Verified Tab
         */
        controlPanel.clickVerifiedTab();

        Assert.assertTrue(
                controlPanel.isVerifiedTabDisplayed(),
                "Verified tab is not displayed.");

        /*
         * Verify Rejected Tab
         */
        controlPanel.clickRejectedTab();

        Assert.assertTrue(
                controlPanel.isRejectedTabDisplayed(),
                "Rejected tab is not displayed.");

        /*
         * Verify Delete Pending Tab
         */
        controlPanel.clickDeletePendingTab();

        Assert.assertTrue(
                controlPanel.isDeletePendingTabDisplayed(),
                "Delete Pending tab is not displayed.");

        /*
         * Return To All Tab
         */
        controlPanel.clickAllTab();

        /*
         * Verify Recipe Card
         */
        Assert.assertTrue(
                controlPanel.isRecipeDisplayed(recipeName),
                "Recipe is not displayed.");

        /*
         * Verify Change Status Screen
         */
        controlPanel.clickRecipeMenu(recipeName);

        Assert.assertTrue(
                controlPanel.isChangeStatusScreenDisplayed(),
                "Change Status screen is not displayed.");

        Assert.assertTrue(
                controlPanel.isRecipeDisplayedOnChangeStatus(recipeName),
                "Recipe name is not displayed on Change Status screen.");

        Assert.assertTrue(
                controlPanel.isSubmittedStatusDisplayed(),
                "Submitted option is not displayed.");

        Assert.assertTrue(
                controlPanel.isVerifiedStatusDisplayed(),
                "Verified option is not displayed.");

        Assert.assertTrue(
                controlPanel.isRejectedStatusDisplayed(),
                "Rejected option is not displayed.");

        Assert.assertTrue(
                controlPanel.isDeletePendingStatusDisplayed(),
                "Delete Pending option is not displayed.");

        /*
         * Verify Delete Recipe Option (Role Based)
         */
        if (controlPanel.isDeleteRecipeDisplayed()) {

            System.out.println(
                    "Delete Recipe option is displayed.");
        }
        else {

            System.out.println(
                    "Delete Recipe option is not available for the current user role.");
        }

        /*
         * Close Change Status Screen
         */
        DriverFactory.getDriver().pressKey(new KeyEvent(AndroidKey.BACK));

        /*
 * Verify Sort Options
 */
Thread.sleep(3000);

controlPanel.clickSort();

Assert.assertTrue(
        controlPanel.isNewestDisplayed(),
        "Newest option is not displayed.");

Assert.assertTrue(
        controlPanel.isOldestDisplayed(),
        "Oldest option is not displayed.");

Assert.assertTrue(
        controlPanel.isNameDisplayed(),
        "Name option is not displayed.");

/*
 * Select Newest to close the sort dialog
 */
controlPanel.selectNewest();

Thread.sleep(2000);

        /*
         * Navigate Back From Control Panel
         */

        hamburger.clickBackButton();

        System.out.println(
                "========== Control Panel UI Verified Successfully ==========");
    }
}