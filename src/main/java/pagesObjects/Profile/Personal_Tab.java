package pagesObjects.Profile;

import java.util.List;

import org.openqa.selenium.WebElement;
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
     * Groups Section
     */
    private WebElement groupsSection() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.HorizontalScrollView"));
    }

    /*
     * Group Names
     */
    private WebElement groupNames() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.HorizontalScrollView/android.view.View"));
    }

    /*
     * Verify Groups Section
     */
    public boolean isGroupsSectionDisplayed() {

        try {

            return groupsSection()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get All Group Names
     */
    public String getAllGroupNames() {

        String groups =
                groupNames()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Groups :");

        System.out.println(
                groups);

        return groups;
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
     * Scroll Groups Right
     */
    public void scrollGroupsRight() {

        try {

            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().className(\"android.widget.HorizontalScrollView\")).scrollForward()"));

            System.out.println(
                    "Groups scrolled right.");

        }

        catch (Exception e) {

            System.out.println(
                    "Reached end of groups.");
        }

        waitUtil.sleep(
                1000);
    }

    /*
     * Scroll Groups Left
     */
    public void scrollGroupsLeft() {

        try {

            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().className(\"android.widget.HorizontalScrollView\")).scrollBackward()"));

            System.out.println(
                    "Groups scrolled left.");

        }

        catch (Exception e) {

            System.out.println(
                    "Reached beginning of groups.");
        }

        waitUtil.sleep(
                1000);
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
                    "//android.view.View[@content-desc='Personal Links\nAdd links to your public profiles and content']"
                            + "/android.widget.Button[1]"));
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

    /*
     * Verify Personal Links Section
     */
    public boolean isPersonalLinksSectionDisplayed() {

        try {

            return personalLinksSection()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
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
     * Verify Add Link Button
     */
    public boolean isAddLinkButtonDisplayed() {

        try {

            return addLinkButton()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Add Link Button
     */
    public void clickAddLinkButton() {

        scrollToPersonalLinksSection();

        waitUtil.clickWithWait(
                addLinkButton());

        waitUtil.sleep(
                1000);

        System.out.println(
                "Add Link button clicked.");
    }

    /*
     * Get Personal Links Details
     */
    public String getPersonalLinksDetails() {

        String details =
                personalLinksSection()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Personal Links Details :");

        System.out.println(
                details);

        return details;
    }

        /*
     * Link Type
     */
    private WebElement linkType(
            String linkType) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='"
                                + linkType
                                + "']"));
    }

    /*
     * Verify Link Type
     */
    public boolean isLinkTypeDisplayed(
            String linkType) {

        try {

            return linkType(
                    linkType)
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Select Link Type
     */
    public void selectLinkType(
            String linkType) {

        waitUtil.clickWithWait(
                linkType(
                        linkType));

        waitUtil.sleep(
                1000);

        System.out.println(
                "Selected Link Type : "
                        + linkType);
    }

    /*
     * Select Facebook
     */
    public void selectFacebook() {

        selectLinkType(
                "Facebook");
    }

    /*
     * Select Instagram
     */
    public void selectInstagram() {

        selectLinkType(
                "Instagram");
    }

    /*
     * Select YouTube
     */
    public void selectYouTube() {

        selectLinkType(
                "YouTube");
    }

    /*
     * Select Website
     */
    public void selectWebsite() {

        selectLinkType(
                "Website");
    }

    /*
     * Select Book Link
     */
    public void selectBookLink() {

        selectLinkType(
                "Book Link");
    }

    /*
     * Verify Facebook
     */
    public boolean isFacebookDisplayed() {

        return isLinkTypeDisplayed(
                "Facebook");
    }

    /*
     * Verify Instagram
     */
    public boolean isInstagramDisplayed() {

        return isLinkTypeDisplayed(
                "Instagram");
    }

    /*
     * Verify YouTube
     */
    public boolean isYouTubeDisplayed() {

        return isLinkTypeDisplayed(
                "YouTube");
    }

    /*
     * Verify Website
     */
    public boolean isWebsiteDisplayed() {

        return isLinkTypeDisplayed(
                "Website");
    }

    /*
     * Verify Book Link
     */
    public boolean isBookLinkDisplayed() {

        return isLinkTypeDisplayed(
                "Book Link");
    }

    /*
     * Get Selected Link Type
     */
    public String getSelectedLinkType(
            String linkType) {

        String selectedLinkType =
                linkType(
                        linkType)
                                .getAttribute(
                                        "content-desc");

        System.out.println(
                "Selected Link Type : "
                        + selectedLinkType);

        return selectedLinkType;
    }

        /*
     * Personal Link View Field
     */
private WebElement personalLinkViewField(
        int rowNumber) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Personal Links\nAdd links to your public profiles and content']"
                            + "/android.view.View"
                            + "/android.view.View["
                            + rowNumber
                            + "]"
                            + "/android.view.View[2]"
                            + "/android.widget.EditText"));
}

    /*
     * Active Personal Link Edit Field
     */
    private WebElement personalLinkEditField() {

        List<WebElement> editFields =
                driver.findElements(
                        AppiumBy.className(
                                "android.widget.EditText"));

        return editFields.get(
                editFields.size() - 1);
    }

    /*
     * Save Personal Link Button
     */
    private WebElement savePersonalLinkButton(
            int rowNumber) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Personal Links\nAdd links to your public profiles and content']"
                                + "/android.widget.Button["
                                + rowNumber
                                + "]"));
    }

    /*
     * Delete Personal Link Button
     */
    private WebElement deletePersonalLinkButton(
            int rowNumber) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Personal Links\nAdd links to your public profiles and content']"
                                + "/android.widget.Button["
                                + (rowNumber + 1)
                                + "]"));
    }

    /*
     * Verify Personal Link Field
     */
    public boolean isPersonalLinkFieldDisplayed(
            int rowNumber) {

        try {

            return personalLinkViewField(
                    rowNumber)
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Scroll Until Personal Link Field Visible
     */
    public void scrollUntilPersonalLinkFieldVisible(
            int rowNumber) {

        scrollToPersonalLinksSection();

        int maxScrolls =
                10;

        for (int i = 0; i < maxScrolls; i++) {

            try {

                if (personalLinkViewField(
                        rowNumber)
                        .isDisplayed()) {

                    System.out.println(
                            "Personal Link field displayed.");

                    return;
                }

            }

            catch (Exception e) {

            }

            scrollDown();

            waitUtil.sleep(
                    800);
        }

        throw new RuntimeException(
                "Unable to locate Personal Link field.");
    }

    /*
     * Scroll Until Save Button Visible
     */
    public void scrollUntilSaveButtonVisible(
            int rowNumber) {

        int maxScrolls =
                8;

        for (int i = 0; i < maxScrolls; i++) {

            try {

                if (savePersonalLinkButton(
                        rowNumber)
                        .isDisplayed()) {

                    System.out.println(
                            "Save button displayed.");

                    return;
                }

            }

            catch (Exception e) {

            }

            scrollDown();

            waitUtil.sleep(
                    800);
        }

        throw new RuntimeException(
                "Unable to locate Save button.");
    }

        /*
     * Clear Personal Link
     */
    public void clearPersonalLink(
            int rowNumber) {

        scrollUntilPersonalLinkFieldVisible(
                rowNumber);

        waitUtil.clickWithWait(
                personalLinkViewField(
                        rowNumber));

        waitUtil.sleep(
                1000);

        WebElement activeField =
                personalLinkEditField();

        waitUtil.clickWithWait(
                activeField);

        waitUtil.sleep(
                500);

        activeField.clear();

        waitUtil.sleep(
                500);

        System.out.println(
                "Personal Link cleared.");
    }

    /*
 * Enter Personal Link
 */
public void enterPersonalLink(
        int rowNumber,
        String personalLink) {

    scrollUntilPersonalLinkFieldVisible(
            rowNumber);

    WebElement field =
            personalLinkViewField(
                    rowNumber);

    /*
     * Click EditText
     */
   field.click();

waitUtil.sleep(1000);

    waitUtil.sleep(
            1000);

    field.clear();

    waitUtil.sleep(
            500);

    field.sendKeys(
            personalLink);

    waitUtil.sleep(
            1000);

    System.out.println(
            "Entered Value : "
                    + field.getAttribute(
                            "text"));

    try {

        driver.hideKeyboard();

    }

    catch (Exception e) {

    }

    System.out.println(
            "Personal Link Entered : "
                    + personalLink);
}

    /*
     * Get Personal Link
     */
    public String getPersonalLink(
            int rowNumber) {

        scrollUntilPersonalLinkFieldVisible(
                rowNumber);

        waitUtil.clickWithWait(
                personalLinkViewField(
                        rowNumber));

        waitUtil.sleep(
                1000);

        String personalLink =
                personalLinkEditField()
                        .getAttribute(
                                "text");

        System.out.println(
                "Personal Link : "
                        + personalLink);

        return personalLink;
    }

    /*
     * Save Personal Link
     */
    public void clickSavePersonalLink(
            int rowNumber) {

        scrollUntilSaveButtonVisible(
                rowNumber);

        try {

            driver.hideKeyboard();

        }

        catch (Exception e) {

        }

        waitUtil.sleep(
                1000);

        waitUtil.clickWithWait(
                savePersonalLinkButton(
                        rowNumber));

        waitUtil.sleep(
                2000);

        System.out.println(
                "Personal Link saved.");
    }

    /*
     * Delete Personal Link
     */
    public void clickDeletePersonalLink(
            int rowNumber) {

        scrollUntilPersonalLinkFieldVisible(
                rowNumber);

        waitUtil.clickWithWait(
                deletePersonalLinkButton(
                        rowNumber));

        waitUtil.sleep(
                2000);

        System.out.println(
                "Personal Link deleted.");
    }

        /*
     * Add Personal Link
     */
    public void addPersonalLink(
            int rowNumber,
            String linkType,
            String personalLink) {

        scrollToPersonalLinksSection();

        clickAddLinkButton();

        scrollDown();

        waitUtil.sleep(
                1000);

        selectLinkType(
                linkType);

        waitUtil.sleep(
                1000);

        enterPersonalLink(
                rowNumber,
                personalLink);

        clickSavePersonalLink(
                rowNumber);

        waitUtil.sleep(
                2000);

        System.out.println(
                "Personal Link Added.");
    }

    /*
     * Update Personal Link
     */
    public void updatePersonalLink(
            int rowNumber,
            String personalLink) {

        clearPersonalLink(
                rowNumber);

        waitUtil.sleep(
                1000);

        enterPersonalLink(
                rowNumber,
                personalLink);

        clickSavePersonalLink(
                rowNumber);

        waitUtil.sleep(
                2000);

        System.out.println(
                "Personal Link Updated.");
    }

    /*
     * Remove Personal Link
     */
    public void removePersonalLink(
            int rowNumber) {

        clickDeletePersonalLink(
                rowNumber);
    }

    /*
     * Delete Account Button
     */
    private WebElement deleteAccountButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='Delete Account']"));
    }

    /*
     * Verify Delete Account Button
     */
    public boolean isDeleteAccountButtonDisplayed() {

        try {

            return deleteAccountButton()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Scroll To Delete Account
     */
    public void scrollToDeleteAccount() {

        int maxScrolls =
                15;

        for (int i = 0; i < maxScrolls; i++) {

            try {

                if (deleteAccountButton()
                        .isDisplayed()) {

                    System.out.println(
                            "Delete Account button displayed.");

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
                "Delete Account button not found.");
    }

    /*
     * Click Delete Account
     */
    public void clickDeleteAccount() {

        waitUtil.clickWithWait(
                deleteAccountButton());

        System.out.println(
                "Delete Account button clicked.");
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

        for (int i = 0; i < 15; i++) {

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

}