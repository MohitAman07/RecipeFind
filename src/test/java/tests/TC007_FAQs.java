package tests;

import base.BaseTest;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObjects.HamburgerMenu.Hamburger;
import pagesObjects.HamburgerMenu.FAQs;

public class TC007_FAQs extends BaseTest {

    @Test
    public void verifyFAQsFunctionality()
            throws InterruptedException {

        System.out.println(
                "==================================================");

        System.out.println(
                "Executing Test Case : verifyFAQsFunctionality");

        System.out.println(
                "==================================================");

        /*
         * Wait For Home Dashboard To Stabilize
         */
        Thread.sleep(9000);

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        FAQs faqs =
                new FAQs(
                        DriverFactory.getDriver());

        /*
         * Verify Hamburger Menu Visibility
         */
        Assert.assertTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is not displayed.");

        System.out.println(
                "Hamburger menu displayed successfully.");

        /*
         * Open Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        Thread.sleep(2000);

        System.out.println(
                "Hamburger menu clicked successfully.");

        /*
         * Verify FAQs Option
         */
        Assert.assertTrue(
                hamburger.isFAQsVisible(),
                "FAQs option is not displayed.");

        System.out.println(
                "FAQs option displayed successfully.");

        /*
         * Click FAQs
         */
        hamburger.clickFAQs();

        Thread.sleep(9000);

        System.out.println(
                "FAQs option clicked successfully.");

        /*
         * Verify FAQ Screen
         */
        Assert.assertTrue(
                faqs.isFAQScreenVisible(),
                "FAQ screen is not displayed.");

        System.out.println(
                "FAQ screen displayed successfully.");

        /*
         * Bring FAQ Content Below Logo
         */
        faqs.bringFAQContentIntoView();

        Thread.sleep(2000);

        System.out.println(
                "FAQ content positioned successfully.");

        /*
         * Fetch All FAQ Questions And Answers
         */
        System.out.println(
                "==================================================");

        System.out.println(
                "Fetching FAQ Questions And Answers");

        System.out.println(
                "==================================================");

        faqs.getAllFAQQuestionsAndAnswers();

        /*
         * Scroll FAQ Back To Top
         */
        faqs.scrollFAQToTop();

        Thread.sleep(2000);

        /*
         * Verify Back Button
         */
        Assert.assertTrue(
                hamburger.isBackButtonVisible(),
                "Back button is not displayed.");

        /*
         * Navigate Back To Home
         */
        hamburger.clickBackButton();

        Thread.sleep(2000);

        hamburger.hideKeyboardIfVisible();

        System.out.println(
                "Back button clicked successfully.");

        System.out.println(
                "==================================================");

        System.out.println(
                "Completed Test Case : verifyFAQsFunctionality");

        System.out.println(
                "==================================================");
    }
}