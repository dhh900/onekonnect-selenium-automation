package TestCases;

import Pages.P01_Login;
import Pages.P02_Home;
import Pages.P03_EDI;
import Pages.P04_Orders;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ReadExcel;

import java.time.Duration;

public class LoginAndOrderSteps {
    // Row index in Excel sheet for EDI test data
    private static int ediRowIndex = 6;
    // Page Object classes
    P01_Login loginPage = new P01_Login();
    P02_Home homePage = new P02_Home();
    P03_EDI ediPage = new P03_EDI();
    P04_Orders ordersPage = new P04_Orders();
    // Variables to store Excel data
    String[][] loginData;
    String[][] ediData;
    // Excel reader utility

    ReadExcel reader = new ReadExcel();
    String filePath = "testdata/oneKonnect.xlsx";

    // Constructor to load test data from Excel
    public LoginAndOrderSteps() {
        loginData = reader.readData(filePath, "Credentials");
        ediData = reader.readData(filePath, "EDI");
    }

    @Given("user open the OneKonnect website")
    public void user_open_the_onekonnect_website() {
        // Step handled in Hooks (browser setup/opening website)
    }

    @When("user enter valid username and password")
    public void user_enter_valid_username_and_password() {
        // Loop through credentials in Excel and enter them

        for (int i = 0; i < loginData.length; i++) {
            String username = loginData[i][0];
            String password = loginData[i][1];

            loginPage.loginUsernameLoc().clear();
            loginPage.loginPasswordLoc().clear();

            loginPage.loginUsernameLoc().sendKeys(username);
            loginPage.loginPasswordLoc().sendKeys(password);
        }
    }

    @And("user click on the login button")
    public void user_click_on_the_login_button() {
        // Click login button
        loginPage.loginBtnLoc().click();
    }

    @Then("user should be navigated to the OneKonnect homepage and see username greeting")
    public void user_should_be_navigated_to_the_onekonnect_homepage_and_see_username_greeting() {
        // Wait for user greeting to appear
        Hooks.wait.until(ExpectedConditions.visibilityOf(homePage.userGreetingLoc()));
        // Validate login by checking URL and greeting
        if (Hooks.driver.getCurrentUrl().contains("PartnerDashBoard")) {
            System.out.println("Login success");
            Assert.assertTrue(homePage.userGreetingLoc().isDisplayed(), "User greeting is not displayed!");
            System.out.println(homePage.userGreetingLoc().getText());
        } else {
            System.out.println("Login failed");
        }
    }

    @When("user navigate to the EDI creation form from the dashboard")
    public void user_navigate_to_the_edi_creation_form_from_the_dashboard() {
        // Navigate to Add EDI form
        homePage.plusBtnLoc().click();
        Hooks.wait.until(ExpectedConditions.visibilityOf(homePage.AddEDILoc()));
        homePage.AddEDILoc().click();
        // Assert correct page opened
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("/PartnerOrders/AddOrder"));
    }

    @And("user fill only the mandatory EDI fields")
    public void user_fill_only_the_mandatory_edi_fields() {
        // Reset index if it exceeds available data
        if (ediRowIndex >= ediData.length) {
            ediRowIndex = 18;
        }
        // Get row data from Excel
        String[] row = ediData[ediRowIndex];
        System.out.println("Using EDI row index: " + ediRowIndex + " with data: " + String.join(", ", row));
        // Wait for page to be ready
        Hooks.wait.until(ExpectedConditions.visibilityOf(ediPage.p_contactNameLoc()));
        // Fill form fields from Excel data
        ediPage.p_contactNameLoc().sendKeys(row[0]);
        ediPage.p_contactPhoneLoc().sendKeys(row[1]);
        ediPage.p_contactEmailLoc().sendKeys(row[2]);
        ediPage.c_customerNameLoc().sendKeys(row[3]);
        ediPage.c_customerIDLoc().sendKeys(row[4]);
        ediPage.c_streetAddressLoc().sendKeys(row[5]);
        ediPage.c_cityLoc().sendKeys(row[6]);
        // Select dropdown (Customer State)
        Select c_stateDropdown = new Select(ediPage.c_stateLoc());
        c_stateDropdown.selectByVisibleText(row[7]);
        ediPage.c_zipCodeLoc().sendKeys(row[8]);
        ediPage.c_contactNameLoc().sendKeys(row[9]);
        ediPage.c_contactPhoneLoc().sendKeys(row[10]);
        ediPage.c_contactEmailLoc().sendKeys(row[11]);
        ediPage.nc_companyNameLoc().sendKeys(row[12]);
        ediPage.nc_cityLoc().sendKeys(row[13]);
        // Select dropdown (New Company State)
        Select nc_stateDropdown = new Select(ediPage.nc_stateLoc());
        nc_stateDropdown.selectByVisibleText(row[14]);
        ediPage.nc_federalTaxIDLoc().sendKeys(row[15]);
        ediPage.nc_companyAddressLoc().sendKeys(row[16]);
        ediPage.cb_noOfCarrierConnectionLoc().sendKeys(row[17]);
        // Select date in datepicker
        ediPage.cb_planYearStartDateLoc().click();
        Hooks.wait.until(ExpectedConditions.visibilityOf(ediPage.cb_planYearStartDateLoc()));
        WebElement monthYear = Hooks.driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch"));
        Hooks.driver.findElement(By.xpath("//td[@class='day' and text()='15']")).click();
        ediPage.cb_noOfEmployeesLoc().sendKeys(row[19]);
        ediPage.ncr_carrierNameLoc().sendKeys(row[20]);
        ediPage.ncr_contactNameLoc().sendKeys(row[21]);
        ediPage.ncr_contactEmailLoc().sendKeys(row[22]);
        // Select COBRA Members option
        new Select(ediPage.ncr_includeCOBRAMembersLoc()).selectByVisibleText(row[23]);
        // Scroll to bottom of the form
        JavascriptExecutor js = Hooks.driver;
        js.executeScript("scroll(0,3000)");
        // Select Plan Type
        ediPage.ncr_planTypeCheckbox().click();
        // Move to next row for next test
        ediRowIndex++;
    }

    @And("user submit the EDI order")
    public void user_submit_the_edi_order() {
        // Submit the order
        ediPage.submitOrderBtnLoc().click();
        // Wait for confirmation popup and confirm
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(2));
        ediPage.submitOrderConfirmationLoc().click();
        System.out.println("Confirmed order submission");
        // Click on final confirmation
        ediPage.orderConfirmationLoc().click();
        // Validate order number is displayed
        Assert.assertTrue(ediPage.orderNoLoc().isDisplayed());
        System.out.println("Order No.: " + ediPage.orderNoLoc().getText());
    }

    @Then("user navigated to the Orders tab")
    public void user_navigated_to_the_orders_tab() {
        // Open Orders tab
        homePage.ordersTabLoc().click();
        // Verify correct URL
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://devtesting.onekonnect.com/eBNPartnerPortal_test2/PartnerOrders/ViewPartnerOrders");
    }

    @And("user should see the created order in the Orders list")
    public void user_should_see_the_created_order_in_the_orders_list() {
        // Wait until orders list is visible
        Hooks.wait.until(ExpectedConditions.visibilityOfAllElements(ordersPage.orderRowsLoc()));
        // Validate order appears in list
        Assert.assertTrue(ordersPage.orderRowsLoc().isDisplayed(), "Created order not found in list");
        System.out.println("Order No.: " + ordersPage.orderRowsLoc().getText());
    }
}
