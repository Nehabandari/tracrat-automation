package TestAutomation.pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath="//input[@name='username']")
    WebElement userNameTextField;

    @FindBy(xpath="//input[@name='password']")
    WebElement passwordTextField;

    @FindBy(xpath="")
    WebElement LoginButton;

    WebDriver driver;

    public HomePage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        //driver = webdriver.
    }

    public void enterUserDetails(String userName, String password){
        userNameTextField.sendKeys(userName);
        passwordTextField.sendKeys(password);
    }

}
