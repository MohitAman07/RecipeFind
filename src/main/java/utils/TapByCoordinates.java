package utils;

import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.google.common.collect.ImmutableList;

import io.appium.java_client.android.AndroidDriver;

public class TapByCoordinates {
    AndroidDriver driver;

    public TapByCoordinates(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapAtPoint(Point point) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence tap = new Sequence(input, 0);
        tap.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x, point.y));
        tap.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(input, Duration.ofMillis(200)));
        tap.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(tap));
    }

    public void tapElement(WebElement el) {
        tapElementAt(el, 0.5, 0.5);
    }

    public void tapElementAt(WebElement el, double xPct, double yPct) {
        org.openqa.selenium.Rectangle elRect;
        elRect = el.getRect();
        Point point = new Point(
                elRect.x + (int) (elRect.getWidth() * xPct),
                elRect.y + (int) (elRect.getHeight() * yPct)
        );
        tapAtPoint(point);
    }
}
