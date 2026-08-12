package pagesObjects.Profile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.WaitUtil;

public class Nutrition_Tab {

    private final AndroidDriver driver;

    private final WaitUtil waitUtil;

    public Nutrition_Tab(
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
     * Nutrition Tab
     */
    private WebElement nutritionTab() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ImageView[@content-desc='Nutrition\nTab 2 of 4']"));
    }

    /*
     * Verify Nutrition Tab
     */
    public boolean isNutritionTabDisplayed() {

        try {

            return nutritionTab()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Nutrition Tab
     */
    public void clickNutritionTab() {

        waitUtil.clickWithWait(
                nutritionTab());

        System.out.println(
                "Nutrition Tab clicked.");
    }

        /*
     * Nutrient Profile Heading
     */
    private WebElement nutrientProfileHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Nutrient Profile']"));
    }

    /*
     * Nutrition Profile Description
     */
    private WebElement nutritionProfileDescription() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Set the percentage of daily calories from each macro. Ranges are used for meal planning and recipe filtering.']"));
    }

    /*
     * Save Button
     */
    private WebElement saveButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.widget.Button"));
    }

    /*
     * Verify Nutrient Profile Heading
     */
    public boolean isNutrientProfileDisplayed() {

        try {

            return nutrientProfileHeading()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Nutrient Profile Heading
     */
    public String getNutrientProfileHeading() {

        String heading =
                nutrientProfileHeading()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Nutrient Profile Heading : "
                        + heading);

        return heading;
    }

    /*
     * Verify Nutrition Profile Description
     */
    public boolean isNutritionProfileDescriptionDisplayed() {

        try {

            return nutritionProfileDescription()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Nutrition Profile Description
     */
    public String getNutritionProfileDescription() {

        String description =
                nutritionProfileDescription()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Nutrition Profile Description :");

        System.out.println(
                description);

        return description;
    }

    /*
     * Verify Save Button
     */
    public boolean isSaveButtonDisplayed() {

        try {

            return saveButton()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Verify Save Button Enabled
     */
    public boolean isSaveButtonEnabled() {

        try {

            return saveButton()
                    .isEnabled();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Save Button
     */
    public void clickSaveButton() {

        waitUtil.clickWithWait(
                saveButton());

        waitUtil.sleep(
                2000);

        System.out.println(
                "Save button clicked.");
    }

        /*
     * Fat Section Heading
     */
    private WebElement fatSectionHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Fat']"));
    }

    /*
     * Fat Min % Heading
     */
    private WebElement fatMinHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "(//android.widget.ScrollView/android.view.View[@content-desc='Min %'])[1]"));
    }

    /*
     * Fat Max % Heading
     */
    private WebElement fatMaxHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "(//android.widget.ScrollView/android.view.View[@content-desc='Max %'])[1]"));
    }

    /*
 * Fat Min % Input Field
 */
private WebElement fatMinPercentageField() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Fat']/following::android.widget.EditText[1]"));
}

/*
 * Fat Max % Input Field
 */
private WebElement fatMaxPercentageField() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Fat']/following::android.widget.EditText[2]"));
}

    /*
     * Verify Fat Section
     */
    public boolean isFatSectionDisplayed() {

        try {

            return fatSectionHeading()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Fat Section Heading
     */
    public String getFatSectionHeading() {

        String heading =
                fatSectionHeading()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Fat Section Heading : "
                        + heading);

        return heading;
    }

    /*
     * Get Fat Min Percentage
     */
    public String getFatMinPercentage() {

        String fatMin =
                fatMinPercentageField()
                        .getAttribute(
                                "text");

        System.out.println(
                "Fat Min Percentage : "
                        + fatMin);

        return fatMin;
    }

    /*
     * Get Fat Max Percentage
     */
    public String getFatMaxPercentage() {

        String fatMax =
                fatMaxPercentageField()
                        .getAttribute(
                                "text");

        System.out.println(
                "Fat Max Percentage : "
                        + fatMax);

        return fatMax;
    }

    /*
 * Enter Fat Min Percentage
 */
public void enterFatMinPercentage(
        String fatMin) {

    waitUtil.clickWithWait(
            fatMinPercentageField());

    waitUtil.sleep(
            1000);

    WebElement activeField =
            driver.switchTo()
                    .activeElement();

    activeField.clear();

    waitUtil.sleep(
            500);

    activeField.sendKeys(
            fatMin);

    waitUtil.sleep(
            1000);

    try {

        driver.hideKeyboard();

    }

    catch (Exception e) {

    }

    System.out.println(
            "Fat Min Percentage Entered : "
                    + fatMin);
}

    /*
 * Enter Fat Max Percentage
 */
public void enterFatMaxPercentage(
        String fatMax) {

    waitUtil.clickWithWait(
            fatMaxPercentageField());

    waitUtil.sleep(
            1000);

    WebElement activeField =
            driver.switchTo()
                    .activeElement();

    activeField.clear();

    waitUtil.sleep(
            500);

    activeField.sendKeys(
            fatMax);

    waitUtil.sleep(
            1000);

    try {

        driver.hideKeyboard();

    }

    catch (Exception e) {

    }

    System.out.println(
            "Fat Max Percentage Entered : "
                    + fatMax);
}

    /*
     * Update Fat Percentage
     */
    public void updateFatPercentage(
            String fatMin,
            String fatMax) {

        enterFatMinPercentage(
                fatMin);

        enterFatMaxPercentage(
                fatMax);
    }

        /*
     * Carbohydrates Section Heading
     */
    private WebElement carbohydratesSectionHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Carbohydrates']"));
    }

    /*
     * Carbohydrates Min % Heading
     */
    private WebElement carbohydratesMinHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "(//android.widget.ScrollView/android.view.View[@content-desc='Min %'])[2]"));
    }

    /*
     * Carbohydrates Max % Heading
     */
    private WebElement carbohydratesMaxHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "(//android.widget.ScrollView/android.view.View[@content-desc='Max %'])[2]"));
    }

    /*
 * Carbohydrates Min % Input Field
 */
private WebElement carbohydratesMinPercentageField() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Carbohydrates']/following::android.widget.EditText[1]"));
}

/*
 * Carbohydrates Max % Input Field
 */
private WebElement carbohydratesMaxPercentageField() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Carbohydrates']/following::android.widget.EditText[2]"));
}

    /*
     * Verify Carbohydrates Section
     */
    public boolean isCarbohydratesSectionDisplayed() {

        try {

            return carbohydratesSectionHeading()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Carbohydrates Section Heading
     */
    public String getCarbohydratesSectionHeading() {

        String heading =
                carbohydratesSectionHeading()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Carbohydrates Section Heading : "
                        + heading);

        return heading;
    }

    /*
     * Get Carbohydrates Min Percentage
     */
    public String getCarbohydratesMinPercentage() {

        String carbohydratesMin =
                carbohydratesMinPercentageField()
                        .getAttribute(
                                "text");

        System.out.println(
                "Carbohydrates Min Percentage : "
                        + carbohydratesMin);

        return carbohydratesMin;
    }

    /*
     * Get Carbohydrates Max Percentage
     */
    public String getCarbohydratesMaxPercentage() {

        String carbohydratesMax =
                carbohydratesMaxPercentageField()
                        .getAttribute(
                                "text");

        System.out.println(
                "Carbohydrates Max Percentage : "
                        + carbohydratesMax);

        return carbohydratesMax;
    }

    /*
 * Enter Carbohydrates Min Percentage
 */
public void enterCarbohydratesMinPercentage(
        String carbohydratesMin) {

    waitUtil.clickWithWait(
            carbohydratesMinPercentageField());

    waitUtil.sleep(
            1000);

    WebElement activeField =
            driver.switchTo()
                    .activeElement();

    activeField.clear();

    waitUtil.sleep(
            500);

    activeField.sendKeys(
            carbohydratesMin);

    waitUtil.sleep(
            1000);

    try {

        driver.hideKeyboard();

    }

    catch (Exception e) {

    }

    System.out.println(
            "Carbohydrates Min Percentage Entered : "
                    + carbohydratesMin);
}

    /*
 * Enter Carbohydrates Max Percentage
 */
public void enterCarbohydratesMaxPercentage(
        String carbohydratesMax) {

    waitUtil.clickWithWait(
            carbohydratesMaxPercentageField());

    waitUtil.sleep(
            1000);

    WebElement activeField =
            driver.switchTo()
                    .activeElement();

    activeField.clear();

    waitUtil.sleep(
            500);

    activeField.sendKeys(
            carbohydratesMax);

    waitUtil.sleep(
            1000);

    try {

        driver.hideKeyboard();

    }

    catch (Exception e) {

    }

    System.out.println(
            "Carbohydrates Max Percentage Entered : "
                    + carbohydratesMax);
}

    /*
     * Update Carbohydrates Percentage
     */
    public void updateCarbohydratesPercentage(
            String carbohydratesMin,
            String carbohydratesMax) {

        enterCarbohydratesMinPercentage(
                carbohydratesMin);

        enterCarbohydratesMaxPercentage(
                carbohydratesMax);
    }

        /*
     * Protein Section Heading
     */
    private WebElement proteinSectionHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Protein']"));
    }

    /*
     * Protein Min % Heading
     */
    private WebElement proteinMinHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "(//android.widget.ScrollView/android.view.View[@content-desc='Min %'])[3]"));
    }

    /*
     * Protein Max % Heading
     */
    private WebElement proteinMaxHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "(//android.widget.ScrollView/android.view.View[@content-desc='Max %'])[3]"));
    }

    /*
 * Protein Min % Input Field
 */
private WebElement proteinMinPercentageField() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Protein']/following::android.widget.EditText[1]"));
}

/*
 * Protein Max % Input Field
 */
private WebElement proteinMaxPercentageField() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Protein']/following::android.widget.EditText[2]"));
}

    /*
     * Verify Protein Section
     */
    public boolean isProteinSectionDisplayed() {

        try {

            return proteinSectionHeading()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Protein Section Heading
     */
    public String getProteinSectionHeading() {

        String heading =
                proteinSectionHeading()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Protein Section Heading : "
                        + heading);

        return heading;
    }

    /*
     * Get Protein Min Percentage
     */
    public String getProteinMinPercentage() {

        String proteinMin =
                proteinMinPercentageField()
                        .getAttribute(
                                "text");

        System.out.println(
                "Protein Min Percentage : "
                        + proteinMin);

        return proteinMin;
    }

    /*
     * Get Protein Max Percentage
     */
    public String getProteinMaxPercentage() {

        String proteinMax =
                proteinMaxPercentageField()
                        .getAttribute(
                                "text");

        System.out.println(
                "Protein Max Percentage : "
                        + proteinMax);

        return proteinMax;
    }

    /*
 * Enter Protein Min Percentage
 */
public void enterProteinMinPercentage(
        String proteinMin) {

    waitUtil.clickWithWait(
            proteinMinPercentageField());

    waitUtil.sleep(
            1000);

    WebElement activeField =
            driver.switchTo()
                    .activeElement();

    activeField.clear();

    waitUtil.sleep(
            500);

    activeField.sendKeys(
            proteinMin);

    waitUtil.sleep(
            1000);

    try {

        driver.hideKeyboard();

    }

    catch (Exception e) {

    }

    System.out.println(
            "Protein Min Percentage Entered : "
                    + proteinMin);
}

    /*
 * Enter Protein Max Percentage
 */
public void enterProteinMaxPercentage(
        String proteinMax) {

    waitUtil.clickWithWait(
            proteinMaxPercentageField());

    waitUtil.sleep(
            1000);

    WebElement activeField =
            driver.switchTo()
                    .activeElement();

    activeField.clear();

    waitUtil.sleep(
            500);

    activeField.sendKeys(
            proteinMax);

    waitUtil.sleep(
            1000);

    try {

        driver.hideKeyboard();

    }

    catch (Exception e) {

    }

    System.out.println(
            "Protein Max Percentage Entered : "
                    + proteinMax);
}

    /*
     * Update Protein Percentage
     */
    public void updateProteinPercentage(
            String proteinMin,
            String proteinMax) {

        enterProteinMinPercentage(
                proteinMin);


        enterProteinMaxPercentage(
                proteinMax);
        
    }

        /*
     * Daily Calorie Intake Section Heading
     */
    private WebElement dailyCalorieIntakeSectionHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Daily Calorie Intake']"));
    }

    /*
     * Daily Calorie Intake Min Heading
     */
    private WebElement dailyCalorieMinHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Min']"));
    }

    /*
     * Daily Calorie Intake Max Heading
     */
    private WebElement dailyCalorieMaxHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Max']"));
    }

    /*
 * Daily Calorie Intake Min Input Field
 */
private WebElement dailyCalorieMinField() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Daily Calorie Intake']/following::android.widget.EditText[1]"));
}

/*
 * Daily Calorie Intake Max Input Field
 */
private WebElement dailyCalorieMaxField() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Daily Calorie Intake']/following::android.widget.EditText[2]"));
}

    /*
     * Verify Daily Calorie Intake Section
     */
    public boolean isDailyCalorieIntakeSectionDisplayed() {

        try {

            return dailyCalorieIntakeSectionHeading()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Daily Calorie Intake Heading
     */
    public String getDailyCalorieIntakeHeading() {

        String heading =
                dailyCalorieIntakeSectionHeading()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Daily Calorie Intake Heading : "
                        + heading);

        return heading;
    }

    /*
 * Get Daily Calorie Intake Min Value
 */
public String getDailyCalorieMinValue() {

    waitUtil.clickWithWait(
            dailyCalorieMinField());

    waitUtil.sleep(
            1000);

    WebElement activeField =
            driver.switchTo()
                    .activeElement();

    String minValue =
            activeField.getAttribute(
                    "text");

    System.out.println(
            "Daily Calorie Intake Min Value : "
                    + minValue);

    return minValue;
}

    /*
 * Get Daily Calorie Intake Max Value
 */
public String getDailyCalorieMaxValue() {

    waitUtil.clickWithWait(
            dailyCalorieMaxField());

    waitUtil.sleep(
            1000);

    WebElement activeField =
            driver.switchTo()
                    .activeElement();

    String maxValue =
            activeField.getAttribute(
                    "text");

    System.out.println(
            "Daily Calorie Intake Max Value : "
                    + maxValue);

    return maxValue;
}

    /*
 * Enter Daily Calorie Intake Min Value
 */
public void enterDailyCalorieMinValue(
        String minValue) {

    waitUtil.clickWithWait(
            dailyCalorieMinField());

    waitUtil.sleep(
            1000);

    WebElement activeField =
            driver.switchTo()
                    .activeElement();

    activeField.clear();

    waitUtil.sleep(
            500);

    activeField.sendKeys(
            minValue);

    waitUtil.sleep(
            1000);

    try {

        driver.hideKeyboard();

    }

    catch (Exception e) {

    }

    System.out.println(
            "Daily Calorie Intake Min Value Entered : "
                    + minValue);
}

    /*
 * Enter Daily Calorie Intake Max Value
 */
public void enterDailyCalorieMaxValue(
        String maxValue) {

    waitUtil.clickWithWait(
            dailyCalorieMaxField());

    waitUtil.sleep(
            1000);

    WebElement activeField =
            driver.switchTo()
                    .activeElement();

    activeField.clear();

    waitUtil.sleep(
            500);

    activeField.sendKeys(
            maxValue);

    waitUtil.sleep(
            1000);

    try {

        driver.hideKeyboard();

    }

    catch (Exception e) {

    }

    System.out.println(
            "Daily Calorie Intake Max Value Entered : "
                    + maxValue);
}

    /*
     * Update Daily Calorie Intake
     */
    public void updateDailyCalorieIntake(
            String minValue,
            String maxValue) {

        enterDailyCalorieMinValue(
                minValue);


        enterDailyCalorieMaxValue(
                maxValue);

    }

        /*
     * Vitamin & Mineral Present Heading
     */
    private WebElement vitaminMineralPresentHeading() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Vitamin & Mineral Present']"));
    }

    /*
     * Vitamin & Mineral Add Button
     */
    private WebElement vitaminMineralAddButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.widget.Button"));
    }

    /*
     * Export CSV Button
     */
    private WebElement exportCsvButton() {

        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.ImageView[@content-desc='Export as CSV']"));
    }

    /*
     * Verify Vitamin & Mineral Present Heading
     */
    public boolean isVitaminMineralPresentDisplayed() {

        try {

            return vitaminMineralPresentHeading()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Get Vitamin & Mineral Present Heading
     */
    public String getVitaminMineralPresentHeading() {

        String heading =
                vitaminMineralPresentHeading()
                        .getAttribute(
                                "content-desc");

        System.out.println(
                "Vitamin & Mineral Present Heading : "
                        + heading);

        return heading;
    }

    /*
     * Verify Vitamin & Mineral Add Button
     */
    public boolean isVitaminMineralAddButtonDisplayed() {

        try {

            return vitaminMineralAddButton()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Vitamin & Mineral Add Button
     */
    public void clickVitaminMineralAddButton() {

        waitUtil.clickWithWait(
                vitaminMineralAddButton());

        waitUtil.sleep(
                1000);

        System.out.println(
                "Vitamin & Mineral Add button clicked.");
    }

    /*
     * Verify Export CSV Button
     */
    public boolean isExportCsvButtonDisplayed() {

        try {

            return exportCsvButton()
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;
        }
    }

    /*
     * Click Export CSV Button
     */
    public void clickExportCsvButton() {

        waitUtil.clickWithWait(
                exportCsvButton());

        waitUtil.sleep(
                2000);

        System.out.println(
                "Export CSV button clicked.");
    }

        /*
     * Update Nutrition Profile
     */
    public void updateNutritionProfile(
            String fatMin,
            String fatMax,
            String carbohydratesMin,
            String carbohydratesMax,
            String proteinMin,
            String proteinMax,
            String calorieMin,
            String calorieMax) {

        /*
         * Update Fat
         */
        updateFatPercentage(
                fatMin,
                fatMax);

        /*
         * Update Carbohydrates
         */
        updateCarbohydratesPercentage(
                carbohydratesMin,
                carbohydratesMax);

        /*
         * Update Protein
         */
        updateProteinPercentage(
                proteinMin,
                proteinMax);

        /*
         * Update Daily Calorie Intake
         */
        updateDailyCalorieIntake(
                calorieMin,
                calorieMax);

        /*
         * Save Nutrition Profile
         */
        clickSaveButton();

        waitUtil.sleep(
                2000);

        System.out.println(
                "Nutrition Profile Updated.");
    }

    /*
     * Scroll To Vitamin & Mineral Section
     */
    public void scrollToVitaminMineralSection() {

        int maxScrolls =
                10;

        for (int i = 0; i < maxScrolls; i++) {

            try {

                if (vitaminMineralPresentHeading()
                        .isDisplayed()) {

                    System.out.println(
                            "Vitamin & Mineral section displayed.");

                    return;
                }

            }

            catch (Exception e) {

            }

            scrollDown();

            waitUtil.sleep(
                    800);
        }

        System.out.println(
                "Vitamin & Mineral section not found.");
    }

    /*
     * Scroll To Export CSV Button
     */
    public void scrollToExportCsvButton() {

        int maxScrolls =
                10;

        for (int i = 0; i < maxScrolls; i++) {

            try {

                if (exportCsvButton()
                        .isDisplayed()) {

                    System.out.println(
                            "Export CSV button displayed.");

                    return;
                }

            }

            catch (Exception e) {

            }

            scrollDown();

            waitUtil.sleep(
                    800);
        }

        System.out.println(
                "Export CSV button not found.");
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

            System.out.println(
                    "Reached bottom of page.");
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

            System.out.println(
                    "Reached top of page.");
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
    * Hide Keyboard
    */
    public void hideKeyboard() {

        try {

            driver.hideKeyboard();

            waitUtil.sleep(
                    500);

            System.out.println(
                    "Keyboard hidden.");

        }

        catch (Exception e) {

            System.out.println(
                    "Keyboard already hidden.");
        }
    }

/*
 * Fat Min Max Validation
 */
private WebElement fatMinMaxValidation() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Fat: min must be lower than max']"));
}

/*
 * Verify Fat Min Max Validation
 */
public boolean isFatMinMaxValidationDisplayed() {

    try {

        return fatMinMaxValidation()
                .isDisplayed();

    }

    catch (Exception e) {

        return false;
    }
}

/*
 * Carbohydrates Min Max Validation
 */
private WebElement carbohydratesMinMaxValidation() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Carbohydrates: min must be lower than max']"));
}

/*
 * Verify Carbohydrates Min Max Validation
 */
public boolean isCarbohydratesMinMaxValidationDisplayed() {

    try {

        return carbohydratesMinMaxValidation()
                .isDisplayed();

    }

    catch (Exception e) {

        return false;
    }
}

/*
 * Protein Min Max Validation
 */
private WebElement proteinMinMaxValidation() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Protein: min must be lower than max']"));
}

/*
 * Verify Protein Min Max Validation
 */
public boolean isProteinMinMaxValidationDisplayed() {

    try {

        return proteinMinMaxValidation()
                .isDisplayed();

    }

    catch (Exception e) {

        return false;
    }
}

/*
 * Daily Calorie Min Max Validation
 */
private WebElement dailyCalorieMinMaxValidation() {

    return driver.findElement(
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Calories: min must be lower than max']"));
}

/*
 * Verify Daily Calorie Min Max Validation
 */
public boolean isDailyCalorieMinMaxValidationDisplayed() {

    try {

        return dailyCalorieMinMaxValidation()
                .isDisplayed();

    }

    catch (Exception e) {

        return false;
    }
}

}