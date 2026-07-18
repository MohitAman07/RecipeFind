package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.ControlPanel;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC015_VerifyRecipeSearch extends BaseTest {

    @Test
    public void verifyRecipeSearch() throws InterruptedException {

        String recipeName = "Chocolate Banana Smoothie";

        Hamburger hamburger =
                new Hamburger(DriverFactory.getDriver());

        ControlPanel controlPanel =
                new ControlPanel(DriverFactory.getDriver());

        System.out.println(
                "========== Verify Recipe Search ==========");

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

        hamburger.clickControlPanel();
        Thread.sleep(5000);

        /*
         * Search Recipe
         */
        controlPanel.enterSearchText(recipeName);
        controlPanel.hideKeyboard();

        /*
         * Verify Recipe Displayed
         */
        Assert.assertTrue(
                controlPanel.isRecipeDisplayed(recipeName),
                "Recipe is not displayed after searching.");

        /*
         * Clear Search
         */
        controlPanel.clearSearchField();

        /*
         * Navigate Back
         */

        hamburger.clickBackButton();

        System.out.println(
                "========== Recipe Search Verified Successfully ==========");
    }
}