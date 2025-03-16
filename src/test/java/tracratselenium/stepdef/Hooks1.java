package tracratselenium.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Hooks1 {
    private WebDriver wd;

    public WebDriver getDriver(){
        return wd;
    }
    @Before
    public void beforeScenario(){
        System.out.println("I am in before scenario");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars","start-maximized","--disable-extensions");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("autofill.profile_enabled",false);
        chromeOptions.setExperimentalOption("prefs", prefs);
        wd = new ChromeDriver(chromeOptions);
        //wd.manage().window().maximize();
        wd.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.get("https://angular15.gotracrat.in/#/login");
    }

    @After
    public void afterScenario(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/jpeg", scenario.getId());
        }
        System.out.println("I am in after scenario");
        wd.quit();

    }
}
}
