package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        try {

            FileInputStream file =
                    new FileInputStream(
                            System.getProperty("user.dir")
                                    + "/src/main/resources/config.properties");

            properties.load(file);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to load config.properties", e);
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}