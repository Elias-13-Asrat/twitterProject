package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.TwitterSignInPageOR;

public class TwitterSignInPage extends BasePage{


	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with "TwitterSignInPageOR", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have goUserName(String username) method, it takes String value and returns "TwitterPasswordPage"
	 */
	
	
	@FindBy(xpath = TwitterSignInPageOR.usernameField)
	WebElement usernameField;
	
	@FindBy(xpath = TwitterSignInPageOR.nextButton)
	WebElement nextButton;
	
	@FindBy(xpath = TwitterSignInPageOR.SignInPageHeaderTitle)
	WebElement SignInPageHeaderTitle;
	
	//create a method to return the elements
	
	public WebElement getUserNameField() {
		return usernameField;
	}
	
	public WebElement getNextButton() {
		return nextButton;
	}
	
	
	
	// method to enter username and click next button
	
	public TwitterPasswordPage goUserName(String username) {

		getUserNameField().sendKeys(username);
		getNextButton().click();
		
		return (TwitterPasswordPage)openPage(TwitterPasswordPage.class);
		
	}

	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(SignInPageHeaderTitle);
	}
	
	
}
