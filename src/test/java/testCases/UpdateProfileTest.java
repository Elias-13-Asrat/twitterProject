package testCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageObject.DescribeYourselfPage;
import pageObject.FinalTwitterProfileupdatePage;
import pageObject.PickProfileHeaderPage;
import pageObject.PickProfilePicPage;

import pageObject.TwitterLoginPage;
import pageObject.TwitterPasswordPage;
import pageObject.TwitterProfilePage;
import pageObject.TwitterSignInPage;
import pageObject.TwitterUserAccountPage;
import utilities.DriverManager;
import utilities.TestDataProvider;

public class UpdateProfileTest extends BaseTest{


	/*
	 * UpdateProfileTest class extends the BaseTest 
	 * 
	 * --> in this class functionality of the framework to login into wwww.twitter.com
	 *   and ability to update profile will be tested
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
	
		TwitterProfilePage TwittPage = TwittMenu.goToProfilesPage();
	
		logInfo("Twitter Profile Page is Navigated");
		
		PickProfilePicPage twittPic = TwittPage.goToSetProfile();
		
		logInfo("Pick Profile Picture Page is Navigated");
		
		PickProfileHeaderPage twittHeader =  twittPic.SkipProfilePicForNow();
		
		logInfo("Pick Profile Header page is Navigated");
		
		DescribeYourselfPage twittSelfDescribe = twittHeader.clickOnSkipForNow();
		
		logInfo("Describe Yourself Page is Navigated");
		
		FinalTwitterProfileupdatePage twittUpdated = twittSelfDescribe.ClickOnSkipForNow();
		
		logInfo("Final Twitter Profile Updated Page is Naviaged");
		
		twittUpdated.seeUpdatedProfile();
		
		logInfo("Updated Profile is Navigated");
		
		
		
		
		DriverManager.getDriver().quit();
	
	
	}
}
