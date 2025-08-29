# onekonnect-selenium-automation

This project automates login and EDI order creation flows in the OneKonnect web application.  
It uses Selenium WebDriver, Cucumber (BDD), TestNG, and Apache POI for Excel-driven test data.

---

## Project Structure

src
└── test
├── java
│ ├── Hooks.java # WebDriver setup & teardown
│ ├── TestCases/
│ │ └── LoginAndOrderSteps.java # Step definitions for Cucumber
│ └── Pages/ # Page Object Model classes
│ ├── P01_Login.java
│ ├── P02_Home.java
│ ├── P03_EDI.java
│ └── P04_Orders.java
│
└── resources
├── features/
│ └── login_and_order.feature # Cucumber feature file
└── testdata/
└── oneKonnect.xlsx # Excel test data

yaml
Copy code

---

## Prerequisites

Make sure you have the following installed:

- Java 11+  
- Maven 3.6+  
- Google Chrome Browser  
- ChromeDriver (matching your Chrome version)  

> Tip: Add ChromeDriver to your system `PATH`, or configure it in `Hooks.java`.

---

## How to Run the Tests

1. Clone the Repository
```bash
git clone https://github.com/<your-username>/onekonnect-automation.git
cd onekonnect-automation
2. Install Dependencies
bash
Copy code
mvn clean install
3. Run All Tests
bash
Copy code
mvn test
4. Run Tests by Tag
For example, to run only smoke tests:
mvn test -Dcucumber.filter.tags="@smoke"

Reports
After execution, reports will be generated:
TestNG Reports → target/surefire-reports
Cucumber Reports (if configured) → target/cucumber-reports.html
Open the HTML report in your browser to review test results.

Test Data (Excel)
The file testdata/oneKonnect.xlsx contains test data:
Credentials sheet → login username & password
EDI sheet → fields for filling the EDI order form
In LoginAndOrderSteps.java, you can change the row index used for test data:
private static int ediRowIndex = 2; // Choose which Excel row to use

Example Command
Run the smoke scenario for login + EDI order creation:
mvn test -Dcucumber.filter.tags="@smoke"

Author
Dina Hussein
Software QA Engineer
