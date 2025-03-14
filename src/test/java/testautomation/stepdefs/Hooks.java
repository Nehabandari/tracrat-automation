package testautomation.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
    private WebDriver wd;

    public WebDriver getDriver(){
        return wd;
    }
    @Before
    public void beforeScenario(){
        System.out.println("I am in before scenario");
        wd = new ChromeDriver();
        wd.manage().window().maximize();
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
