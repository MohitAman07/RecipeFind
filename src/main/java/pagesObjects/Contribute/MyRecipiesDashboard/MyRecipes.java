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

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.WaitUtil;

public class MyRecipes {

    private final AndroidDriver driver;

    private final WaitUtil waitUtil;

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
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc='My Recipes\nTab 2 of 2']")
    private WebElement myRecipesTab;

    /*
     * Search
     */
    @AndroidFindBy(
            xpath = "//android.widget.EditText")
    private WebElement searchField;

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
     * Recipe Status Tabs
     */
    @AndroidFindBy(
            xpath = "//android.widget.HorizontalScrollView")
    private WebElement horizontalScroll;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='All']")
    private WebElement allTab;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Submitted']")
    private WebElement submittedTab;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Verified']")
    private WebElement verifiedTab;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Rejected']")
    private WebElement rejectedTab;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc='Delete Pending']")
    private WebElement deletePendingTab;

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
                                + "')]/android.widget.Button"));
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
     * Dynamic Nutrition Panel
     */
    private WebElement nutritionPanel(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'"
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
                        "//android.view.View[contains(@content-desc,'"
                                + recipeName
                                + "')]//android.widget.Button[@content-desc='Delete nutrition panel']"));
    }


    /*
 * Find Recipe Card
 */
private WebElement findRecipeCard(
        String recipeName) {

    String previousFirstRecipe =
            "";

    while (true) {

        /*
         * Check Whether Recipe Is Visible
         */
        List<WebElement> recipes =
                driver.findElements(
                        AppiumBy.xpath(
                                "//android.view.View[contains(@content-desc,'"
                                        + recipeName
                                        + "')]"));

        if (!recipes.isEmpty()
                && recipes.get(0).isDisplayed()) {

            System.out.println(
                    "Recipe found : "
                            + recipeName);

            return recipes.get(0);
        }

        /*
         * Capture First Visible Recipe
         */
        List<WebElement> visibleRecipes =
                driver.findElements(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'\n')]"));

        String currentFirstRecipe =
                "";

        if (!visibleRecipes.isEmpty()) {

            currentFirstRecipe =
                    visibleRecipes
                            .get(0)
                            .getAttribute(
                                    "content-desc");
        }

        /*
         * End Of List Reached
         */
        if (currentFirstRecipe.equals(
                previousFirstRecipe)) {

            break;
        }

        previousFirstRecipe =
                currentFirstRecipe;

        scrollRecipes();

        waitUtil.sleep(
                1500);
    }

    throw new NoSuchElementException(
            "Recipe not found : "
                    + recipeName);
}

/*
 * Open Recipe
 */
public void openRecipe(
        String recipeName) {

    WebElement recipe =
            findRecipeCard(
                    recipeName);

    waitUtil.clickWithWait(
            recipe);

    System.out.println(
            "Recipe opened : "
                    + recipeName);
}

/*
 * Click Recipe Card
 */
public void clickRecipeCard(
        String recipeName) {

    openRecipe(
            recipeName);
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
     * Search Field
     */
    public boolean isSearchFieldDisplayed() {

        return searchField.isDisplayed();
    }

    public void clickSearchField() {

        waitUtil.clickWithWait(
                searchField);

        System.out.println(
                "Search field clicked.");
    }

    public void enterSearchText(
            String recipeName) {

        waitUtil.clickWithWait(
                searchField);

        searchField.clear();

        searchField.sendKeys(
                recipeName);

        System.out.println(
                "Recipe searched : "
                        + recipeName);
    }

    public void clearSearchField() {

        searchField.clear();

        System.out.println(
                "Search field cleared.");
    }

    /*
     * Sort
     */
    public boolean isSortButtonDisplayed() {

        return sortButton.isDisplayed();
    }

    public void clickSort() {

        waitUtil.clickWithWait(
                sortButton);

        System.out.println(
                "Sort button clicked.");
    }

    public boolean isNewestDisplayed() {

        return newest.isDisplayed();
    }

    public void selectNewest() {

        waitUtil.clickWithWait(
                newest);

        System.out.println(
                "Newest selected.");
    }

    public boolean isOldestDisplayed() {

        return oldest.isDisplayed();
    }

    public void selectOldest() {

        waitUtil.clickWithWait(
                oldest);

        System.out.println(
                "Oldest selected.");
    }

    public boolean isNameDisplayed() {

        return name.isDisplayed();
    }

    public void selectName() {

        waitUtil.clickWithWait(
                name);

        System.out.println(
                "Name selected.");
    }

    /*
     * All Tab
     */
    public boolean isAllTabDisplayed() {

        return allTab.isDisplayed();
    }

    public void clickAllTab() {

        horizontalScroll.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                                + "new UiSelector().description(\"All\"))"));

        waitUtil.clickWithWait(
                allTab);

        System.out.println(
                "All tab selected.");
    }

    /*
     * Submitted Tab
     */
    public boolean isSubmittedTabDisplayed() {

        return submittedTab.isDisplayed();
    }

    public void clickSubmittedTab() {

        horizontalScroll.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                                + "new UiSelector().description(\"Submitted\"))"));

        waitUtil.clickWithWait(
                submittedTab);

        System.out.println(
                "Submitted tab selected.");
    }

    /*
     * Verified Tab
     */
    public boolean isVerifiedTabDisplayed() {

        return verifiedTab.isDisplayed();
    }

    public void clickVerifiedTab() {

        horizontalScroll.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                                + "new UiSelector().description(\"Verified\"))"));

        waitUtil.clickWithWait(
                verifiedTab);

        System.out.println(
                "Verified tab selected.");
    }

    /*
     * Rejected Tab
     */
    public boolean isRejectedTabDisplayed() {

        return rejectedTab.isDisplayed();
    }

    public void clickRejectedTab() {

        horizontalScroll.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                                + "new UiSelector().description(\"Rejected\"))"));

        waitUtil.clickWithWait(
                rejectedTab);

        System.out.println(
                "Rejected tab selected.");
    }

    /*
     * Delete Pending Tab
     */
    public boolean isDeletePendingTabDisplayed() {

        return deletePendingTab.isDisplayed();
    }

    public void clickDeletePendingTab() {

        horizontalScroll.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
                                + "new UiSelector().description(\"Delete Pending\"))"));

        waitUtil.clickWithWait(
                deletePendingTab);

        System.out.println(
                "Delete Pending tab selected.");
    }
    /*
     * Recipe Menu
     */
    public void clickRecipeMenu(
            String recipeName) {

        waitUtil.clickWithWait(
                recipeMenu(
                        recipeName));

        System.out.println(
                "Recipe menu clicked : "
                        + recipeName);
    }

    /*
     * Recipe Author
     */
    public void clickRecipeAuthor(
            String recipeName) {

        waitUtil.clickWithWait(
                recipeAuthor(
                        recipeName));

        System.out.println(
                "Recipe author clicked : "
                        + recipeName);
    }

    /*
     * Comment Icon
     */
    public void clickCommentIcon(
            String recipeName) {

        waitUtil.clickWithWait(
                recipeCommentIcon(
                        recipeName));

        System.out.println(
                "Comment icon clicked : "
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
                "Nutrition Panel opened : "
                        + recipeName);
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
                "Delete Nutrition Panel clicked : "
                        + recipeName);
    }

    /*
     * Cooking Time
     */
    public String getCookingTime(
            String recipeName) {

        String cookingTime =
                recipeCookingTime(
                        recipeName)
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Cooking Time : "
                        + cookingTime);

        return cookingTime;
    }

    /*
     * Serving Time
     */
    public String getServingTime(
            String recipeName) {

        String servingTime =
                recipeServingTime(
                        recipeName)
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Serving Time : "
                        + servingTime);

        return servingTime;
    }

    /*
     * Recipe Status
     */
    public String getRecipeStatus(
            String recipeName) {

        String status =
                recipeStatus(
                        recipeName)
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Recipe Status : "
                        + status);

        return status;
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

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Verify Recipe Author
     */
    public boolean isRecipeAuthorDisplayed(
            String recipeName) {

        try {

            return recipeAuthor(
                    recipeName)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Verify Comment Icon
     */
    public boolean isCommentIconDisplayed(
            String recipeName) {

        try {

            return recipeCommentIcon(
                    recipeName)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Verify Cooking Time
     */
    public boolean isCookingTimeDisplayed(
            String recipeName) {

        try {

            return recipeCookingTime(
                    recipeName)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Verify Serving Time
     */
    public boolean isServingTimeDisplayed(
            String recipeName) {

        try {

            return recipeServingTime(
                    recipeName)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Verify Recipe Status
     */
    public boolean isRecipeStatusDisplayed(
            String recipeName) {

        try {

            return recipeStatus(
                    recipeName)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
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

        } catch (Exception e) {

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

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Verify My Recipes Tab
     */
    public boolean isMyRecipesTabDisplayed() {

        return myRecipesTab.isDisplayed();
    }



        /*
     * Scroll Recipes
     */
    public void scrollRecipes() {

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
                List.of(
                        swipe));

        System.out.println(
                "Recipes scrolled successfully.");
    }

    /*
     * Get All Recipes
     */
    public List<String> getAllRecipes() {

        List<String> recipeList =
                new ArrayList<>();

        String previousFirstRecipe =
                "";

        while (true) {

            List<WebElement> recipes =
                    driver.findElements(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'\n')]"));

            String currentFirstRecipe =
                    "";

            if (!recipes.isEmpty()) {

                currentFirstRecipe =
                        recipes.get(0)
                                .getAttribute(
                                        "content-desc");
            }

            for (WebElement recipe : recipes) {

                String content =
                        recipe.getAttribute(
                                "content-desc");

                if (content == null
                        || content.isBlank()) {

                    continue;
                }

                content =
                        content.trim();

                if (!recipeList.contains(
                        content)) {

                    recipeList.add(
                            content);

                    System.out.println(
                            "Recipe Found :");

                    System.out.println(
                            content);

                    System.out.println(
                            "------------------------------------------------");
                }
            }

            /*
             * End Of List
             */
            if (currentFirstRecipe.equals(
                    previousFirstRecipe)) {

                System.out.println(
                        "Reached end of recipe list.");

                break;
            }

            previousFirstRecipe =
                    currentFirstRecipe;

            scrollRecipes();

            waitUtil.sleep(
                    1500);
        }

        System.out.println(
                "Total Recipes : "
                        + recipeList.size());

        return recipeList;
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
}



