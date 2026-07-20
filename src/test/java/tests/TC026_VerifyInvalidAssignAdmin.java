package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.GroupManagement;
import pagesObjects.HamburgerMenu.Hamburger;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC026_VerifyInvalidAssignAdmin extends BaseTest {

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

        super.setUp(method);
    }

    @Test
    public void verifyInvalidAssignAdmin()
            throws Exception {

        String invalidAdmin =
                "invaliduser@test.com";

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        GroupManagement groupManagement =
                new GroupManagement(
                        DriverFactory.getDriver());

        /*
         * Navigate to Group Management
         */
        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(3000);

        hamburger.clickGroupManagement();

        Thread.sleep(3000);

        /*
         * Enter Invalid Admin
         */
        groupManagement.hideKeyboard();

        groupManagement.enterAssignAdmin(
                invalidAdmin);

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        /*
         * Search Admin User
         */
        groupManagement.clickTickButton();

        groupManagement.hideKeyboard();

        Thread.sleep(3000);

        /*
         * Verify User Not Found Message
         */
        ValidationUtil.verifyTrue(
                groupManagement.isUserNotFoundMessageDisplayed(),
                "User not found message is displayed.");

        System.out.println(
                "TC026_VerifyInvalidAssignAdmin executed successfully.");
    }
}