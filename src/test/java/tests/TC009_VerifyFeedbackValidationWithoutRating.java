package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Feedback;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC009_VerifyFeedbackValidationWithoutRating extends BaseTest {

    @Test
    public void verifyFeedbackValidationWithoutRating()
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
         * Verify Hamburger Menu
         */
        Assert.assertTrue(
                hamburger.isHamburgerMenuVisible(),
                "Hamburger menu is not displayed.");

        /*
         * Open Hamburger Menu
         */
        hamburger.clickHamburgerMenu();

        System.out.println(
                "Hamburger menu clicked successfully.");

        Thread.sleep(1000);

        /*
         * Verify Feedback Menu
         */
        Assert.assertTrue(
                hamburger.isFeedbackVisible(),
                "Feedback menu is not displayed.");

        /*
         * Open Feedback Screen
         */
        hamburger.clickFeedback();

        System.out.println(
                "Feedback menu clicked successfully.");

        Thread.sleep(2000);

        /*
         * Verify Feedback Screen
         */
        Assert.assertTrue(
                feedback.isFeedbackPageVisible(),
                "Feedback page is not displayed.");

        System.out.println(
                "Feedback page displayed successfully.");

        /*
         * Click Submit Without Selecting Rating
         */
        feedback.clickSubmit();

        System.out.println(
                "Submit button clicked successfully without selecting a rating.");

        Thread.sleep(1000);

        /*
         * Verify Validation Message Displayed
         */
        Assert.assertTrue(
                feedback.isSelectRatingValidationVisible(),
                "Please select a rating validation is not displayed.");

        System.out.println(
                "Validation message displayed successfully.");

        /*
         * Verify Validation Message Text
         */
        Assert.assertEquals(
                feedback.getSelectRatingValidationText(),
                "Please select a rating",
                "Incorrect validation message displayed.");

        System.out.println(
                "Validation message verified successfully.");
    }
}