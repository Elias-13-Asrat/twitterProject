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
import pageObject.TwitterExplorePage;

import pageObject.TwitterLoginPage;
import pageObject.TwitterPasswordPage;
import pageObject.TwitterSignInPage;
import pageObject.TwitterUserAccountPage;
import utilities.DriverManager;
import utilities.TestDataProvider;

public class LoginTest1 extends BaseTest {
	
	/*
	 * LoginTest1 class extends the BaseTest 
	 * 
	 * --> in this class functionality of the framework to login into www.twitter.com and
	 *     ability to access different menu options from TwitterExplore Page will be tested
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
	
		TwitterExplorePage explore = TwittMenu.goToExplorePage();
		
		logInfo("Navigated to Twitter Explore Page");
		
		explore.goToCovid19InfoMenu();
		
		logInfo("Navigated to Covid-19 Menu from Explore Page");
	
		explore.goToEntertainmentMenu();

		logInfo("Navigated to Entertainment Menu from Explore Page");
	
		explore.goToForYouMenu();
		
		logInfo("Navigated to For You Menu from Explore Page");
	
		explore.goToNewsMenu();

		logInfo("Navigated to News Menu from Explore Page");
		
		explore.goToSportsMenu();

		logInfo("Navigated to Sports Menu from Explore Page");
	
		explore.goToTrendingMenu();

		logInfo("Navigated to Trending Menu from Explore Page");
	
	
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		DriverManager.getDriver().quit();
	
	}
	

	
	
	
	
	
	
}
