# Selenide Java Test Automation Framework

## Overview

This project is a test automation framework built with Selenide, Java, and Maven. It provides a robust foundation for
web UI testing with clean, readable test code and powerful reporting capabilities.

AUT/Demo website: https://demo.testarchitect.com/

## Features

- **Selenide-based UI Testing**: Concise and stable UI tests with automatic screenshots and advanced element selectors
- **Page Object Model**: Well-structured test architecture following best practices
- **Parallel Test Execution**: Configuration for running tests in parallel
- **Custom Reporting**: Detailed Allure reports with screenshots, test steps, and execution logs
- **CI/CD Integration**: Ready-to-use configurations for popular CI systems

## Prerequisites

- Java JDK 21 or higher
- Maven 3.6.3 or higher
- Chrome browser installed

## Project Structure

```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── constants
│   │   │           ├── models
│   │   │           ├── utils
│   │   │           └── pages
│   │   └── resources
│   └── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           ├── tests
│       │           └── api
│       └── resources
│           └── testdata
├── target
├── pom.xml
├── README.md
└── .gitignore
```

## Installation

1. Clone the repository:

```bash
git clone https://github.com/nbmhoang/selenide-example
cd selenide-example
```

2. Install dependencies:

```bash
mvn clean install -DskipTests
```

## Configuration

Core configurations are stored in `src/main/resources/properties/config.properties` file:

```properties
url=https://demo.testarchitect.com/
email=
password=
```

You can override these properties via command line:

```bash
mvn test -Dbrowser=firefox -DheadlessMode=true
```

## Running Tests

### Run all tests

```bash
mvn clean test
```

### Run a specific test class

```bash
mvn clean test -Dtest=LoginTests
```

### Run tests with tags

```bash
mvn clean test -Dgroups=smoke
```

### Generate Allure Report

```bash
mvn allure:serve
```

## Writing Tests

### Basic Test Structure

```java
public class LoginTests extends BaseTest {

    @Test
    public void userCanLogin() {
        open("/login");

        new LoginPage()
                .setUsername("testuser")
                .setPassword("password")
                .clickLoginButton();

        new DashboardPage().verifyDashboardIsDisplayed();
    }
}
```

### Page Object Example

```java
public class LoginPage {
    private final SelenideElement usernameField = $("#username");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("button[type='submit']");

    public LoginPage setUsername(String username) {
        usernameField.setValue(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
```

## Key Dependencies

- [Selenide](https://selenide.org/) - Concise UI test framework
- [TestNG](https://testng.org/) - Test runner
- [Allure](https://docs.qameta.io/allure/) - Reporting
- [Log4j](https://logging.apache.org/log4j/2.x/) - Logging
- [JavaFaker](https://github.com/DiUS/java-faker) - Test data generation
- [AssertJ](https://assertj.github.io/doc/) - Fluent assertions

## CI/CD Integration

### GitHub Actions

`.github/workflows/tests.yml` is included for GitHub Actions integration.

### Jenkins

`Jenkinsfile` is provided with a pipeline configuration.

## Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin feature/my-new-feature`
5. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
