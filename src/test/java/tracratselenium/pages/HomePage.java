package tracratselenium.pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.beust.jcommander.internal.Console;

import io.cucumber.java.it.Data;
import io.opentelemetry.api.trace.Span;
import io.reactivex.rxjava3.functions.Action;
import tracratselenium.helpers.DriverHelper;
import tracratselenium.stepdef.browserStepdefs;

public class HomePage {
	
	private By loader = By.className("loader");
	private By ngxloader = By.xpath("//ngx-spinner/div");
	
	@FindBy(xpath = "//span[normalize-space()='Current Roles']")            //elements
	private WebElement currentroleHeader;

	
	@FindBy(xpath="//div[@title='click here to Manage Companies']/ngx-select-dropdown")
	private WebElement selectCompanyDropdown;
	
	
	public String selectcompany;
	public String companyName;
	public DriverHelper driverHelper;
	WebDriver webDriver;
	WebDriver driver;
	
	
	public HomePage(DriverHelper driverHelper) {
		webDriver=driverHelper.getDriver();
		PageFactory.initElements(webDriver, this);       //initialization
		this.driverHelper=driverHelper;
			
	}
	public void waitforcurrentroleHeader() {
		driverHelper.waitForElementNotPresent(loader);
		driverHelper.pause(5000);
		driverHelper.waitForVisible(currentroleHeader);
		driverHelper.waitForElementNotPresent(ngxloader);
		driverHelper.pause(10000);
		Assert.assertEquals(currentroleHeader.getText(),"Current Roles");
		System.out.println("Enter Dashboard successfully");
				
	}
	
	public void selectCompany(String companyName) {
		driverHelper.selectNgxDropdownOption(selectCompanyDropdown, companyName);
	 	System.out.println("click the select company");
	
	}
		
   
    }
	
	
	  

	 


