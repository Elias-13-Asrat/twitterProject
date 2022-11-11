package listeners;

	import java.util.Arrays;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.Markup;
	import com.aventstack.extentreports.markuputils.MarkupHelper;

   import base.BaseTest;

	import utilities.TakeScreenshot;

	public class TestListeners extends BaseTest implements ITestListener {

		
		/*
		 * TestListerenr class extends the BaseTest Class and implements
		 * methods found in ITestListener interface
		 * 
		 *  In this class i implemented OnTestSuccess(), onTestFilure(), and onTestSkip()
		 * 
		 */
		
		/*
		 * 
		 * BASIC HTML Syntax:
		 *  <b> & </b> --> HTML for Bold Text 
		 *  <font color = xxxxxxxx>
		 * & </font> --> specifying the color of the font 
		 * <br> & </br> --> line break 
		 * \n --> new line
		 * 
		 */

		public void onTestSuccess(ITestResult result) {

			// get the current test's name
			String testName = result.getMethod().getMethodName();

			// Test Case: XYZ PASSED will be in bold font on the Extent Report
			String logText = "<b>" + "Test Case: " + testName + " PASSED" + "</b>";

			// Create a label to be added to the report
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);

			// Get the Current Thread's testReport and add the details to the test report
			testReport.get().log(Status.INFO, "--------- TEST EXECUTION COMPLETED ----------");

			/*
			 *  Get the Current Thread's testReport and add a 'PASS' status with the
			 *    specified markup details (m)
			 */
			
			testReport.get().pass(m);

		}

		public void onTestFailure(ITestResult result) {

			/*
			 * 1. Failure's exception (stack trace) to be present in the Report 
			 * 2. Screenshot of the browser window at the time of the exception/failure
			 */

			String testName = result.getMethod().getMethodName();
			String screenshotPath = "";

			/*
			 * 'result' contains all the details of the current test method's execution From
			 * the 'result' we're going to get the exception details that are stored in the
			 * 'Throwable' class (getThrowable())
			 * 
			 * getStackTrace() method will return the stack trace as an Array
			 * 
			 * toString() method will convert the array to a string and store the value in
			 * the 'exceptionMessage' string variable
			 */

			String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());

			/*
			 * NOTE: exceptionMessage will have the entire stack track (all relevant error
			 * messages) separated by commas (,)
			 */

			testReport.get()
					.info("<details>" + "<summary>" + "<b>" + "<font color=red>"
							+ "Exception Occurred: Click to View Details" + "</font>" + "</b>" + "</summary>"
							+ exceptionMessage.replaceAll(",", "<br>") + "</details>" + "\n");

			
			
			//Take the Screenshot --> Take the Screenshot and add it to the Screenshots folder in the project
			
			try {
			screenshotPath = TakeScreenshot.takeScreenshot(testName);
			}catch(Throwable t) {
				t.printStackTrace();
			}
			
			//Add the screenshot to the top of the Test Report
			try {
				testReport.get().addScreenCaptureFromPath(screenshotPath);
			}catch(Throwable t) {
				t.printStackTrace();
			}
			
			
			
			
			
			
			// Add the failure message to the test report
			String failureMessage = "<b>" + "Test Case: " + testName + " FAILED" + "/<b>";
			// Create a label to be added to the report
			Markup m = MarkupHelper.createLabel(failureMessage, ExtentColor.RED);

			// Get the Current Thread's testReport and add the details to the test report
			testReport.get().log(Status.INFO, "--------- TEST EXECUTION COMPLETED ----------");

			// Get the Current Thread's testReport and add a 'PASS' status with the
			// specified markup details (m)
			testReport.get().fail(m);

		}

		public void onStart(ITestContext context) {

			// Create the test in ExtentReports at the time of Execution
			test = extent.createTest(context.getName());

			// Set the created test to refer to the current thread (in case we have Parallel
			// test execution)
			testReport.set(test);

		}

	}




