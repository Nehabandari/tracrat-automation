package tracratselenium.aruna.page;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tracratselenium.aruna.helpers.DriverHelper;

import java.time.Duration;

public class CompanyPage {

    @FindBy(xpath = "//button[@title='Add a new Company.']")
    WebElement addcomapnybutton;

    @FindBy(xpath = "//p[@class='card-text']")
    WebElement managecompaniestext;


    @FindBy(xpath="//div[@class='card-header']/strong")
    WebElement verifyingaddcomapnypage;

    @FindBy(id ="name")
    WebElement companyNameTextField;

    @FindBy(id="url")
    WebElement urlTextField;


    @FindBy(id="fax")
    WebElement faxTextField;

    @FindBy(id="AddressLine1")
    WebElement addressLine1TextField;

    @FindBy(id="AddressLine2")
    WebElement addressLine2TextField;


    @FindBy(id = "phone")
    WebElement phonenumberTextField;

    @FindBy(id = "city")
    WebElement cityTextField;

    @FindBy(id = "state")
    WebElement stateTextField;

    @FindBy(id = "pcode")
    WebElement postalCodeTextField;

    @FindBy(id="desc")
    WebElement descriptionTextField;

    @FindBy(id="conatctName")
    WebElement primaryContactNameTextField;

    @FindBy(id = "companyAnnouncement")
    WebElement companyAnnouncementsTextField;

    @FindBy(xpath = "//button[@title='Save Company']")
    WebElement saveButton;

    @FindBy(xpath="//div[contains(@class, 'div-search')]/input")
    WebElement searchcompanyName;

    @FindBy(xpath="//table/tbody/tr/td")
    WebElement companyInTheTable;

    @FindBy(xpath ="//button[@title='Edit this Company']")
    WebElement editButton;

    @FindBy(xpath = "//div[@class='card-header']/strong")
    WebElement companyHeaderInTheDetailsPage;


    WebDriver wdriver;

    private DriverHelper driverHelper;

    private String companyName;

       public CompanyPage(DriverHelper dh){
        PageFactory.initElements(dh.getDriver(), this);
        wdriver = dh.getDriver();
        driverHelper = dh;
    }

    public void setCompanyName(String compName){
        companyName = compName;
    }


    public String getCompanyName(){
        return companyName;
    }

    public void waitforddcompanybutton(){
        driverHelper.waitForVisible(addcomapnybutton);
        //new WebDriverWait(wdriver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(addcomapnybutton));
        //addcomapnybutton.click();

    }

    public void verifymanagecompanytext(){
        if(!managecompaniestext.getText().contains("Manage Companies")) {
            System.out.println(managecompaniestext.getText());

            Assert.fail();
        }
    }

    public void clickOnAddCompanyButton(){
        addcomapnybutton.click();
    }

    public void verifyAddCompanyPage(){
        new WebDriverWait(wdriver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(verifyingaddcomapnypage));
        Assert.assertTrue(verifyingaddcomapnypage.isDisplayed());
    }

    public void enterCompanyData() throws Exception{
        //String companyData = RandomStringUtils.randomAlphabetic(5);

        Faker faker = new Faker();
        companyName = faker.company().name();
        companyNameTextField.sendKeys(companyName);
        System.out.println(companyName);
        urlTextField.sendKeys((faker.company().url()));
        phonenumberTextField.sendKeys(faker.phoneNumber().subscriberNumber());
        faxTextField.sendKeys(faker.phoneNumber().phoneNumber());
        addressLine1TextField.sendKeys(faker.address().streetAddress());
        addressLine2TextField.sendKeys(faker.address().secondaryAddress());
        cityTextField.sendKeys(faker.address().cityName());
        stateTextField.sendKeys(faker.address().state());
        postalCodeTextField.sendKeys(faker.address().postcode());
        descriptionTextField.sendKeys(faker.company().catchPhrase());
        primaryContactNameTextField.sendKeys(faker.artist().name());
        companyAnnouncementsTextField.sendKeys(RandomStringUtils.randomAlphanumeric(30));
        Thread.sleep(5000);

    }


    public void clickonSaveButton(){
       //((JavascriptExecutor) wdriver).executeScript("arguments[0].scrollIntoView();", saveButton);

        //JavascriptExecutor js = (JavascriptExecutor) wdriver;
        //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //js.executeScript("window.scrollBy(0,850)", "");
               new Actions(wdriver)
                .scrollToElement(saveButton)
                .perform();

        saveButton.click();
    }

    public void verifyingcompanysuccessmessage(){
        new WebDriverWait(wdriver,Duration.ofSeconds(60)).until(ExpectedConditions.alertIsPresent());
        Alert alert = wdriver.switchTo().alert();
        //Store the alert text in a variable and verify it
        String text = alert.getText();
        Assert.assertEquals(text, "Company successfully Added,Refreshing List");
        alert.accept();
    }

    public void searchingForCompanyName(){

        driverHelper.waitForVisible(searchcompanyName);

        searchcompanyName.sendKeys(companyName);
    }

    public void verifyingcompanynameFromTheccompanyList(){

           new Actions(wdriver, Duration.ofSeconds(20)).pause(Duration.ofSeconds(2)).perform();
           Assert.assertEquals(companyInTheTable.getText(),companyName);
    }

    public void clickOnEditButton(){
           editButton.click();
    }

    public void verifyingCompanyDetailsPage(){
           driverHelper.waitForVisible(companyHeaderInTheDetailsPage);
           Assert.assertEquals(companyNameTextField.getAttribute("value"), companyName);
    }
}
