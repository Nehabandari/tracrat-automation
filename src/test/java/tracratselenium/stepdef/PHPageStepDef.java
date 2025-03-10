package tracratselenium.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import tracratselenium.aruna.helpers.DriverHelper;
import tracratselenium.newpages.PrctcHomePage;

public class PHPageStepDef {

    PrctcHomePage php;

    public PHPageStepDef(Hooks hooks){

        php = new PrctcHomePage(hooks.getDriver());
    }


    //PHomePage php = new PHomePage();
    @Given("the user name is {string} and the password is {string}")
    public void give_user_name_and_the_password_(String username, String password){
    php.enterUserDetails(username,password);
    }

    @When("I click the login button")
    public void click_login_button(){

    }
}
