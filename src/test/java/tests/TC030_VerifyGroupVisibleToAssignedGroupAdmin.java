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

public class TC030_VerifyGroupVisibleToAssignedGroupAdmin extends BaseTest {

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
    public void verifyGroupVisibleToAssignedGroupAdmin()
            throws Exception {

        String groupName =
                "Automation Group "
                        + System.currentTimeMillis();

        String groupDescription =
                "Automation Group Description";

        String groupDomain =
                "www.google.com";

        String adminUser =
                ConfigReader.getProperty(
                        "groupadmin.email");

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        GroupManagement groupManagement =
                new GroupManagement(
                        DriverFactory.getDriver());

        /*
         * Navigate To Group Management
         */
        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(3000);

        hamburger.clickGroupManagement();

        Thread.sleep(3000);

        /*
         * Create New Group
         */
        groupManagement.hideKeyboard();

        Thread.sleep(2000);

        groupManagement.enterGroupName(
                groupName);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDescription(
                groupDescription);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDomain(
                groupDomain);

        groupManagement.hideKeyboard();

        groupManagement.enterAssignAdmin(
                adminUser);

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        groupManagement.clickTickButton();

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        groupManagement.clickAdminUser(
                adminUser);

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        groupManagement.clickCreateGroup();

        Thread.sleep(4000);

        /*
         * Navigate To Groups Dashboard
         */
        groupManagement.clickViewAllGroups();

        Thread.sleep(3000);

        groupManagement.hideKeyboard();

        groupManagement.scrollGroupsList();

        Thread.sleep(3000);

        /*
         * Search Created Group
         */
        groupManagement.enterGroupSearch(
                groupName);

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

        groupManagement.hideKeyboard();

        /*
         * Verify Group Created
         */
        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupName),
                "Group created successfully.");

        /*
         * Logout Super Admin
         */
        Thread.sleep(3000);

        hamburger.clickBackButton();

        Thread.sleep(3000);

        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(3000);

        hamburger.clickSignOut();

        Thread.sleep(8000);

        /*
         * Login As Group Admin
         */
        authenticateUser(
                ConfigReader.getProperty(
                        "groupadmin.email"),
                ConfigReader.getProperty(
                        "groupadmin.password"));

        ensureApplicationReady();

        Thread.sleep(5000);

        /*
         * Reinitialize Page Objects
         */
        hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        groupManagement =
                new GroupManagement(
                        DriverFactory.getDriver());

        /*
         * Navigate To Group Management
         * (Group Admin lands directly on Groups Dashboard)
         */
        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(3000);

        hamburger.clickGroupManagement();

        Thread.sleep(3000);

        /*
         * Search Created Group
         */
        groupManagement.hideKeyboard();

        groupManagement.enterGroupSearch(
                groupName);

        groupManagement.hideKeyboard();

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

        /*
         * Verify Created Group Is Visible
         */
        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupName),
                "Created group is visible for assigned Group Admin.");

        System.out.println(
                "TC030_VerifyGroupVisibleToAssignedGroupAdmin executed successfully.");
    }
}