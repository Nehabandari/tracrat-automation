package tracratselenium.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tracratselenium.helpers.DriverHelper;
import tracratselenium.page.HomePage;
import tracratselenium.page.LocationPage;
import tracratselenium.pojo.CompanyDataDetails;

import javax.xml.stream.Location;
public class LocationstepDefs {
    LocationPage locationPage;
    public LocationstepDefs(DriverHelper driverHelper, LocationPage lp) {

        locationPage = lp;
    }

    @Then("verify Manage Location page should be open")
    public void verify_Manage_Location_page_should_be_open(){
        locationPage.waitformanagelocationbutton();
        locationPage.verifymanagelocationtext();

    }

    @When("i click on add location")
    public void click_on_add_location(){
        locationPage.clickOnAddLocationButton();

    }

    @Then("add location page should be loaded")
    public void add_location_page_should_be_loaded(){
        locationPage.verifyAddLocationPage();
    }

    @Given("the required details in location page")
    public void enter_required_details_in_location_page()throws Exception{
        locationPage.enterLocationData();

    }

    @When("i click on save button in location page")
    public void click_on_save_button_in_company_page(){
        locationPage.clickonSaveButton();

    }

    @Then("location should be saved")
    public void location_should_be_saved(){
        locationPage.verifyinglocationsuccessmessage();

    }

    @Then("verify that selected location should be loaded")
    public void verify_that_selected_location_should_be_loaded(){
        locationPage.verifyselectedlocationisloaded();

    }

    @When("search for the location name")
    public void search_for_the_company_name(){
        locationPage.searchingForLocationName();

    }

    @Then("location name should be display in the locations list")
    public void location_name_should_be_display_in_the_locations_list(){
        locationPage.verifyingcompanynameFromThelocationsList();

    }

    @When("i click on Edit button")
    public void click_on_Edit_button(){
        locationPage.clickOnEditButton();
    }

    @Then("location details page should be loaded")
    public void location_details_page_should_be_loaded(){

        locationPage.verifyingLocationDetailsPage();
    }

    @Then("verify the location details saved")
    public void verify_the_location_detail_saved(){
        locationPage.verifyCreatedLocationdetails();
    }

    @Given("i change the location details")
    public void change_the_location_details()throws Exception{
        locationPage.changeLocationData();

    }
}
