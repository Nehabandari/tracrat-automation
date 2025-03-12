package TestAutomation.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\resources\\Features",
        glue = "TestAutomation\\Stepdefs",
        plugin = {
                "html:target/Cucumber2/result.html"
        }
)

public class CucumberRunner extends AbstractTestNGCucumberTests {

}
