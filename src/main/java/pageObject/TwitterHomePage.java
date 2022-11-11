package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.TwitterHomePageOR;
import utilities.DriverManager;

public class TwitterHomePage extends BasePage{

	
	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with " TwitterHomePageOR ", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have SearchTwitter(String topicToSearch) method it takes a String value 
	 *  and returns "SearchTwitterPage"
	 */
	
	
	@FindBy(xpath = TwitterHomePageOR.SearchForTwitterLink)
	WebElement SearchForTwitterLink;
	
	//method to return located element
	
	public WebElement getSearchForTwitterLink() {
		
		return SearchForTwitterLink;
	}
	
	// method to Search for Twitter
	
	public SearchTwitterPage SearchTwitter(String topicToSearch) {
		
		SearchForTwitterLink.sendKeys(topicToSearch);
		
		Actions action = new Actions(DriverManager.getDriver());
		
		action.sendKeys(Keys.ENTER).build().perform();
		
		return (SearchTwitterPage)openPage(SearchTwitterPage.class);
	}
	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(SearchForTwitterLink);
	}

}
