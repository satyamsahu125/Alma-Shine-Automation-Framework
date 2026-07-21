# AlmaShines Sign Up Automation

## Overview

This repository contains the automation solution for the **AlmaShines SDET Take-Home Assignment**.

The objective of this project is to automate the **Sign Up** workflow of the AlmaShines demo community platform while following industry-standard automation practices. The framework is developed using **Java**, **Selenium WebDriver**, **TestNG**, **Maven**, and the **Page Object Model (POM)** design pattern.

---

# Technology Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI (Excel Data Provider)
- Page Object Model (POM)
- Extent Reports

---

# Project Structure

```text
AlmaShines-Automation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   └── BaseClass.java
│   │   │   │
│   │   │   ├── factory/
│   │   │   │   └── DriverFactory.java
│   │   │   │
│   │   │   ├── pages/
│   │   │   │   ├── DetailPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── MainPage.java
│   │   │   │   ├── RoleDetailsPage.java
│   │   │   │   └── SignUpPage.java
│   │   │   │
│   │   │   └── utilities/
│   │   │       ├── CustomSoftAssert.java
│   │   │       ├── ExcelUtility.java
│   │   │       ├── ExtentManager.java
│   │   │       ├── FileUtility.java
│   │   │       ├── ListenerImplementation.java
│   │   │       ├── PropertiesUtility.java
│   │   │       └── WaitUtility.java
│   │   │
│   │   └── resources/
│   │
│   ├── test/
│   │   ├── java/
│   │   │   └── aTest/
│   │   │       └── SignupTest.java
│   │   │
│   │   └── resources/
│   │       ├── TestData/
│   │       │   └── testData.xlsx
│   │       │
│   │       └── config.properties
│
├── reports/
├── screenshots/
├── target/
├── test-output/
│
├── pom.xml
├── testng.xml
└── README.md
```

---

# Prerequisites

Before running the project, ensure the following are installed:

- Java 8 or later
- Maven
- Google Chrome
- ChromeDriver compatible with the installed Chrome version
- Eclipse IDE or IntelliJ IDEA

---

# Installation

Clone the repository

```bash
git clone <repository-url>
```

Navigate to the project

```bash
cd AlmaShines-Automation
```

Install dependencies

```bash
mvn clean install
```

---

# Configuration

Application configuration is available in

```
src/test/resources/config.properties
```

Example:

```properties
browser=chrome
url=https://www.almashines.com/dtc
```

Change the browser or application URL if required.

---

# Test Data

The framework is completely data-driven.

Update the Excel file before execution.

```
src/test/resources/TestData/testData.xlsx
```

Each worksheet represents a different test scenario (for example, Existing Email, Invalid Name, Invalid Password).

No code changes are required when updating test data.

---

# Automated Test Scenarios

The following scenarios have been automated:

- Existing Email Validation
- Invalid Name Validation
- Invalid Password Validation
- Successful Sign Up Flow (OTP assisted)

---

# Manual Test Scenarios

The following scenarios were intentionally left for manual testing because they require environment support or are outside the assignment scope.

- OTP Expiry
- OTP Resend
- OTP Rate Limiting
- Browser Compatibility Testing
- Mobile Responsiveness
- Accessibility Testing
- Performance Testing
- Network interruption during OTP verification

---

# Running the Tests

Execute all tests using Maven:

```bash
mvn test
```

Or execute the TestNG suite directly from your IDE.

---

# Reports

After execution:

### TestNG Report

```
test-output/
```

### Extent Report

```
reports/
```

### Failure Screenshots

```
screenshots/
```

---

# Important Notes

## OTP Automation

To automate the complete Sign Up flow, an automated OTP retrieval mechanism was implemented using Java's `Scanner` class.

During execution, the script pauses after requesting the OTP and waits for the user to enter the OTP received in the registered email inbox. Once entered, the automation resumes and completes the remaining registration flow.

In a real-world QA environment, OTP verification is typically handled using one of the following approaches:

- Dedicated QA/Test API to retrieve generated OTPs.
- Database access to fetch the latest OTP.
- Mocked OTP service.
- Static OTP configured for lower environments.
- OTP verification disabled in dedicated automation environments.

Reading OTPs directly from an email inbox is generally not recommended for production automation because it introduces external dependencies and can make tests slower or flaky.

---

## Test Design

The framework follows a data-driven approach where each test scenario uses its own worksheet in the Excel file.

This keeps test data independent and allows scenarios to be maintained without modifying the automation code.

---

## Design Decisions

The framework was designed with maintainability and scalability in mind.

Key design decisions include:

- Page Object Model (POM)
- Data-Driven Testing using Apache POI
- Driver Factory Pattern
- Reusable Utility Classes
- Explicit Wait Utilities
- Custom Soft Assertions
- TestNG Listeners
- Extent Reporting

---

# Assumptions

- Existing Email tests require an already registered email account.
- Successful Sign Up requires access to a valid email inbox for OTP verification.
- Internet connectivity is required during execution.
- Chrome is used as the default browser.
- Google Sign Up, Facebook Sign Up, Login, Forgot Password, and post-registration profile completion are outside the scope of this assignment.

---

# Known Limitations

- OTP retrieval depends on email delivery and may increase execution time.
- Dynamic UI changes may require locator updates if the application changes.
- Browser-specific compatibility testing is not included.
- Performance and security testing are outside the scope of this automation project.

---

---

# Author

**Satyam Sahu**

**SDET  Assignment – AlmaShines**
