package testautomation.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepdefs {

    @Then("the login should be successful")
    public void the_login_should_be_successful() {

    }

    @When("i select the company {string} from navigation bar")
    public void select_the_company_from_navigation_bar(String Companyname ){

    }

    @Then("verify the selected company should be loaded")
    public void verify_the_selected_company_should_be_loaded(){

    }
    @When("i select the location {string} from navigation bar")
    public void select_the_location_from_navigation_bar(String Locationname ){

    }
    @Then("verify the selected location should be loaded")
    public void verify_the_selected_location_should_be_loaded(){

    }
}
