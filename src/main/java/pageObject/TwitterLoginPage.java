package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


import objectRepository.TwitterLoginPageOR;
import utilities.DriverManager;

public class TwitterLoginPage extends BasePage{


	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with "TwitterLoginPageOR", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have goToLogin() method and it's return type is "TwitterSignInPage"
	 */
	
	
	
	@FindBy(xpath =TwitterLoginPageOR.LoginpageHeaderTitle)
	WebElement LoginpageHeaderTitle;
	
	@FindBy(xpath = TwitterLoginPageOR.signInLink)
	WebElement signInLink;
	
	
	@FindBy(xpath = TwitterLoginPageOR.signUpLink)
	WebElement signUpLink;
	
	// create a method to return tge signInLink element
	public WebElement getSignInLink() {
		return signInLink;
	}
	
	// create a method to return the signUpLink
	public WebElement getSignUpLink() {
		return signUpLink;
	}
	
	// method to go to Login page(to click on sign in)
	
	public TwitterSignInPage goToLogin() {
		getSignInLink().click();
		
		return (TwitterSignInPage) openPage(TwitterSignInPage.class);
	}
	
	
	//
	public TwitterLoginPage open(String URL) {
		DriverManager.getDriver().navigate().to(URL);
		
		return (TwitterLoginPage) openPage(TwitterLoginPage.class);
	}
	
	
	
	

	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(LoginpageHeaderTitle);
	}
	
}
