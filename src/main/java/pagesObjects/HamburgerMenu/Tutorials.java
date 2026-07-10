package pagesObjects.HamburgerMenu;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Tutorials {
    private AndroidDriver driver;

    public Tutorials(AndroidDriver driver) {

        this.driver = driver;
    }

     /*
    * Tutorial Screen
    */
    public boolean isTutorialScreenVisible() {

        List<WebElement> images =
                driver.findElements(
                        AppiumBy.className(
                                "android.widget.ImageView"));

        System.out.println(
                "Tutorial Image Count : "
                        + (images.size()-1));

        return images.size() >= 2;
    }

    /*
    * Fetch Tutorial Cards
    */
    public int getAllTutorialCards() {

        int totalCards = 1;

        for (int i = 1; i < 15; i++) {

            List<WebElement> images =
                    driver.findElements(
                            AppiumBy.className(
                                    "android.widget.ImageView"));

            System.out.println(
                    "Visible Tutorial Images : "
                            + (images.size() - 1));

            /*
            * Tutorial card is usually the last ImageView
            */
            WebElement card =
                    images.get(
                            images.size() - 1);

            String identifier =
                    card.getRect()
                            .toString();

            System.out.println(
                    "Tutorial Card Identifier : "
                            + identifier);

            swipeTutorialCard();

            try {

                Thread.sleep(2000);
            }
            catch (InterruptedException e) {

                Thread.currentThread()
                        .interrupt();
            }

            totalCards++;
        }

        System.out.println(
                "Total Tutorial Cards : "
                        + totalCards);

        return totalCards;
    }

    private void swipeTutorialCard() {

        driver.executeScript(
            "mobile: swipeGesture",
            Map.of(
                    "left", 100,
                    "top", 500,
                    "width", 500,
                    "height", 500,
                    "direction", "left",
                    "percent", 0.60
            ));

        System.out.println(
                "Tutorial card swiped.");
    }
}
