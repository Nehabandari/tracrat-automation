package tracratselenium.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\resources\\Features",
        tags = "@smoke",
        glue = "tracratselenium\\stepdef",
        plugin = {
                "html:target/Cucumber2/result.html"
        }
)
public class CucumberRunner1 extends AbstractTestNGCucumberTests {
}
