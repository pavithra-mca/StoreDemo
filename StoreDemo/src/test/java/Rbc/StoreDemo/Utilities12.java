package Rbc.StoreDemo;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import Rbc.StoreDemo.StoreDemoTests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Utilities12 extends StoreDemoTests {
	
	
	
public void TakeScreenShortOF() throws InterruptedException, IOException
{
	
	
	TakesScreenshot tk=(TakesScreenshot)driver;
	Thread.sleep(500);
	String ImageFileName = new SimpleDateFormat("MMddyy-HHmmss").format(new Date());
	File f=tk.getScreenshotAs(OutputType.FILE);
	System.out.println(f.getAbsoluteFile());
	File destlocation=new File("C:\\Users\\maanya sri\\Downloads\\seleniumtraining\\selenium\\screenshorts");/*\\screenshort.png");*/
	String[] filenames = null;
	if(destlocation.isDirectory())
	{
	  filenames=destlocation.list();
	}
	destlocation=new File("C:\\Users\\maanya sri\\Downloads\\seleniumtraining\\selenium\\screenshorts\\screenshort"+ImageFileName+".png");
	FileUtils.copyFile(f,destlocation);
	Reporter.log("<br><img src='"+destlocation+"' height='400' width='400'/></br>");
}

}
