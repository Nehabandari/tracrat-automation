package tracratselenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tracratselenium.helpers.DriverHelper;
import tracratselenium.pojo.CompanyDataDetails;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private WebDriver webdriver;

    private DriverHelper driverHelper;

    private CompanyDataDetails companyDataDetails;

    private By ngxLoader = By.xpath("//ngx-spinner/div");
    private By homepagelink = By.linkText("Home");

    //@FindBy(linkText = "Home")
    //WebElement homepagelink;

    @FindBy(xpath = "//h4[@class='card-title mb-0']")
    WebElement primaryfindings;

    @FindBy(xpath = "//div[@title='click here to Manage Companies']/ngx-select-dropdown/div/div/button")
    WebElement selectcompany;

    @FindBy(name = "search-text")
    WebElement searchcompanytextfield;

    @FindBy(xpath = "//div[@class='available-items']/div")
    List< WebElement> companieslist;

    @FindBy(xpath = "(//h4)[3]")
    WebElement verifyingcompany;

    @FindBy(partialLinkText = "Company")
    WebElement companyLink;

    @FindBy(partialLinkText = "Manage Companies")
    WebElement managecompanieslink;


    public HomePage(DriverHelper driverHelper, CompanyDataDetails companyDataDetails){
        webdriver = driverHelper.getDriver();
        this.driverHelper = driverHelper;
        PageFactory.initElements(driverHelper.getDriver(), this);
        this.companyDataDetails = companyDataDetails;
    }

        public void checkhomelinkisdisplayed(){
        WebElement homepg = webdriver.findElement(homepagelink);
        Assert.assertTrue(homepg.isDisplayed());
    }

    public void selectingCompany(String companyname)throws Exception{

        new WebDriverWait(webdriver, Duration.ofSeconds(30)).until(ExpectedConditions.numberOfElementsToBe(ngxLoader, 0));
        new WebDriverWait(webdriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(selectcompany));
        //Thread.sleep(1000);

        selectcompany.click();
        new WebDriverWait(webdriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(searchcompanytextfield));
        searchcompanytextfield.sendKeys(companyname);
        Thread.sleep(1000);
        boolean iscompanyclicked = false;
        for(WebElement eachcompany:companieslist){

            if(companyname.equals(eachcompany.getText())) {
                companyDataDetails.setName(companyname);
                eachcompany.click();

                iscompanyclicked = true;
            }

        }
        Assert.assertTrue(iscompanyclicked);



    }


    public void verifyselectedcompanyloaded(){

        new WebDriverWait(webdriver,Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(primaryfindings));

        Assert.assertTrue(verifyingcompany.isDisplayed());
        String compaName = verifyingcompany.getText();
        if(!compaName.contains(companyDataDetails.getName())){
            Assert.fail();
        }
        
    }

    public void clickOnCompanymenu(){
        companyLink.click();
    }

    public void clickManagecompanieslinkabc(){
        driverHelper.waitForVisible(managecompanieslink);
        managecompanieslink.click();
    }


}
