package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.TwitterNotificationPageOR;

public class TwitterNotificationPage extends BasePage {

	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with " TwitterNotificationPageOR ", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have different methods to go to Twitter Notification menu options, these methods are:
	 * 
	 *   goToAllOption() ----> gives access to Twitter Notification Menu Option "All"
	 *   
	 *   goToMentionsOption() ----> gives access to Twitter Notification Menu Option "Mentions"
	 *
	 */
	
	
	@FindBy(xpath = TwitterNotificationPageOR.NotificationPageHeader)
	WebElement NotificationPageHeader;
	
	@FindBy(xpath = TwitterNotificationPageOR.NotificationAllMenuLink)
	WebElement NotificationAllMenuLink;
	
	@FindBy(xpath = TwitterNotificationPageOR.NotificationMentionsMenuLink)
	WebElement NotificationMentionsMenuLink;
	
	
	//method to return located Element
	
	public WebElement getNotificationPageHeader() {
		return NotificationPageHeader;
	}
	
	public WebElement getNoticationAllMenuLink() {
		return NotificationAllMenuLink;
	}
	
	public WebElement getNotificationMentionsMenuLink() {
		return NotificationMentionsMenuLink;
	}
	
	
	// method to go to different Notification menu
	
	public void goToAllOption() {
		NotificationAllMenuLink.click();
	}
	
	public void goToMentionsOption() {
		NotificationMentionsMenuLink.click();
	}
	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(NotificationPageHeader);
	}
	
	

}
