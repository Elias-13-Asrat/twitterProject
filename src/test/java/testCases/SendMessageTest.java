package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.NewMessagePage;

import pageObject.TwitterLoginPage;
import pageObject.TwitterMessagesPage;
import pageObject.TwitterPasswordPage;
import pageObject.TwitterSignInPage;
import pageObject.TwitterUserAccountPage;
import pageObject.WrittingMessagePage;
import utilities.DriverManager;
import utilities.TestDataProvider;

public class SendMessageTest extends BaseTest{
	

	/*
	 * SendMessageTest class extends the BaseTest 
	 * 
	 * --> in this class functionality of the framework to login into wwww.twitter.com
	 *   and ability to Send a Message to selected follower will be tested
	 * 
	 */
	
	
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "commonDataProvider")	
	public void TestTwo(String username, String password, String browserName, String URL, String message, String personToText) {


		openBrowser(browserName);
		
		logInfo("Launched " + browserName + " Browser");

		
		TwitterLoginPage home = new TwitterLoginPage().open(URL);
		
		logInfo("Navigated to " + URL);
		
		TwitterSignInPage twittSignIn = home.goToLogin();
		
		logInfo("Navigated to Login Page");
		
		TwitterPasswordPage twittPassword =twittSignIn.goUserName(username);
		 
		logInfo("Logged in as : " + "<b>" + username + "</b>");
		
		TwitterUserAccountPage TwittMenu =twittPassword.goPassword(password);
		
		logInfo("Logged using password : " + "<b>" + password + "</b>");
	
		TwitterMessagesPage Tmessage = TwittMenu.goToMessagePage();
	
		logInfo("Twitter Messages Page Navigated");
		
		NewMessagePage newMessage = Tmessage.WriteNewMessage();
	
		logInfo("New Message Page Navigated");
		
		WrittingMessagePage wtMessage =newMessage.SearchPeople(personToText);
		
		logInfo("Writting Message Page is Navigated and '" + personToText + "' Selected to Text");
		
		wtMessage.writeMessage(message);
		
		logInfo(message + " is texted to : " + personToText);
		
		DriverManager.getDriver().quit();
		
	}
	
}
