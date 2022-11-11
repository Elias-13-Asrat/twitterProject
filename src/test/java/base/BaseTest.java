package base;

import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DriverManager;

public class BaseTest {
	

	/*
	 *  BaseTest class is Super class for all Test Cases
	 *  
	 *  In this class the following is done:
	 *  
	 *   --> Declaring driver;
	 *   ---> Initializing the driver and opening the browser
	 *   ---> Setting up the Logger
	 *   ---> Adding the Extent Report
	 *   --->
	 *   
	 *  
	 *  
	 *  
	 */
	
	
	private static WebDriver driver;

	
	// set up the logger
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	
	// Adding the Extent Report classes
	
		public static ExtentSparkReporter sparkReporter;
		public static ExtentReports extent;
		public static ExtentTest test;
		public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
		
		public static String getCurrentDateTime() {
			Date myDate = new Date();
			
			String fileName = myDate.toString().replace(":", "_").replace(" ", "_");
			
			//Extract the Day
			String day = fileName.substring(0, 10);
			
			//Extract the Time
			String time = fileName.substring(11, 19);
			
			//Extract the Hour, Minutes, and Seconds --> I want to provide the time in a 12-hour format
			String [] x = time.split("_");
			
			String AMPM = "";
			
			//capture the hour
			int hour = Integer.valueOf(x[0]); //converting from string to int
			if(hour >= 12) {
				AMPM="PM";
				if(hour !=12) {
					hour = hour-12;
				}
			}else {
				AMPM="AM";
			}
			
			if(hour == 0) {
				hour = 12;
			}
			
			String finalDateTime = day + " @ " + hour + "_" + x[1] + " " + AMPM;
			return finalDateTime;
		}

		
		
		
		
		
		
		@BeforeSuite	
		public void setUp() {
		// Configure Extent Reports
		sparkReporter = new ExtentSparkReporter("./ExtentReports/" + getCurrentDateTime() + ".html");
		sparkReporter.config().setEncoding("utf-8"); // required for HTML reports
		sparkReporter.config().setDocumentTitle("Bootcamp Spring 2022 - Test Automation Report"); // Sets the title of the Report
		sparkReporter.config().setReportName("Elias Zerihune - Twitter POM w/Page Factory Test Report");																									
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
					
		// Instantiate the ExtentReport Class
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter); 

		
		// Adding more details to the Report
		extent.setSystemInfo("Organization", "PCS");
		extent.setSystemInfo("Scrum Team", "Eagles");
		extent.setSystemInfo("OS", "Window OS");
		extent.setSystemInfo("Build #", "PCS-8.81.49");
		extent.setSystemInfo("Name","Elias");	
		
		}
		
		
		@AfterSuite
		public void tearDown() {
			extent.flush();
			//browserQuit();
		}
		
		
		
		public static void logInfo(String message) {
			testReport.get().log(Status.INFO, message);
		}
		
	
		// method that quit the driver
		public static void browserQuit() {
			DriverManager.getDriver().quit();
		}
	
	// open browser method
	public static void openBrowser(String browserName) {
		

		if(browserName.contains("chrome")) {
			
			//Initialize the WebDriverManager
			
			WebDriverManager.chromedriver().setup();
			
			//launch the chromedriver
			
			 driver = new ChromeDriver();
			
			 DriverManager.setDriver(driver); //taking the non - safe driver and setting it to be safe driver
			
			//set up implicit wait
			 
			 DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//maximize the window
			
			 DriverManager.getDriver().manage().window().maximize();
			
		}else if(browserName.contains("fireFox")) {
			
			//Initialize the WebDriverManager
			
			WebDriverManager.firefoxdriver().setup();
			
			//launch the fireFoxdriver
			
			 driver = new FirefoxDriver();
			 
			 DriverManager.setDriver(driver); //setting the non-safe driver to be thred-safe
			
			//set up implicit wait
			 DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//maximize the window
			 DriverManager.getDriver().manage().window().maximize();

	}
	
		
		
		
	}
	
	
	
	
}
