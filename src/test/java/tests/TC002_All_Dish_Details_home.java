package tests;

import java.util.Set;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Home.HomeDashboard;
import utils.ValidationUtil;

public class TC002_All_Dish_Details_home extends BaseTest {

    @Test
    public void verifyAllDishDetailsOnHomeDashboard() {

        /*
         * Create Home Dashboard object
         */
        HomeDashboard dashboard =
                new HomeDashboard(
                        DriverFactory.getDriver());

        /*
         * Fetch all dishes from dashboard
         */
        Set<String> dishes =
                dashboard.getAllDashboardDishes();

        /*
         * Print all dishes
         */
        for (String dish : dishes) {

            System.out.println(
                    dish);

            System.out.println(
                    "------------------------------------------------");
        }

        /*
         * Validation
         */
        ValidationUtil.verifyTrue(
                dishes.size() > 0,
                "Recipes are displayed on Home Dashboard.");

        System.out.println(
                "Total Recipes Found : "
                        + dishes.size());

        System.out.println(
                "Completed Test Case : AllDishDetailshome");

        System.out.println(
                "==================================================");
    }
}