package pagesObjects.Contribute.MyRecipiesDashboard;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.WaitUtil;

public class MyRecipes {

    private AndroidDriver driver;
    private WaitUtil waitUtil;

    public MyRecipes(
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
     * My Recipes Tab
     */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='My Recipes\nTab 2 of 2']")
    private WebElement myRecipesTab;

    /*
     * Search Recipe
     */
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement searchField;

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
     * Recipe Status Tabs
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
     * Dynamic Recipe Card
     */
    private WebElement recipeCard(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ImageView[contains(@content-desc,'"
                                + recipeName
                                + "')]"));
    }

    /*
     * Dynamic Nutrition Panel
     */
    private WebElement nutritionPanel(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ImageView[contains(@content-desc,'"
                                + recipeName
                                + "')]//android.widget.Button[@content-desc='Nutrition Panel']"));
    }

    /*
     * Dynamic Delete Nutrition Panel
     */
    private WebElement deleteNutritionPanel(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ImageView[contains(@content-desc,'"
                                + recipeName
                                + "')]//android.widget.Button[@content-desc='Delete nutrition panel']"));
    }

    /*
     * Find Recipe Card
     */
    private WebElement findRecipeCard(
            String recipeName) {

        for (int attempt = 1; attempt <= 5; attempt++) {

            try {

                WebElement recipe =
                        recipeCard(
                                recipeName);

                if (recipe.isDisplayed()) {

                    return recipe;
                }

            }

            catch (NoSuchElementException e) {

            }

            scrollRecipes();
        }

        throw new NoSuchElementException(
                "Recipe not found : "
                        + recipeName);
    }

        /*
     * My Recipes Tab
     */
    public void clickMyRecipesTab() {

        waitUtil.clickWithWait(
                myRecipesTab);

        System.out.println(
                "My Recipes tab opened.");
    }

    /*
     * Search Recipe
     */
    public void clickSearchField() {

        waitUtil.clickWithWait(
                searchField);
    }

    public void enterSearchText(
            String recipeName) {

        waitUtil.clickWithWait(
                searchField);

        searchField.clear();

        searchField.sendKeys(
                recipeName);
    }

    public void clearSearchField() {

        searchField.clear();
    }

    /*
     * Sort
     */
    public void clickSort() {

        waitUtil.clickWithWait(
                sortButton);
    }

    public void selectNewest() {

        waitUtil.clickWithWait(
                newest);
    }

    public void selectOldest() {

        waitUtil.clickWithWait(
                oldest);
    }

    public void selectName() {

        waitUtil.clickWithWait(
                name);
    }

    /*
     * All Tab
     */
    public void clickAllTab() {

        horizontalScroll.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                                + "new UiSelector().description(\"All\"))"));

        waitUtil.clickWithWait(
                allTab);
    }

    /*
     * Submitted Tab
     */
    public void clickSubmittedTab() {

        horizontalScroll.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                                + "new UiSelector().description(\"Submitted\"))"));

        waitUtil.clickWithWait(
                submittedTab);
    }

    /*
     * Verified Tab
     */
    public void clickVerifiedTab() {

        horizontalScroll.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                                + "new UiSelector().description(\"Verified\"))"));

        waitUtil.clickWithWait(
                verifiedTab);
    }

    /*
     * Rejected Tab
     */
    public void clickRejectedTab() {

        horizontalScroll.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                                + "new UiSelector().description(\"Rejected\"))"));

        waitUtil.clickWithWait(
                rejectedTab);
    }

    /*
     * Delete Pending Tab
     */
    public void clickDeletePendingTab() {

        horizontalScroll.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                                + "new UiSelector().description(\"Delete Pending\"))"));

        waitUtil.clickWithWait(
                deletePendingTab);
    }

    /*
     * Open Recipe
     */
    public void openRecipe(
            String recipeName) {

        waitUtil.clickWithWait(
                findRecipeCard(
                        recipeName));

        System.out.println(
                "Recipe opened : "
                        + recipeName);
    }

    /*
     * Nutrition Panel
     */
    public void clickNutritionPanel(
            String recipeName) {

        waitUtil.clickWithWait(
                nutritionPanel(
                        recipeName));

        System.out.println(
                "Nutrition Panel opened.");
    }

    /*
     * Delete Nutrition Panel
     */
    public void clickDeleteNutritionPanel(
            String recipeName) {

        waitUtil.clickWithWait(
                deleteNutritionPanel(
                        recipeName));

        System.out.println(
                "Delete Nutrition Panel clicked.");
    }

    /*
     * Verify Recipe Displayed
     */
    public boolean isRecipeDisplayed(
            String recipeName) {

        try {

            return findRecipeCard(
                    recipeName)
                            .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Scroll Recipes
     */
    public void scrollRecipes() {

        Dimension size =
                DriverFactory.getDriver()
                        .manage()
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

        DriverFactory.getDriver()
                .perform(
                        List.of(
                                swipe));

        System.out.println(
                "Recipes scrolled successfully.");
    }

    /*
     * Verify My Recipes Tab
     */
    public boolean isMyRecipesTabDisplayed() {

        return myRecipesTab.isDisplayed();
    }

    /*
     * Verify Search Field
     */
    public boolean isSearchFieldDisplayed() {

        return searchField.isDisplayed();
    }

    /*
     * Verify Sort Button
     */
    public boolean isSortButtonDisplayed() {

        return sortButton.isDisplayed();
    }

    /*
     * Verify Sort Options
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
     * Verify Tabs
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
     * Verify Nutrition Panel
     */
    public boolean isNutritionPanelDisplayed(
            String recipeName) {

        try {

            return nutritionPanel(
                    recipeName)
                            .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Verify Delete Nutrition Panel
     */
    public boolean isDeleteNutritionPanelDisplayed(
            String recipeName) {

        try {

            return deleteNutritionPanel(
                    recipeName)
                            .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
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
 * Get All Recipes
 */
public List<String> getAllRecipes() {

    List<String> recipeList =
            new ArrayList<>();

    String previousLastRecipe =
            "";

    while (true) {

        List<WebElement> recipes =
                driver.findElements(
                        AppiumBy.xpath(
                                "//android.widget.ImageView"));

        for (WebElement recipe : recipes) {

            String content =
                    recipe.getAttribute(
                            "content-desc");

            if (content != null
                    && !content.isBlank()
                    && !recipeList.contains(
                            content)) {

                recipeList.add(
                        content);
            }
        }

        if (recipeList.isEmpty()) {

            break;
        }

        String currentLastRecipe =
                recipeList.get(
                        recipeList.size() - 1);

        if (currentLastRecipe.equals(
                previousLastRecipe)) {

            break;
        }

        previousLastRecipe =
                currentLastRecipe;

        scrollRecipes();

        try {

            Thread.sleep(
                    1500);

        }

        catch (InterruptedException e) {

            Thread.currentThread()
                    .interrupt();
        }
    }

    System.out.println(
            "Total Recipes : "
                    + recipeList.size());

    return recipeList;
}
}