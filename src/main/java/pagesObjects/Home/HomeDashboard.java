package pagesObjects.Home;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomeDashboard {

    private AndroidDriver driver;

    public HomeDashboard(
            AndroidDriver driver) {

        this.driver =
                driver;
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
     * Dashboard ScrollView
     */
    private WebElement dashboardScrollView() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ScrollView"));
    }

    /*
     * Welcome Message
     */
    public boolean isWelcomeMessageVisible() {

        List<WebElement> elements =
                driver.findElements(
                        AppiumBy.xpath(
                                "//*[starts-with(@content-desc,'Hi ')]"));

        System.out.println(
                "Welcome Message Count : "
                        + elements.size());

        return !elements.isEmpty();
    }

    public String getWelcomeMessage() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//*[starts-with(@content-desc,'Hi ')]"))
                .getAttribute(
                        "contentDescription");
    }

    /*
     * Welcome Sub Message
     */
    public boolean isWelcomeSubMessageVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "What do you want to cook today?"))
                .isEmpty();
    }

    /*
     * Home Button
     */
    public boolean isHomeButtonVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//android.widget.Button[contains(@content-desc,'Home')]"))
                .isEmpty();
    }

    public void clickHomeButton() {

        driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[contains(@content-desc,'Home')]"))
                .click();

        System.out.println(
                "Home button clicked.");
    }

    /*
     * Cookbook Button
     */
    public boolean isCookbookButtonVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//android.widget.Button[contains(@content-desc,'Cookbook')]"))
                .isEmpty();
    }

    public void clickCookbookButton() {

        driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[contains(@content-desc,'Cookbook')]"))
                .click();

        System.out.println(
                "Cookbook button clicked.");
    }

    /*
     * Contribute Button
     */
    public boolean isContributeButtonVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//android.widget.Button[contains(@content-desc,'Contribute')]"))
                .isEmpty();
    }

    public void clickContributeButton() {

        driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[contains(@content-desc,'Contribute')]"))
                .click();

        System.out.println(
                "Contribute button clicked.");
    }

    /*
     * Profile Button
     */
    public boolean isProfileButtonVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//android.widget.Button[contains(@content-desc,'Profile')]"))
                .isEmpty();
    }

    public void clickProfileButton() {

        driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[contains(@content-desc,'Profile')]"))
                .click();

        System.out.println(
                "Profile button clicked.");
    }

        /*
     * Open Recipe
     */
    public void openRecipe(
            String recipeName) {

        recipeCard(
                recipeName)
                .click();

        System.out.println(
                "Recipe opened : "
                        + recipeName);
    }

    /*
     * Click Follow Button
     */
    public void clickFollowButton(
            String recipeName) {

        followButton(
                recipeName)
                .click();

        System.out.println(
                "Follow button clicked.");
    }

    /*
     * Click Share Button
     */
    public void clickShareButton(
            String recipeName) {

        shareButton(
                recipeName)
                .click();

        System.out.println(
                "Share button clicked.");
    }

    /*
     * Click Comment Icon
     */
    public void clickCommentIcon(
            String recipeName) {

        commentIcon(
                recipeName)
                .click();

        System.out.println(
                "Comment icon clicked.");
    }

    /*
     * Get Recipe Card Description
     */
    public String getRecipeDescription(
            String recipeName) {

        return recipeCard(
                recipeName)
                .getAttribute(
                        "content-desc");
    }

    /*
     * Get All Visible Recipe Cards
     */
    public List<WebElement> getVisibleRecipeCards() {

        return driver.findElements(
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.view.View[@content-desc]"));
    }

    /*
     * Get Visible Recipe Count
     */
    public int getVisibleRecipeCount() {

        return getVisibleRecipeCards()
                .size();
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
     * Fetch all dishes from dashboard
     */
    public Set<String> getAllDashboardDishes() {

        Set<String> dishes =
                new LinkedHashSet<>();

        int sameScrollCount =
                0;

        int previousSize =
                0;

        while (true) {

            List<WebElement> cards =
                    driver.findElements(
                            AppiumBy.xpath(
                                    "//android.widget.ScrollView/android.view.View[@content-desc]"));

            System.out.println(
                    "Visible cards : "
                            + cards.size());

            for (WebElement card : cards) {

                String contentDesc =
                        card.getAttribute(
                                "content-desc");

                if (contentDesc == null
                        || contentDesc.isBlank()) {

                    continue;
                }

                /*
                 * Ignore non recipe elements
                 */
                if (contentDesc.startsWith("Hi ")
                        || contentDesc.equals("What do you want to cook today?")
                        || contentDesc.contains("Instant Noodles")) {

                    continue;
                }

                dishes.add(
                        contentDesc.trim());

                System.out.println(
                        "Recipe Found :\n"
                                + contentDesc);
            }

            System.out.println(
                    "Total unique recipes : "
                            + dishes.size());

            if (dishes.size()
                    == previousSize) {

                sameScrollCount++;

            } else {

                sameScrollCount =
                        0;
            }

            if (sameScrollCount >= 2) {

                System.out.println(
                        "No more recipes found.");

                break;
            }

            previousSize =
                    dishes.size();

            if (!scrollDashboard()) {

                System.out.println(
                        "Reached end of dashboard.");

                break;
            }

            try {

                Thread.sleep(
                        1500);

            } catch (InterruptedException e) {

                Thread.currentThread()
                        .interrupt();
            }
        }

        return dishes;
    }

        /*
     * Scroll Dashboard
     */
    private boolean scrollDashboard() {

        try {

            dashboardScrollView();

            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\"))"
                                    + ".scrollForward()"));

            System.out.println(
                    "Dashboard scrolled.");

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Unable to scroll dashboard.");

            return false;
        }
    }
}