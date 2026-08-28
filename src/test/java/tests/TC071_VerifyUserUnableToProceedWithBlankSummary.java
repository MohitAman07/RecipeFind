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

public class TC071_VerifyUserUnableToProceedWithBlankSummary
        extends BaseTest {

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
    public void verifyUserUnableToProceedWithBlankSummary()
            throws Exception {

        AddRecipe addRecipe =
                new AddRecipe(
                        DriverFactory.getDriver());

        HomeDashboard homeDashboard =
                new HomeDashboard(
                        DriverFactory.getDriver());

        Hamburger hamburger=new Hamburger(DriverFactory.getDriver());

        /*
         * Allow Home Dashboard To Stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Open Contribute
         */
        homeDashboard.clickContributeButton();

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

        /*
         * Enter Recipe Name
         */
        addRecipe.enterRecipeName(
                recipeName);

        /*
         * Enter Cooking Time
         */
        addRecipe.enterCookingTime(
                cookingTime);

        /*
         * Enter Serving Time
         */
        addRecipe.enterServingTime(
                servingTime);

        /*
         * Enter Serving Limit
         */
        addRecipe.enterServingLimit(
                servingLimit);

        /*
         * Leave Recipe Summary Empty
         */

        /*
         * Click Proceed
         */
        addRecipe.clickProceed();

        Thread.sleep(
                1500);

        /*
         * Verify Recipe Summary Error Message
         */
        addRecipe.verifyRecipeSummaryErrorMessage();

        Thread.sleep(500);

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
                "Recipe summary validation verified successfully.");

        System.out.println(
                "User cannot proceed with a blank recipe summary.");

        System.out.println(
                "==================================================");
    }
}