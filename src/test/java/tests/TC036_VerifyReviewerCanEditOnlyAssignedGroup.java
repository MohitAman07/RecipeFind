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

public class TC036_VerifyReviewerCanEditOnlyAssignedGroup extends BaseTest {

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
    public void verifyReviewerCanEditOnlyAssignedGroup()
            throws Exception {

        String groupA =
                "Reviewer Group A "
                        + System.currentTimeMillis();

        String groupB =
                "Reviewer Group B "
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
         * Create Group A
         */
        groupManagement.enterGroupName(
                groupA);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDescription(
                description);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDomain(
                domain);

        groupManagement.hideKeyboard();

        /*
         * Add Group Admin
         */
        groupManagement.enterAssignAdmin(
                groupAdmin);

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        groupManagement.clickTickButton();

        Thread.sleep(2000);

        groupManagement.clickAdminUser(
                groupAdmin);

        Thread.sleep(2000);

        /*
         * Add Reviewer As Admin
         */
        groupManagement.enterAssignAdmin(
                reviewer);

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        Thread.sleep(3000);

        groupManagement.clickTickButton();

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        Thread.sleep(3000);

        groupManagement.clickAdminUser(
                reviewer);

        
        Thread.sleep(2000);

        groupManagement.clickCreateGroup();

        Thread.sleep(5000);

        /*
         * Verify Group A
         */
        groupManagement.clickViewAllGroups();

        Thread.sleep(3000);

        groupManagement.enterGroupSearch(
                groupA);

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupA),
                "Group A created successfully.");

        hamburger.clickBackButton();

        Thread.sleep(3000);

        /*
         * Create Group B
         */
        groupManagement.enterGroupName(
                groupB);

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

        groupManagement.hideKeyboard();

        groupManagement.clickAdminUser(
                groupAdmin);

        Thread.sleep(2000);

        groupManagement.hideKeyboard();

        groupManagement.clickCreateGroup();

        Thread.sleep(4000);
        /*
         * Verify Group B
         */
        groupManagement.clickViewAllGroups();

        Thread.sleep(3000);

        groupManagement.enterGroupSearch(
                groupB);

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupB),
                "Group B created successfully.");

        groupManagement.selectGroup(
                groupB);

        Thread.sleep(3000);

        groupManagement.clickEditGroup();

        Thread.sleep(3000);

                /*
         * Add Reviewer As Member To Group B
         */
        groupManagement.enterMemberSearch(
                reviewer);

        groupManagement.hideKeyboard();

        Thread.sleep(2000);
        groupManagement.clickEditMemberTickButton();

        Thread.sleep(2000);

        groupManagement.clickMember(
                reviewer);

        Thread.sleep(2000);

        ValidationUtil.verifyTrue(
                groupManagement.isMemberDisplayed(
                        reviewer),
                "Reviewer added as Member successfully.");

        groupManagement.hideKeyboard();

        groupManagement.clickSaveButton();

        Thread.sleep(5000);

        /*
         * Logout Super Admin
         */
        hamburger.clickBackButton();

        Thread.sleep(3000);

        hamburger.clickBackButton();

        Thread.sleep(3000);

        hamburger.clickBackButton();

        Thread.sleep(3000);

        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(3000);

        hamburger.clickSignOut();

        Thread.sleep(8000);

        /*
         * Login As Reviewer
         */
        authenticateUser(
                ConfigReader.getProperty(
                        "reviewer.email"),
                ConfigReader.getProperty(
                        "reviewer.password"));

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
         */
        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(3000);

        hamburger.clickGroupManagement();

        Thread.sleep(3000);

        /*
         * Verify Reviewer Can Edit Group A
         */
        groupManagement.enterGroupSearch(
                groupA);

        groupManagement.hideKeyboard();

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupA),
                "Reviewer can view Group A.");

        groupManagement.selectGroup(
                groupA);

        Thread.sleep(3000);

        ValidationUtil.verifyTrue(
                groupManagement.isEditButtonDisplayed(),
                "Edit button displayed for Group A.");

        hamburger.clickBackButton();

        Thread.sleep(3000);

        /*
         * Verify Reviewer Cannot Edit Group B
         */
        groupManagement.enterGroupSearch(
                groupB);

        groupManagement.hideKeyboard();

        groupManagement.clickGroupSearchButton();

        Thread.sleep(3000);

        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupB),
                "Reviewer can view Group B.");

        groupManagement.selectGroup(
                groupB);

        Thread.sleep(3000);

        ValidationUtil.verifyFalse(
                groupManagement.isEditButtonDisplayed(),
                "Edit button should not be displayed for Group B.");

        /*
         * Logout reviewer acc 
         */
        hamburger.clickBackButton();

        Thread.sleep(3000);

        hamburger.clickBackButton();

        Thread.sleep(3000);

        hamburger.clickHamburgerMenu();

        hamburger.hideKeyboardIfVisible();

        Thread.sleep(3000);

        hamburger.clickSignOut();

        Thread.sleep(8000);      

        System.out.println(
                "TC036_VerifyReviewerCanEditOnlyAssignedGroup executed successfully.");
    }
}