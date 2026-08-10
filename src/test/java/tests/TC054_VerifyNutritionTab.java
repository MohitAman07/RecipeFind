package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Home.HomeDashboard;
import pagesObjects.Profile.Nutrition_Tab;
import pagesObjects.Profile.Personal_Tab;
import utils.ValidationUtil;

public class TC054_VerifyNutritionTab extends BaseTest {

        @Test
    public void verifyNutritionTab()
            throws Exception {

        HomeDashboard home =
                new HomeDashboard(
                        DriverFactory.getDriver());

        Personal_Tab personalTab =
                new Personal_Tab(
                        DriverFactory.getDriver());

        Nutrition_Tab nutritionTab =
                new Nutrition_Tab(
                        DriverFactory.getDriver());
                

        String fatMin =
                "20";

        String fatMax =
                "35";

        String carbohydratesMin =
                "40";

        String carbohydratesMax =
                "55";

        String proteinMin =
                "20";

        String proteinMax =
                "35";

        String calorieMin =
                "1800";

        String calorieMax =
                "2200";

        /*
         * Verify Profile Button
         */
        ValidationUtil.verifyTrue(
                home.isProfileButtonVisible(),
                "Profile button displayed successfully.");

        /*
         * Click Profile Button
         */
        home.clickProfileButton();

        Thread.sleep(
                3000);

        /*
         * Verify Personal Tab
         */
        ValidationUtil.verifyTrue(
                personalTab.isPersonalTabDisplayed(),
                "Personal tab displayed successfully.");

        /*
         * Click Nutrition Tab
         */
        nutritionTab.clickNutritionTab();

        Thread.sleep(
                3000);

        /*
         * Verify Nutrition Tab
         */
        ValidationUtil.verifyTrue(
                nutritionTab.isNutritionTabDisplayed(),
                "Nutrition tab displayed successfully.");

        /*
         * Verify Nutrient Profile Heading
         */
        ValidationUtil.verifyTrue(
                nutritionTab.isNutrientProfileDisplayed(),
                "Nutrient Profile displayed successfully.");

        System.out.println(
                nutritionTab.getNutrientProfileHeading());

        /*
         * Verify Nutrition Profile Description
         */
        ValidationUtil.verifyTrue(
                nutritionTab.isNutritionProfileDescriptionDisplayed(),
                "Nutrition Profile Description displayed successfully.");

        System.out.println(
                nutritionTab.getNutritionProfileDescription());

        /*
         * Verify Save Button
         */
        ValidationUtil.verifyTrue(
                nutritionTab.isSaveButtonDisplayed(),
                "Save button displayed successfully.");

        System.out.println(
                "Save Button Enabled : "
                        + nutritionTab.isSaveButtonEnabled());

                /*
         * Verify Fat Section
         */
        ValidationUtil.verifyTrue(
                nutritionTab.isFatSectionDisplayed(),
                "Fat section displayed successfully.");

        System.out.println(
                nutritionTab.getFatSectionHeading());

        /*
         * Print Existing Fat Values
         */
        System.out.println(
                "Fat Min : "
                        + nutritionTab.getFatMinPercentage());

        System.out.println(
                "Fat Max : "
                        + nutritionTab.getFatMaxPercentage());

        /*
         * Update Fat Percentage
         */
        nutritionTab.updateFatPercentage(
                fatMin,
                fatMax);

        Thread.sleep(
                2000);

        /*
         * Verify Carbohydrates Section
         */
        ValidationUtil.verifyTrue(
                nutritionTab.isCarbohydratesSectionDisplayed(),
                "Carbohydrates section displayed successfully.");

        System.out.println(
                nutritionTab.getCarbohydratesSectionHeading());

        /*
         * Print Existing Carbohydrates Values
         */
        System.out.println(
                "Carbohydrates Min : "
                        + nutritionTab.getCarbohydratesMinPercentage());

        System.out.println(
                "Carbohydrates Max : "
                        + nutritionTab.getCarbohydratesMaxPercentage());

        /*
         * Update Carbohydrates Percentage
         */
        nutritionTab.updateCarbohydratesPercentage(
                carbohydratesMin,
                carbohydratesMax);

        Thread.sleep(
                2000);

        /*
         * Verify Protein Section
         */
        ValidationUtil.verifyTrue(
                nutritionTab.isProteinSectionDisplayed(),
                "Protein section displayed successfully.");

        System.out.println(
                nutritionTab.getProteinSectionHeading());

        /*
         * Print Existing Protein Values
         */
        System.out.println(
                "Protein Min : "
                        + nutritionTab.getProteinMinPercentage());

        System.out.println(
                "Protein Max : "
                        + nutritionTab.getProteinMaxPercentage());

        /*
         * Update Protein Percentage
         */
        nutritionTab.updateProteinPercentage(
                proteinMin,
                proteinMax);

        Thread.sleep(
                2000);

                /*
         * Verify Daily Calorie Intake Section
         */
        ValidationUtil.verifyTrue(
                nutritionTab.isDailyCalorieIntakeSectionDisplayed(),
                "Daily Calorie Intake section displayed successfully.");

        System.out.println(
                nutritionTab.getDailyCalorieIntakeHeading());

        /*
         * Print Existing Daily Calorie Intake Values
         */
        System.out.println(
                "Daily Calorie Min : "
                        + nutritionTab.getDailyCalorieMinValue());

        System.out.println(
                "Daily Calorie Max : "
                        + nutritionTab.getDailyCalorieMaxValue());

        /*
         * Update Daily Calorie Intake
         */
        nutritionTab.updateDailyCalorieIntake(
                calorieMin,
                calorieMax);

        Thread.sleep(
                2000);

        /*
         * Scroll To Vitamin & Mineral Section
         */
        nutritionTab.scrollToVitaminMineralSection();

        Thread.sleep(
                2000);

        /*
         * Verify Vitamin & Mineral Present Section
         */
        ValidationUtil.verifyTrue(
                nutritionTab.isVitaminMineralPresentDisplayed(),
                "Vitamin & Mineral Present section displayed successfully.");

        System.out.println(
                nutritionTab.getVitaminMineralPresentHeading());

        /*
         * Verify Vitamin & Mineral Add Button
         */
        ValidationUtil.verifyTrue(
                nutritionTab.isVitaminMineralAddButtonDisplayed(),
                "Vitamin & Mineral Add button displayed successfully.");

        /*
         * Scroll To Export CSV Button
         */
        nutritionTab.scrollToExportCsvButton();

        Thread.sleep(
                2000);

        /*
         * Verify Export CSV Button
         */
        ValidationUtil.verifyTrue(
                nutritionTab.isExportCsvButtonDisplayed(),
                "Export CSV button displayed successfully.");

        /*
         * Scroll To Top
         */
        nutritionTab.scrollToTop();

        Thread.sleep(
                2000);

        System.out.println(
                "==================================================");

        System.out.println(
                "TC049_VerifyNutritionTab executed successfully.");

        System.out.println(
                "==================================================");
    }
}

