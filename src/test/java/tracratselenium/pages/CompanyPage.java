package tracratselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import tracratselenium.helpers.DriverHelper;
import tracratselenium.pojo.CompanyDetails;

public class CompanyPage {

    private WebDriver webDriver;
    private By ngxLoader = By.xpath("//ngx-spinner/div");

    @FindBy(linkText = "Manage Companies")
    private WebElement manageCompaniesLink;

    @FindBy(xpath = "//p[@class='card-text']")
    private WebElement manageCompaniesHeader;

    @FindBy(xpath = "//button[@title='Add a new Company.']")
    private WebElement addCompanyButton;

    @FindBy(xpath = "//div[@class='card-header']/strong")
    private WebElement companyFormHeader;

    @FindBy(css = "input[name='name']")
    private WebElement companyNameTextField;

    @FindBy(css = "input[name='address1']")
    private WebElement addressTextField;

    @FindBy(css = "input[name='phone']")
    private WebElement phoneTextField;

    @FindBy(id = "city")
    private WebElement cityTextField;

    @FindBy(id = "state")
    private WebElement stateTextField;

    @FindBy(xpath = "//button[@title='Save Company']")
    private WebElement saveButton;

    private DriverHelper driverHelper;

    private String companyName;

    public CompanyPage(DriverHelper driverHelper) {
        webDriver = driverHelper.getDriver();
        PageFactory.initElements(webDriver, this);       //initialization
        this.driverHelper = driverHelper;
    }

    public void clickManageCompany() {
        manageCompaniesLink.click();
        driverHelper.waitForPageLoad();
    }


    public void waitForManageCompanyHeader() {
        driverHelper.waitForVisible(manageCompaniesHeader);
        Assert.assertTrue(manageCompaniesHeader.getText().contains("Manage Companies"), "Manage Companies page didnt load");
    }

    public void clickAddCompanyButton() {
        driverHelper.waitForClickable(addCompanyButton);
        driverHelper.click(addCompanyButton);
    }

    public void isAddCompanyPageDisplayed() {
        driverHelper.waitForVisible(companyFormHeader);
        Assert.assertEquals(companyFormHeader.getText(), "ADD COMPANY");
    }

    public void fillAddCompanyDetails(CompanyDetails details) {
        driverHelper.waitForVisible(companyNameTextField);
        companyName = details.getName();
        companyNameTextField.sendKeys(companyName);
        addressTextField.sendKeys(details.getAddress());
        phoneTextField.sendKeys(details.getPhone());
        cityTextField.sendKeys(details.getCity());
        stateTextField.sendKeys(details.getState());
        // Fill other fields
    }

    public String getCompanyName(){
        return companyName;
    }

    public void clickSaveButton() {
        driverHelper.scrollUsingActions(saveButton);
        driverHelper.waitForClickable(saveButton);
        saveButton.click();
    }

    public void isSuccessMessageDisplayed() {
        driverHelper.waitForAlert();
        driverHelper.assertAlert("Company successfully Added,Refreshing List");
        driverHelper.chooseOk();
        driverHelper.waitForElementNotPresent(ngxLoader);
        driverHelper.waitForPageLoad();
    }

}
