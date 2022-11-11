package testCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageObject.SearchTwitterPage;
import pageObject.TwitterHomePage;
import pageObject.TwitterLoginPage;
import pageObject.TwitterPasswordPage;
import pageObject.TwitterSignInPage;
import pageObject.TwitterUserAccountPage;
import utilities.DriverManager;
import utilities.TestDataProvider;

public class SearchTwitterTest extends BaseTest{


	/*
	 * SearchTwitterTest class extends the BaseTest 
	 * 
	 * --> in this class functionality of the framework to login into wwww.twitter.com
	 *   and ability to Search for Twitter will be tested
	 * 
	 */
	
	
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "commonDataProvider")	
	public void TwitterSearchTest(String username, String password, String browserName, String URL, String topicToSearch) {


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

		TwitterHomePage twittHome = TwittMenu.goToHomePage();
		
		logInfo("Twitter Home Page is Navigated");
		
		SearchTwitterPage searchTwitt = twittHome.SearchTwitter(topicToSearch);
		
		logInfo(topicToSearch +" is entered in Twitter Search field and Searched Twitter Page is Navigated");
		
		searchTwitt.goToTopAcessMenu();
		
		logInfo("Navigated Top Menu Option about " + topicToSearch + " from Searched Twitter Page");
		
		searchTwitt.getPeopleOptionLink();

		logInfo("Navigated People Menu Option about " + topicToSearch + " from Searched Twitter Page");
		
		searchTwitt.goToLatestAcessMenu();

		logInfo("Navigated Latest Menu Option about " + topicToSearch + " from Searched Twitter Page");
		
		searchTwitt.goToPhotoAcessMenu();
		
		logInfo("Navigated Photos Menu Option about " + topicToSearch + " from Searched Twitter Page");
		
		searchTwitt.goToVideoAcessMenu();
		
    	logInfo("Navigated Videos Menu Option about " + topicToSearch + " from Searched Twitter Page");
		
		
		
		
		DriverManager.getDriver().quit();
		
		
		
	
	}	
}
