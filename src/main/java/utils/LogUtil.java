package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(
                    "HH:mm:ss");

    private LogUtil() {
    }

    public static String getCurrentTime() {

        return LocalDateTime.now()
                .format(formatter);
    }

    public static void printHeader(
            String testCase,
            String status,
            String color) {

        System.out.println(
                "\n==================================================");

        System.out.println(
                "[" + getCurrentTime() + "]");

        System.out.println(
                "TC     : "
                        + testCase);

        System.out.println(
                "STATUS : "
                        + color
                        + status
                        + ConsoleColor.RESET);

        System.out.println(
                "==================================================");
    }

    public static void printRetry(
            String testCase,
            int retry,
            int maxRetry) {

        System.out.println(
                "\n==================================================");

        System.out.println(
                "[" + getCurrentTime() + "]");

        System.out.println(
                "TC     : "
                        + testCase);

        System.out.println(
                "STATUS : "
                        + ConsoleColor.YELLOW
                        + "RETRYING ("
                        + retry
                        + "/"
                        + maxRetry
                        + ")"
                        + ConsoleColor.RESET);

        System.out.println(
                "==================================================");
    }

}