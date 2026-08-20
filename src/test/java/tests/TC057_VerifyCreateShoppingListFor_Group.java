package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.ShoppingList;
import utils.ValidationUtil;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.HamburgerMenu.GroupManagement;

public class TC057_VerifyCreateShoppingListFor_Group extends BaseTest {

    String groupName =
            "Create shopping list 10-08-2026";

    @Test
    public void verifyCreateShoppingListForGroup()
            throws Exception {

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        ShoppingList shoppingList =
                new ShoppingList(
                        DriverFactory.getDriver());

        GroupManagement groupManagement =
                new GroupManagement(
                        DriverFactory.getDriver());

        /*
         * Open Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Expand Create Shopping List
         */
        hamburger.expandCreateShoppingList();

        Thread.sleep(
                1000);

        /*
         * Select For Group
         */
        hamburger.clickForGroup();

        Thread.sleep(
                3000);

        /*
         * Search Group
         */
        groupManagement.enterGroupSearch(
                groupName);

        groupManagement.clickGroupSearchButton();

        Thread.sleep(
                3000);

        groupManagement.hideKeyboard();

        /*
         * Verify Group Created
         */
        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupName),
                "Group displayed successfully.");

        /*
         * Open Group
         */
        groupManagement.selectGroup(
                groupName);

        Thread.sleep(
                2000);

        /*
         * Expand Contributor
         */
        shoppingList.expandContributor(
                "Aman Mohit");

        Thread.sleep(
                2000);

        /*
         * Select Recipe
         */

        shoppingList.selectRecipe(
                "Classic Sugar Cookies with Glaze and Sprinkles");

        shoppingList.selectRecipe(
                "Grilled Chicken Salad");

        shoppingList.selectRecipe(
                "Testing 09-08-2026");

        shoppingList.selectRecipe(
                "Testing sugar 09-08-2026");

        shoppingList.selectRecipe(
                "White Bread");

        Thread.sleep(
                3000);

        /*
         * Click Next
         */
        shoppingList.clickNextButton();

        Thread.sleep(
                3000);

        /*
         * Select US Customary Unit
         */
        shoppingList.selectUnit(
                "US Customary");

        Thread.sleep(
                2000);

        /*
         * Enter Order Quantity
         */

        shoppingList.enterOrderFor(
                "Classic Sugar Cookies with Glaze and Sprinkles",
                "8");

        shoppingList.enterOrderFor(
                "Grilled Chicken Salad",
                "8");

        shoppingList.enterOrderFor(
                "Testing 09-08-2026",
                "8");

        shoppingList.enterOrderFor(
                "Testing sugar 09-08-2026",
                "8");

        shoppingList.enterOrderFor(
                "White Bread",
                "8");

        Thread.sleep(
                3000);

        /*
         * Open Export Dropdown
         */
        shoppingList.clickExportButton();

        Thread.sleep(
                1000);

        /*
         * Select Shopping List
         */
        shoppingList.selectExportOption(
                "Shopping List");

        /*
         * Click Outside Export Dropdown
         */
        shoppingList.clickOutsideExportDropdown();

        Thread.sleep(
                1000);

        /*
         * Click Download
         */
        shoppingList.clickDownloadButton();

        Thread.sleep(
                2000);

        /*
         * Verify Shopping List Saved Message
         */
        ValidationUtil.verifyTrue(
                shoppingList.isShoppingListSavedMessageDisplayed(),
                "Shopping List PDF + CSV saved message is not displayed.");

        System.out.println(
                "==================================================");

        System.out.println(
                "Shopping List For Group exported successfully as PDF and CSV.");

        System.out.println(
                "==================================================");
    }
}