package tracratselenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tracratselenium.helpers.DriverHelper;
import tracratselenium.stepdef.browserStepdefs;

public class LoginPage {
	public DriverHelper driverHelper;

	@FindBy(name = "username")
	private WebElement usernameTestField;

	@FindBy(name = "password")
	private WebElement PasswordTestField;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginbutton;

	public LoginPage(browserStepdefs browserStepdefs) {

		PageFactory.initElements(browserStepdefs.getDriver(), this);

	}

	public void enterusernameAndPassword(String username, String password) {
		usernameTestField.sendKeys(username);
		PasswordTestField.sendKeys(password);

	}

	public void click_on_loginbutton() {
		loginbutton.click();

	}

}
