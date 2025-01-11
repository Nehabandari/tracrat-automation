package tracratselenium.stepdef;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tracratselenium.helpers.Constants;
import tracratselenium.helpers.DriverHelper;
import tracratselenium.pages.CompanyPage;
import tracratselenium.pages.HomePage;

public class HomePageStepDefs {

    private HomePage homePage;
    private CompanyPage companyPage;
    private BrowserStepDefs browserStepdefs;
    private DriverHelper driverHelper;

    public HomePageStepDefs(HomePage homePage, CompanyPage companyPage, BrowserStepDefs browserStepdefs, DriverHelper driverHelper) {
        this.homePage = homePage;
        this.companyPage = companyPage;
        this.browserStepdefs = browserStepdefs;
        this.driverHelper = driverHelper;
    }

    @Then("the login should be successful")
    public void the_login_should_be_successful() {
        homePage.waitForCurrentRoleHeader();
    }

    @When("i select the company {string} from navigation bar")
    public void i_select_the_company_from_navigation_bar(String companyName) {
        homePage.selectCompany(companyName);
    }

    @Then("verify the selected company should be loaded")
    public void verify_the_selected_company_should_be_loaded() {
        homePage.verifySelectedCompany();
        Scenario scenario = browserStepdefs.getScenario();
        scenario.attach(driverHelper.takeScreenshotAndReturnBytes(), Constants.IMAGE_JPEG, scenario.getId());
    }

    @When("i select the created company from navigation bar")
    public void i_select_the_created_company_from_navigation_bar() {
        homePage.selectCompany(companyPage.getCompanyName());
    }
}
