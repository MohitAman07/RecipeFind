package pagesObjects.HamburgerMenu;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.WaitUtil;

public class ControlPanel {

    private AndroidDriver driver;

    private WaitUtil waitUtil;

    public ControlPanel(
            AndroidDriver driver) {

        this.driver =
                driver;

        this.waitUtil =
                new WaitUtil(driver);

        PageFactory.initElements(
                new AppiumFieldDecorator(driver),
                this);
    }

    /*
     * Search
     */
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement searchField;

    /*
     * Groups
     */
    @AndroidFindBy(
            xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]")
    private WebElement groups;

    /*
     * Sort
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Sort']")
    private WebElement sortButton;

    /*
     * Sort Options
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Newest']")
    private WebElement newest;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Oldest']")
    private WebElement oldest;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Name']")
    private WebElement name;

    /*
     * Horizontal Tabs
     */
    @AndroidFindBy(
            xpath = "//android.widget.HorizontalScrollView")
    private WebElement horizontalScroll;

//     @AndroidFindBy(
//             xpath = "//android.widget.Button[@content-desc='All']")
//     private WebElement allTab;

//     @AndroidFindBy(
//             xpath = "//android.widget.Button[@content-desc='Submitted']")
//     private WebElement submittedTab;

//     @AndroidFindBy(
//             xpath = "//android.widget.Button[@content-desc='Verified']")
//     private WebElement verifiedTab;

//     @AndroidFindBy(
//             xpath = "//android.widget.Button[@content-desc='Rejected']")
//     private WebElement rejectedTab;

//     @AndroidFindBy(
//             xpath = "//android.widget.Button[@content-desc='Delete Pending']")
//     private WebElement deletePendingTab;

@AndroidFindBy(
        xpath = "//android.widget.Button[starts-with(@content-desc,'All')]")
private WebElement allTab;

@AndroidFindBy(
        xpath = "//android.widget.Button[starts-with(@content-desc,'Submitted')]")
private WebElement submittedTab;

@AndroidFindBy(
        xpath = "//android.widget.Button[starts-with(@content-desc,'Verified')]")
private WebElement verifiedTab;

@AndroidFindBy(
        xpath = "//android.widget.Button[starts-with(@content-desc,'Rejected')]")
private WebElement rejectedTab;

@AndroidFindBy(
    xpath = "//android.widget.Button[starts-with(@content-desc,'Delete Pending')]")
private WebElement deletePendingTab;

    /*
     * Change Status Screen
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc='Change Status']")
    private WebElement changeStatusScreen;

    /*
     * Change Status Options
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Submitted']")
    private WebElement submittedStatus;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Verified']")
    private WebElement verifiedStatus;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Rejected']")
    private WebElement rejectedStatus;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='DeletePending']")
    private WebElement deletePendingStatus;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Delete Recipe']")
    private WebElement deleteRecipe;

    /*
     * Group Search
     */
    @AndroidFindBy(
            xpath = "//android.widget.EditText")
    private WebElement groupSearchField;

    @AndroidFindBy(
            xpath = "//android.widget.EditText/following-sibling::android.widget.Button")
    private WebElement groupSearchButton;

        /*
     * Dynamic Group
     */
    private WebElement group(
            String groupName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='"
                                + groupName
                                + "']"));
    }

    /*
     * Dynamic Recipe Card
     */
    private WebElement recipeCard(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'"
                                + recipeName
                                + "')]"));
    }


/*
 * Dynamic Recipe Menu (3 Dots)
 */
private WebElement recipeMenu(
        String recipeName) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[contains(@content-desc,'"
                            + recipeName
                            + "')]/android.widget.Button[last()]"));
}

    /*
     * Dynamic Recipe Author
     */
    private WebElement recipeAuthor(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'"
                                + recipeName
                                + "')]/android.view.View[contains(@content-desc,'by ')]"));
    }

    /*
     * Dynamic Comment Icon
     */
    private WebElement recipeCommentIcon(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'"
                                + recipeName
                                + "')]/android.widget.ImageView[1]"));
    }

    /*
     * Dynamic Cooking Time
     */
    private WebElement recipeCookingTime(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "(//android.view.View[contains(@content-desc,'"
                                + recipeName
                                + "')]//android.view.View[contains(@content-desc,'Min')])[1]"));
    }

    /*
     * Dynamic Serving Time
     */
    private WebElement recipeServingTime(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "(//android.view.View[contains(@content-desc,'"
                                + recipeName
                                + "')]//android.view.View[contains(@content-desc,'Min')])[2]"));
    }

    /*
     * Dynamic Recipe Status Icon
     */
    private WebElement recipeStatus(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'"
                                + recipeName
                                + "')]/android.view.View[3]/android.view.View[3]"));
    }

    /*
     * Dynamic Recipe Description
     */
    private WebElement recipeDescription(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'"
                                + recipeName
                                + "')]"));
    }

    /*
     * Dynamic Recipe Name On Change Status Screen
     */
    private WebElement changeStatusRecipe(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='"
                                + recipeName
                                + "']"));
    }

        /*
     * Search Field
     */
    public void clickSearchField() {

        Assert.assertTrue(
                searchField.isDisplayed(),
                "Search field is not displayed.");

        waitUtil.clickWithWait(searchField);
    }


// /*
//  * Enter Search Text
//  */
// public void enterSearchText(
//         String searchText) {

//     waitUtil.waitForElementVisible(
//             searchField);

//     searchField.click();

//     searchField.clear();

//     /*
//      * Enter One Character At A Time
//      */
//     for (char character :
//             searchText.toCharArray()) {

//         searchField.sendKeys(
//                 String.valueOf(
//                         character));

//         try {

//             Thread.sleep(
//                     3000);

//         }

//         catch (InterruptedException e) {

//             Thread.currentThread()
//                     .interrupt();

//             throw new RuntimeException(
//                     "Interrupted while entering search text.",
//                     e);
//         }

//         /*
//          * Check Complete Recipe Card
//          * After Each Character
//          */
//         try {

//             WebElement recipeCard =
//                     driver.findElement(
//                             AppiumBy.xpath(
//                                     "//android.view.View[contains(@content-desc,'"
//                                             + searchText
//                                             + "')]"));

//             if (recipeCard.isDisplayed()) {

//                 System.out.println(
//                         "Recipe card appeared during search : "
//                                 + searchText);

//                 return;
//             }

//         }

//         catch (Exception e) {

//             /*
//              * Recipe card is not available yet.
//              * Continue entering next character.
//              */
//             System.out.println(
//                     "Recipe card not available yet. "
//                             + "Continuing search : "
//                             + searchText);
//         }
//     }

//     /*
//      * Full Search Text Entered
//      */
//     System.out.println(
//             "Full search text entered : "
//                     + searchText);

//     /*
//      * Wait For Final Recipe Result
//      */
//     try {

//         Thread.sleep(
//                 5000);

//     }

//     catch (InterruptedException e) {

//         Thread.currentThread()
//                 .interrupt();

//         throw new RuntimeException(
//                 "Interrupted while waiting for search result.",
//                 e);
//     }

//     /*
//      * Final Recipe Card Check
//      */
//     try {

//         WebElement recipeCard =
//                 driver.findElement(
//                         AppiumBy.xpath(
//                                 "//android.view.View[contains(@content-desc,'"
//                                         + searchText
//                                         + "')]"));

//         if (recipeCard.isDisplayed()) {

//             System.out.println(
//                     "Recipe card displayed after full search : "
//                             + searchText);

//         }

//     }

//     catch (Exception e) {

//         System.out.println(
//                 "Recipe card not displayed after full search : "
//                         + searchText);
//     }
// }

/*
 * Enter Search Text
 */
public void enterSearchText(
        String searchText) {

    waitUtil.waitForElementVisible(
            searchField);

    waitUtil.clickWithWait(
            searchField);

    searchField.clear();

    /*
     * Sequential Input Delay
     */
    int inputDelay =
            3000;

    boolean recipeFound =
            false;

    /*
     * Enter One Character At A Time
     */
    for (char character :
            searchText.toCharArray()) {

        searchField.sendKeys(
                String.valueOf(
                        character));

        /*
         * Wait After Each Character
         * To Allow Search Results To Load
         */
        waitUtil.sleep(
                inputDelay);

        /*
         * Check Complete Recipe Card
         * After Each Character
         */
        try {

            WebElement recipeCard =
                    driver.findElement(
                            AppiumBy.xpath(
                                    "//android.view.View[contains(@content-desc,'"
                                            + searchText
                                            + "')]"));

            if (recipeCard.isDisplayed()) {

                System.out.println(
                        "Recipe card appeared during search : "
                                + searchText);

                recipeFound =
                        true;

                break;
            }

        }

        catch (Exception e) {

            /*
             * Recipe card is not available yet.
             * Continue entering next character.
             */
            System.out.println(
                    "Recipe card not available yet. "
                            + "Continuing search : "
                            + searchText);
        }
    }

    /*
     * If Recipe Is Found During Sequential Search
     */
    if (recipeFound) {
        return;
    }

    /*
     * Sequential Search Did Not Find Recipe
     *
     * Clear The Search Field And Enter
     * The Complete Search Text
     */
    System.out.println(
            "Recipe not found using sequential search. "
                    + "Trying complete search text.");

    searchField.clear();

    /*
     * Small Delay After Clearing
     */
    waitUtil.sleep(
            1000);

    /*
     * Enter Complete Search String
     */
    searchField.sendKeys(
            searchText);

    /*
     * Wait For Search Result
     */
    waitUtil.sleep(
            5000);

    /*
     * Final Recipe Card Check
     */
    try {

        WebElement recipeCard =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.view.View[contains(@content-desc,'"
                                        + searchText
                                        + "')]"));

        if (recipeCard.isDisplayed()) {

            System.out.println(
                    "Recipe card displayed after complete search : "
                            + searchText);

        }

    }

    catch (Exception e) {

        System.out.println(
                "Recipe card not displayed after complete search : "
                        + searchText);
    }
}


    public void clearSearchField() {

        Assert.assertTrue(
                searchField.isDisplayed(),
                "Search field is not displayed.");

        searchField.clear();
    }

    /*
     * Groups
     */
    public void clickGroups() {

        Assert.assertTrue(
                groups.isDisplayed(),
                "Groups section is not displayed.");

        waitUtil.clickWithWait(groups);
    }

    /*
     * Select Group
     */
    public void selectGroup(
            String groupName) {

        WebElement groupElement =
                group(groupName);

        Assert.assertTrue(
                groupElement.isDisplayed(),
                "Group '" + groupName
                        + "' is not displayed.");

        waitUtil.clickWithWait(groupElement);
    }

    /*
     * Group Search
     */
    public void enterGroupSearch(
            String groupName) {

        Assert.assertTrue(
                groupSearchField.isDisplayed(),
                "Group Search field is not displayed.");

        waitUtil.clickWithWait(groupSearchField);

        groupSearchField.clear();

        groupSearchField.sendKeys(groupName);
    }

    public void clickGroupSearchButton() {

        Assert.assertTrue(
                groupSearchButton.isDisplayed(),
                "Group Search button is not displayed.");

        waitUtil.clickWithWait(groupSearchButton);
    }

    /*
     * Sort
     */
    public void clickSort() {

        Assert.assertTrue(
                sortButton.isDisplayed(),
                "Sort button is not displayed.");

        waitUtil.clickWithWait(sortButton);
    }

    public void selectNewest() {

        Assert.assertTrue(
                newest.isDisplayed(),
                "Newest option is not displayed.");

        waitUtil.clickWithWait(newest);
    }

    public void selectOldest() {

        Assert.assertTrue(
                oldest.isDisplayed(),
                "Oldest option is not displayed.");

        waitUtil.clickWithWait(oldest);
    }

    public void selectName() {

        Assert.assertTrue(
                name.isDisplayed(),
                "Name option is not displayed.");

        waitUtil.clickWithWait(name);
    }

    /*
 * Horizontal Scroll To Make Tab Visible
 */
private void scrollHorizontalTabs(WebElement tab) {

    /*
     * Check if tab is already visible
     */
    try {

        if (tab.isDisplayed()) {

            System.out.println(
                    "Tab is already visible.");

            return;
        }

    } catch (Exception e) {
        // Continue with scrolling.
    }

    /*
     * Swipe left to find the tab
     */
    for (int i = 1; i <= 3; i++) {

        swipeTabsLeft();

        waitUtil.sleep(500);

        try {

            if (tab.isDisplayed()) {

                System.out.println(
                        "Tab became visible after left swipe : "
                        + i);

                return;
            }

        } catch (Exception e) {
            // Continue scrolling.
        }
    }

    /*
     * Swipe right to find the tab
     */
    for (int i = 1; i <= 3; i++) {

        swipeTabsRight();

        waitUtil.sleep(500);

        try {

            if (tab.isDisplayed()) {

                System.out.println(
                        "Tab became visible after right swipe : "
                        + i);

                return;
            }

        } catch (Exception e) {
            // Continue scrolling.
        }
    }

    throw new RuntimeException(
            "Unable to make Control Panel tab visible.");
}

/*
 * Horizontal Swipe To Left
 */
private void swipeTabsLeft() {

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
                    900,
                    675));

    swipe.addAction(
            finger.createPointerDown(
                    PointerInput.MouseButton.LEFT.asArg()));

    swipe.addAction(
            finger.createPointerMove(
                    Duration.ofMillis(800),
                    PointerInput.Origin.viewport(),
                    200,
                    675));

    swipe.addAction(
            finger.createPointerUp(
                    PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(
            Arrays.asList(
                    swipe));

    waitUtil.sleep(1000);

    System.out.println(
            "Control Panel tabs swiped left.");
}

/*
 * Horizontal Swipe To Right
 */
private void swipeTabsRight() {

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
                    200,
                    675));

    swipe.addAction(
            finger.createPointerDown(
                    PointerInput.MouseButton.LEFT.asArg()));

    swipe.addAction(
            finger.createPointerMove(
                    Duration.ofMillis(800),
                    PointerInput.Origin.viewport(),
                    900,
                    675));

    swipe.addAction(
            finger.createPointerUp(
                    PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(
            Arrays.asList(
                    swipe));

    waitUtil.sleep(1000);

    System.out.println(
            "Control Panel tabs swiped right.");
}

        /*
 * Click All Tab
 */
public void clickAllTab() {

    scrollHorizontalTabs(
            allTab);

    waitUtil.waitForElementVisible(
            allTab);

    waitUtil.clickWithWait(
            allTab);

    System.out.println(
            "All tab clicked.");
}

/*
 * Click Submitted Tab
 */
public void clickSubmittedTab() {

    scrollHorizontalTabs(
            submittedTab);

    waitUtil.waitForElementVisible(
            submittedTab);

    waitUtil.clickWithWait(
            submittedTab);

    System.out.println(
            "Submitted tab clicked.");
}

/*
 * Click Verified Tab
 */
public void clickVerifiedTab() {

    scrollHorizontalTabs(
            verifiedTab);

    waitUtil.waitForElementVisible(
            verifiedTab);

    waitUtil.clickWithWait(
            verifiedTab);

    System.out.println(
            "Verified tab clicked.");
}

/*
 * Click Rejected Tab
 */
public void clickRejectedTab() {

    scrollHorizontalTabs(
            rejectedTab);

    waitUtil.waitForElementVisible(
            rejectedTab);

    waitUtil.clickWithWait(
            rejectedTab);

    System.out.println(
            "Rejected tab clicked.");
}



/*
 * Click Delete Pending Tab
 */
public void clickDeletePendingTab() {

    scrollHorizontalTabs(
            deletePendingTab);

    waitUtil.waitForElementVisible(
            deletePendingTab);

    waitUtil.clickWithWait(
            deletePendingTab);

    System.out.println(
            "Delete Pending tab clicked.");
}

    /*
     * Open Recipe
     */
    public void openRecipe(
            String recipeName) {

        WebElement recipe =
                recipeCard(recipeName);

        Assert.assertTrue(
                recipe.isDisplayed(),
                "Recipe '" + recipeName
                        + "' is not displayed.");

        waitUtil.clickWithWait(recipe);
    }

    /*
     * Click Recipe Menu
     */
    public void clickRecipeMenu(
            String recipeName) {

        WebElement menu =
                recipeMenu(recipeName);

        Assert.assertTrue(
                menu.isDisplayed(),
                "Recipe menu is not displayed.");

        waitUtil.clickWithWait(menu);
    }

    /*
     * Click Recipe Author
     */
    public void clickRecipeAuthor(
            String recipeName) {

        WebElement author =
                recipeAuthor(recipeName);

        Assert.assertTrue(
                author.isDisplayed(),
                "Recipe author is not displayed.");

        waitUtil.clickWithWait(author);

        System.out.println(
                "Recipe author clicked.");
    }

    /*
     * Click Comment Icon
     */
    public void clickCommentIcon(
            String recipeName) {

        WebElement comment =
                recipeCommentIcon(recipeName);

        Assert.assertTrue(
                comment.isDisplayed(),
                "Comment icon is not displayed.");

        waitUtil.clickWithWait(comment);
    }

    /*
     * Get Cooking Time
     */
    public String getCookingTime(
            String recipeName) {

        WebElement cookingTime =
                recipeCookingTime(recipeName);

        Assert.assertTrue(
                cookingTime.isDisplayed(),
                "Cooking time is not displayed.");

        return cookingTime.getAttribute(
                "content-desc");
    }

    /*
     * Get Serving Time
     */
    public String getServingTime(
            String recipeName) {

        WebElement servingTime =
                recipeServingTime(recipeName);

        Assert.assertTrue(
                servingTime.isDisplayed(),
                "Serving time is not displayed.");

        return servingTime.getAttribute(
                "content-desc");
    }

    /*
     * Get Recipe Status
     */
    public String getRecipeStatus(
            String recipeName) {

        WebElement status =
                recipeStatus(recipeName);

        Assert.assertTrue(
                status.isDisplayed(),
                "Recipe status is not displayed.");

        return status.getAttribute(
                "content-desc");
    }

    /*
     * Get Recipe Description
     */
    public String getRecipeDescription(
            String recipeName) {

        WebElement description =
                recipeDescription(recipeName);

        Assert.assertTrue(
                description.isDisplayed(),
                "Recipe description is not displayed.");

        return description.getAttribute(
                "content-desc");
    }

        /*
     * Verify Recipe Displayed
     */
    public boolean isRecipeDisplayed(
            String recipeName) {

        return recipeCard(recipeName).isDisplayed();
    }

    /*
     * Verify Recipe Author Displayed
     */
    public boolean isRecipeAuthorDisplayed(
            String recipeName) {

        return recipeAuthor(recipeName).isDisplayed();
    }

    /*
     * Verify Comment Icon Displayed
     */
    public boolean isCommentIconDisplayed(
            String recipeName) {

        return recipeCommentIcon(recipeName).isDisplayed();
    }

    /*
     * Verify Cooking Time Displayed
     */
    public boolean isCookingTimeDisplayed(
            String recipeName) {

        return recipeCookingTime(recipeName).isDisplayed();
    }

    /*
     * Verify Serving Time Displayed
     */
    public boolean isServingTimeDisplayed(
            String recipeName) {

        return recipeServingTime(recipeName).isDisplayed();
    }

    /*
     * Verify Recipe Status Displayed
     */
    public boolean isRecipeStatusDisplayed(
            String recipeName) {

        return recipeStatus(recipeName).isDisplayed();
    }

    /*
     * Verify Change Status Screen
     */
    public boolean isChangeStatusScreenDisplayed() {

        return changeStatusScreen.isDisplayed();
    }

    /*
     * Verify Recipe Name On Change Status Screen
     */
    public boolean isRecipeDisplayedOnChangeStatus(
            String recipeName) {

        return changeStatusRecipe(recipeName).isDisplayed();
    }

    /*
     * Submitted Status
     */
    public void clickSubmittedStatus() {

        Assert.assertTrue(
                submittedStatus.isDisplayed(),
                "Submitted option is not displayed.");

        waitUtil.clickWithWait(submittedStatus);
    }

    /*
     * Verified Status
     */
    public void clickVerifiedStatus() {

        Assert.assertTrue(
                verifiedStatus.isDisplayed(),
                "Verified option is not displayed.");

        waitUtil.clickWithWait(verifiedStatus);
    }

    /*
     * Rejected Status
     */
    public void clickRejectedStatus() {

        Assert.assertTrue(
                rejectedStatus.isDisplayed(),
                "Rejected option is not displayed.");

        waitUtil.clickWithWait(rejectedStatus);
    }

    /*
     * Delete Pending Status
     */
    public void clickDeletePendingStatus() {

        Assert.assertTrue(
                deletePendingStatus.isDisplayed(),
                "Delete Pending option is not displayed.");

        waitUtil.clickWithWait(deletePendingStatus);
    }

    /*
     * Delete Recipe
     */
    public boolean isDeleteRecipeDisplayed() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='Delete Recipe']"))
                .isEmpty();
    }

    /*
     * Change Status Options
     */
    public boolean isSubmittedStatusDisplayed() {

        return submittedStatus.isDisplayed();
    }

    public boolean isVerifiedStatusDisplayed() {

        return verifiedStatus.isDisplayed();
    }

    public boolean isRejectedStatusDisplayed() {

        return rejectedStatus.isDisplayed();
    }

    public boolean isDeletePendingStatusDisplayed() {

        return deletePendingStatus.isDisplayed();
    }

    /*
     * Tabs
     */
    public boolean isAllTabDisplayed() {

        return allTab.isDisplayed();
    }

    public boolean isSubmittedTabDisplayed() {

        return submittedTab.isDisplayed();
    }

    public boolean isVerifiedTabDisplayed() {

        return verifiedTab.isDisplayed();
    }

    public boolean isRejectedTabDisplayed() {

        return rejectedTab.isDisplayed();
    }

    public boolean isDeletePendingTabDisplayed() {

        return deletePendingTab.isDisplayed();
    }

    /*
     * Sort Button
     */
    public boolean isSortButtonDisplayed() {

        return sortButton.isDisplayed();
    }

    /*
     * Sort Options
     */
    public boolean isNewestDisplayed() {

        return newest.isDisplayed();
    }

    public boolean isOldestDisplayed() {

        return oldest.isDisplayed();
    }

    public boolean isNameDisplayed() {

        return name.isDisplayed();
    }

    /*
     * Search Field
     */
    public boolean isSearchFieldDisplayed() {

        return searchField.isDisplayed();
    }

    /*
     * Groups
     */
    public boolean isGroupsDisplayed() {

        return groups.isDisplayed();
    }

    /*
     * Hide Keyboard
     */
    public void hideKeyboard() {

        try {

            driver.hideKeyboard();

            System.out.println(
                    "Keyboard hidden successfully.");
        }
        catch (Exception e) {

            System.out.println(
                    "Keyboard is already hidden.");
        }
    }

    /*
 * Wait For Recipe To Be Displayed
 */
public boolean waitForRecipeDisplayed(
        String recipeName) {

    try {

        new WebDriverWait(
                driver,
                Duration.ofSeconds(20))
                .until(
                        driver -> {

                            try {

                                return isRecipeDisplayed(
                                        recipeName);

                            }

                            catch (Exception e) {

                                return false;
                            }
                        });

        System.out.println(
                "Recipe loaded successfully : "
                        + recipeName);

        return true;

    }

    catch (Exception e) {

        System.out.println(
                "Recipe not loaded within wait time : "
                        + recipeName);

        return false;
    }
}
}