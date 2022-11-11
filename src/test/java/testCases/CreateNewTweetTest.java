package testCases;

import org.testng.annotations.Test;

import base.BaseTest;

import pageObject.TwitterLoginPage;
import pageObject.TwitterPasswordPage;
import pageObject.TwitterSignInPage;
import pageObject.TwitterTweetPage;
import pageObject.TwitterUserAccountPage;
import utilities.DriverManager;
import utilities.TestDataProvider;

public class CreateNewTweetTest extends BaseTest {

	/*
	 * CreateNewTweetTest class extends the BaseTest 
	 * 
	 * --> in this class functionality of the framework to login into wwww.twitter.com
	 *   and ability to create a New tweet will be tested
	 * 
	 */
	

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "commonDataProvider")	
	public void NewTweetTest(String username, String password, String browserName, String URL, String tweet) {


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
		
		TwitterTweetPage TweetPage = TwittMenu.goToTweetPage();
		
		logInfo("Twitter Tweet page is Navigated");
		
		TweetPage.CreateNewTweet(tweet);
		
		logInfo(tweet + " : is tweeted ");
		
		
		
		DriverManager.getDriver().quit();
		
		
	
	}
	
}
