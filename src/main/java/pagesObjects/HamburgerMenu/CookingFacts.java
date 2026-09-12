package pagesObjects.HamburgerMenu;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.WaitUtil;

public class CookingFacts {

    private final AndroidDriver driver;
    private final WaitUtil waitUtil;


    // ======================== Constructor ======================== //

    public CookingFacts(
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


    // ======================== Top Level Sections ======================== //

    /*
     * Cooking Facts Header
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"COOKING FACTS\"]")
    private WebElement cookingFactsHeader;


    /*
     * Culinary Abbreviations & Measures /
     * Equivalents Header
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Culinary Abbreviations & Measures / Equivalents\"]")
    private WebElement culinaryAbbreviationsHeader;


    /*
     * Time and Temperature Control Header
     *
     * Note:
     * Application locator contains a trailing space.
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Time and Temperature Control \"]")
    private WebElement timeTemperatureHeader;


    /*
     * Stages of Sugar Header
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Stages of Sugar\"]")
    private WebElement stagesOfSugarHeader;


    /*
     * Cool Food in Two Stages Header
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Cool Food in Two Stages\"]")
    private WebElement coolFoodHeader;


    /*
     * Avoiding Your Allergen Header
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Avoiding Your Allergen\"]")
    private WebElement avoidingYourAllergenHeader;


    // ======================== Abbreviations ======================== //

    /*
     * Abbreviations - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Abbreviations, Collapsed\"]")
    private WebElement abbreviationsCollapsed;


    /*
     * Abbreviations - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Abbreviations, Expanded\"]")
    private WebElement abbreviationsExpanded;


    /*
     * US Customary - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"US Customary, Collapsed\"]")
    private WebElement usCustomaryCollapsed;


    /*
     * US Customary - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"US Customary, Expanded\"]")
    private WebElement usCustomaryExpanded;


    /*
     * SI (Metric) - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"SI (Metric), Collapsed\"]")
    private WebElement siMetricCollapsed;


    /*
     * SI (Metric) - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"SI (Metric), Expanded\"]")
    private WebElement siMetricExpanded;


    /*
     * Others - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Others, Collapsed\"]")
    private WebElement othersCollapsed;


    /*
     * Others - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Others, Expanded\"]")
    private WebElement othersExpanded;


    // ======================== Measures And Equivalents ======================== //

    /*
     * Measures and Equivalents - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Measures and Equivalents, Collapsed\"]")
    private WebElement measuresCollapsed;


    /*
     * Measures and Equivalents - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Measures and Equivalents, Expanded\"]")
    private WebElement measuresExpanded;


    // ======================== Weights And Equivalents ======================== //

    /*
     * Weights and Equivalents - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Weights and Equivalents, Collapsed\"]")
    private WebElement weightsCollapsed;


    /*
     * Weights and Equivalents - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Weights and Equivalents, Expanded\"]")
    private WebElement weightsExpanded;


    // ======================== Time And Temperature ======================== //

    /*
     * Cooking Temperatures - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Cooking Temperatures, Collapsed\"]")
    private WebElement cookingTemperaturesCollapsed;


    /*
     * Cooking Temperatures - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Cooking Temperatures, Expanded\"]")
    private WebElement cookingTemperaturesExpanded;


    // ======================== Stages Of Sugar ======================== //

    /*
     * Sugar Stages - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Sugar Stages, Collapsed\"]")
    private WebElement sugarStagesCollapsed;


    /*
     * Sugar Stages - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Sugar Stages, Expanded\"]")
    private WebElement sugarStagesExpanded;


    // ======================== Cool Food In Two Stages ======================== //

    /*
     * Cooling Stages - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Cooling Stages, Collapsed\"]")
    private WebElement coolingStagesCollapsed;


    /*
     * Cooling Stages - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Cooling Stages, Expanded\"]")
    private WebElement coolingStagesExpanded;


    // ======================== All 9 Allergens ======================== //

    /*
     * All 9 Allergens - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"All 9 Allergens, Collapsed\"]")
    private WebElement allNineAllergensCollapsed;


    /*
     * All 9 Allergens - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"All 9 Allergens, Expanded\"]")
    private WebElement allNineAllergensExpanded;


    /*
     * Understanding Food Allergen Labels - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Understanding Food Allergen Labels, Collapsed\"]")
    private WebElement understandingAllergenLabelsCollapsed;


    /*
     * Understanding Food Allergen Labels - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Understanding Food Allergen Labels, Expanded\"]")
    private WebElement understandingAllergenLabelsExpanded;


    // ======================== Crustacean Shellfish ======================== //

    /*
     * Crustacean Shellfish - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Crustacean Shellfish, Collapsed\"]")
    private WebElement crustaceanShellfishCollapsed;


    /*
     * Crustacean Shellfish - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Crustacean Shellfish, Expanded\"]")
    private WebElement crustaceanShellfishExpanded;


    /*
     * Crustacean Shellfish-Free Diet Guidelines - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Crustacean Shellfish-Free Diet Guidelines, Collapsed\"]")
    private WebElement crustaceanCollapsed;


    /*
     * Crustacean Shellfish-Free Diet Guidelines - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Crustacean Shellfish-Free Diet Guidelines, Expanded\"]")
    private WebElement crustaceanExpanded;


    /*
     * Hidden Sources of Shellfish - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Shellfish, Collapsed\"]")
    private WebElement hiddenShellfishCollapsed;


    /*
     * Hidden Sources of Shellfish - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Shellfish, Expanded\"]")
    private WebElement hiddenShellfishExpanded;


    /*
     * Shellfish Allergy Considerations - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Shellfish Allergy Considerations, Collapsed\"]")
    private WebElement shellfishAllergyCollapsed;


    /*
     * Shellfish Allergy Considerations - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Shellfish Allergy Considerations, Expanded\"]")
    private WebElement shellfishAllergyExpanded;


    // ======================== Egg ======================== //

    /*
     * Egg - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Egg, Collapsed\"]")
    private WebElement eggCollapsed;


    /*
     * Egg - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Egg, Expanded\"]")
    private WebElement eggExpanded;


    /*
     * Egg Allergy Considerations - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Egg Allergy Considerations, Collapsed\"]")
    private WebElement eggAllergyCollapsed;


    /*
     * Egg Allergy Considerations - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Egg Allergy Considerations, Expanded\"]")
    private WebElement eggAllergyExpanded;


    /*
     * Egg-Free Diet Guidelines - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Egg-Free Diet Guidelines, Collapsed\"]")
    private WebElement eggFreeCollapsed;


    /*
     * Egg-Free Diet Guidelines - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Egg-Free Diet Guidelines, Expanded\"]")
    private WebElement eggFreeExpanded;


    /*
     * Hidden Sources of Egg - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Egg, Collapsed\"]")
    private WebElement hiddenEggCollapsed;


    /*
     * Hidden Sources of Egg - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Egg, Expanded\"]")
    private WebElement hiddenEggExpanded;


    // ======================== Fish ======================== //

    /*
     * Fish - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Fish, Collapsed\"]")
    private WebElement fishCollapsed;


    /*
     * Fish - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Fish, Expanded\"]")
    private WebElement fishExpanded;


    /*
     * Fish Allergy Considerations - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Fish Allergy Considerations, Collapsed\"]")
    private WebElement fishAllergyCollapsed;


    /*
     * Fish Allergy Considerations - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Fish Allergy Considerations, Expanded\"]")
    private WebElement fishAllergyExpanded;


    /*
     * Fish-Free Diet Guidelines - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Fish-Free Diet Guidelines, Collapsed\"]")
    private WebElement fishFreeCollapsed;


    /*
     * Fish-Free Diet Guidelines - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Fish-Free Diet Guidelines, Expanded\"]")
    private WebElement fishFreeExpanded;


    /*
     * Hidden Sources of Fish - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Fish, Collapsed\"]")
    private WebElement hiddenFishCollapsed;


    /*
     * Hidden Sources of Fish - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Fish, Expanded\"]")
    private WebElement hiddenFishExpanded;


    // ======================== Milk ======================== //

    /*
     * Milk - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Milk, Collapsed\"]")
    private WebElement milkCollapsed;


    /*
     * Milk - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Milk, Expanded\"]")
    private WebElement milkExpanded;


    /*
     * Hidden Sources of Milk - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Milk, Collapsed\"]")
    private WebElement hiddenMilkCollapsed;


    /*
     * Hidden Sources of Milk - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Milk, Expanded\"]")
    private WebElement hiddenMilkExpanded;


    /*
     * Milk Allergy Considerations - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Milk Allergy Considerations, Collapsed\"]")
    private WebElement milkAllergyCollapsed;


    /*
     * Milk Allergy Considerations - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Milk Allergy Considerations, Expanded\"]")
    private WebElement milkAllergyExpanded;


    /*
     * Milk-Free Diet Guidelines - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Milk-Free Diet Guidelines, Collapsed\"]")
    private WebElement milkFreeCollapsed;


    /*
     * Milk-Free Diet Guidelines - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Milk-Free Diet Guidelines, Expanded\"]")
    private WebElement milkFreeExpanded;


    // ======================== Peanuts ======================== //

    /*
     * Peanuts - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Peanuts, Collapsed\"]")
    private WebElement peanutsCollapsed;


    /*
     * Peanuts - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Peanuts, Expanded\"]")
    private WebElement peanutsExpanded;


    /*
     * Hidden Sources of Peanuts - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Peanuts, Collapsed\"]")
    private WebElement hiddenPeanutsCollapsed;


    /*
     * Hidden Sources of Peanuts - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Peanuts, Expanded\"]")
    private WebElement hiddenPeanutsExpanded;


    /*
     * Peanut Allergy Considerations - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Peanut Allergy Considerations, Collapsed\"]")
    private WebElement peanutAllergyCollapsed;


    /*
     * Peanut Allergy Considerations - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Peanut Allergy Considerations, Expanded\"]")
    private WebElement peanutAllergyExpanded;


    /*
     * Peanut-Free Diet Guidelines - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Peanut-Free Diet Guidelines, Collapsed\"]")
    private WebElement peanutFreeCollapsed;


    /*
     * Peanut-Free Diet Guidelines - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Peanut-Free Diet Guidelines, Expanded\"]")
    private WebElement peanutFreeExpanded;


    // ======================== Sesame ======================== //

    /*
     * Sesame - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Sesame, Collapsed\"]")
    private WebElement sesameCollapsed;


    /*
     * Sesame - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Sesame, Expanded\"]")
    private WebElement sesameExpanded;


    /*
     * Hidden Sources of Sesame - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Sesame, Collapsed\"]")
    private WebElement hiddenSesameCollapsed;


    /*
     * Hidden Sources of Sesame - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Sesame, Expanded\"]")
    private WebElement hiddenSesameExpanded;


    /*
     * Sesame-Free Diet Guidelines - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Sesame-Free Diet Guidelines, Collapsed\"]")
    private WebElement sesameFreeCollapsed;


    /*
     * Sesame-Free Diet Guidelines - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Sesame-Free Diet Guidelines, Expanded\"]")
    private WebElement sesameFreeExpanded;


    // ======================== Soy ======================== //

    /*
     * Soy - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Soy, Collapsed\"]")
    private WebElement soyCollapsed;


    /*
     * Soy - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Soy, Expanded\"]")
    private WebElement soyExpanded;


    /*
     * Hidden Sources of Soy - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Soy, Collapsed\"]")
    private WebElement hiddenSoyCollapsed;


    /*
     * Hidden Sources of Soy - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Soy, Expanded\"]")
    private WebElement hiddenSoyExpanded;


    /*
     * Soy Allergy Considerations - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Soy Allergy Considerations, Collapsed\"]")
    private WebElement soyAllergyCollapsed;


    /*
     * Soy Allergy Considerations - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Soy Allergy Considerations, Expanded\"]")
    private WebElement soyAllergyExpanded;


    /*
     * Soy-Free Diet Guidelines - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Soy-Free Diet Guidelines, Collapsed\"]")
    private WebElement soyFreeCollapsed;


    /*
     * Soy-Free Diet Guidelines - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Soy-Free Diet Guidelines, Expanded\"]")
    private WebElement soyFreeExpanded;


    // ======================== Tree Nuts ======================== //

    /*
     * Tree Nuts - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Tree Nuts, Collapsed\"]")
    private WebElement treeNutsCollapsed;


    /*
     * Tree Nuts - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Tree Nuts, Expanded\"]")
    private WebElement treeNutsExpanded;


    /*
     * Hidden Sources of Tree Nuts - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Tree Nuts, Collapsed\"]")
    private WebElement hiddenTreeNutsCollapsed;


    /*
     * Hidden Sources of Tree Nuts - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Tree Nuts, Expanded\"]")
    private WebElement hiddenTreeNutsExpanded;


    /*
     * Tree Nut Allergy Considerations - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Tree Nut Allergy Considerations, Collapsed\"]")
    private WebElement treeNutAllergyCollapsed;


    /*
     * Tree Nut Allergy Considerations - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Tree Nut Allergy Considerations, Expanded\"]")
    private WebElement treeNutAllergyExpanded;


    /*
     * Tree Nut-Free Diet Guidelines - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Tree Nut-Free Diet Guidelines, Collapsed\"]")
    private WebElement treeNutFreeCollapsed;


    /*
     * Tree Nut-Free Diet Guidelines - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Tree Nut-Free Diet Guidelines, Expanded\"]")
    private WebElement treeNutFreeExpanded;


    // ======================== Wheat ======================== //

    /*
     * Wheat - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Wheat, Collapsed\"]")
    private WebElement wheatCollapsed;


    /*
     * Wheat - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Wheat, Expanded\"]")
    private WebElement wheatExpanded;


    /*
     * Hidden Sources of Wheat - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Wheat, Collapsed\"]")
    private WebElement hiddenWheatCollapsed;


    /*
     * Hidden Sources of Wheat - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Hidden Sources of Wheat, Expanded\"]")
    private WebElement hiddenWheatExpanded;


    /*
     * Wheat-Free Diet Guidelines - Collapsed
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Wheat-Free Diet Guidelines, Collapsed\"]")
    private WebElement wheatFreeCollapsed;


    /*
     * Wheat-Free Diet Guidelines - Expanded
     */
    @AndroidFindBy(
            xpath = "//android.view.View[@content-desc=\"Wheat-Free Diet Guidelines, Expanded\"]")
    private WebElement wheatFreeExpanded;


    // ======================== Header Methods ======================== //

    /*
     * Verify Cooking Facts Header
     */
    public void verifyCookingFactsHeader() {

        waitUtil.waitForElementVisible(
                cookingFactsHeader);

        System.out.println(
                "Cooking Facts header displayed.");
    }


    /*
     * Verify Culinary Abbreviations Header
     */
    public void verifyCulinaryAbbreviationsHeader() {

        scrollToElement(
                "//android.view.View[@content-desc=\"Culinary Abbreviations & Measures / Equivalents\"]",
                "Culinary Abbreviations & Measures / Equivalents");

        System.out.println(
                "Culinary Abbreviations & Measures / Equivalents displayed.");
    }


    /*
     * Verify Time And Temperature Header
     */
    public void verifyTimeTemperatureHeader() {

        scrollToElement(
                "//android.view.View[@content-desc=\"Time and Temperature Control \"]",
                "Time and Temperature Control");

        System.out.println(
                "Time and Temperature Control displayed.");
    }


    /*
     * Verify Stages Of Sugar Header
     */
    public void verifyStagesOfSugarHeader() {

        scrollToElement(
                "//android.view.View[@content-desc=\"Stages of Sugar\"]",
                "Stages of Sugar");

        System.out.println(
                "Stages of Sugar displayed.");
    }


    /*
     * Verify Cool Food Header
     */
    public void verifyCoolFoodHeader() {

        scrollToElement(
                "//android.view.View[@content-desc=\"Cool Food in Two Stages\"]",
                "Cool Food in Two Stages");

        System.out.println(
                "Cool Food in Two Stages displayed.");
    }


    /*
     * Verify Avoiding Your Allergen Header
     */
    public void verifyAvoidingYourAllergenHeader() {

        scrollToElement(
                "//android.view.View[@content-desc=\"Avoiding Your Allergen\"]",
                "Avoiding Your Allergen");

        System.out.println(
                "Avoiding Your Allergen displayed.");
    }


    // ======================== Top Level Allergen Methods ======================== //

    /*
     * Expand All 9 Allergens
     */
    public void expandAllNineAllergens() {

        expandAccordion(
                "All 9 Allergens");

    }


    /*
     * Expand Crustacean Shellfish
     */
    public void expandCrustaceanShellfish() {

        expandAccordion(
                "Crustacean Shellfish");

    }


    /*
     * Expand Egg
     */
    public void expandEgg() {

        expandAccordion(
                "Egg");

    }


    /*
     * Expand Fish
     */
    public void expandFish() {

        expandAccordion(
                "Fish");

    }


    /*
     * Expand Milk
     */
    public void expandMilk() {

        expandAccordion(
                "Milk");

    }


    /*
     * Expand Peanuts
     */
    public void expandPeanuts() {

        expandAccordion(
                "Peanuts");

    }


    /*
     * Expand Sesame
     */
    public void expandSesame() {

        expandAccordion(
                "Sesame");

    }


    /*
     * Expand Soy
     */
    public void expandSoy() {

        expandAccordion(
                "Soy");

    }


    /*
     * Expand Tree Nuts
     */
    public void expandTreeNuts() {

        expandAccordion(
                "Tree Nuts");

    }


    /*
     * Expand Wheat
     */
    public void expandWheat() {

        expandAccordion(
                "Wheat");

    }


    // ======================== Accordion Methods ======================== //

    /*
     * Click Abbreviations
     */
    public void clickAbbreviations() {

        clickAccordion(
                "Abbreviations");

    }


    /*
     * Click US Customary
     */
    public void clickUSCustomary() {

        clickAccordion(
                "US Customary");

    }


    /*
     * Click SI (Metric)
     */
    public void clickSIMetric() {

        clickAccordion(
                "SI (Metric)");

    }


    /*
     * Click Others
     */
    public void clickOthers() {

        clickAccordion(
                "Others");

    }


    /*
     * Click Measures And Equivalents
     */
    public void clickMeasuresAndEquivalents() {

        clickAccordion(
                "Measures and Equivalents");

    }


    /*
     * Click Weights And Equivalents
     */
    public void clickWeightsAndEquivalents() {

        clickAccordion(
                "Weights and Equivalents");

    }


    /*
     * Click Cooking Temperatures
     */
    public void clickCookingTemperatures() {

        clickAccordion(
                "Cooking Temperatures");

    }


    /*
     * Click Sugar Stages
     */
    public void clickSugarStages() {

        clickAccordion(
                "Sugar Stages");

    }


    /*
     * Click Cooling Stages
     */
    public void clickCoolingStages() {

        clickAccordion(
                "Cooling Stages");

    }


    /*
     * Click Understanding Food Allergen Labels
     */
    public void clickUnderstandingFoodAllergenLabels() {

        clickAccordion(
                "Understanding Food Allergen Labels");

    }


    /*
     * Click Crustacean Shellfish-Free Diet Guidelines
     */
    public void clickCrustacean() {

        clickAccordion(
                "Crustacean Shellfish-Free Diet Guidelines");

    }


    /*
     * Click Hidden Sources Of Shellfish
     */
    public void clickHiddenSourcesOfShellfish() {

        clickAccordion(
                "Hidden Sources of Shellfish");

    }


    /*
     * Click Shellfish Allergy Considerations
     */
    public void clickShellfishAllergy() {

        clickAccordion(
                "Shellfish Allergy Considerations");

    }


    /*
     * Click Egg Allergy Considerations
     */
    public void clickEggAllergy() {

        clickAccordion(
                "Egg Allergy Considerations");

    }


    /*
     * Click Egg-Free Diet Guidelines
     */
    public void clickEggFree() {

        clickAccordion(
                "Egg-Free Diet Guidelines");

    }


    /*
     * Click Hidden Sources Of Egg
     */
    public void clickHiddenSourcesOfEgg() {

        clickAccordion(
                "Hidden Sources of Egg");

    }


    /*
     * Click Fish Allergy Considerations
     */
    public void clickFishAllergy() {

        clickAccordion(
                "Fish Allergy Considerations");

    }


    /*
     * Click Fish-Free Diet Guidelines
     */
    public void clickFishFree() {

        clickAccordion(
                "Fish-Free Diet Guidelines");

    }


    /*
     * Click Hidden Sources Of Fish
     */
    public void clickHiddenSourcesOfFish() {

        clickAccordion(
                "Hidden Sources of Fish");

    }


    /*
     * Click Hidden Sources Of Milk
     */
    public void clickHiddenSourcesOfMilk() {

        clickAccordion(
                "Hidden Sources of Milk");

    }


    /*
     * Click Milk Allergy Considerations
     */
    public void clickMilkAllergy() {

        clickAccordion(
                "Milk Allergy Considerations");

    }


    /*
     * Click Milk-Free Diet Guidelines
     */
    public void clickMilkFree() {

        clickAccordion(
                "Milk-Free Diet Guidelines");

    }


    /*
     * Click Hidden Sources Of Peanuts
     */
    public void clickHiddenSourcesOfPeanuts() {

        clickAccordion(
                "Hidden Sources of Peanuts");

    }


    /*
     * Click Peanut Allergy Considerations
     */
    public void clickPeanutAllergy() {

        clickAccordion(
                "Peanut Allergy Considerations");

    }


    /*
     * Click Peanut-Free Diet Guidelines
     */
    public void clickPeanutFree() {

        clickAccordion(
                "Peanut-Free Diet Guidelines");

    }


    /*
     * Click Hidden Sources Of Sesame
     */
    public void clickHiddenSourcesOfSesame() {

        clickAccordion(
                "Hidden Sources of Sesame");

    }


    /*
     * Click Sesame-Free Diet Guidelines
     */
    public void clickSesameFree() {

        clickAccordion(
                "Sesame-Free Diet Guidelines");

    }


    /*
     * Click Hidden Sources Of Soy
     */
    public void clickHiddenSourcesOfSoy() {

        clickAccordion(
                "Hidden Sources of Soy");

    }


    /*
     * Click Soy Allergy Considerations
     */
    public void clickSoyAllergy() {

        clickAccordion(
                "Soy Allergy Considerations");

    }


    /*
     * Click Soy-Free Diet Guidelines
     */
    public void clickSoyFree() {

        clickAccordion(
                "Soy-Free Diet Guidelines");

    }


    /*
     * Click Hidden Sources Of Tree Nuts
     */
    public void clickHiddenSourcesOfTreeNuts() {

        clickAccordion(
                "Hidden Sources of Tree Nuts");

    }


    /*
     * Click Tree Nut Allergy Considerations
     */
    public void clickTreeNutAllergy() {

        clickAccordion(
                "Tree Nut Allergy Considerations");

    }


    /*
     * Click Tree Nut-Free Diet Guidelines
     */
    public void clickTreeNutFree() {

        clickAccordion(
                "Tree Nut-Free Diet Guidelines");

    }


    /*
     * Click Hidden Sources Of Wheat
     */
    public void clickHiddenSourcesOfWheat() {

        clickAccordion(
                "Hidden Sources of Wheat");

    }


    /*
     * Click Wheat-Free Diet Guidelines
     */
    public void clickWheatFree() {

        clickAccordion(
                "Wheat-Free Diet Guidelines");

    }


    // ======================== Coordinate Scroll ======================== //

    /*
     * Scroll Down Until Element Is Visible
     */
    private WebElement scrollToElement(
            String xpath,
            String elementName) {

        for (int attempt = 1;
                attempt <= 15;
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
                 * Continue with coordinate swipe.
                 */
            }

            swipeDownByCoordinates();

            System.out.println(
                    "Coordinate scroll performed for : "
                            + elementName
                            + " | Attempt : "
                            + attempt);
        }

        throw new RuntimeException(
                "Element could not be found after scrolling : "
                        + elementName);
    }


    /*
     * Swipe To Next Content
     *
     * Finger moves upward.
     * Content moves upward and lower
     * Cooking Facts items become visible.
     */
    private void swipeDownByCoordinates() {

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

        waitUtil.sleep(
                1000);
    }


    /*
     * Scroll To Top By Coordinates
     */
    public void scrollUpToTop() {

        for (int attempt = 1;
                attempt <= 21;
                attempt++) {

            try {

                WebElement header =
                        driver.findElement(
                                AppiumBy.xpath(
                                        "//android.view.View[@content-desc=\"COOKING FACTS\"]"));

                if (header.isDisplayed()) {

                    System.out.println(
                            "Cooking Facts header visible. "
                                    + "Already at top.");

                    return;
                }

            }

            catch (Exception e) {

                /*
                 * Header is not currently visible.
                 * Continue scrolling towards top.
                 */
            }

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

            System.out.println(
                    "Swipe to top performed | Attempt : "
                            + attempt);

            waitUtil.sleep(
                    1000);
        }

        throw new RuntimeException(
                "Cooking Facts could not be scrolled to top.");
    }


    // ======================== Generic Accordion ======================== //

    /*
     * Click Accordion
     *
     * Used for individual accordions.
     *
     * If the accordion is collapsed,
     * it will be expanded.
     *
     * If the accordion is already expanded,
     * it will be collapsed.
     */
    private void clickAccordion(
            String accordionName) {

        String collapsedXpath =
                "//android.view.View[@content-desc=\""
                        + accordionName
                        + ", Collapsed\"]";

        String expandedXpath =
                "//android.view.View[@content-desc=\""
                        + accordionName
                        + ", Expanded\"]";

        /*
         * First Search For Collapsed State
         */
        try {

            WebElement accordion =
                    findAccordionWithScroll(
                            collapsedXpath,
                            accordionName
                                    + ", Collapsed");

            waitUtil.clickWithWait(
                    accordion);

            System.out.println(
                    accordionName
                            + " expanded.");

            return;
        }

        catch (Exception e) {

            /*
             * Collapsed state was not found.
             * Check if accordion is already expanded.
             */
        }

        /*
         * Search For Expanded State
         */
        WebElement accordion =
                findAccordionWithScroll(
                        expandedXpath,
                        accordionName
                                + ", Expanded");

        waitUtil.clickWithWait(
                accordion);

        System.out.println(
                accordionName
                        + " collapsed.");
    }


    /*
     * Expand Accordion
     *
     * Used for parent accordions:
     *
     * All 9 Allergens
     * Crustacean Shellfish
     * Egg
     * Fish
     * Milk
     * Peanuts
     * Sesame
     * Soy
     * Tree Nuts
     * Wheat
     *
     * If already expanded, it does not click again.
     */
    private void expandAccordion(
            String accordionName) {

        String collapsedXpath =
                "//android.view.View[@content-desc=\""
                        + accordionName
                        + ", Collapsed\"]";

        String expandedXpath =
                "//android.view.View[@content-desc=\""
                        + accordionName
                        + ", Expanded\"]";

        /*
         * Check If Already Expanded
         */
        List<WebElement> expandedElements =
                driver.findElements(
                        AppiumBy.xpath(
                                expandedXpath));

        for (WebElement element :
                expandedElements) {

            try {

                if (element.isDisplayed()) {

                    System.out.println(
                            accordionName
                                    + " is already expanded.");

                    return;
                }

            }

            catch (Exception e) {

                /*
                 * Continue searching.
                 */
            }
        }

        /*
         * Find Collapsed Accordion
         */
        WebElement collapsed =
                findAccordionWithScroll(
                        collapsedXpath,
                        accordionName
                                + ", Collapsed");

        waitUtil.clickWithWait(
                collapsed);

        /*
         * Wait Until Expanded
         */
        new WebDriverWait(
                driver,
                Duration.ofSeconds(10))
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        AppiumBy.xpath(
                                                expandedXpath)));

        System.out.println(
                accordionName
                        + " expanded successfully.");
    }


    /*
     * Find Accordion With Coordinate Scroll
     */
    private WebElement findAccordionWithScroll(
            String xpath,
            String elementName) {

        for (int attempt = 1;
                attempt <= 15;
                attempt++) {

            try {

                WebElement element =
                        driver.findElement(
                                AppiumBy.xpath(
                                        xpath));

                if (element.isDisplayed()) {

                    System.out.println(
                            "Accordion visible : "
                                    + elementName
                                    + " | Attempt : "
                                    + attempt);

                    return element;
                }

            }

            catch (Exception e) {

                /*
                 * Accordion is not currently visible.
                 * Continue scrolling.
                 */
            }

            /*
             * Scroll only after confirming that
             * the required accordion is not visible.
             */
            swipeDownByCoordinates();

            System.out.println(
                    "Scrolling to accordion : "
                            + elementName
                            + " | Attempt : "
                            + attempt);
        }

        throw new RuntimeException(
                "Accordion could not be found : "
                        + elementName);
    }

}