---

# Platform NG

This is my submission for the Platform NG take home test.

## File Structure

```
ProjectRoot/
│
├── src/main/java/
│   ├── pages/                  # Page Object Models
│   │   ├── HomePage.java
│   │   ├── LoginPage.java
│   │   ├── BasketPage.java
│   │   ├── CheckoutPage.java
│   │   └── ConfirmationPage.java
│   │
│   └── utils/                  # Utility classes
│       ├── DriverFactory.java
│       ├── ConfigReader.java
│       ├── SiteItems.java
│       ├── WaitUtil.java
│       └── ElementUtil.java
│
├── src/test/java/
│   ├── tests/
│   │   ├── unit/               # Unit tests
│   │   │   ├── LoginTests.java
│   │   │   ├── ShoppingTests.java
│   │   │   ├── BasketTests.java
│   │   │   └── CheckoutTests.java
│   │   │
│   │   └── e2e/                # End-to-End tests
│   │       └── CompletePurchaseTest.java
│   │
│   └── base/
│       └── BaseTest.java
│
└── src/test/resources/
    └── config.properties       # Configuration properties
```

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them.

```
Java JDK
Maven
```

### Installing

A step-by-step series of examples that tell you how to get a development environment running.

```
1. Clone the repository
2. Open the project in your IDE (e.g., IntelliJ IDEA, Eclipse)
3. Ensure Maven dependencies are downloaded
```

### Running the Tests

Explain how to run the automated tests for this system.

```
1. Navigate to the src/test/java/tests directory
2. Run tests individually or use a test suite configuration
3. Alternatively, use Maven commands:
   - To run all tests: mvn clean test
   - To run a specific test suite: mvn -Dtest=TestSuiteName test
```

## Built With

* [Selenium WebDriver] - Web automation framework
* [Maven] - Dependency Management
* [TestNG] - Testing Framework

---
