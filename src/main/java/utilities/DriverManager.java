package utilities;

import org.openqa.selenium.WebDriver;

public class DriverManager {


	// In this class i am creating a Thread Safe Driver object and all classes will use this method to access the driver
	
	//Create a Thread safe driver object ----> creating  a static Thread safe webdriver object
	
	public static ThreadLocal <WebDriver> dr = new ThreadLocal <WebDriver>();
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	public static void setDriver(WebDriver driver) {
		
		// assigning the thread safe driver instance(dr) to the webdriver instance that is initialized in the test
		
		dr.set(driver);	
	}
	
	
	
}
