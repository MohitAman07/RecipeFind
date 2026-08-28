package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Contribute.AddRecipeDashboard.AddRecipe;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.Home.HomeDashboard;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC058_VerifyAddRecipe extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    @Override
    public void setUp(
            Method method) {

        loginEmail =
                ConfigReader.getProperty(
                        "superadmin.email");

        loginPassword =
                ConfigReader.getProperty(
                        "superadmin.password");

        super.setUp(
                method);
    }

    @Test
    public void verifyAddRecipe()
            throws Exception {

        AddRecipe addRecipe =
                new AddRecipe(
                        DriverFactory.getDriver());
        
        HomeDashboard homeDashboard=new HomeDashboard(DriverFactory.getDriver());

        Hamburger hamburger=new Hamburger(DriverFactory.getDriver());

        /*
         * Allow Home Dashboard To Stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Open Contribute
         */
        homeDashboard.clickContributeButton();;

        Thread.sleep(
                2000);

        /*
         * Open Add Recipe Section
         */
        addRecipe.clickAddRecipe();

        Thread.sleep(
                3000);

        /*
         * Recipe Details
         */
        String recipeName =
                "Automation Test Recipe";

        String cookingTime =
                "15";

        String servingTime =
                "10";

        String servingLimit =
                "4";

        String recipeSummary =
                "This is an automation test recipe.";

        String recipeStep =
                "1 Kg Sugar";

        String proTipText =
                "Serve immediately for the best taste.";

        /*
         * Recipe Classification
         */
       

        String cuisineName =
                "South Asian";

        String dietaryName =
                "Vegetarian";

        String occasionName =
                "Diwali";

        String difficultyName =
                "Beginner";

        String attributeName =
                "Comfort food";

        /*
         * Recipe Source Details
         */
        String link =
                "https://example.com";

        String sourcedFrom =
                "Automation Test Source";

        /*
         * Complete Add Recipe Flow
         */
        addRecipe.createRecipe(
                recipeName,
                cookingTime,
                servingTime,
                servingLimit,
                recipeSummary,
                recipeStep,
                proTipText,
                cuisineName,
                dietaryName,
                occasionName,
                difficultyName,
                attributeName,
                link,
                sourcedFrom);

        /*
         * Allow Recipe Submission To Complete
         */
        Thread.sleep(
                3000);
                
        hamburger.clickBackButton();

        Thread.sleep(2000);
          
        homeDashboard.clickHomeButton(); 

        Thread.sleep(3000);

        /*
         * Open Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is  displayed.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Logout Super User
         */
        hamburger.clickSignOut();
        

        System.out.println(
                "==================================================");

        System.out.println(
                "Add Recipe test completed successfully.");

        System.out.println(
                "Recipe created : "
                        + recipeName);

        System.out.println(
                "==================================================");
    }
}