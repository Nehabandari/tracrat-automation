package tracratselenium.aruna.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src\\test\\resources\\Feature1",
    tags = "@smoke",
    glue = "tracratselenium\\aruna\\stepdef",
        plugin = {
            "html:target/Cucumber1/result.html"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {



}
