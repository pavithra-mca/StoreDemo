package Rbc.StoreDemo;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import Rbc.StoreDemo.*;

import org.apache.log4j.Logger;


public class HomePage {
	
	WebDriver driver;
	Wait wait;
	Logger log;
	StoreDemoTests test;
	public HomePage(WebDriver driver,Wait wait,Logger log)
	{
	this.driver = driver;
	this.wait =wait;
	this.log = log;
	}
	public void GoToAccessories() throws Exception
	{
		try
		{
		log.info("In Home page...");
		
		//Assert.assertEquals(HomePageTitile, driver.getTitle());
		
		log.info("Assertion of home page done..");
		
		//String HomePageTitile = "Accessories | ONLINE STORE";
		
		//Home Page
		//Thread.sleep(1000);
	log.info("finding product category link..");
		WebElement ProdCategoryLink= (WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu-item-33']/a")));
		//WebElement Accessories	=driver.findElement(By.linkText("Accessories"));
		log.info("finding Accessories link..");
		WebElement AccessoriesLink= driver.findElement(By.xpath(".//a[text()='Accessories']"));
		log.info("Accessories Link Found");
		Actions action= new Actions(driver);
		action.moveToElement(ProdCategoryLink).build().perform();;
	log.info("ProductDetails..clicked");
		action.moveToElement(AccessoriesLink).build().perform();;
		log.info("Accessories clicked");
		test.ScreenShort();
		Thread.sleep(1000);
		action.click().perform();
		log.info("action performed...Accessories clicked");
		test.ScreenShort();
		log.info("Screen shot captured..");
		//return driver;
		}
		catch(Exception e)
		{
			log.info("Problem occured.. Throwing object not found error."+e.getMessage()+"\n"+e.getStackTrace()+"\nLine number:"+e.getStackTrace()[0].getLineNumber()+"\nClassName:"+e.getClass());
	    	throw new Exception();
			
		}
	}

}
