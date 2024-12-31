package tracratselenium.pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.record.RefreshAllRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v121.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import tracratselenium.helpers.DriverHelper;
import tracratselenium.stepdef.browserStepdefs;

public class CompanyPage {
	
	private WebDriver webDriver;
	
	@FindBy(xpath="//a[@class='nav-link ng-star-inserted active']")
	private WebElement ManageCompany;
	
	@FindBy(xpath="//modal-container[@role='dialog']")
	private WebElement manageCompanyHeader;
	
	public DriverHelper driverHelper;
	/*
	
	public void click_ManageCompany() {
		ManageCompany.click();
	}
	public void waitforManageCompanyHeader() {
		driverHelper.waitForVissible(manageCompanyHeader);
		//DriverHelper.waitForVissible(manageCompanyHeader);	
		Assert.assertEquals(manageCompanyHeader.getText(),"Manage Companies");
	}*/
		
}
