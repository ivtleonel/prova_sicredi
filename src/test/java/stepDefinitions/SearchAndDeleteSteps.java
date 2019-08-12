package stepDefinitions;

import static org.junit.Assert.assertTrue;

import core.DriverFactory;
import core.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.FormPage;
import pageObjects.HomePage;

public class SearchAndDeleteSteps extends TestBase{
	
	
	private HomePage homePage;
	private FormPage formPage;
	
	@Before
	public void setUp(){ 
		homePage = new HomePage();
		formPage = new FormPage(); 
						
	}
	
	
	@Given("^I am in the form and saved a data$")
	public void i_am_in_the_form_and_saved_a_data() throws Throwable {
		    
	}

	@When("^I Click on link Go back to list$")
	public void i_Click_on_link_Go_back_to_list() throws Throwable {
	    formPage.clickOnGoBackToList();
	    
	}

	@When("^I click in the icon and Search the Name \"([^\"]*)\"$")
	public void i_click_in_the_icon_and_Search_the_Name(String arg1) throws Throwable {
	   homePage.clickInSearchButton();
	   homePage.search(arg1);	    
	}

	@When("^I click on checkbox Actions$")
	public void i_click_o_checkbox_Actions() throws Throwable {
	
		homePage.checkboxClick();
	}


	@When("^I click on delete button$")
	public void i_click_on_delete_button() throws Throwable {
	    homePage.clickRemove();
	    
	}

	@When("^i click on delete popup$")
	public void i_click_on_delete_popup() throws Throwable {
	    assertTrue("Click in delete button fail!", formPage.isDisplayedDeleteConfirmMessage());	 
	    homePage.confirDelete();
	    
	}

	@Then("^I verify the message confirmation delete$")
	public void i_verify_the_message_confirmation_delete() throws Throwable {
		assertTrue("Delete was fail!", homePage.hasSuccessfullyDeleteItens());	 
	    
	}

	

	@After("@SearchDelete")
	public void tearDown() {		
		DriverFactory.killDriver();
	}
	


}
