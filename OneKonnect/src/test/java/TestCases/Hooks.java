package TestCases;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class Hooks {
    public static ChromeDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://devtesting.onekonnect.com/eBNPartnerPortal_test2/Account/Login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
