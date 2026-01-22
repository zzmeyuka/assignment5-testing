# TestNG Automation Framework - SauceDemo

## Project Overview
This project is an automated testing framework developed for the **SauceDemo (Swag Labs)** web application. It demonstrates the implementation of a professional test automation suite using **Java**, **Selenium WebDriver**, and **TestNG**.

The framework fulfills the following requirements:
1.  **TestNG Lifecycle Management**: Proper use of `@BeforeMethod` and `@AfterMethod`.
2.  **Logging**: Full integration with **Log4j2** to record test steps in a file.
3.  **Reporting**: Automated HTML reports using **Extent Reports**.
4.  **Automatic Screenshots**: Captures browser state upon test failure.

---

## Tech Stack
- **Language**: Java 17
- **Build Tool**: Maven
- **Test Framework**: TestNG
- **Browser Automation**: Selenium WebDriver
- **Logging**: Apache Log4j2
- **Reporting**: Extent Reports 5

---

## Project Structure
- `src/main/resources/log4j2.xml` - Configuration for logging to console and file.
- `src/test/java/org/example/BaseTest.java` - Setup and teardown logic.
- `src/test/java/org/example/SauceDemoTests.java` - Automated test cases.
- `src/test/java/org/example/TestListener.java` - Listener for reporting and screenshots.
- `logs/test_run.log` - File where execution logs are stored.
- `target/ExtentReport.html` - Generated graphical test report.

---

## Test Cases Included
1. **validLoginTest**: Verifies successful login with standard user credentials.
2. **invalidLoginTest**: Verifies that a locked-out user or wrong password triggers an error message.
3. **failedTestForScreenshot**: A deliberate failure case designed to verify the automatic screenshot capture and reporting functionality.

---

## How to Run
1. **Prerequisites**: Ensure you have **JDK 17** and **Maven** installed.
2. **Clone the repository**:
   ```bash
   git clone <your-repository-url>
