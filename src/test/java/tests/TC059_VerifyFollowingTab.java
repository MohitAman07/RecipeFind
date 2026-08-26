package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Profile.Following_Tab;
import utils.ConfigReader;
import utils.ValidationUtil;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC059_VerifyFollowingTab extends BaseTest {

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
    public void verifyFollowingTabDetails()
            throws Exception {

        String personName =
                "Rupsy S.";

        Following_Tab following =
                new Following_Tab(
                        DriverFactory.getDriver());

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        /*
         * Allow Home Dashboard To Stabilize
         */
        Thread.sleep(
                3000);

        /*
         * Open Profile Tab
         */
        following.Click_Profile_Tab();

        Thread.sleep(
                2000);

        /*
         * Open Following Tab
         */
        following.Click_Following_Tab();

        Thread.sleep(
                2000);

        /*
         * Refresh Following List
         */
        following.refreshFollowingList();

        Thread.sleep(
                3000);

        /*
         * Follow Person
         *
         * Person tile is used only as an anchor.
         * Follow button is clicked separately.
         */
        following.followPerson(
                personName);

        Thread.sleep(
                2000);

        /*
         * Verify Following Count
         */
        following.Verify_Following_count();

        Thread.sleep(
                2000);

       /*
         * Open Hamburger Menu
         */
        ValidationUtil.verifyTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu displayed successfully.");

        hamburger.clickHamburgerMenu();

        Thread.sleep(
                2000);

        hamburger.clickSignOut();        


        System.out.println(
                "==================================================");

        System.out.println(
                "Following tab details verified successfully.");

        System.out.println(
                "Person followed : "
                        + personName);

        System.out.println(
                "==================================================");
    }
}