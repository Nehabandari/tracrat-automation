package tracratselenium.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tracratselenium.helpers.DriverHelper;
import tracratselenium.page.HomePage;
import tracratselenium.pojo.CompanyDataDetails;
import tracratselenium.pojo.LocationDataDetails;

public class HomePageStepDefs1 {
    private HomePage homepage ;
    private CompanyDataDetails companyDataDetails;
    private LocationDataDetails locationDataDetails;

    public HomePageStepDefs(DriverHelper driverHelper, HomePage hp, CompanyDataDetails companyDataDetails, LocationDataDetails locationDataDeatails) {

        homepage = hp;
        this.companyDataDetails = companyDataDetails;
        this.locationDataDetails = locationDataDetails;

    }


    @When("i select the company {string} from navigation bar")
    public void select_the_company (String companyname) throws Exception{
        homepage.selectingCompany(companyname);
    }

    @Then("verify the selected company should be loaded")
    public void verify_the_selected_company(){
        homepage.verifyselectedcompanyloaded();

    }

    @When("i click on company expand")
    public void i_click_on_company_expand(){
        homepage.clickOnCompanymenu();
    }


    @And("i click on manage location")
    public void click_on_manage_location(){
        homepage.clickManagelocationslinkabc();

    }

    @When("i select the created location from navigation bar")
    public void select_the_created_location_from_navigation_bar()throws Exception{

        homepage.selectingLocation(locationDataDetails.getName());
    }

}
}
