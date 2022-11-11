package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.SearchTwitterPageOR;

public class SearchTwitterPage extends BasePage{

	
	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with " SearchTwitterPageOR ", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have different methods to go to different Menu options in Search Twitter Page
	 *      goToTopAcessMenu()    ---->  gives access to Top Menu Option
	 *      goToLatestAcessMenu() ---->  gives access to Latest Menu Option
	 *      goToPeopleAcessMenu() ---->  gives access to People Menu Option
	 *      goToPhotoAcessMenu()  ---->  gives access to Photos Menu Option
	 *      goToVideoAcessMenu()  ---->  gives access to Videos Menu Option
	 *  
	 */

	
	
	@FindBy(xpath = SearchTwitterPageOR.TopOptionLink)
	WebElement TopOptionLink;
	
	@FindBy(xpath = SearchTwitterPageOR.LatestOptionLink)
	WebElement LatestOptionLink;
	
	@FindBy(xpath = SearchTwitterPageOR.PeopleOptionLink)
	WebElement PeopleOptionLink;
	
	@FindBy(xpath =SearchTwitterPageOR.PhotosOptionLink)
	WebElement PhotosOptionLink;
	
	@FindBy(xpath = SearchTwitterPageOR.VideosOptionLink)
	WebElement VideosOptionLink;
	
	//method to return located element
	
	public WebElement getTopOptionLink() {
		return TopOptionLink;
	}
	
	public WebElement getLatestOptionLink() {
		return LatestOptionLink;
	}
	
	public WebElement getPeopleOptionLink() {
		return PeopleOptionLink;
	}
	
	public WebElement getPhotosOptionLink() {
		return PhotosOptionLink;
	}
	
	public WebElement getVideosOptionLink() {
		return VideosOptionLink;
	}
	
	//method to go different menu options
	
	public void goToTopAcessMenu() {
		TopOptionLink.click();
	}
	
	public void goToLatestAcessMenu() {
		LatestOptionLink.click();
	}
	
	public void goToPeopleAcessMenu() {
		PeopleOptionLink.click();
	}
	
	public void goToPhotoAcessMenu() {
		PhotosOptionLink.click();
	}
	
	public void goToVideoAcessMenu() {
		VideosOptionLink.click();
	}
	
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(VideosOptionLink);
	}
	
	
	
	

}
