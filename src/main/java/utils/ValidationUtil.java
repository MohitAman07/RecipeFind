package utils;

import org.testng.Assert;

public class ValidationUtil {

    public static void verifyTrue(
            boolean condition,
            String step) {

        if (condition) {

            System.out.println(
                    "[PASS] "
                            + step);

        } else {

            System.out.println(
                    "[FAIL] "
                            + step);

            Assert.fail(step);
        }
    }

    public static void verifyFalse(
            boolean condition,
            String step) {

        if (!condition) {

            System.out.println(
                    "[PASS] "
                            + step);

        } else {

            System.out.println(
                    "[FAIL] "
                            + step);

            Assert.fail(step);
        }
    }

    public static void verifyEquals(
            Object actual,
            Object expected,
            String step) {

        if (actual.equals(expected)) {

            System.out.println(
                    "[PASS] "
                            + step);

        } else {

            System.out.println(
                    "[FAIL] "
                            + step);

            Assert.fail(
                    step
                            + "\nExpected : "
                            + expected
                            + "\nActual   : "
                            + actual);
        }
    }
}