package pagesObjects.Contribute.MyRecipiesDashboard;

import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import utils.WaitUtil;

public class NutritionFactsPage {

    private final AndroidDriver driver;

    private final WaitUtil waitUtil;

    /*
     * Maximum number of scrolls
     */
    private static final int MAX_SCROLLS =
            20;

    /*
     * Allergen Ingredient Mapping
     */
    private static final Map<String, List<String>> ALLERGEN_MAP =
            new LinkedHashMap<>();

    static {

        /*
         * Milk
         */
        ALLERGEN_MAP.put(
                "MILK",
                Arrays.asList(
                        "milk",
                        "dairy",
                        "cheese",
                        "cheeses",
                        "cream",
                        "creams",
                        "yogurt",
                        "yogurts",
                        "yoghurt",
                        "yoghurts",
                        "whey",
                        "custard",
                        "butter",
                        "buttermilk",
                        "milkshake",
                        "milkshakes",
                        "milkfat",
                        "milk chocolate",
                        "milkchocolate",
                        "milka",
                        "caramilk",
                        "grassmilk",
                        "cheesecake",
                        "cheesecakes",
                        "cheeseburger",
                        "cheeseburgers",
                        "cheeseburgerito",
                        "cheesesteak",
                        "cheeseball",
                        "cheeseballs",
                        "cheesebar",
                        "cheeseboard",
                        "cheesecorn",
                        "cheesecrisp",
                        "cheesecrisps",
                        "cheesestick",
                        "cheesesticks",
                        "creamcheese",
                        "creamcheesespread",
                        "headcheese",
                        "jackcheese",
                        "threecheese"));

        /*
         * Fish
         */
        ALLERGEN_MAP.put(
                "FISH",
                Arrays.asList(
                        "fish",
                        "salmon",
                        "tuna",
                        "cod",
                        "anchovy",
                        "anchovies",
                        "tilapia",
                        "halibut",
                        "sardine",
                        "sardines",
                        "catfish",
                        "codfish",
                        "cuttlefish",
                        "filefish",
                        "finfish",
                        "fishcake",
                        "hogfish",
                        "kingfish",
                        "lumpfish",
                        "milkfish",
                        "paddlefish",
                        "redfish",
                        "rockfish",
                        "sailfish",
                        "stockfish",
                        "sunfish",
                        "swordfish"));

        /*
         * Wheat
         */
        ALLERGEN_MAP.put(
                "WHEAT",
                Arrays.asList(
                        "wheat",
                        "flour",
                        "bread",
                        "cracker",
                        "crackers",
                        "pasta",
                        "semolina",
                        "wheatberry",
                        "wheatena",
                        "wheatfuls",
                        "wheatgrass",
                        "wheats",
                        "wheatsnacks",
                        "wheatsoba",
                        "wholewheat",
                        "wheaties",
                        "greenwheat"));

        /*
         * Sesame
         */
        ALLERGEN_MAP.put(
                "SESAME",
                Arrays.asList(
                        "sesame",
                        "tahini"));

        /*
         * Crustacean
         */
        ALLERGEN_MAP.put(
                "CRUSTACEAN",
                Arrays.asList(
                        "shrimp",
                        "shrimps",
                        "crab",
                        "crabs",
                        "lobster",
                        "prawn",
                        "prawns",
                        "crawfish",
                        "crayfish",
                        "crustacean",
                        "crabcake",
                        "crabcakes",
                        "crabmeat",
                        "crabstick",
                        "crabsticks",
                        "crabfries",
                        "shrimped",
                        "shrimpmeat"));

        /*
         * Shellfish
         */
        ALLERGEN_MAP.put(
                "SHELLFISH",
                Arrays.asList(
                        "shellfish",
                        "shrimp",
                        "shrimps",
                        "crab",
                        "crabs",
                        "lobster",
                        "prawn",
                        "prawns",
                        "crawfish",
                        "crayfish",
                        "crustacean",
                        "oyster",
                        "oysters",
                        "octopus",
                        "octopuses",
                        "mussel",
                        "mussels"));

        /*
         * Peanut
         */
        ALLERGEN_MAP.put(
                "PEANUT",
                Arrays.asList(
                        "peanut",
                        "peanuts",
                        "peanutbutter",
                        "peanutty",
                        "peanuty"));

        /*
         * Soybean
         */
        ALLERGEN_MAP.put(
                "SOYBEAN",
                Arrays.asList(
                        "soy",
                        "soya",
                        "soybean",
                        "soybeans",
                        "edamame",
                        "tofu",
                        "soysauce",
                        "soyburger",
                        "soyburgers",
                        "soybutter",
                        "soyabean",
                        "soyaki",
                        "soyrizo"));

        /*
         * Tree Nut
         */
        ALLERGEN_MAP.put(
                "TREE NUT",
                Arrays.asList(
                        "almond",
                        "almonds",
                        "walnut",
                        "walnuts",
                        "cashew",
                        "cashews",
                        "pecan",
                        "pecans",
                        "hazelnut",
                        "hazelnuts",
                        "pistachio",
                        "pistachios",
                        "macadamia",
                        "macadamias",
                        "brazil nut",
                        "brazil nuts",
                        "pine nut",
                        "pine nuts",
                        "tree nut",
                        "tree nuts",
                        "treenut",
                        "treenuts"));

        /*
         * Egg
         */
        ALLERGEN_MAP.put(
                "EGG",
                Arrays.asList(
                        "egg",
                        "eggs",
                        "eggnog",
                        "eggroll",
                        "eggrolls",
                        "eggo",
                        "eggwrap",
                        "eggwraps"));
    }

    public NutritionFactsPage(
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
     * Nutrition Facts Header
     */
    private String nutritionFactsHeaderXPath() {

        return "(//android.widget.ScrollView/android.view.View[@content-desc='Nutrition Facts'])[2]";
    }

    /*
     * Recipe Name With Servings
     */
    private String recipeNameWithServingsXPath(
            String recipeName,
            String servings) {

        return "//android.view.View[@content-desc='"
                + recipeName
                + " Recipe for "
                + servings
                + " servings']";
    }

    /*
     * Serving Size
     */
    private String servingSizeXPath() {

        return "//android.view.View[normalize-space(@content-desc)='Serving Size']";
    }

    /*
     * Calories
     */
    private String caloriesXPath() {

        return "//android.view.View[normalize-space(@content-desc)='Calories']";
    }

    /*
     * Total Fat
     */
    private String totalFatXPath() {

        return "//android.view.View[normalize-space(@content-desc)='Total Fat']";
    }

    /*
     * Saturated Fat
     */
    private String saturatedFatXPath() {

        return "//android.view.View[normalize-space(@content-desc)='Saturated Fat']";
    }

    /*
     * Trans Fat
     */
    private String transFatXPath() {

        return "//android.view.View[normalize-space(@content-desc)='Trans Fat']";
    }

    /*
     * Cholesterol
     */
    private String cholesterolXPath() {

        return "//android.view.View[normalize-space(@content-desc)='Cholesterol']";
    }

    /*
     * Sodium
     */
    private String sodiumXPath() {

        return "//android.view.View[normalize-space(@content-desc)='Sodium']";
    }

    /*
     * Total Carbohydrate
     */
    private String totalCarbohydrateXPath() {

        return "//android.view.View[normalize-space(@content-desc)='Total Carbohydrate']";
    }

    /*
     * Dietary Fiber
     */
    private String dietaryFiberXPath() {

        return "//android.view.View[normalize-space(@content-desc)='Dietary Fiber']";
    }

    /*
     * Total Sugars
     */
    private String totalSugarsXPath() {

        return "//android.view.View[normalize-space(@content-desc)='Total Sugars']";
    }

    /*
     * Added Sugars
     */
    private String addedSugarsXPath() {

        return "//android.view.View[normalize-space(@content-desc)='Added Sugars']";
    }

    /*
     * Protein
     */
    private String proteinXPath() {

        return "//android.view.View[normalize-space(@content-desc)='Protein']";
    }

    /*
     * Ingredients
     */
    private String ingredientsXPath() {

        return "//android.view.View[starts-with(@content-desc,'INGREDIENTS:')]";
    }

    /*
     * Contains / Allergens
     */
    private String containsXPath() {

        return "//android.view.View[starts-with(@content-desc,'CONTAINS:')]";
    }

    /*
     * Check Element Displayed
     */
    private boolean isElementDisplayed(
            WebElement element) {

        try {

            return element != null
                    && element.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Scroll Down
     *
     * Small controlled swipe.
     *
     * Start : 65%
     * End   : 35%
     */
    private void scrollDown() {

        Dimension size =
                driver.manage()
                        .window()
                        .getSize();

        int startX =
                size.width / 2;

        int startY =
                (int) (size.height * 0.65);

        int endY =
                (int) (size.height * 0.35);

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
                                500),
                        PointerInput.Origin.viewport(),
                        startX,
                        endY));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(
                Arrays.asList(
                        swipe));

        waitUtil.sleep(
                1200);

        System.out.println(
                "Nutrition Facts small scroll performed.");
    }

    /*
     * Scroll To Element
     *
     * Re-finds the element after every
     * scroll because the Flutter UI can
     * rebuild the ScrollView elements.
     */
    private boolean scrollToElement(
            String xpath,
            String elementName) {

        for (int scrollCount = 0;
                scrollCount < MAX_SCROLLS;
                scrollCount++) {

            try {

                List<WebElement> elements =
                        driver.findElements(
                                AppiumBy.xpath(
                                        xpath));

                for (WebElement element :
                        elements) {

                    try {

                        if (element.isDisplayed()) {

                            System.out.println(
                                    elementName
                                            + " is visible after "
                                            + scrollCount
                                            + " scroll(s).");

                            return true;
                        }

                    } catch (Exception e) {

                        System.out.println(
                                elementName
                                        + " element became stale. Rechecking.");
                    }
                }

            } catch (Exception e) {

                System.out.println(
                        "Unable to locate "
                                + elementName
                                + " at current position.");
            }

            /*
             * Target is still hidden.
             */
            System.out.println(
                    elementName
                            + " is still hidden. Performing scroll "
                            + (scrollCount + 1));

            scrollDown();
        }

        System.out.println(
                elementName
                        + " could not be made visible after "
                        + MAX_SCROLLS
                        + " scrolls.");

        return false;
    }

    /*
     * Nutrition Facts Header
     */
    public boolean isNutritionFactsDisplayed() {

        try {

            return scrollToElement(
                    nutritionFactsHeaderXPath(),
                    "Nutrition Facts");

        } catch (Exception e) {

            System.out.println(
                    "Unable to verify Nutrition Facts header.");

            return false;
        }
    }

    /*
     * Get Nutrition Facts Header
     */
    public String getNutritionFactsText() {

        try {

            if (!isNutritionFactsDisplayed()) {

                return "";
            }

            List<WebElement> elements =
                    driver.findElements(
                            AppiumBy.xpath(
                                    nutritionFactsHeaderXPath()));

            for (WebElement element :
                    elements) {

                if (isElementDisplayed(
                        element)) {

                    String text =
                            element.getAttribute(
                                    "content-desc");

                    System.out.println(
                            "Nutrition Facts Header : "
                                    + text);

                    return text;
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Unable to get Nutrition Facts header.");
        }

        return "";
    }

    /*
     * Recipe Name With Servings
     */
    public boolean isRecipeNameWithServingsDisplayed(
            String recipeName,
            String servings) {

        return scrollToElement(
                recipeNameWithServingsXPath(
                        recipeName,
                        servings),
                "Recipe Name With Servings");
    }

    /*
     * Get Recipe Name With Servings
     */
    public String getRecipeNameWithServingsText(
            String recipeName,
            String servings) {

        try {

            if (!isRecipeNameWithServingsDisplayed(
                    recipeName,
                    servings)) {

                return "";
            }

            WebElement element =
                    driver.findElement(
                            AppiumBy.xpath(
                                    recipeNameWithServingsXPath(
                                            recipeName,
                                            servings)));

            String text =
                    element.getAttribute(
                            "content-desc");

            System.out.println(
                    "Recipe Name With Servings : "
                            + text);

            return text;

        } catch (Exception e) {

            return "";
        }
    }

    /*
     * Serving Size
     */
    public boolean isServingSizeDisplayed() {

        return scrollToElement(
                servingSizeXPath(),
                "Serving Size");
    }

    /*
     * Calories
     */
    public boolean isCaloriesDisplayed() {

        return scrollToElement(
                caloriesXPath(),
                "Calories");
    }

    /*
     * Total Fat
     */
    public boolean isTotalFatDisplayed() {

        return scrollToElement(
                totalFatXPath(),
                "Total Fat");
    }

    /*
     * Saturated Fat
     */
    public boolean isSaturatedFatDisplayed() {

        return scrollToElement(
                saturatedFatXPath(),
                "Saturated Fat");
    }

    /*
     * Trans Fat
     */
    public boolean isTransFatDisplayed() {

        return scrollToElement(
                transFatXPath(),
                "Trans Fat");
    }

    /*
     * Cholesterol
     */
    public boolean isCholesterolDisplayed() {

        return scrollToElement(
                cholesterolXPath(),
                "Cholesterol");
    }

    /*
     * Sodium
     */
    public boolean isSodiumDisplayed() {

        return scrollToElement(
                sodiumXPath(),
                "Sodium");
    }

    /*
     * Total Carbohydrate
     */
    public boolean isTotalCarbohydrateDisplayed() {

        return scrollToElement(
                totalCarbohydrateXPath(),
                "Total Carbohydrate");
    }

    /*
     * Dietary Fiber
     */
    public boolean isDietaryFiberDisplayed() {

        return scrollToElement(
                dietaryFiberXPath(),
                "Dietary Fiber");
    }

    /*
     * Total Sugars
     */
    public boolean isTotalSugarsDisplayed() {

        return scrollToElement(
                totalSugarsXPath(),
                "Total Sugars");
    }

    /*
     * Added Sugars
     */
    public boolean isAddedSugarsDisplayed() {

        return scrollToElement(
                addedSugarsXPath(),
                "Added Sugars");
    }

    /*
     * Protein
     */
    public boolean isProteinDisplayed() {

        return scrollToElement(
                proteinXPath(),
                "Protein");
    }

    /*
     * Ingredients
     */
    public boolean isIngredientsDisplayed() {

        return scrollToElement(
                ingredientsXPath(),
                "Ingredients");
    }

    /*
     * Contains / Allergens
     */
    public boolean isContainsDisplayed() {

        return scrollToElement(
                containsXPath(),
                "Contains / Allergens");
    }

    /*
     * Get Nutrition Value
     *
     * The value is the next android.view.View
     * after the nutrition label.
     */
    private String getNutritionValue(
            String labelXPath,
            String labelName) {

        try {

            if (!scrollToElement(
                    labelXPath,
                    labelName)) {

                return "";
            }

            WebElement value =
                    driver.findElement(
                            AppiumBy.xpath(
                                    labelXPath
                                            + "/following-sibling::android.view.View[1]"));

            String text =
                    value.getAttribute(
                            "content-desc");

            System.out.println(
                    labelName
                            + " : "
                            + text);

            return text;

        } catch (Exception e) {

            System.out.println(
                    "Unable to get "
                            + labelName
                            + " value.");

            return "";
        }
    }

    /*
     * Get Serving Size Value
     */
    public String getServingSizeValue() {

        return getNutritionValue(
                servingSizeXPath(),
                "Serving Size");
    }

    /*
     * Get Calories Value
     */
    public String getCaloriesValue() {

        return getNutritionValue(
                caloriesXPath(),
                "Calories");
    }

    /*
     * Get Total Fat Value
     */
    public String getTotalFatValue() {

        return getNutritionValue(
                totalFatXPath(),
                "Total Fat");
    }

    /*
     * Get Saturated Fat Value
     */
    public String getSaturatedFatValue() {

        return getNutritionValue(
                saturatedFatXPath(),
                "Saturated Fat");
    }

    /*
     * Get Trans Fat Value
     */
    public String getTransFatValue() {

        return getNutritionValue(
                transFatXPath(),
                "Trans Fat");
    }

    /*
     * Get Cholesterol Value
     */
    public String getCholesterolValue() {

        return getNutritionValue(
                cholesterolXPath(),
                "Cholesterol");
    }

    /*
     * Get Sodium Value
     */
    public String getSodiumValue() {

        return getNutritionValue(
                sodiumXPath(),
                "Sodium");
    }

    /*
     * Get Total Carbohydrate Value
     */
    public String getTotalCarbohydrateValue() {

        return getNutritionValue(
                totalCarbohydrateXPath(),
                "Total Carbohydrate");
    }

    /*
     * Get Dietary Fiber Value
     */
    public String getDietaryFiberValue() {

        return getNutritionValue(
                dietaryFiberXPath(),
                "Dietary Fiber");
    }

    /*
     * Get Total Sugars Value
     */
    public String getTotalSugarsValue() {

        return getNutritionValue(
                totalSugarsXPath(),
                "Total Sugars");
    }

    /*
     * Get Added Sugars Value
     */
    public String getAddedSugarsValue() {

        return getNutritionValue(
                addedSugarsXPath(),
                "Added Sugars");
    }

    /*
     * Get Protein Value
     */
    public String getProteinValue() {

        return getNutritionValue(
                proteinXPath(),
                "Protein");
    }

    /*
     * Get Current Ingredients
     */
    public String getCurrentIngredients() {

        try {

            if (!scrollToElement(
                    ingredientsXPath(),
                    "Ingredients")) {

                return "";
            }

            WebElement element =
                    driver.findElement(
                            AppiumBy.xpath(
                                    ingredientsXPath()));

            String ingredients =
                    element.getAttribute(
                            "content-desc");

            System.out.println(
                    "Current Nutrition Facts Ingredients : "
                            + ingredients);

            return ingredients;

        } catch (Exception e) {

            System.out.println(
                    "Unable to get Nutrition Facts ingredients.");

            return "";
        }
    }

    /*
     * Verify Ingredients Are Populated
     */
    public boolean isIngredientsPopulated() {

        try {

            String ingredients =
                    getCurrentIngredients();

            return ingredients != null
                    && !ingredients.trim().isEmpty()
                    && ingredients
                            .toUpperCase()
                            .startsWith(
                                    "INGREDIENTS:");

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Current Contains / Allergens
     */
    public String getCurrentContainsAllergens() {

        try {

            if (!scrollToElement(
                    containsXPath(),
                    "Contains / Allergens")) {

                return "";
            }

            WebElement element =
                    driver.findElement(
                            AppiumBy.xpath(
                                    containsXPath()));

            String contains =
                    element.getAttribute(
                            "content-desc");

            System.out.println(
                    "Actual Populated Allergens : "
                            + contains);

            return contains;

        } catch (Exception e) {

            System.out.println(
                    "Unable to get Nutrition Facts allergens.");

            return "";
        }
    }

    /*
     * Verify Allergens Are Populated
     */
    public boolean areAllergensPopulated() {

        try {

            String allergens =
                    getCurrentContainsAllergens();

            return allergens != null
                    && !allergens.trim().isEmpty()
                    && allergens
                            .toUpperCase()
                            .startsWith(
                                    "CONTAINS:")
                    && !allergens
                            .trim()
                            .equalsIgnoreCase(
                                    "CONTAINS:");

        } catch (Exception e) {

            return false;
        }
    }

    /*
     * Normalize Ingredient
     */
    private String normalizeIngredient(
            String ingredient) {

        if (ingredient == null) {

            return "";
        }

        return ingredient
                .toLowerCase()
                .replaceAll(
                        "\\s+",
                        " ")
                .trim();
    }

    /*
     * Check Allergen Match
     */
    private boolean isAllergenMatched(
            String ingredient,
            String allergenWord) {

        String normalizedIngredient =
                normalizeIngredient(
                        ingredient);

        String normalizedWord =
                normalizeIngredient(
                        allergenWord);

        if (normalizedIngredient.isEmpty()
                || normalizedWord.isEmpty()) {

            return false;
        }

        /*
         * Multi-word allergen
         */
        if (normalizedWord.contains(" ")) {

            return normalizedIngredient
                    .contains(
                            normalizedWord);
        }

        /*
         * Single-word allergen
         */
        String[] ingredientWords =
                normalizedIngredient.split(
                        "\\s+");

        for (String word :
                ingredientWords) {

            if (word.equals(
                    normalizedWord)) {

                return true;
            }
        }

        return false;
    }

    /*
     * Get Expected Allergens
     *
     * Expected allergens are dynamically
     * calculated from the current
     * Nutrition Facts ingredients.
     */
    public String getExpectedAllergens(
            String currentIngredients) {

        if (currentIngredients == null
                || currentIngredients.trim().isEmpty()) {

            return "CONTAINS:";
        }

        String ingredientText =
                currentIngredients
                        .replaceFirst(
                                "(?i)^INGREDIENTS:\\s*",
                                "")
                        .trim();

        if (ingredientText.isEmpty()) {

            return "CONTAINS:";
        }

        String[] ingredients =
                ingredientText.split(
                        "\\s*;\\s*");

        Set<String> expectedAllergens =
                new LinkedHashSet<>();

        /*
         * Iterate through allergen mapping
         * in fixed order.
         */
        for (Map.Entry<String, List<String>> entry :
                ALLERGEN_MAP.entrySet()) {

            String allergen =
                    entry.getKey();

            List<String> matchingWords =
                    entry.getValue();

            boolean matched =
                    false;

            for (String ingredient :
                    ingredients) {

                for (String allergenWord :
                        matchingWords) {

                    if (isAllergenMatched(
                            ingredient,
                            allergenWord)) {

                        expectedAllergens.add(
                                allergen);

                        matched = true;

                        break;
                    }
                }

                if (matched) {

                    break;
                }
            }
        }

        String expected =
                "CONTAINS: "
                        + String.join(
                                ", ",
                                expectedAllergens);

        System.out.println(
                "Expected Allergens : "
                        + expected);

        return expected;
    }

    // /*
    //  * Verify Allergens Are Populated Correctly
    //  */
    // public boolean verifyAllergensArePopulatedCorrectly() {

    //     try {

    //         String currentIngredients =
    //                 getCurrentIngredients();

    //         if (currentIngredients == null
    //                 || currentIngredients.isEmpty()) {

    //             System.out.println(
    //                     "Unable to verify allergens because ingredients are empty.");

    //             return false;
    //         }

    //         String expectedAllergens =
    //                 getExpectedAllergens(
    //                         currentIngredients);

    //         String actualAllergens =
    //                 getCurrentContainsAllergens();

    //         if (actualAllergens == null
    //                 || actualAllergens.isEmpty()) {

    //             System.out.println(
    //                     "Actual allergens are empty.");

    //             return false;
    //         }

    //         boolean result =
    //                 expectedAllergens
    //                         .equalsIgnoreCase(
    //                                 actualAllergens
    //                                         .trim());

    //         System.out.println(
    //                 "Expected Allergens : "
    //                         + expectedAllergens);

    //         System.out.println(
    //                 "Actual Allergens : "
    //                         + actualAllergens);

    //         System.out.println(
    //                 "Allergen Validation Result : "
    //                         + result);

    //         return result;

    //     } catch (Exception e) {

    //         System.out.println(
    //                 "Unable to verify Nutrition Facts allergens.");

    //         return false;
    //     }
    // }

    /*
 * Verify Allergens Are Populated Correctly
 *
 * Allergen order is ignored.
 */
public boolean verifyAllergensArePopulatedCorrectly() {

    try {

        String currentIngredients =
                getCurrentIngredients();

        if (currentIngredients == null
                || currentIngredients.isEmpty()) {

            System.out.println(
                    "Unable to verify allergens because ingredients are empty.");

            return false;
        }

        String expectedAllergens =
                getExpectedAllergens(
                        currentIngredients);

        String actualAllergens =
                getCurrentContainsAllergens();

        if (actualAllergens == null
                || actualAllergens.isEmpty()
                || actualAllergens
                        .trim()
                        .equalsIgnoreCase(
                                "CONTAINS:")) {

            System.out.println(
                    "Actual allergens are empty.");

            return false;
        }

        /*
         * Convert Expected Allergens
         * Into a Set.
         */
        Set<String> expectedSet =
                convertAllergensToSet(
                        expectedAllergens);

        /*
         * Convert Actual Allergens
         * Into a Set.
         */
        Set<String> actualSet =
                convertAllergensToSet(
                        actualAllergens);

        /*
         * Compare Sets.
         *
         * Order is ignored.
         */
        boolean result =
                expectedSet.equals(
                        actualSet);

        System.out.println(
                "Expected Allergens : "
                        + expectedAllergens);

        System.out.println(
                "Actual Allergens : "
                        + actualAllergens);

        System.out.println(
                "Expected Allergen Set : "
                        + expectedSet);

        System.out.println(
                "Actual Allergen Set : "
                        + actualSet);

        System.out.println(
                "Allergen Order Ignored : true");

        System.out.println(
                "Allergen Validation Result : "
                        + result);

        return result;

    } catch (Exception e) {

        System.out.println(
                "Unable to verify Nutrition Facts allergens.");

        System.out.println(
                "Reason : "
                        + e.getMessage());

        return false;
    }
}

/*
 * Convert Allergens String Into Set
 *
 * Order is intentionally ignored.
 */
private Set<String> convertAllergensToSet(
        String allergensText) {

    Set<String> allergenSet =
            new LinkedHashSet<>();

    if (allergensText == null
            || allergensText.trim().isEmpty()) {

        return allergenSet;
    }

    String allergenText =
            allergensText
                    .replaceFirst(
                            "(?i)^CONTAINS:\\s*",
                            "")
                    .trim();

    if (allergenText.isEmpty()) {

        return allergenSet;
    }

    String[] allergens =
            allergenText.split(
                    "\\s*,\\s*");

    for (String allergen :
            allergens) {

        String normalizedAllergen =
                allergen
                        .trim()
                        .replaceAll(
                                "\\s+",
                                " ")
                        .toUpperCase();

        if (!normalizedAllergen.isEmpty()) {

            allergenSet.add(
                    normalizedAllergen);
        }
    }

    return allergenSet;
}

    /*
     * Verify All Nutrition Values
     */
    public boolean verifyAllNutritionValues() {

        try {

            System.out.println(
                    "==================================================");

            System.out.println(
                    "Starting Nutrition Values Validation");

            if (!isServingSizeDisplayed()
                    || getServingSizeValue().isEmpty()) {

                System.out.println(
                        "Serving Size validation failed.");

                return false;
            }

            if (!isCaloriesDisplayed()
                    || getCaloriesValue().isEmpty()) {

                System.out.println(
                        "Calories validation failed.");

                return false;
            }

            if (!isTotalFatDisplayed()
                    || getTotalFatValue().isEmpty()) {

                System.out.println(
                        "Total Fat validation failed.");

                return false;
            }

            if (!isSaturatedFatDisplayed()
                    || getSaturatedFatValue().isEmpty()) {

                System.out.println(
                        "Saturated Fat validation failed.");

                return false;
            }

            if (!isTransFatDisplayed()
                    || getTransFatValue().isEmpty()) {

                System.out.println(
                        "Trans Fat validation failed.");

                return false;
            }

            if (!isCholesterolDisplayed()
                    || getCholesterolValue().isEmpty()) {

                System.out.println(
                        "Cholesterol validation failed.");

                return false;
            }

            if (!isSodiumDisplayed()
                    || getSodiumValue().isEmpty()) {

                System.out.println(
                        "Sodium validation failed.");

                return false;
            }

            if (!isTotalCarbohydrateDisplayed()
                    || getTotalCarbohydrateValue().isEmpty()) {

                System.out.println(
                        "Total Carbohydrate validation failed.");

                return false;
            }

            if (!isDietaryFiberDisplayed()
                    || getDietaryFiberValue().isEmpty()) {

                System.out.println(
                        "Dietary Fiber validation failed.");

                return false;
            }

            if (!isTotalSugarsDisplayed()
                    || getTotalSugarsValue().isEmpty()) {

                System.out.println(
                        "Total Sugars validation failed.");

                return false;
            }

            if (!isAddedSugarsDisplayed()
                    || getAddedSugarsValue().isEmpty()) {

                System.out.println(
                        "Added Sugars validation failed.");

                return false;
            }

            if (!isProteinDisplayed()
                    || getProteinValue().isEmpty()) {

                System.out.println(
                        "Protein validation failed.");

                return false;
            }

            System.out.println(
                    "All Nutrition Values validated successfully.");

            System.out.println(
                    "==================================================");

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Nutrition Values validation failed.");

            System.out.println(
                    "Reason : "
                            + e.getMessage());

            return false;
        }
    }

//     /*
//      * Complete Nutrition Facts Validation
//      */
//     public boolean verifyCurrentNutritionFacts(
//             String recipeName,
//             String servings) {

//         try {

//             System.out.println(
//                     "==================================================");

//             System.out.println(
//                     "Starting Complete Nutrition Facts Validation");

//             /*
//              * Nutrition Facts Header
//              */
//             if (!isNutritionFactsDisplayed()) {

//                 System.out.println(
//                         "Nutrition Facts header validation failed.");

//                 return false;
//             }

//             /*
//              * Recipe Name With Servings
//              */
//             if (!isRecipeNameWithServingsDisplayed(
//                     recipeName,
//                     servings)) {

//                 System.out.println(
//                         "Recipe name with servings validation failed.");

//                 return false;
//             }

//             /*
//              * Nutrition Values
//              */
//             if (!verifyAllNutritionValues()) {

//                 System.out.println(
//                         "Nutrition values validation failed.");

//                 return false;
//             }

//             /*
//              * Ingredients
//              */
//             String currentIngredients =
//                     getCurrentIngredients();

//             if (currentIngredients == null
//                     || currentIngredients.isEmpty()) {

//                 System.out.println(
//                         "Nutrition Facts ingredients validation failed.");

//                 return false;
//             }

//             System.out.println(
//                     "Current Ingredients : "
//                             + currentIngredients);

//             /*
//              * Expected Allergens
//              */
//             String expectedAllergens =
//                     getExpectedAllergens(
//                             currentIngredients);

//             System.out.println(
//                     "Expected Allergens : "
//                             + expectedAllergens);

//             /*
//              * Actual Allergens
//              */
//             String currentAllergens =
//                     getCurrentContainsAllergens();

//             if (currentAllergens == null
//                     || currentAllergens.isEmpty()
//                     || currentAllergens
//                             .trim()
//                             .equalsIgnoreCase(
//                                     "CONTAINS:")) {

//                 System.out.println(
//                         "Nutrition Facts allergens validation failed.");

//                 return false;
//             }

//             System.out.println(
//                     "Actual Allergens : "
//                             + currentAllergens);

//             /*
//     * Compare Allergens
//     *
//     * Order is ignored.
//     */
//     Set<String> expectedAllergenSet =
//             convertAllergensToSet(
//                     expectedAllergens);

//     Set<String> actualAllergenSet =
//             convertAllergensToSet(
//                     currentAllergens);

//     if (!expectedAllergenSet.equals(
//             actualAllergenSet)) {

//         System.out.println(
//                 "Allergen validation failed.");

//         System.out.println(
//                 "Expected Allergen Set : "
//                         + expectedAllergenSet);

//         System.out.println(
//                 "Actual Allergen Set : "
//                         + actualAllergenSet);

//         return false;
//     }

//     System.out.println(
//             "Allergen validation passed. Order ignored.");


//             System.out.println(
//                     "Complete Nutrition Facts validation completed successfully.");

//             System.out.println(
//                     "==================================================");

//             return true;

//         } catch (Exception e) {

//             System.out.println(
//                     "Complete Nutrition Facts validation failed.");

//             System.out.println(
//                     "Reason : "
//                             + e.getMessage());

//             return false;
//         }
//     }


/*
 * Complete Nutrition Facts Validation
 */
public boolean verifyCurrentNutritionFacts(
        String recipeName,
        String servings) {

    try {

        System.out.println(
                "==================================================");

        System.out.println(
                "Starting Complete Nutrition Facts Validation");

        /*
         * Nutrition Facts Header
         */
        if (!isNutritionFactsDisplayed()) {

            System.out.println(
                    "Nutrition Facts header validation failed.");

            return false;
        }

        /*
         * Recipe Name With Servings
         */
        if (!isRecipeNameWithServingsDisplayed(
                recipeName,
                servings)) {

            System.out.println(
                    "Recipe name with servings validation failed.");

            return false;
        }

        /*
         * Nutrition Values
         */
        if (!verifyAllNutritionValues()) {

            System.out.println(
                    "Nutrition values validation failed.");

            return false;
        }

        /*
         * Ingredients
         */
        String currentIngredients =
                getCurrentIngredients();

        if (currentIngredients == null
                || currentIngredients.isEmpty()) {

            System.out.println(
                    "Nutrition Facts ingredients validation failed.");

            return false;
        }

        System.out.println(
                "Current Ingredients : "
                        + currentIngredients);

        /*
         * Expected Allergens
         */
        String expectedAllergens =
                getExpectedAllergens(
                        currentIngredients);

        System.out.println(
                "Expected Allergens : "
                        + expectedAllergens);

        /*
         * Contains / Allergens
         *
         * Contains section is conditional.
         *
         * If the recipe contains allergenic
         * ingredients, the Contains section
         * must be displayed and validated.
         *
         * If the recipe does not contain any
         * allergenic ingredients, the Contains
         * section is not required.
         */
        if (expectedAllergens == null
                || expectedAllergens
                        .trim()
                        .equalsIgnoreCase(
                                "CONTAINS:")) {

            System.out.println(
                    "No allergenic ingredients found.");

            System.out.println(
                    "Contains / Allergens section is not required.");

        } else {

            /*
             * Actual Allergens
             */
            String currentAllergens =
                    getCurrentContainsAllergens();

            if (currentAllergens == null
                    || currentAllergens.isEmpty()
                    || currentAllergens
                            .trim()
                            .equalsIgnoreCase(
                                    "CONTAINS:")) {

                System.out.println(
                        "Nutrition Facts allergens validation failed.");

                return false;
            }

            System.out.println(
                    "Actual Allergens : "
                            + currentAllergens);

            /*
             * Convert Expected Allergens
             * Into Set
             */
            Set<String> expectedAllergenSet =
                    convertAllergensToSet(
                            expectedAllergens);

            /*
             * Convert Actual Allergens
             * Into Set
             */
            Set<String> actualAllergenSet =
                    convertAllergensToSet(
                            currentAllergens);

            /*
             * Compare Allergens
             *
             * Order is ignored.
             */
            if (!expectedAllergenSet.equals(
                    actualAllergenSet)) {

                System.out.println(
                        "Allergen validation failed.");

                System.out.println(
                        "Expected Allergen Set : "
                                + expectedAllergenSet);

                System.out.println(
                        "Actual Allergen Set : "
                                + actualAllergenSet);

                return false;
            }

            System.out.println(
                    "Allergen validation passed. Order ignored.");
        }

        System.out.println(
                "Complete Nutrition Facts validation completed successfully.");

        System.out.println(
                "==================================================");

        return true;

    } catch (Exception e) {

        System.out.println(
                "Complete Nutrition Facts validation failed.");

        System.out.println(
                "Reason : "
                        + e.getMessage());

        return false;
    }
}

    /*
     * Existing Compatibility Method
     */
    public boolean verifyCurrentNutritionFacts() {

        try {

            /*
             * Header
             */
            if (!isNutritionFactsDisplayed()) {

                return false;
            }

            /*
             * Nutrition Values
             */
            if (!verifyAllNutritionValues()) {

                return false;
            }

            /*
             * Ingredients
             */
            String currentIngredients =
                    getCurrentIngredients();

            if (currentIngredients == null
                    || currentIngredients.isEmpty()) {

                return false;
            }

            /*
             * Allergens
             */
            String currentAllergens =
                    getCurrentContainsAllergens();

            if (currentAllergens == null
                    || currentAllergens.isEmpty()
                    || currentAllergens
                            .trim()
                            .equalsIgnoreCase(
                                    "CONTAINS:")) {

                return false;
            }

            /*
             * Compare Allergens
             */
            String expectedAllergens =
                    getExpectedAllergens(
                            currentIngredients);

            return expectedAllergens
                    .equalsIgnoreCase(
                            currentAllergens
                                    .trim());

        } catch (Exception e) {

            return false;
        }
    }
}