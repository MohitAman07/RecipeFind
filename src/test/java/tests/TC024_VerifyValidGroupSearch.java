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

public class TC024_VerifyValidGroupSearch extends BaseTest {

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
    public void verifyValidGroupSearch()
            throws Exception {

        String groupName =
                "Automation Group " + System.currentTimeMillis();

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
         * Navigate to Group Management
         */
        hamburger.clickHamburgerMenu();

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
         * Search Created Group
         */
        groupManagement.enterGroupSearch(
                groupName);

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);
        
        groupManagement.hideKeyboard();
        /*
         * Verify Search Result
         */
        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupName),
                "Created group is displayed successfully.");

        System.out.println(
                "TC024_VerifyValidGroupSearch executed successfully.");
    }
}