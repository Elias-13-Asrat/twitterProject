package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.PickProfilePicPageOR;

public class PickProfilePicPage extends BasePage {
	
	

	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with PickProfilePicPageOR, because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have SkipProfilePicForNow() method and returns PickProfileHeaderPage
	 */

	
	
	
	@FindBy(xpath = PickProfilePicPageOR.pickProfilePicHeaderTitle)
	WebElement pickProfilePicHeaderTitle;

	@FindBy(xpath = PickProfilePicPageOR.SkipForNowLink)
    WebElement SkipForNowLink;
	
	
	//method to return located element
	
	public WebElement getPickProfilePicHeaderTitle() {
		
		return pickProfilePicHeaderTitle;
	}
	
	public WebElement getSkipForNowLink() {
		
		return SkipForNowLink;
	}
	
	// method to click on skip for now Link
	
	public PickProfileHeaderPage SkipProfilePicForNow() {
		SkipForNowLink.click();
		
		return (PickProfileHeaderPage)openPage(PickProfileHeaderPage.class);
	}
	
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(pickProfilePicHeaderTitle);
	}
	
	
	
	

}
