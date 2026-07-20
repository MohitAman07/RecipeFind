package pagesObjects.HamburgerMenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.WaitUtil;

public class GroupManagement {

    private AndroidDriver driver;
    private WaitUtil waitUtil;

    public GroupManagement(AndroidDriver driver) {

        this.driver = driver;
        this.waitUtil =
                new WaitUtil(driver);

        PageFactory.initElements(
                new AppiumFieldDecorator(driver),
                this);
    }

    /*
        * User Not Found Message
        */
        @AndroidFindBy(xpath = "//android.view.View[@content-desc='User not found']")
        private WebElement userNotFoundMessage;

    /*
        * No Groups Created Yet
        */
        @AndroidFindBy(xpath = "//android.view.View[@content-desc='No Groups Created Yet']")
        private WebElement noGroupsCreatedYetMessage;

    /*
     * Groups Heading
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Groups']")
    private WebElement groupsHeading;

    /*
     * Groups Scroll View
     */
    @AndroidFindBy(xpath = "//android.widget.ScrollView")
    private WebElement groupsScrollView;

    /*
     * Group Search Field
     */
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement groupSearchField;

    /*
     * Group Search Button
     */
    @AndroidFindBy(xpath = "//android.widget.EditText/following-sibling::android.widget.Button")
    private WebElement groupSearchButton;

    /*
     * Create Group Heading
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Create a Group']")
    private WebElement createGroupHeading;

    /*
     * View All Groups
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='View all groups']")
    private WebElement viewAllGroups;

    /*
     * Group Name Heading
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Group Name']")
    private WebElement groupNameHeading;

    /*
     * Group Name Field
     */
    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private WebElement groupNameField;

    /*
     * Group Description Heading
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Group Description']")
    private WebElement groupDescriptionHeading;

    /*
     * Group Description Field
     */
    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private WebElement groupDescriptionField;

    /*
     * Group Domain Heading
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Group Domain']")
    private WebElement groupDomainHeading;

    /*
     * Group Domain Field
     */
    @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
        private WebElement groupDomainField;

    /*
     * Assign Admin Heading
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Assign Admin']")
    private WebElement assignAdminHeading;

    /*
     * Assign Admin Field
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Assign Admin']")
    private WebElement assignAdminField;

    /*
     * Tick Button
     */
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View/android.widget.Button[1]")
    private WebElement tickButton;

    /*
     * Create Group Button
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Create Group']")
    private WebElement createGroupButton;

    /*
     * Cancel Button
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Cancel']")
    private WebElement cancelButton;


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
     * Dynamic Assign Admin to a Group after searching for the user
     */
    private WebElement assignAdminGroup(
            String email) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[contains(@content-desc,'"
                                + email
                                + "')]"));
    } 

/*
 * Groups Heading
 */
public boolean isGroupsHeadingDisplayed() {

    return groupsHeading.isDisplayed();
}

/*
 * Scroll Groups List
 */
public void scrollGroupsList() {

    try {

        groupsScrollView.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));

        System.out.println(
                "Groups list scrolled successfully.");
    }

    catch (Exception e) {

        System.out.println(
                "Unable to scroll groups list.");
    }
}
/*
 * Group Search Field
 */
public boolean isGroupSearchFieldDisplayed() {

    return groupSearchField.isDisplayed();
}

/*
 * Group Search Button
 */
public boolean isGroupSearchButtonDisplayed() {

    return groupSearchButton.isDisplayed();
}

/*
 * Create Group Heading
 */
public boolean isCreateGroupHeadingDisplayed() {

    return createGroupHeading.isDisplayed();
}

/*
 * View All Groups
 */
public boolean isViewAllGroupsDisplayed() {

    return viewAllGroups.isDisplayed();
}

/*
 * Group Name Heading
 */
public boolean isGroupNameHeadingDisplayed() {

    return groupNameHeading.isDisplayed();
}

/*
 * Group Name Field
 */
public boolean isGroupNameFieldDisplayed() {

    return groupNameField.isDisplayed();
}

/*
 * Group Description Heading
 */
public boolean isGroupDescriptionHeadingDisplayed() {

    return groupDescriptionHeading.isDisplayed();
}

/*
 * Group Description Field
 */
public boolean isGroupDescriptionFieldDisplayed() {

    return groupDescriptionField.isDisplayed();
}

/*
 * Group Domain Heading
 */
public boolean isGroupDomainHeadingDisplayed() {

    return groupDomainHeading.isDisplayed();
}

/*
 * Group Domain Field
 */
public boolean isGroupDomainFieldDisplayed() {

    return groupDomainField.isDisplayed();
}

/*
 * Assign Admin Heading
 */
public boolean isAssignAdminHeadingDisplayed() {

    return assignAdminHeading.isDisplayed();
}

/*
 * Assign Admin Field
 */
public boolean isAssignAdminFieldDisplayed() {

    return assignAdminField.isDisplayed();
}

/*
 * Tick Button
 */
public boolean isTickButtonDisplayed() {

    return tickButton.isDisplayed();
}

/*
 * Create Group Button
 */
public boolean isCreateGroupButtonDisplayed() {

    return createGroupButton.isDisplayed();
}

/*
 * Cancel Button
 */
public boolean isCancelButtonDisplayed() {

    return cancelButton.isDisplayed();
}

/*
 * Dynamic Group
 */
public boolean isGroupDisplayed(
        String groupName) {

    return group(groupName)
            .isDisplayed();
}

/*
 * Dynamic Admin User
 */
public boolean isAdminUserDisplayed(
        String email) {

    return assignAdminGroup(email)
            .isDisplayed();
}

/*
 * Enter Group Search
 */
public void enterGroupSearch(
        String groupName) {

    Assert.assertTrue(
            groupSearchField.isDisplayed(),
            "Group Search field is not displayed.");

    waitUtil.clickWithWait(
            groupSearchField);

    groupSearchField.clear();

    groupSearchField.sendKeys(
            groupName);

    System.out.println(
            "Group name entered : "
                    + groupName);
}

/*
 * Click Group Search Button
 */
public void clickGroupSearchButton() {

    Assert.assertTrue(
            groupSearchButton.isDisplayed(),
            "Group Search button is not displayed.");

    waitUtil.clickWithWait(
            groupSearchButton);

    System.out.println(
            "Group Search button clicked.");
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
            "Group '"
                    + groupName
                    + "' is not displayed.");

    waitUtil.clickWithWait(
            groupElement);

    System.out.println(
            "Group selected : "
                    + groupName);
}

/*
 * Enter Group Name
 */
public void enterGroupName(
        String groupName) {

    Assert.assertTrue(
            groupNameField.isDisplayed(),
            "Group Name field is not displayed.");

    waitUtil.clickWithWait(
            groupNameField);

    groupNameField.clear();

    groupNameField.sendKeys(
            groupName);

    System.out.println(
            "Group Name entered : "
                    + groupName);
}

/*
 * Enter Group Description
 */
public void enterGroupDescription(
        String description) {

    Assert.assertTrue(
            groupDescriptionField.isDisplayed(),
            "Group Description field is not displayed.");

    waitUtil.clickWithWait(
            groupDescriptionField);

    groupDescriptionField.clear();

    groupDescriptionField.sendKeys(
            description);

    System.out.println(
            "Group Description entered.");
}

/*
 * Enter Group Domain
 */
public void enterGroupDomain(
        String domain) {

    Assert.assertTrue(
            groupDomainField.isDisplayed(),
            "Group Domain field is not displayed.");

    waitUtil.clickWithWait(
            groupDomainField);

    groupDomainField.clear();

    groupDomainField.sendKeys(
            domain);

    System.out.println(
            "Group Domain entered : "
                    + domain);
}

/*
 * Enter Assign Admin
 */
public void enterAssignAdmin(
        String email) {

    Assert.assertTrue(
            assignAdminField.isDisplayed(),
            "Assign Admin field is not displayed.");

    waitUtil.clickWithWait(
            assignAdminField);

    assignAdminField.clear();

    assignAdminField.sendKeys(
            email);

    System.out.println(
            "Admin entered : "
                    + email);
}

/*
 * Click Tick Button
 */
public void clickTickButton() {

    Assert.assertTrue(
            tickButton.isDisplayed(),
            "Tick button is not displayed.");

    waitUtil.clickWithWait(
            tickButton);

    System.out.println(
            "Tick button clicked.");
}

/*
 * Select Admin User
 */
public void clickAdminUser(
        String email) {

    WebElement admin =
            assignAdminGroup(email);

    Assert.assertTrue(
            admin.isDisplayed(),
            "Admin user is not displayed.");

    waitUtil.clickWithWait(
            admin);

    System.out.println(
            "Admin user selected : "
                    + email);
}

/*
 * Click Create Group
 */
public void clickCreateGroup() {

    Assert.assertTrue(
            createGroupButton.isDisplayed(),
            "Create Group button is not displayed.");

    waitUtil.clickWithWait(
            createGroupButton);

    System.out.println(
            "Create Group button clicked.");
}

/*
 * Click Cancel
 */
public void clickCancel() {

    Assert.assertTrue(
            cancelButton.isDisplayed(),
            "Cancel button is not displayed.");

    waitUtil.clickWithWait(
            cancelButton);

    System.out.println(
            "Cancel button clicked.");
}

/*
 * Click View All Groups
 */
public void clickViewAllGroups() {

    Assert.assertTrue(
            viewAllGroups.isDisplayed(),
            "View All Groups option is not displayed.");

    waitUtil.clickWithWait(
            viewAllGroups);

    System.out.println(
            "View All Groups clicked.");
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
 * Verify Super Admin
 */
public boolean isSuperAdmin() {

    return isCreateGroupHeadingDisplayed();
}

/*
 * Verify Super Admin Access
 */
public boolean hasCreateGroupAccess() {

    try {

        return createGroupHeading.isDisplayed();
    }

    catch (Exception e) {

        return false;
    }
}

/*
 * No Groups Created Yet Message
 */
public boolean isNoGroupsCreatedYetMessageDisplayed() {

    try {

        return noGroupsCreatedYetMessage.isDisplayed();
    }

    catch (Exception e) {

        return false;
    }
}

/*
 * User Not Found Message
 */
public boolean isUserNotFoundMessageDisplayed() {

    try {

        return userNotFoundMessage.isDisplayed();
    }

    catch (Exception e) {

        return false;
    }
}


}

