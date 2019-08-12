package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
		
	public static WebDriverWait wait;
	public static WebDriver driver;
	
	public PageBase() {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(DriverFactory.getDriver(), this);	
		wait = new WebDriverWait(DriverFactory.getDriver(), 10);		
	}
	
	
	

}
