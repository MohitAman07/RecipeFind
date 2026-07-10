package tests;

import base.BaseTest;

import driver.DriverFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObjects.Home.HomeDashboard;

import java.util.Set;

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

            System.out.println(dish);

            System.out.println(
                    "------------------------------------------------");
        }

        /*
         * Validation
         */
        Assert.assertTrue(
                dishes.size() > 0,
                "No dishes were found on the Home Dashboard.");

        System.out.println(
                "Total Dishes Found : "
                        + dishes.size());
    }
}