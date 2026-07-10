package pagesObjects.Home;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;

public class RecipeSearch {

    private AndroidDriver driver;

    public RecipeSearch(AndroidDriver driver) {

        this.driver = driver;
    }

    /*
     * Search Field
     */
    public boolean isSearchFieldVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText"))
                .isEmpty();
    }

    public void enterRecipeName(String recipeName) {

        WebElement searchField =
                driver.findElement(
                        AppiumBy.xpath(
                                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText"));

        searchField.click();

        searchField.clear();

        searchField.sendKeys(recipeName);

        System.out.println(
                "Recipe name entered : "
                        + recipeName);
    }

    /*
     * Search Filter Button
     */
    public boolean isSearchFilterButtonVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[1]"))
                .isEmpty();
    }

    public void clickSearchFilterButton() {

        driver.findElement(
                AppiumBy.xpath(
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[1]"))
                .click();

        System.out.println(
                "Search filter button clicked.");
    }

    /*
     * Search Button
     */
    public boolean isSearchButtonVisible() {

        return !driver.findElements(
                AppiumBy.xpath(
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]"))
                .isEmpty();
    }

    public void clickSearchButton() {

        driver.findElement(
                AppiumBy.xpath(
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]"))
                .click();

        System.out.println(
                "Search button clicked.");
    }

    /*
     * Complete Search Flow
     */
    public void searchRecipe(String recipeName) {

        enterRecipeName(recipeName);

        clickSearchButton();

        System.out.println(
                "Recipe searched successfully : "
                        + recipeName);
    }
}