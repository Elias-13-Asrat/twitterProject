package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.TwitterProfilePageOR;

public class TwitterProfilePage extends BasePage{
	
	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with "TwitterProfilePageOR", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have goToSetProfile() method and returns "PickProfilePicPage"
	 */

	@FindBy(xpath = TwitterProfilePageOR.SetProfileLink)
	WebElement SetProfileLink;

	
	// method to return located element
	
	public WebElement getSetProfileLink() {
		
		return SetProfileLink;
	}
	
	
	
	//method to click on profile Link
	
	public PickProfilePicPage goToSetProfile() {
		SetProfileLink.click();
		
		return (PickProfilePicPage)openPage(PickProfilePicPage.class);
	}
	
	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(SetProfileLink);
	}
	
	
	
	
	
}
