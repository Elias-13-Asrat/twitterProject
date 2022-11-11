package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.TwitterPasswordPageOR;

public class TwitterPasswordPage extends BasePage {
	

	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with "TwitterPasswordPageOR", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have goPassword(String password) , it takes a String value and returns 
	 * "TwitterUserAccountPage"
	 */
	
	
	@FindBy(xpath = TwitterPasswordPageOR.PasswordPageHeaderTitle)
	WebElement PasswordPageHeaderTitle;
	
	@FindBy(xpath = TwitterPasswordPageOR.passwordLink)
	WebElement passwordLink;
	
	@FindBy(xpath = TwitterPasswordPageOR.LoginLink)
	WebElement LoginLink;
	
	//method to return elements
	
	public WebElement getPasswordField() {
		return passwordLink;
	}
	
	public WebElement getLoginLink() {
		return LoginLink;
	}
	

	// method to enter password and click login button
	public TwitterUserAccountPage goPassword(String password) {
		passwordLink.sendKeys(password);
		getLoginLink().click();
		
		return (TwitterUserAccountPage)openPage(TwitterUserAccountPage.class);
	}

	@Override
	protected ExpectedCondition getPageLoadConditon() {
	
		return ExpectedConditions.visibilityOf(PasswordPageHeaderTitle);
	}

}
