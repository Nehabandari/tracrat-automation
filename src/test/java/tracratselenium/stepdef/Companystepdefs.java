package tracratselenium.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tracratselenium.helpers.DriverHelper;
import tracratselenium.page.CompanyPage;

public class Companystepdefs {

    CompanyPage companyPage;
    public Companystepdefs(DriverHelper driverHelper, CompanyPage cp) {

        companyPage = cp;
    }

    @Then("verify Manage Company page should be open")
    public void verify_Manage_Company_page_should_be_open(){
        companyPage.waitforddcompanybutton();
        companyPage.verifymanagecompanytext();

    }

    @When("i click on add company")
    public void click_on_add_company(){
        companyPage.clickOnAddCompanyButton();

    }

    @Then("add company page should be loaded")
    public void add_company_page_should_be_loaded(){

        companyPage.verifyAddCompanyPage();
    }

    @Given("the required details in company page")
    public void enter_required_details_in_company_page()throws Exception{
        companyPage.enterCompanyData();

    }

    @When("i click on save button in company page")
    public void click_on_save_button_in_company_page(){
        companyPage.clickonSaveButton();

    }

    @Then("company should be saved")
    public void company_should_be_saved(){
        companyPage.verifyingcompanysuccessmessage();

    }

       @Then("verify that selected company should be loaded")
    public void verify_that_selected_company_should_be_loaded(){

    }

    @When("search for the company name")
    public void search_for_the_company_name(){
        companyPage.searchingForCompanyName();

    }

    @Then("company name should be display in the companies list")
    public void company_name_should_be_display_in_the_companies_list(){
        companyPage.verifyingcompanynameFromTheccompanyList();

    }

    @When("i click on Edit button")
    public void click_on_Edit_button(){
        companyPage.clickOnEditButton();
    }

    @Then("company details page should be loaded")
    public void company_details_page_should_be_loaded(){
        companyPage.verifyingCompanyDetailsPage();
    }

    @Then("verify the company details saved")
    public void verify_the_company_detail_saved(){
        companyPage.verifyCreatedCompanydetails();
    }
}
