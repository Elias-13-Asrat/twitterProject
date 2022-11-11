package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.PickProfileHeaderPageOR;

public class PickProfileHeaderPage extends BasePage{

	
	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with PickProfileHeaderPageOR, because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have clickOnSkipForNow() method and returns DescribeYourselfPage
	 */

	
	
	@FindBy(xpath = PickProfileHeaderPageOR .PickHeaderPageHeaderTitle)
	WebElement PickHeaderPageHeaderTitle;

	@FindBy(xpath = PickProfileHeaderPageOR .SkipForNowLink)
	WebElement SkipForNowLink;
	
	// method to return located element
	
	public WebElement getPickHeaderPageHeaderTitle() {
		return PickHeaderPageHeaderTitle;
	}
	
	public WebElement getSkipForNowLink() {
		return SkipForNowLink;
	}
	
	// method to click on skip for now button
	public DescribeYourselfPage clickOnSkipForNow() {
		SkipForNowLink.click();
		
		return (DescribeYourselfPage)openPage(DescribeYourselfPage.class);
	}
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(PickHeaderPageHeaderTitle);
	}
	
	
	
	
	
}
