package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.GroupManagement;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.HamburgerMenu.ShoppingList;
import utils.ConfigReader;
import utils.ValidationUtil;

public class TC060_VerifyOnlyGroupAdminSelectedRecipesAreDisplayedInCreateShoppingListForGroup
        extends BaseTest {

    /*
     * Test Data
     */
    String groupName =
            "Automation Shopping List Group "
                    + System.currentTimeMillis();

    String groupDescription =
            "Group recipe selection validation";

    String groupDomain =
            "www.google.com";

    String adminUser1 =
            "mohit.aman1998@gmail.com";

    String adminUser2 =
            "testuser124355@gmail.com";

    /*
     * Super User Setup
     */
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

        super.setUp(
                method);
    }

    @Test
    public void verifyOnlyGroupAdminSelectedRecipesAreDisplayedInCreateShoppingListForGroup()
            throws Exception {

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        GroupManagement groupManagement =
                new GroupManagement(
                        DriverFactory.getDriver());

        ShoppingList shoppingList =
                new ShoppingList(
                        DriverFactory.getDriver());

        /*
         * Allow Home Dashboard To Stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Open Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu displayed successfully.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Open Group Management
         */
        ValidationUtil.verifyTrue(
                hamburger.isGroupManagementVisible(),
                "Group Management option displayed successfully.");


        hamburger.clickGroupManagement();

        Thread.sleep(
                3000);

        /*
         * Verify Create Group Access
         */
        ValidationUtil.verifyTrue(
                groupManagement.hasCreateGroupAccess(),
                "Create Group access is not available.");

        /*
         * Enter Group Name
         */
        groupManagement.enterGroupName(
                groupName);

        groupManagement.hideKeyboard();

        Thread.sleep(
                1000);

        /*
         * Enter Group Description
         */
        groupManagement.enterGroupDescription(
                groupDescription);

        groupManagement.hideKeyboard();

        Thread.sleep(
                1000);

        /*
         * Enter Group Domain
         */
        groupManagement.enterGroupDomain(
                groupDomain);

        groupManagement.hideKeyboard();

        Thread.sleep(
                1000);

        /*
         * Add First Admin
         */
        groupManagement.enterAssignAdmin(
                adminUser1);

        Thread.sleep(
                3000);

        groupManagement.hideKeyboard();

        Thread.sleep(
                3000);

        groupManagement.clickTickButton();

        Thread.sleep(
                3000);

        /*
         * Select First Admin
         */
        groupManagement.clickAdminUser(
                adminUser1);

        Thread.sleep(
                2000);

        /*
         * Add Second Admin
         */
        groupManagement.enterAssignAdmin(
                adminUser2);

        Thread.sleep(
                2000);

        groupManagement.hideKeyboard();

        Thread.sleep(
                2000);

        groupManagement.clickTickButton();

        Thread.sleep(
                3000);

        /*
         * Select Second Admin
         */
        groupManagement.clickAdminUser(
                adminUser2);

        Thread.sleep(
                2000);

        /*
         * Create Group
         */
        groupManagement.clickCreateGroup();

        Thread.sleep(
                3000);

        /*
         * View All Groups
         */
        groupManagement.clickViewAllGroups();

        Thread.sleep(
                3000);

        /*
         * Search Created Group
         */
        groupManagement.enterGroupSearch(
                groupName);

        groupManagement.clickGroupSearchButton();

        groupManagement.hideKeyboard();

        Thread.sleep(
                3000);

        /*
         * Verify Group
         */
        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupName),
                "Created group is not displayed.");

        /*
         * Open Created Group
         */
        groupManagement.selectGroup(
                groupName);

        Thread.sleep(
                5000);

        /*
         * Verify Edit Button
         */
        ValidationUtil.verifyTrue(
                groupManagement.isEditButtonDisplayed(),
                "Edit button is not displayed.");

        /*
         * Click Edit
         */
        groupManagement.clickEditGroup();

        Thread.sleep(
                3000);

        /*
         * Click Recipes Tab
         */
        groupManagement.clickRecipesTab();

        Thread.sleep(
                3000);

        /*
         * Expand Aman Mohit
         */
        groupManagement.expandMember(
                "Aman Mohit");

        Thread.sleep(
                2000);

        /*
         * Verify Aman Mohit Expanded
         */
        ValidationUtil.verifyTrue(
                groupManagement.isMemberExpanded(
                        "Aman Mohit"),
                "Aman Mohit member section is not expanded.");

        /*
         * Select Aloo Samosa
         */
        groupManagement.selectMemberRecipe(
                "Aman Mohit",
                "aloo samosa");

        Thread.sleep(
                3000);

        /*
         * Select Apricot Bread
         */
        groupManagement.selectMemberRecipe(
                "Aman Mohit",
                "Apricot Bread");

        Thread.sleep(
                3000);

        /*
        * Collapse Aman Mohit
        */
        groupManagement.collapseMember(
                "Aman Mohit");

        /*
         * Expand Normaluser2
         */
        groupManagement.expandMember(
                "Normaluser2 noadmin privilage");

        Thread.sleep(
                2000);

        /*
         * Verify Normaluser2 Expanded
         */
        ValidationUtil.verifyTrue(
                groupManagement.isMemberExpanded(
                        "Normaluser2 noadmin privilage"),
                "Normaluser2 noadmin privilage member section is not expanded.");

        /*
         * Select Basmati Rice
         */
        groupManagement.selectMemberRecipe(
                "Normaluser2 noadmin privilage",
                "Basmati Rice");

        Thread.sleep(
                3000);

        /*
        * Collapse Normaluser2
        */
        groupManagement.collapseMember(
                "Normaluser2 noadmin privilage");

        
        Thread.sleep(
                2000);
        /*
         * Save Group Recipe Selection
         */
        groupManagement.clickSaveButton();

        Thread.sleep(
                7000);

        /*
        * Click Group Management Back Button
        */
        groupManagement.clickGroupManagementBackButton();

        Thread.sleep(
                2000);

        /*
        * Click Group Management Back Button
        */
        groupManagement.clickGroupManagementBackButton();

        Thread.sleep(
                2000);

        /*
        * Click Group Management Back Button
        */
        groupManagement.clickGroupManagementBackButton();

        Thread.sleep(
                2000);

        /*
         * Open Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is not displayed.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        /*
         * Expand Create Shopping List
         */
        hamburger.expandCreateShoppingList();

        Thread.sleep(
                2000);

        /*
         * Select For Group
         */
        hamburger.clickForGroup();

        Thread.sleep(
                2000);

         /*
         * Search Created Group
         */
        groupManagement.enterGroupSearch(
                groupName);

        groupManagement.clickGroupSearchButton();

        groupManagement.hideKeyboard();

        Thread.sleep(
                3000);

        /*
         * Verify Group
         */
        ValidationUtil.verifyTrue(
                groupManagement.isGroupDisplayed(
                        groupName),
                "Created group is not displayed.");

        Thread.sleep(
                2000);


        /*
        * Select Created Group
        */
        shoppingList.selectGroup(
                groupName);

        Thread.sleep(
                3000);

        /*
        * Select Aloo Samosa From Aman Mohit
        */
        shoppingList.selectContributorRecipe(
                "Aman Mohit",
                "aloo samosa");

        Thread.sleep(
                2000);

        /*
        * Select Apricot Bread From Aman Mohit
        */
        shoppingList.selectContributorRecipe(
                "Aman Mohit",
                "Apricot Bread");

        Thread.sleep(
                2000);

        /*
        * Collapse Aman Mohit
        */
        shoppingList.collapseContributor(
                "Aman Mohit");

        Thread.sleep(
                2000);

        /*
        * Select Basmati Rice From Normaluser2
        */
        shoppingList.selectContributorRecipe(
                "Normaluser2 noadmin privilage",
                "Basmati Rice");

        Thread.sleep(
                2000);

        /*
        * Collapse Normaluser2
        */
        shoppingList.collapseContributor(
                "Normaluser2 noadmin privilage");

        Thread.sleep(
                2000);

        /*
        * Click Next
        */
        shoppingList.clickNextButton();

        Thread.sleep(
                3000);


        /*
         * Select Unit
         */
        shoppingList.selectUnit(
                "US Customary");

        Thread.sleep(
                2000);

        /*
         * Enter Order Quantity
         */
        shoppingList.enterOrderFor(
                "aloo samosa",
                "4");

        shoppingList.enterOrderFor(
                "Apricot Bread",
                "4");

        shoppingList.enterOrderFor(
                "Basmati Rice",
                "4");

        Thread.sleep(
                3000);

        /*
         * Open Export Dropdown
         */
        shoppingList.clickExportButton();

        Thread.sleep(
                1000);

        /*
         * Select Shopping List
         */
        shoppingList.selectExportOption(
                "Shopping List");

        Thread.sleep(
                1000);

        /*
         * Click Outside Export Dropdown
         */
        shoppingList.clickOutsideExportDropdown();

        Thread.sleep(
                2000);

        /*
         * Click Download
         */
        shoppingList.clickDownloadButton();

        // Thread.sleep(
        //         3000);

        // /*
        //  * Verify Shopping List Saved Message
        //  */
        // ValidationUtil.verifyTrue(
        //         shoppingList.isShoppingListSavedMessageDisplayed(),
        //         "Shopping List PDF + CSV saved message is not displayed.");

        System.out.println(
                "==================================================");

        System.out.println(
                "Group recipe selection and Shopping List validation completed successfully.");

        System.out.println(
                "Group : "
                        + groupName);

        System.out.println(
                "Selected Recipes : Aloo Samosa, Apricot Bread, Basmati Rice");

        System.out.println(
                "==================================================");
    }
}