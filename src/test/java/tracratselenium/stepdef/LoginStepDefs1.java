package tracratselenium.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tracratselenium.helpers.DriverHelper;
import tracratselenium.page.HomePage;
import tracratselenium.page.LoginPage;

public class LoginStepDefs1 {

    LoginPage loginPage;

    HomePage homePage;

    public LoginStepDefs1(DriverHelper driverHelper, LoginPage lp, HomePage hp){

       loginPage = lp;
       homePage = hp;
    }

    @Given("the user name is {string} and the password is {string}")
    public void Given_the_user_details(String username, String password){
       loginPage.enterDetails(username, password);

    }
    @When("I click the login button")
    public void click_the_login_button(){
        loginPage.clickLoginButton();
    }

    @Then("the login should be successful")
    public void the_login_should_be_successful(){

        homePage.checkhomelinkisdisplayed();

    }


}