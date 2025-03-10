package tracratselenium.aruna.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tracratselenium.aruna.helpers.DriverHelper;
import tracratselenium.aruna.page.CompanyPage;
import tracratselenium.aruna.page.HomePage;

public class HomePageStepDefs {

    HomePage homepage ;
    CompanyPage companypage;

    public HomePageStepDefs(DriverHelper driverHelper, HomePage hp, CompanyPage cp) {

        homepage = hp;
        companypage = cp;

    }


    @When("i select the company {string} from navigation bar")
    public void select_the_company (String companyname) throws Exception{
        homepage.selectingCompany(companyname);
    }

    @Then("verify the selected company should be loaded")
    public void verify_the_selected_company(){
        homepage.verifyselectedcompanyloaded();

    }


    @And("i click on manage company")
    public void click_on_manage_company(){
        homepage.clickManagecompanieslinkabc();

    }

    @When("i select the created company from navigation bar")
    public void select_the_created_company_from_navigation_bar()throws Exception{

        homepage.selectingCompany(companypage.getCompanyName());
    }

}