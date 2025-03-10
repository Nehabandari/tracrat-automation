package tracratselenium.newrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\resources\\Features",
        glue = "tracratselenium\\newstepdefs",
        //tags = "@smoke",
        plugin = {
                "html:target/cucumber/results.html"
        }
)
public class NewCucumberRunner extends AbstractTestNGCucumberTests {
}
