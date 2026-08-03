package pagesObjects.Profile;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.WaitUtil;

public class Personal_Tab {

    private final AndroidDriver driver;

    private final WaitUtil waitUtil;

    public Personal_Tab(
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

    /*
     * Personal Tab
     */
    private WebElement personalTab() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Personal\nTab 1 of 4']"));
    }

    /*
     * Profile Tag
     */
    private WebElement profileTag() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'.')]"));
    }

    /*
     * Personal Email
     */
    private WebElement personalEmail() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'@')]"));
    }

    /*
     * Verify Personal Tab
     */
    public boolean isPersonalTabDisplayed() {

        try {

            return personalTab()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Personal Tab
     */
    public void clickPersonalTab() {

        waitUtil.clickWithWait(
                personalTab());

        System.out.println(
                "Personal Tab clicked.");
    }

    /*
     * Verify Profile Tag
     */
    public boolean isProfileTagDisplayed() {

        try {

            return profileTag()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Profile Tag
     */
    public String getProfileTag() {

        String profile =

                profileTag()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Profile Tag : "
                        + profile);

        return profile;
    }

    /*
     * Verify Personal Email
     */
    public boolean isPersonalEmailDisplayed() {

        try {

            return personalEmail()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Personal Email
     */
    public String getPersonalEmail() {

        String email =

                personalEmail()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Personal Email : "
                        + email);

        return email;
    }

        /*
     * First Name / Last Name Card
     */
    private WebElement firstLastNameCard() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='First Name\nLast Name']"));
    }

    /*
     * First Name Field
     */
    private WebElement firstNameField() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='First Name\nLast Name']/android.widget.EditText[1]"));
    }

    /*
     * Last Name Field
     */
    private WebElement lastNameField() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='First Name\nLast Name']/android.widget.EditText[2]"));
    }

    /*
     * Save Name Button
     */
    private WebElement saveNameButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='First Name\nLast Name']/android.widget.Button"));
    }

    /*
     * Verify Name Card
     */
    public boolean isNameCardDisplayed() {

        try {

            return firstLastNameCard()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get First Name
     */
    public String getFirstName() {

        String firstName =
                firstNameField()
                        .getAttribute(
                                "text");

        System.out.println(
                "First Name : "
                        + firstName);

        return firstName;
    }

    /*
     * Get Last Name
     */
    public String getLastName() {

        String lastName =
                lastNameField()
                        .getAttribute(
                                "text");

        System.out.println(
                "Last Name : "
                        + lastName);

        return lastName;
    }

    /*
     * Enter First Name
     */
    public void enterFirstName(
            String firstName) {

        waitUtil.clickWithWait(
                firstNameField());

        firstNameField()
                .clear();

        waitUtil.sleep(
                500);

        firstNameField()
                .sendKeys(
                        firstName);

        try {

            driver.hideKeyboard();

        }

        catch (Exception e) {

        }

        System.out.println(
                "First Name Entered : "
                        + firstName);
    }

    /*
     * Enter Last Name
     */
    public void enterLastName(
            String lastName) {

        waitUtil.clickWithWait(
                lastNameField());

        lastNameField()
                .clear();

        waitUtil.sleep(
                500);

        lastNameField()
                .sendKeys(
                        lastName);

        try {

            driver.hideKeyboard();

        }

        catch (Exception e) {

        }

        System.out.println(
                "Last Name Entered : "
                        + lastName);
    }

    /*
     * Save Name
     */
    public void clickSaveName() {

        waitUtil.clickWithWait(
                saveNameButton());

        waitUtil.sleep(
                2000);

        System.out.println(
                "Name saved successfully.");
    }

    /*
     * Update Name
     */
    public void updateName(
            String firstName,
            String lastName) {

        enterFirstName(
                firstName);

        enterLastName(
                lastName);

        clickSaveName();
    }

        /*
     * Contact Information Field
     */
    private WebElement contactInformationField() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.EditText[contains(@text,'@')]"));
    }

    /*
     * Save Contact Information Button
     */
    private WebElement saveContactInformationButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.EditText[contains(@text,'@')]/android.widget.Button"));
    }

    /*
     * Verify Contact Information
     */
    public boolean isContactInformationDisplayed() {

        try {

            return contactInformationField()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Contact Information
     */
    public String getContactInformation() {

        String contactInformation =
                contactInformationField()
                        .getAttribute(
                                "text");

        System.out.println(
                "Contact Information : "
                        + contactInformation);

        return contactInformation;
    }

    /*
     * Enter Contact Information
     */
    public void enterContactInformation(
            String contactInformation) {

        waitUtil.clickWithWait(
                contactInformationField());

        contactInformationField()
                .clear();

        waitUtil.sleep(
                500);

        contactInformationField()
                .sendKeys(
                        contactInformation);

        try {

            driver.hideKeyboard();

        }

        catch (Exception e) {

        }

        System.out.println(
                "Contact Information Entered : "
                        + contactInformation);
    }

    /*
     * Add Email Address
     */
    public void addEmailAddress(
            String emailAddress) {

        String existingEmails =
                getContactInformation();

        if (!existingEmails.isBlank()) {

            existingEmails =
                    existingEmails
                            + "; "
                            + emailAddress;

        }

        else {

            existingEmails =
                    emailAddress;
        }

        enterContactInformation(
                existingEmails);
    }

    /*
     * Save Contact Information
     */
    public void clickSaveContactInformation() {

        waitUtil.clickWithWait(
                saveContactInformationButton());

        waitUtil.sleep(
                2000);

        System.out.println(
                "Contact Information saved.");
    }

    /*
     * Update Contact Information
     */
    public void updateContactInformation(
            String contactInformation) {

        enterContactInformation(
                contactInformation);

        clickSaveContactInformation();
    }

    /*
     * Recipe Statistics Card
     */
    private WebElement recipeStatisticsCard() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'Recipes')]"));
    }

    /*
     * Verify Recipe Statistics Card
     */
    public boolean isRecipeStatisticsDisplayed() {

        try {

            return recipeStatisticsCard()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Recipe Statistics
     */
    public String getRecipeStatistics() {

        String statistics =
                recipeStatisticsCard()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Recipe Statistics :");

        System.out.println(
                statistics);

        return statistics;
    }

    /*
     * Get Recipes Contributed Count
     */
    public String getRecipesContributedCount() {

        String[] values =
                getRecipeStatistics()
                        .split(
                                "\\n");

        for (int i = 0; i < values.length; i++) {

            if (values[i].equalsIgnoreCase(
                    "Contributed")) {

                String contributed =
                        values[i - 1];

                System.out.println(
                        "Recipes Contributed : "
                                + contributed);

                return contributed;
            }
        }

        return "";
    }

    /*
     * Get Saved Recipes Count
     */
    public String getSavedRecipesCount() {

        String[] values =
                getRecipeStatistics()
                        .split(
                                "\\n");

        for (int i = 0; i < values.length; i++) {

            if (values[i].equalsIgnoreCase(
                    "Saved")) {

                String saved =
                        values[i - 1];

                System.out.println(
                        "Saved Recipes : "
                                + saved);

                return saved;
            }
        }

        return "";
    }

    /*
     * Verify Recipe Counts Loaded
     */
    public boolean isRecipeCountLoaded() {

        return !getRecipesContributedCount()
                .isBlank()
                &&
                !getSavedRecipesCount()
                        .isBlank();
    }

    /*
     * Print Recipe Counts
     */
    public void printRecipeCounts() {

        System.out.println(
                "Recipes Contributed : "
                        + getRecipesContributedCount());

        System.out.println(
                "Saved Recipes : "
                        + getSavedRecipesCount());
    }

        /*
     * Membership Section
     */
    private WebElement membershipSection() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Switch[contains(@content-desc,'Membership')]"));
    }

    /*
     * Verify Membership Section
     */
    public boolean isMembershipSectionDisplayed() {

        try {

            return membershipSection()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Membership Details
     */
    public String getMembershipDetails() {

        String membershipDetails =
                membershipSection()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Membership Details :");

        System.out.println(
                membershipDetails);

        return membershipDetails;
    }

    /*
     * Scroll To Membership Section
     */
    public void scrollToMembershipSection() {

        int maxScrolls =
                10;

        for (int i = 0; i < maxScrolls; i++) {

            try {

                if (membershipSection()
                        .isDisplayed()) {

                    System.out.println(
                            "Membership section displayed.");

                    return;
                }

            }

            catch (Exception e) {

            }

            scrollDown();

            waitUtil.sleep(
                    800);
        }

        System.out.println(
                "Membership section not found.");
    }

    /*
     * Profile ID
     */
    private WebElement profileId() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[starts-with(@content-desc,'SV')]"));
    }

    /*
     * Verify Profile ID
     */
    public boolean isProfileIdDisplayed() {

        try {

            return profileId()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Profile ID
     */
    public String getProfileId() {

        String profileId =
                profileId()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Profile ID : "
                        + profileId);

        return profileId;
    }

    /*
     * Scroll To Profile ID
     */
    public void scrollToProfileId() {

        int maxScrolls =
                10;

        for (int i = 0; i < maxScrolls; i++) {

            try {

                if (profileId()
                        .isDisplayed()) {

                    System.out.println(
                            "Profile ID displayed.");

                    return;
                }

            }

            catch (Exception e) {

            }

            scrollDown();

            waitUtil.sleep(
                    800);
        }

        System.out.println(
                "Profile ID not found.");
    }

/*
 * Groups Section (Horizontal Scroll)
 */
private WebElement groupsSectionHorizontal() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.widget.HorizontalScrollView"));
}

/*
 * Groups Section (No Horizontal Scroll)
 */
private WebElement groupsSectionNormal() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[contains(@content-desc, ',')]"));
}

/*
 * Group Names
 */
private WebElement groupNames() {

    try {

        groupsSectionHorizontal()
                .isDisplayed();

        System.out.println(
                "Using Horizontal Groups Layout.");

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.HorizontalScrollView/android.view.View"));
    }

    catch (Exception e) {

        System.out.println(
                "Using Normal Groups Layout.");

        return groupsSectionNormal();
    }
}

/*
 * Verify Groups Section
 */
public boolean isGroupsSectionDisplayed() {

    /*
     * Try Horizontal Layout
     */
    try {

        groupsSectionHorizontal()
                .isDisplayed();

        System.out.println(
                "Using Horizontal Groups Layout.");

        return true;
    }

    /*
     * Fallback To Normal Layout
     */
    catch (Exception e) {

        try {

            groupsSectionNormal()
                    .isDisplayed();

            System.out.println(
                    "Using Normal Groups Layout.");

            return true;
        }

        catch (Exception ex) {

            return false;
        }
    }
}

/*
 * Get All Group Names
 */
public String getAllGroupNames() {

    String groups =
            "";

    try {

        groups =
                groupNames()
                        .getAttribute(
                                "content-desc");

        if (groups == null) {

            groups =
                    "";
        }

        groups =
                groups.trim();

        System.out.println(
                "Groups :");

        System.out.println(
                groups);

    }

    catch (Exception e) {

        System.out.println(
                "Unable to retrieve groups.");

        groups =
                "";
    }

    return groups;
}

/*
 * Scroll Groups Right
 */
public void scrollGroupsRight() {

    try {

        /*
         * Verify Horizontal Layout
         */
        groupsSectionHorizontal();

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().className(\"android.widget.HorizontalScrollView\")).scrollForward()"));

        System.out.println(
                "Groups scrolled right.");
    }

    catch (Exception e) {

        System.out.println(
                "Normal Groups Layout. No horizontal scrolling required.");
    }

    waitUtil.sleep(
            1000);
}

/*
 * Scroll Groups Left
 */
public void scrollGroupsLeft() {

    try {

        /*
         * Verify Horizontal Layout
         */
        groupsSectionHorizontal();

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().className(\"android.widget.HorizontalScrollView\")).scrollBackward()"));

        System.out.println(
                "Groups scrolled left.");
    }

    catch (Exception e) {

        System.out.println(
                "Normal Groups Layout. No horizontal scrolling required.");
    }

    waitUtil.sleep(
            1000);
}

/*
 * Get Group Count
 */
public int getGroupCount() {

    String groups =
            getAllGroupNames();

    if (groups == null
            || groups.isBlank()) {

        return 0;
    }

    String[] groupList =
            groups.split(",");

    System.out.println(
            "Total Groups : "
                    + groupList.length);

    return groupList.length;
}

/*
 * Verify Group Present
 */
public boolean isGroupPresent(
        String groupName) {

    try {

        return getAllGroupNames()
                .contains(
                        groupName);

    }

    catch (Exception e) {

        return false;
    }
}

/*
 * Scroll To Group
 */
public boolean scrollToGroup(
        String groupName) {

    int maxScrolls =
            10;

    for (int i = 0; i < maxScrolls; i++) {

        if (isGroupPresent(
                groupName)) {

            System.out.println(
                    "Group Found : "
                            + groupName);

            return true;
        }

        scrollGroupsRight();
    }

    System.out.println(
            "Group Not Found : "
                    + groupName);

    return false;
}

/*
 * Print Groups
 */
public void printGroups() {

    System.out.println(
            getAllGroupNames());

    System.out.println(
            "Total Groups : "
                    + getGroupCount());
}

        /*
     * Followers Count
     */
    private WebElement followersCount() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'Followers:')]"));
    }



    /*
     * Verify Followers Count
     */
    public boolean isFollowersCountDisplayed() {

        try {

            return followersCount()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Followers Count
     */
    public String getFollowersCount() {

        String followers =
                followersCount()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Followers : "
                        + followers);

        return followers;
    }

    /*
     * Scroll To Followers Count
     */
    public void scrollToFollowersCount() {

        int maxScrolls =
                12;

        for (int i = 0; i < maxScrolls; i++) {

            try {

                if (followersCount()
                        .isDisplayed()) {

                    System.out.println(
                            "Followers section displayed.");

                    return;
                }

            }

            catch (Exception e) {

            }

            scrollDown();

            waitUtil.sleep(
                    800);
        }

        System.out.println(
                "Followers section not found.");
    }

/*------------------------------------------------------------------------------- */
/*
 * Personal Links Section
 */
private WebElement personalLinksSection() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Personal Links\nAdd links to your public profiles and content']"));
}

/*
 * Add Link Button
 */
private WebElement addLinkButton() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Personal Links\nAdd links to your public profiles and content']/android.widget.Button"));
}

/*
 * Link Type
 */
private WebElement linkType(
        String selectedLink) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='"
                            + selectedLink
                            + "']"));
}

/*
 * Personal Link Row
 */
private WebElement personalLinkRow() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.widget.Button[@content-desc='Personal Links\nAdd links to your public profiles and content']/android.view.View/android.view.View"));
}

/*
 * Personal Link Edit Field
 */
private WebElement personalLinkEditField() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.widget.Button[@content-desc='Personal Links\nAdd links to your public profiles and content']/android.view.View/android.view.View"));
}


/*
 * Save Personal Link Button
 */
private WebElement savePersonalLinkButton() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.widget.Button[@content-desc='Personal Links\nAdd links to your public profiles and content']/android.widget.Button[2]"));
}

/*
 * Verify Personal Links Section
 */
public boolean isPersonalLinksSectionDisplayed() {

    try {

        boolean displayed =
                personalLinksSection()
                        .isDisplayed();

        System.out.println(
                "Personal Links Section : "
                        + displayed);

        return displayed;

    }

    catch (Exception e) {

        return false;
    }
}


/*
 * Click Add Link Button
 */
public void clickAddLinkButton() {

    waitUtil.clickWithWait(
            addLinkButton());

    waitUtil.sleep(
            1000);

    System.out.println(
            "Add Link button clicked.");
}

/*
 * Select Link Type
 */
public void selectLinkType(
        String selectedLink) {

    waitUtil.clickWithWait(
            linkType(
                    selectedLink));

    waitUtil.sleep(
            1000);

    System.out.println(
            "Selected Link Type : "
                    + selectedLink);
}

/*
 * Click Personal Link Row
 */
public void clickPersonalLinkRow() {

    waitUtil.clickWithWait(
            personalLinkRow());

    waitUtil.sleep(
            1000);

    System.out.println(
            "Personal Link Row clicked.");
}

/*
 * Click Save Personal Link
 */
public void clickSavePersonalLink() {

    waitUtil.clickWithWait(
            savePersonalLinkButton());

    waitUtil.sleep(
            2000);

    System.out.println(
            "Personal Link Saved.");
}



/*-------------------------------------------------------------------------------- */

/*
 * Add Personal Link
 */
public void addPersonalLink(
        String selectedLink,
        String personalLink) {

    /*
     * Scroll To Personal Links Section
     */
    scrollToPersonalLinksSection();

    /*
     * Click Add Link
     */
    clickAddLinkButton();

    /*
     * Select Link Type
     */
    selectLinkType(
            selectedLink);

    /*
     * Enter Personal Link
     */
    enterPersonalLink(
            personalLink);

    /*
     * Save Personal Link
     */
    clickSavePersonalLink();

    System.out.println(
            "Personal Link Added.");
}


/*
 * Enter Personal Link
 */
public void enterPersonalLink(
        String personalLink) {

    /*
     * Open Personal Link Field
     */
    clickPersonalLinkRow();

    waitUtil.sleep(
            1000);

    /*
     * Enter Personal Link
     */
    driver.switchTo()
            .activeElement()
            .sendKeys(
                    personalLink);

    waitUtil.sleep(
            1000);

    System.out.println(
            "Personal Link Entered : "
                    + personalLink);

    try {

        driver.hideKeyboard();

    }

    catch (Exception e) {

    }
}

/*
 * Scroll To Personal Links Section
 */
public void scrollToPersonalLinksSection() {

    int maxScrolls =
            12;

    for (int i = 0; i < maxScrolls; i++) {

        try {

            if (personalLinksSection()
                    .isDisplayed()) {

                System.out.println(
                        "Personal Links section displayed.");

                return;
            }

        }

        catch (Exception e) {

        }

        scrollDown();

        waitUtil.sleep(
                800);
    }

    System.out.println(
            "Personal Links section not found.");
}



/*
 * Scroll Down
 */
public void scrollDown() {

    try {

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

        System.out.println(
                "Scrolled down.");

    }

    catch (Exception e) {

        System.out.println(
                "Reached bottom of page.");
    }

    waitUtil.sleep(
            1000);
}

/*
 * Scroll Up
 */
public void scrollUp() {

    try {

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));

        System.out.println(
                "Scrolled up.");

    }

    catch (Exception e) {

        System.out.println(
                "Reached top of page.");
    }

    waitUtil.sleep(
            1000);
}

/*
 * Scroll To Top
 */
public void scrollToTop() {

    for (int i = 0; i < 10; i++) {

        scrollUp();
    }

    System.out.println(
            "Scrolled to top.");
}

/*
 * Scroll To Bottom
 */
public void scrollToBottom() {

    for (int i = 0; i < 20; i++) {

        scrollDown();
    }

    System.out.println(
            "Scrolled to bottom.");
}

/*
 * Tap Delete Button
 */
public void tapDeleteButton() {

    PointerInput finger =
            new PointerInput(
                    PointerInput.Kind.TOUCH,
                    "finger");

    Sequence tap =
            new Sequence(
                    finger,
                    1);

    tap.addAction(
            finger.createPointerMove(
                    Duration.ZERO,
                    PointerInput.Origin.viewport(),
                    962,
                    1268));

    tap.addAction(
            finger.createPointerDown(
                    PointerInput.MouseButton.LEFT.asArg()));

    tap.addAction(
            finger.createPointerUp(
                    PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(
            Collections.singletonList(
                    tap));

    waitUtil.sleep(
            1000);

    System.out.println(
            "Delete button clicked.");
}

/*
 * Remove Personal Link
 */
public void removePersonalLink() {

    /*
     * Click Existing Personal Link
     */
    clickPersonalLinkRow();

    /*
     * Tap Delete Button
     */
    tapDeleteButton();

    waitUtil.sleep(
            2000);

    System.out.println(
            "Personal Link Removed.");
}

}