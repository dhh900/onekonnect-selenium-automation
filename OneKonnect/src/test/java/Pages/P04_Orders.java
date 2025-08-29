package Pages;

import TestCases.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P04_Orders {
    public WebElement orderRowsLoc() {
        return Hooks.driver.findElement(By.xpath("//*[@id=\"body\"]/section/section[2]/div/table/tbody/tr[1]/td[3]"));
    }
}

