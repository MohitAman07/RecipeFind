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

public class TC027_VerifyMandatoryFieldValidation extends BaseTest {

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
    public void verifyMandatoryFieldValidation()
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
         * Click Create Group without entering mandatory fields
         */
        groupManagement.hideKeyboard();

        groupManagement.clickCreateGroup();

        Thread.sleep(3000);

        /*
         * Verify Mandatory Field Validation
         */
        ValidationUtil.verifyTrue(
                groupManagement.isGroupNameRequiredMessageDisplayed(),
                "Group Name mandatory validation is displayed.");

        ValidationUtil.verifyTrue(
                groupManagement.isGroupDescriptionRequiredMessageDisplayed(),
                "Group Description mandatory validation is displayed.");

        System.out.println(
                "TC027_VerifyMandatoryFieldValidation executed successfully.");
    }
}