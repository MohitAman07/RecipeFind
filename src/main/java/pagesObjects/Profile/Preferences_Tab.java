package pagesObjects.Profile;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.EnumReligionScrollTrigger;
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
     * LOCATORS
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
     * Preferences Section
     */
    private WebElement preferencesSection() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Dietary Preference\nReligion\nAllergies\nIngredient Inclusion\nIngredient Exclusion\nCustom Include\nCustom Exclude']"));
    }

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
        * Religion Option
        */
        private WebElement religionOption(
                String religion) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.Button[@content-desc=\""
                                + religion
                                + "\"]"));
        }

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
     * Ingredient Inclusion Capsule
     */
    private WebElement ingredientInclusionCapsule(
            String ingredient) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='"
                                + ingredient
                                + "']"));
    }

    /*
     * Ingredient Exclusion Capsule
     */
    private WebElement ingredientExclusionCapsule(
            String ingredient) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='"
                                + ingredient
                                + "']"));
    }

    /*
     * Delete Ingredient Inclusion
     */
    private WebElement deleteIngredientInclusionButton(
            String ingredient) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='"
                                + ingredient
                                + "']/android.widget.Button[@content-desc='Delete']"));
    }

    /*
     * Delete Ingredient Exclusion
     */
    private WebElement deleteIngredientExclusionButton(
            String ingredient) {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='"
                                + ingredient
                                + "']/android.widget.Button[@content-desc='Delete']"));
    }

        /*
     * ==========================================================
     * GENERIC METHODS
     * ==========================================================
     */

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
     * Get Preference Options
     */
    public List<String> getPreferenceOptions() {

        List<String> options =
                new ArrayList<>();

        String[] values =
                preferencesSection()
                        .getAttribute(
                                "content-desc")
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
     * Click Dietary Preference
     */
    public void clickDietaryPreference() {

        waitUtil.clickWithWait(
                preferenceAddButton(
                        1));

        waitUtil.sleep(
                1000);

        System.out.println(
                "Dietary Preference button clicked.");
    }

    /*
     * Close Selection Popup
     */
    public void closeSelectionPopup() {

        driver.navigate()
                .back();

        waitUtil.sleep(
                1000);

        System.out.println(
                "Selection Popup closed.");
    }

        /*
     * ==========================================================
     * SCROLL METHODS
     * ==========================================================
     */

    /*
     * Scroll Down
     */
    public void scrollDown() {

        try {

            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

            System.out.println(
                    "Scrolled Down.");

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
                    "Scrolled Up.");

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
                "Scrolled To Top.");
    }

    /*
     * Scroll To Bottom
     */
    public void scrollToBottom() {

        for (int i = 0; i < 20; i++) {

            scrollDown();
        }

        System.out.println(
                "Scrolled To Bottom.");
    }

        /*
     * ==========================================================
     * DIETARY PREFERENCE
     * ==========================================================
     */

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
     * Verify Valid Dietary Preference
     */
    public boolean isValidDietaryPreference(
            String dietaryPreference) {

        return getDietaryCategories()
                .contains(
                        dietaryPreference);
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

                if (isDietaryPreferenceDisplayed(
                        dietaryPreference)) {

                    System.out.println(
                            dietaryPreference
                                    + " displayed successfully.");

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
                        + " is not displayed.");
    }

    /*
     * Verify Dietary Preference List
     */
    public void verifyDietaryPreferenceList() {

        for (String dietaryPreference : getDietaryCategories()) {

            scrollUntilDietaryPreferenceVisible(
                    dietaryPreference);

            System.out.println(
                    dietaryPreference
                            + " verified successfully.");
        }

        System.out.println(
                "Dietary Preference List verified successfully.");
    }

        /*
     * Select Dietary Preference
     */
    public void selectDietaryPreference(
            String dietaryPreference) {

        /*
         * Verify Dietary Preference
         */
        if (!isValidDietaryPreference(
                dietaryPreference)) {

            throw new RuntimeException(
                    "Invalid Dietary Preference : "
                            + dietaryPreference);
        }

        /*
         * Open Dietary Preference List
         */
        clickDietaryPreference();

        waitUtil.sleep(
                1000);

        /*
         * Scroll Until Dietary Preference Visible
         */
        scrollUntilDietaryPreferenceVisible(
                dietaryPreference);

        /*
         * Select Dietary Preference
         */
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
 * ==========================================================
 * RELIGION
 * ==========================================================
 */

/*
 * Click Religion
 */
public void clickReligion() {

    waitUtil.clickWithWait(
            preferenceAddButton(
                    2));

    waitUtil.sleep(
            1000);

    System.out.println(
            "Religion button clicked.");
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
     * Get Religion List
     */
    public List<String> getReligionList() {

        List<String> religions =
                new ArrayList<>();

        religions.add(
                "African Traditional");

        religions.add(
                "Agnosticism");

        religions.add(
                "Ahmadiyya");

        religions.add(
                "Alevi");

        religions.add(
                "Ancient Religions");

        religions.add(
                "Anthroposophy");

        religions.add(
                "Atheism");

        religions.add(
                "Australian Aboriginal");

        religions.add(
                "Ayyavazhi");

        religions.add(
                "Baha'i Faith");

        religions.add(
                "Beta Israel");

        religions.add(
                "Branch Davidian");

        religions.add(
                "Buddhism");

        religions.add(
                "Candomble");

        religions.add(
                "Cao Dai");

        religions.add(
                "Christianity");

        religions.add(
                "Christian Science");

        religions.add(
                "Confucianism");

        religions.add(
                "Deism");

        religions.add(
                "Druze");

        religions.add(
                "Eckankar");

        religions.add(
                "Falun Gong");

        religions.add(
                "Hasidism");

        religions.add(
                "Hinduism");

        religions.add(
                "Igbo Judaism");

        religions.add(
                "Islam");

        religions.add(
                "Jainism");

        religions.add(
                "Jediism");

        religions.add(
                "Jehovah's Witnesses");

        religions.add(
                "Judaism");

        religions.add(
                "Kabbalah");

        religions.add(
                "Karaite Judaism");

        religions.add(
                "Lemba");

        religions.add(
                "Lingayatism");

        religions.add(
                "Mandaeism");

        religions.add(
                "Messianic Judaism");

        religions.add(
                "Mormon");

        religions.add(
                "Native American");

        religions.add(
                "Neo-Paganism");

        religions.add(
                "New Thought");

        religions.add(
                "Pantheism");

        religions.add(
                "Rastafari");

        religions.add(
                "Religious Science");

        religions.add(
                "Samaritan");

        religions.add(
                "Santeria");

        religions.add(
                "Scientology");

        religions.add(
                "Shinto");

        religions.add(
                "Sikhism");

        religions.add(
                "Spiritism");

        religions.add(
                "Subud");

        religions.add(
                "Taoism");

        religions.add(
                "Tenrikyo");

        religions.add(
                "Theosophy");

        religions.add(
                "Unitarianism");

        religions.add(
                "Unitarian Universalism");

        religions.add(
                "Unity Church");

        religions.add(
                "Vodou");

        religions.add(
                "Wicca");

        religions.add(
                "Yazidism");

        religions.add(
                "Zoroastrianism");

        return religions;
    }

    /*
     * Verify Valid Religion
     */
    public boolean isValidReligion(
            String religion) {

        return getReligionList()
                .contains(
                        religion);
    }

    
    /*
 * Scroll Until Religion Visible
 */
public void scrollUntilReligionVisible(
        String religion) {

    int maxScrolls =
            30;

    for (int i = 0; i < maxScrolls; i++) {

        System.out.println(
                "Searching : "
                        + religion
                        + " | Attempt : "
                        + (i + 1));

        if (isReligionDisplayed(
                religion)) {

            System.out.println(
                    religion
                            + " displayed successfully.");

            return;
        }

        smallScrollDown();
    }

    throw new RuntimeException(
            religion
                    + " is not displayed.");
}

/*
 * Small Scroll Down
 */
public void smallScrollDown() {

    try {

        System.out.println(
                "Performing Small Scroll...");

        driver.executeScript(
        "mobile: scrollGesture",
        Map.of(
                "left", 250,
                "top", 350,
                "width", 450,
                "height", 900,
                "direction", "down",
                "percent", 0.20));

        waitUtil.sleep(
                1000);

        System.out.println(
                "Small Scroll Completed.");

    }

    catch (Exception e) {

        e.printStackTrace();
    }
}


/*
 * Verify Religion List
 */
public void verifyReligionList() {


    waitUtil.sleep(
            1000);

    for (String religion : getReligionList()) {

        scrollUntilReligionVisible(
                religion);

        System.out.println(
                religion
                        + " verified successfully.");

        /*
         * Trigger Next Religion Section
         */
        if (EnumReligionScrollTrigger.SCROLL_TRIGGERS.contains(
                religion)) {

            System.out.println(
                    "Religion Trigger Matched : "
                            + religion);

            smallScrollDown();

            waitUtil.sleep(
                    1000);
        }
    }

    System.out.println(
            "Religion List verified successfully.");
}

/*
 * Select Religion
 */
public void selectReligion(
        String religion) {

    /*
     * Verify Religion
     */
    if (!isValidReligion(
            religion)) {

        throw new RuntimeException(
                "Invalid Religion : "
                        + religion);
    }

    /*
     * Open Religion List
     */
    clickReligion();

    waitUtil.sleep(
            1000);


    /*
     * Scroll Until Religion Visible
     */
    scrollUntilReligionVisible(
            religion);

    /*
     * Select Religion
     */
    waitUtil.clickWithWait(
            religionOption(
                    religion));

    waitUtil.sleep(
            1000);

    System.out.println(
            "Selected Religion : "
                    + religion);

        
}

// private WebElement religionChip(
//         String religion) {

//     return driver.findElement(
//             AppiumBy.xpath(
//                     "//android.view.View[@content-desc=\""
//                             + religion
//                             + "\"]"));
// }

private WebElement religionChip(
        String religion) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc=\""
                            + religion
                            + "\"]"));
}

/*
 * Delete Religion
 */

private WebElement religionDeleteButton(
        String religion) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc=\""
                            + religion
                            + "\"]"
                            + "/android.widget.Button[@content-desc=\"Delete\"]"));
}






/*
 * ==========================================================
 * ALLERGIES
 * ==========================================================
 */

/*
 * Click Allergies
 */
public void clickAllergies() {

    waitUtil.clickWithWait(
            preferenceAddButton(
                    3));

    waitUtil.sleep(
            1000);

    System.out.println(
            "Allergies button clicked.");
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
 * Verify Valid Allergy
 */
public boolean isValidAllergy(
        String allergy) {

    return getAllergyList()
            .contains(
                    allergy);
}

/*
 * Verify Allergy List
 */
public void verifyAllergyList() {

    for (String allergy : getAllergyList()) {

        if (!isAllergyDisplayed(
                allergy)) {

            throw new RuntimeException(
                    allergy
                            + " is not displayed.");
        }

        System.out.println(
                allergy
                        + " verified successfully.");
    }

    System.out.println(
            "Allergy List verified successfully.");
}

/*
 * Select Allergy
 */
public void selectAllergy(
        String allergy) {

    /*
     * Verify Allergy
     */
    if (!isValidAllergy(
            allergy)) {

        throw new RuntimeException(
                "Invalid Allergy : "
                        + allergy);
    }

    /*
     * Open Allergy List
     */
    clickAllergies();

    waitUtil.sleep(
            1000);

    /*
     * Select Allergy
     */
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
 * ==========================================================
 * INGREDIENT INCLUSION / EXCLUSION LOCATORS
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
 * Ingredient Exclusion Section
 */
private WebElement ingredientExclusionSection() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[contains(@content-desc,'Ingredient Exclusion')]"));
}

/*
 * Ingredient Inclusion Chips
 */
// private List<WebElement> ingredientInclusionChips() {

//     return driver.findElements(
//             AppiumBy.xpath(
//                     "//android.view.View[contains(@content-desc,'Ingredient Inclusion')]"
//                             + "/following-sibling::android.view.View"));
// }

private WebElement ingredientInclusionChip(
        String ingredient) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc=\""
                            + ingredient
                            + "\"]"));
}

/*
 * Ingredient Exclusion Chips
 */
// private List<WebElement> ingredientExclusionChips() {

//     return driver.findElements(
//             AppiumBy.xpath(
//                     "//android.view.View[contains(@content-desc,'Ingredient Exclusion')]"
//                             + "/following-sibling::android.view.View"));
// }

private WebElement ingredientExclusionChip(
        String ingredient) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc=\""
                            + ingredient
                            + "\"]"));
}

/*
 * Ingredient Inclusion Delete Button
 */
// private WebElement ingredientInclusionDeleteButton(
//         String ingredient) {

//     return driver.findElement(
//             AppiumBy.xpath(
//                     "//android.view.View[@content-desc=\""
//                             + ingredient
//                             + "\"]"
//                             + "/android.widget.Button"));
// }

private WebElement ingredientInclusionDeleteButton(
        String ingredient) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc=\""
                            + ingredient
                            + "\"]"
                            + "/android.widget.Button[@content-desc=\"Delete\"]"));
}

/*
 * Ingredient Exclusion Delete Button
 */
// private WebElement ingredientExclusionDeleteButton(
//         String ingredient) {

//     return driver.findElement(
//             AppiumBy.xpath(
//                     "//android.view.View[@content-desc=\""
//                             + ingredient
//                             + "\"]"
//                             + "/android.widget.Button"));
// }

private WebElement ingredientExclusionDeleteButton(
        String ingredient) {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc=\""
                            + ingredient
                            + "\"]"
                            + "/android.widget.Button[@content-desc=\"Delete\"]"));
}


/*
 * Ingredient Inclusion Chips
 */
private List<WebElement> ingredientInclusionChips() {

    return driver.findElements(
            AppiumBy.xpath(
                    "//android.widget.HorizontalScrollView/android.view.View"));
}

/*
 * Ingredient Exclusion Chips
 */
private List<WebElement> ingredientExclusionChips() {

    return driver.findElements(
            AppiumBy.xpath(
                    "//android.widget.HorizontalScrollView/android.view.View"));
}

/*
 * Horizontal Scroll Ingredient Inclusion
 */
public void scrollIngredientInclusion() {

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
                    900,
                    1735));

    swipe.addAction(
            finger.createPointerDown(
                    PointerInput.MouseButton.LEFT.asArg()));

    swipe.addAction(
            finger.createPointerMove(
                    Duration.ofMillis(
                            400),
                    PointerInput.Origin.viewport(),
                    250,
                    1735));

    swipe.addAction(
            finger.createPointerUp(
                    PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(
            Arrays.asList(
                    swipe));

    waitUtil.sleep(
            500);

    System.out.println(
            "Ingredient Inclusion Scrolled.");
}

/*
 * Horizontal Scroll Ingredient Exclusion
 */
public void scrollIngredientExclusion() {

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
                    900,
                    1855));

    swipe.addAction(
            finger.createPointerDown(
                    PointerInput.MouseButton.LEFT.asArg()));

    swipe.addAction(
            finger.createPointerMove(
                    Duration.ofMillis(
                            400),
                    PointerInput.Origin.viewport(),
                    250,
                    1855));

    swipe.addAction(
            finger.createPointerUp(
                    PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(
            Arrays.asList(
                    swipe));

    waitUtil.sleep(
            500);

    System.out.println(
            "Ingredient Exclusion Scrolled.");
}

/*
 * Get Visible Ingredient Inclusion
 */
public Set<String> getVisibleIngredientInclusion() {

    Set<String> ingredients =
            new LinkedHashSet<>();

    for (WebElement chip : ingredientInclusionChips()) {

        try {

            String ingredient =
                    chip.getAttribute(
                            "content-desc")
                            .trim();

            if (!ingredient.isEmpty()) {

                ingredients.add(
                        ingredient);

                System.out.println(
                        "Ingredient Inclusion : "
                                + ingredient);
            }

        }

        catch (Exception e) {

        }
    }

    return ingredients;
}

/*
 * Get Visible Ingredient Exclusion
 */
public Set<String> getVisibleIngredientExclusion() {

    Set<String> ingredients =
            new LinkedHashSet<>();

    for (WebElement chip : ingredientExclusionChips()) {

        try {

            String ingredient =
                    chip.getAttribute(
                            "content-desc")
                            .trim();

            if (!ingredient.isEmpty()) {

                ingredients.add(
                        ingredient);

                System.out.println(
                        "Ingredient Exclusion : "
                                + ingredient);
            }

        }

        catch (Exception e) {

        }
    }

    return ingredients;
}

/*
 * Verify Religion Ingredient Inclusion
 */
// public boolean verifyReligionIngredientInclusion(
//         String religion) {

//     List<String> expectedIngredients =
//             RELIGION_INCLUSION.get(
//                     religion);

//     if (expectedIngredients == null) {

//         throw new RuntimeException(
//                 "No Inclusion Mapping Found : "
//                         + religion);
//     }

//     Set<String> actualIngredients =
//             new LinkedHashSet<>();

//     int previousSize =
//             -1;

//     while (previousSize != actualIngredients.size()) {

//         previousSize =
//                 actualIngredients.size();

//         actualIngredients.addAll(
//                 getVisibleIngredientInclusion());

//         scrollIngredientInclusion();
//     }

//     System.out.println(
//             "Expected Inclusion : "
//                     + expectedIngredients);

//     System.out.println(
//             "Actual Inclusion : "
//                     + actualIngredients);

//     return actualIngredients.containsAll(
//             expectedIngredients);
// }

public boolean verifyReligionIngredientInclusion(
        String religion) {

    List<String> expected =
        RELIGION_EXCLUSION.getOrDefault(
                religion,
                new ArrayList<>());

    Set<String> actual =
            getAllIngredientInclusion();

    System.out.println(
            "Expected : "
                    + expected);

    System.out.println(
            "Actual : "
                    + actual);

    return actual.containsAll(
            expected);
}

/*
 * Verify Religion Ingredient Exclusion
 */
// public boolean verifyReligionIngredientExclusion(
//         String religion) {

//     List<String> expectedIngredients =
//             RELIGION_EXCLUSION.get(
//                     religion);

//     if (expectedIngredients == null) {

//         throw new RuntimeException(
//                 "No Exclusion Mapping Found : "
//                         + religion);
//     }

//     Set<String> actualIngredients =
//             new LinkedHashSet<>();

//     int previousSize =
//             -1;

//     while (previousSize != actualIngredients.size()) {

//         previousSize =
//                 actualIngredients.size();

//         actualIngredients.addAll(
//                 getVisibleIngredientExclusion());

//         scrollIngredientExclusion();
//     }

//     System.out.println(
//             "Expected Exclusion : "
//                     + expectedIngredients);

//     System.out.println(
//             "Actual Exclusion : "
//                     + actualIngredients);

//     return actualIngredients.containsAll(
//             expectedIngredients);
// }

public boolean verifyReligionIngredientExclusion(
        String religion) {

    List<String> expected =
        RELIGION_INCLUSION.getOrDefault(
                religion,
                new ArrayList<>());

    Set<String> actual =
            getAllIngredientExclusion();

    System.out.println(
            "Expected : "
                    + expected);

    System.out.println(
            "Actual : "
                    + actual);

    return actual.containsAll(
            expected);
}

/*
 * Delete Visible Ingredient Inclusion
 */
public void deleteVisibleIngredientInclusion() {

    List<WebElement> chips =
            ingredientInclusionChips();

    for (WebElement chip : chips) {

        try {

            String ingredient =
                    chip.getAttribute(
                            "content-desc");

            WebElement deleteButton =
                    chip.findElement(
                            AppiumBy.className(
                                    "android.widget.Button"));

            waitUtil.clickWithWait(
                    deleteButton);

            waitUtil.sleep(
                    500);

            System.out.println(
                    ingredient
                            + " removed successfully.");

        }

        catch (Exception e) {

        }
    }
}

/*
 * Delete Visible Ingredient Exclusion
 */
public void deleteVisibleIngredientExclusion() {

    List<WebElement> chips =
            ingredientExclusionChips();

    for (WebElement chip : chips) {

        try {

            String ingredient =
                    chip.getAttribute(
                            "content-desc");

            WebElement deleteButton =
                    chip.findElement(
                            AppiumBy.className(
                                    "android.widget.Button"));

            waitUtil.clickWithWait(
                    deleteButton);

            waitUtil.sleep(
                    500);

            System.out.println(
                    ingredient
                            + " removed successfully.");

        }

        catch (Exception e) {

        }
    }
}

/*
 * Delete All Ingredient Inclusion
 */
public void deleteAllIngredientInclusion() {

    int maxScrolls =
            15;

    while (maxScrolls-- > 0) {

        deleteVisibleIngredientInclusion();

        scrollIngredientInclusion();

        if (ingredientInclusionChips().isEmpty()) {

            break;
        }
    }

    System.out.println(
            "All Ingredient Inclusion removed successfully.");
}

/*
 * Delete All Ingredient Exclusion
 */
public void deleteAllIngredientExclusion() {

    int maxScrolls =
            15;

    while (maxScrolls-- > 0) {

        deleteVisibleIngredientExclusion();

        scrollIngredientExclusion();

        if (ingredientExclusionChips().isEmpty()) {

            break;
        }
    }

    System.out.println(
            "All Ingredient Exclusion removed successfully.");
}

/*
 * Verify Ingredient Inclusion Empty
 */
public boolean isIngredientInclusionEmpty() {

    try {

        return ingredientInclusionChips()
                .isEmpty();

    }

    catch (Exception e) {

        return false;
    }
}

/*
 * Verify Ingredient Exclusion Empty
 */
public boolean isIngredientExclusionEmpty() {

    try {

        return ingredientExclusionChips()
                .isEmpty();

    }

    catch (Exception e) {

        return false;
    }
}

/*
 * Print Visible Ingredient Inclusion
 */
public void printVisibleIngredientInclusion() {

    for (WebElement chip : ingredientInclusionChips()) {

        System.out.println(
                chip.getAttribute(
                        "content-desc"));
    }
}

/*
 * Print Visible Ingredient Exclusion
 */
public void printVisibleIngredientExclusion() {

    for (WebElement chip : ingredientExclusionChips()) {

        System.out.println(
                chip.getAttribute(
                        "content-desc"));
    }
}

/*
 * Read All Ingredient Inclusion
 */
private Set<String> getAllIngredientInclusion() {

    Set<String> ingredients =
            new LinkedHashSet<>();

    for (int i = 0; i < 10; i++) {

        ingredients.addAll(
                getVisibleIngredientInclusion());

        scrollIngredientInclusion();
    }

    return ingredients;
}

/*
 * Read All Ingredient Exclusion
 */
private Set<String> getAllIngredientExclusion() {

    Set<String> ingredients =
            new LinkedHashSet<>();

    for (int i = 0; i < 10; i++) {

        ingredients.addAll(
                getVisibleIngredientExclusion());

        scrollIngredientExclusion();
    }

    return ingredients;
}


}