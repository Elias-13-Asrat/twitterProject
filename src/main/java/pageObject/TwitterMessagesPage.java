package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.TwitterMessagesPageOR;

public class TwitterMessagesPage extends BasePage{
	
	
	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with "TwitterMessagesPageOR", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have WriteNewMessage() method and it returns "NewMessagePage"
	 */

	@FindBy(xpath = TwitterMessagesPageOR.NewMessageLink)
	WebElement NewMessageLink;
	
	
	// method to return located webelement
	
	public WebElement getNewMessageLink() {
		return NewMessageLink;
	}
	
	public NewMessagePage WriteNewMessage() {
		NewMessageLink.click();
		
		return (NewMessagePage)openPage(NewMessagePage.class);
	}
	
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
	
		return ExpectedConditions.visibilityOf(NewMessageLink);
	}

}
