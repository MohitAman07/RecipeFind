package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Feedback;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC008_VerifyFeedbackScreenUI extends BaseTest {

    @Test
    public void verifyFeedbackScreenUI() throws InterruptedException {

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
         * Verify Feedback Menu
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

        System.out.println(
                "Feedback page displayed successfully.");

        /*
         * Verify Emoji 1
         */
        Assert.assertTrue(
                feedback.Emoji1.isDisplayed(),
                "Emoji 1 is not displayed.");

        /*
         * Verify Emoji 2
         */
        Assert.assertTrue(
                feedback.Emoji2.isDisplayed(),
                "Emoji 2 is not displayed.");

        /*
         * Verify Emoji 3
         */
        Assert.assertTrue(
                feedback.Emoji3.isDisplayed(),
                "Emoji 3 is not displayed.");

        /*
         * Verify Emoji 4
         */
        Assert.assertTrue(
                feedback.Emoji4.isDisplayed(),
                "Emoji 4 is not displayed.");

        /*
         * Verify Emoji 5
         */
        Assert.assertTrue(
                feedback.Emoji5.isDisplayed(),
                "Emoji 5 is not displayed.");

        System.out.println(
                "All emojis displayed successfully.");

        /*
         * Verify First Feedback Field
         */
        Assert.assertTrue(
                feedback.isLikeMostFieldVisible(),
                "\"What did you like most\" field is not displayed.");

        System.out.println(
                "First feedback field displayed successfully.");

        /*
         * Verify Second Feedback Field
         */
        Assert.assertTrue(
                feedback.isRecommendAppFieldVisible(),
                "\"Recommend app\" field is not displayed.");

        System.out.println(
                "Second feedback field displayed successfully.");

        /*
         * Verify Third Feedback Field
         */
        Assert.assertTrue(
                feedback.isImprovementFieldVisible(),
                "\"Improvement\" field is not displayed.");

        System.out.println(
                "Third feedback field displayed successfully.");

        System.out.println(
                "Feedback Screen UI verified successfully.");
    }
}