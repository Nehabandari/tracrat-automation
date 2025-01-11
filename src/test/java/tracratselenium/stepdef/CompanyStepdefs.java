package tracratselenium.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import tracratselenium.pages.CompanyPage;
import tracratselenium.pojo.CompanyDetails;

public class CompanyStepDefs {

    private final CompanyPage companyPage;

    public CompanyStepDefs(CompanyPage companyPage) {
        this.companyPage = companyPage;
    }

    @Then("i click on manage company")
    public void I_click_Manage_Company() {
    	companyPage.clickManageCompany();
    }

    @Then("verify Manage Company page should be open")
    public void verify_Manage_Company_page_should_be_open() {
        companyPage.waitForManageCompanyHeader();
    }

    @When("i click on add company")
    public void clickOnAddCompany() {
        companyPage.clickAddCompanyButton();
    }

    @Then("add company page should be loaded")
    public void verifyAddCompanyPageLoaded() {
        companyPage.isAddCompanyPageDisplayed();
    }

    @Given("the required details in company page")
    public void enterCompanyDetails() {
        // Assuming you have test data, you could also pass this as a DataTable in feature file
        CompanyDetails details = new CompanyDetails();
        Faker faker = new Faker();
        details.setName("AU_"+faker.company().name());
        details.setAddress(faker.address().streetAddress());
        details.setPhone(faker.phoneNumber().phoneNumberInternational());
        details.setCity(faker.address().city());
        details.setState(faker.address().state());
        // ... set other  fields
        companyPage.fillAddCompanyDetails(details);
    }

    @When("i click on save button in company page")
    public void clickSaveButton() {
        companyPage.clickSaveButton();
    }

    @Then("company should be saved")
    public void verifyCompanySaved() {
        companyPage.isSuccessMessageDisplayed();
    }

}
