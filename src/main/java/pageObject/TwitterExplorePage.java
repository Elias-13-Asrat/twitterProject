package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.TwitterExplorePageOR;

public class TwitterExplorePage extends BasePage {


	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with " TwitterExplorePageOR ", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class there are different methods that will be used to access different Menu options
	 * from Twitter Explore Page; these methods are:
	 * 
	 *    goToForYouMenu()  -----> gives access to ForYou Twitter Explore Option
	 *    
	 *    goToTrendingMenu() -----> gives access to Trending Twitter Explore Option
	 *    
	 *    goToCovid19InfoMenu() -----> gives access to Covid-19 Info Twitter Explore Option
	 *    
	 *    goToNewsMenu() -----> gives access to News Twitter Explore Option
	 *    
	 *    goToSportsMenu() -----> gives access to Sports Twitter Explore Option
	 *    
	 *   goToEntertainmentMenu() -----> gives access to Entertainment Twitter Explore Option
	 *
	 */
	
	
	@FindBy(xpath = TwitterExplorePageOR.ForYouLink)
	WebElement ForYouLink;
	
	@FindBy(xpath = TwitterExplorePageOR.TrendingLink)
	WebElement TrendingLink;
	
	@FindBy(xpath = TwitterExplorePageOR.Covid19Link)
	WebElement Covid19Link;
	
	@FindBy(xpath = TwitterExplorePageOR.NewsLink)
	WebElement NewsLink;
	
	@FindBy(xpath = TwitterExplorePageOR.SportsLink)
	WebElement SportsLink;
	
	@FindBy(xpath = TwitterExplorePageOR.EntertainmentLink)
	WebElement EntertainmentLink;
	
	// method that returns the located WebElements
	
	public WebElement getForYouLink() {
		return ForYouLink;
	}
	
	public WebElement getTrendingLink() {
		return TrendingLink;
	}
	
	public WebElement getCovid19Link() {
		return Covid19Link;
	}
	
	public WebElement getNewsLink() {
		return NewsLink;
	}
	
	public WebElement getSportsLink() {
		return SportsLink;
	}
	
	public WebElement getEntertainmentLink() {
		return EntertainmentLink;
	}
	
	//method to go to different options inside explore page
	
	public void goToForYouMenu() {
		ForYouLink.click();
	}
	
	public void goToTrendingMenu() {
		TrendingLink.click();
	}
	
	public void goToCovid19InfoMenu() {
		Covid19Link.click();
	}
	
	public void goToNewsMenu() {
		NewsLink.click();
	}
	
	public void goToSportsMenu() {
		SportsLink.click();
	}
	
	public void goToEntertainmentMenu() {
		EntertainmentLink.click();
	}
	
	
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
	
			
	return ExpectedConditions.visibilityOf(SportsLink);
	}

	
	
	
	
	
	
	
	
}
