package tracratselenium.newpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tracratselenium.aruna.helpers.DriverHelper;

import java.sql.Driver;

public class PrctcHomePage {

    @FindBy(xpath="//input[@name='username']")
    WebElement userNameTextField;

    @FindBy(xpath="//input[@name='password']")
    WebElement passwordTextField;

    @FindBy(xpath="")
    WebElement LoginButton;

    WebDriver driver;

    public PrctcHomePage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
         //driver = webdriver.getDriver();
    }

    public void enterUserDetails(String userName, String password){
        userNameTextField.sendKeys(userName);
        passwordTextField.sendKeys(password);
    }
}
