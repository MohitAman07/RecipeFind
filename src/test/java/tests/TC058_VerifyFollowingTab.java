package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Profile.Following_Tab;

public class TC058_VerifyFollowingTab extends BaseTest {

    @Test
    public void verifyFollowingTabDetails()  throws Exception {
       
         Following_Tab following =
                new Following_Tab(
                        DriverFactory.getDriver());


        following.Click_Profile_Tab();

        Thread.sleep(2000);

        following.Click_Following_Tab();

        Thread.sleep(2000);

        following.Click_Follow_Button();

        Thread.sleep(2000);

        following.Verify_Following_count();

        Thread.sleep(2000);

        following.Open_Profile();

         }
        }