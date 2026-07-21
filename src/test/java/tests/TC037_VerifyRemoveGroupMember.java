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

public class TC037_VerifyRemoveGroupMember extends BaseTest {

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
    public void verifyRemoveGroupMember()
            throws Exception {

        String groupName =
                "Remove Member "
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

        groupManagement.clickSaveButton();

        Thread.sleep(5000);

        hamburger.clickBackButton();

        Thread.sleep(2000);

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
         * Remove Reviewer Member
         */
        groupManagement.clickEditGroup();

        Thread.sleep(3000);

        ValidationUtil.verifyTrue(
                groupManagement.isMemberDisplayed(
                        reviewer),
                "Reviewer is available before removal.");

        groupManagement.deleteMember(
                reviewer);

        Thread.sleep(2000);

        groupManagement.clickSaveButton();

        Thread.sleep(5000);

        hamburger.clickBackButton();

        Thread.sleep(2000);

        /*
         * Verify Reviewer Removed Successfully
         */
        groupManagement.enterGroupSearch(
                groupName);

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

        groupManagement.selectGroup(
                groupName);

        Thread.sleep(3000);

        ValidationUtil.verifyFalse(
                groupManagement.isMemberDisplayed(
                        reviewer),
                "Reviewer removed successfully.");

    }

}