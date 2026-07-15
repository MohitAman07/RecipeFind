package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Feedback;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC011_SubmitFeedbackSuccessfully extends BaseTest {

    @Test
    public void submitFeedbackSuccessfully()
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

        System.out.println(
                "Feedback menu clicked successfully.");

        Thread.sleep(2000);

        /*
         * Verify Feedback Page
         */
        Assert.assertTrue(
                feedback.isFeedbackPageVisible(),
                "Feedback page is not displayed.");

        /*
         * Select Rating
         */
        feedback.selectEmoji(5);

        System.out.println(
                "Rating selected successfully.");

        /*
         * Enter Feedback
         */
        feedback.enterLikeMost(
                "The app is easy to use and recipes are well organized.");

        feedback.enterRecommendApp(
                "I would definitely recommend this app to my friends and family.");

        feedback.enterImprovement(
                "Please add more regional recipes and advanced search filters.");

        System.out.println(
                "Feedback details entered successfully.");

        /*
         * Submit Feedback
         */
        feedback.clickSubmit();

        System.out.println(
                "Submit button clicked successfully.");

        /*
         * Verify Successful Submission
         * (Replace this assertion with the actual success
         * message/dialog/toast verification available in your app.)
         */

        Thread.sleep(3000);
    }
}