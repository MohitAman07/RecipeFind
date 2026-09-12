package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pagesObjects.HamburgerMenu.ControlPanel;
import pagesObjects.HamburgerMenu.Hamburger;
import utils.ValidationUtil;

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
        Thread.sleep(
                3000);

        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is displayed.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                3000);

        /*
         * Verify Control Panel
         */
        hamburger.clickControlPanel();

        Thread.sleep(
                3000);

        ValidationUtil.verifyTrue(
                controlPanel.isSearchFieldDisplayed(),
                "Search field is displayed.");

        /*
         * Verify Groups Section
         */
        ValidationUtil.verifyTrue(
                controlPanel.isGroupsDisplayed(),
                "Groups section is displayed.");

        /*
         * Verify Sort Button
         */
        ValidationUtil.verifyTrue(
                controlPanel.isSortButtonDisplayed(),
                "Sort button is displayed.");

        /*
         * Verify All Tab
         */
        Thread.sleep(
                3000);

        controlPanel.clickAllTab();

        ValidationUtil.verifyTrue(
                controlPanel.isAllTabDisplayed(),
                "All tab is displayed.");

        Thread.sleep(
                3000);

        /*
         * Verify Submitted Tab
         */
        controlPanel.clickSubmittedTab();

        ValidationUtil.verifyTrue(
                controlPanel.isSubmittedTabDisplayed(),
                "Submitted tab is displayed.");

        Thread.sleep(
                3000);

        /*
         * Verify Verified Tab
         */
        controlPanel.clickVerifiedTab();

        ValidationUtil.verifyTrue(
                controlPanel.isVerifiedTabDisplayed(),
                "Verified tab is displayed.");

        Thread.sleep(
                3000);

        /*
         * Verify Rejected Tab
         */
        controlPanel.clickRejectedTab();

        ValidationUtil.verifyTrue(
                controlPanel.isRejectedTabDisplayed(),
                "Rejected tab is displayed.");

        Thread.sleep(
                3000);

        /*
         * Verify Delete Pending Tab
         */
        controlPanel.clickDeletePendingTab();

        ValidationUtil.verifyTrue(
                controlPanel.isDeletePendingTabDisplayed(),
                "Delete Pending tab is displayed.");

        Thread.sleep(
                3000);

        /*
         * Return To All Tab
         */
        controlPanel.clickAllTab();

        /*
         * Verify Recipe Card
         */
        Thread.sleep(
                5000);

        controlPanel.enterSearchText(
                recipeName);

        controlPanel.hideKeyboard();

        Thread.sleep(
                3000);

        ValidationUtil.verifyTrue(
                controlPanel.isRecipeDisplayed(recipeName),
                "Recipe is displayed.");

        /*
         * Verify Change Status Screen
         */
        Thread.sleep(
                3000);

        controlPanel.clickRecipeMenu(
                recipeName);

        ValidationUtil.verifyTrue(
                controlPanel.isChangeStatusScreenDisplayed(),
                "Change Status screen is displayed.");

        ValidationUtil.verifyTrue(
                controlPanel.isRecipeDisplayedOnChangeStatus(
                        recipeName),
                "Recipe name is displayed on Change Status screen.");

        ValidationUtil.verifyTrue(
                controlPanel.isSubmittedStatusDisplayed(),
                "Submitted option is displayed.");

        ValidationUtil.verifyTrue(
                controlPanel.isVerifiedStatusDisplayed(),
                "Verified option is displayed.");

        ValidationUtil.verifyTrue(
                controlPanel.isRejectedStatusDisplayed(),
                "Rejected option is displayed.");

        ValidationUtil.verifyTrue(
                controlPanel.isDeletePendingStatusDisplayed(),
                "Delete Pending option is displayed.");

        /*
         * Verify Delete Recipe Option (Role Based)
         */
        if (controlPanel.isDeleteRecipeDisplayed()) {

            ValidationUtil.verifyTrue(
                    true,
                    "Delete Recipe option is displayed.");

        }
        else {

            System.out.println(
                    "Delete Recipe option is not available "
                            + "for the current user role.");
        }

        /*
         * Close Change Status Screen
         */
        DriverFactory.getDriver().pressKey(
                new KeyEvent(
                        AndroidKey.BACK));

        /*
         * Verify Sort Options
         */
        Thread.sleep(
                3000);

        controlPanel.clickSort();

        ValidationUtil.verifyTrue(
                controlPanel.isNewestDisplayed(),
                "Newest option is displayed.");

        ValidationUtil.verifyTrue(
                controlPanel.isOldestDisplayed(),
                "Oldest option is displayed.");

        ValidationUtil.verifyTrue(
                controlPanel.isNameDisplayed(),
                "Name option is displayed.");

        /*
         * Select Newest to close the sort dialog
         */
        controlPanel.selectNewest();

        Thread.sleep(
                2000);

        /*
         * Navigate Back From Control Panel
         */
        hamburger.clickBackButton();

        System.out.println(
                "========== Control Panel UI Verified Successfully ==========");
    }
}