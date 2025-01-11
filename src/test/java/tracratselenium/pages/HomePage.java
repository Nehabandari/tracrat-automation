package tracratselenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import tracratselenium.helpers.DriverHelper;
@Slf4j
public class HomePage {

    private By loader = By.className("loader");
    private By ngxLoader = By.xpath("//ngx-spinner/div");

    @FindBy(xpath = "//span[normalize-space()='Current Roles']")            //elements
    private WebElement currentRoleHeader;


    @FindBy(xpath = "//div[@title='click here to Manage Companies']/ngx-select-dropdown")
    //div[normalize-space()='Select Company']
    // fixing this
  //  @FindBy(xpath = "//button[normalize-space()='Select Company']")
    private WebElement selectCompanyDropdown;


    private String selectCompany;
    private String companyName;
    private DriverHelper driverHelper;
    WebDriver webDriver;
    WebDriver driver;


    public HomePage(DriverHelper driverHelper) {
        webDriver = driverHelper.getDriver();
        PageFactory.initElements(webDriver, this);       //initialization
        this.driverHelper = driverHelper;
    }

    public void waitForCurrentRoleHeader() {
        driverHelper.waitForElementNotPresent(loader);
        driverHelper.waitForPageLoad();
        driverHelper.waitForVisible(currentRoleHeader);
        driverHelper.waitForElementNotPresent(ngxLoader);
        driverHelper.waitForPageLoad();
        driverHelper.pause(7000);
        Assert.assertEquals(currentRoleHeader.getText(), "Current Roles");
        System.out.println("Enter Dashboard successfully");
        //log.info("Enter Dashboard successfully from slf4j");
    }

    public void selectCompany(String companyName) {
        this.companyName = companyName;
        driverHelper.selectNgxDropdownOption(selectCompanyDropdown, companyName);
        driverHelper.waitForElementNotPresent(ngxLoader);
        System.out.println("click the select company");
    }

    public void verifySelectedCompany(){
        WebElement selectedCompany = selectCompanyDropdown.findElement(By.xpath(".//div[@class='ng-star-inserted']/button"));
        Assert.assertEquals(selectedCompany.getText(), companyName);
    }


}
	
	
	  

	 


