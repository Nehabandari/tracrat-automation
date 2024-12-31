package tracratselenium.stepdef;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tracratselenium.pages.CompanyPage;

public class CompanyStepdefs {
	
	private CompanyPage CompanyPage;
	
	public CompanyStepdefs(CompanyPage CompanyPage) {
	this .CompanyPage=CompanyPage;
	}
	
	 @Then("I click Manage Company")
	 public void I_click_Manage_Company() {
		// CompanyPage.click_ManageCompany();
	 }
	 @Then("verify Manage Company page should be open")
	 public void verify_Manage_Company_page_should_be_open() {
		 //CompanyPage.waitforManageCompanyHeader();
	 }   
	
}
