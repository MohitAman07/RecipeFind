package pagesObjects.Contribute.MyRecipiesDashboard;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import utils.WaitUtil;

public class RecipeDetailsPage {

    private final AndroidDriver driver;

    private final WaitUtil waitUtil;

    public RecipeDetailsPage(
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
     * Dynamic Recipe Name
     */
    private WebElement recipeName(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='"
                                + recipeName
                                + "']"));
    }

    /*
     * Recipe Author
     */
    private WebElement authorName() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[starts-with(@content-desc,'by ')]"));
    }

    /*
     * Favourite Button
     */
    private WebElement favouriteButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.widget.Button[1]"));
    }

    /*
     * Edit Recipe Button
     */
    private WebElement editRecipeButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='Edit']"));
    }

    /*
     * Delete Recipe Button
     */
    private WebElement deleteRecipeButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.widget.Button[3]"));
    }

    /*
     * Like Button
     */
    private WebElement likeButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button"));
    }

    /*
     * Dynamic Like Button
     */
    private WebElement likeButton(
            String likeCount) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='"
                                + likeCount
                                + "']"));
    }

    /*
     * Comment Button
     */
    private WebElement commentButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ImageView"));
    }

    /*
     * Dynamic Comment Button
     */
    private WebElement commentButton(
            String commentCount) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ImageView[@content-desc='"
                                + commentCount
                                + "']"));
    }

    /*
     * Export PDF Button
     */
    private WebElement exportPdfButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='Export as PDF']"));
    }

    /*
     * Share Button
     */
    private WebElement shareButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.widget.Button[3]"));
    }

    /*
     * No Comments Message
     */
    private WebElement noCommentsMessage() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='No comments yet. Be the first to comment!']"));
    }

    /*
     * Comment Field
     */
    private WebElement commentField() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.EditText"));
    }

    /*
     * Post Comment Button
     */
    private WebElement postCommentButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.FrameLayout[@resource-id='android:id/content']"
                                + "/android.widget.FrameLayout"
                                + "/android.view.View"
                                + "/android.view.View"
                                + "/android.view.View"
                                + "/android.view.View"
                                + "/android.view.View[1]"
                                + "/android.view.View"
                                + "/android.widget.Button"));
    }

        /*
     * Dynamic Comment Card
     */
    private WebElement commentCard(
            String comment) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.view.View[contains(@content-desc,'"
                                + comment
                                + "')]"));
    }

    /*
     * Dynamic Edit Comment Button
     */
    private WebElement editCommentButton(
            String comment) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.view.View[contains(@content-desc,'"
                                + comment
                                + "')]/android.view.View[1]"));
    }

    /*
     * Dynamic Delete Comment Button
     */
    private WebElement deleteCommentButton(
            String comment) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.view.View[contains(@content-desc,'"
                                + comment
                                + "')]/android.view.View[2]"));
    }

    /*
     * Reply Button
     */
    private WebElement replyButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Reply']"));
    }

    /*
     * Dynamic Reply Input Field
     */
    private WebElement replyInputField(
            String comment) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.view.View[contains(@content-desc,'"
                                + comment
                                + "')]/android.widget.EditText"));
    }

    /*
     * Cancel Reply Button
     */
    private WebElement cancelReplyButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='Cancel']"));
    }

    /*
     * Submit Reply Button
     */
    private WebElement submitReplyButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='Reply']"));
    }

    /*
     * Cancel Edit Button
     */
    private WebElement cancelEditButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='Cancel']"));
    }

    /*
     * Save Comment Button
     */
    private WebElement saveCommentButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='Save']"));
    }

    /*
     * Comment Posted Popup
     */
    private WebElement commentPostedPopup() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Comment posted']"));
    }

    /*
     * Comment Updated Popup
     */
    private WebElement commentUpdatedPopup() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Comment updated']"));
    }

    /*
     * Blank Reply Popup
     */
    private WebElement blankReplyPopup() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc=\"Reply can't be blank\"]"));
    }

        /*
     * Verify Recipe Name
     */
    public boolean isRecipeDisplayed(
            String recipeName) {

        try {

            return recipeName(
                    recipeName)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Recipe Name
     */
    public String getRecipeName(
            String recipeName) {

        String name =
                recipeName(
                        recipeName)
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Recipe Name : "
                        + name);

        return name;
    }

    /*
     * Verify Author
     */
    public boolean isAuthorDisplayed() {

        try {

            return authorName()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Author Name
     */
    public String getAuthorName() {

        String author =
                authorName()
                        .getAttribute(
                                "content-desc");

        if (author.startsWith("by ")) {

            author =
                    author.substring(
                            3);
        }

        System.out.println(
                "Author : "
                        + author);

        return author;
    }

    /*
     * Verify Favourite Button
     */
    public boolean isFavouriteButtonDisplayed() {

        try {

            return favouriteButton()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Favourite Button
     */
    public void clickFavouriteButton() {

        waitUtil.clickWithWait(
                favouriteButton());

        System.out.println(
                "Favourite button clicked.");
    }

    /*
     * Verify Edit Recipe Button
     */
    public boolean isEditRecipeDisplayed() {

        try {

            return editRecipeButton()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Edit Recipe
     */
    public void clickEditRecipe() {

        waitUtil.clickWithWait(
                editRecipeButton());

        System.out.println(
                "Edit recipe clicked.");
    }

    /*
     * Verify Delete Recipe Button
     */
    public boolean isDeleteRecipeDisplayed() {

        try {

            return deleteRecipeButton()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Delete Recipe
     */
    public void clickDeleteRecipe() {

        waitUtil.clickWithWait(
                deleteRecipeButton());

        System.out.println(
                "Delete recipe clicked.");
    }

    /*
     * Verify Like Button
     */
    public boolean isLikeButtonDisplayed() {

        try {

            String likeCount =
                    getLikeCount();

            return likeButton(
                    likeCount)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Like Count
     */
    public String getLikeCount() {

        WebElement like =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.widget.Button[@content-desc]"));

        String count =
                like.getAttribute(
                        "content-desc");

        System.out.println(
                "Like Count : "
                        + count);

        return count;
    }

    /*
     * Verify Comment Button
     */
    public boolean isCommentButtonDisplayed() {

        try {

            String commentCount =
                    getCommentCount();

            return commentButton(
                    commentCount)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Comment Count
     */
    public String getCommentCount() {

        WebElement comment =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.widget.ImageView[@content-desc]"));

        String count =
                comment.getAttribute(
                        "content-desc");

        System.out.println(
                "Comment Count : "
                        + count);

        return count;
    }

    /*
     * Click Comment Button
     */
    public void clickCommentButton() {

        String commentCount =
                getCommentCount();

        waitUtil.clickWithWait(
                commentButton(
                        commentCount));

        System.out.println(
                "Comment button clicked.");
    }

    /*
     * Verify Export PDF Button
     */
    public boolean isExportPdfButtonDisplayed() {

        scrollToBottom();

        try {

            return exportPdfButton()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Export PDF
     */
    public void clickExportPdf() {

        scrollToBottom();

        waitUtil.clickWithWait(
                exportPdfButton());

        System.out.println(
                "Export PDF button clicked.");
    }

    /*
     * Verify Share Button
     */
    public boolean isShareButtonDisplayed() {

        scrollToBottom();

        try {

            return shareButton()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Share Button
     */
    public void clickShareButton() {

        scrollToBottom();

        waitUtil.clickWithWait(
                shareButton());

        System.out.println(
                "Share button clicked.");
    }

    /*
     * Verify No Comments Message
     */
    public boolean isNoCommentsMessageDisplayed() {

        try {

            return noCommentsMessage()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Get No Comments Message
     */
    public String getNoCommentsMessage() {

        String message =
                noCommentsMessage()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "No Comment Message : "
                        + message);

        return message;
    }

    /*
     * Verify Comment Field
     */
    public boolean isCommentFieldDisplayed() {

        try {

            return commentField()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Comment Field
     */
    public void clickCommentField() {

        waitUtil.clickWithWait(
                commentField());

        System.out.println(
                "Comment field clicked.");
    }

    /*
     * Enter Comment
     */
    public void enterComment(
            String comment) {

        waitUtil.clickWithWait(
                commentField());

        commentField()
                .clear();

        commentField()
                .sendKeys(
                        comment);

        System.out.println(
                "Comment entered : "
                        + comment);
    }

    /*
     * Clear Comment
     */
    public void clearComment() {

        waitUtil.clickWithWait(
                commentField());

        commentField()
                .clear();

        System.out.println(
                "Comment field cleared.");
    }

    /*
     * Verify Post Comment Button
     */
    public boolean isPostCommentButtonDisplayed() {

        try {

            return postCommentButton()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

        /*
     * Click Post Comment
     */
    public void clickPostComment() {

        waitUtil.clickWithWait(
                postCommentButton());

        System.out.println(
                "Post Comment button clicked.");
    }

    /*
     * Complete Post Comment Flow
     */
    public void postComment(
            String comment) {

        enterComment(
                comment);

        hideKeyboard();

        clickPostComment();

        waitUtil.sleep(
                2000);
    }

    /*
     * Verify Comment Posted Popup
     */
    public boolean isCommentPostedPopupDisplayed() {

        try {

            WebDriverWait wait =
                    new WebDriverWait(
                            driver,
                            Duration.ofSeconds(
                                    5));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath(
                                    "//android.view.View[@content-desc='Comment posted']")));

            System.out.println(
                    "Comment Posted popup displayed.");

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Comment Posted popup not displayed.");

            return false;
        }
    }

    /*
     * Find Comment
     */
    private WebElement findComment(
            String comment) {

        return commentCard(
                comment);
    }

    /*
     * Verify Comment Displayed
     */
    public boolean isCommentDisplayed(
            String comment) {

        try {

            return findComment(
                    comment)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Comment
     */
    public void clickComment(
            String comment) {

        waitUtil.clickWithWait(
                findComment(
                        comment));

        System.out.println(
                "Comment clicked : "
                        + comment);
    }

    /*
     * Get Comment
     */
    public String getComment(
            String comment) {

        String text =
                findComment(
                        comment)
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Comment :");

        System.out.println(
                text);

        return text;
    }

    /*
     * Verify Edit Comment Button
     */
    public boolean isEditCommentDisplayed(
            String comment) {

        try {

            return editCommentButton(
                    comment)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Edit Comment
     */
    public void clickEditComment(
            String comment) {

        waitUtil.clickWithWait(
                editCommentButton(
                        comment));

        System.out.println(
                "Edit Comment clicked.");
    }

    /*
     * Click Delete Comment
     */
    public void clickDeleteComment(
            String comment) {

        waitUtil.clickWithWait(
                deleteCommentButton(
                        comment));

        System.out.println(
                "Delete Comment clicked.");
    }

        /*
     * Enter Updated Comment
     */
    public void enterUpdatedComment(
            String updatedComment) {

        waitUtil.clickWithWait(
                commentField());

        commentField()
                .clear();

        commentField()
                .sendKeys(
                        updatedComment);

        System.out.println(
                "Updated Comment : "
                        + updatedComment);
    }

    /*
     * Save Edited Comment
     */
    public void clickSaveComment() {

        waitUtil.clickWithWait(
                saveCommentButton());

        System.out.println(
                "Save Comment clicked.");
    }

    /*
     * Cancel Edit
     */
    public void clickCancelEdit() {

        waitUtil.clickWithWait(
                cancelEditButton());

        System.out.println(
                "Cancel Edit clicked.");
    }

    /*
     * Complete Edit Comment Flow
     */
    public void editComment(
            String existingComment,
            String updatedComment) {

        clickEditComment(
                existingComment);

        waitUtil.sleep(
                1000);

        enterUpdatedComment(
                updatedComment);

        clickSaveComment();

        waitUtil.sleep(
                2000);
    }

    /*
     * Verify Comment Updated Popup
     */
    public boolean isCommentUpdatedPopupDisplayed() {

        try {

            return commentUpdatedPopup()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Comment Updated Popup
     */
    public String getCommentUpdatedPopup() {

        String popup =
                commentUpdatedPopup()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Popup : "
                        + popup);

        return popup;
    }

    /*
     * Verify Save Button
     */
    public boolean isSaveButtonDisplayed() {

        try {

            return saveCommentButton()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Verify Cancel Edit Button
     */
    public boolean isCancelEditButtonDisplayed() {

        try {

            return cancelEditButton()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

        /*
     * Verify Reply Button
     */
    public boolean isReplyButtonDisplayed() {

        try {

            return replyButton()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Reply Button
     */
    public void clickReplyButton() {

        if (isReplyButtonDisplayed()) {

            waitUtil.clickWithWait(
                    replyButton());

            System.out.println(
                    "Reply button clicked.");
        }

        else {

            System.out.println(
                    "Reply button is not available.");
        }
    }

    /*
     * Verify Reply Field
     */
    public boolean isReplyFieldDisplayed(
            String comment) {

        try {

            return replyInputField(
                    comment)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Enter Reply
     */
    public void enterReply(
            String comment,
            String reply) {

        waitUtil.clickWithWait(
                replyInputField(
                        comment));

        replyInputField(
                comment)
                .clear();

        replyInputField(
                comment)
                .sendKeys(
                        reply);

        System.out.println(
                "Reply entered : "
                        + reply);
    }

    /*
     * Cancel Reply
     */
    public void clickCancelReply() {

        waitUtil.clickWithWait(
                cancelReplyButton());

        System.out.println(
                "Cancel Reply clicked.");
    }

    /*
     * Submit Reply
     */
    public void clickSubmitReply() {

        waitUtil.clickWithWait(
                submitReplyButton());

        System.out.println(
                "Reply submitted.");
    }

    /*
     * Complete Reply Flow
     */
    public void replyToComment(
            String comment,
            String reply) {

        if (!isReplyButtonDisplayed()) {

            System.out.println(
                    "Reply option not available.");

            return;
        }

        clickReplyButton();

        waitUtil.sleep(
                1000);

        enterReply(
                comment,
                reply);

        clickSubmitReply();

        waitUtil.sleep(
                2000);
    }

    /*
     * Verify Blank Reply Popup
     */
    public boolean isBlankReplyPopupDisplayed() {

        try {

            return blankReplyPopup()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Blank Reply Popup
     */
    public String getBlankReplyPopup() {

        String popup =
                blankReplyPopup()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Popup : "
                        + popup);

        return popup;
    }

    /*
     * Verify Cancel Reply Button
     */
    public boolean isCancelReplyButtonDisplayed() {

        try {

            return cancelReplyButton()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Verify Submit Reply Button
     */
    public boolean isSubmitReplyButtonDisplayed() {

        try {

            return submitReplyButton()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Submit Blank Reply
     */
    public void submitBlankReply(
            String comment) {

        if (!isReplyButtonDisplayed()) {

            System.out.println(
                    "Reply option not available.");

            return;
        }

        clickReplyButton();

        waitUtil.sleep(
                1000);

        replyInputField(
                comment)
                .clear();

        clickSubmitReply();

        waitUtil.sleep(
                1000);
    }

        /*
     * Scroll Comments
     */
    public void scrollComments() {

        Dimension size =
                driver.manage()
                        .window()
                        .getSize();

        int startX =
                size.width / 2;

        int startY =
                (int) (size.height * 0.75);

        int endY =
                (int) (size.height * 0.30);

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
                        Duration.ofMillis(
                                700),
                        PointerInput.Origin.viewport(),
                        startX,
                        endY));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(
                Arrays.asList(
                        swipe));

        System.out.println(
                "Comments scrolled.");
    }

    /*
     * Last Visible Comment
     */
    private String getLastVisibleComment() {

        List<WebElement> comments =
                driver.findElements(
                        AppiumBy.xpath(
                                "//android.widget.ScrollView/android.view.View[@content-desc]"));

        if (comments.isEmpty()) {

            return "";
        }

        return comments.get(
                comments.size() - 1)
                .getAttribute(
                        "content-desc");
    }

    /*
     * Scroll Until Last Comment
     */
    public void scrollToLastComment() {

        String previousLastComment =
                "";

        while (true) {

            String currentLastComment =
                    getLastVisibleComment();

            if (currentLastComment.equals(
                    previousLastComment)) {

                System.out.println(
                        "Reached end of comments.");

                break;
            }

            previousLastComment =
                    currentLastComment;

            scrollComments();

            waitUtil.sleep(
                    1200);
        }
    }

    /*
 * Scroll To Bottom
 */
public void scrollToBottom() {

    String previousLastElement =
            "";

    int stableCount =
            0;

    while (stableCount < 2) {

        List<WebElement> visibleElements =
                driver.findElements(
                        AppiumBy.xpath(
                                "//android.widget.ScrollView//*[@content-desc]"));

        String currentLastElement =
                "";

        if (!visibleElements.isEmpty()) {

            currentLastElement =
                    visibleElements
                            .get(
                                    visibleElements.size() - 1)
                            .getAttribute(
                                    "content-desc");
        }

        if (currentLastElement.equals(
                previousLastElement)) {

            stableCount++;

        }

        else {

            stableCount = 0;
        }

        previousLastElement =
                currentLastElement;

        scrollDown();

        waitUtil.sleep(
                1500);
    }

    System.out.println(
            "Reached bottom of recipe details.");
}

    /*
     * Scroll Down
     */
    private void scrollDown() {

        Dimension size =
                driver.manage()
                        .window()
                        .getSize();

        int startX =
                size.width / 2;

        int startY =
                (int) (size.height * 0.75);

        int endY =
                (int) (size.height * 0.25);

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
                        Duration.ofMillis(
                                700),
                        PointerInput.Origin.viewport(),
                        startX,
                        endY));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(
                Arrays.asList(
                        swipe));

        System.out.println(
                "Recipe details scrolled.");
    }




    /*
     * Scroll To Top
     */
    public void scrollToTop() {

        Dimension size =
                driver.manage()
                        .window()
                        .getSize();

        int startX =
                size.width / 2;

        int startY =
                (int) (size.height * 0.30);

        int endY =
                (int) (size.height * 0.80);

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
                        Duration.ofMillis(
                                700),
                        PointerInput.Origin.viewport(),
                        startX,
                        endY));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(
                Arrays.asList(
                        swipe));

        System.out.println(
                "Scrolled to top.");
    }

    /*
     * Hide Keyboard
     */
    public void hideKeyboard() {

        try {

            driver.hideKeyboard();

            System.out.println(
                    "Keyboard hidden.");

        } catch (Exception e) {

            System.out.println(
                    "Keyboard already hidden.");
        }
    }

    /*
     * Delete Comment Popup
     */
    private WebElement deleteCommentPopup() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Delete Comment?']"));
    }

    /*
     * Cancel Delete Button
     */
    private WebElement cancelDeleteButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='Cancel']"));
    }

    /*
     * Verify Delete Popup
     */
    public boolean isDeleteCommentPopupDisplayed() {

        try {

            return deleteCommentPopup()
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Delete Comment Message
     */
    private WebElement deleteCommentMessage() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//*[@text='This comment will be permanently removed.' or @content-desc='This comment will be permanently removed.']"));
    }

    /*
     * Click Cancel Delete
     */
    public void clickCancelDelete() {

        waitUtil.clickWithWait(
                cancelDeleteButton());

        System.out.println(
                "Delete cancelled.");
    }

    /*
     * Get Delete Comment Message
     */
    public String getDeleteCommentMessage() {

        String message =
                deleteCommentMessage()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Delete Message : "
                        + message);

        return message;
    }

    /*
     * Confirm Delete Button
     */
    private WebElement confirmDeleteButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='Delete']"));
    }

    /*
     * Click Confirm Delete
     */
    public void clickConfirmDelete() {

        waitUtil.clickWithWait(
                confirmDeleteButton());

        System.out.println(
                "Comment deleted.");
    }
}