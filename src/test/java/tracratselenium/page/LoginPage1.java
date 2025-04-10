package tracratselenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tracratselenium.helpers.DriverHelper;

public class LoginPage1 {
    @FindBy(name = "username")
    WebElement userNameTextField;

    @FindBy(name = "password")
    WebElement passwordTextField;

    @FindBy(xpath = "//form[@name='myForm']/div[4]/div[1]/button")
    WebElement loginbutton;

    public LoginPage1(DriverHelper driverHelper){

        PageFactory.initElements(driverHelper.getDriver(), this);
    }
    public void enterDetails(String username, String password){
        userNameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton(){

        loginbutton.click();
    }
}

