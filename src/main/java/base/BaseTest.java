package base;

import driver.DriverFactory;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumBy;
import pagesObjects.Signup.AudioPermissionPage;
import pagesObjects.Signup.GoogleAccountPage;
import pagesObjects.Signup.GoogleLoginPage;
import pagesObjects.Signup.NearbyPermissionPage;
import pagesObjects.Signup.SignUpPage;

import utils.ConfigReader;

public class BaseTest {

        @BeforeMethod(alwaysRun = true)
        public void setUp(Method method) {

        System.out.println(
                "\n==================================================");

        System.out.println(
                "Executing Test Case : "
                        + method.getName());

        System.out.println(
                "==================================================");

        DriverFactory.initializeDriver();

        verifyApplicationLaunch();

        authenticateUser();

        ensureApplicationReady();
        }

    private void verifyApplicationLaunch() {

        String currentPackage =
                DriverFactory.getDriver()
                             .getCurrentPackage();

        Assert.assertEquals(
                currentPackage,
                "com.quickelf.recipeFind.debug",
                "Recipe Find application is not launched.");

        System.out.println(
                "Application launched successfully.");

        System.out.println(
                "Current Package : "
                        + currentPackage);
    }

    protected void authenticateUser() {

        try {

            boolean authenticationCompleted = false;

            SignUpPage signUpPage =
                    new SignUpPage(
                            DriverFactory.getDriver());

            GoogleAccountPage googlePage =
                    new GoogleAccountPage(
                            DriverFactory.getDriver());

            GoogleLoginPage googleLoginPage =
                    new GoogleLoginPage(
                            DriverFactory.getDriver());

            AudioPermissionPage audioPage =
                    new AudioPermissionPage(
                            DriverFactory.getDriver());

            NearbyPermissionPage nearbyPage =
                    new NearbyPermissionPage(
                            DriverFactory.getDriver());

            String email =
                    ConfigReader.getProperty(
                            "gmail.email");

            String password =
                    ConfigReader.getProperty(
                            "gmail.password");

            /*
             * Sign Up Screen
             */
            if (signUpPage.isSignUpDisplayed()) {

                System.out.println(
                        "Sign Up screen detected.");

                signUpPage.clickContinueWithGoogle();

                System.out.println(
                        "Continue with Google clicked.");

                Thread.sleep(8000);

                System.out.println(
                        "Package after Google click : "
                                + DriverFactory.getDriver()
                                               .getCurrentPackage());

                boolean googleAccountDisplayed =
                        googlePage.waitForChooseAccountScreen();

                System.out.println(
                        "Google Account Screen Displayed : "
                                + googleAccountDisplayed);

                /*
                 * Choose Account Screen
                 */
                if (googleAccountDisplayed) {

                    System.out.println(
                            "Choose account screen detected.");

                    if (googlePage.selectConfiguredAccount(email)) {

                        authenticationCompleted = true;

                        System.out.println(
                                "Configured account selected.");
                    }
                    else {

                        System.out.println(
                                "Configured account not found.");

                        googlePage.clickAddAnotherAccount();

                        System.out.println(
                                "Add another account clicked.");

                        Thread.sleep(5000);

                        System.out.println(
        DriverFactory.getDriver().getPageSource());

                        /*
                         * Debug Email Screen
                         */
                        System.out.println(
                                "Package before email entry : "
                                        + DriverFactory.getDriver()
                                                       .getCurrentPackage());

                        System.out.println(
                                "Email field count : "
                                        + DriverFactory.getDriver()
                                                .findElements(
                                                        AppiumBy.id(
                                                                "identifierId"))
                                                .size());

                        /*
                         * Google Email Login
                         */
                        System.out.println(
                                "Waiting for Google email screen...");

                        int retry = 0;

                        while (DriverFactory.getDriver()
                                .findElements(AppiumBy.id("identifierId"))
                                .isEmpty()
                                && retry < 30) {

                        Thread.sleep(1000);

                        retry++;

                        System.out.println("Waiting... " + retry);
                        }

                        System.out.println(
                                "Email field count : "
                                + DriverFactory.getDriver()
                                        .findElements(AppiumBy.id("identifierId"))
                                        .size());

                        googleLoginPage.enterEmail(email);

                        googleLoginPage.clickEmailNext();

                        Thread.sleep(3000);

                        googleLoginPage.enterPassword(password);

                        googleLoginPage.clickPasswordNext();

                        Thread.sleep(3000);

                        if (googleLoginPage.isIAgreeDisplayed()) {

                            googleLoginPage.clickIAgree();

                            System.out.println(
                                    "Clicked I Agree.");

                            Thread.sleep(3000);
                        }

                        authenticationCompleted = true;

                        System.out.println(
                                "Google credentials entered successfully.");
                    }
                }
                /*
                 * Direct Google Login Screen
                 */
                else {

                    System.out.println(
                            "Google login screen detected.");

                        
                    googleLoginPage.enterEmail(email);

                    googleLoginPage.clickEmailNext();

                    Thread.sleep(3000);

                    googleLoginPage.enterPassword(password);

                    googleLoginPage.clickPasswordNext();

                    Thread.sleep(3000);

                    if (googleLoginPage.isIAgreeDisplayed()) {

                        googleLoginPage.clickIAgree();

                        Thread.sleep(3000);
                    }

                    authenticationCompleted = true;

                    System.out.println(
                            "Google credentials entered successfully.");
                }
            }
            else {

                System.out.println(
                        "User already authenticated.");

                authenticationCompleted = true;
            }

            /*
             * Audio Permission
             */
            if (audioPage.isDisplayed()) {

                audioPage.allowWhileUsingApp();

                System.out.println(
                        "Audio permission allowed.");

                Thread.sleep(2000);
            }

            /*
             * Nearby Devices Permission
             */
            if (nearbyPage.isDisplayed()) {

                nearbyPage.allow();

                System.out.println(
                        "Nearby devices permission allowed.");

                Thread.sleep(2000);
            }

            Assert.assertTrue(
                    authenticationCompleted,
                    "Authentication did not complete successfully.");

            System.out.println(
                    "Authentication completed successfully.");
        }
        catch (Exception e) {

            e.printStackTrace();

            DriverFactory.quitDriver();

            Assert.fail(
                    "Authentication failed : "
                            + e.getMessage());
        }
    }

    private void ensureApplicationReady() {

    try {

        String currentPackage =
                DriverFactory.getDriver()
                        .getCurrentPackage();

        // Bring Recipe Find to foreground if another app is open
        if (!"com.quickelf.recipeFind.debug".equals(currentPackage)) {

            DriverFactory.getDriver()
                    .activateApp("com.quickelf.recipeFind.debug");

            Thread.sleep(2000);

            System.out.println(
                    "Recipe Find application activated.");
        }

        // Click Home if the Home button is available
        if (!DriverFactory.getDriver()
                .findElements(
                        AppiumBy.xpath(
                                "//android.widget.Button[contains(@content-desc,'Home')]"))
                .isEmpty()) {

            DriverFactory.getDriver()
                    .findElement(
                            AppiumBy.xpath(
                                    "//android.widget.Button[contains(@content-desc,'Home')]"))
                    .click();

            System.out.println(
                    "Home button clicked.");
        }

        System.out.println(
                "Application is ready for test execution.");

    } catch (Exception e) {

        Assert.fail(
                "Unable to prepare application : "
                        + e.getMessage());
                }
        }

    @AfterMethod(alwaysRun = true)
        public void tearDown(Method method) {

        // System.out.println(
        //         "Completed Test Case : "
        //                 + method.getName());

        // System.out.println(
        //         "==================================================\n");

        // DriverFactory.quitDriver();
        }
}