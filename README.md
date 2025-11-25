Your current `README.md` is **excellent**—it's professional, comprehensive, and well-structured. You've covered all the technical requirements and project details perfectly.

To make it even more impactful and directly highlight the skills requested in Task 2 (Design Pattern & Clean Code), I have made two key refinements:

1.  **Refined Design Patterns:** Explicitly call out the **Service Object Model** and the **Builder Pattern** as the primary choices, which are the gold standard for API testing frameworks.
2.  **Simplified Test Scenarios:** Used clearer terminology (e.g., "Schema Validation") to describe your testing depth.

Here is the updated, simplified, and strategically refined Markdown:

-----

## 🚀 Updated `README.md` for Task 2

# FakerAPI Automation Test Project

This project contains automated API tests for **FakerAPI** using Java, RestAssured, and TestNG. The framework is built on **clean code principles** and employs essential **design patterns** for maintainability and scalability.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Project Setup](#project-setup)
- [Project Structure](#project-structure)
- [Running the Tests](#running-the-tests)
- [Test Scenarios & Coverage](#test-scenarios--coverage)
- [Design Patterns & Clean Code](#design-patterns--clean-code)

***

## Prerequisites

Ensure you have the following installed:
* **Java JDK 11** or higher (`java -version`)
* **Apache Maven 3.6** or higher (`mvn -version`)

## Project Setup

1.  **Clone the repository** (or navigate to the project directory):
    ```bash
    git clone <repository-url>
    cd dummyapi-automation
    ```

2.  **Install dependencies**:
    ```bash
    mvn clean install
    ```

## Project Structure

The project uses the **Service Object Model (SOM)** pattern to separate the API interaction layer from the test logic.

````

dummyapi-automation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       ├── clients/          \# Service Layer (API interactions)
│   │   │       │   └── UserClient.java
│   │   │       └── data/             \# Data Builders/Models (Request/Response POJOs)
│   │   │           └── UserBuilder.java
│   │   └── resources/
│   │       └── config.properties     \# Centralized configuration (Base URL, etc.)
│   └── test/
│       └── java/
│           └── com/example/tests/    \# Test Layer (TestNG Assertions)
│               ├── UserTests.java
│               └── ...
├── pom.xml                           \# Maven Configuration
└── testng.xml                        \# TestNG Test Suite

````

***

## Running the Tests

### Quick Start (Recommended)
This command cleans, executes all tests, generates the report, and opens it automatically:

```bash
mvn clean test && mvn allure:serve
````

### Individual Commands

| Action | Command | Notes |
| :--- | :--- | :--- |
| **Run All Tests** | `mvn clean test` | Executes tests defined in `testng.xml`. |
| **Run Specific Class** | `mvn test -Dtest=UserTests` | Executes only the specified test class. |
| **View Allure Report** | `mvn allure:serve` | Generates and opens the interactive HTML report. |

-----

## Test Scenarios & Coverage

The tests focus on covering Happy Path, Boundary Conditions, and critical Data Validation for the API endpoints.

| API Endpoint | Test Cases Implemented | Test Type Covered |
| :--- | :--- | :--- |
| **User API (`/v1/users`)** | 4 | Happy Path, **Boundary Limits** (0, 100 users), **Schema Validation** (required fields). |
| **Company API (`/v1/companies`)** | 4 | Happy Path, **Boundary Limits** (0, 100 companies), **Schema Validation**. |
| **Book API (`/v1/books`)** | 4 | Happy Path, **Boundary Limits** (0, 100 books), **Schema Validation**. |

**Total Coverage Summary:** 12 tests covering three endpoints, ensuring functional integrity and data correctness under various conditions.

-----

## Design Patterns & Clean Code

The framework adheres to **Clean Code** principles, primarily using the **Service Object Model** for structure.

### Design Patterns Implemented

| Pattern | Component | Purpose |
| :--- | :--- | :--- |
| **Service Object Model (SOM)** | `UserClient.java` | Separates the **API Call logic (Act)** from the **Test Logic (Assert)**, adhering to the Single Responsibility Principle (SRP). |
| **Builder Pattern** | `UserBuilder.java` | Creates complex request bodies (POJOs) step-by-step using a **fluent interface**, making test data creation clean and readable. |
| **Singleton/Configuration** | `ConfigLoader` | Ensures only one instance of configuration data (like `base.url`) is loaded and shared across all tests, promoting the **DRY** principle. |

### Clean Code Principles Followed

  * **AAA Pattern:** Every test method is clearly structured: **Arrange** (set up data/client), **Act** (call API via client), **Assert** (validate response).
  * **DRY (Don't Repeat Yourself):** Achieved via **`BaseClient`** (for common headers/setup) and centralized **`config.properties`** (for parameters).
  * **Meaningful Naming:** Test methods clearly indicate intent (e.g., `testRetrieveMax100Users()`).

-----

**Author**: Ahmad Fahrezi  
**Last Updated**: November 2025