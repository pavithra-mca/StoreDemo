package Rbc.StoreDemo;

import java.io.File;
import java.io.IOException;




import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.TestListenerAdapter;
import org.testng.ITestResult;
import org.testng.Reporter;

import Rbc.StoreDemo.StoreDemoTests;
import Rbc.StoreDemo.Utilities12;

public class TestListeners12 implements ITestListener  {
	/*
	WebDriver driver;
	public TestListeners(WebDriver driver)
	{
		this.driver =driver;
		
	}
	*/
	public void onTestSuccess(ITestResult arg0) {

		// This is calling the printTestResults method

		
		Reporter.log("**************onTestSucess***************************************");
		
	//Utilities.class.getMethod(TakeScreenShortOF(), null);
		
		Reporter.log("*****************************************************");
	}
	/*public void TakeScreen() throws InterruptedException,IOException
	{
		TakesScreenshot tk=(TakesScreenshot)driver;
		Thread.sleep(500);
		
		File f=tk.getScreenshotAs(OutputType.FILE);
		System.out.println(f.getAbsoluteFile());
		File destlocation=new File("C:\\Users\\maanya sri\\Downloads\\seleniumtraining\\selenium\\screenshorts");
		String[] filenames = null;
		if(destlocation.isDirectory())
		{
		  filenames=destlocation.list();
		}
		destlocation=new File("C:\\Users\\maanya sri\\Downloads\\seleniumtraining\\selenium\\screenshorts\\screenshort"+filenames.length+".png");
		FileUtils.copyFile(f,destlocation);
	}

*/
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
