package tracratselenium.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import tracratselenium.pages.LoginPage;

public class LoginStepDefs {
    LoginPage loginpage;

    public LoginStepDefs(LoginPage loginpage) {
        this.loginpage = loginpage;
    }

    @Given("the user name is {string} and the password is {string}")
    public void login(String username, String password) {
        loginpage.enterUsernameAndPassword(username, password);

    }

    @When("I click the login button")
    public void click_on_login_button() {
        loginpage.clickOnLoginButton();

    }
}
