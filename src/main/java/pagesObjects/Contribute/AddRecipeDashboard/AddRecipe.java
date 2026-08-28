package pagesObjects.Contribute.AddRecipeDashboard;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.ValidationUtil;
import utils.WaitUtil;

public class AddRecipe {

    private final AndroidDriver driver;
    private final WaitUtil waitUtil;

    // ======================== Constructor ======================== //

    public AddRecipe(
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

    // ======================== Locators ======================== //

    /*
     * Add Recipe Tab
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Add Recipe\n"
                    + "Tab 1 of 2\"]")
    private WebElement addRecipeButton;

    /*
     * Create New Recipe Header
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Create New Recipe\"]")
    private WebElement createNewRecipeHeader;

    /*
     * Recipe Name
     */
    @AndroidFindBy(
            xpath = "//android.widget.ScrollView/"
                    + "android.view.View[3]/"
                    + "android.widget.EditText")
    private WebElement recipeNameField;

    /*
 * Cooking Time
 */
@AndroidFindBy(
        xpath = "//android.widget.ScrollView/"
                + "android.view.View[5]/"
                + "android.widget.EditText[1]")
private WebElement cookingTimeField;

/*
 * Serving Time
 */
@AndroidFindBy(
        xpath = "//android.widget.ScrollView/"
                + "android.view.View[5]/"
                + "android.widget.EditText[2]")
private WebElement servingTimeField;

/*
 * Serving Limit
 */
@AndroidFindBy(
        xpath = "//android.widget.ScrollView/"
                + "android.view.View[5]/"
                + "android.widget.EditText[3]")
private WebElement servingLimitField;

    /*
     * Recipe Summary
     */
    @AndroidFindBy(
            xpath = "//android.widget.ScrollView/"
                    + "android.widget.EditText")
    private WebElement recipeSummaryField;

    /*
     * Recipe Summary Mic
     */
    @AndroidFindBy(
            xpath = "//android.widget.ScrollView/"
                    + "android.widget.EditText/"
                    + "android.widget.Button")
    private WebElement recipeSummaryMic;

    /*
     * Recipe Steps Header
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Recipe Steps\"]")
    private WebElement recipeStepsHeader;


    /*
     * Add Step
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Add Step\"]")
    private WebElement addStepButton;

    /*
     * Pro Tip
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Pro Tip\"]")
    private WebElement proTip;

    /*
        * Pro Tip Button
        */
        @AndroidFindBy(
                xpath = "//android.view.View[@content-desc=\"Pro Tip\"]"
                        + "/android.widget.Button")
        private WebElement proTipButton;

    /*
     * Pro Tip Input
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Pro Tip\"]/"
                    + "android.widget.EditText")
    private WebElement proTipField;

    /*
     * Pro Tip Delete
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Pro Tip\"]/"
                    + "android.widget.Button")
    private WebElement proTipDeleteButton;

    /*
     * Keywords
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Keywords\"]")
    private WebElement keywords;

    /*
     * Add Keyword Button
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Keywords\"]/"
                    + "android.widget.Button")
    private WebElement addKeywordButton;

    /*
     * Cuisine
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Cuisine\"]")
    private WebElement cuisineButton;

    /*
     * Dietary
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Dietary\"]")
    private WebElement dietaryButton;

    /*
     * Occasions
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Occasions\"]")
    private WebElement occasionsButton;

    /*
     * Difficulty
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Difficulty\"]")
    private WebElement difficultyButton;

    /*
     * Attributes
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Attributes\"]")
    private WebElement attributesButton;

    /*
     * Keyword Cancel
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Cancel\"]")
    private WebElement cancelButton;

    /*
     * Keyword Confirm
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Confirm\"]")
    private WebElement confirmButton;

    /*
     * Add Links Section
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Add Links\n"
                    + "Here you can add only 1 link per recipe\"]")
    private WebElement addLinksSection;

    /*
     * Add Link Button
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Add Links\n"
                    + "Here you can add only 1 link per recipe\"]/"
                    + "android.widget.Button")
    private WebElement addLinkButton;

    /*
     * Add Link Input
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Add Links\n"
                    + "Here you can add only 1 link per recipe\"]/"
                    + "android.widget.EditText")
    private WebElement addLinkField;

    /*
     * Add Link Delete
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Add Links\n"
                    + "Here you can add only 1 link per recipe\"]/"
                    + "android.widget.Button")
    private WebElement addLinkDeleteButton;

    /*
     * Sourced From
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Sourced From\"]")
    private WebElement sourcedFromSection;

    /*
     * Add Sourced From Button
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Sourced From\"]/"
                    + "android.widget.Button")
    private WebElement addSourcedFromButton;

    /*
     * Sourced From Input
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Sourced From\"]/"
                    + "android.widget.EditText")
    private WebElement sourcedFromField;

    /*
     * Sourced From Delete
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Sourced From\"]/"
                    + "android.widget.Button")
    private WebElement sourcedFromDeleteButton;

    /*
     * Proceed
     */
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Proceed\"]")
    private WebElement proceedButton;

    // ======================== Navigation ======================== //

    /*
     * Click Add Recipe
     */
    public void clickAddRecipe() {

        waitUtil.waitForElementVisible(
                addRecipeButton);

        waitUtil.clickWithWait(
                addRecipeButton);

        System.out.println(
                "Add Recipe clicked.");
    }

    /*
     * Verify Create New Recipe Header
     */
    public boolean isCreateNewRecipeDisplayed() {

        try {

            return createNewRecipeHeader
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    // ======================== Coordinate Scrolling ======================== //

/*
 * Scroll Add Recipe Form Down By Coordinates
 */
public void scrollAddRecipeFormDown() {

    Map<String, Object> swipe =
            new HashMap<>();

    swipe.put(
            "left",
            100);

    swipe.put(
            "top",
            350);

    swipe.put(
            "width",
            880);

    swipe.put(
            "height",
            1750);

    swipe.put(
            "direction",
            "up");

    swipe.put(
            "percent",
            0.70);

    swipe.put(
            "speed",
            600);

    driver.executeScript(
            "mobile: swipeGesture",
            swipe);

    try {

        Thread.sleep(
                1000);

    }

    catch (InterruptedException e) {

        Thread.currentThread()
                .interrupt();

        throw new RuntimeException(
                "Interrupted while scrolling Add Recipe form.",
                e);
    }

    System.out.println(
            "Add Recipe form scrolled down.");
}


/*
 * Scroll Add Recipe Form To Top By Coordinates
 */
private void scrollAddRecipeFormToTop() {

    Map<String, Object> swipe =
            new HashMap<>();

    swipe.put(
            "left",
            100);

    swipe.put(
            "top",
            500);

    swipe.put(
            "width",
            880);

    swipe.put(
            "height",
            1400);

    /*
     * Swipe DOWN to move the form
     * back towards the top.
     */
    swipe.put(
            "direction",
            "down");

    swipe.put(
            "percent",
            0.70);

    swipe.put(
            "speed",
            600);

    driver.executeScript(
            "mobile: swipeGesture",
            swipe);

    try {

        Thread.sleep(
                1000);

    }

    catch (InterruptedException e) {

        Thread.currentThread()
                .interrupt();

        throw new RuntimeException(
                "Interrupted while scrolling Add Recipe form to top.",
                e);
    }

    System.out.println(
            "Add Recipe form scrolled to top.");
}


/*
 * Scroll To Element
 */
private WebElement scrollToElement(
        String xpath,
        String elementName) {

    for (int attempt = 1;
            attempt <= 10;
            attempt++) {

        try {

            WebElement element =
                    driver.findElement(
                            AppiumBy.xpath(
                                    xpath));

            if (element.isDisplayed()) {

                System.out.println(
                        "Element visible : "
                                + elementName
                                + " | Attempt : "
                                + attempt);

                return element;
            }
        }

        catch (Exception e) {

            /*
             * Element is not currently visible.
             * Continue coordinate scrolling.
             */
        }

        scrollAddRecipeFormDown();

        System.out.println(
                "Scrolling to element : "
                        + elementName
                        + " | Attempt : "
                        + attempt);
    }

    throw new RuntimeException(
            "Unable to find element : "
                    + elementName);
}

/*
 * Scroll Up To Element
 */
private WebElement scrollUpToElement(
        String xpath,
        String elementName) {

    for (int attempt = 1;
            attempt <= 10;
            attempt++) {

        try {

            WebElement element =
                    driver.findElement(
                            AppiumBy.xpath(
                                    xpath));

            if (element.isDisplayed()) {

                System.out.println(
                        "Element visible : "
                                + elementName
                                + " | Attempt : "
                                + attempt);

                return element;
            }
        }

        catch (Exception e) {

            /*
             * Element is not currently visible.
             * Continue scrolling towards top.
             */
        }

        scrollAddRecipeFormToTop();

        System.out.println(
                "Scrolling up to element : "
                        + elementName
                        + " | Attempt : "
                        + attempt);
    }

    throw new RuntimeException(
            "Unable to find element : "
                    + elementName);
}


/*
 * Click Element After Scrolling Into View
 */
private void clickAfterScroll(
        String xpath,
        String elementName) {

    WebElement element =
            scrollToElement(
                    xpath,
                    elementName);

    waitUtil.clickWithWait(
            element);

    System.out.println(
            elementName
                    + " clicked.");
}

// ======================== Recipe Details ======================== //

/*
 * Enter Recipe Name
 */
public void enterRecipeName(
        String recipeName) {

    WebElement field =
            scrollToElement(
                    "//android.widget.ScrollView/"
                            + "android.view.View[3]/"
                            + "android.widget.EditText",
                    "Recipe Name");

    waitUtil.clickWithWait(
            field);

    field.clear();

    field.sendKeys(
            recipeName);

             hideKeyboard();

    System.out.println(
            "Recipe name entered : "
                    + recipeName);
}

/*
 * Enter Cooking Time
 */
public void enterCookingTime(
        String cookingTime) {

    waitUtil.waitForElementVisible(
            cookingTimeField);

    waitUtil.clickWithWait(
            cookingTimeField);

    cookingTimeField.clear();

    cookingTimeField.sendKeys(
            cookingTime);

    hideKeyboard();

    System.out.println(
            "Cooking time entered : "
                    + cookingTime);
}

/*
 * Enter Serving Time
 */
public void enterServingTime(
        String servingTime) {

    waitUtil.waitForElementVisible(
            servingTimeField);

    waitUtil.clickWithWait(
            servingTimeField);

    servingTimeField.clear();

    servingTimeField.sendKeys(
            servingTime);

         hideKeyboard();

    System.out.println(
            "Serving time entered : "
                    + servingTime);
}

/*
 * Enter Serving Limit
 */
public void enterServingLimit(
        String servingLimit) {

    waitUtil.waitForElementVisible(
            servingLimitField);

    waitUtil.clickWithWait(
            servingLimitField);

    servingLimitField.clear();

    servingLimitField.sendKeys(
            servingLimit);

         hideKeyboard();

    System.out.println(
            "Serving limit entered : "
                    + servingLimit);
}

/*
 * Enter Recipe Summary
 */
public void enterRecipeSummary(
        String summary) {

    WebElement field =
            scrollToElement(
                    "//android.widget.ScrollView/"
                            + "android.widget.EditText",
                    "Recipe Summary");

    waitUtil.clickWithWait(
            field);

    field.clear();

    field.sendKeys(
            summary);

            hideKeyboard();

    System.out.println(
            "Recipe summary entered.");
}

/*
 * Click Recipe Steps
 */
public void clickRecipeSteps() {

    clickAfterScroll(
            "//android.view.View[@content-desc=\"Recipe Steps\"]",
            "Recipe Steps");
}

/*
 * Get Recipe Steps Input Fields
 */
private List<WebElement> getRecipeStepInputs() {

    return driver.findElements(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc=\"Recipe Steps\"]"
                            + "/following::android.widget.EditText"));
}

/*
 * Get Latest Recipe Step Input
 */
private WebElement getLatestRecipeStepInput() {

    List<WebElement> stepInputs =
            driver.findElements(
                    AppiumBy.xpath(
                            "//android.view.View[@content-desc=\"Recipe Steps\"]"
                                    + "/following::android.widget.EditText"));

    if (stepInputs.isEmpty()) {

        throw new RuntimeException(
                "Recipe Step input field is not displayed.");
    }

    return stepInputs.get(
            stepInputs.size() - 1);
}


/*
 * Enter Recipe Step
 */
public void enterRecipeStep(
        String recipeStep) throws InterruptedException {

    WebElement stepInput =
            getLatestRecipeStepInput();

    waitUtil.waitForElementVisible(
            stepInput);

    waitUtil.clickWithWait(
            stepInput);

    stepInput.clear();

    stepInput.sendKeys(
            recipeStep);

    hideKeyboard();

    System.out.println(
            "Recipe step entered : "
                    + recipeStep);

    Thread.sleep(
            500);

    /*
     * Verify Recipe Step
     */
    verifyRecipeStep();
}


/*
 * Click Recipe Step Mic
 */
public void clickRecipeStepMic() {

    WebElement micButton =
            driver.findElement(
                    AppiumBy.xpath(
                            "(//android.view.View[@content-desc=\"Recipe Steps\"]"
                                    + "/following::android.widget.EditText)[last()]"
                                    + "/android.widget.Button[1]"));

    waitUtil.clickWithWait(
            micButton);

    System.out.println(
            "Recipe Step Mic clicked.");
}


/*
 * Delete Recipe Step
 */
public void deleteRecipeStep() {

    WebElement deleteButton =
            driver.findElement(
                    AppiumBy.xpath(
                            "(//android.view.View[@content-desc=\"Recipe Steps\"]"
                                    + "/following::android.widget.EditText)[last()]"
                                    + "/android.widget.Button[2]"));

    waitUtil.clickWithWait(
            deleteButton);

    System.out.println(
            "Recipe Step Delete clicked.");
}


/*
 * Verify Recipe Step
 */
public void verifyRecipeStep() {

    WebElement verifyButton =
            driver.findElement(
                    AppiumBy.xpath(
                            "(//android.view.View[@content-desc=\"Recipe Steps\"]"
                                    + "/following::android.widget.EditText)[last()]"
                                    + "/android.widget.Button[3]"));

    waitUtil.clickWithWait(
            verifyButton);

    System.out.println(
            "Recipe Step Verify clicked.");
}


/*
 * Add Recipe Step
 */
public void clickAddStep() {

    clickAfterScroll(
            "//android.widget.Button[@content-desc=\"Add Step\"]",
            "Add Step");
}

// ======================== Pro Tip ======================== //

/*
 * Scroll To Pro Tip
 */
public void scrollToProTip() {

    scrollToElement(
            "//android.view.View[@content-desc=\"Pro Tip\"]",
            "Pro Tip");
}


/*
 * Click Add Pro Tip
 */
public void clickAddProTip() {

    clickAfterScroll(
            "//android.view.View[@content-desc=\"Pro Tip\"]"
                    + "/android.widget.Button",
            "Add Pro Tip");

}


// /*
//  * Enter Pro Tip
//  */
// public void enterProTip(
//         String proTipText) {

//     WebElement field =
//             scrollToElement(
//                     "//android.view.View[@content-desc=\"Pro Tip\"]/"
//                             + "android.widget.EditText",
//                     "Pro Tip Input");

//     waitUtil.clickWithWait(
//             field);

//     field.clear();

//     field.sendKeys(
//             proTipText);

//     hideKeyboard();

//     System.out.println(
//             "Pro Tip entered : "
//                     + proTipText);
// }

/*
 * Enter Pro Tip
 */
public void enterProTip(
        String proTipText) {

    WebElement field =
            driver.findElement(
                    AppiumBy.xpath(
                            "//android.view.View[@content-desc=\"Pro Tip\"]/"
                                    + "android.widget.EditText"));

    waitUtil.waitForElementVisible(
            field);

    waitUtil.clickWithWait(
            field);

    field.clear();

    field.sendKeys(
            proTipText);

    hideKeyboard();

    System.out.println(
            "Pro Tip entered : "
                    + proTipText);
}


/*
 * Delete Pro Tip
 */
public void deleteProTip() {

    clickAfterScroll(
            "//android.view.View[@content-desc=\"Pro Tip\"]/"
                    + "android.widget.Button",
            "Pro Tip Delete");
}

// ======================== Keywords ======================== //


/*
 * Scroll Keyword Selection Window Down By Coordinates
 */
private void scrollKeywordWindowDown() {

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
                    634,
                    878));

    swipe.addAction(
            finger.createPointerDown(
                    PointerInput.MouseButton.LEFT.asArg()));

    swipe.addAction(
            new Pause(
                    finger,
                    Duration.ofMillis(300)));

    swipe.addAction(
            finger.createPointerMove(
                    Duration.ofMillis(800),
                    PointerInput.Origin.viewport(),
                    634,
                    450));

    swipe.addAction(
            finger.createPointerUp(
                    PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(
            Arrays.asList(
                    swipe));

    try {

        Thread.sleep(
                1000);

    }

    catch (InterruptedException e) {

        Thread.currentThread()
                .interrupt();

        throw new RuntimeException(
                "Interrupted while scrolling keyword selection.",
                e);
    }

    System.out.println(
            "Keyword selection options scrolled down by coordinates.");
}

/*
 * Click Keywords
 */
public void clickKeywords() {

    clickAfterScroll(
            "//android.view.View[@content-desc=\"Keywords\"]",
            "Keywords");
}


/*
 * Click Add New Keyword
 */
public void clickAddKeyword() {

    clickAfterScroll(
            "//android.view.View[@content-desc=\"Keywords\"]/"
                    + "android.widget.Button",
            "Add New Keyword");
}

/*
 * Select Keyword
 */
public void selectKeyword(
        String keywordName) {

    String keywordXpath =
            "//android.view.View[@content-desc=\""
                    + keywordName
                    + "\"]";

    for (int attempt = 1;
            attempt <= 15;
            attempt++) {

        try {

            WebElement keyword =
                    driver.findElement(
                            AppiumBy.xpath(
                                    keywordXpath));

            if (keyword.isDisplayed()) {

                waitUtil.clickWithWait(
                        keyword);

                System.out.println(
                        "Keyword selected : "
                                + keywordName);

                return;
            }

        }

        catch (Exception e) {

            /*
             * Keyword not currently visible.
             */
        }

        System.out.println(
                "Keyword not visible : "
                        + keywordName
                        + " | Swipe attempt : "
                        + attempt);

        scrollKeywordWindowDown();
    }

    throw new RuntimeException(
            "Unable to find keyword : "
                    + keywordName);
}

/*
 * Confirm Keyword Selection
 */
public void confirmKeywordSelection() {

    WebElement confirm =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10))
                    .until(
                            ExpectedConditions
                                    .visibilityOfElementLocated(
                                            AppiumBy.xpath(
                                                    "//android.widget.Button[@content-desc=\"Confirm\"]")));

    waitUtil.clickWithWait(
            confirm);

    System.out.println(
            "Keyword selection confirmed.");

        hideKeyboard();
}


/*
 * Cancel Keyword Selection
 */
public void cancelKeywordSelection() {

    WebElement cancel =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10))
                    .until(
                            ExpectedConditions
                                    .visibilityOfElementLocated(
                                            AppiumBy.xpath(
                                                    "//android.widget.Button[@content-desc=\"Cancel\"]")));

    waitUtil.clickWithWait(
            cancel);

    System.out.println(
            "Keyword selection cancelled.");
}

// ======================== Selection Popup Scrolling ======================== //

// /*
//  * Scroll Selection Popup Down By Coordinates
//  */
// private void scrollSelectionPopupDown() {

//     Map<String, Object> swipe =
//             new HashMap<>();

//     swipe.put(
//             "left",
//             100);

//     swipe.put(
//             "top",
//             450);

//     swipe.put(
//             "width",
//             880);

//     swipe.put(
//             "height",
//             1400);

//     swipe.put(
//             "direction",
//             "up");

//     swipe.put(
//             "percent",
//             0.60);

//     swipe.put(
//             "speed",
//             600);

//     driver.executeScript(
//             "mobile: swipeGesture",
//             swipe);

//     try {

//         Thread.sleep(
//                 800);

//     }

//     catch (InterruptedException e) {

//         Thread.currentThread()
//                 .interrupt();

//         throw new RuntimeException(
//                 "Interrupted while scrolling selection popup.",
//                 e);
//     }

//     System.out.println(
//             "Selection popup scrolled down.");
// }

// /*
//  * Find Selection Option With Scroll
//  */
// private WebElement findSelectionOptionWithScroll(
//         String optionName) {

//     String optionXpath =
//             "//android.widget.Button[@content-desc=\""
//                     + optionName
//                     + "\"]";

//     for (int attempt = 1;
//             attempt <= 10;
//             attempt++) {

//         try {

//             WebElement option =
//                     driver.findElement(
//                             AppiumBy.xpath(
//                                     optionXpath));

//             if (option.isDisplayed()) {

//                 System.out.println(
//                         "Option visible : "
//                                 + optionName
//                                 + " | Attempt : "
//                                 + attempt);

//                 return option;
//             }
//         }

//         catch (Exception e) {

//             /*
//              * Option is not currently visible.
//              * Continue coordinate scrolling.
//              */
//         }

//         scrollSelectionPopupDown();

//         System.out.println(
//                 "Searching option : "
//                         + optionName
//                         + " | Attempt : "
//                         + attempt);
//     }

//     throw new RuntimeException(
//             "Option could not be found : "
//                     + optionName);
// }

/*
 * Scroll Selection Popup Down By Coordinates
 */
private void scrollSelectionPopupDown() {

    PointerInput finger =
            new PointerInput(
                    PointerInput.Kind.TOUCH,
                    "finger");

    Sequence swipe =
            new Sequence(
                    finger,
                    1);

    /*
     * Start inside the right-side
     * selection options list.
     */
    swipe.addAction(
            finger.createPointerMove(
                    Duration.ZERO,
                    PointerInput.Origin.viewport(),
                    634,
                    878));

    swipe.addAction(
            finger.createPointerDown(
                    PointerInput.MouseButton.LEFT.asArg()));

    swipe.addAction(
            new Pause(
                    finger,
                    Duration.ofMillis(300)));

    /*
     * Swipe UP inside the options list.
     */
    swipe.addAction(
            finger.createPointerMove(
                    Duration.ofMillis(800),
                    PointerInput.Origin.viewport(),
                    634,
                    500));

    swipe.addAction(
            finger.createPointerUp(
                    PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(
            Arrays.asList(
                    swipe));

    try {

        Thread.sleep(
                800);

    }

    catch (InterruptedException e) {

        Thread.currentThread()
                .interrupt();

        throw new RuntimeException(
                "Interrupted while scrolling selection popup.",
                e);
    }

    System.out.println(
            "Selection popup scrolled down.");
}


/*
 * Find Selection Option With Scroll
 */
private WebElement findSelectionOptionWithScroll(
        String optionName) {

    String optionXpath =
            "//android.widget.Button[@content-desc=\""
                    + optionName
                    + "\"]";

    for (int attempt = 1;
            attempt <= 15;
            attempt++) {

        try {

            WebElement option =
                    driver.findElement(
                            AppiumBy.xpath(
                                    optionXpath));

            if (option.isDisplayed()) {

                System.out.println(
                        "Option visible : "
                                + optionName
                                + " | Attempt : "
                                + attempt);

                return option;
            }

        }

        catch (Exception e) {

            /*
             * Option is not currently visible.
             * Continue coordinate scrolling.
             */
        }

        System.out.println(
                "Searching option : "
                        + optionName
                        + " | Attempt : "
                        + attempt);

        /*
         * Swipe only inside the
         * selection options list.
         */
        scrollSelectionPopupDown();
    }

    throw new RuntimeException(
            "Option could not be found : "
                    + optionName);
}

// ======================== Cuisine ======================== //

/*
 * Select Cuisine
 */
public void selectCuisine(
        String cuisineName) {

    clickAfterScroll(
            "//android.widget.Button[@content-desc=\"Cuisine\"]",
            "Cuisine");

    WebElement cuisineOption =
            findSelectionOptionWithScroll(
                    cuisineName);

    waitUtil.clickWithWait(
            cuisineOption);

    System.out.println(
            "Cuisine selected : "
                    + cuisineName);
}

// ======================== Dietary ======================== //

/*
 * Select Dietary
 */
public void selectDietary(
        String dietaryName) {

    clickAfterScroll(
            "//android.widget.Button[@content-desc=\"Dietary\"]",
            "Dietary");

    WebElement dietaryOption =
            findSelectionOptionWithScroll(
                    dietaryName);

    waitUtil.clickWithWait(
            dietaryOption);

    System.out.println(
            "Dietary selected : "
                    + dietaryName);
}

// ======================== Occasions ======================== //

/*
 * Select Occasion
 */
public void selectOccasion(
        String occasionName) {

    clickAfterScroll(
            "//android.widget.Button[@content-desc=\"Occasions\"]",
            "Occasions");

    WebElement occasionOption =
            findSelectionOptionWithScroll(
                    occasionName);

    waitUtil.clickWithWait(
            occasionOption);

    System.out.println(
            "Occasion selected : "
                    + occasionName);
}

// ======================== Difficulty ======================== //

/*
 * Select Difficulty
 */
public void selectDifficulty(
        String difficultyName) {

    clickAfterScroll(
            "//android.widget.Button[@content-desc=\"Difficulty\"]",
            "Difficulty");

    WebElement difficultyOption =
            findSelectionOptionWithScroll(
                    difficultyName);

    waitUtil.clickWithWait(
            difficultyOption);

    System.out.println(
            "Difficulty selected : "
                    + difficultyName);
}

// ======================== Attributes ======================== //

/*
 * Select Attribute
 */
public void selectAttribute(
        String attributeName) {

    clickAfterScroll(
            "//android.widget.Button[@content-desc=\"Attributes\"]",
            "Attributes");

    WebElement attributeOption =
            findSelectionOptionWithScroll(
                    attributeName);

    waitUtil.clickWithWait(
            attributeOption);

    System.out.println(
            "Attribute selected : "
                    + attributeName);
}

// ======================== Add Links ======================== //

/*
 * Click Add Links
 */
public void clickAddLinks() {

    clickAfterScroll(
            "//android.view.View[@content-desc=\"Add Links\n"
                    + "Here you can add only 1 link per recipe\"]",
            "Add Links");
}


/*
 * Click Add New Link
 */
public void clickAddNewLink() {

    clickAfterScroll(
            "//android.view.View[@content-desc=\"Add Links\n"
                    + "Here you can add only 1 link per recipe\"]/"
                    + "android.widget.Button",
            "Add New Link");
}


/*
 * Enter Link
 */
public void enterLink(
        String link) {


    WebElement field =
            scrollToElement(
                    "//android.view.View[@content-desc=\"Add Links\n"
                            + "Here you can add only 1 link per recipe\"]/"
                            + "android.widget.EditText",
                    "Add Link Input");

    waitUtil.clickWithWait(
            field);

    field.clear();

    field.sendKeys(
            link);

    System.out.println(
            "Recipe link entered : "
                    + link);
}


/*
 * Delete Link
 */
public void deleteLink() {

    clickAfterScroll(
            "//android.view.View[@content-desc=\"Add Links\n"
                    + "Here you can add only 1 link per recipe\"]/"
                    + "android.widget.Button",
            "Delete Link");
}

// ======================== Sourced From ======================== //

/*
 * Click Sourced From
 */
public void clickSourcedFrom() {

    clickAfterScroll(
            "//android.view.View[@content-desc=\"Sourced From\"]",
            "Sourced From");
}


/*
 * Click Add New Sourced From
 */
public void clickAddSourcedFrom() {

    clickAfterScroll(
            "//android.view.View[@content-desc=\"Sourced From\"]/"
                    + "android.widget.Button",
            "Add Sourced From");
}


/*
 * Enter Sourced From
 */
public void enterSourcedFrom(
        String source) {

    WebElement field =
            scrollToElement(
                    "//android.view.View[@content-desc=\"Sourced From\"]/"
                            + "android.widget.EditText",
                    "Sourced From Input");

    waitUtil.clickWithWait(
            field);

    field.clear();

    field.sendKeys(
            source);

             hideKeyboard();

    System.out.println(
            "Sourced From entered : "
                    + source);
}


/*
 * Delete Sourced From
 */
public void deleteSourcedFrom() {

    clickAfterScroll(
            "//android.view.View[@content-desc=\"Sourced From\"]/"
                    + "android.widget.Button",
            "Delete Sourced From");
}

// ======================== Final Actions ======================== //

/*
 * Click Cancel
 */
public void clickCancel() {

    WebElement cancel =
            scrollToElement(
                    "//android.widget.Button[@content-desc=\"Cancel\"]",
                    "Cancel");

    waitUtil.clickWithWait(
            cancel);

    System.out.println(
            "Cancel clicked.");
}


/*
 * Click Proceed
 */
public void clickProceed() {

    WebElement proceed =
            scrollToElement(
                    "//android.widget.Button[@content-desc=\"Proceed\"]",
                    "Proceed");

    waitUtil.clickWithWait(
            proceed);

    System.out.println(
            "Proceed clicked.");
}

// ======================== Complete Recipe Creation Flow ======================== //
/*
 * Complete Add Recipe Flow
 */
public void createRecipe(
        String recipeName,
        String cookingTime,
        String servingTime,
        String servingLimit,
        String recipeSummary,
        String recipeStep,
        String proTipText,
        String cuisineName,
        String dietaryName,
        String occasionName,
        String difficultyName,
        String attributeName,
        String link,
        String sourcedFrom)
        throws Exception {

    /*
     * Click Add Recipe
     */
    clickAddRecipe();

    Thread.sleep(
            1500);

    /*
     * Enter Recipe Name
     */
    enterRecipeName(
            recipeName);

    /*
     * Enter Cooking Time
     */
    enterCookingTime(
            cookingTime);

    /*
     * Enter Serving Time
     */
    enterServingTime(
            servingTime);

    /*
     * Enter Serving Limit
     */
    enterServingLimit(
            servingLimit);

    /*
     * Enter Recipe Summary
     */
    enterRecipeSummary(
            recipeSummary);

    /*
     * Enter Recipe Step
     */
    enterRecipeStep(
            recipeStep);

    Thread.sleep(
        60000);

    /*
     * Add Pro Tip
     */
    clickAddProTip();

    Thread.sleep(
            500);

    /*
     * Enter Pro Tip
     */
    enterProTip(
            proTipText);

    Thread.sleep(
            500);

    /*
     * Add Keyword
     */
    clickAddKeyword();

    Thread.sleep(
            500);


    /*
     * Select Cuisine
     */
    selectCuisine(
            cuisineName);

    Thread.sleep(
            500);

    /*
     * Select Dietary
     */
    selectDietary(
            dietaryName);

    Thread.sleep(
            500);

    /*
     * Select Occasion
     */
    selectOccasion(
            occasionName);

    Thread.sleep(
            500);

    /*
     * Select Difficulty
     */
    selectDifficulty(
            difficultyName);

    Thread.sleep(
            500);

    /*
     * Select Attribute
     */
    selectAttribute(
            attributeName);


    Thread.sleep(
            500);

    /*
 * Confirm Keyword
 */
confirmKeywordSelection();


Thread.sleep(500);

hideKeyboard();



    /*
     * Add New Link
     */
    clickAddNewLink();

    Thread.sleep(
            500);

    /*
     * Enter Link
     */
    enterLink(
            link);

    Thread.sleep(
            500);

    /*
     * Add Sourced From
     */
    clickAddSourcedFrom();

    Thread.sleep(
            500);

    /*
     * Enter Sourced From
     */
    enterSourcedFrom(
            sourcedFrom);

    Thread.sleep(
            500);

    /*
     * Proceed
     */
    clickProceed();

    System.out.println(
            "==================================================");

    System.out.println(
            "Recipe creation flow completed.");

    System.out.println(
            "Recipe name : "
                    + recipeName);

    System.out.println(
            "Cuisine : "
                    + cuisineName);

    System.out.println(
            "Dietary : "
                    + dietaryName);

    System.out.println(
            "Occasion : "
                    + occasionName);

    System.out.println(
            "Difficulty : "
                    + difficultyName);

    System.out.println(
            "Attribute : "
                    + attributeName);

    System.out.println(
            "Link : "
                    + link);

    System.out.println(
            "Sourced From : "
                    + sourcedFrom);

    System.out.println(
            "==================================================");
}


/*
     * Hide Keyboard
     */
    public void hideKeyboard() {

        try {

            driver.hideKeyboard();

            System.out.println(
                    "Keyboard hidden successfully.");

        } catch (Exception e) {

            System.out.println(
                    "Keyboard is already hidden.");
        }
    }

/*------------------Error Message--------------------- */
/*
 * Recipe Name Error Message
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Recipe name cannot be empty\"]")
private WebElement recipeNameErrorMessage;

/*
 * Serving Limit Error Message
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Enter 1-999\"]")
private WebElement servingLimitErrorMessage;

/*
 * Recipe Summary Error Message
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Required\"]")
private WebElement recipeSummaryErrorMessage;

/*
 * Verify Recipe Name Error Message
 */
public void verifyRecipeNameErrorMessage() {

    WebElement errorMessage =
            scrollUpToElement(
                    "//android.view.View[@content-desc=\"Recipe name cannot be empty\"]",
                    "Recipe Name Error Message");

    ValidationUtil.verifyTrue(
            errorMessage.isDisplayed(),
            "Recipe name error message is displayed.");

    System.out.println(
            "Recipe name error message displayed.");
}

/*
 * Verify Serving Limit Error Message
 */
public void verifyServingLimitErrorMessage() {

    WebElement errorMessage =
            scrollUpToElement(
                    "//android.view.View[@content-desc=\"Enter 1-999\"]",
                    "Serving Limit Error Message");

    ValidationUtil.verifyTrue(
            errorMessage.isDisplayed(),
            "Serving limit error message is displayed.");

    System.out.println(
            "Serving limit error message displayed : "
                    + errorMessage.getAttribute(
                            "content-desc"));
}

/*
 * Verify Recipe Summary Error Message
 */
public void verifyRecipeSummaryErrorMessage() {

    WebElement errorMessage =
            scrollUpToElement(
                    "//android.view.View[@content-desc=\"Required\"]",
                    "Recipe Summary Error Message");

    ValidationUtil.verifyTrue(
            errorMessage.isDisplayed(),
            "Recipe summary error message is displayed.");

    System.out.println(
            "Recipe summary error message displayed : "
                    + errorMessage.getAttribute(
                            "content-desc"));
}


/*
 * ==========================================================
 * RECIPE STEPS & INGREDIENTS
 * ==========================================================
 */

/*
 * Recipe Steps & Ingredients Header
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Recipe Steps & Ingredients\"]")
private WebElement recipeStepsIngredientsHeader;


/*
 * Step 1
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Step 1\"]")
private WebElement step1;


/*
 * Extracted Items Verification
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Extracted items verification\"]")
private WebElement extractedItemsVerification;


/*
 * Add Ingredient Button
 */
@AndroidFindBy(
        xpath = "//android.view.View[@content-desc=\"Extracted items verification\"]"
                + "/following-sibling::android.widget.Button[1]")
private WebElement addIngredientButton;


/*
 * Proceed Button
 */
@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Proceed\"]")
private WebElement ingredientsProceedButton;


/*
 * Previous Button
 */
@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Prev\"]")
private WebElement prevButton;


/*
 * Next Button
 */
@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Next\"]")
private WebElement nextButton;


/*
 * Submit Recipe Button
 */
@AndroidFindBy(
        xpath = "//android.widget.Button[@content-desc=\"Submit Recipe\"]")
private WebElement submitRecipeButton;


/*
 * ==========================================================
 * RECIPE STEP
 * ==========================================================
 */

/*
 * Get Recipe Step
 *
 * Recipe step text is dynamic.
 */
private WebElement getRecipeStep(
        String recipeStep) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc=\""
                            + recipeStep
                            + "\"]"));
}


/*
 * Verify Recipe Step
 */
public void verifyRecipeStep(
        String recipeStep) {

    WebElement step =
            getRecipeStep(
                    recipeStep);

    waitUtil.waitForElementVisible(
            step);

    ValidationUtil.verifyTrue(
            step.isDisplayed(),
            "Recipe step is displayed.");

    System.out.println(
            "Recipe step displayed : "
                    + recipeStep);
}


/*
 * ==========================================================
 * EXTRACTED ITEMS VERIFICATION
 * ==========================================================
 */

/*
 * Verify Extracted Items Verification
 */
public void verifyExtractedItemsVerification() {

    waitUtil.waitForElementVisible(
            extractedItemsVerification);

    ValidationUtil.verifyTrue(
            extractedItemsVerification.isDisplayed(),
            "Extracted items verification section is displayed.");

    System.out.println(
            "Extracted items verification section displayed.");
}


/*
 * Check Whether Ingredient Is Extracted
 */
private boolean isIngredientExtracted(
        String ingredientName) {

    try {

        List<WebElement> ingredients =
                driver.findElements(
                        AppiumBy.xpath(
                                "//android.view.View[@content-desc=\"Extracted items verification\"]"
                                        + "/following::android.widget.EditText[@text=\""
                                        + ingredientName
                                        + "\"]"));

        return !ingredients.isEmpty();

    }

    catch (Exception e) {

        return false;
    }
}


/*
 * Click Add Ingredient
 */
public void clickAddIngredient() {

    waitUtil.waitForElementVisible(
            extractedItemsVerification);

    waitUtil.clickWithWait(
            addIngredientButton);

    System.out.println(
            "Add Ingredient clicked.");
}


/*
 * ==========================================================
 * INGREDIENT ROW FIELDS
 * ==========================================================
 */

/*
 * Get Ingredient Field
 *
 * Gets the first Ingredient EditText
 * under Extracted Items Verification.
 */
private WebElement getIngredientField() {

    return driver.findElement(
            AppiumBy.xpath(
                    "(//android.view.View[@content-desc=\"Extracted items verification\"]"
                            + "/following::android.widget.EditText)[1]"));
}


/*
 * Get Quantity Field
 *
 * Gets the second EditText under
 * Extracted Items Verification.
 */
private WebElement getQuantityField() {

    return driver.findElement(
            AppiumBy.xpath(
                    "(//android.view.View[@content-desc=\"Extracted items verification\"]"
                            + "/following::android.widget.EditText)[2]"));
}


/*
 * Get Ingredient Unit Button
 *
 * Gets the unit button from the
 * ingredient row.
 */
private WebElement getIngredientUnitButton() {

    return driver.findElement(
            AppiumBy.xpath(
                    "(//android.view.View[@content-desc=\"Extracted items verification\"]"
                            + "/following::android.widget.Button[@content-desc=\"-\"])[1]"));
}


/*
 * Get Ingredient Note Field
 *
 * Gets the Notes EditText from
 * the ingredient row.
 */
private WebElement getIngredientNoteField() {

    return driver.findElement(
            AppiumBy.xpath(
                    "(//android.view.View[@content-desc=\"Extracted items verification\"]"
                            + "/following::android.widget.EditText)[3]"));
}


/*
 * Get Delete Ingredient Button
 */
private WebElement getDeleteIngredientButton() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc=\"Extracted items verification\"]"
                            + "/following::android.widget.EditText[3]"
                            + "/following-sibling::android.view.View[1]"));
}


/*
 * ==========================================================
 * INGREDIENT ENTRY
 * ==========================================================
 */

/*
 * Enter Ingredient
 *
 * Handles both extracted and
 * non-extracted ingredient.
 */
public void enterIngredient(
        String ingredientName)
        throws Exception {

    /*
     * Check whether ingredient was extracted.
     */
    if (isIngredientExtracted(
            ingredientName)) {

        /*
         * Ingredient already extracted.
         */
        System.out.println(
                "Ingredient extracted : "
                        + ingredientName);

        WebElement field =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.view.View[@content-desc=\"Extracted items verification\"]"
                                        + "/following::android.widget.EditText[@text=\""
                                        + ingredientName
                                        + "\"][1]"));

        waitUtil.waitForElementVisible(
                field);

        waitUtil.clickWithWait(
                field);

        field.clear();

        field.sendKeys(
                ingredientName);

        hideKeyboard();

        System.out.println(
                "Extracted ingredient updated : "
                        + ingredientName);
    }

    else {

        /*
         * Ingredient was not extracted.
         */
        System.out.println(
                "Ingredient not extracted : "
                        + ingredientName);

        /*
         * Add a new ingredient row.
         */
        clickAddIngredient();

        Thread.sleep(
                500);

        /*
         * Enter ingredient manually.
         */
        WebElement field =
                getIngredientField();

        waitUtil.waitForElementVisible(
                field);

        waitUtil.clickWithWait(
                field);

        field.clear();

        field.sendKeys(
                ingredientName);

        hideKeyboard();

        System.out.println(
                "Ingredient entered manually : "
                        + ingredientName);
    }
}


/*
 * Enter Ingredient Quantity
 */
public void enterIngredientQuantity(
        String quantity) {

    WebElement field =
            getQuantityField();

    waitUtil.waitForElementVisible(
            field);

    waitUtil.clickWithWait(
            field);

    field.clear();

    field.sendKeys(
            quantity);

    hideKeyboard();

    System.out.println(
            "Ingredient quantity entered : "
                    + quantity);
}


/*
 * Click Ingredient Unit
 */
public void clickIngredientUnit() {

    WebElement button =
            getIngredientUnitButton();

    waitUtil.waitForElementVisible(
            button);

    waitUtil.clickWithWait(
            button);

    System.out.println(
            "Ingredient unit dropdown clicked.");
}


/*
 * Enter Ingredient Note
 */
public void enterIngredientNote(
        String note) {

    WebElement field =
            getIngredientNoteField();

    waitUtil.waitForElementVisible(
            field);

    waitUtil.clickWithWait(
            field);

    field.clear();

    field.sendKeys(
            note);

    hideKeyboard();

    System.out.println(
            "Ingredient note entered : "
                    + note);
}


/*
 * Delete Ingredient
 */
public void deleteIngredient() {

    WebElement button =
            getDeleteIngredientButton();

    waitUtil.waitForElementVisible(
            button);

    waitUtil.clickWithWait(
            button);

    System.out.println(
            "Ingredient row deleted.");
}


/*
 * ==========================================================
 * NAVIGATION
 * ==========================================================
 */

/*
 * Click Ingredients Proceed
 */
public void clickIngredientsProceed() {

    waitUtil.waitForElementVisible(
            ingredientsProceedButton);

    waitUtil.clickWithWait(
            ingredientsProceedButton);

    System.out.println(
            "Ingredients Proceed clicked.");
}


/*
 * Click Previous
 */
public void clickPrevious() {

    waitUtil.waitForElementVisible(
            prevButton);

    waitUtil.clickWithWait(
            prevButton);

    System.out.println(
            "Previous button clicked.");
}


/*
 * Click Next
 */
public void clickNext() {

    waitUtil.waitForElementVisible(
            nextButton);

    waitUtil.clickWithWait(
            nextButton);

    System.out.println(
            "Next button clicked.");
}


/*
 * Click Submit Recipe
 *
 * Submit Recipe is available on the
 * Final Review screen.
 */
public void clickSubmitRecipe() {

    WebElement button =
            scrollToElement(
                    "//android.widget.Button[@content-desc=\"Submit Recipe\"]",
                    "Submit Recipe");

    waitUtil.waitForElementVisible(
            button);

    waitUtil.clickWithWait(
            button);

    System.out.println(
            "Submit Recipe clicked.");
}

/*
 * Select Ingredient Unit
 */
public void selectIngredientUnit(
        String unit) {

    WebElement option =
            driver.findElement(
                    AppiumBy.xpath(
                            "//android.widget.Button[@content-desc=\""
                                    + unit
                                    + "\"]"));

    waitUtil.waitForElementVisible(
            option);

    waitUtil.clickWithWait(
            option);

    System.out.println(
            "Ingredient unit selected : "
                    + unit);
}

/*
 * Verify Recipe Steps & Ingredients Header
 */
public void verifyRecipeStepsIngredientsHeader() {

    waitUtil.waitForElementVisible(
            recipeStepsIngredientsHeader);

    ValidationUtil.verifyTrue(
            recipeStepsIngredientsHeader.isDisplayed(),
            "Recipe Steps & Ingredients header is displayed.");

    System.out.println(
            "Recipe Steps & Ingredients header displayed.");
}


}