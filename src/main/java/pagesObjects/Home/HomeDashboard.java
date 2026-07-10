package pagesObjects.Home;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class HomeDashboard {

    private AndroidDriver driver;

    public HomeDashboard(AndroidDriver driver) {

        this.driver = driver;
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

        System.out.println(
                "Home button count : "
                        + driver.findElements(
                                AppiumBy.xpath(
                                        "//android.widget.Button[contains(@content-desc,'Home')]"))
                                .size());

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
     * Fetch all dishes from dashboard
     */
    public Set<String> getAllDashboardDishes() {

        Set<String> dishes =
                new LinkedHashSet<>();

        int sameScrollCount = 0;
        int previousSize = 0;

        while (true) {

            List<WebElement> cards =
                    driver.findElements(
                            AppiumBy.xpath(
                                    "//android.widget.ScrollView/android.widget.ImageView"));

            System.out.println(
                    "Visible cards : "
                            + cards.size());

            for (WebElement card : cards) {

                String contentDesc =
                        card.getAttribute(
                                "contentDescription");

                if (contentDesc != null
                        && !contentDesc.trim().isEmpty()) {

                    dishes.add(
                            contentDesc.trim());

                    System.out.println(
                            "Visible Dish : "
                                    + contentDesc);
                }
            }

            System.out.println(
                    "Total unique dishes fetched : "
                            + dishes.size());

            /*
             * Stop if no new dishes found
             */
            if (dishes.size() == previousSize) {

                sameScrollCount++;
            }
            else {

                sameScrollCount = 0;
            }

            if (sameScrollCount >= 2) {

                System.out.println(
                        "No new dishes found.");

                break;
            }

            previousSize = dishes.size();

            boolean scrolled =
                    scrollDashboard();

            if (!scrolled) {

                System.out.println(
                        "Reached end of dashboard.");

                break;
            }

            try {

                Thread.sleep(2000);
            }
            catch (InterruptedException e) {

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

            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable("
                                    + "new UiSelector().scrollable(true))"
                                    + ".scrollForward()"));

            System.out.println(
                    "Dashboard scrolled.");

            return true;
        }
        catch (Exception e) {

            return false;
        }
    }  
}