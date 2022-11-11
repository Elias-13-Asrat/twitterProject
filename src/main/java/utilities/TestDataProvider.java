package utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;


public class TestDataProvider {
	
	/*
	 *  This class has relation with ReadingExcel class, 
	 *   it uses getTestData() method to access the test data values from Excel
	 */
	
	/*
	 * Method m ---> Java Reflection API
	 * Method class contains information about the current method being executed by the thread
	 * .getName() method returns the name of the current method being executed as a string
	 * 
	 */
	
	
	String path = System.getProperty("user.dir");
	 String path1 = path.replace("\\","/");
	
	ReadingExcel TwitterExcel = new ReadingExcel(path1 +"//src//test//resources//TestData//FramWorkExcelData.xlsx");
	
	
	@DataProvider(name = "commonDataProvider")
	public Object[][] getTestData(Method m) throws EncryptedDocumentException, IOException{
		Object [][] testData = TwitterExcel.readExcelData(m.getName());
		
		return testData;
	}
	
}
