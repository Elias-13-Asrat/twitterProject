package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.FinalTwitterProfileupdatePageOR;

public class FinalTwitterProfileupdatePage extends BasePage{
	
	

	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with "FinalTwitterProfileupdatePageOR", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have seeUpdatedProfile() method, this method will be used to access or see the updated profile
	 */

	
	

	@FindBy(xpath = FinalTwitterProfileupdatePageOR.ProfileUpdatedLink)
	WebElement ProfileUpdatedLink;

	@FindBy(xpath = FinalTwitterProfileupdatePageOR.SeeProfileLink)
	WebElement SeeProfileLink;
	
	// method to return located element
	
	public WebElement getProfileUpdatedLink() {
		return ProfileUpdatedLink;
	}
	
	public WebElement getSeeProfileLink() {
		return SeeProfileLink;
	}
	
	
	// method to see profile
	
	public void seeUpdatedProfile() {
	  SeeProfileLink.click();
	}
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(ProfileUpdatedLink);
	}
	
	
	
}
