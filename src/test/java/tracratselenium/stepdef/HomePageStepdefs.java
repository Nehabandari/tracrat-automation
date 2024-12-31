package tracratselenium.stepdef;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import tracratselenium.pages.HomePage;

public class HomePageStepdefs {
	
	private HomePage homePage;
	WebDriver driver;
	
	public HomePageStepdefs(HomePage homePage) {
		
		this.homePage=homePage;
	}
	
	
	 @Then("the login should be successful")
	public void the_login_should_be_successful() {
		homePage.waitforcurrentroleHeader();
			
	}
	 @Then("I select the dropdown {string}")
	  public void WhenTheUserSelects(String companyName){
		 homePage.selectCompany(companyName);
    }
	    
  
	@Then("verify the selected company should be loaded")
	    public void verify_the_selected_company_should_be_loaded() {
				 
	    }

	
}
