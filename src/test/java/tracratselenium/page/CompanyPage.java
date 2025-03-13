package tracratselenium.page;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tracratselenium.helpers.DriverHelper;
import tracratselenium.pojo.CompanyDataDetails;

import java.nio.file.Paths;
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

    @FindBy(id="logo")
    WebElement logoFileUploadField;

    @FindBy(id="conatctName")
    WebElement primaryContactNameTextField;


    @FindAll({
            @FindBy(id = "companyAnnouncement"),
            @FindBy(id = "companyAnnouncements")
    })
    WebElement companyAnnouncementsTextField;

    @FindBy(xpath = "//button[@title='Save Company']")
    WebElement saveButton;

    @FindBy(xpath="//div[contains(@class, 'div-search')]/input")
    WebElement searchcompanyName;

    @FindBy(xpath="//table/tbody/tr/td")
    WebElement companyInTheTable;

    @FindBy(xpath ="//button[@title='Edit this Company']")
    WebElement editButton;

    @FindBy(xpath ="//button[@title='Delete this Company']")
    WebElement deleteButton;

    @FindBy(xpath = "//div[@class='card-header']/strong")
    WebElement companyHeaderInTheDetailsPage;

    @FindBy(id = "tracratAnnouncement")
    WebElement tracratAnnouncementsTextField;

    @FindBy(xpath = "//button[@title='Update this Company']")
    WebElement updatebutton;

    @FindBy(xpath = "//div[@class='modal-content']")
    WebElement deleteConfirmationPopup;

    @FindBy(xpath = "//div[@class='modal-content']/div/button")
    WebElement yesButtonInPopup;


    WebDriver wdriver;

    private DriverHelper driverHelper;

    private CompanyDataDetails companyDataDetails;

        public CompanyPage(DriverHelper dh, CompanyDataDetails companyDataDetails){
        PageFactory.initElements(dh.getDriver(), this);
        wdriver = dh.getDriver();
        driverHelper = dh;
        this.companyDataDetails = companyDataDetails;
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
        companyDataDetails.setName("au_"+RandomStringUtils.randomNumeric(3)+faker.company().name());
        companyDataDetails.setUrl(faker.company().url());
        companyDataDetails.setPhone(faker.phoneNumber().subscriberNumber());
        companyDataDetails.setFax(faker.phoneNumber().phoneNumber());
        companyDataDetails.setAddress1(faker.address().streetAddress());
        companyDataDetails.setAddress2(faker.address().secondaryAddress());
        companyDataDetails.setCity(faker.address().cityName());
        companyDataDetails.setState(faker.address().state());
        companyDataDetails.setPostalCode(faker.address().postcode());
        companyDataDetails.setDescription(faker.company().catchPhrase());
        companyDataDetails.setPrimaryContactName(faker.artist().name());
        companyDataDetails.setTracratAnnouncements("Tracrat Announcements");
        companyDataDetails.setCompanyAnnouncements(RandomStringUtils.randomAlphanumeric(30));

        companyNameTextField.sendKeys(companyDataDetails.getName());
        System.out.println(companyDataDetails.getName());
        urlTextField.sendKeys(companyDataDetails.getUrl());
        phonenumberTextField.sendKeys(companyDataDetails.getPhone());
        faxTextField.sendKeys(companyDataDetails.getFax());
        addressLine1TextField.sendKeys(companyDataDetails.getAddress1());
        addressLine2TextField.sendKeys(companyDataDetails.getAddress2());
        cityTextField.sendKeys(companyDataDetails.getCity());
        stateTextField.sendKeys(companyDataDetails.getState());
        postalCodeTextField.sendKeys(companyDataDetails.getPostalCode());
        descriptionTextField.sendKeys(companyDataDetails.getDescription());
        String imageFile = Paths.get("images/icons8-google-logo-128.png").toAbsolutePath().toString();
        logoFileUploadField.sendKeys(imageFile);
        primaryContactNameTextField.sendKeys(companyDataDetails.getPrimaryContactName());
        companyAnnouncementsTextField.sendKeys(companyDataDetails.getCompanyAnnouncements());
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

    public void verifyingcompanyupdatedsuccessmessage(){
        new WebDriverWait(wdriver,Duration.ofSeconds(60)).until(ExpectedConditions.alertIsPresent());
        Alert alert = wdriver.switchTo().alert();
        //Store the alert text in a variable and verify it
        String text = alert.getText();
        Assert.assertEquals(text, "Company updated successfully,Refreshing List");
        alert.accept();
    }

    public void verifyingcompanydeletesuccessmessage(){
        new WebDriverWait(wdriver,Duration.ofSeconds(60)).until(ExpectedConditions.alertIsPresent());
        Alert alert = wdriver.switchTo().alert();
        //Store the alert text in a variable and verify it
        String text = alert.getText();
        Assert.assertEquals(text, "Company successfully deleted,Refreshing List");
        alert.accept();
    }

    public void searchingForCompanyName(){

        driverHelper.waitForVisible(searchcompanyName);

        searchcompanyName.sendKeys(companyDataDetails.getName());
    }

    public void verifyingcompanynameFromTheccompanyList(){

           new Actions(wdriver, Duration.ofSeconds(20)).pause(Duration.ofSeconds(2)).perform();
           Assert.assertEquals(companyInTheTable.getText(),companyDataDetails.getName());
    }

    public void clickOnEditButton(){
        editButton.click();
    }

    public void verifyingCompanyDetailsPage(){
        driverHelper.waitForPageLoad();
        driverHelper.waitForVisible(companyHeaderInTheDetailsPage);
        Assert.assertEquals(companyNameTextField.getAttribute("value"), companyDataDetails.getName());
    }

    public void verifyCreatedCompanydetails(){
        Assert.assertEquals(companyNameTextField.getAttribute("value"), companyDataDetails.getName());
        Assert.assertEquals(urlTextField.getAttribute("value"), companyDataDetails.getUrl());
        Assert.assertEquals(phonenumberTextField.getAttribute("value"), companyDataDetails.getPhone());
        Assert.assertEquals(faxTextField.getAttribute("value"), companyDataDetails.getFax());
        Assert.assertEquals(addressLine1TextField.getAttribute("value"), companyDataDetails.getAddress1());
        Assert.assertEquals(addressLine2TextField.getAttribute("value"), companyDataDetails.getAddress2());
        Assert.assertEquals(cityTextField.getAttribute("value"), companyDataDetails.getCity());
        Assert.assertEquals(stateTextField.getAttribute("value"), companyDataDetails.getState());
        Assert.assertEquals(postalCodeTextField.getAttribute("value"), companyDataDetails.getPostalCode());
        Assert.assertEquals(descriptionTextField.getAttribute("value"), companyDataDetails.getDescription());
        //Assert.assertEquals(tracratAnnouncementsTextField.getAttribute("value"), companyDataDetails.getTracratAnnouncements());
        Assert.assertEquals(companyAnnouncementsTextField.getAttribute("value"), companyDataDetails.getCompanyAnnouncements());

    }


    public void changeCompanyData() throws Exception {
        //String companyData = RandomStringUtils.randomAlphabetic(5);

        Faker faker = new Faker();
        companyDataDetails.setName("au_" + RandomStringUtils.randomNumeric(3) + faker.company().name());
        companyDataDetails.setUrl(faker.company().url());
        companyDataDetails.setPhone(faker.phoneNumber().subscriberNumber());
        companyDataDetails.setFax(faker.phoneNumber().phoneNumber());
        companyDataDetails.setAddress1(faker.address().streetAddress());
        companyDataDetails.setAddress2(faker.address().secondaryAddress());
        companyDataDetails.setCity(faker.address().cityName());
        companyDataDetails.setState(faker.address().state());
        companyDataDetails.setPostalCode(faker.address().postcode());
        companyDataDetails.setDescription(faker.company().catchPhrase());
        companyDataDetails.setTracratAnnouncements(RandomStringUtils.randomAlphanumeric(50));
        companyDataDetails.setCompanyAnnouncements(RandomStringUtils.randomAlphanumeric(30));

        companyNameTextField.clear();
        companyNameTextField.sendKeys(companyDataDetails.getName());
        System.out.println(companyDataDetails.getName());

        urlTextField.clear();
        urlTextField.sendKeys(companyDataDetails.getUrl());

        phonenumberTextField.clear();
        phonenumberTextField.sendKeys(companyDataDetails.getPhone());

        faxTextField.clear();
        faxTextField.sendKeys(companyDataDetails.getFax());

        addressLine1TextField.clear();
        addressLine1TextField.sendKeys(companyDataDetails.getAddress1());

        addressLine2TextField.clear();
        addressLine2TextField.sendKeys(companyDataDetails.getAddress2());

        cityTextField.clear();
        cityTextField.sendKeys(companyDataDetails.getCity());

        stateTextField.clear();
        stateTextField.sendKeys(companyDataDetails.getState());

        postalCodeTextField.clear();
        postalCodeTextField.sendKeys(companyDataDetails.getPostalCode());

        descriptionTextField.clear();
        descriptionTextField.sendKeys(companyDataDetails.getDescription());

        String imageFile = Paths.get("images/Apple_logo_PNG7.png").toAbsolutePath().toString();
        logoFileUploadField.sendKeys(imageFile);

        tracratAnnouncementsTextField.clear();
        tracratAnnouncementsTextField.sendKeys(companyDataDetails.getTracratAnnouncements());

        companyAnnouncementsTextField.clear();
        companyAnnouncementsTextField.sendKeys(companyDataDetails.getCompanyAnnouncements());
        Thread.sleep(3000);
    }

    public void clickOnUpdateButton(){
        updatebutton.click();
    }

    public void clickOnDeleteButton(){
        deleteButton.click();
    }

    public void waitForDeletePopup(){
            driverHelper.waitForVisible(deleteConfirmationPopup);
    }

    public void clickYesInPopup(){
            yesButtonInPopup.clear();
    }

}
