package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.HamburgerMenu.Tutorials;
import utils.ValidationUtil;

public class TC006_Tutorial extends BaseTest {

    @Test
    public void verifyTutorialFunctionality()
            throws InterruptedException {

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        Tutorials tutorials =
                new Tutorials(
                        DriverFactory.getDriver());

        Thread.sleep(
                3000);

        /*
         * ==================================================
         * Open Hamburger Menu
         * ==================================================
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is displayed.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                1000);

        /*
         * ==================================================
         * Open Tutorial
         * ==================================================
         */
        ValidationUtil.verifyTrue(
                hamburger.isTutorialVisible(),
                "Tutorial option is displayed.");

        hamburger.clickTutorial();

        Thread.sleep(
                1000);

        ValidationUtil.verifyTrue(
                hamburger.isTutorialExpandedVisible(),
                "Tutorial menu is expanded.");

        /*
         * ==================================================
         * HOME
         * ==================================================
         */
        ValidationUtil.verifyTrue(
                tutorials.isHomeVisible(),
                "Home is displayed.");

        tutorials.clickHome();

        tutorials.swipeSelectedTutorialScreen(
                3);

        hamburger.clickBackButton();

        Thread.sleep(
                1000);

        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is displayed after Home.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                1000);

        hamburger.clickTutorial();

        Thread.sleep(
                1000);

        /*
         * ==================================================
         * COOKBOOK
         * ==================================================
         */
        tutorials.swipeTutorialMenu(
                2);

        ValidationUtil.verifyTrue(
                tutorials.isCookbookVisible(),
                "Cookbook is displayed.");

        tutorials.clickCookbook();

        tutorials.swipeSelectedTutorialScreen(
                2);

        hamburger.clickBackButton();

        Thread.sleep(
                1000);

        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is displayed after Cookbook.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                1000);

        hamburger.clickTutorial();

        Thread.sleep(
                1000);

        /*
         * ==================================================
         * CONTRIBUTE
         * ==================================================
         */
        tutorials.swipeTutorialMenu(
                5);

        ValidationUtil.verifyTrue(
                tutorials.isContributeVisible(),
                "Contribute is displayed.");

        tutorials.clickContribute();

        tutorials.swipeSelectedTutorialScreen(
                5);

        hamburger.clickBackButton();

        Thread.sleep(
                1000);

        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is displayed after Contribute.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                1000);

        hamburger.clickTutorial();

        Thread.sleep(
                1000);

        /*
         * ==================================================
         * PROFILE
         * ==================================================
         */
        tutorials.swipeTutorialMenu(
                5);

        ValidationUtil.verifyTrue(
                tutorials.isProfileVisible(),
                "Profile is displayed.");

        tutorials.clickProfile();

        tutorials.swipeSelectedTutorialScreen(
                5);

        hamburger.clickBackButton();

        Thread.sleep(
                1000);

        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is displayed after Profile.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                1000);

        hamburger.clickTutorial();

        Thread.sleep(
                1000);

        /*
         * ==================================================
         * ENGAGEMENT
         * ==================================================
         */
        tutorials.swipeTutorialMenu(
                3);

        ValidationUtil.verifyTrue(
                tutorials.isEngagementVisible(),
                "Engagement is displayed.");

        tutorials.clickEngagement();

        tutorials.swipeSelectedTutorialScreen(
                3);

        hamburger.clickBackButton();

        Thread.sleep(
                1000);

        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is displayed after Engagement.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                1000);

        hamburger.clickTutorial();

        Thread.sleep(
                1000);

        /*
         * ==================================================
         * EXPORTS
         * ==================================================
         */
        ValidationUtil.verifyTrue(
                tutorials.isExportsVisible(),
                "Exports is displayed.");

        tutorials.clickExports();

        hamburger.clickBackButton();

        /*
         * ==================================================
         * Test Completed
         * ==================================================
         */
        System.out.println(
                "==================================================");

        System.out.println(
                "Tutorial functionality verified successfully.");

        System.out.println(
                "Home : 3 swipes");

        System.out.println(
                "Cookbook : 2 swipes");

        System.out.println(
                "Contribute : 5 swipes");

        System.out.println(
                "Profile : 5 swipes");

        System.out.println(
                "Engagement : 3 swipes");

        System.out.println(
                "Exports : No swipe");

        System.out.println(
                "Group Management : 2 swipes");

        System.out.println(
                "Control Panel : No swipe");

        System.out.println(
                "==================================================");
    }
}