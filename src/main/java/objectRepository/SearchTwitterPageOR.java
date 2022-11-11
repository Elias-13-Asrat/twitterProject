package objectRepository;

public class SearchTwitterPageOR {
	
	/*
	 * This Class used as Object Repository and has relation with "SearchTwitterPage",
	 *   ---> this class contains the final String value of it's locators
	 * 
	 * 
	 */
	
	//SearchTwitter Page elements
	
	public static final String TopOptionLink = "//span[text()='Top']";
	
	public static final String LatestOptionLink = "//span[text()='Latest']";

	public static final String PeopleOptionLink = "(//span[text()='People'])[1]";
	
	public static final String PhotosOptionLink = "//span[text()='Photos']";
	
	public static final String  VideosOptionLink = "//span[text()='Videos']";
}
