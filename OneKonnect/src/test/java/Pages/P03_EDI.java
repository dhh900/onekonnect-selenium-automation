package Pages;

import TestCases.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P03_EDI {
    public WebElement p_contactNameLoc() {
        return Hooks.driver.findElement(By.id("partnerContactName"));
    }

    public WebElement p_contactPhoneLoc() {
        return Hooks.driver.findElement(By.id("partnerContactPhone"));
    }

    public WebElement p_contactEmailLoc() {
        return Hooks.driver.findElement(By.id("partnerContactEmail"));
    }

    public WebElement c_customerNameLoc() {
        return Hooks.driver.findElement(By.id("CustomerName"));
    }

    public WebElement c_customerIDLoc() {
        return Hooks.driver.findElement(By.id("CustomerCode"));
    }

    public WebElement c_streetAddressLoc() {
        return Hooks.driver.findElement(By.id("CustomerAdd"));
    }

    public WebElement c_cityLoc() {
        return Hooks.driver.findElement(By.id("CustomerCity"));
    }

    public WebElement c_stateLoc() {
        return Hooks.driver.findElement(By.id("StateID"));
    }

    public WebElement c_zipCodeLoc() {
        return Hooks.driver.findElement(By.id("PrimaryCode"));
    }

    public WebElement c_contactNameLoc() {
        return Hooks.driver.findElement(By.id("ContactName"));
    }

    public WebElement c_contactPhoneLoc() {
        return Hooks.driver.findElement(By.id("ContactNumber"));
    }

    public WebElement c_contactEmailLoc() {
        return Hooks.driver.findElement(By.id("ContactEmail"));
    }

    public WebElement nc_companyNameLoc() {
        return Hooks.driver.findElement(By.id("CompName_0"));
    }

    public WebElement nc_cityLoc() {
        return Hooks.driver.findElement(By.id("CompCity_0"));
    }

    public WebElement nc_stateLoc() {
        return Hooks.driver.findElement(By.id("CompStateID_0"));
    }

    public WebElement nc_federalTaxIDLoc() {
        return Hooks.driver.findElement(By.id("CompFedralTaxID_0"));
    }

    public WebElement nc_companyAddressLoc() {
        return Hooks.driver.findElement(By.id("CompAddress_0"));
    }

    public WebElement cb_noOfCarrierConnectionLoc() {
        return Hooks.driver.findElement(By.id("ConnectionsNumber"));
    }

    public WebElement cb_planYearStartDateLoc() {
        return Hooks.driver.findElement(By.id("PlanYearStartDate"));
    }

    public WebElement cb_noOfEmployeesLoc() {
        return Hooks.driver.findElement(By.id("EmployeesNumber"));
    }

    public WebElement ncr_carrierNameLoc() {
        return Hooks.driver.findElement(By.id("CarrierName_0"));
    }

    public WebElement ncr_contactNameLoc() {
        return Hooks.driver.findElement(By.id("ContactName_0"));
    }

    public WebElement ncr_contactEmailLoc() {
        return Hooks.driver.findElement(By.id("ContactEmail_0"));
    }

    public WebElement ncr_includeCOBRAMembersLoc() {
        return Hooks.driver.findElement(By.id("CobraMembers_0"));
    }

    public WebElement ncr_planTypeCheckbox() {
        return Hooks.driver.findElement(By.id("Carrier_0_PlanChecked_1"));
    }

    public WebElement submitOrderBtnLoc() {
        return Hooks.driver.findElement(By.id("UASub"));
    }

    public WebElement submitOrderConfirmationLoc() {
        return Hooks.driver.findElement(By.id("confirm_id"));
    }

    public WebElement orderConfirmationLoc() {
        return Hooks.driver.findElement(By.id("success_id"));
    }

    public WebElement orderNoLoc() {
        return Hooks.driver.findElement(By.className("numberTxtBox"));
    }
}