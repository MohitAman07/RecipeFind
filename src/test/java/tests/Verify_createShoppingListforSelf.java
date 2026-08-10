package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.ShoppingList;
import pagesObjects.HamburgerMenu.Hamburger;


public class Verify_createShoppingListforSelf extends BaseTest{

     @Test
    public void verifyCreateShoppingListForSelf()
            throws Exception {

        Hamburger hamburger =new Hamburger(DriverFactory.getDriver());

        ShoppingList shoppingList =
                new ShoppingList(
                        DriverFactory.getDriver());


        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(3000);

         shoppingList.clickCreateShoppingList();

        // Select Self
        shoppingList.selectForSelf();

         // Expand AI Recipes
        // shoppingList.clickAISuggestionsDropdown();
        //  Thread.sleep(2000);

        // Expand Community Recipes
        // shoppingList.clickCommunityDropdown();
        //  Thread.sleep(2000);

        //  shoppingList.clickCommunityDropdown();
        //  Thread.sleep(2000);

        // Select Recipe
        shoppingList.selectRecipe(
                "Cashew katli (diamond, burfee)");

        shoppingList.selectRecipe(
                "Choux pastry");


         Thread.sleep(2000);

        // Next
        shoppingList.clickNextButton();

        // Select Unit
        shoppingList.selectUnit(
                "Metric");

        shoppingList.selectUnit(
                "US Customary");

        Thread.sleep(2000);

       
        // Quantity
        shoppingList.enterOrderFor(
                "8");

        // Export
        shoppingList.clickExportButton();

        // CSV Export
        shoppingList.selectExportType(
                "CSV File");

        // Drive
        shoppingList.selectDrive();

        // Upload
        shoppingList.uploadFileToDrive();

        shoppingList.clickBackButton();

        shoppingList.selectRecipe(
                "Basmati Rice");

        Thread.sleep(2000);

        shoppingList.selectRecipe(
                "Caesar dressing");
        
        Thread.sleep(2000);
                
                
        shoppingList.selectRecipe(
                "Creamy Chicken & Pasta Casserole with Crispy Potato Chip Topping");
        
        Thread.sleep(2000);

        shoppingList.selectRecipe(
                "Cashew katli (diamond, burfee)");

        Thread.sleep(2000);

        shoppingList.selectRecipe(
                "Choux pastry");

        Thread.sleep(2000);

         shoppingList.selectRecipe(
                "Almond Peda (Matcha)");

        Thread.sleep(3000);

        shoppingList.clickNextButton();

        Thread.sleep(3000);

        shoppingList.clickExportButton();

         // CSV Export
        shoppingList.selectExportType(
                "PDF");

         // Drive
        shoppingList.selectDrive();

        // Upload
        shoppingList.uploadFileToDrive();

        System.out.println(
                "Shopping List For Self exported successfully.");
    }

}
