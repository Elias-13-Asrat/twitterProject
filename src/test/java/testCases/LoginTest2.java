package testCases;

import org.testng.annotations.Test;

import base.BaseTest;

import pageObject.TwitterLoginPage;
import pageObject.TwitterNotificationPage;
import pageObject.TwitterPasswordPage;
import pageObject.TwitterSignInPage;
import pageObject.TwitterUserAccountPage;
import utilities.DriverManager;
import utilities.TestDataProvider;

public class LoginTest2 extends BaseTest {

	/*
	 * LoginTest2 class extends the BaseTest 
	 * 
	 * --> in this class functionality of the framework to login into wwww.twitter.com
	 *   and ability to access different menu options from TwitterNotification Page will be tested
	 * 
	 */
	

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "commonDataProvider")	
	public void LoginTest(String username, String password, String browserName, String URL) {


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
	
		TwitterNotificationPage twittNotification = TwittMenu.goToNotificationPage();
		
		logInfo("Twitter Notification Page is Navigated");
		
		twittNotification.goToAllOption();
		
		logInfo("Navigated to ALL menu option from Notification Page");
		
		twittNotification.goToMentionsOption();
		
		logInfo("Navigated to Mentions menu option from Notification Page");
		
		
		
		DriverManager.getDriver().quit();
		
		
	}
}
