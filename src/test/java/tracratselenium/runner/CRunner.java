package tracratselenium.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\resources\\Features",
        glue = "tracratselenium\\stepdef",
        plugin = {
                "html:target/Cucumber2/result.html"
        }


)
public class CRunner extends AbstractTestNGCucumberTests  {

}
