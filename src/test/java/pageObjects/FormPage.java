package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.PageBase;


public class FormPage extends PageBase{
	
	
	public FormPage() {
		
	}

	@FindBy(how = How.ID, using = "field-customerName") 
	private WebElement nameField;
	
	@FindBy(how = How.ID, using = "field-contactLastName") 
	private WebElement lastNameField;
	
	@FindBy(how = How.ID, using = "field-contactFirstName") 
	private WebElement firstNameField;
	
	@FindBy(how = How.ID, using = "field-phone") 
	private WebElement phoneField;
	
	@FindBy(how = How.ID, using = "field-addressLine1") 
	private WebElement addressLine1Field;
	
	@FindBy(how = How.ID, using = "field-addressLine2") 
	private WebElement addressLine2Field;
	
	@FindBy(how = How.ID, using = "field-city") 
	private WebElement cityField;
	
	@FindBy(how = How.ID, using = "field-state") 
	private WebElement stateField;
	
	@FindBy(how = How.ID, using = "field-postalCode") 
	private WebElement postalCodeField;
	
	@FindBy(how = How.ID, using = "field-country") 
	private WebElement countryField;
	
	@FindBy(how = How.NAME, using = "salesRepEmployeeNumber") 
	private WebElement employerField;
	
	@FindBy(how = How.ID, using = "field_salesRepEmployeeNumber_chosen") 
	private WebElement employeChosenrField;
	
	@FindBy(how = How.ID, using = "field-creditLimit") 
	private WebElement creditLimitField;
	
	@FindBy(how = How.ID, using = "form-button-save") 
	private WebElement saveButton;
	
	@FindBy(how = How.CSS, using = "a[href="
			+ "\"/demo/bootstrap_theme_v4/\"]")
	private WebElement goBackToList;
	

	@FindBy(how = How.CLASS_NAME, using = "success") 
	private WebElement reportMessage;
	
	
	public void fillOutName(String name) {
		nameField.sendKeys(name);
	}
	
	public void fillOutLastName(String name) {
		lastNameField.sendKeys(name);
	}
	
	public void fillOutFirstName(String name) {
		firstNameField.sendKeys(name);
	}
	
	public void fillOutPhone(String number) {
		phoneField.sendKeys(number);
	}
	
	public void fillOutAddressLine1Field(String address) {
		addressLine1Field.sendKeys(address);
	}
	
	public void fillOutAddressLine2Field(String address) {
		addressLine2Field.sendKeys(address);
	}
	
	public void fillOutCity(String city) {
		cityField.sendKeys(city);
	}
	
	public void fillOutState(String state) {
		stateField.sendKeys(state);
	}
	
	public void fillOutPostalCode(String code) {
		postalCodeField.sendKeys(code);
	}
	
	public void fillOutCountry(String country) {
		countryField.sendKeys(country);
	}
	
	public void fillOutEmployer(String employer) {
		employeChosenrField.click();
		List<WebElement> optionsList = driver.findElements(By.cssSelector("ul>li.active-result"));
		
		for (WebElement option : optionsList) {
			
			if (option.getText().equals(employer)){
				option.click();
				break;
			}
		}	
	}
	
	
	
	public void fillOutCrediLimit(String limit) {
		creditLimitField.sendKeys(limit);
	}
	
	
	public void buttonSave(){
		saveButton.click();
		
	}
	
	public boolean hasSuccessfullyStoredData() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href=\"/demo/bootstrap_theme_v4/\"]")));
		return reportMessage.getText().contains("Your data has been successfully stored into the database.");
	}
	
	public void clickOnGoBackToList() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href=\"/demo/bootstrap_theme_v4/\"]")));
		goBackToList.click();
	}
	 public boolean isDisplayedDeleteConfirmMessage() {
		 List<WebElement> elements = driver.findElements(By.cssSelector(".warning.table-warning")); 
		 int numberOfElements = elements.size();
		 String message;
		 String className;
		 
		 if (numberOfElements == 1) {
			 message = "Are you sure that you want to delete this 1 item?"; 
			 className = ".alert-delete-multiple-one";
		 }else {
			 message = "Are you sure that you want to delete those " + Integer.toString(numberOfElements) + " items?"; 
			 className = ".alert-delete-multiple";
		 }
		   	 
		 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(className)));
		 System.out.print(element.getText());
		 System.out.print(message);
		 return element.getText().equals(message); 
	 }
}
