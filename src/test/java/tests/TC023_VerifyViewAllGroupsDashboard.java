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

public class TC023_VerifyViewAllGroupsDashboard extends BaseTest {

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
    public void verifyViewAllGroupsDashboard()
            throws Exception {

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
         * Navigate to Groups Dashboard
         */
        groupManagement.clickViewAllGroups();

        Thread.sleep(3000);

        groupManagement.hideKeyboard();

        /*
         * Verify Groups Dashboard
         */
        ValidationUtil.verifyTrue(
                groupManagement.isGroupsHeadingDisplayed(),
                "Groups heading is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isGroupSearchFieldDisplayed(),
                "Group Search field is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isGroupSearchButtonDisplayed(),
                "Group Search button is displayed.");

        System.out.println(
                "TC023_VerifyViewAllGroupsDashboard executed successfully.");
    }
}