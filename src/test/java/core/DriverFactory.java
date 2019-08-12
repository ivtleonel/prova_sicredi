package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();		
		}
		return driver;
	}
	
	public static void killDriver() {
		
		if(driver != null) {
			driver.close();
			driver = null;			
		}
	}

	public static void close() {
		driver.close();
	}
}
