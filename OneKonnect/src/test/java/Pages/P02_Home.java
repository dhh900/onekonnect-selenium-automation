package Pages;

import TestCases.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_Home {
    public WebElement userGreetingLoc() {
        return Hooks.driver.findElement(By.className("usernamegeerting"));
    }

    public WebElement plusBtnLoc() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[1]/div/div/div/ul/li[5]"));
    }

    public WebElement AddEDILoc() {
        return Hooks.driver.findElement(By.id("AddEDI"));
    }

    public WebElement ordersTabLoc() {
        return Hooks.driver.findElement(By.id("order"));
    }


}
