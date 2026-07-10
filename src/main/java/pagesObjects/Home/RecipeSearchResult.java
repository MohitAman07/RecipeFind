package pagesObjects.Home;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecipeSearchResult {

    private AndroidDriver driver;

    public RecipeSearchResult(AndroidDriver driver) {

        this.driver = driver;
    }

    /*
     * Search Results Header
     */
    public boolean isSearchResultsHeaderVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ScrollView/android.view.View[1]"))
                .isEmpty();
    }

    public String getSearchResultsHeader() {

        return driver.findElement(
                AppiumBy.xpath(
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ScrollView/android.view.View[1]"))
                .getAttribute("contentDescription");
    }

    /*
     * Results Text
     */
    public boolean isResultsTextVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ScrollView/android.view.View[2]"))
                .isEmpty();
    }

    public String getResultsText() {

        return driver.findElement(
                AppiumBy.xpath(
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ScrollView/android.view.View[2]"))
                .getAttribute("contentDescription");
    }

    /*
     * Community Tab
     */
    public boolean isCommunityTabVisible() {

        List<WebElement> tabs =
                driver.findElements(
                        AppiumBy.xpath(
                                "//*[contains(@content-desc,'Community')]"));

        System.out.println(
                "Community Tab Count : "
                        + tabs.size());

        return !tabs.isEmpty();
    }

    public void clickCommunityTab() {

        driver.findElement(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'Community')]"))
                .click();

        System.out.println(
                "Community tab clicked.");
    }

    /*
     * AI Generated Tab
     */
        public boolean isAIGeneratedTabVisible() {

        if (!driver.findElements(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'AI Generated')]"))
                .isEmpty()) {

            return true;
        }

        scrollToTop();

        return !driver.findElements(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'AI Generated')]"))
                .isEmpty();
    }

    public void clickAIGeneratedTab() {

        driver.findElement(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'AI Generated')]"))
                .click();

        System.out.println(
                "AI Generated tab clicked.");
    }

        /*
 * Fetch all Community Recipe Cards
 */
public Set<String> getAllCommunityResults() {

    Set<String> recipes =
            new LinkedHashSet<>();

    int sameScrollCount = 0;
    int previousSize = 0;

    while (true) {

        List<WebElement> cards =
                driver.findElements(
                        AppiumBy.xpath(
                                "//android.widget.ScrollView//android.widget.ImageView"));

        System.out.println(
                "Visible Community Cards : "
                        + cards.size());

        for (WebElement card : cards) {

            String contentDesc =
                    card.getAttribute(
                            "contentDescription");

            if (contentDesc == null
                    || contentDesc.trim().isEmpty()) {

                continue;
            }

            String value =
                    contentDesc.trim();

            /*
             * Skip tabs and non-recipe cards
             */
            if (value.contains("Tab")
                    || !value.contains("by ")) {

                continue;
            }

            /*
             * Add only unique recipes
             */
            if (recipes.add(value)) {

                System.out.println(
                        "Visible Community Recipe Card :");

                System.out.println(value);

                System.out.println(
                        "------------------------------------------------");
            }
        }

        System.out.println(
                "Total unique community recipes fetched : "
                        + recipes.size());

        /*
         * Stop if no new recipes found
         */
        if (recipes.size() == previousSize) {

            sameScrollCount++;
        }
        else {

            sameScrollCount = 0;
        }

        if (sameScrollCount >= 2) {

            System.out.println(
                    "No new community recipes found.");

            break;
        }

        previousSize = recipes.size();

        boolean scrolled =
                scrollCommunityResults();

        if (!scrolled) {

            System.out.println(
                    "Reached end of community results.");

            break;
        }

        try {

            Thread.sleep(2000);
        }
        catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }

    return recipes;
}

        /*
 * Scroll Community Results
 */
private boolean scrollCommunityResults() {

    try {

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable("
                                + "new UiSelector().scrollable(true))"
                                + ".scrollForward()"));

        System.out.println(
                "Community results scrolled.");

        return true;
    }
    catch (Exception e) {

        return false;
    }
}
        /*
    * AI Generation Failure
    */
    public boolean isAIGenerationFailed() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'Failed to generate recipes')]"))
                .isEmpty();
    }

    public String getAIGenerationFailureMessage() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'Failed to generate recipes')]"))
                .getAttribute(
                        "contentDescription");
    }

   /*
 * Fetch all AI Generated Recipe Cards
 */
public Set<String> getAllAIGeneratedResults()
        throws InterruptedException {

    Set<String> recipes =
            new LinkedHashSet<>();

    /*
     * Wait for AI generation
     */
    for (int wait = 1; wait <= 30; wait++) {

        /*
         * Failure scenario
         */
        if (isAIGenerationFailed()) {

            System.out.println(
                    "AI Generation Failed : "
                            + getAIGenerationFailureMessage());

            return recipes;
        }

                List<WebElement> cards =
                driver.findElements(
                        AppiumBy.xpath(
                                "/hierarchy/android.widget.FrameLayout"
                                + "/android.widget.LinearLayout"
                                + "/android.widget.FrameLayout"
                                + "/android.widget.FrameLayout"
                                + "/android.view.View"
                                + "/android.view.View"
                                + "/android.view.View"
                                + "/android.view.View"
                                + "/android.view.View[1]"
                                + "/android.view.View"
                                + "/android.widget.ScrollView"
                                + "/android.view.View[5]"
                                + "/android.view.View"
                                + "/android.view.View"));

                        System.out.println(
                        "Visible AI Recipe Cards : "
                        + cards.size());

                boolean aiRecipeFound = false;

                for (WebElement card : cards) {

        String value =
                card.getAttribute(
                        "contentDescription");

        if (value == null
                || value.trim().isEmpty()) {

                continue;
        }

        value = value.trim();

        /*
        * Skip static texts
        */
        if (value.equals("Search Results")
                || value.startsWith("Results for")
                || value.contains("Tab")
                || value.contains("Community-shared")
                || value.contains("AI-generated recipe suggestions")
                || value.contains("Failed to generate recipes")) {

                continue;
        }

        /*
        * Actual AI Recipe Card
        */
        recipes.add(value);

        System.out.println(
                "Visible AI Recipe Card :");

        System.out.println(value);

        System.out.println(
                "------------------------------------------------");

        aiRecipeFound = true;
        }

        /*
         * AI recipes found
         */
        if (aiRecipeFound) {

            int sameScrollCount = 0;
            int previousSize = recipes.size();

            while (true) {

                /*
                 * Stop if no new recipes found
                 */
                if (recipes.size() == previousSize) {

                    sameScrollCount++;
                }
                else {

                    sameScrollCount = 0;
                }

                if (sameScrollCount >= 2) {

                    System.out.println(
                            "No new AI recipes found.");

                    break;
                }

                previousSize = recipes.size();

                boolean scrolled =
                        scrollAIResults();

                if (!scrolled) {

                    System.out.println(
                            "Reached end of AI recipes.");

                    break;
                }

                Thread.sleep(2000);

                cards =
                        driver.findElements(
                                AppiumBy.xpath(
                                        "//android.widget.ScrollView//android.view.View"));

                System.out.println(
                        "Visible AI Cards : "
                                + cards.size());

                for (WebElement card : cards) {

                    String contentDesc =
                            card.getAttribute(
                                    "contentDescription");

                    if (contentDesc == null
                            || contentDesc.trim().isEmpty()) {

                        continue;
                    }

                    String value =
                            contentDesc.trim();

                    if (value.equals("Search Results")
                            || value.startsWith("Results for")
                            || value.contains("Tab")
                            || value.contains("Community-shared")
                            || value.contains("AI-generated recipe suggestions")
                            || value.contains("Failed to generate recipes")) {

                        continue;
                    }

                    if (value.length() > 30) {

                        recipes.add(value);

                        System.out.println(
                                "Visible AI Recipe : ");

                        System.out.println(value);

                        System.out.println(
                                "------------------------------------------------");
                    }
                }

                System.out.println(
                        "Total unique AI recipes fetched : "
                                + recipes.size());
            }

            return recipes;
        }

        System.out.println(
                "Waiting for AI recipes... "
                        + wait);

        Thread.sleep(3000);
    }

    return recipes;
}

        /*
        * Scroll AI Results
        */
        private boolean scrollAIResults() {

        try {

                driver.findElement(
                        AppiumBy.androidUIAutomator(
                                "new UiScrollable("
                                        + "new UiSelector().scrollable(true))"
                                        + ".scrollForward()"));

                System.out.println(
                        "AI results scrolled.");

                return true;
        }
        catch (Exception e) {

                return false;
        }
        }

    // /*
    //  * Fetch AI Generated Results
    //  */
    // public Set<String> getAllAIGeneratedResults() {

    //     Set<String> recipes =
    //             new LinkedHashSet<>();

    //     int sameScrollCount = 0;
    //     int previousSize = 0;

    //     while (sameScrollCount < 3) {

    //         List<WebElement> cards =
    //                 driver.findElements(
    //                         AppiumBy.xpath(
    //                                 "//android.widget.ScrollView//android.view.View"));

    //         for (WebElement card : cards) {

    //             String contentDesc =
    //                     card.getAttribute(
    //                             "contentDescription");

    //             if (contentDesc != null
    //                     && !contentDesc.trim().isEmpty()) {

    //                 String value =
    //                         contentDesc.trim();

    //                 /*
    //                  * Skip static texts and headers
    //                  */
    //                 if (!value.equals("Search Results")
    //                         && !value.startsWith("Results for")
    //                         && !value.contains("Tab")
    //                         && !value.contains("Community-shared")
    //                         && !value.contains("AI-generated recipe suggestions")
    //                         && value.length() > 30) {

    //                     recipes.add(value);
    //                 }
    //             }
    //         }

    //         System.out.println(
    //                 "AI Generated recipes fetched : "
    //                         + recipes.size());

    //         if (recipes.size() == previousSize) {

    //             sameScrollCount++;
    //         }
    //         else {

    //             sameScrollCount = 0;
    //         }

    //         previousSize = recipes.size();

    //         scrollResults();
    //     }

    //     return recipes;
    // }
    

    // /*
    //  * Debug Visible Content Descriptions
    //  */
    // public void printVisibleContentDescriptions() {

    //     System.out.println(
    //             "========== Visible Elements ==========");

    //     List<WebElement> elements =
    //             driver.findElements(
    //                     AppiumBy.xpath("//*"));

    //     for (WebElement element : elements) {

    //         String desc =
    //                 element.getAttribute(
    //                         "contentDescription");

    //         String clazz =
    //                 element.getAttribute(
    //                         "className");

    //         System.out.println(
    //                 "Class : " + clazz);

    //         System.out.println(
    //                 "Content Desc : " + desc);

    //         System.out.println(
    //                 "------------------------------------------------");
    //     }

    //     System.out.println(
    //             "=======================================");
    // }


    public void scrollToTop() {

    driver.executeScript(
            "mobile: scrollGesture",
            Map.of(
                    "left", 0,
                    "top", 259,
                    "width", 1080,
                    "height", 1769,
                    "direction", "up",
                    "percent", 3.0
            ));

    System.out.println(
            "Scrolled back to top.");
}
}