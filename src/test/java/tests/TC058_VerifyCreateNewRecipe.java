package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pagesObjects.Contribute.AddRecipeDashboard.AddRecipe;
import utils.Scroll;
import org.testng.Assert;



public class TC058_VerifyCreateNewRecipe extends BaseTest{
@Test
public void verifyAddRecipe() throws InterruptedException {

    AddRecipe addRecipe =new AddRecipe(DriverFactory.getDriver());

    Scroll scroll = new Scroll( DriverFactory.getDriver());

        // ==========================
        // Open Add Recipe Screen
        // ==========================

        addRecipe.clickContributeTab();

      Thread.sleep(3000);

        // ==========================
        // Upload Image
        // ==========================

        addRecipe.clickImage();

        Thread.sleep(2000);
        
        addRecipe.clickGallery();
        addRecipe.selectRecipeImage();
        addRecipe.clickImageDone();
        addRecipe.clickCropButton();

        // ==========================
        // Recipe Details
        // ==========================

        addRecipe.clickRecipeName();
        addRecipe.enterRecipeName(
                "Potato Chips Automation");

        addRecipe.clickPrepTime();
        addRecipe.enterPrepTime(
                "10");

        addRecipe.clickCookTime();
        addRecipe.enterCookTime(
                "15");

        addRecipe.clickServings();
        addRecipe.enterServings(
                "4");

        addRecipe.clickSummary();
        addRecipe.enterSummary(
                "Homemade crispy potato chips recipe.");

        // ==========================
        // Recipe Steps
        // ==========================

        addRecipe.clickRecipeStep1();
        addRecipe.enterRecipeStep1(
                "Thinly slice potatoes and soak in cold water.");

        addRecipe.validateStep1();

        addRecipe.clickAddStep();

        addRecipe.clickRecipeStep2();
        addRecipe.enterRecipeStep2(
                "Heat oil and fry potatoes until golden.");

        addRecipe.validateStep2();

        // ==========================
        // Scroll Down
        // ==========================

        scroll.ScrollDown();

        // ==========================
        // Pro Tip
        // ==========================

        addRecipe.openProTip();

        addRecipe.clickProTipField();

        addRecipe.enterProTip(
                "Use ice cold water for extra crispiness.");

        // ==========================
        // Keywords
        // ==========================

        addRecipe.clickKeywords();

        addRecipe.clickSelectCuisine();

        addRecipe.clickDietary();

        addRecipe.clickSelectDietary();

        addRecipe.clickReligion();

        addRecipe.clickSelectReligion();

        addRecipe.clickDifficulty();

        addRecipe.clickSelectDifficulty();

        addRecipe.clickConfirmKeywords();

        // ==========================
        // Add Link
        // ==========================

        addRecipe.clickAddLinks();

        addRecipe.enterAddLinks();

        addRecipe.enterLinkText(
                "https://youtube.com");

        // ==========================
        // Source
        // ==========================

        addRecipe.clickSourcedFrom();

        addRecipe.enterSourcedField();

        addRecipe.enterSourcedText(
                "Family Recipe");

        // ==========================
        // Proceed
        // ==========================

        addRecipe.clickProceed();

        // ==========================
        // Verification Page
        // ==========================

        Assert.assertTrue(
                addRecipe.verifyStep01Displayed());

        // ==========================
        // Ingredients
        // ==========================

        addRecipe.clickAddIngredient();

        addRecipe.enterIngredient();

        addRecipe.typeIngredient(
                "Potato");

        addRecipe.enterQuantity();

        addRecipe.typeQuantity(
                "500");

        addRecipe.clickUnitList();

        addRecipe.selectGram();

        // ==========================
        // Next
        // ==========================

        addRecipe.clickNext();

        // ==========================
        // Utensils
        // ==========================

        addRecipe.clickAddUtensils();

        addRecipe.selectUtensils();

        addRecipe.clickAddCustomUtensils();

        addRecipe.enterCustomUtensils(
                "Steel Bowl");

        addRecipe.clickAddButton();

        addRecipe.clickUtensilsConfirm();

        // ==========================
        // Final Submit
        // ==========================

        addRecipe.clickProceed02();

        addRecipe.clickSubmitRecipe();
    }


    }
