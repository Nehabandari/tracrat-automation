package TestAutomation.Stepdefs;

import TestAutomation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefs {

    HomePage homePage;
    public LoginPageStepDefs(Hooks hooks) {

        homePage = new HomePage(hooks.getDriver());
    }

    @Given("the user name is {string} and the password is {string}")
    public void give_user_name_and_the_password_(String username, String password){
        //homePage.
        System.out.println("Print this");
    }

    @When("I click the login button")
    public void click_login_button(){
        System.out.println("Print this one too");

    }

}
