package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.FormPage;
import pageObjects.HomePage;

public class UpdateFormSteps {
	
	private HomePage homePage;
	private FormPage formPage;
	private WebDriver driver;
	
	@Before 
	public void setUp(){ 
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
						
	}
	
	
	@Given("^I access home page$")
	public void i_access_form() throws Throwable {
		homePage = new HomePage(driver);
		homePage.accessPageHome();
	    
	}

	@When("^I click in select and change the version$")
	public void i_click_in_select_and_change_the_version() throws Throwable {
		homePage.selectV4Theme();	    
	}

	@When("^I click in Add Customer$")
	public void i_click_in_Add_Customer() throws Throwable {
	   homePage.openForm();
	   formPage = new FormPage(driver);
	    
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
	
	@After()
	public void tearDown() {		
		driver.close();
	}

}
