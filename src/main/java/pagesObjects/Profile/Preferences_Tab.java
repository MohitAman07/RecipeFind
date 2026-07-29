package pagesObjects.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.WaitUtil;

public class Preferences_Tab {

    private final AndroidDriver driver;

    private final WaitUtil waitUtil;

    /*
     * Religion Ingredient Mapping
     */
    private static final Map<String, List<String>> RELIGION_INCLUSION =
            new HashMap<>();

    private static final Map<String, List<String>> RELIGION_EXCLUSION =
            new HashMap<>();

    /*
     * Constructor
     */
    public Preferences_Tab(
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
     * ==========================================================
     * PREFERENCES TAB
     * ==========================================================
     */

    /*
     * Preferences Tab
     */
    private WebElement preferencesTab() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Preferences\nTab 3 of 4']"));
    }

    /*
     * Verify Preferences Tab
     */
    public boolean isPreferencesTabDisplayed() {

        try {

            return preferencesTab()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Preferences Tab
     */
    public void clickPreferencesTab() {

        waitUtil.clickWithWait(
                preferencesTab());

        waitUtil.sleep(
                1000);

        System.out.println(
                "Preferences Tab clicked.");
    }

        /*
     * ==========================================================
     * PREFERENCES SECTION
     * ==========================================================
     */

    /*
     * Preferences Section
     */
    private WebElement preferencesSection() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Dietary Preference\nReligion\nAllergies\nIngredient Inclusion\nIngredient Exclusion\nCustom Include\nCustom Exclude']"));
    }

    /*
     * Verify Preferences Section
     */
    public boolean isPreferencesSectionDisplayed() {

        try {

            return preferencesSection()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Preferences Details
     */
    public String getPreferencesDetails() {

        String details =
                preferencesSection()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Preferences Details :");

        System.out.println(
                details);

        return details;
    }

    /*
     * Get Preference Options
     */
    public List<String> getPreferenceOptions() {

        List<String> options =
                new ArrayList<>();

        String[] values =
                getPreferencesDetails()
                        .split(
                                "\\n");

        for (String value : values) {

            options.add(
                    value.trim());
        }

        return options;
    }

    /*
     * Verify Preference Option
     */
    public boolean isPreferenceOptionDisplayed(
            String option) {

        return getPreferenceOptions()
                .contains(
                        option);
    }

    /*
     * ==========================================================
     * PREFERENCE ACTION BUTTONS
     * ==========================================================
     */

    /*
     * Preference Add Button
     */
    private WebElement preferenceAddButton(
            int buttonIndex) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Dietary Preference\nReligion\nAllergies\nIngredient Inclusion\nIngredient Exclusion\nCustom Include\nCustom Exclude']"
                                + "/android.widget.Button["
                                + buttonIndex
                                + "]"));
    }

    /*
     * Verify Preference Add Button
     */
    public boolean isPreferenceAddButtonDisplayed(
            int buttonIndex) {

        try {

            return preferenceAddButton(
                    buttonIndex)
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Preference Add Button
     */
    public void clickPreferenceAddButton(
            int buttonIndex,
            String preferenceName) {

        waitUtil.clickWithWait(
                preferenceAddButton(
                        buttonIndex));

        waitUtil.sleep(
                1000);

        System.out.println(
                preferenceName
                        + " button clicked.");
    }

    /*
     * Click Dietary Preference
     */
    public void clickDietaryPreference() {

        clickPreferenceAddButton(
                1,
                "Dietary Preference");
    }

    /*
     * Click Religion
     */
    public void clickReligion() {

        clickPreferenceAddButton(
                2,
                "Religion");
    }

    /*
     * Click Allergies
     */
    public void clickAllergies() {

        clickPreferenceAddButton(
                3,
                "Allergies");
    }

    /*
     * Click Ingredient Inclusion
     */
    public void clickIngredientInclusion() {

        clickPreferenceAddButton(
                4,
                "Ingredient Inclusion");
    }

    /*
     * Click Ingredient Exclusion
     */
    public void clickIngredientExclusion() {

        clickPreferenceAddButton(
                5,
                "Ingredient Exclusion");
    }

    /*
     * Click Custom Include
     */
    public void clickCustomInclude() {

        clickPreferenceAddButton(
                6,
                "Custom Include");
    }

    /*
     * Click Custom Exclude
     */
    public void clickCustomExclude() {

        clickPreferenceAddButton(
                7,
                "Custom Exclude");
    }

    /*
     * Verify All Preference Buttons
     */
    public boolean areAllPreferenceButtonsDisplayed() {

        for (int i = 1; i <= 7; i++) {

            if (!isPreferenceAddButtonDisplayed(
                    i)) {

                return false;
            }
        }

        return true;
    }

        /*
     * ==========================================================
     * DIETARY PREFERENCE
     * ==========================================================
     */

    /*
     * Dietary Preference Option
     */
    private WebElement dietaryPreferenceOption(
            String dietaryPreference) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='"
                                + dietaryPreference
                                + "']"));
    }

    /*
     * Verify Dietary Preference Displayed
     */
    public boolean isDietaryPreferenceDisplayed(
            String dietaryPreference) {

        try {

            return dietaryPreferenceOption(
                    dietaryPreference)
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Scroll Until Dietary Preference Visible
     */
    public void scrollUntilDietaryPreferenceVisible(
            String dietaryPreference) {

        int maxScrolls =
                20;

        for (int i = 0; i < maxScrolls; i++) {

            try {

                if (dietaryPreferenceOption(
                        dietaryPreference)
                        .isDisplayed()) {

                    System.out.println(
                            dietaryPreference
                                    + " displayed.");

                    return;
                }

            }

            catch (Exception e) {

            }

            scrollDown();

            waitUtil.sleep(
                    1000);
        }

        throw new RuntimeException(
                dietaryPreference
                        + " not found.");
    }

    /*
     * Select Dietary Preference
     */
    public void selectDietaryPreference(
            String dietaryPreference) {

        if (!isValidDietaryCategory(
                dietaryPreference)) {

            throw new RuntimeException(
                    "Invalid Dietary Preference : "
                            + dietaryPreference);
        }

        clickDietaryPreference();

        waitUtil.sleep(
                1000);

        scrollUntilDietaryPreferenceVisible(
                dietaryPreference);

        waitUtil.clickWithWait(
                dietaryPreferenceOption(
                        dietaryPreference));

        waitUtil.sleep(
                1000);

        System.out.println(
                "Selected Dietary Preference : "
                        + dietaryPreference);
    }

    /*
     * Get Dietary Categories
     */
    public List<String> getDietaryCategories() {

        List<String> dietaryCategories =
                new ArrayList<>();

        dietaryCategories.add(
                "Age-Specific");

        dietaryCategories.add(
                "Allergen-Specific");

        dietaryCategories.add(
                "Cardiovascular");

        dietaryCategories.add(
                "Gastrointestinal");

        dietaryCategories.add(
                "Gluten-Free");

        dietaryCategories.add(
                "Historical");

        dietaryCategories.add(
                "Ketogenic");

        dietaryCategories.add(
                "Low-FODMAP");

        dietaryCategories.add(
                "Macrobiotic");

        dietaryCategories.add(
                "Mediterranean");

        dietaryCategories.add(
                "Metabolic");

        dietaryCategories.add(
                "Neurological");

        dietaryCategories.add(
                "Paleo");

        dietaryCategories.add(
                "Pescatarian");

        dietaryCategories.add(
                "Renal");

        dietaryCategories.add(
                "Therapeutic");

        dietaryCategories.add(
                "Vegan");

        dietaryCategories.add(
                "Vegetarian");

        return dietaryCategories;
    }

    /*
     * Verify Dietary Category
     */
    public boolean isValidDietaryCategory(
            String dietaryPreference) {

        return getDietaryCategories()
                .contains(
                        dietaryPreference);
    }

    /*
     * Verify All Dietary Categories
     */
    public void verifyDietaryCategories() {

        for (String dietaryPreference : getDietaryCategories()) {

            scrollUntilDietaryPreferenceVisible(
                    dietaryPreference);

            System.out.println(
                    dietaryPreference
                            + " verified.");
        }
    }

        /*
     * ==========================================================
     * RELIGION
     * ==========================================================
     */

    /*
     * Religion Option
     */
    private WebElement religionOption(
            String religion) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='"
                                + religion
                                + "']"));
    }

    /*
     * Verify Religion Displayed
     */
    public boolean isReligionDisplayed(
            String religion) {

        try {

            return religionOption(
                    religion)
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Scroll Until Religion Visible
     */
    public void scrollUntilReligionVisible(
            String religion) {

        int maxScrolls =
                50;

        for (int i = 0; i < maxScrolls; i++) {

            try {

                if (religionOption(
                        religion)
                        .isDisplayed()) {

                    System.out.println(
                            religion
                                    + " displayed.");

                    return;
                }

            }

            catch (Exception e) {

            }

            scrollDown();

            waitUtil.sleep(
                    1000);
        }

        throw new RuntimeException(
                religion
                        + " not found.");
    }

    /*
     * Select Religion
     */
    public void selectReligion(
            String religion) {

        if (!isValidReligion(
                religion)) {

            throw new RuntimeException(
                    "Invalid Religion : "
                            + religion);
        }

        clickReligion();

        waitUtil.sleep(
                1000);

        scrollUntilReligionVisible(
                religion);

        waitUtil.clickWithWait(
                religionOption(
                        religion));

        waitUtil.sleep(
                1000);

        System.out.println(
                "Selected Religion : "
                        + religion);
    }

    /*
     * Get Religion List
     */
    public List<String> getReligionList() {

        List<String> religions =
                new ArrayList<>();

        religions.add("African Traditional");
        religions.add("Agnosticism");
        religions.add("Ahmadiyya");
        religions.add("Alevi");
        religions.add("Ancient Religions");
        religions.add("Anthroposophy");
        religions.add("Atheism");
        religions.add("Australian Aboriginal");
        religions.add("Ayyavazhi");
        religions.add("Baha'i Faith");
        religions.add("Beta Israel");
        religions.add("Branch Davidian");
        religions.add("Buddhism");
        religions.add("Candomble");
        religions.add("Cao Dai");
        religions.add("Christianity");
        religions.add("Christian Science");
        religions.add("Confucianism");
        religions.add("Deism");
        religions.add("Druze");
        religions.add("Eckankar");
        religions.add("Falun Gong");
        religions.add("Hasidism");
        religions.add("Hinduism");
        religions.add("Igbo Judaism");
        religions.add("Islam");
        religions.add("Jainism");
        religions.add("Jediism");
        religions.add("Jehovah's Witnesses");
        religions.add("Judaism");
        religions.add("Kabbalah");
        religions.add("Karaite Judaism");
        religions.add("Lemba");
        religions.add("Lingayatism");
        religions.add("Mandaeism");
        religions.add("Messianic Judaism");
        religions.add("Mormon");
        religions.add("Native American");
        religions.add("Neo-Paganism");
        religions.add("New Thought");
        religions.add("Pantheism");
        religions.add("Rastafari");
        religions.add("Religious Science");
        religions.add("Samaritan");
        religions.add("Santeria");
        religions.add("Scientology");
        religions.add("Shinto");
        religions.add("Sikhism");
        religions.add("Spiritism");
        religions.add("Subud");
        religions.add("Taoism");
        religions.add("Tenrikyo");
        religions.add("Theosophy");
        religions.add("Unitarianism");
        religions.add("Unitarian Universalism");
        religions.add("Unity Church");
        religions.add("Vodou");
        religions.add("Wicca");
        religions.add("Yazidism");
        religions.add("Zoroastrianism");

        return religions;
    }

    /*
     * Verify Religion
     */
    public boolean isValidReligion(
            String religion) {

        return getReligionList()
                .contains(
                        religion);
    }

    /*
     * Print Religion List
     */
    public void printReligionList() {

        System.out.println(
                "Religion List :");

        for (String religion : getReligionList()) {

            System.out.println(
                    religion);
        }

        System.out.println(
                "Total Religions : "
                        + getReligionList().size());
    }

        /*
     * ==========================================================
     * ALLERGIES
     * ==========================================================
     */

    /*
     * Allergy Option
     */
    private WebElement allergyOption(
            String allergy) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc='"
                                + allergy
                                + "']"));
    }

    /*
     * Verify Allergy Displayed
     */
    public boolean isAllergyDisplayed(
            String allergy) {

        try {

            return allergyOption(
                    allergy)
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Scroll Until Allergy Visible
     */
    public void scrollUntilAllergyVisible(
            String allergy) {

        int maxScrolls =
                15;

        for (int i = 0; i < maxScrolls; i++) {

            try {

                if (allergyOption(
                        allergy)
                        .isDisplayed()) {

                    System.out.println(
                            allergy
                                    + " displayed.");

                    return;
                }

            }

            catch (Exception e) {

            }

            scrollDown();

            waitUtil.sleep(
                    1000);
        }

        throw new RuntimeException(
                allergy
                        + " not found.");
    }

    /*
     * Select Allergy
     */
    public void selectAllergy(
            String allergy) {

        if (!isValidAllergy(
                allergy)) {

            throw new RuntimeException(
                    "Invalid Allergy : "
                            + allergy);
        }

        clickAllergies();

        waitUtil.sleep(
                1000);

        scrollUntilAllergyVisible(
                allergy);

        waitUtil.clickWithWait(
                allergyOption(
                        allergy));

        waitUtil.sleep(
                1000);

        System.out.println(
                "Selected Allergy : "
                        + allergy);
    }

    /*
     * Get Allergy List
     */
    public List<String> getAllergyList() {

        List<String> allergies =
                new ArrayList<>();

        allergies.add(
                "Crustacean");

        allergies.add(
                "Egg");

        allergies.add(
                "Fish");

        allergies.add(
                "Milk");

        allergies.add(
                "Peanut");

        allergies.add(
                "Sesame");

        allergies.add(
                "Shellfish");

        allergies.add(
                "Soybean");

        allergies.add(
                "Tree Nut");

        allergies.add(
                "Wheat");

        return allergies;
    }

    /*
     * Verify Allergy
     */
    public boolean isValidAllergy(
            String allergy) {

        return getAllergyList()
                .contains(
                        allergy);
    }

    /*
     * Print Allergy List
     */
    public void printAllergyList() {

        System.out.println(
                "Allergy List :");

        for (String allergy : getAllergyList()) {

            System.out.println(
                    allergy);
        }

        System.out.println(
                "Total Allergies : "
                        + getAllergyList().size());
    }

    /*
     * Verify All Allergies
     */
    public void verifyAllergyList() {

        for (String allergy : getAllergyList()) {

            scrollUntilAllergyVisible(
                    allergy);

            System.out.println(
                    allergy
                            + " verified.");
        }
    }

        /*
     * ==========================================================
     * INGREDIENT INCLUSION
     * ==========================================================
     */

    /*
     * Ingredient Inclusion Section
     */
    private WebElement ingredientInclusionSection() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'Ingredient Inclusion')]"));
    }

    /*
     * Ingredient Inclusion Capsule
     */
    private WebElement ingredientInclusionCapsule(
            String ingredient) {

        return ingredientInclusionSection()
                .findElement(
                        AppiumBy.xpath(
                                ".//android.view.View[@content-desc='"
                                        + ingredient
                                        + "']"));
    }

    /*
     * Delete Ingredient Inclusion Button
     */
    private WebElement deleteIngredientInclusionButton(
            String ingredient) {

        return ingredientInclusionCapsule(
                ingredient)
                .findElement(
                        AppiumBy.xpath(
                                ".//android.widget.Button[@content-desc='Delete']"));
    }

    /*
     * Verify Ingredient Inclusion Section
     */
    public boolean isIngredientInclusionSectionDisplayed() {

        try {

            return ingredientInclusionSection()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Displayed Ingredient Inclusion
     */
    public List<String> getDisplayedIngredientInclusion() {

        List<String> ingredients =
                new ArrayList<>();

        List<WebElement> capsules =
                ingredientInclusionSection()
                        .findElements(
                                AppiumBy.xpath(
                                        ".//android.view.View[@content-desc]"));

        for (WebElement capsule : capsules) {

            String value =
                    capsule.getAttribute(
                            "content-desc");

            if (value != null
                    && !value.isBlank()
                    && !value.equals(
                            "Ingredient Inclusion")) {

                ingredients.add(
                        value);
            }
        }

        System.out.println(
                "Ingredient Inclusion : "
                        + ingredients);

        return ingredients;
    }

    /*
     * Verify Ingredient Included
     */
    public boolean isIngredientIncluded(
            String ingredient) {

        return getDisplayedIngredientInclusion()
                .contains(
                        ingredient);
    }

    /*
     * Delete Ingredient Inclusion
     */
    public void deleteIngredientInclusion(
            String ingredient) {

        waitUtil.clickWithWait(
                deleteIngredientInclusionButton(
                        ingredient));

        waitUtil.sleep(
                1000);

        System.out.println(
                ingredient
                        + " removed from Ingredient Inclusion.");
    }

    /*
     * Delete All Ingredient Inclusion
     */
    public void deleteAllIngredientInclusion() {

        int maxAttempts =
                30;

        while (maxAttempts-- > 0) {

            List<String> ingredients =
                    getDisplayedIngredientInclusion();

            if (ingredients.isEmpty()) {

                break;
            }

            deleteIngredientInclusion(
                    ingredients.get(
                            0));

            waitUtil.sleep(
                    1000);
        }

        System.out.println(
                "All Ingredient Inclusion removed.");
    }

    /*
     * Verify Ingredient Inclusion
     */
    public boolean verifyIngredientInclusion(
            List<String> expectedIngredients) {

        List<String> actualIngredients =
                getDisplayedIngredientInclusion();

        return actualIngredients.containsAll(
                expectedIngredients)
                &&
                expectedIngredients.containsAll(
                        actualIngredients);
    }

        /*
     * ==========================================================
     * INGREDIENT EXCLUSION
     * ==========================================================
     */

    /*
     * Ingredient Exclusion Section
     */
    private WebElement ingredientExclusionSection() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'Ingredient Exclusion')]"));
    }

    /*
     * Ingredient Exclusion Capsule
     */
    private WebElement ingredientExclusionCapsule(
            String ingredient) {

        return ingredientExclusionSection()
                .findElement(
                        AppiumBy.xpath(
                                ".//android.view.View[@content-desc='"
                                        + ingredient
                                        + "']"));
    }

    /*
     * Delete Ingredient Exclusion Button
     */
    private WebElement deleteIngredientExclusionButton(
            String ingredient) {

        return ingredientExclusionCapsule(
                ingredient)
                .findElement(
                        AppiumBy.xpath(
                                ".//android.widget.Button[@content-desc='Delete']"));
    }

    /*
     * Verify Ingredient Exclusion Section
     */
    public boolean isIngredientExclusionSectionDisplayed() {

        try {

            return ingredientExclusionSection()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Displayed Ingredient Exclusion
     */
    public List<String> getDisplayedIngredientExclusion() {

        List<String> ingredients =
                new ArrayList<>();

        List<WebElement> capsules =
                ingredientExclusionSection()
                        .findElements(
                                AppiumBy.xpath(
                                        ".//android.view.View[@content-desc]"));

        for (WebElement capsule : capsules) {

            String value =
                    capsule.getAttribute(
                            "content-desc");

            if (value != null
                    && !value.isBlank()
                    && !value.equals(
                            "Ingredient Exclusion")) {

                ingredients.add(
                        value);
            }
        }

        System.out.println(
                "Ingredient Exclusion : "
                        + ingredients);

        return ingredients;
    }

    /*
     * Verify Ingredient Excluded
     */
    public boolean isIngredientExcluded(
            String ingredient) {

        return getDisplayedIngredientExclusion()
                .contains(
                        ingredient);
    }

    /*
     * Delete Ingredient Exclusion
     */
    public void deleteIngredientExclusion(
            String ingredient) {

        waitUtil.clickWithWait(
                deleteIngredientExclusionButton(
                        ingredient));

        waitUtil.sleep(
                1000);

        System.out.println(
                ingredient
                        + " removed from Ingredient Exclusion.");
    }

    /*
     * Delete All Ingredient Exclusion
     */
    public void deleteAllIngredientExclusion() {

        int maxAttempts =
                30;

        while (maxAttempts-- > 0) {

            List<String> ingredients =
                    getDisplayedIngredientExclusion();

            if (ingredients.isEmpty()) {

                break;
            }

            deleteIngredientExclusion(
                    ingredients.get(
                            0));

            waitUtil.sleep(
                    1000);
        }

        System.out.println(
                "All Ingredient Exclusion removed.");
    }

    /*
     * Verify Ingredient Exclusion
     */
    public boolean verifyIngredientExclusion(
            List<String> expectedIngredients) {

        List<String> actualIngredients =
                getDisplayedIngredientExclusion();

        return actualIngredients.containsAll(
                expectedIngredients)
                &&
                expectedIngredients.containsAll(
                        actualIngredients);
    }

        /*
     * ==========================================================
     * RELIGION INGREDIENT MAPPING
     * ==========================================================
     */

    static {

        /*
         * Alevi
         */
        RELIGION_EXCLUSION.put(
                "Alevi",
                Arrays.asList(
                        "Pork"));

        /*
         * Anthroposophy
         */
        RELIGION_EXCLUSION.put(
                "Anthroposophy",
                Arrays.asList(
                        "Prepared Food"));

        /*
         * Ayyavazhi
         */
        RELIGION_EXCLUSION.put(
                "Ayyavazhi",
                Arrays.asList(
                        "Alcohol",
                        "Allium",
                        "Egg",
                        "Game",
                        "Red Meat",
                        "Poultry",
                        "Seafood"));

        /*
         * Baha'i Faith
         */
        RELIGION_EXCLUSION.put(
                "Baha'i Faith",
                Arrays.asList(
                        "Alcohol"));

        /*
         * Beta Israel
         */
        RELIGION_EXCLUSION.put(
                "Beta Israel",
                Arrays.asList(
                        "Blood",
                        "Crustacean",
                        "Feathered Game",
                        "Pork",
                        "Rabbit",
                        "Shellfish"));

        /*
         * Branch Davidian
         */
        RELIGION_EXCLUSION.put(
                "Branch Davidian",
                Arrays.asList(
                        "Alcohol",
                        "Game",
                        "Red Meat",
                        "Poultry",
                        "Seafood"));

        /*
         * Buddhism
         */
        RELIGION_INCLUSION.put(
                "Buddhism",
                Arrays.asList(
                        "Dairy",
                        "Fat",
                        "Fermented Food",
                        "Grain",
                        "Herb & Seasoning",
                        "Juice",
                        "Nut",
                        "Legume",
                        "Plant",
                        "Plant-Based Protein",
                        "Sweetener",
                        "Vegetable"));

        RELIGION_EXCLUSION.put(
                "Buddhism",
                Arrays.asList(
                        "Animal Fat"));

        /*
         * Cao Dai
         */
        RELIGION_EXCLUSION.put(
                "Cao Dai",
                Arrays.asList(
                        "Alcohol",
                        "Egg",
                        "Game",
                        "Red Meat",
                        "Poultry",
                        "Seafood"));

        /*
         * Christianity
         */
        RELIGION_INCLUSION.put(
                "Christianity",
                Arrays.asList(
                        "Fruit",
                        "Grain",
                        "Legume",
                        "Nut",
                        "Plant-Based Protein",
                        "Seafood",
                        "Sweeteners",
                        "Vegetable"));

        /*
         * Druze
         */
        RELIGION_EXCLUSION.put(
                "Druze",
                Arrays.asList(
                        "Alcohol",
                        "Pork"));

        /*
         * Falun Gong
         */
        RELIGION_EXCLUSION.put(
                "Falun Gong",
                Arrays.asList(
                        "Alcohol",
                        "Game",
                        "Red Meat",
                        "Poultry"));

                /*
         * Hasidism
         */
        RELIGION_EXCLUSION.put(
                "Hasidism",
                Arrays.asList(
                        "Blood",
                        "Crustacean",
                        "Feathered Game",
                        "Garlic",
                        "Pork",
                        "Rabbit",
                        "Shellfish"));

        /*
         * Hinduism
         */
        RELIGION_INCLUSION.put(
                "Hinduism",
                Arrays.asList(
                        "Rock Salt",
                        "Dairy",
                        "Fruit",
                        "Nut",
                        "Plant-Based Protein",
                        "Vegetable Oil"));

        RELIGION_EXCLUSION.put(
                "Hinduism",
                Arrays.asList(
                        "Alcohol",
                        "Allium",
                        "Egg",
                        "Feathered Game",
                        "Game",
                        "Marine Mammal",
                        "Red Meat",
                        "Offal",
                        "Poultry",
                        "Seafood",
                        "Grain",
                        "Salt",
                        "Beef"));

        /*
         * Igbo Judaism
         */
        RELIGION_EXCLUSION.put(
                "Igbo Judaism",
                Arrays.asList(
                        "Blood",
                        "Crustacean",
                        "Feathered Game",
                        "Pork",
                        "Rabbit",
                        "Shellfish"));

        /*
         * Islam
         */
        RELIGION_EXCLUSION.put(
                "Islam",
                Arrays.asList(
                        "Alcohol",
                        "Blood",
                        "Pork",
                        "Gelatin"));

        /*
         * Jainism
         */
        RELIGION_INCLUSION.put(
                "Jainism",
                Arrays.asList(
                        "Dairy",
                        "Fruit",
                        "Grain",
                        "Legume",
                        "Nut",
                        "Plant",
                        "Plant-Based Protein",
                        "Sweeteners",
                        "Vegetable"));

        RELIGION_EXCLUSION.put(
                "Jainism",
                Arrays.asList(
                        "Egg",
                        "Feathered Game",
                        "Fermented Food",
                        "Game",
                        "Honey",
                        "Marine Mammal",
                        "Red Meat",
                        "Offal",
                        "Poultry",
                        "Root & Tuber",
                        "Seafood",
                        "Artificial Sweetener",
                        "Refined Sugar"));

        /*
         * Jehovah's Witnesses
         */
        RELIGION_EXCLUSION.put(
                "Jehovah's Witnesses",
                Arrays.asList(
                        "Blood"));

        /*
         * Judaism
         */
        RELIGION_INCLUSION.put(
                "Judaism",
                Arrays.asList(
                        "Matzah"));

        RELIGION_EXCLUSION.put(
                "Judaism",
                Arrays.asList(
                        "Pork",
                        "Shellfish",
                        "Bread",
                        "Grain",
                        "Legume",
                        "Prepared & Processed Food",
                        "Nut",
                        "Alcohol",
                        "Salt",
                        "Blood",
                        "Crustacean",
                        "Feathered Game",
                        "Rabbit"));

        /*
         * Kabbalah
         */
        RELIGION_EXCLUSION.put(
                "Kabbalah",
                Arrays.asList(
                        "Blood",
                        "Crustacean",
                        "Feathered Game",
                        "Garlic",
                        "Pork",
                        "Rabbit",
                        "Shellfish"));

        /*
         * Karaite Judaism
         */
        RELIGION_EXCLUSION.put(
                "Karaite Judaism",
                Arrays.asList(
                        "Blood",
                        "Crustacean",
                        "Feathered Game",
                        "Pork",
                        "Rabbit",
                        "Shellfish"));

        /*
         * Lemba
         */
        RELIGION_EXCLUSION.put(
                "Lemba",
                Arrays.asList(
                        "Blood",
                        "Crustacean",
                        "Feathered Game",
                        "Pork",
                        "Rabbit",
                        "Shellfish"));

        /*
         * Lingayatism
         */
        RELIGION_EXCLUSION.put(
                "Lingayatism",
                Arrays.asList(
                        "Alcohol",
                        "Allium",
                        "Egg",
                        "Game",
                        "Red Meat",
                        "Poultry",
                        "Seafood"));

                /*
         * Mandaeism
         */
        RELIGION_EXCLUSION.put(
                "Mandaeism",
                Arrays.asList(
                        "Alcohol",
                        "Blood",
                        "Red Meat"));

        /*
         * Messianic Judaism
         */
        RELIGION_EXCLUSION.put(
                "Messianic Judaism",
                Arrays.asList(
                        "Blood",
                        "Crustacean",
                        "Feathered Game",
                        "Pork",
                        "Rabbit",
                        "Shellfish"));

        /*
         * Mormon
         */
        RELIGION_EXCLUSION.put(
                "Mormon",
                Arrays.asList(
                        "Alcohol",
                        "Caffeinated Beverage"));

        /*
         * Rastafari
         */
        RELIGION_INCLUSION.put(
                "Rastafari",
                Arrays.asList(
                        "Dairy",
                        "Fruit",
                        "Grain",
                        "Legume",
                        "Nut",
                        "Plant",
                        "Plant-Based Protein",
                        "Sweetener",
                        "Vegetable"));

        RELIGION_EXCLUSION.put(
                "Rastafari",
                Arrays.asList(
                        "Alcohol",
                        "Artificial Sweeteners",
                        "Pork",
                        "Salt",
                        "Shellfish",
                        "Refined Sugar"));

        /*
         * Samaritan
         */
        RELIGION_EXCLUSION.put(
                "Samaritan",
                Arrays.asList(
                        "Blood",
                        "Crustacean",
                        "Feathered Game",
                        "Pork",
                        "Rabbit",
                        "Shellfish"));

        /*
         * Scientology
         */
        RELIGION_EXCLUSION.put(
                "Scientology",
                Arrays.asList(
                        "Alcohol"));

        /*
         * Sikhism
         */
        RELIGION_INCLUSION.put(
                "Sikhism",
                Arrays.asList(
                        "Dairy",
                        "Fruit",
                        "Grain",
                        "Herb & Seasoning",
                        "Legume",
                        "Red Meat",
                        "Nut",
                        "Plant",
                        "Plant-Based Protein",
                        "Sweeteners",
                        "Vegetable"));

        RELIGION_EXCLUSION.put(
                "Sikhism",
                Arrays.asList(
                        "Alcohol"));

        /*
         * Taoism
         */
        RELIGION_EXCLUSION.put(
                "Taoism",
                Arrays.asList(
                        "Alcohol",
                        "Artificial Sweetener",
                        "Dairy",
                        "Dairy Fat",
                        "Refined Sugar"));

        /*
         * Theosophy
         */
        RELIGION_EXCLUSION.put(
                "Theosophy",
                Arrays.asList(
                        "Alcohol",
                        "Game",
                        "Red Meat",
                        "Poultry",
                        "Seafood"));

        /*
         * Yazidism
         */
        RELIGION_EXCLUSION.put(
                "Yazidism",
                Arrays.asList(
                        "Lettuce"));

    }

        /*
     * ==========================================================
     * RELIGION VALIDATION METHODS
     * ==========================================================
     */

    /*
     * Get Expected Ingredient Inclusion
     */
    public List<String> getExpectedIngredientInclusion(
            String religion) {

        return RELIGION_INCLUSION.getOrDefault(
                religion,
                new ArrayList<>());
    }

    /*
     * Get Expected Ingredient Exclusion
     */
    public List<String> getExpectedIngredientExclusion(
            String religion) {

        return RELIGION_EXCLUSION.getOrDefault(
                religion,
                new ArrayList<>());
    }

    /*
     * Verify Religion Ingredient Inclusion
     */
    public boolean verifyReligionIngredientInclusion(
            String religion) {

        List<String> expected =
                getExpectedIngredientInclusion(
                        religion);

        List<String> actual =
                getDisplayedIngredientInclusion();

        System.out.println(
                "Religion : "
                        + religion);

        System.out.println(
                "Expected Inclusion : "
                        + expected);

        System.out.println(
                "Actual Inclusion : "
                        + actual);

        return actual.containsAll(
                expected)
                &&
                expected.containsAll(
                        actual);
    }

    /*
     * Verify Religion Ingredient Exclusion
     */
    public boolean verifyReligionIngredientExclusion(
            String religion) {

        List<String> expected =
                getExpectedIngredientExclusion(
                        religion);

        List<String> actual =
                getDisplayedIngredientExclusion();

        System.out.println(
                "Religion : "
                        + religion);

        System.out.println(
                "Expected Exclusion : "
                        + expected);

        System.out.println(
                "Actual Exclusion : "
                        + actual);

        return actual.containsAll(
                expected)
                &&
                expected.containsAll(
                        actual);
    }

    /*
     * Print Religion Mapping
     */
    public void printReligionMapping(
            String religion) {

        System.out.println(
                "Religion : "
                        + religion);

        System.out.println(
                "Ingredient Inclusion : "
                        + getExpectedIngredientInclusion(
                                religion));

        System.out.println(
                "Ingredient Exclusion : "
                        + getExpectedIngredientExclusion(
                                religion));
    }

    /*
     * Verify Religion Mapping Exists
     */
    public boolean hasReligionMapping(
            String religion) {

        return RELIGION_INCLUSION.containsKey(
                religion)
                ||
                RELIGION_EXCLUSION.containsKey(
                        religion);
    }

    /*
     * Print Supported Religions
     */
    public void printSupportedReligions() {

        List<String> religions =
                new ArrayList<>();

        religions.addAll(
                RELIGION_INCLUSION.keySet());

        for (String religion : RELIGION_EXCLUSION.keySet()) {

            if (!religions.contains(
                    religion)) {

                religions.add(
                        religion);
            }
        }

        System.out.println(
                "Supported Religions :");

        for (String religion : religions) {

            System.out.println(
                    religion);
        }

        System.out.println(
                "Total Supported Religions : "
                        + religions.size());
    }

        /*
     * Add Dietary Preference
     */
    public void addDietaryPreference(
            String dietaryPreference) {

        selectDietaryPreference(
                dietaryPreference);

        waitUtil.sleep(
                1000);
    }

    /*
     * Add Religion
     */
    public void addReligion(
            String religion) {

        selectReligion(
                religion);

        waitUtil.sleep(
                1000);
    }

    /*
     * Add Allergy
     */
    public void addAllergy(
            String allergy) {

        selectAllergy(
                allergy);

        waitUtil.sleep(
                1000);
    }

    /*
     * ==========================================================
     * WORKFLOW METHODS
     * ==========================================================
     */

    /*
     * Validate Religion
     */
    public void validateReligion(
            String religion) {

        addReligion(
                religion);

        waitUtil.sleep(
                2000);

        if (!verifyReligionIngredientInclusion(
                religion)) {

            throw new RuntimeException(
                    "Ingredient Inclusion validation failed.");
        }

        if (!verifyReligionIngredientExclusion(
                religion)) {

            throw new RuntimeException(
                    "Ingredient Exclusion validation failed.");
        }

        System.out.println(
                religion
                        + " validated successfully.");
    }

    /*
     * Clear Religion Preferences
     */
    public void clearReligionPreferences() {

        deleteAllIngredientInclusion();

        waitUtil.sleep(
                1000);

        deleteAllIngredientExclusion();

        waitUtil.sleep(
                1000);

        System.out.println(
                "Religion Preferences cleared.");
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


    /*
 * Print Dietary Categories
 */
public void printDietaryCategories() {

    System.out.println(
            "Dietary Categories :");

    for (String dietaryPreference : getDietaryCategories()) {

        System.out.println(
                dietaryPreference);
    }

    System.out.println(
            "Total Dietary Categories : "
                    + getDietaryCategories().size());
}


/*
 * Verify All Religions
 */
public void verifyReligionList() {

    clickReligion();

    waitUtil.sleep(1000);

    for (String religion : getReligionList()) {

        scrollUntilReligionVisible(religion);

        System.out.println(religion + " verified.");
    }

    driver.navigate().back();    // or click outside popup
}

}