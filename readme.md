# TestAppTravels

This is an automated testing project for testing web applications using Selenium WebDriver, TestNG, and Maven. It focuses on automating scenarios such as hotel searches, user sign-ups, and result validations.

---

## Features

- Automated test scenarios using Selenium WebDriver.
- ExtentReports integration for detailed test reports.
- Modular page object model structure for maintainability.
- Logging with Log4j for better debugging and tracking.

---

## Tools & Technologies

- **Selenium WebDriver** - Browser automation.
- **TestNG** - Testing framework.
- **ExtentReports** - Reporting tool.
- **Log4j** - Logging utility.
- **Maven** - Build tool.
- **Java 17** - Programming language used for test scripts.


## Project Structure

- **index.html** - Extent report file generated after running tests.
- **pom.xml** - Maven configuration and dependencies.

### `src/`
- **main/**
    - **java/**
        - **pl.seleniumdemo/**
            - `LoggerTest.java` - Example logging utility.
    - **resources/**
        - `log4j2.xml` - Logging configuration.

- **test/**
    - **java/**
        - **pl.seleniumdemo/**
            - **pages/**
                - `HotelSearchPage.java` - Handles hotel search functionalities.
                - `LoggedUserPage.java` - Handles logged-in user functionalities.
                - `ResultsPage.java` - Handles search results functionalities.
                - `SignUpPage.java` - Handles user sign-up functionalities.
            - **tests/**
                - `BaseTest.java` - Base setup for the test suite.
                - `HotelSearchTest.java` - Test cases for hotel searches.
                - `SignUpTest.java` - Test cases for user sign-ups.
            - **utils/**
                - `DriverFactory.java` - Utility for browser driver setup.
                - `PropertiesLoader.java` - Utility for loading configuration files.
                - `SeleniumHelper.java` - Helper methods for Selenium.
    - **resources/**
        - **screenshots/** - Directory for screenshots taken during tests.
        - **config.properties** - Configuration file for the browser name.

---


## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/lubomat/TestAppTravels.git
