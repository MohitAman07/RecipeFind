package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import utils.ConfigReader;

import java.net.URI;
import java.time.Duration;

public class DriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void initializeDriver() {

        try {

            if (driver != null) {
                return;
            }

            UiAutomator2Options options = new UiAutomator2Options();

            options.setPlatformName(
                    ConfigReader.getProperty("platformName"));

            options.setAutomationName(
                    ConfigReader.getProperty("automationName"));

            options.setDeviceName(
                    ConfigReader.getProperty("deviceName"));

            options.setUdid(
                    ConfigReader.getProperty("udid"));

            options.setApp(
                    System.getProperty("user.dir")
                            + "/"
                            + ConfigReader.getProperty("app"));

            options.setNewCommandTimeout(
                    Duration.ofSeconds(
                            Integer.parseInt(
                                    ConfigReader.getProperty(
                                            "newCommandTimeout"))));

            /*
             * Keeps login session during development.
             * Change to false before execution in CI if required.
             */
            options.setNoReset(false);
            options.setFullReset(false);


            driver = new AndroidDriver(
                    URI.create(
                            ConfigReader.getProperty(
                                    "appiumServerURL"))
                            .toURL(),
                    options);

            System.out.println(
                    "Driver initialized successfully.");

        } catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException(
                    "Unable to initialize driver", e);
        }
    }

    public static void quitDriver() {

        if (driver != null) {

            driver.quit();

            driver = null;

            System.out.println(
                    "Driver closed successfully.");
        }
    }
}