package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverManager;



public abstract class BasePage <T> {
	
	protected WebDriver driver;
	
	
	/*
	 * The BasePage is the supper class for all page classes and they will extend it
	 * 
	 * This class will be responsible for 2 things:
	 * 
	 * FIRST: Initialize the Page Factory Elements
	 * 
	 * SECOND : Define the Page Load Conditions
	 *    ---> Each time a new page loads, we need to first ensure that we are on the correct page
	 *         before continuing with the execution of the actions on that page
	 *    ---> To do this, we are going to implement explicitly wait to check various Expected Conditions 
	 *         for each individual pages	 
	 */
	
	public T openPage(Class <T> clazz) {
		
		T page = null;
		
		driver = DriverManager.getDriver();
		
		// Initializing the page factory element for the appropriate class then store it in page itself
		
		page = PageFactory.initElements(driver, clazz);
		
		ExpectedCondition<?> pageLoadCondition = ((BasePage<?>) page).getPageLoadConditon();
		
		
		/*
		 * The getPageLoadCondtion() method is going to be called by each page
		 * This is why we are saying 'page.getPageLoadCondition()'
		 * 
		 * The page pbject (variable) must belong to a specific type
		 * so we are type-casting it to the BasePage type (to the parent of all page type)
		 * 
		 * since the BasePage is a super type that can hold an object of any page type
		 *  ( ? wild card generic type) --- i am indicating  that while doing the type casting
		 * This is why i have the 'BasePage<?>'
		 */
		
		
		
		
		// this will implement the page load condition and wait until the condition is met
		
		waitForPageToLoad(pageLoadCondition); 
		
		
		
		return page; //Once the page load conditon is met, the page Object will be returned
	}
	
	/*
	 * Since the page load condition for each page can be different
	 * we will not define this method here
	 * 
	 * Undefined methods are abstract so this method must be abstract
	 * 
	 * If an abstract method is declared in a class, then the class
	 * must also be marked as abstract 
	 */
	
	
	
	// create method that returns expected condition
	
//	protected ExpectedCondition getPageLoadCondition() {
//	
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(element));
//		
//		
//	}
//	
	
	
	// this method will be defined or implemented in any class that extends this BasePage class
	// When it's extended, the page load condition must be defined
	
	protected abstract ExpectedCondition<?> getPageLoadConditon();
	
	
	//method that actually wait the page to load
	
	private void waitForPageToLoad(ExpectedCondition<?> pageLoadCondition) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(pageLoadCondition);
	}
	
	
	
	
	
	
	
	
}
