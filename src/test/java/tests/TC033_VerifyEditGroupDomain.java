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

public class TC033_VerifyEditGroupDomain extends BaseTest {

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
    public void verifyEditGroupDomain()
            throws Exception {

        String groupName =
                "Automation Group "
                        + System.currentTimeMillis();

        String groupDescription =
                "Automation Group Description";

        String groupDomain =
                "www.google.com";

        String updatedGroupDomain =
                "www.updatedgoogle.com";

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
         * Open Group
         */
        groupManagement.selectGroup(
                groupName);

        Thread.sleep(3000);

        ValidationUtil.verifyTrue(
                groupManagement.isEditButtonDisplayed(),
                "Edit button displayed successfully.");

        /*
         * Edit Group Domain
         */
        groupManagement.clickEditGroup();

        Thread.sleep(3000);

        groupManagement.hideKeyboard();

        groupManagement.clearGroupDomain();

        groupManagement.enterUpdatedGroupDomain(
                updatedGroupDomain);

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        groupManagement.clickSaveButton();

        Thread.sleep(5000);

        hamburger.clickBackButton();

        /*
         * Search Updated Group
         */
        groupManagement.enterGroupSearch(
                groupName);

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

        groupManagement.hideKeyboard();

        /*
         * Open Updated Group
         */
        groupManagement.selectGroup(
                groupName);

        Thread.sleep(3000);

        groupManagement.clickEditGroup();

        Thread.sleep(3000);

        /*
         * Verify Updated Group Domain
         */
        ValidationUtil.verifyTrue(
                groupManagement.isGroupDomainDisplayed(
                        updatedGroupDomain),
                "Group Domain updated successfully.");

        System.out.println(
                "TC033_VerifyEditGroupDomain executed successfully.");
    }
}