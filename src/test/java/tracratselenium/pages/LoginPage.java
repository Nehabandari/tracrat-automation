package tracratselenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tracratselenium.helpers.DriverHelper;
import tracratselenium.stepdef.BrowserStepDefs;

public class LoginPage {
	private DriverHelper driverHelper;

	@FindBy(name = "username")
	private WebElement userNameTextField;

	@FindBy(name = "password")

	private WebElement passwordTextField;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginButton;

	public LoginPage(BrowserStepDefs browserStepdefs) {

		PageFactory.initElements(browserStepdefs.getDriver(), this);

	}

	public void enterUsernameAndPassword(String username, String password) {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);

	}

	public void clickOnLoginButton() {
		loginButton.click();

	}

}
