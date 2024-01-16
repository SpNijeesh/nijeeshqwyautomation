package qwy.automationqwy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import qwy.automationqwy.resources.ExtentReportManager;

public class Listerners implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReportManager.createInstance();
//	private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//    private PrintStream printStream = new PrintStream(outputStream);
    
    @Override
    public void onStart(ITestContext context) {
      //  System.setOut(printStream); // Redirect System.out to capture console output
    }

	@Override
	public void onTestStart(ITestResult result)
	{

		test= extent.createTest(result.getMethod().getMethodName());
		//outputStream.reset();
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test passed");
		//  appendConsoleOutputToReport(result);
		
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		test.log(Status.FAIL, "Test failed");
		test.fail(result.getThrowable());
	//	appendConsoleOutputToReport(result);
		
	}
	 @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test skipped: " + result.getName());
	    }
//	 private void appendConsoleOutputToReport(ITestResult result) {
//	        String consoleOutput = outputStream.toString();
//	        result.setAttribute("consoleOutput", consoleOutput);
//	        }
}
