package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.NewMessagePageOR;
import utilities.DriverManager;

public class NewMessagePage extends BasePage{
	
	
	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with " NewMessagePageOR ", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have SearchPeople() method, it takes a String value and enters the 
	 *   String value into searchPeopleField; then it returns " WrittingMessagePage "
	 */
	

	@FindBy(xpath =  NewMessagePageOR.searchPeopleField)
	WebElement searchPeopleField;
	
	@FindBy(xpath =  NewMessagePageOR.NextButton)
	WebElement NextButton;
	
	@FindBy(xpath =  NewMessagePageOR.PersonToTextLink)
	WebElement PersonToTextLink;
	
	
	//method to return located webElement
	
	public WebElement getSearchPeopleField() {
		return searchPeopleField;
	}
	
	public WebElement getNextButton() {
		return NextButton;
	}
	
	public WebElement getPersonToTextLink() {
		return PersonToTextLink;
	}
	
	// create method that search people to write message
	
	public WrittingMessagePage SearchPeople(String personToText)  {
		searchPeopleField.sendKeys(personToText);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PersonToTextLink.click();
		
		NextButton.click();
		
		return (WrittingMessagePage)openPage(WrittingMessagePage.class);
	}
	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(searchPeopleField);
	}

}
