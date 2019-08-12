package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;

import core.DriverFactory;
import core.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.FormPage;
import pageObjects.HomePage;

public class UpdateFormSteps extends TestBase{
	
	private HomePage homePage;
	private FormPage formPage;
	
	@Before 
	public void setUp(){ 
		
		
						
	}
	
	
	@Given("^I access home page$")
	public void i_access_form() throws Throwable {
		homePage = new HomePage();
		homePage.accessPageHome();
	    
	}

	@When("^I click in select and change the version$")
	public void i_click_in_select_and_change_the_version() throws Throwable {
		homePage.selectV4Theme();	    
	}

	@When("^I click in Add Customer$")
	public void i_click_in_Add_Customer() throws Throwable {
	   homePage.openForm();
	   formPage = new FormPage();
	    
	}

	@When("^I fill out the fields with values$")
	public void i_fill_out_the_fields_with_values(DataTable values) throws Throwable {
	   List<String> list = values.asList(String.class);
	   formPage.fillOutName(list.get(0));
	   formPage.fillOutLastName(list.get(1));
	   formPage.fillOutFirstName(list.get(2));
	   formPage.fillOutPhone(list.get(3));
	   formPage.fillOutAddressLine1Field(list.get(4));
	   formPage.fillOutAddressLine2Field(list.get(5));
	   formPage.fillOutCity(list.get(6));
	   formPage.fillOutState(list.get(7));
	   formPage.fillOutPostalCode(list.get(8));
	   formPage.fillOutCountry(list.get(9));
	   formPage.fillOutEmployer(list.get(10));
	   formPage.fillOutCrediLimit(list.get(11));
	   
	}
	
	@When("^I click in save$")
	public void i_click_in_save() throws Throwable {
	    formPage.buttonSave();	    
	}

	@Then("^I verify the message confirmation$")
	public void i_verify_the_message_confirmation() throws Throwable {
	    assertTrue("Your data has not saved! It is Failed!", formPage.hasSuccessfullyStoredData());	    
	}
	
	@After("@Create")
	public void tearDown() {		
		DriverFactory.killDriver();	
	}

}
