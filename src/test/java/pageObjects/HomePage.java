package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
	public WebDriverWait wait;
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);			
	}

	@FindBy(how = How.ID, using = "switch-version-select") 
	private WebElement selectVersion;
	
	@FindBy(how = How.CSS, using = "option[value=\"bootstrap_theme_v4\"]") 
	private WebElement v4Theme;
	
	@FindBy(how = How.CSS, using = "a[href=\"/demo/bootstrap_theme_v4/add\"]")
	private WebElement addCustomerButton;
	
	@FindBy(how = How.CLASS_NAME, using = "search-button")
	private WebElement searchButton;
	
	@FindBy(how = How.NAME, using = "search") 
	private WebElement searchField;
	
	
	@FindBy(how = How.CLASS_NAME, using = "select-all-none") 
	private WebElement checkbox;
	
	@FindBy(how = How.CLASS_NAME, using = "text-danger") 
	private WebElement removeButton;
	
	@FindBy(how = How.CLASS_NAME, using = "delete-multiple-confirmation-button") 
	private WebElement confirmButton;
	
	
	public void accessPageHome() {
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
	}
	
	public void selectV4Theme() {		
		selectVersion.click();
		v4Theme.click();
	}
	
	public String getSelectVersionText() {
		return selectVersion.getText();
	}
	
	public boolean isV4Selected() {
		return v4Theme.getAttribute("selected").equals("true");
	}
	
	public void openForm() {
		addCustomerButton.click();
	}
	
	public void clickInSearchButton() {
		searchButton.click();
	}
	
	public void search(String search) {
		searchField.sendKeys(search);
		searchField.sendKeys(Keys.ENTER);
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public void checkboxClick() {
		 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select-all-none")));
		 element.click(); 
	}
	public void clickRemove() {
		removeButton.click();
	}
	
	public void confirDelete() {
		confirmButton.click();
	}
	
	public boolean hasSuccessfullyDeleteItens() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-growl=\"container\"]")));
						
		return element.getText().contains("Your data has been successfully deleted from the database.");
	}
	
}







