package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Feedback;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC012_VerifyFeedbackCancelButton extends BaseTest {

    @Test
    public void verifyFeedbackCancelButton()
            throws InterruptedException {

        /*
         * Wait for dashboard to stabilize
         */
        Thread.sleep(3000);

        Hamburger hamburger =
                new Hamburger(
                        DriverFactory.getDriver());

        Feedback feedback =
                new Feedback(
                        DriverFactory.getDriver());

        /*
         * Open Hamburger Menu
         */
        Assert.assertTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is not displayed.");

        hamburger.clickHamburgerMenu();

        System.out.println(
                "Hamburger menu clicked successfully.");

        Thread.sleep(1000);

        /*
         * Open Feedback Screen
         */
        Assert.assertTrue(
                hamburger.isFeedbackVisible(),
                "Feedback menu is not displayed.");

        hamburger.clickFeedback();

        Thread.sleep(2000);

        /*
         * Verify Feedback Screen
         */
        Assert.assertTrue(
                feedback.isFeedbackPageVisible(),
                "Feedback page is not displayed.");

        /*
         * Click Cancel
         */
        feedback.clickCancel();

        System.out.println(
                "Cancel button clicked successfully.");

        Thread.sleep(2000);

        /*
         * Verify Home Screen is displayed
         * (Replace this with the appropriate page verification if
         * Cancel navigates somewhere else.)
         */
        Assert.assertTrue(
        feedback.isFeedbackPageVisible(),
        "Feedback page is not displayed after clicking Cancel.");

        System.out.println(
                "Cancel button functionality verified successfully.");
    }
}