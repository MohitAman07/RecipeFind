package pagesObjects.HamburgerMenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Scroll;
import utils.WaitUtil;

public class ControlPanel {

    private AndroidDriver driver;
    private Scroll scroll;
    private WaitUtil waitUtil;

    public ControlPanel(AndroidDriver driver) {

        this.driver = driver;
        this.scroll = new Scroll(driver);
        this.waitUtil = new WaitUtil(driver);

        PageFactory.initElements(
                new AppiumFieldDecorator(driver),
                this);
    }

    @AndroidFindBy(accessibility = "Control Panel")
    private WebElement control_panel;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    private WebElement Dots;

    @AndroidFindBy(accessibility = "Change Status")
    private WebElement VerifyChangestatus;

    @AndroidFindBy(accessibility = "All")
    private WebElement All_Tab;

    @AndroidFindBy(accessibility = "Submitted")
    private WebElement Submitted;

    @AndroidFindBy(accessibility = "Verified")
    private WebElement Verified;

    @AndroidFindBy(accessibility = "Rejected")
    private WebElement Rejected;

    @AndroidFindBy(accessibility = "DeletePending")
    private WebElement DeletePending;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private WebElement Verify_Submitted_recipes;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private WebElement Verify_Verified_Recipes;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private WebElement Verify_Rejected_Recipes;

    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private WebElement Group_Icon;

    @AndroidFindBy(accessibility = "Mohit-Testing-01-july")
    private WebElement Group_01;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    private WebElement Enter_Group_name;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='2']")
    private WebElement Group_Search_Button;

    @AndroidFindBy(accessibility = "Delete")
    private WebElement Remove_Group;

    /*
     * Control Panel
     */
    public void openControlPanel() {

        Assert.assertTrue(
                control_panel.isDisplayed(),
                "Control Panel is not displayed.");

        waitUtil.clickWithWait(control_panel);
    }

    /*
     * Three Dots
     */
    public void clickDots() {

        Assert.assertTrue(
                Dots.isDisplayed(),
                "Dots button is not displayed.");

        waitUtil.clickWithWait(Dots);
    }

    /*
     * Change Status
     */
    public void clickChangeStatus() {

        Assert.assertTrue(
                VerifyChangestatus.isDisplayed(),
                "Change Status option is not displayed.");

    }

    
 /*
     * Tabs
     */
    public void clickAllTab() {

        Assert.assertTrue(
                All_Tab.isDisplayed(),
                "All tab is not displayed.");

        waitUtil.clickWithWait(All_Tab);
    }

    public void clickSubmittedTab() {

        Assert.assertTrue(
                Submitted.isDisplayed(),
                "Submitted tab is not displayed.");

        waitUtil.clickWithWait(Submitted);
    }

    public void clickVerifiedTab() {

        Assert.assertTrue(
                Verified.isDisplayed(),
                "Verified tab is not displayed.");

        waitUtil.clickWithWait(Verified);
    }

    public void clickRejectedTab() {

        Assert.assertTrue(
                Rejected.isDisplayed(),
                "Rejected tab is not displayed.");

        waitUtil.clickWithWait(Rejected);
    }

    public void clickDeletePendingTab() {

        Assert.assertTrue(
                DeletePending.isDisplayed(),
                "Delete Pending tab is not displayed.");

        waitUtil.clickWithWait(DeletePending);
    }

    /*
     * Recipe Verification
     */
    public void openSubmittedRecipe() {

        Assert.assertTrue(
                Verify_Submitted_recipes.isDisplayed(),
                "Submitted recipe is not displayed.");

        waitUtil.clickWithWait(Verify_Submitted_recipes);
    }

    public void openVerifiedRecipe() {

        Assert.assertTrue(
                Verify_Verified_Recipes.isDisplayed(),
                "Verified recipe is not displayed.");

        waitUtil.clickWithWait(Verify_Verified_Recipes);
    }

    public void openRejectedRecipe() {

        Assert.assertTrue(
                Verify_Rejected_Recipes.isDisplayed(),
                "Rejected recipe is not displayed.");

        waitUtil.clickWithWait(Verify_Rejected_Recipes);
    }

    /*
     * Group
     */
    public void clickGroupIcon() {

        Assert.assertTrue(
                Group_Icon.isDisplayed(),
                "Group icon is not displayed.");

        waitUtil.clickWithWait(Group_Icon);
    }

    public void selectGroup() {

        Assert.assertTrue(
                Group_01.isDisplayed(),
                "Group is not displayed.");

        waitUtil.clickWithWait(Group_01);
    }

    /*
     * Group Name
     */
    public void clickGroupNameField() {

        Assert.assertTrue(
                Enter_Group_name.isDisplayed(),
                "Group Name field is not displayed.");

        waitUtil.clickWithWait(Enter_Group_name);
    }

    public void enterGroupName(String groupName) {

        Assert.assertTrue(
                Enter_Group_name.isDisplayed(),
                "Group Name field is not displayed.");

        waitUtil.clickWithWait(Enter_Group_name);
        Enter_Group_name.clear();
        Enter_Group_name.sendKeys(groupName);
    }

    /*
     * Search Group
     */
    public void clickGroupSearchButton() {

        Assert.assertTrue(
                Group_Search_Button.isDisplayed(),
                "Group Search button is not displayed.");

        waitUtil.clickWithWait(Group_Search_Button);
    }

    /*
     * Remove Group
     */
    public void clickRemoveGroup() {

        Assert.assertTrue(
                Remove_Group.isDisplayed(),
                "Remove Group button is not displayed.");

        waitUtil.clickWithWait(Remove_Group);
    }
}