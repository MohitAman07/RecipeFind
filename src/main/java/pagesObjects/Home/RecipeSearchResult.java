package pagesObjects.Home;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.WaitUtil;

public class RecipeSearchResult {

    private final AndroidDriver driver;
    private final WaitUtil waitUtil;

    public RecipeSearchResult(
            AndroidDriver driver) {

        this.driver =
                driver;

        this.waitUtil =
                new WaitUtil(driver);
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
     * Dynamic Follow Button
     */
    private WebElement followButton(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'"
                                + recipeName
                                + "')]/android.view.View[2]"));
    }

    /*
     * Dynamic Share Button
     */
    private WebElement shareButton(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'"
                                + recipeName
                                + "')]/android.widget.Button"));
    }

    /*
     * Dynamic Comment Icon
     */
    private WebElement commentIcon(
            String recipeName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'"
                                + recipeName
                                + "')]/android.widget.ImageView[2]"));
    }

    /*
     * Dynamic Author Name
     */
    private WebElement authorName(
            String recipeName,
            String authorName) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'"
                                + recipeName
                                + "')]"
                                + "/android.view.View[@content-desc='by "
                                + authorName
                                + "']"));
    }

        /*
     * Search Results Header
     */
    public boolean isSearchResultsHeaderVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'Search Results')]"))
                .isEmpty();
    }

    public String getSearchResultsHeader() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'Search Results')]"))
                .getAttribute(
                        "content-desc");
    }

    /*
     * Results Text
     */
    public boolean isResultsTextVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'Results for')]"))
                .isEmpty();
    }

    public String getResultsText() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'Results for')]"))
                .getAttribute(
                        "content-desc");
    }

    /*
     * Community Tab
     */
    public boolean isCommunityTabVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'Community')]"))
                .isEmpty();
    }

    public void clickCommunityTab() {

        waitUtil.clickWithWait(
                driver.findElement(
                        AppiumBy.xpath(
                                "//*[contains(@content-desc,'Community')]")));

        System.out.println(
                "Community tab clicked.");
    }

    /*
     * AI Generated Tab
     */
    public boolean isAIGeneratedTabVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'AI Generated')]"))
                .isEmpty();
    }

    public void clickAIGeneratedTab() {

        waitUtil.clickWithWait(
                driver.findElement(
                        AppiumBy.xpath(
                                "//*[contains(@content-desc,'AI Generated')]")));

        System.out.println(
                "AI Generated tab clicked.");
    }

    /*
     * Verify Recipe Card
     */
    public boolean isRecipeDisplayed(
            String recipeName) {

        try {

            return recipeCard(
                    recipeName)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Open Recipe
     */
    public void openRecipe(
            String recipeName) {

        waitUtil.clickWithWait(
                recipeCard(
                        recipeName));

        System.out.println(
                "Recipe opened : "
                        + recipeName);
    }

    /*
     * Verify Follow Button
     */
    public boolean isFollowButtonDisplayed(
            String recipeName) {

        try {

            return followButton(
                    recipeName)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Follow Button
     */
    public void clickFollowButton(
            String recipeName) {

        waitUtil.clickWithWait(
                followButton(
                        recipeName));

        System.out.println(
                "Follow button clicked.");
    }

    /*
     * Verify Share Button
     */
    public boolean isShareButtonDisplayed(
            String recipeName) {

        try {

            return shareButton(
                    recipeName)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Share Button
     */
    public void clickShareButton(
            String recipeName) {

        waitUtil.clickWithWait(
                shareButton(
                        recipeName));

        System.out.println(
                "Share button clicked.");
    }

    /*
     * Verify Comment Icon
     */
    public boolean isCommentIconDisplayed(
            String recipeName) {

        try {

            return commentIcon(
                    recipeName)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Comment Icon
     */
    public void clickCommentIcon(
            String recipeName) {

        waitUtil.clickWithWait(
                commentIcon(
                        recipeName));

        System.out.println(
                "Comment icon clicked.");
    }


        /*
     * Click Recipe Card
     */
    public void clickRecipeCard(
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

            if (!recipes.isEmpty()) {

                waitUtil.clickWithWait(
                        recipes.get(0));

                System.out.println(
                        "Recipe card clicked : "
                                + recipeName);

                return;
            }

            /*
             * Capture First Visible Recipe
             */
            List<WebElement> visibleRecipes =
                    driver.findElements(
                            AppiumBy.xpath(
                                    "//android.widget.ScrollView/android.view.View[@content-desc]"));

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

            scrollCommunityRecipes();

            waitUtil.sleep(
                    1500);
        }

        throw new RuntimeException(
                "Recipe not found : "
                        + recipeName);
    }

    /*
     * Scroll Community Recipes
     */
    public void scrollCommunityRecipes() {

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
                        540,
                        1700));

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(
                                700),
                        PointerInput.Origin.viewport(),
                        540,
                        500));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(
                Arrays.asList(
                        swipe));

        System.out.println(
                "Community recipes scrolled.");
    }

        /*
     * Fetch All Community Recipe Cards
     */
    public Set<String> getAllCommunityResults() {

        Set<String> recipes =
                new LinkedHashSet<>();

        String previousFirstRecipe =
                "";

        while (true) {

            List<WebElement> cards =
                    driver.findElements(
                            AppiumBy.xpath(
                                    "//android.widget.ScrollView/android.view.View[@content-desc]"));

            System.out.println(
                    "Visible Community Recipe Cards : "
                            + cards.size());

            String currentFirstRecipe =
                    "";

            if (!cards.isEmpty()) {

                currentFirstRecipe =
                        cards.get(0)
                                .getAttribute(
                                        "content-desc");
            }

            for (WebElement card : cards) {

                String content =
                        card.getAttribute(
                                "content-desc");

                if (content == null
                        || content.isBlank()) {

                    continue;
                }

                content =
                        content.trim();

                /*
                 * Skip Static Contents
                 */
                if (content.equals(
                        "Search Results")
                        || content.startsWith(
                                "Results for")
                        || content.contains(
                                "Community")
                        || content.contains(
                                "AI Generated")
                        || content.contains(
                                "Community-shared recipes")) {

                    continue;
                }

                /*
                 * Recipe Card
                 */
                if (recipes.add(
                        content)) {

                    System.out.println(
                            "Community Recipe :");

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
                        "Reached end of Community Results.");

                break;
            }

            previousFirstRecipe =
                    currentFirstRecipe;

            scrollCommunityResults();

            waitUtil.sleep(
                    1500);
        }

        System.out.println(
                "Total Community Recipes : "
                        + recipes.size());

        return recipes;
    }

    /*
     * Scroll Community Results
     */
    private void scrollCommunityResults() {

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
                        540,
                        1700));

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(
                                700),
                        PointerInput.Origin.viewport(),
                        540,
                        500));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(
                Arrays.asList(
                        swipe));

        System.out.println(
                "Community Results Scrolled.");
    }

        /*
     * Fetch All AI Generated Recipe Cards
     */
    public Set<String> getAllAIGeneratedResults()
            throws InterruptedException {

        Set<String> recipes =
                new LinkedHashSet<>();

        /*
         * Wait For AI Generation
         */
        for (int wait = 1;
                wait <= 30;
                wait++) {

            if (isAIGenerationFailed()) {

                System.out.println(
                        "AI Generation Failed : "
                                + getAIGenerationFailureMessage());

                return recipes;
            }

            List<WebElement> cards =
                    driver.findElements(
                            AppiumBy.xpath(
                                    "//android.widget.ScrollView/android.view.View[@content-desc]"));

            boolean aiRecipeFound =
                    false;

            for (WebElement card : cards) {

                String content =
                        card.getAttribute(
                                "content-desc");

                if (content == null
                        || content.isBlank()) {

                    continue;
                }

                content =
                        content.trim();

                /*
                 * Skip Static Contents
                 */
                if (content.equals(
                        "Search Results")
                        || content.startsWith(
                                "Results for")
                        || content.contains(
                                "Community")
                        || content.contains(
                                "AI Generated")
                        || content.contains(
                                "AI-generated recipe suggestions")
                        || content.contains(
                                "Failed to generate recipes")) {

                    continue;
                }

                recipes.add(
                        content);

                aiRecipeFound =
                        true;
            }

            if (aiRecipeFound) {

                break;
            }

            System.out.println(
                    "Waiting For AI Recipes... "
                            + wait);

            waitUtil.sleep(
                    3000);
        }

        /*
         * Scroll Through AI Recipes
         */
        String previousFirstRecipe =
                "";

        while (true) {

            List<WebElement> cards =
                    driver.findElements(
                            AppiumBy.xpath(
                                    "//android.widget.ScrollView/android.view.View[@content-desc]"));

            String currentFirstRecipe =
                    "";

            if (!cards.isEmpty()) {

                currentFirstRecipe =
                        cards.get(0)
                                .getAttribute(
                                        "content-desc");
            }

            for (WebElement card : cards) {

                String content =
                        card.getAttribute(
                                "content-desc");

                if (content == null
                        || content.isBlank()) {

                    continue;
                }

                content =
                        content.trim();

                if (content.equals(
                        "Search Results")
                        || content.startsWith(
                                "Results for")
                        || content.contains(
                                "Community")
                        || content.contains(
                                "AI Generated")
                        || content.contains(
                                "AI-generated recipe suggestions")
                        || content.contains(
                                "Failed to generate recipes")) {

                    continue;
                }

                recipes.add(
                        content);
            }

            if (currentFirstRecipe.equals(
                    previousFirstRecipe)) {

                System.out.println(
                        "Reached End Of AI Recipes.");

                break;
            }

            previousFirstRecipe =
                    currentFirstRecipe;

            scrollAIResults();

            waitUtil.sleep(
                    1500);
        }

        System.out.println(
                "Total AI Recipes : "
                        + recipes.size());

        return recipes;
    }

    /*
     * Scroll AI Results
     */
    private void scrollAIResults() {

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
                        540,
                        1700));

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(
                                700),
                        PointerInput.Origin.viewport(),
                        540,
                        500));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(
                Arrays.asList(
                        swipe));

        System.out.println(
                "AI Results Scrolled.");
    }

        /*
     * AI Generation Failed
     */
    public boolean isAIGenerationFailed() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'Failed to generate recipes')]"))
                .isEmpty();
    }

    /*
     * AI Failure Message
     */
    public String getAIGenerationFailureMessage() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'Failed to generate recipes')]"))
                .getAttribute(
                        "content-desc");
    }

    /*
     * Scroll Back To Top
     */
    public void scrollToTop() {

        driver.executeScript(
                "mobile: scrollGesture",
                Map.of(
                        "left", 0,
                        "top", 250,
                        "width", 1080,
                        "height", 1800,
                        "direction", "up",
                        "percent", 3.0));

        System.out.println(
                "Scrolled back to top.");
    }

    /*
     * Verify Recipe Exists
     */
    public boolean isRecipePresent(
            String recipeName) {

        try {

            return recipeCard(
                    recipeName)
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Open Community Recipe
     */
    public void openCommunityRecipe(
            String recipeName) {

        waitUtil.clickWithWait(
                recipeCard(
                        recipeName));

        System.out.println(
                "Community Recipe opened : "
                        + recipeName);
    }

    /*
     * Share Recipe
     */
    public void shareRecipe(
            String recipeName) {

        waitUtil.clickWithWait(
                shareButton(
                        recipeName));

        System.out.println(
                "Recipe shared successfully.");
    }

    /*
     * Open Recipe Comments
     */
    public void openRecipeComments(
            String recipeName) {

        waitUtil.clickWithWait(
                commentIcon(
                        recipeName));

        System.out.println(
                "Recipe comments opened.");
    }

    /*
     * Get Recipe Name
     */
    public String getRecipeName(
            String recipeName) {

        String content =
                recipeCard(
                        recipeName)
                        .getAttribute(
                                "content-desc");

        if (content == null
                || content.isBlank()) {

            return "";
        }

        return content.split(
                "\n")[0];
    }

    /*
     * Get Complete Recipe Card Content
     */
    public String getRecipeCardContent(
            String recipeName) {

        return recipeCard(
                recipeName)
                .getAttribute(
                        "content-desc");
    }

    /*
     * Get Follow Status
     */
    public String getFollowStatus(
            String recipeName) {

        return followButton(
                recipeName)
                .getAttribute(
                        "content-desc");
    }

    /*
     * Follow / Unfollow Recipe
     */
    public void followRecipeIfRequired(
            String recipeName)
            throws InterruptedException {

        String status =
                getFollowStatus(
                        recipeName);

        System.out.println(
                "Current Follow Status : "
                        + status);

        /*
         * Already Following
         */
        if (status != null
                && status.equalsIgnoreCase(
                        "Following")) {

            clickFollowButton(
                    recipeName);

            waitUtil.sleep(
                    1500);

            clickFollowButton(
                    recipeName);

            System.out.println(
                    "Recipe unfollowed and followed again.");
        }

        /*
         * Not Following
         */
        else {

            clickFollowButton(
                    recipeName);

            System.out.println(
                    "Recipe followed successfully.");
        }
    }
}