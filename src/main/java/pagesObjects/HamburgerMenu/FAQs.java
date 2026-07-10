package pagesObjects.HamburgerMenu;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.EnumFQAsscrolltrigger;
import utils.Scroll;

public class FAQs {

    private AndroidDriver driver;
    private Scroll scroll;

    public FAQs(AndroidDriver driver) {

        this.driver = driver;
        this.scroll = new Scroll(driver);
    }

    /*
     * FAQ Screen
     */
    public boolean isFAQScreenVisible() {

        return !driver.findElements(
                AppiumBy.accessibilityId(
                        "FREQUENTLY ASKED QUESTIONS"))
                .isEmpty();
    }

    /*
     * Bring FAQ Content Below Logo
     */
    public void bringFAQContentIntoView() {

        try {

            driver.executeScript(
                    "mobile: swipeGesture",
                    Map.of(
                            "left", 100,
                            "top", 300,
                            "width", 800,
                            "height", 1000,
                            "direction", "up",
                            "percent", 0.18));

            Thread.sleep(1500);

            System.out.println(
                    "FAQ Content Positioned Below Logo.");
        }
        catch (Exception e) {

            System.out.println(
                    "Unable To Position FAQ Content.");
        }
    }

    /*
     * Fetch Visible Content Descriptions
     */
    private Set<String> getVisibleContentDescriptions() {

        Set<String> values =
                new LinkedHashSet<>();

        List<WebElement> elements =
                driver.findElements(
                        AppiumBy.xpath("//*"));

        for (WebElement element : elements) {

            String desc =
                    element.getAttribute(
                            "contentDescription");

            if (desc != null
                    && !desc.trim().isEmpty()) {

                values.add(
                        desc.trim());
            }
        }

        return values;
    }

    /*
     * Fetch Visible FAQ Headers
     */
    private List<WebElement> getVisibleFAQHeaders() {

        return driver.findElements(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc "
                                + "and not(@content-desc='Collapsed') "
                                + "and not(@content-desc='Expanded') "
                                + "and not(contains(@content-desc,', Collapsed')) "
                                + "and not(contains(@content-desc,', Expanded'))]"));
    }

    /*
     * Check If Question Requires Scroll
     */
    private boolean shouldScrollForNextSection(
        String questionText) {

    String cleanedQuestion =
            questionText
                    .replace(
                            ", Collapsed",
                            "")
                    .trim();

    boolean shouldScroll =
            EnumFQAsscrolltrigger
                    .SCROLL_TRIGGERS
                    .contains(
                            cleanedQuestion);

    System.out.println(
            "FAQ Trigger Check : "
                    + cleanedQuestion);

    System.out.println(
            "Trigger Matched : "
                    + shouldScroll);

    return shouldScroll;
}

    /*
     * Fetch All FAQ Questions And Answers
     */
    public void getAllFAQQuestionsAndAnswers() {

    Set<String> processedQuestions =
            new LinkedHashSet<>();

    int noNewQuestionCount = 0;

    while (noNewQuestionCount < 10) {

        int beforeCount =
                processedQuestions.size();

        try {
                processVisibleQuestions(
                        processedQuestions);
        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

        int afterCount =
                processedQuestions.size();

        if (beforeCount == afterCount) {

            noNewQuestionCount++;

            System.out.println(
                    "No New Questions Found. Attempt : "
                            + noNewQuestionCount);
        }
        else {

            noNewQuestionCount = 0;
        }

        swipeFAQ();
    }

    System.out.println(
            "==================================================");

    System.out.println(
            "Total FAQ Questions : "
                    + processedQuestions.size());

    System.out.println(
            "==================================================");
}

    /*
     * Process Visible Questions
     */
    private void processVisibleQuestions(
            Set<String> processedQuestions) throws Exception {

        List<WebElement> questions =
                driver.findElements(
                        AppiumBy.xpath(
                                "//android.view.View[contains(@content-desc,'Collapsed')]"));

        for (WebElement question : questions) {

            String questionText =
                    question.getAttribute(
                            "contentDescription");

            if (questionText == null
                    || questionText.equals(
                            "Collapsed")
                    || processedQuestions.contains(
                            questionText)) {

                continue;
            }

            processedQuestions.add(
                    questionText);

            System.out.println(
                    "Question : "
                            + questionText);

            try {

                Set<String> beforeExpand =
                        getVisibleContentDescriptions();

                question.click();

                Thread.sleep(1000);

                Set<String> afterExpand =
                        getVisibleContentDescriptions();

                boolean answerFound = false;

                for (String value : afterExpand) {

                    if (!beforeExpand.contains(
                            value)
                            && !value.contains(
                                    "Collapsed")
                            && !value.contains(
                                    "Expanded")) {

                        System.out.println(
                                "Answer : "
                                        + value);

                        answerFound = true;

                        break;
                    }
                }

                if (!answerFound) {

                    System.out.println(
                            "Answer : Not Found");
                }

                driver.findElement(
                        AppiumBy.accessibilityId(
                                questionText.replace(
                                        ", Collapsed",
                                        ", Expanded")))
                        .click();

                Thread.sleep(500);
            }
            catch (Exception e) {

                System.out.println(
                        "Unable To Process : "
                                + questionText);

                System.out.println(
                        "Reason : "
                                + e.getMessage());
            }

            System.out.println(
                    "------------------------------------------------");

                        if (shouldScrollForNextSection(
                        questionText)) {

                System.out.println(
                        "Enum Question Matched.");

                scrollToNextSection();

                Thread.sleep(1500);
                }
            }
}
    

    /*
     * Scroll To Next FAQ Section
     */
    private void scrollToNextSection() {

    try {

        for (int i = 0; i < 5; i++) {

            List<WebElement> questions =
                    driver.findElements(
                            AppiumBy.xpath(
                                    "//android.view.View[contains(@content-desc,'Collapsed')]"));

            if (!questions.isEmpty()) {

                int y =
                        questions.get(0)
                                .getRect()
                                .getY();

                System.out.println(
                        "Top Question Y : "
                                + y);

                if (y < 350) {

                    break;
                }
            }

            driver.executeScript(
                    "mobile: swipeGesture",
                    Map.of(
                            "left", 100,
                            "top", 300,
                            "width", 800,
                            "height", 1200,
                            "direction", "up",
                            "percent", 0.12));

            Thread.sleep(800);
        }

        System.out.println(
                "Next FAQ Section Positioned.");
    }
    catch (Exception e) {

        System.out.println(
                "Unable To Position Next FAQ Section.");
    }
}

    /*
     * General FAQ Swipe
     */
    private boolean swipeFAQ() {

        try {

            driver.executeScript(
                    "mobile: swipeGesture",
                    Map.of(
                            "left", 100,
                            "top", 600,
                            "width", 800,
                            "height", 900,
                            "direction", "up",
                            "percent", 0.20));

            Thread.sleep(1500);

            System.out.println(
                    "FAQ Swiped.");

            return true;
        }
        catch (Exception e) {

            System.out.println(
                    "Unable To Swipe FAQ.");

            return false;
        }
    }

    /*
     * Scroll FAQ To Top
     */
    public void scrollFAQToTop() {

        try {

            for (int i = 0; i < 15; i++) {

                scroll.ScrollUp();

                Thread.sleep(500);
            }

            System.out.println(
                    "FAQ Scrolled Back To Top.");
        }
        catch (Exception e) {

            System.out.println(
                    "Unable To Scroll FAQ To Top.");
        }
    }
}