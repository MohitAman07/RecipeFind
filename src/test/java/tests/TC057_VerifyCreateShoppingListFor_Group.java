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

         groupManagement.enterGroupSearch(
                groupName);

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

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
                "Aman Mohi");

        Thread.sleep(
                2000);

        /*
         * Select Recipe
         */
        shoppingList.selectRecipe(
                "Classic Pancakes with Berries and Banana");

        shoppingList.selectRecipe(
                "Classic Sugar Cookies with Glaze and Sprinkles");

        shoppingList.selectRecipe(
                "Grilled Chicken Salad");

        shoppingList.selectRecipe(
                "Teing sugar 09-08-2026");

        shoppingList.selectRecipe(
                "Testing 09-08-2026");

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
         * Select Metric Unit
         */
        shoppingList.selectUnit(
                "US Customary");

        Thread.sleep(
                2000);

        /*
         * Enter Order Quantity
         */
        shoppingList.enterOrderFor(
                "Classic Pancakes with Berries and Banana",
                "8");

        shoppingList.enterOrderFor(
                "Classic Sugar Cookies with Glaze and Sprinkles",
                "8");

        shoppingList.enterOrderFor(
                "Grilled Chicken Salad",
                "8");

        shoppingList.enterOrderFor(
                "Teing sugar 09-08-2026",
                "8");

        shoppingList.enterOrderFor(
                "Testing 09-08-2026",
                "8");

        shoppingList.enterOrderFor(
                "White Bread",
                "8");

        Thread.sleep(
                3000);

        /*
         * Click Export Shopping List
         */
        shoppingList.clickExportShoppingListButton();

        Thread.sleep(
                1000);

        /*
         * Select CSV Export
         */
        shoppingList.selectExportType(
                "CSV File");

        Thread.sleep(
                2000);
        
        /*
        * Click Outside Share Window
        */
        shoppingList.clickOutsideShareWindow();

        Thread.sleep(
                3000);


        /*
         * Click Export Shopping List
         */
        shoppingList.clickExportShoppingListButton();

        Thread.sleep(
                3000);

        /*
         * Select PDF Export
         */
        shoppingList.selectExportType(
                "PDF");

        Thread.sleep(
                3000);

         /*
        * Click Outside Share Window
        */
        shoppingList.clickOutsideShareWindow();

        System.out.println(
                "==================================================");

        System.out.println(
                "Shopping List For Group exported successfully.");

        System.out.println(
                "==================================================");
    }
}