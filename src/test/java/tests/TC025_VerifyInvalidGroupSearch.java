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

public class TC025_VerifyInvalidGroupSearch extends BaseTest {

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
    public void verifyInvalidGroupSearch()
            throws Exception {

        String invalidGroupName =
                "Invalid Group " + System.currentTimeMillis();

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

        hamburger.hideKeyboardIfVisible();;

        hamburger.clickGroupManagement();

        Thread.sleep(3000);

        /*
         * Navigate to Groups Dashboard
         */
        groupManagement.clickViewAllGroups();

        Thread.sleep(3000);

        /*
         * Scroll to load all groups
         */
        groupManagement.hideKeyboard();

        groupManagement.scrollGroupsList();

        Thread.sleep(3000);

        /*
         * Search Invalid Group
         */
        groupManagement.enterGroupSearch(
                invalidGroupName);

        groupManagement.hideKeyboard();

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

        groupManagement.hideKeyboard();

        /*
         * Verify No Groups Found Message
         */
        ValidationUtil.verifyTrue(
                groupManagement.isNoGroupsCreatedYetMessageDisplayed(),
                "No Groups Created Yet message is displayed.");

        System.out.println(
                "TC025_VerifyInvalidGroupSearch executed successfully.");
    }
}