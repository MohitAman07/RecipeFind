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

public class TC022_VerifyCreateGroupDashboard extends BaseTest {

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
    public void verifyCreateGroupDashboard()
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

        Thread.sleep(3000);

        hamburger.clickGroupManagement();

        Thread.sleep(3000);

        /*
         * Verify Create Group Dashboard
         */
        ValidationUtil.verifyTrue(
                groupManagement.isCreateGroupHeadingDisplayed(),
                "Create Group heading is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isViewAllGroupsDisplayed(),
                "View All Groups option is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isGroupNameHeadingDisplayed(),
                "Group Name heading is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isGroupNameFieldDisplayed(),
                "Group Name field is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isGroupDescriptionHeadingDisplayed(),
                "Group Description heading is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isGroupDescriptionFieldDisplayed(),
                "Group Description field is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isGroupDomainHeadingDisplayed(),
                "Group Domain heading is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isGroupDomainFieldDisplayed(),
                "Group Domain field is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isAssignAdminHeadingDisplayed(),
                "Assign Admin heading is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isAssignAdminFieldDisplayed(),
                "Assign Admin field is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isTickButtonDisplayed(),
                "Tick button is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isCreateGroupButtonDisplayed(),
                "Create Group button is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isCancelButtonDisplayed(),
                "Cancel button is displayed.");

        System.out.println(
                "TC022_VerifyCreateGroupDashboard executed successfully.");
    }
}