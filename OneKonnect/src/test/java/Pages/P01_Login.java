package Pages;

import TestCases.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_Login {
    public WebElement loginUsernameLoc() {
        return Hooks.driver.findElement(By.id("UserName"));
    }

    public WebElement loginPasswordLoc() {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement loginBtnLoc() {
        return Hooks.driver.findElement(By.className("submitbtn"));
    }
}
