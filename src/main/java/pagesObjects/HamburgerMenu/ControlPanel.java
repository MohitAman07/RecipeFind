package pagesObjects.HamburgerMenu;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;
import org.testng.Assert;

public class ControlPanel {

    private AndroidDriver driver;
    private WaitUtil waitUtil;

    public ControlPanel(AndroidDriver driver) {

        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

        /*
 * Search
 */
@AndroidFindBy(xpath = "//android.widget.EditText")
private WebElement searchField;

/*
 * Groups
 */
@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]")
private WebElement groups;

/*
 * Sort
 */
@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Sort']")
private WebElement sortButton;

/*
 * Sort Options
 */
@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Newest']")
private WebElement newest;

@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Oldest']")
private WebElement oldest;

@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Name']")
private WebElement name;

/*
 * Tabs
 */
@AndroidFindBy(xpath = "//android.widget.HorizontalScrollView")
private WebElement horizontalScroll;

@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='All']")
private WebElement allTab;

@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Submitted']")
private WebElement submittedTab;

@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Verified']")
private WebElement verifiedTab;

@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Rejected']")
private WebElement rejectedTab;

@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Delete Pending']")
private WebElement deletePendingTab;

/*
 * Change Status Screen
 */
@AndroidFindBy(xpath = "//android.view.View[@content-desc='Change Status']")
private WebElement changeStatusScreen;

/*
 * Change Status Options
 */
@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Submitted']")
private WebElement submittedStatus;

@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Verified']")
private WebElement verifiedStatus;

@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Rejected']")
private WebElement rejectedStatus;

@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='DeletePending']")
private WebElement deletePendingStatus;

@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Delete Recipe']")
private WebElement deleteRecipe;

/*
 * Dynamic Group
 */
private WebElement group(String groupName) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='" + groupName + "']"));
}

/*
 * Dynamic Recipe Card
 */
private WebElement recipeCard(String recipeName) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.widget.ImageView[contains(@content-desc,'" + recipeName + "')]"));
}

/*
 * Dynamic Recipe Status
 */
private WebElement recipeStatus(String recipeName) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.widget.ImageView[contains(@content-desc,'" + recipeName
                            + "')]/android.view.View/android.view.View[3]"));
}

/*
 * Dynamic Recipe Menu (3 Dots)
 */
private WebElement recipeMenu(String recipeName) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.widget.ImageView[contains(@content-desc,'" + recipeName
                            + "')]/android.widget.Button"));
}

/*
 * Dynamic Recipe Name On Change Status Screen
 */
private WebElement changeStatusRecipe(String recipeName) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='" + recipeName + "']"));
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

public void enterSearchText(String recipeName) {

    Assert.assertTrue(
            searchField.isDisplayed(),
            "Search field is not displayed.");

    waitUtil.clickWithWait(searchField);
    searchField.clear();
    searchField.sendKeys(recipeName);
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

public void selectGroup(String groupName) {

    WebElement group = group(groupName);

    Assert.assertTrue(
            group.isDisplayed(),
            "Group '" + groupName + "' is not displayed.");

    waitUtil.clickWithWait(group);
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
 * All Tab
 */
public void clickAllTab() {

    horizontalScroll.findElement(
            AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                            + "new UiSelector().description(\"All\"))"));

    Assert.assertTrue(
            allTab.isDisplayed(),
            "All tab is not displayed.");

    waitUtil.clickWithWait(allTab);
}

/*
 * Submitted Tab
 */
public void clickSubmittedTab() {

    horizontalScroll.findElement(
            AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                            + "new UiSelector().description(\"Submitted\"))"));

    Assert.assertTrue(
            submittedTab.isDisplayed(),
            "Submitted tab is not displayed.");

    waitUtil.clickWithWait(submittedTab);
}

/*
 * Verified Tab
 */
public void clickVerifiedTab() {

    horizontalScroll.findElement(
            AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                            + "new UiSelector().description(\"Verified\"))"));

    Assert.assertTrue(
            verifiedTab.isDisplayed(),
            "Verified tab is not displayed.");

    waitUtil.clickWithWait(verifiedTab);
}

/*
 * Rejected Tab
 */
public void clickRejectedTab() {

    horizontalScroll.findElement(
            AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                            + "new UiSelector().description(\"Rejected\"))"));

    Assert.assertTrue(
            rejectedTab.isDisplayed(),
            "Rejected tab is not displayed.");

    waitUtil.clickWithWait(rejectedTab);
}

/*
 * Delete Pending Tab
 */
public void clickDeletePendingTab() {

    horizontalScroll.findElement(
            AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                            + "new UiSelector().description(\"Delete Pending\"))"));

    Assert.assertTrue(
            deletePendingTab.isDisplayed(),
            "Delete Pending tab is not displayed.");

    waitUtil.clickWithWait(deletePendingTab);
}

/*
 * Open Recipe
 */
public void openRecipe(String recipeName) {

    WebElement recipe = recipeCard(recipeName);

    Assert.assertTrue(
            recipe.isDisplayed(),
            "Recipe '" + recipeName + "' is not displayed.");

    waitUtil.clickWithWait(recipe);
}

/*
 * Verify Recipe Displayed
 */
public boolean isRecipeDisplayed(String recipeName) {

    return recipeCard(recipeName).isDisplayed();
}

/*
 * Get Recipe Status
 */
public String getRecipeStatus(String recipeName) {

    WebElement status = recipeStatus(recipeName);

    Assert.assertTrue(
            status.isDisplayed(),
            "Recipe status is not displayed.");

    return status.getAttribute("content-desc");
}

/*
 * Recipe Menu
 */
public void clickRecipeMenu(String recipeName) {

    WebElement menu = recipeMenu(recipeName);

    Assert.assertTrue(
            menu.isDisplayed(),
            "Recipe menu is not displayed.");

    waitUtil.clickWithWait(menu);
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
public boolean isRecipeDisplayedOnChangeStatus(String recipeName) {

    return changeStatusRecipe(recipeName).isDisplayed();
}

/*
 * Submitted
 */
public void clickSubmittedStatus() {

    Assert.assertTrue(
            submittedStatus.isDisplayed(),
            "Submitted option is not displayed.");

    waitUtil.clickWithWait(submittedStatus);
}

/*
 * Verified
 */
public void clickVerifiedStatus() {

    Assert.assertTrue(
            verifiedStatus.isDisplayed(),
            "Verified option is not displayed.");

    waitUtil.clickWithWait(verifiedStatus);
}

/*
 * Rejected
 */
public void clickRejectedStatus() {

    Assert.assertTrue(
            rejectedStatus.isDisplayed(),
            "Rejected option is not displayed.");

    waitUtil.clickWithWait(rejectedStatus);
}

/*
 * Delete Pending
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

    Assert.assertTrue(
            newest.isDisplayed(),
            "Newest option is not displayed.");

    return newest.isDisplayed();
}

public boolean isOldestDisplayed() {

    Assert.assertTrue(
            oldest.isDisplayed(),
            "Oldest option is not displayed.");

    return oldest.isDisplayed();
}

public boolean isNameDisplayed() {

    Assert.assertTrue(
            name.isDisplayed(),
            "Name option is not displayed.");

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

}