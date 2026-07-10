package utils;

import driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        try {

            File source = ((TakesScreenshot)
                    DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            String destination =
                    System.getProperty("user.dir")
                            + "/screenshots/"
                            + testName + "_"
                            + timestamp + ".png";

            FileUtils.copyFile(source,
                    new File(destination));

            return destination;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}