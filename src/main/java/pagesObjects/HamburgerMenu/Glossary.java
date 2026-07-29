package pagesObjects.HamburgerMenu;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.EnumGlossaryScrollTrigger;
import utils.Scroll;

public class Glossary {

    private AndroidDriver driver;

    private Scroll scroll;

    public Glossary(
            AndroidDriver driver) {

        this.driver = driver;

        this.scroll =
                new Scroll(driver);
    }

    /*
    * Fetch Visible Glossary Headers
    */
    private List<WebElement> getVisibleGlossaryHeaders() {

        return driver.findElements(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'Collapsed')]"));
    }

    /*
     * Glossary Screen
     */
    public boolean isGlossaryScreenVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "GLOSSARY"))
                .isEmpty();
    }

    /*
     * Bring Glossary Content Below Logo
     */
    public void bringGlossaryContentIntoView() {

        try {

            driver.executeScript(
                    "mobile: swipeGesture",
                    java.util.Map.of(
                            "left", 100,
                            "top", 300,
                            "width", 800,
                            "height", 1000,
                            "direction", "up",
                            "percent", 0.18));

            Thread.sleep(1500);

            System.out.println(
                    "Glossary Content Positioned Below Logo.");

        } catch (Exception e) {

            System.out.println(
                    "Unable To Position Glossary Content.");
        }
    }

    /*
    * Check If Glossary Requires Scroll
    */
    private boolean shouldScrollForNextSection(
            String glossaryName) {

        String cleanedName =
                glossaryName
                        .replace(
                                ", Collapsed",
                                "")
                        .trim();

        boolean shouldScroll =
                EnumGlossaryScrollTrigger
                        .SCROLL_TRIGGERS
                        .contains(
                                cleanedName);

        System.out.println(
                "Glossary Trigger Check : "
                        + cleanedName);

        System.out.println(
                "Trigger Matched : "
                        + shouldScroll);

        return shouldScroll;
    }

    /*
    * Fetch All Glossary Terms
    */
    public void getAllGlossaryTerms() {

        Set<String> processedGlossary =
                new LinkedHashSet<>();

        int noNewGlossaryCount = 0;

        while (noNewGlossaryCount < 10) {

            int beforeCount =
                    processedGlossary.size();

            try {

                processVisibleGlossary(
                        processedGlossary);

            } catch (Exception e) {

                e.printStackTrace();
            }

            int afterCount =
                    processedGlossary.size();

            if (beforeCount == afterCount) {

                noNewGlossaryCount++;

                System.out.println(
                        "No New Glossary Found. Attempt : "
                                + noNewGlossaryCount);
            }
            else {

                noNewGlossaryCount = 0;
            }

            swipeGlossary();
        }

        System.out.println(
                "==================================================");

        System.out.println(
                "Total Glossary Terms : "
                        + processedGlossary.size());

        System.out.println(
                "==================================================");
    }

    /*
 * Process Visible Glossary
 */
private void processVisibleGlossary(
        Set<String> processedGlossary)
        throws Exception {

    List<WebElement> glossaryTerms =
            getVisibleGlossaryHeaders();

    for (WebElement glossary : glossaryTerms) {

        String glossaryName =
                glossary.getAttribute(
                        "contentDescription");

        if (glossaryName == null
                || glossaryName.equals("Collapsed")
                || processedGlossary.contains(glossaryName)) {

            continue;
        }

        processedGlossary.add(glossaryName);

        System.out.println(
                "Glossary : "
                        + glossaryName);

        try {

            
            /*
            * Expand Glossary
            */
            glossary.click();

            Thread.sleep(1000);

    /*
    * Read Description
    */
    List<WebElement> views =
            driver.findElements(
                    AppiumBy.xpath(
                            "//android.view.View"));

    boolean descriptionFound = false;

    for (int i = 0; i < views.size(); i++) {

        String value =
                views.get(i)
                        .getAttribute(
                                "contentDescription");

        if (value == null
                || value.trim().isEmpty()) {

            continue;
        }

        /*
        * Found Expanded Glossary
        */
        if (value.equals(
                glossaryName.replace(
                        ", Collapsed",
                        ", Expanded"))) {

            /*
            * Next View Contains Description
            */
            if (i + 1 < views.size()) {

                String description =
                        views.get(i + 1)
                                .getAttribute(
                                        "contentDescription");

                if (description != null
                        && !description.trim().isEmpty()) {

                    System.out.println(
                            "Description : "
                                    + description);

                    descriptionFound = true;
                }
            }

            break;
        }
    }

    if (!descriptionFound) {

        System.out.println(
                "Description : Not Found");
    }

    /*
    * Collapse Glossary
    */
    driver.findElement(
            AppiumBy.accessibilityId(
                    glossaryName.replace(
                            ", Collapsed",
                            ", Expanded")))
            .click();

    Thread.sleep(700);

        } catch (Exception e) {

            System.out.println(
                    "Unable To Process : "
                            + glossaryName);

            System.out.println(
                    "Reason : "
                            + e.getMessage());
        }

        System.out.println(
                "------------------------------------------------");

        if (shouldScrollForNextSection(
                glossaryName)) {

            System.out.println(
                    "Enum Glossary Matched.");

            scrollToNextSection();

            Thread.sleep(1500);
        }
    }
}


    /*
    * Scroll To Next Glossary Section
    */
    private void scrollToNextSection() {

        try {

            for (int i = 0; i < 5; i++) {

                List<WebElement> glossary =
                        getVisibleGlossaryHeaders();

                if (!glossary.isEmpty()) {

                    int y =
                            glossary.get(0)
                                    .getRect()
                                    .getY();

                    System.out.println(
                            "Top Glossary Y : "
                                    + y);

                    if (y < 350) {

                        break;
                    }
                }

                driver.executeScript(
                        "mobile: swipeGesture",
                        java.util.Map.of(
                                "left", 100,
                                "top", 300,
                                "width", 800,
                                "height", 1200,
                                "direction", "up",
                                "percent", 0.12));

                Thread.sleep(800);
            }

            System.out.println(
                    "Next Glossary Section Positioned.");
        }

        catch (Exception e) {

            System.out.println(
                    "Unable To Position Next Glossary Section.");
        }
    }

    /*
    * General Glossary Swipe
    */
    private boolean swipeGlossary() {

        try {

            driver.executeScript(
                    "mobile: swipeGesture",
                    java.util.Map.of(
                            "left", 100,
                            "top", 600,
                            "width", 800,
                            "height", 900,
                            "direction", "up",
                            "percent", 0.20));

            Thread.sleep(1500);

            System.out.println(
                    "Glossary Swiped.");

            return true;
        }

        catch (Exception e) {

            System.out.println(
                    "Unable To Swipe Glossary.");

            return false;
        }
    }

    /*
    * Scroll Glossary Back To Top
    */
    public void scrollGlossaryToTop() {

        try {

            for (int i = 0; i < 15; i++) {

                scroll.ScrollUp();

                Thread.sleep(500);
            }

            System.out.println(
                    "Glossary Scrolled Back To Top.");
        }

        catch (Exception e) {

            System.out.println(
                    "Unable To Scroll Glossary To Top.");
        }
    }
}