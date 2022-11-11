	package utilities;

	import java.io.File;
	import java.io.IOException;
	import java.util.Date;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
     import org.openqa.selenium.TakesScreenshot;

     import base.BaseTest;


	public class TakeScreenshot extends BaseTest {
		
		/*
		 * TakeScreenshot class extends BaseTest class
		 * 
		 * - this class has a 'takeScreenshot() method takes a String value for the test name; 
		 *   capture the screenshot when it is called and save the file under 'screenshots' folder
		 */
		
		public static String takeScreenshot(String testName) throws IOException {
			
			Date myDate = new Date();
			String fileName = myDate.toString().replace(":", "_").replace(" ", "_");
			
			//Extract the Day
			String day = fileName.substring(0, 10);
			
			//Extract the Time
			String time = fileName.substring(11, 19);
			
			
			String path = System.getProperty("user.dir");
			
			String New_path = path.replace("\\","/");
			
			String destinationFilePath = New_path + "//screenshots//" + day + "//" + 
										time + "_" + testName + ".jpg";
			
			
			//Capture the screenshot and store it into a file
			File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			
			//Copy the file (screenshot) to a specified location
			//We need to import the FileUtils class from the 'commons' package
			//We need to add the commons-io dependency
			
			FileUtils.copyFile(screenshot, new File(destinationFilePath));
			
			return destinationFilePath;
			
		}


	}




