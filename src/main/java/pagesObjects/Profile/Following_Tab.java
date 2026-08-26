package pagesObjects.Profile;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.WaitUtil;
import org.testng.Assert;

public class Following_Tab {

    private final AndroidDriver driver;
    private final WaitUtil waitUtil;

    // ======================== Constructor ======================== //

    public Following_Tab(AndroidDriver driver) {

        this.driver = driver;

        this.waitUtil = new WaitUtil(driver);

        PageFactory.initElements(
                new AppiumFieldDecorator(driver),
                this
        );
    }

    // ======================== Locators ======================== //

    @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
    private WebElement Profile_Tab;
    //android.view.View[@index='3']

    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private WebElement Following_Tab;

    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    private WebElement follow_button;

    @AndroidFindBy(
    xpath = "//android.view.View[contains(@content-desc,\"You are following\")]")
    private WebElement followingCount;

    @AndroidFindBy(
        xpath = "//android.widget.ImageView["
                + "contains(@content-desc,\"Quick E.\")"
                + " and contains(@content-desc,\"Cranbury library\")"
                + " and contains(@content-desc,\"Recipes\")"
                + " and contains(@content-desc,\"Followers\")"
                + "]")
    private WebElement Open_profile;


    // ======================== Profile Tab ======================== //

    /**
     * Click on Profile tab
     */
    public void Click_Profile_Tab() {

          Assert.assertTrue(
                Profile_Tab.isDisplayed(),
                "For Self option is not displayed.");

        waitUtil.clickWithWait(
                 Profile_Tab);

        System.out.println(
                "profile tab clicked.");
    }


    // ======================== Following Tab ======================== //

/*
 * Click on Following tab
 */
public void Click_Following_Tab() {

    WebElement elementToTap =
            driver.findElement(
                    By.xpath(
                            "//android.view.View[@content-desc=\"Following\nTab 4 of 4\"]"));

    waitUtil.clickWithWait(
            elementToTap);

    System.out.println(
            "Following tab clicked.");
}


    // ======================== Follow Button ======================== //

    /**
     * Click on Follow button
     */
    public void Click_Follow_Button() {

          Assert.assertTrue(
                follow_button.isDisplayed(),
                "For follow button is not displayed.");

        waitUtil.clickWithWait(
                 follow_button);

        System.out.println(
                "Follow Button clicked.");

       
    }


    // ======================== Verify Following Count ======================== //

    /*
 * Verify Following Count
 */
public void Verify_Following_count() {

    WebElement followingCount =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10))
                    .until(
                            ExpectedConditions
                                    .visibilityOfElementLocated(
                                            AppiumBy.xpath(
                                                    "//android.view.View[contains(@content-desc,\"You are following\")]")));

    System.out.println(
            "Following count displayed : "
                    + followingCount.getAttribute(
                            "content-desc"));
}

    // ======================== Open Profile ======================== //

 /*
 * Open Person Profile
 */
public void openPersonProfile(
        String personName) {

    scrollToPerson(
            personName);

    String personXpath =
            "//android.widget.ImageView[contains(@content-desc,\""
                    + personName
                    + "\")]";

    WebElement personTile =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10))
                    .until(
                            ExpectedConditions
                                    .visibilityOfElementLocated(
                                            AppiumBy.xpath(
                                                    personXpath)));

    waitUtil.clickWithWait(
            personTile);

    System.out.println(
            "Person profile opened : "
                    + personName);
}


//     /**
//      * Open profile using dynamic profile content description
//      *
//      * Example:
//      * Open_Profile("Quick E.", "Cranbury library", "101", "2");
//      */
//     public void Open_Profile(
//             String userName,
//             String profileName,
//             String recipeCount,
//             String followerCount) {

//         String contentDescription =
//                 userName + "\r\n"
//                 + profileName + "\r\n"
//                 + recipeCount + "\r\n"
//                 + "Recipes\r\n"
//                 + followerCount + "\r\n"
//                 + "Followers";

//         String xpath =
//                 "//android.widget.ImageView[@content-desc=\""
//                 + contentDescription
//                 + "\"]";

//         WebElement profile = driver.findElement(
//                 By.xpath(xpath)
//         );


/*
 * Scroll Person Into View
 */
public void scrollToPerson(
        String personName) {

    String personXpath =
            "//android.widget.ImageView[contains(@content-desc,\""
                    + personName
                    + "\")]";

    for (int attempt = 1;
            attempt <= 5;
            attempt++) {

        /*
         * Check Person
         */
        try {

            WebElement personTile =
                    driver.findElement(
                            AppiumBy.xpath(
                                    personXpath));

            if (personTile.isDisplayed()) {

                System.out.println(
                        "Person found : "
                                + personName);

                return;
            }

        }

        catch (Exception e) {

            /*
             * Person not visible.
             * Continue scrolling.
             */
        }

        /*
         * Swipe Up Using Coordinates
         */
        try {

            int startX =
                    495;

            int startY =
                    1406;

            int endX =
                    495;

            int endY =
                    689;

            PointerInput finger =
                    new PointerInput(
                            PointerInput.Kind.TOUCH,
                            "finger");

            Sequence swipe =
                    new Sequence(
                            finger,
                            1);

            swipe.addAction(
                    finger.createPointerMove(
                            Duration.ZERO,
                            PointerInput.Origin.viewport(),
                            startX,
                            startY));

            swipe.addAction(
                    finger.createPointerDown(
                            PointerInput.MouseButton.LEFT.asArg()));

            swipe.addAction(
                    finger.createPointerMove(
                            Duration.ofMillis(600),
                            PointerInput.Origin.viewport(),
                            endX,
                            endY));

            swipe.addAction(
                    finger.createPointerUp(
                            PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(
                    List.of(swipe));

            Thread.sleep(
                    1000);

            System.out.println(
                    "Person scroll attempt : "
                            + attempt
                            + " | "
                            + personName);
        }

        catch (Exception e) {

            throw new RuntimeException(
                    "Unable to scroll person : "
                            + personName,
                    e);
        }
    }

    throw new RuntimeException(
            "Person could not be found after scrolling : "
                    + personName);
}

/*
 * Scroll Person Tile To Make Follow Button Visible
 */
public void scrollToPersonForFollow(
        String personName) {

    String personXpath =
            "//android.widget.ImageView[contains(@content-desc,\""
                    + personName
                    + "\")]";

    for (int attempt = 1;
            attempt <= 5;
            attempt++) {

        try {

            WebElement personTile =
                    driver.findElement(
                            AppiumBy.xpath(
                                    personXpath));

            /*
             * Get Person Tile Position
             */
            Point location =
                    personTile.getLocation();

            Dimension size =
                    personTile.getSize();

            int personBottom =
                    location.getY()
                            + size.getHeight();

            /*
             * Follow Button Should Be
             * Inside Person Tile
             */
            if (location.getY() >= 200
                    && personBottom <= 2200) {

                System.out.println(
                        "Person tile positioned for Follow button : "
                                + personName);

                return;
            }

        }

        catch (Exception e) {

            /*
             * Person tile not available.
             * Continue scrolling.
             */
        }

        /*
         * Coordinate Swipe Up
         */
        try {

            int startX =
                    495;

            int startY =
                    1406;

            int endX =
                    495;

            int endY =
                    689;

            PointerInput finger =
                    new PointerInput(
                            PointerInput.Kind.TOUCH,
                            "finger");

            Sequence swipe =
                    new Sequence(
                            finger,
                            1);

            swipe.addAction(
                    finger.createPointerMove(
                            Duration.ZERO,
                            PointerInput.Origin.viewport(),
                            startX,
                            startY));

            swipe.addAction(
                    finger.createPointerDown(
                            PointerInput.MouseButton.LEFT.asArg()));

            swipe.addAction(
                    finger.createPointerMove(
                            Duration.ofMillis(600),
                            PointerInput.Origin.viewport(),
                            endX,
                            endY));

            swipe.addAction(
                    finger.createPointerUp(
                            PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(
                    List.of(swipe));

            Thread.sleep(
                    1000);

            System.out.println(
                    "Person tile scroll attempt : "
                            + attempt
                            + " | "
                            + personName);
        }

        catch (Exception e) {

            throw new RuntimeException(
                    "Unable to scroll person tile : "
                            + personName,
                    e);
        }
    }

    throw new RuntimeException(
            "Person tile could not be positioned for Follow button : "
                    + personName);
}

/*
 * Click Follow Button For Person
 */
public void followPerson(
        String personName) {

    /*
     * Scroll Person Tile To Make
     * Follow Button Visible
     */
    scrollToPersonForFollow(
            personName);

    String followButtonXpath =
            "//android.widget.ImageView[contains(@content-desc,\""
                    + personName
                    + "\")]/android.view.View";

    /*
     * Locate Follow Button Using
     * Person Tile As Anchor
     */
    WebElement followButton =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10))
                    .until(
                            ExpectedConditions
                                    .elementToBeClickable(
                                            AppiumBy.xpath(
                                                    followButtonXpath)));

    /*
     * Click ONLY Follow Button
     */
    waitUtil.clickWithWait(
            followButton);

    System.out.println(
            "Follow button clicked for : "
                    + personName);
}

/*
 * Refresh Following List
 */
public void refreshFollowingList() {

    try {

        int startX =
                490;

        int startY =
                1092;

        int endX =
                486;

        int endY =
                1647;

        PointerInput finger =
                new PointerInput(
                        PointerInput.Kind.TOUCH,
                        "finger");

        Sequence swipe =
                new Sequence(
                        finger,
                        1);

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        startX,
                        startY));

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(500),
                        PointerInput.Origin.viewport(),
                        endX,
                        endY));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(
                List.of(swipe));

        System.out.println(
                "Following list refreshed.");

    }

    catch (Exception e) {

        throw new RuntimeException(
                "Unable to refresh Following list.",
                e);
    }
}


}



    

    







    

