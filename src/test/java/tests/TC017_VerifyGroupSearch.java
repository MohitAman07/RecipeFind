package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.ControlPanel;
import pagesObjects.HamburgerMenu.Hamburger;
import utils.ValidationUtil;

public class TC017_VerifyGroupSearch extends BaseTest {

    @Test
    public void verifyGroupSearch() throws InterruptedException {

        String groupName = "Group Testing";

        Hamburger hamburger =
                new Hamburger(DriverFactory.getDriver());

        ControlPanel controlPanel =
                new ControlPanel(DriverFactory.getDriver());

        System.out.println(
                "========== Verify Group Search ==========");

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
         * Open Control Panel
         */
        Thread.sleep(5000);

        hamburger.clickControlPanel();
        /*
         * Verify Groups Section
         */

        controlPanel.clickGroups();

        /*
         * Search Group
         */
       controlPanel.enterGroupSearch(groupName);

        controlPanel.hideKeyboard();

        controlPanel.clickGroupSearchButton();

        Thread.sleep(3000);

        controlPanel.selectGroup(groupName);

        // /*
        //  * Navigate Back
        Thread.sleep(3000);
         hamburger.clickBackButton();

        System.out.println(
                "========== Group Search Verified Successfully ==========");
    }
}