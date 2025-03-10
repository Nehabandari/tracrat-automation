package tracratselenium.newpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
     private WebDriver webDriver;

    @FindBy(name = "username")
    private WebElement userNameTextField;

    @FindBy(name = "password")
    private WebElement passwordTextField;

    @FindBy(xpath = "//form[@name='myForm']/div[4]/div[1]/button")
    private WebElement loginButton1;

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void authentication(String username, String password){
        userNameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton1.click();
    }

    public void enterloginDetails(String username, String password){
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(userNameTextField));

        userNameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton1.click();
    }



    public void clickForPassword(){

    }

}



