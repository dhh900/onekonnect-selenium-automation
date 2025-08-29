package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = {"TestCases"},
        plugin = {"pretty", "html:target/TestReport.html"},
        tags = "@smoke"  // Lowercase to match feature
)

public class TestRunners extends AbstractTestNGCucumberTests {
}