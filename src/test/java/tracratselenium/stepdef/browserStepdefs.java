package tracratselenium.stepdef;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tracratselenium.helpers.ConfigReader;

public class browserStepdefs {
	
private WebDriver webDriver;
	
	@Before
	public void openBrowser() {
		System.out.println(ConfigReader.getProperty("browser")+" ##########");
		if(ConfigReader.getProperty("browser").equals("chrome")) {
			webDriver = new ChromeDriver();
		}else if(ConfigReader.getProperty("browser").equals("firefox")) {
			webDriver = new FirefoxDriver();
		}
		
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("pageLoadTimeOut"))));
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		webDriver.get(ConfigReader.getProperty("appUrl"));
		

	}
	
	@After
	public void closeBrowser(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/jpeg", scenario.getId());
		}
		webDriver.quit();
	}
	
	public WebDriver getDriver() {
		return webDriver;
	}
}
