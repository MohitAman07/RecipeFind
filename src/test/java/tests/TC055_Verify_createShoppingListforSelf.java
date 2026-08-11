package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.HamburgerMenu.ShoppingList;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC055_Verify_createShoppingListforSelf extends BaseTest {

    @Test
    public void verifyCreateShoppingListForSelf()
            throws Exception {

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        ShoppingList shoppingList =
                new ShoppingList(
                        DriverFactory.getDriver());

        /*
         * Open Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu displayed successfully.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Verify Create Shopping List Collapsed
         */
        ValidationUtil.verifyTrue(
                hamburger.isCreateShoppingListCollapsedVisible(),
                "Create Shopping List option displayed successfully.");

        /*
         * Expand Create Shopping List
         */
        hamburger.expandCreateShoppingList();

        Thread.sleep(
                1000);

        /*
         * Verify For Self
         */
        ValidationUtil.verifyTrue(
                hamburger.isForSelfVisible(),
                "For Self option displayed successfully.");

        /*
         * Select For Self
         */
        hamburger.clickForSelf();

        Thread.sleep(
                3000);

        /*
         * Select Testing Sugar Content Recipe
         */
        shoppingList.selectRecipe(
                "Testing sugar content");

        Thread.sleep(
                1000);

        /*
         * Select Grilled Chicken Salad Recipe
         */
        shoppingList.selectRecipe(
                "Grilled Chicken Salad");

        Thread.sleep(
                2000);

        /*
         * Click Next
         */
        shoppingList.clickNextButton();

        Thread.sleep(
                5000);

        /*
         * Select Metric Unit
         */
        shoppingList.selectUnit(
        "US Customary");

        Thread.sleep(
                2000);

        /*
         * Enter Order Quantity For Testing Sugar Content
         */
        shoppingList.enterOrderFor(
                "Testing sugar content",
                "4");

        Thread.sleep(
                1000);

        /*
         * Enter Order Quantity For Grilled Chicken Salad
         */
        shoppingList.enterOrderFor(
                "Grilled Chicken Salad",
                "4");

        Thread.sleep(
                2000);

        /*
         * Click Export Shopping List
         */
        shoppingList.clickExportShoppingListButton();

        Thread.sleep(
                1000);

        /*
         * Select PDF Export
         */
        shoppingList.selectExportType(
                "PDF");

        // Thread.sleep(
        //         2000);

        // /*
        //  * Select Drive
        //  */
        // shoppingList.selectDrive();

        // Thread.sleep(
        //         2000);

        // /*
        //  * Upload File
        //  */
        // shoppingList.uploadFileToDrive();

        // Thread.sleep(
        //         3000);

        /*
        * Terminate RecipeFind App
        */
        DriverFactory.getDriver()
                .terminateApp(
                        ConfigReader.getProperty(
                                "app.package"));

        Thread.sleep(
        2000);

        /*
        * Launch RecipeFind App
        */
        DriverFactory.getDriver()
                .activateApp(
                        appPackage);

        Thread.sleep(
                3000);

        System.out.println(
                "==================================================");

        System.out.println(
                "Shopping List For Self exported successfully as PDF.");

        System.out.println(
                "==================================================");
    }
}