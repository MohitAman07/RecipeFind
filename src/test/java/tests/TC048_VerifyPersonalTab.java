package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Home.HomeDashboard;
import pagesObjects.Profile.Personal_Tab;
import utils.ValidationUtil;

public class TC048_VerifyPersonalTab extends BaseTest {

    @Test
    public void verifyPersonalTabDetails()
            throws Exception {

        HomeDashboard home =
                new HomeDashboard(
                        DriverFactory.getDriver());

        Personal_Tab personalTab =
                new Personal_Tab(
                        DriverFactory.getDriver());

        String firstName =
                "Normaluser2";

        String lastName =
                "noadmin privilage";

        String email =
                "testuser124355@gmail.com";

        String facebookLink =
                "https://facebook.com/automation";

        // String updatedFacebookLink =
        //         "https://facebook.com/automationupdated";

        /*
         * Verify Profile Button
         */
        ValidationUtil.verifyTrue(
                home.isProfileButtonVisible(),
                "Profile button displayed successfully.");

        /*
         * Click Profile Button
         */
        home.clickProfileButton();

        Thread.sleep(
                3000);

        /*
         * Verify Personal Tab
         */
        ValidationUtil.verifyTrue(
                personalTab.isPersonalTabDisplayed(),
                "Personal tab displayed successfully.");

        /*
         * Click Personal Tab
         */
        personalTab.clickPersonalTab();

        Thread.sleep(
                3000);

        /*
         * Verify Profile Tag
         */
        ValidationUtil.verifyTrue(
                personalTab.isProfileTagDisplayed(),
                "Profile tag displayed successfully.");

        System.out.println(
                personalTab.getProfileTag());

        /*
         * Verify Personal Email
         */
        ValidationUtil.verifyTrue(
                personalTab.isPersonalEmailDisplayed(),
                "Personal email displayed successfully.");

        System.out.println(
                personalTab.getPersonalEmail());

        /*
         * Verify First Name / Last Name Card
         */
        ValidationUtil.verifyTrue(
                personalTab.isNameCardDisplayed(),
                "First Name / Last Name card displayed successfully.");

        /*
         * Verify First Name
         */
        ValidationUtil.verifyTrue(
                personalTab.getFirstName()
                        .equals(
                                firstName),
                "First Name verified successfully.");

        System.out.println(
                "First Name : "
                        + personalTab.getFirstName());

        /*
         * Verify Last Name
         */
        ValidationUtil.verifyTrue(
                personalTab.getLastName()
                        .equals(
                                lastName),
                "Last Name verified successfully.");

        System.out.println(
                "Last Name : "
                        + personalTab.getLastName());

        /*
         * Verify Contact Information
         */
        ValidationUtil.verifyTrue(
                personalTab.isContactInformationDisplayed(),
                "Contact Information displayed successfully.");

        /*
         * Verify Contact Information Value
         */
        ValidationUtil.verifyTrue(
                personalTab.getContactInformation()
                        .contains(
                                email),
                "Contact Information verified successfully.");

        System.out.println(
                "Contact Information : "
                        + personalTab.getContactInformation());

        /*
         * Verify Recipe Statistics
         */
        ValidationUtil.verifyTrue(
                personalTab.isRecipeStatisticsDisplayed(),
                "Recipe Statistics displayed successfully.");

        /*
         * Print Recipe Statistics
         */
        System.out.println(
                personalTab.getRecipeStatistics());

        /*
         * Verify Recipe Counts Loaded
         */
        ValidationUtil.verifyTrue(
                personalTab.isRecipeCountLoaded(),
                "Recipe counts loaded successfully.");

        /*
         * Print Recipe Counts
         */
        personalTab.printRecipeCounts();

        /*
         * Scroll To Membership Section
         */
        personalTab.scrollToMembershipSection();

        Thread.sleep(
                2000);

        /*
         * Verify Membership Section
         */
        ValidationUtil.verifyTrue(
                personalTab.isMembershipSectionDisplayed(),
                "Membership section displayed successfully.");

        /*
         * Get Membership Details
         */
        System.out.println(
                personalTab.getMembershipDetails());

        /*
         * Scroll To Profile ID
         */
        personalTab.scrollToProfileId();

        Thread.sleep(
                2000);

        /*
         * Verify Profile ID
         */
        ValidationUtil.verifyTrue(
                personalTab.isProfileIdDisplayed(),
                "Profile ID displayed successfully.");

        System.out.println(
                personalTab.getProfileId());

        Thread.sleep(
                3000);

        /*
         * Verify Groups Section
         */
        ValidationUtil.verifyTrue(
                personalTab.isGroupsSectionDisplayed(),
                "Groups section displayed successfully.");

        /*
         * Print Groups
         */
        personalTab.printGroups();

        /*
         * Scroll To Followers Section
         */
        personalTab.scrollToFollowersCount();

        Thread.sleep(
                2000);

        /*
         * Verify Followers Count
         */
        ValidationUtil.verifyTrue(
                personalTab.isFollowersCountDisplayed(),
                "Followers count displayed successfully.");

        System.out.println(
                personalTab.getFollowersCount());

        /*
         * Scroll To Personal Links Section
         */
        personalTab.scrollToPersonalLinksSection();

        Thread.sleep(
                2000);

        /*
         * Verify Personal Links Section
         */
        ValidationUtil.verifyTrue(
                personalTab.isPersonalLinksSectionDisplayed(),
                "Personal Links section displayed successfully.");

        /*
         * Click Add Link Button
         */
        personalTab.clickAddLinkButton();

        Thread.sleep(
                2000);

        /*
         * Select Facebook Link Type
         */
        personalTab.selectLinkType(
                "Facebook");

        Thread.sleep(
                2000);

        /*
         * Click Personal Link Row
         */
        personalTab.clickPersonalLinkRow();

        Thread.sleep(
                2000);

        /*
         * Enter Facebook Personal Link
         */
        personalTab.enterPersonalLink(
                facebookLink);

        Thread.sleep(
                2000);

        /*
        * Save Personal Link
        */
        personalTab.clickSavePersonalLink();

        Thread.sleep(
                3000);

        /*
        * Remove Personal Link
        */
        personalTab.removePersonalLink();

        Thread.sleep(
                3000);

        /*
        * Scroll To Top
        */
        personalTab.scrollToTop();

        Thread.sleep(
                2000);

        System.out.println(
                "==================================================");

        System.out.println(
                "TC048_VerifyPersonalTab executed successfully.");

        System.out.println(
                "==================================================");
    }
}

