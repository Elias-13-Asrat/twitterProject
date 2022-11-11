package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.WrittingMessagePageOR;

public class WrittingMessagePage extends BasePage {
	
	
	/*
	 * this class extends the BasePage and implement getPageLoadConditon() abstract method 
	 *    found in the BasePage class
	 * 
	 * this class also has relation with "WrittingMessagePageOR", because it gets it's locators
	 *   final String value from there
	 * 
	 * In this class i have writeMessage(String message) method, it takes a String value and send the text message
	 */
	

	@FindBy(xpath = WrittingMessagePageOR.MessageField)
	WebElement MessageField;
	
	@FindBy(xpath = WrittingMessagePageOR.SendButton)
	WebElement SendButton;
	
	
	//method to return located WebElement
	
	public WebElement getMessageFiled() {
		return MessageField;
	}
	
	public WebElement getSendButton() {
		return SendButton;
	}
	
	//method to write a message
	
	public void writeMessage(String message) {
		MessageField.sendKeys(message);
		
		SendButton.click();
	}
	
	
	
	@Override
	protected ExpectedCondition getPageLoadConditon() {
		
		return ExpectedConditions.visibilityOf(MessageField);
	}

}
