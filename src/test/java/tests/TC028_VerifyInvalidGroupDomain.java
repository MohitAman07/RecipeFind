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

public class TC028_VerifyInvalidGroupDomain extends BaseTest {

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
    public void verifyInvalidGroupDomain()
            throws Exception {

        String groupName =
                "Automation Group " + System.currentTimeMillis();

        String groupDescription =
                "Automation Group Description";

        String invalidDomain =
                "invaliddomain";

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

         groupManagement.hideKeyboard();

        Thread.sleep(3000);

        hamburger.clickGroupManagement();

         groupManagement.hideKeyboard();

         Thread.sleep(3000);

        /*
         * Verify Create Group Dashboard
         */
        ValidationUtil.verifyTrue(
                groupManagement.isCreateGroupHeadingDisplayed(),
                "Create Group heading is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isCreateGroupButtonDisplayed(),
                "Create Group button is displayed.");

        /*
         * Enter Group Details
         */
        groupManagement.hideKeyboard();

        groupManagement.enterGroupName(
                groupName);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDescription(
                groupDescription);

        groupManagement.hideKeyboard();

        groupManagement.enterGroupDomain(
                invalidDomain);

        groupManagement.hideKeyboard();

        /*
         * Click Create Group
         */
        groupManagement.clickCreateGroup();

        Thread.sleep(3000);

        /*
         * Verify Invalid Domain Validation
         */
        ValidationUtil.verifyTrue(
                groupManagement.isInvalidDomainMessageDisplayed(),
                "Invalid domain validation is displayed.");

        System.out.println(
                "TC028_VerifyInvalidGroupDomain executed successfully.");
    }
}