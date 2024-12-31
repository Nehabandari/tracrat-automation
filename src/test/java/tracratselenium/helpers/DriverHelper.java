package tracratselenium.helpers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import tracratselenium.stepdef.browserStepdefs;

public class DriverHelper {
	
	private WebDriver webDriver;
	
	public  DriverHelper(browserStepdefs browserstepdefs) {
		webDriver=browserstepdefs.getDriver();
	}
	
	public WebDriver getDriver() {
		return webDriver;
	}
	
	public void waitForVisible(WebElement webElement){
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(webElement));
	}
	public void waitForClickable(WebElement webElement){
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(webElement));
	}
	public void waitForElementNotPresent(By locator) {
		new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.numberOfElementsToBe(locator, 0));
	}
	
	public void pause(int timeoutInMilliseconds) {
		try {
			Thread.sleep(timeoutInMilliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public WebElement until(ExpectedCondition<WebElement> visibilityOfElementLocated) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void click(WebElement webElement){
		webElement.click();
	}
	
	public void selectNgxDropdownOption(WebElement webelement, String value) {
		waitForVisible(webelement);
		click(webelement);
		pause(2000);
		WebElement searchText = webelement.findElement(By.name("search-text"));
		waitForClickable(searchText);
		searchText.sendKeys(value);
		pause(1500);
		List<WebElement> options = webelement.findElements(By.xpath("./div[@class='available-items']/div"));
		boolean foundOption = false;
		for(WebElement eachOption : options) {
			String optionText = eachOption.getText().trim();
			System.out.println(optionText);
			if(optionText.equals(value)) {
				foundOption = true;
				eachOption.click();
				break;
			}
		}
		Assert.assertTrue(foundOption, value+" Option not found");
	}
}
