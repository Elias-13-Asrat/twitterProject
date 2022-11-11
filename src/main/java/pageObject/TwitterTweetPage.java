package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.TwitterTweetPageOR;

public class TwitterTweetPage extends BasePage {
	

	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with "TwitterTweetPageOR", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have CreateNewTweet(String tweet) method, it takes a String value and 
	 * creates a new tweet
	 */
	
	

	@FindBy(xpath = TwitterTweetPageOR.tweetButton)
	WebElement tweetButton;
	
	@FindBy(xpath = TwitterTweetPageOR.tweetField)
	WebElement tweetField;
	
	@FindBy(xpath = TwitterTweetPageOR.tweetReplayOptionEveryone)
	WebElement tweetReplayOptionEveryone;
	
	@FindBy(xpath = TwitterTweetPageOR.tweetReplayOptionOnlyFollower)
	WebElement tweetReplayOptionOnlyFollower;
	
	
	
	// method to get located webElements
	
	public WebElement getTweetButton() {
		return tweetButton;
	}
	
	public WebElement getTweetFiled() {
		return tweetField;
	}
	
	public WebElement getTweetRelpayOptionEveryOne() {
		return tweetReplayOptionEveryone;
	}
	
	public WebElement getTweetReplayOptionOnlyFollower() {
		return tweetReplayOptionOnlyFollower;
	}
	
	// create a method that create a new tweet
	
	public void CreateNewTweet(String tweet) {
		

		tweetField.sendKeys(tweet);
		tweetReplayOptionEveryone.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tweetReplayOptionOnlyFollower.click();
		
		tweetButton.click();
		
	}
	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(tweetButton);
	}

}
