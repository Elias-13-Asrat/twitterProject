package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.DescribeYourselfPageOR;

public class DescribeYourselfPage extends BasePage{
	
	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with "DescribeYourselfPageOR", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have ClickOnSkipForNow() method and it returns me "FinalTwitterProfileupdatePage"
	 */

	@FindBy(xpath = DescribeYourselfPageOR.DiscribeYourSelfPageHeaderTitle)
	WebElement DiscribeYourSelfPageHeaderTitle;

	@FindBy(xpath = DescribeYourselfPageOR.SkipForNowButton)
	WebElement SkipForNowButton;
	
	// method to return located element
	public WebElement getHeaderTitle() {
		return DiscribeYourSelfPageHeaderTitle;
	}
	
	public WebElement getSkipForNowButton() {
		return SkipForNowButton;
	}
	
	// method to click skip for now method
	public FinalTwitterProfileupdatePage ClickOnSkipForNow() {
		SkipForNowButton.click();
		
		return (FinalTwitterProfileupdatePage)openPage(FinalTwitterProfileupdatePage.class);
		
	}
	
	
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(DiscribeYourSelfPageHeaderTitle);
	}
	
	
	
}
