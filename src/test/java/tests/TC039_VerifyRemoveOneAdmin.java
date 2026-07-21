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

public class TC039_VerifyRemoveOneAdmin extends BaseTest {

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
    public void verifyRemoveOneAdmin()
            throws Exception {

        String groupName =
                "Multiple Admin "
                        + System.currentTimeMillis();

        String description =
                "Automation Group Description";

        String domain =
                "www.google.com";

        String groupAdmin =
                ConfigReader.getProperty(
                        "groupadmin.email");

        String reviewer =
                ConfigReader.getProperty(
                        "reviewer.email");

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
         * Create Group
         */
        groupManagement.enterGroupName(
                groupName);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDescription(
                description);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDomain(
                domain);

        groupManagement.hideKeyboard();

        groupManagement.enterAssignAdmin(
                groupAdmin);

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        groupManagement.clickTickButton();

        Thread.sleep(2000);

        groupManagement.clickAdminUser(
                groupAdmin);

        Thread.sleep(2000);

        groupManagement.clickCreateGroup();

        Thread.sleep(5000);

        /*
         * Open Created Group
         */
        groupManagement.clickViewAllGroups();

        Thread.sleep(3000);

        groupManagement.enterGroupSearch(
                groupName);

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupName),
                "Group created successfully.");

        groupManagement.selectGroup(
                groupName);

        Thread.sleep(3000);

        /*
         * Add Reviewer As Member
         */
        groupManagement.clickEditGroup();

        Thread.sleep(3000);

        groupManagement.enterMemberSearch(
                reviewer);

        groupManagement.hideKeyboard();

        Thread.sleep(1000);

        groupManagement.clickEditMemberTickButton();

        Thread.sleep(2000);

        groupManagement.clickMember(
                reviewer);

        Thread.sleep(2000);

        ValidationUtil.verifyTrue(
                groupManagement.isMemberDisplayed(
                        reviewer),
                "Reviewer added successfully.");

        /*
         * Promote Reviewer To Admin
         */
        groupManagement.makeMemberAdmin(
                reviewer);

        Thread.sleep(3000);

        ValidationUtil.verifyTrue(
                groupManagement.isUserAdmin(
                        reviewer),
                "Reviewer promoted to Admin successfully.");

        groupManagement.clickSaveButton();

        Thread.sleep(5000);

        hamburger.clickBackButton();

        Thread.sleep(3000);

                /*
         * Re-open Group
         */
        groupManagement.enterGroupSearch(
                groupName);

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupName),
                "Group displayed successfully.");

        groupManagement.selectGroup(
                groupName);

        Thread.sleep(3000);

        /*
         * Open Edit Group
         */
        groupManagement.clickEditGroup();

        Thread.sleep(3000);

        /*
         * Verify Both Users Are Admins
         */
        ValidationUtil.verifyTrue(
                groupManagement.isUserAdmin(
                        groupAdmin),
                "Group Admin is displayed as Admin.");

        ValidationUtil.verifyTrue(
                groupManagement.isUserAdmin(
                        reviewer),
                "Reviewer is displayed as Admin.");

        /*
         * Remove One Admin
         */
        groupManagement.removeAdmin(
                groupAdmin);

        Thread.sleep(3000);

        groupManagement.clickSaveButton();

        Thread.sleep(5000);

        hamburger.clickBackButton();

        Thread.sleep(3000);

        /*
         * Verify Admin Removed Successfully
         */
        groupManagement.enterGroupSearch(
                groupName);

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupName),
                "Group displayed successfully.");

        groupManagement.selectGroup(
                groupName);

        Thread.sleep(3000);

        groupManagement.clickEditGroup();

        Thread.sleep(3000);

        ValidationUtil.verifyFalse(
                groupManagement.isUserAdmin(
                        groupAdmin),
                "Group Admin removed successfully.");

        ValidationUtil.verifyTrue(
                groupManagement.isUserAdmin(
                        reviewer),
                "Reviewer remains as Admin.");

    }

}