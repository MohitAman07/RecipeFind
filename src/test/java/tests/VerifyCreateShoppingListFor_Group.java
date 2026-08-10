package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.ShoppingList;
import pagesObjects.HamburgerMenu.Hamburger;
import utils.Scroll;


public class VerifyCreateShoppingListFor_Group extends BaseTest{

     @Test
    public void verifyCreateShoppingListForGroup()
            throws Exception {

        Hamburger hamburger =new Hamburger(DriverFactory.getDriver());

        ShoppingList shoppingList =
                new ShoppingList(
                        DriverFactory.getDriver());

        Scroll scroll = new Scroll( DriverFactory.getDriver());


        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(3000);

         shoppingList.clickCreateShoppingList();

         Thread.sleep(3000);

        // Click For Group
        shoppingList.clickForGroup();


        // Select Group
        shoppingList.SelectGroup();

        Thread.sleep(2000);

        shoppingList.Selectcontributor_01();

        // Select Recipe
        shoppingList.selectRecipe("Aloo Paneer Gravy");
        shoppingList.selectRecipe("Soya Chunks Masala");
        shoppingList.selectRecipe("Testing data in ios and andriod");
        shoppingList.selectRecipe("Testing serving and add sugar");
        Thread.sleep(3000);
  
        scroll.ScrollDown();

      
        shoppingList.Selectcontributor_02();

        shoppingList.selectRecipe("Basmati Rice");
        shoppingList.selectRecipe("Testing duplicate");
        Thread.sleep(3000);
        scroll.ScrollDown();


        shoppingList.SelectContributor_03();
        Thread.sleep(3000);
  
        shoppingList.selectRecipe("Belgian waffles");
        shoppingList.selectRecipe("Choco cake");
        scroll.ScrollDown();
        Thread.sleep(3000);
        shoppingList.selectRecipe("Fried rice");
        shoppingList.selectRecipe("Jamun shots");
        shoppingList.selectRecipe("Jhalmuri");
         Thread.sleep(3000);
         scroll.ScrollDown();
  

        shoppingList.selectRecipe("Kachori");
        shoppingList.selectRecipe("Kaju roll");
        shoppingList.selectRecipe("Methi puri");
        shoppingList.selectRecipe("Momos");
        scroll.ScrollDown();
        Thread.sleep(3000);
        shoppingList.selectRecipe("Pani puri");
        shoppingList.selectRecipe("Shikanji");
        shoppingList.selectRecipe("Vanila cake");

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

         shoppingList.selectExportType(
                "PDF");

        // Drive
        shoppingList.selectDrive();

        // Upload
        shoppingList.uploadFileToDrive();

        System.out.println(
                "Shopping List For Group exported successfully.");


            }
            }
