package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.TwitterUserAccountPageOR;

public class TwitterUserAccountPage extends BasePage {
	

	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with "TwitterUserAccountPageOR", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have different methods to go to different Twitter Pages. These methods are:
	 * 
	 * 	 goToHomePage() method ---> returns "TwitterHomePage"
	 * 
	 *   goToExplorePage() method ----> returns "TwitterExplorePage"
	 *   
	 *   goToNotificationPage() method ---> returns  "TwitterNotificationPage"
	 *   
	 *   goToMessagePage()  method -------> returns "TwitterMessagesPage"
	 *   
	 *   goToProfilesPage() method -----> returns  "TwitterProfilePage"
	 *   
	 *   goToTweetPage() method ------> returns "TwitterTweetPage"
	 *
	 *
	 */
	
	
	
	
	@FindBy(xpath =TwitterUserAccountPageOR.HomeLink)
	WebElement HomeLink;
	
	@FindBy(xpath =TwitterUserAccountPageOR.ExploreLink)
	WebElement ExploreLink;
	
	@FindBy(xpath = TwitterUserAccountPageOR.NotificationLink)
	WebElement NotificationLink;
	
	@FindBy(xpath = TwitterUserAccountPageOR.MessagesLink)
	WebElement MessagesLink;
	
	@FindBy(xpath = TwitterUserAccountPageOR.ProfilesLink)
	WebElement ProfilesLink;
	
	@FindBy(xpath = TwitterUserAccountPageOR.TweetLink)
	WebElement TweetLink;
	
	
	// method to access located webElements
	
	 public WebElement getHomeLink() {
		 return HomeLink;
	 }
	
	public WebElement getExploreLink() {
		return ExploreLink;
	}
	
	public WebElement getNotificationLink() {
		return NotificationLink;
	}
	
	public WebElement getMessageLink() {
		return MessagesLink;
	}
	
	public WebElement getProfilesLink() {
		return ProfilesLink;
	}
	
	public WebElement getTweetLink() {
		return TweetLink;
	}
	
	// method to go to different menu
	
	public TwitterHomePage goToHomePage() {
		HomeLink.click();
		
		return (TwitterHomePage)openPage(TwitterHomePage.class);
	}
	
	
	public TwitterExplorePage goToExplorePage() {
		ExploreLink.click();
		
		return (TwitterExplorePage)openPage(TwitterExplorePage.class);
	}
	
	public TwitterNotificationPage goToNotificationPage() {
		NotificationLink.click();
		
		return (TwitterNotificationPage)openPage(TwitterNotificationPage.class);
	}
	
	public TwitterMessagesPage goToMessagePage() {
		MessagesLink.click();
		
		return (TwitterMessagesPage)openPage(TwitterMessagesPage.class);
	}
	
	public TwitterProfilePage goToProfilesPage() {
		ProfilesLink.click();
		
		return (TwitterProfilePage)openPage(TwitterProfilePage.class);
	}
	public TwitterTweetPage goToTweetPage() {
		TweetLink.click();
		
		return (TwitterTweetPage)openPage(TwitterTweetPage.class);
	}
	
	

	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(TweetLink);
	}
	

}
