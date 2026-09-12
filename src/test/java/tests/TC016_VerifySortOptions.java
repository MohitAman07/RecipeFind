package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.ControlPanel;
import pagesObjects.HamburgerMenu.Hamburger;
import utils.ValidationUtil;

public class TC016_VerifySortOptions extends BaseTest {

    @Test
    public void verifySortOptions() throws InterruptedException {

        Hamburger hamburger =
                new Hamburger(DriverFactory.getDriver());

        ControlPanel controlPanel =
                new ControlPanel(DriverFactory.getDriver());

        System.out.println(
                "========== Verify Sort Options ==========");

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

        hamburger.clickControlPanel();

        /*
         * Verify Sort Button
         */
        Assert.assertTrue(
                controlPanel.isSortButtonDisplayed(),
                "Sort button is not displayed.");

        /*
         * Verify Sort By Newest
         */
        Thread.sleep(3000);
        controlPanel.clickSort();

        Assert.assertTrue(
                controlPanel.isNewestDisplayed(),
                "Newest option is not displayed.");

        controlPanel.selectNewest();


        /*
         * Verify Sort By Oldest
         */
        controlPanel.clickSort();

        Assert.assertTrue(
                controlPanel.isOldestDisplayed(),
                "Oldest option is not displayed.");

        controlPanel.selectOldest();


        /*
         * Verify Sort By Name
         */
        controlPanel.clickSort();

        Assert.assertTrue(
                controlPanel.isNameDisplayed(),
                "Name option is not displayed.");

        controlPanel.selectName();


        /*
         * Navigate Back
         */
        Thread.sleep(3000);
        hamburger.clickBackButton();

        System.out.println(
                "========== Sort Options Verified Successfully ==========");
    }
}