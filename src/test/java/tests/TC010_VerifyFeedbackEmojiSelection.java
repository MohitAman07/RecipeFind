package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.HamburgerMenu.Feedback;
import pagesObjects.HamburgerMenu.Hamburger;

public class TC010_VerifyFeedbackEmojiSelection extends BaseTest {

    @Test
    public void verifyFeedbackEmojiSelection()
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
         * Verify Feedback Screen
         */
        Assert.assertTrue(
                feedback.isFeedbackPageVisible(),
                "Feedback page is not displayed.");

        /*
         * Select Emoji 1
         */
        feedback.selectEmoji(1);

        System.out.println(
                "Emoji 1 selected successfully.");

        Thread.sleep(1000);

        /*
         * Select Emoji 2
         */
        feedback.selectEmoji(2);

        System.out.println(
                "Emoji 2 selected successfully.");

        Thread.sleep(1000);

        /*
         * Select Emoji 3
         */
        feedback.selectEmoji(3);

        System.out.println(
                "Emoji 3 selected successfully.");

        Thread.sleep(1000);

        /*
         * Select Emoji 4
         */
        feedback.selectEmoji(4);

        System.out.println(
                "Emoji 4 selected successfully.");

        Thread.sleep(1000);

        /*
         * Select Emoji 5
         */
        feedback.selectEmoji(5);

        System.out.println(
                "Emoji 5 selected successfully.");

        System.out.println(
                "All emojis are selectable successfully.");
    }
}