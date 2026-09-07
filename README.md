# Recipe Find Mobile Automation Framework

Mobile UI automation framework for the Recipe Find Android application. The framework uses Java, Maven, Appium, Selenium, TestNG, and the Page Object Model (POM).

## What This Framework Automates

The TestNG suite currently contains test cases covering:

- Authentication and Google sign-in
- Home screen, welcome screen, tutorial, search, and dish details
- Hamburger menu, FAQs, glossary, feedback, and control panel
- Recipe search, recipe status, recipe creation, and nutrition facts
- Groups, group administration, reviewers, members, and notifications
- User profile, dietary preferences, religion, allergies, and ingredients
- Shopping lists, following, comments, likes, and quick statistics

The complete suite is declared in `testng.xml` and currently includes test classes `TC001` through `TC076`.

## Technology Stack

| Component | Version or implementation |
| --- | --- |
| Java | 21 source and target |
| Maven | Required for dependency management and execution |
| Appium Java Client | 9.0.0 |
| Selenium Java | 4.18.1 |
| TestNG | 7.10.2 |
| UiAutomator2 | Android automation driver |
| ExtentReports | 5.1.1 |
| Log4j | 2.23.1 |
| Apache POI | 5.2.5 |
| OpenPDF | 1.3.39 |

## Project Structure

```text
Recipe Find framework/
├── apps/                         Android APK files used by the tests
├── screenshots/                  Failure screenshots
├── src/
│   ├── main/java/
│   │   ├── base/                 Shared test lifecycle
│   │   ├── driver/               Appium driver creation
│   │   ├── listeners/            TestNG listeners and retry handling
│   │   ├── pagesObjects/         Page objects grouped by application area
│   │   ├── reports/               Extent and PDF report generation
│   │   └── utils/                Configuration, waits, scrolling, validation, and logging
│   ├── main/resources/            Runtime configuration and logging XML files
│   └── test/java/tests/           TestNG test classes
├── pom.xml                       Maven build and dependency configuration
├── testng.xml                    Test suite and listener registration
└── Jenkinsfile                   CI entry point, if Jenkins is configured
```

## Prerequisites

Install and configure the following before running the tests:

1. Java Development Kit 21.
2. Maven, with `mvn` available on `PATH`.
3. Android Studio or the Android SDK.
4. Android SDK Platform-Tools, with `adb` available on `PATH`.
5. Appium server 2.x.
6. The UiAutomator2 driver for Appium:

   ```bash
   appium driver install uiautomator2
   ```

7. An Android emulator or a USB-connected Android device.
8. The Recipe Find APK at the path configured in `src/main/resources/config.properties`.

Check the local tools:

```bash
java -version
mvn -version
adb version
adb devices
appium -v
```

For a physical device, enable Developer options and USB debugging, then authorize the computer when Android displays the debugging prompt. For an emulator, start it from Android Studio or with the Android Emulator command line.

## Appium Server Setup

Start Appium before running Maven:

```bash
appium --address 127.0.0.1 --port 4723
```

The default framework configuration connects to:

```text
http://127.0.0.1:4723
```

If Appium is running on another host or port, update `appiumServerURL` in `src/main/resources/config.properties`.

## Configuration

The framework loads configuration directly from `src/main/resources/config.properties` through `ConfigReader`.

The important device and application settings are:

```properties
platformName=Android
automationName=UiAutomator2
deviceName=emulator-5554
udid=emulator-5554
appiumServerURL=http://127.0.0.1:4723
app=apps/RecipeFind_Debug_v4.2.0.apk
app.package=com.quickelf.recipeFind.debug
newCommandTimeout=300
```

Before execution:

- Set `deviceName` and `udid` to the device identifier shown by `adb devices`.
- Confirm that the APK named by `app` exists relative to the repository root.
- Set `app.package` to the package installed by that APK.
- Confirm that the configured Google account can sign in to the application.
- Keep test credentials outside source control where possible. The existing properties file contains credentials and should be treated as sensitive.

The active APK is the debug build. An alternative alpha APK is present as a commented configuration entry in the properties file.

## Is This Framework Automated for Google Pixel 10?

**The framework is Android-compatible, but it is not currently configured or verified specifically for Google Pixel 10.** The checked-in configuration targets:

```properties
deviceName=emulator-5554
udid=emulator-5554
```

It can be used with a Google Pixel 10 if the device is visible to ADB and the APK supports that Android version. To target a connected Pixel 10:

1. Connect the phone and enable USB debugging.
2. Run `adb devices` and copy the Pixel 10 serial number.
3. Replace both `deviceName` and `udid` with that serial number in `config.properties`.
4. Start Appium and run a focused test first.

Example:

```properties
deviceName=PIXEL_10_SERIAL
udid=PIXEL_10_SERIAL
```

This configuration change means the framework can target the device. It is not a certification or compatibility guarantee; the complete suite still needs to be executed on the Pixel 10 and reviewed for OS, permissions, keyboard, Google sign-in, and application behavior differences.

## How Execution Works

`DriverFactory` creates an `AndroidDriver` with `UiAutomator2Options`, the configured device, APK, and Appium URL.

Before each TestNG test, `BaseTest`:

1. Initializes the driver if it is not already initialized.
2. Verifies that the current application package is the configured Recipe Find package.
3. Handles the sign-up or Google authentication flow.
4. Handles audio and nearby-device permissions when displayed.
5. Activates Recipe Find and prepares the application for the test.

The TestNG listeners register execution status, retry handling, reports, console output, and failure screenshots. The current `tearDown` method does not quit the driver after each test, so the session may remain active during the suite. Call `DriverFactory.quitDriver()` when adding a controlled end-of-suite cleanup.

## Running Tests

From the repository root, install dependencies and run the configured suite:

```bash
mvn clean test
```

The Maven Surefire plugin is configured to use `testng.xml`, so the command above runs the suite declared in that file.

Run the suite explicitly:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

Run one test class. Use the class name without the package when invoking Surefire:

```bash
mvn -Dtest=TC076_VerifyNutritionFactsPanel test
```

Run one test method:

```bash
mvn -Dtest=TC076_VerifyNutritionFactsPanel#methodName test
```

For a first device check, use a small authentication or launch test before running all 76 test classes.

## Reports and Artifacts

After execution, inspect:

- `target/surefire-reports/` for Maven Surefire and TestNG result files.
- `target/ExtentReport.html` for the Extent HTML report when generated by `ExtentManager`.
- `target/ExecutionReport_<timestamp>.pdf` for the generated PDF execution report.
- `screenshots/` for screenshots captured by the failure listener.
- `target/` for compiled classes and other Maven build output.

The listener reports passed, failed, skipped, and retried tests to the console. Failed tests include the failure message and a screenshot when screenshot capture succeeds.

## Framework Components

- `BaseTest`: common setup, authentication, permissions, application readiness, and teardown hook.
- `DriverFactory`: creates and closes the Appium Android driver.
- `pagesObjects`: page objects containing screen locators and user actions.
- `WaitUtil`: reusable explicit wait operations.
- `Scroll`: scrolling and swipe helpers.
- `ValidationUtil`: reusable validation and assertion helpers.
- `ScreenshotUtil`: failure screenshot capture.
- `TestListener`: TestNG status handling, console summary, Extent logging, and screenshots.
- `RetryAnalyzer` and `RetryListener`: retry support for failed tests.
- `ExtentManager`: Extent report lifecycle.
- `PDFReportGenerator`: PDF execution summary generation.

## Troubleshooting

### `NoSuchDeviceException` or the device is offline

Run:

```bash
adb devices
```

Make sure the identifier exactly matches `deviceName` and `udid`, then restart the emulator or reconnect and authorize the physical device.

### Appium connection failure

Confirm that Appium is running on port 4723 and that `appiumServerURL` matches the running server. Confirm that the UiAutomator2 driver is installed.

### APK not found

Run Maven from the repository root and confirm that the configured relative path, such as `apps/RecipeFind_Debug_v4.2.0.apk`, exists.

### Application package assertion failure

Inspect the package installed by the APK and make `app.package` match it. The test setup deliberately fails when the current package is not the configured Recipe Find package.

### Google authentication fails

Check the configured account, network access, Google Play services, device date/time, and any account or consent screen shown on the device. Do not commit real credentials to the repository.

### Tests fail after a previous run

The driver configuration currently uses `noReset=false` and `fullReset=false`. This allows the framework to reset application state as configured by Appium while retaining the existing driver session during the suite. Review application data, permissions, and sign-in state on the device before rerunning.

## CI/CD

The repository includes a `Jenkinsfile`. A CI agent must provide Java 21, Maven, Android SDK/ADB, an available Android device or emulator, the Appium server, the APK, and any required test credentials. CI should inject secrets securely rather than storing them in `config.properties`.

## Maintenance Notes

- Keep page-specific locators and actions in page objects.
- Keep device, application, server, and account values in configuration rather than test classes.
- Add new test classes to `testng.xml` when they should run in the complete suite.
- Do not describe a device as supported until the suite has been executed and reviewed on that device.
