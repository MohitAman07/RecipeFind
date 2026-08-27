package pagesObjects.HamburgerMenu;

import java.time.Duration;
import java.util.List;

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

public class QuickStatics {

    private final AndroidDriver driver;
    private final WaitUtil waitUtil;

    // ======================== Constructor ======================== //

    public QuickStatics(
            AndroidDriver driver) {

        this.driver =
                driver;

        this.waitUtil =
                new WaitUtil(
                        driver);

        PageFactory.initElements(
                new AppiumFieldDecorator(
                        driver),
                this);
    }

    // ======================== Analytics ======================== //

    /*
    * Back Button
    */
    @AndroidFindBy(
            xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]"
                    + "/android.widget.FrameLayout"
                    + "/android.view.View"
                    + "/android.view.View"
                    + "/android.view.View"
                    + "/android.view.View"
                    + "/android.view.View[1]"
                    + "/android.view.View"
                    + "/android.view.View"
                    + "/android.widget.Button")
    private WebElement backButton;

    /*
     * Analytics Header
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Analytics\"]")
    private WebElement analyticsHeader;

    /*
     * Last Updated
     */
    @AndroidFindBy(
            xpath = "//android.view.View[contains(@content-desc,\"Last updated:\")]")
    private WebElement lastUpdated;

    /*
     * Select Date Range
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Select Date Range\"]")
    private WebElement selectDateRange;

    // ======================== Calendar ======================== //

    /*
     * Close Calendar
     */
    @AndroidFindBy(
            xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]"
                    + "/android.widget.FrameLayout"
                    + "/android.view.View"
                    + "/android.view.View"
                    + "/android.view.View[1]"
                    + "/android.view.View"
                    + "/android.view.View"
                    + "/android.view.View"
                    + "/android.view.View[1]")
    private WebElement closeCalendar;

    /*
     * Month Backward
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Backward\"]")
    private WebElement backwardMonth;

    /*
     * Month Forward
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Forward\"]")
    private WebElement forwardMonth;

    /*
     * Reset
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Reset\"]")
    private WebElement resetCalendar;

    /*
     * Apply
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Apply\"]")
    private WebElement applyCalendar;

    // ======================== Tabs ======================== //

    /*
     * User Tab
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"User\"]")
    private WebElement userTab;

    /*
     * Recipe Tab
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Recipe\"]")
    private WebElement recipeTab;

    // ======================== Account ======================== //

    /*
     * Account Header
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"ACCOUNT\"]")
    private WebElement accountHeader;

    /*
     * Total Users
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Total users\"]")
    private WebElement totalUsers;

    /*
     * Active Users
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Active users\"]")
    private WebElement activeUsers;

    /*
     * Monthly User Growth
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Monthly user growth\"]")
    private WebElement monthlyUserGrowth;

    // ======================== Subscriptions ======================== //

    /*
     * Subscription Header
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"SUBSCRIPTIONS\"]")
    private WebElement subscriptionsHeader;

    /*
     * Active Subscriptions
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Active subscriptions\"]")
    private WebElement activeSubscriptions;

    /*
     * Expired Subscriptions
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Expired subscriptions\"]")
    private WebElement expiredSubscriptions;

    /*
     * Auto Renew Enabled
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Auto renew enabled\"]")
    private WebElement autoRenewEnabled;

    /*
     * Auto Renew Disabled
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Auto renew disabled\"]")
    private WebElement autoRenewDisabled;

    /*
     * Monthly Subscription Growth
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Monthly subscription growth\"]")
    private WebElement monthlySubscriptionGrowth;

    // ======================== Social And Community ======================== //

    /*
     * Social And Community Header
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"SOCIAL AND COMMUNITY\"]")
    private WebElement socialCommunityHeader;

    /*
     * Users With Followers
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Users with followers\"]")
    private WebElement usersWithFollowers;

    /*
     * Highest Followers
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Highest followers\"]")
    private WebElement highestFollowers;

    /*
     * Top Contributor
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Top contributor\"]")
    private WebElement topContributor;

    /*
     * Most Liked Contributor
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Most liked contributor\"]")
    private WebElement mostLikedContributor;

    /*
     * Total Groups
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Total groups\"]")
    private WebElement totalGroups;

    /*
     * Group With Most Recipes
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Group with most recipes\"]")
    private WebElement groupWithMostRecipes;

    // ======================== Analytics Methods ======================== //

    /*
    * Click Back Button
    */
    public void clickBackButton() {

        new WebDriverWait(
                driver,
                Duration.ofSeconds(10))
                .until(
                        ExpectedConditions.visibilityOf(
                                backButton));

        waitUtil.clickWithWait(
                backButton);

        System.out.println(
                "Quick Statistics back button clicked.");
    }

    /*
     * Verify Analytics Header
     */
    public void verifyAnalyticsHeader() {

        new WebDriverWait(
                driver,
                Duration.ofSeconds(10))
                .until(
                        ExpectedConditions.visibilityOf(
                                analyticsHeader));

        System.out.println(
                "Analytics header displayed.");
    }

    /*
     * Get Last Updated Date
     */
    public String getLastUpdatedDate() {

        new WebDriverWait(
                driver,
                Duration.ofSeconds(10))
                .until(
                        ExpectedConditions.visibilityOf(
                                lastUpdated));

        String updatedDate =
                lastUpdated.getAttribute(
                        "content-desc");

        System.out.println(
                "Last updated : "
                        + updatedDate);

        return updatedDate;
    }

    // ======================== Date Range Methods ======================== //

    /*
     * Click Select Date Range
     */
    public void clickSelectDateRange() {

        waitUtil.clickWithWait(
                selectDateRange);

        System.out.println(
                "Select Date Range clicked.");
    }

    /*
     * Close Calendar
     */
    public void clickCloseCalendar() {

        waitUtil.clickWithWait(
                closeCalendar);

        System.out.println(
                "Calendar closed.");
    }

    /*
     * Click Previous Month
     */
    public void clickPreviousMonth() {

        waitUtil.clickWithWait(
                backwardMonth);

        System.out.println(
                "Previous month clicked.");
    }

    /*
     * Click Next Month
     */
    public void clickNextMonth() {

        waitUtil.clickWithWait(
                forwardMonth);

        System.out.println(
                "Next month clicked.");
    }

    /*
     * Get Calendar Month And Year
     */
    public String getCalendarMonthYear() {

        WebElement monthYear =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10))
                        .until(
                                ExpectedConditions
                                        .visibilityOfElementLocated(
                                                AppiumBy.xpath(
                                                        "//android.view.View[contains(@content-desc,\"202\")]")));

        String month =
                monthYear.getAttribute(
                        "content-desc");

        System.out.println(
                "Calendar month and year : "
                        + month);

        return month;
    }

    /*
     * Get Calendar Month And Year
     *
     * Dynamic Value
     */
    public String getCalendarMonthYear(
            String monthYearValue) {

        WebElement monthYear =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10))
                        .until(
                                ExpectedConditions
                                        .visibilityOfElementLocated(
                                                AppiumBy.xpath(
                                                        "//android.view.View[@content-desc=\""
                                                                + monthYearValue
                                                                + "\"]")));

        String value =
                monthYear.getAttribute(
                        "content-desc");

        System.out.println(
                "Calendar month and year : "
                        + value);

        return value;
    }

    /*
     * Reset Calendar
     */
    public void clickReset() {

        waitUtil.clickWithWait(
                resetCalendar);

        System.out.println(
                "Calendar reset clicked.");
    }

    /*
     * Apply Calendar
     */
    public void clickApply() {

        waitUtil.clickWithWait(
                applyCalendar);

        System.out.println(
                "Calendar Apply clicked.");
    }

    // ======================== Tab Methods ======================== //

    /*
     * Click User Tab
     */
    public void clickUserTab() {

        waitUtil.clickWithWait(
                userTab);

        System.out.println(
                "User tab clicked.");
    }

    /*
     * Click Recipe Tab
     */
    public void clickRecipeTab() {

        waitUtil.clickWithWait(
                recipeTab);

        System.out.println(
                "Recipe tab clicked.");
    }

    // ======================== Account Methods ======================== //

    /*
     * Verify Account Header
     */
    public void verifyAccountHeader() {

        new WebDriverWait(
                driver,
                Duration.ofSeconds(10))
                .until(
                        ExpectedConditions.visibilityOf(
                                accountHeader));

        System.out.println(
                "Account section displayed.");
    }

    /*
     * Get Total User Count
     */
    public String getTotalUserCount() {

        return getMetricValue(
                "Total users");
    }

    /*
     * Get Active User Count
     */
    public String getActiveUserCount() {

        return getMetricValue(
                "Active users");
    }

    /*
     * Get Monthly User Growth
     */
    public String getMonthlyUserGrowth() {

        WebElement growth =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10))
                        .until(
                                ExpectedConditions
                                        .visibilityOfElementLocated(
                                                AppiumBy.xpath(
                                                        "(//android.widget.ScrollView/android.view.View[contains(@content-desc,\"%\")])[1]")));

        String value =
                growth.getAttribute(
                        "content-desc");

        System.out.println(
                "Monthly user growth : "
                        + value);

        return value;
    }

    // ======================== Subscription Methods ======================== //

    /*
     * Verify Subscription Header
     */
    public void verifySubscriptionsHeader() {

        new WebDriverWait(
                driver,
                Duration.ofSeconds(10))
                .until(
                        ExpectedConditions.visibilityOf(
                                subscriptionsHeader));

        System.out.println(
                "Subscriptions section displayed.");
    }

    /*
     * Get Active Subscription Count
     */
    public String getActiveSubscriptionCount() {

        return getMetricValue(
                "Active subscriptions");
    }

    /*
     * Get Expired Subscription Count
     */
    public String getExpiredSubscriptionCount() {

        return getMetricValue(
                "Expired subscriptions");
    }

    /*
     * Get Auto Renew Enabled Count
     */
    public String getAutoRenewEnabledCount() {

        return getMetricValue(
                "Auto renew enabled");
    }

    /*
     * Get Auto Renew Disabled Count
     */
    public String getAutoRenewDisabledCount() {

        return getMetricValue(
                "Auto renew disabled");
    }

    /*
     * Get Monthly Subscription Growth
     */
    public String getMonthlySubscriptionGrowth() {

        WebElement growth =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10))
                        .until(
                                ExpectedConditions
                                        .visibilityOfElementLocated(
                                                AppiumBy.xpath(
                                                        "(//android.widget.ScrollView/android.view.View[contains(@content-desc,\"%\")])[2]")));

        String value =
                growth.getAttribute(
                        "content-desc");

        System.out.println(
                "Monthly subscription growth : "
                        + value);

        return value;
    }

    // ======================== Social And Community Methods ======================== //

    /*
     * Mandatory Coordinate Scroll Down
     * To Social And Community
     */
    public void scrollDownToSocialCommunity() {

        int startX =
                540;

        int startY =
                1500;

        int endX =
                540;

        int endY =
                500;

        performSwipe(
                startX,
                startY,
                endX,
                endY);

        try {

            Thread.sleep(
                    1500);

        }

        catch (InterruptedException e) {

            Thread.currentThread()
                    .interrupt();

            throw new RuntimeException(
                    "Interrupted while scrolling to Social and Community.",
                    e);
        }

        System.out.println(
                "Scrolled down to Social and Community.");
    }

    /*
     * Scroll Up To Top
     */
    public void scrollUpToTop() {

        int startX =
                540;

        int startY =
                500;

        int endX =
                540;

        int endY =
                1500;

        performSwipe(
                startX,
                startY,
                endX,
                endY);

        try {

            Thread.sleep(
                    1500);

        }

        catch (InterruptedException e) {

            Thread.currentThread()
                    .interrupt();

            throw new RuntimeException(
                    "Interrupted while scrolling to top.",
                    e);
        }

        System.out.println(
                "Scrolled up to top.");
    }

    /*
     * Scroll To Social And Community
     *
     * Mandatory Scroll
     */
    public void scrollToSocialCommunity() {

        /*
         * Always perform coordinate scroll
         */
        scrollDownToSocialCommunity();

        /*
         * Wait For Social And Community
         */
        new WebDriverWait(
                driver,
                Duration.ofSeconds(10))
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        AppiumBy.xpath(
                                                "//android.view.View[@content-desc=\"SOCIAL AND COMMUNITY\"]")));

        /*
         * Wait For Users With Followers
         */
        new WebDriverWait(
                driver,
                Duration.ofSeconds(10))
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        AppiumBy.xpath(
                                                "//android.view.View[@content-desc=\"Users with followers\"]")));

        System.out.println(
                "Social and Community section fully visible.");
    }

    /*
     * Verify Social And Community Header
     */
    public void verifySocialCommunityHeader() {

        new WebDriverWait(
                driver,
                Duration.ofSeconds(10))
                .until(
                        ExpectedConditions.visibilityOf(
                                socialCommunityHeader));

        System.out.println(
                "Social and Community section displayed.");
    }

    /*
     * Get Users With Followers Count
     */
    public String getUsersWithFollowersCount() {

        return getMetricValue(
                "Users with followers");
    }

    /*
     * Get Highest Followers Person
     *
     * Label is used as anchor.
     */
    public String getHighestFollowersPerson() {

        return getSocialMetricValue(
                "Highest followers");
    }

    /*
     * Get Top Contributor
     *
     * Label is used as anchor.
     */
    public String getTopContributor() {

        return getSocialMetricValue(
                "Top contributor");
    }

    /*
     * Get Most Liked Contributor
     *
     * Label is used as anchor.
     */
    public String getMostLikedContributor() {

        return getSocialMetricValue(
                "Most liked contributor");
    }

    /*
     * Get Total Groups Count
     */
    public String getTotalGroupsCount() {

        return getMetricValue(
                "Total groups");
    }

    /*
     * Get Group With Most Recipes
     *
     * Label is used as anchor.
     */
    public String getGroupWithMostRecipes() {

        return getSocialMetricValue(
                "Group with most recipes");
    }

    // ======================== Dynamic Helpers ======================== //

    /*
     * Get Metric Value Using Label As Anchor
     */
    private String getMetricValue(
            String label) {

        String xpath =
                "//android.view.View[@content-desc=\""
                        + label
                        + "\"]/following-sibling::android.view.View[1]";

        WebElement value =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10))
                        .until(
                                ExpectedConditions
                                        .visibilityOfElementLocated(
                                                AppiumBy.xpath(
                                                        xpath)));

        String metricValue =
                value.getAttribute(
                        "content-desc");

        System.out.println(
                label
                        + " : "
                        + metricValue);

        return metricValue;
    }

    /*
     * Get Social Metric Value
     *
     * Uses the metric label as an anchor.
     */
    private String getSocialMetricValue(
            String label) {

        String xpath =
                "//android.view.View[@content-desc=\""
                        + label
                        + "\"]"
                        + "/following::android.view.View["
                        + "not(@content-desc=\""
                        + label
                        + "\")"
                        + " and string-length(@content-desc) > 0"
                        + "][1]";

        WebElement value =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10))
                        .until(
                                ExpectedConditions
                                        .visibilityOfElementLocated(
                                                AppiumBy.xpath(
                                                        xpath)));

        String metricValue =
                value.getAttribute(
                        "content-desc");

        System.out.println(
                label
                        + " : "
                        + metricValue);

        return metricValue;
    }

    // ======================== Coordinate Swipe ======================== //

    /*
     * Perform Coordinate Swipe
     */
    private void performSwipe(
            int startX,
            int startY,
            int endX,
            int endY) {

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
                        Duration.ofMillis(700),
                        PointerInput.Origin.viewport(),
                        endX,
                        endY));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(
                List.of(swipe));
    }


// ======================== Content Status ======================== //

/*
 * Content Status Header
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"CONTENT STATUS\"]")
private WebElement contentStatusHeader;

/*
 * Top Exported Recipe
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Top exported recipe\"]")
private WebElement topExportedRecipe;

/*
 * Community
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Community\"]")
private WebElement community;

/*
 * AI
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"AI\"]")
private WebElement ai;

/*
 * Published Recipes
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Published recipes\"]")
private WebElement publishedRecipes;

/*
 * Pending Recipes
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Pending recipes\"]")
private WebElement pendingRecipes;

/*
 * Pending Delete Recipes
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Pending delete recipes\"]")
private WebElement pendingDeleteRecipes;

/*
 * Monthly Recipe Growth
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Monthly recipe growth\"]")
private WebElement monthlyRecipeGrowth;


// ======================== Engagement ======================== //

/*
 * Engagement Header
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"ENGAGEMENT\"]")
private WebElement engagementHeader;

/*
 * Top Liked Recipe
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Top liked recipe\"]")
private WebElement topLikedRecipe;

/*
 * Top Commented Recipe
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Top commented recipe\"]")
private WebElement topCommentedRecipe;

/*
 * Top Favorite Recipe
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Top favorite recipe\"]")
private WebElement topFavoriteRecipe;

/*
 * Recipes With Likes
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Recipes with likes\"]")
private WebElement recipesWithLikes;

/*
 * Recipes With Comments
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Recipes with comments\"]")
private WebElement recipesWithComments;

/*
 * Recipes With Favorites
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Recipes with favorites\"]")
private WebElement recipesWithFavorites;


// ======================== Export Share ======================== //

/*
 * Export Share Header
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"EXPORTS/SHARE\"]")
private WebElement exportsShareHeader;

/*
 * Total Recipe Exports
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Total recipe exports\"]")
private WebElement totalRecipeExports;

/*
 * Most Exported Recipe
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Most exported recipe\"]")
private WebElement mostExportedRecipe;

/*
 * Exports This Month
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Exports this month\"]")
private WebElement exportsThisMonth;


// ======================== Content Status Methods ======================== //

/*
 * Verify Content Status Header
 */
public void verifyContentStatusHeader() {

    new WebDriverWait(
            driver,
            Duration.ofSeconds(10))
            .until(
                    ExpectedConditions.visibilityOf(
                            contentStatusHeader));

    System.out.println(
            "Content Status section displayed.");
}

/*
 * Get Top Exported Recipe
 */
public String getTopExportedRecipe() {

    return getRecipeMetricValue(
            "Top exported recipe");
}

/*
 * Get Community Count
 */
public String getCommunityCount() {

    return getRecipeMetricValue(
            "Community");
}

/*
 * Get AI Count
 */
public String getAICount() {

    return getRecipeMetricValue(
            "AI");
}

/*
 * Get Published Recipes Count
 */
public String getPublishedRecipesCount() {

    return getRecipeMetricValue(
            "Published recipes");
}

/*
 * Get Pending Recipes Count
 */
public String getPendingRecipesCount() {

    return getRecipeMetricValue(
            "Pending recipes");
}

/*
 * Get Pending Delete Recipes Count
 */
public String getPendingDeleteRecipesCount() {

    return getRecipeMetricValue(
            "Pending delete recipes");
}

/*
 * Get Monthly Recipe Growth
 */
public String getMonthlyRecipeGrowth() {

    String xpath =
            "//android.view.View[@content-desc=\"Monthly recipe growth\"]"
                    + "/following::android.view.View[contains(@content-desc,\"%\")][1]";

    WebElement growth =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10))
                    .until(
                            ExpectedConditions.visibilityOfElementLocated(
                                    AppiumBy.xpath(
                                            xpath)));

    String value =
            growth.getAttribute(
                    "content-desc");

    System.out.println(
            "Monthly recipe growth : "
                    + value);

    return value;
}


// ======================== Engagement Methods ======================== //

/*
 * Verify Engagement Header
 */
public void verifyEngagementHeader() {

    new WebDriverWait(
            driver,
            Duration.ofSeconds(10))
            .until(
                    ExpectedConditions.visibilityOf(
                            engagementHeader));

    System.out.println(
            "Engagement section displayed.");
}

/*
 * Get Top Liked Recipe
 */
public String getTopLikedRecipe() {

    return getRecipeMetricValue(
            "Top liked recipe");
}

/*
 * Get Top Commented Recipe
 */
public String getTopCommentedRecipe() {

    return getRecipeMetricValue(
            "Top commented recipe");
}

/*
 * Get Top Favorite Recipe
 */
public String getTopFavoriteRecipe() {

    return getRecipeMetricValue(
            "Top favorite recipe");
}

/*
 * Get Recipes With Likes Count
 */
public String getRecipesWithLikesCount() {

    return getRecipeMetricValue(
            "Recipes with likes");
}

/*
 * Get Recipes With Comments Count
 */
public String getRecipesWithCommentsCount() {

    return getRecipeMetricValue(
            "Recipes with comments");
}

/*
 * Get Recipes With Favorites Count
 */
public String getRecipesWithFavoritesCount() {

    return getRecipeMetricValue(
            "Recipes with favorites");
}


// ======================== Export Share Methods ======================== //

/*
 * Verify Export Share Header
 */
public void verifyExportsShareHeader() {

    new WebDriverWait(
            driver,
            Duration.ofSeconds(10))
            .until(
                    ExpectedConditions.visibilityOf(
                            exportsShareHeader));

    System.out.println(
            "Exports/Share section displayed.");
}

/*
 * Get Total Recipe Exports
 */
public String getTotalRecipeExports() {

    return getRecipeMetricValue(
            "Total recipe exports");
}

/*
 * Get Most Exported Recipe
 */
public String getMostExportedRecipe() {

    return getRecipeMetricValue(
            "Most exported recipe");
}

/*
 * Get Exports This Month
 */
public String getExportsThisMonth() {

    return getRecipeMetricValue(
            "Exports this month");
}

/*
 * Get Recipe Metric Value
 *
 * Label is used as anchor.
 */
private String getRecipeMetricValue(
        String label) {

    String xpath =
            "//android.view.View[@content-desc=\""
                    + label
                    + "\"]"
                    + "/following::android.view.View["
                    + "not(@content-desc=\""
                    + label
                    + "\")"
                    + " and string-length(@content-desc) > 0"
                    + "][1]";

    WebElement value =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10))
                    .until(
                            ExpectedConditions
                                    .visibilityOfElementLocated(
                                            AppiumBy.xpath(
                                                    xpath)));

    String metricValue =
            value.getAttribute(
                    "content-desc");

    System.out.println(
            label
                    + " : "
                    + metricValue);

    return metricValue;
}

/*
 * Mandatory Scroll Down To Engagement
 */
public void scrollDownToEngagement() {

    performSwipe(
            540,
            1500,
            540,
            500);

    try {

        Thread.sleep(
                1500);

    }

    catch (InterruptedException e) {

        Thread.currentThread()
                .interrupt();

        throw new RuntimeException(
                "Interrupted while scrolling to Engagement.",
                e);
    }

    /*
     * Wait Until Engagement Header Is Visible
     */
    new WebDriverWait(
            driver,
            Duration.ofSeconds(10))
            .until(
                    ExpectedConditions
                            .visibilityOfElementLocated(
                                    AppiumBy.xpath(
                                            "//android.view.View[@content-desc=\"ENGAGEMENT\"]")));

    System.out.println(
            "Mandatory scroll completed to Engagement section.");
}


/*
 * Scroll Down To Exports Share
 */
public void scrollDownToExportsShare() {

    performSwipe(
            540,
            1500,
            540,
            500);

    try {

        Thread.sleep(
                1500);

    }

    catch (InterruptedException e) {

        Thread.currentThread()
                .interrupt();

        throw new RuntimeException(
                "Interrupted while scrolling to Exports/Share.",
                e);
    }

    System.out.println(
            "Scrolled down to Exports/Share.");
}


/*
 * Scroll Up To Analytics
 */
public void scrollUpToAnalytics() {

    performSwipe(
            540,
            500,
            540,
            1500);

    try {

        Thread.sleep(
                1500);

    }

    catch (InterruptedException e) {

        Thread.currentThread()
                .interrupt();

        throw new RuntimeException(
                "Interrupted while scrolling to Analytics.",
                e);
    }

    System.out.println(
            "Scrolled up to Analytics.");
}


}