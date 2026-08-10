# 📱 Recipe Find Mobile Automation Framework

A robust Mobile Test Automation Framework built using **Java, Selenium, Appium, TestNG, Maven, and Page Object Model (POM)** for automating the Recipe Find Android application.

The framework is designed to be scalable, reusable, maintainable, and easy to integrate into CI/CD pipelines.

---

# 🚀 Features

- Page Object Model (POM) Architecture
- Data Driven Test Execution
- Cross User Role Testing
- Custom Test Listener
- Automatic Retry Mechanism
- Screenshot Capture on Failure
- PDF Execution Report
- Detailed Console Execution Summary
- Soft Assertions & Validation Utilities
- Explicit Wait Utilities
- Scroll Utilities
- Dynamic Locator Support
- Android Emulator & Real Device Support
- Parallel Test Execution
- Easily CI/CD Integratable
- Modular Framework Structure

---

# 🛠 Technology Stack

| Technology | Version |
|------------|----------|
| Java | 17+ |
| Maven | Latest |
| Selenium | 4.x |
| Appium | 9.x |
| TestNG | 7.x |
| Android Studio | Latest |
| UiAutomator2 | Latest |
| Git | Latest |

---

# 📂 Project Structure

```
RecipeFindFramework
│
├── src
│   ├── main
│   │   ├── pages
│   │   ├── utils
│   │   ├── base
│   │   ├── constants
│   │   ├── drivers
│   │   └── reports
│   │
│   └── test
│       ├── testcases
│       ├── testdata
│       ├── listeners
│       ├── retry
│       └── resources
│
├── screenshots
├── reports
├── logs
├── test-output
├── pom.xml
└── README.md
```

---

# 🏗 Framework Design

The framework follows the **Page Object Model (POM)** architecture.

```
Test Case
      │
      ▼
Page Objects
      │
      ▼
Base Page
      │
      ▼
Utilities
      │
      ▼
Driver
```

This keeps the project clean, reusable, and maintainable.

---

# 📦 Framework Components

## BaseTest

Responsible for

- Driver initialization
- Device setup
- Test execution lifecycle
- User Role handling
- BeforeSuite
- BeforeMethod
- AfterMethod
- AfterSuite

---

## Page Objects

Each application screen has its own page class.

Example

```
LoginPage
HomePage
RecipePage
CommentPage
GroupPage
NotificationPage
ProfilePage
```

Each page contains

- Locators
- Actions
- Validations

---

## Utilities

Framework contains reusable utilities.

### WaitUtil

- Explicit Wait
- Visibility Wait
- Clickable Wait
- Presence Wait

---

### ScrollUtil

Supports

- Scroll Until Visible
- Scroll Into View
- Scroll Forward
- Scroll Backward
- Swipe

---

### ValidationUtil

Provides reusable assertions

- verifyEquals()
- verifyTrue()
- verifyFalse()
- verifyContains()

---

### ScreenshotUtil

Automatically captures screenshot when

- Test fails
- Exception occurs

---

### PDFReportUtil

Generates

- PDF Summary
- Test Results
- Pass Count
- Fail Count
- Execution Time

---

### RetryAnalyzer

Automatically retries failed tests.

Configurable retry count.

---

### TestListener

Captures

- Pass
- Fail
- Skip
- Retry
- Screenshots
- Execution Time
- Console Summary

---

# 👥 Supported User Roles

Framework supports multiple user roles.

Example

```
Admin
Normal User
Contributor
Author
Guest
```

Role specific login methods are available.

---

# 📋 Test Execution

Run complete suite

```
mvn clean test
```

Run specific TestNG XML

```
mvn test -DsuiteXmlFile=testng.xml
```

Run single class

```
mvn -Dtest=LoginTest test
```

Run single method

```
mvn -Dtest=LoginTest#verifyLogin test
```

---

# ⚙ Configuration

Framework uses configuration files for

- Device Name
- Platform Version
- App Package
- App Activity
- Timeout
- Environment
- Credentials

Modify values as needed before execution.

---

# 📱 Supported Devices

✔ Android Emulator

✔ Physical Android Device

---

# 📊 Reports

Framework generates

- TestNG Report
- PDF Report
- Console Summary
- Failure Screenshots

---

Example

```
================================================

TEST EXECUTION SUMMARY

================================================

Passed : 85

Failed : 2

Skipped : 1

Retried : 2

Execution Time : 12m 42s

================================================
```

---

# 🔄 Retry Mechanism

Framework automatically retries failed test cases.

Useful for

- Network delay
- App synchronization
- Intermittent failures

---

# 📷 Screenshot Capture

Automatic screenshot capture

```
screenshots/

├── TC001.png

├── TC005.png

├── TC010.png
```

---

# 🧪 Framework Best Practices

- No Hardcoded Waits
- Explicit Waits
- Reusable Components
- Generic Methods
- Clean Code
- Single Responsibility Principle
- Minimal Code Duplication

---

# 📈 CI/CD Ready

Framework can easily integrate with

- Jenkins
- GitHub Actions
- Azure DevOps
- GitLab CI

Supports

- Scheduled Runs
- Nightly Builds
- Smoke Suite
- Regression Suite

---

# 📌 Naming Conventions

Example

```
TC001_Login

TC002_CreateRecipe

TC003_EditRecipe

TC004_DeleteRecipe
```

Methods

```
clickLogin()

enterUsername()

verifyToast()

createRecipe()
```

---

# 📝 Logging

Framework logs

- Test Start
- Test End
- Steps
- Failures
- Exceptions
- Retry Information

---

# 📚 Design Principles

- Page Object Model
- DRY Principle
- SOLID Principles
- Reusable Utilities
- Maintainable Code
- Modular Architecture

---

# 🤝 Contributing

1. Fork the repository

2. Create feature branch

3. Commit changes

4. Push branch

5. Create Pull Request

---

# 👨‍💻 Author

**Mohit Aman**

Software Test Engineer

Specialization

- Mobile Automation
- Selenium
- Appium
- Java
- TestNG
- API Testing
- CI/CD

---

# ⭐ Future Enhancements

- iOS Automation
- Allure Reports
- BrowserStack Integration
- LambdaTest Integration
- Docker Support
- Parallel Device Execution
- AI Based Self Healing Locators

---

# 📄 License

This project is intended for educational and professional automation purposes.
