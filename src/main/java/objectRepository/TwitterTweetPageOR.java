package objectRepository;


public class TwitterTweetPageOR {
	

	/*
	 * This Class used as Object Repository and has relation with "TwitterTweetPage",
	 *   ---> this class contains the final String value of it's locators
	 * 
	 * 
	 */

	// Twitter Tweet Page Elements
	
	
	public static final String tweetButton = "(//span[text()='Tweet'])[1]";
	
	public static final String tweetField = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']";
	
	public static final String tweetReplayOptionEveryone = "//span[text()='Everyone can reply']"; 

	public static final String tweetReplayOptionOnlyFollower = "//span[text()='People you follow']";
}
