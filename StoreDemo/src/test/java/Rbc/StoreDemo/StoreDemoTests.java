package Rbc.StoreDemo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

//import com.sun.xml.internal.ws.transport.http.DeploymentDescriptorParser;



import Rbc.StoreDemo.HomePage;










import org.testng.reporters.*;
public class StoreDemoTests  {
	public static WebDriver driver ;
	public final static Logger log =Logger.getLogger(StoreDemoTests.class);
	static final String logproppath= "config\\log.properties";
	//public String BrowserType = "firefox";
	//public String url="http://store.demoqa.com/";
	public String PriceAccessoriesPage;
	Properties pros =new Properties();
	Wait<WebDriver> wait;
	
	
	//PropertyConfigurator.configure(logproppath);

	@BeforeSuite
	public void setup() throws Exception
	{
		//Thread.sleep(1000);
		
		try
		{
		String timestamp;
		timestamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		System.setProperty("current.logdate", timestamp);
		System.out.println("Log4j property file location" + logproppath);
		
		PropertyConfigurator.configure(logproppath);
		log.info("Execution is in Before class..and intializing the drivers...");
		
		InputStream in=new FileInputStream("config\\PropertyValues.properties");
		pros.load(in);
		
		}
		catch(Exception e)
		{
			log.info("Problem occured.. Throwing object not found error."+e.getMessage()+"\n"+e.getStackTrace()+"\nLine number:"+e.getStackTrace()[0].getLineNumber()+"\nClassName:"+e.getClass());
	    	throw new Exception();
			
		}
	}
		
	@Parameters({"url","BrowserType"})
	@BeforeTest(alwaysRun=true)
	public void navigatingToUrl(String url,String BrowserType)
	{
		if(BrowserType.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			Reporter.log("<font colour=\"blue\"><h2>I am running in IE..<h2></font>");
			 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			 
					 // Settings to Accept the SSL Certificate in the Capability object
			 capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			 
					 
			driver= new InternetExplorerDriver(capabilities);
			
			
		}
		else if(BrowserType.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			Reporter.log("<font colour=\"blue\"><h2>I am running in chrome..<h2></font>");
			driver=new ChromeDriver();
			
			
		}
		else
		{
			
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			Reporter.log("<font colour=\"blue\"><h2>I am running in firefox..<h2></font>");
			driver= new FirefoxDriver();
			
			
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		 wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30,TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
	}
	@Test
	public void storedemoqa() throws InterruptedException,IOException,Exception
	{
		try
		{
			
	
	//Thread.sleep(6000);
	ScreenShort();
	log.info("In Home page...");
	String HomePageTitile = "ONLINE STORE | Toolsqa Dummy Test site";
	//Assert.assertEquals(HomePageTitile, driver.getTitle());
	
	log.info("Assertion of home page done..");
	
	//String HomePageTitile = "Accessories | ONLINE STORE";
	
	//Home Page
	Thread.sleep(1000);
log.info("finding product category link..");
	//WebElement ProdCategoryLink= driver.findElement(By.xpath(pros.getProperty("ProductCategoryLinkHomePge").trim());
WebElement ProdCategoryLink= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu-item-33']/a")));
	//WebElement Accessories	=driver.findElement(By.linkText("Accessories"));
	log.info("finding Accessories link..");
	//Thread.sleep(2000);
	WebElement AccessoriesLink= driver.findElement(By.xpath(pros.getProperty("AccessorieslinkHomePage").trim()));
	
	Actions action= new Actions(driver);
	action.moveToElement(ProdCategoryLink).build().perform();;
	action.moveToElement(AccessoriesLink).build().perform();;
	ScreenShort();
	Thread.sleep(1000);
	action.click().perform();
	log.info("action performed...Accessories clicked");
	ScreenShort();
	log.info("Screen shot captured..");
	///Accessories Page
	//Thread.sleep(2000);
	
	
	WebElement AddtoCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pros.getProperty("AddtoCartAceessoriesPAge").trim())));
	
	String AccessoriesPageTitile = "Accessories | ONLINE STORE";
	Assert.assertEquals(driver.getTitle(),AccessoriesPageTitile);
	log.info("title of the assert page verified...");
	
	WebElement PriceSpan =driver.findElement(By.xpath(pros.getProperty("PriceSpanAccessoriesPAge").trim()));
	PriceAccessoriesPage=PriceSpan.getText();
	log.info("Price garabbed..");
	
	AddtoCartButton = driver.findElement(By.xpath(pros.getProperty("AddtoCartAceessoriesPAge").trim()));
	
	AddtoCartButton.click();
	
    ScreenShort();
	
   // AddtoCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[text()='Magic Mouse']/ancestor::div[1]//form/div[2]/div[1]/span/input")));
	Thread.sleep(12000);
	WebElement CheckoutElement = driver.findElement(By.xpath(pros.getProperty("CheckoutElementAccessoriesPAge").trim()));
    
   // WebElement CheckoutElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='header_cart']/a/em[1]")));
	
	int CheckoutCount = Integer.parseInt(CheckoutElement.getText().trim());
	Assert.assertEquals(CheckoutCount,1);
	
	CheckoutElement.click();
	ScreenShort();
	
	
	
    
    
    
    
    //CheckoutPage
    
    String CheckoutPageTitile ="Checkout | ONLINE STORE";
    AssertJUnit.assertEquals(CheckoutPageTitile, driver.getTitle());
    
    
    // verifyItemAdded();

		}
		catch(Exception e)
		{
			log.info("Problem occured.. Throwing object not found error."+e.getMessage()+"\n"+e.getStackTrace()+"\nLine number:"+e.getStackTrace()[0].getLineNumber());
	    	throw new Exception();
			
		}
	
}
	
	public void ScreenShort() throws InterruptedException,IOException
	{
		Reporter.log(driver.getTitle());
		TakesScreenshot tk=(TakesScreenshot)driver;
		Thread.sleep(500);
		String ImageFileName = new SimpleDateFormat("MMddyy-HHmmss").format(new Date());
		File f=tk.getScreenshotAs(OutputType.FILE);
		System.out.println(f.getAbsoluteFile());
		
		String  dest=System.getProperty("user.dir")+"/ScreenShots/"+ImageFileName+".png";
		File destlocation=new File(dest);//("C:\\Users\\maanya sri\\Downloads\\seleniumtraining\\selenium\\screenshorts");/*\\screenshort.png");*/
		
		//destlocation=new File("C:\\Users\\maanya sri\\Downloads\\seleniumtraining\\selenium\\screenshorts\\screenshort"+ImageFileName+".png");
		FileUtils.copyFile(f,destlocation);
		Reporter.log("<br><img src='"+destlocation+"' height='400' width='400'/></br>");
	}

	@Test(dependsOnMethods={"storedemoqa"})
	public void verifyCartInCheckoutpage() throws Exception
	{
		try
		{
			ScreenShort();
		Integer resultIndex = -1;
		log.info("verifying the title of the checkou page");
		String CheckoutPageTitile ="Checkout | ONLINE STORE";
	    AssertJUnit.assertEquals(CheckoutPageTitile, driver.getTitle());
	    
	    log.info("Passing the verification string in json format");
	    
	    String jsonString= "{\"Product\":\"Magic Mouse\",\"Quantity\":\"1\",\"Price\":\"$150.00\",\"Total\":\"$150.00\"}";
		
		JSONParser parser = new JSONParser();
		String JSON_DATA = jsonString;
		Object obj = null;
		try {
			obj = parser.parse(JSON_DATA);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		JSONObject jsonObject = (JSONObject) obj;
		//logger.info("Total number or elements in Json is " + jsonObject.size());
		
		System.out.println("Total number or elements in Json is " + jsonObject.size());
		
		Properties propArray = new Properties();
		Set keys = jsonObject.keySet();
	    Iterator a = keys.iterator();
		int i = 0;
	    while(a.hasNext()) {
	    	String key = (String)a.next();
	        // loop to get the dynamic key
	        String value = (String)jsonObject.get(key);
	       
	        propArray.setProperty(key, value);
	        System.out.println(propArray.toString());
	        i++;
	    }
	    
	    WebElement resultfieldTable = driver.findElement(By.xpath(".//table[@class='checkout_cart']"));
		new Actions(driver).moveToElement(resultfieldTable).perform();
		
		List<Integer> headerIndex = new ArrayList<Integer>();
		List<String> headerValue = new ArrayList<String>();
		List<String> dataValue = new ArrayList<String>();
		
		Set headerInfo = propArray.keySet();
		Iterator itr = headerInfo.iterator();
		String header = null;
		String expectedtablevalue = null;
		Integer headercount=-1;
		List<WebElement> columnheaders=null;
		List<WebElement> datarows=null;
		Integer foundresult=0; // Increment to the number of json values and verify
		Integer headerprocessingcount=0;
		
		while(itr.hasNext()){ // Process each json at a time
			headercount = -1;
			header = (String) itr.next();
			
			expectedtablevalue = propArray.getProperty(header);
			log.info("Header I am looking for: "+header+" - Value I am looking for:"+expectedtablevalue);
			
			columnheaders = resultfieldTable.findElements(By.xpath("./tbody/tr/th"));
			log.info("Number of columns in the table"+ columnheaders.size());
			
			datarows = resultfieldTable.findElements(By.xpath("./tbody/tr"));
			log.info("Number of data rows in the table"+ datarows.size());
			
			for(WebElement processinghedaderele: columnheaders){
				headercount++;
				log.info("Header I am processing- number" + headercount + "- value"+ processinghedaderele.getText());
				if(processinghedaderele.getText().trim().length()>1){
					if(processinghedaderele.getText().trim().contains(header.trim())){
						try{
							log.info("Match found for header in"+headercount);
							headerIndex.add(headerprocessingcount, headercount);
							headerValue.add(headerprocessingcount,header.trim());
							dataValue.add(headerprocessingcount,expectedtablevalue.trim());
							headerprocessingcount++;
							log.info("Completed processing one json search. Moving to next");
						}
						catch(Exception e){
							log.info("Exception in updating Arraylist"+e.getLocalizedMessage()+e.getMessage()+e.toString());
						}
						break;
					}
				}
				
			}
			log.info("The columns I have to process"+headerValue.toString());
			log.info("The values I have to process"+dataValue.toString());
			log.info("The Index I have to process"+headerIndex.toString());
			
		}
		
		
		log.info("******************************");
		log.info("Table Header indexes are found");
		log.info("******************************");
		
		Integer rowcount=1;
		for(int it=1;it<datarows.size();it++)//the first row is header and so procesing from the next row
			
			
		{
			WebElement processingdatarow=datarows.get(it);
			foundresult =0;
			log.info("Processing data row " + rowcount+ "in the table");
			
			//getting the values from header indexes and comparing the values
			for(int indexkeyref=0; indexkeyref < headerIndex.size();indexkeyref++){
				
				Integer headerIndexprocess = headerIndex.get(indexkeyref);
				String processingtablevalue;
				if(headerIndexprocess+2==3)
				
				{
				processingtablevalue=processingdatarow.findElement(By.xpath("./td["+(headerIndexprocess+2)+"]/form/input[1]")).getAttribute("value").toString();
				}
				else
				{
					processingtablevalue= processingdatarow.findElement(By.xpath("./td["+(headerIndexprocess+2)+"]")).getText().trim();
				 
				}
				log.info("Current value in the table"+processingtablevalue);
				
				expectedtablevalue = dataValue.get(indexkeyref).toString();
				log.info("Value I am looking for"+expectedtablevalue);
				
				
				if(processingtablevalue.contains("...")){
					log.info("Table has chopped content.");
					
					WebElement tdelement = processingdatarow.findElement(By.xpath("./td["+(headerIndexprocess+1)+"]"));
					tdelement.click();
					Thread.sleep(1000);
					processingtablevalue = tdelement.findElement(By.xpath(".//span/div")).getAttribute("innerText").trim();
					//logger.info("Inner text"+processingdatarow.findElement(By.xpath("./td["+(headerIndexprocess+1)+"]/div/span/div")).getAttribute("innerText"));
					log.info("Table inside content"+processingtablevalue);
				}
				
				
				
				log.info("Value of the column"+headerIndexprocess+2);
				log.info("Value of corresponding table column:"+processingtablevalue);
			
				if(processingtablevalue.length()>0){
					if(processingtablevalue.trim().contains(expectedtablevalue.trim())){
						log.info("Found match for the table content in row"+rowcount);
						foundresult++;
						//break;
					}
					else{
						log.info("Mis match:"+processingtablevalue.trim()+" did not match expected value:"+expectedtablevalue);
					}
				}
				else{
					log.info("Row:"+rowcount+" Column:"+ headerIndexprocess+" does not have any value.");
				}
			}
		
			if(propArray.size() == foundresult){
				log.info("Found data for all the info in table in row"+rowcount);
				resultIndex = rowcount;
				break;
			}
			rowcount++;
		}
		log.info("Row index identified"+resultIndex);
		
		log.info("***************************************************************");
		log.info("Table Verification done");
		log.info("*****************************************************************");
		
		WebElement ContinueLink = driver.findElement(By.linkText("Continue"));
		ContinueLink.click();
		
		ScreenShort();
		
		}
		catch(Exception e)
		{
			log.info("Unable to Verify the table content. Throwing object not found error."+e.getMessage()+"\n"+e.getStackTrace()+"\nLine number:"+e.getStackTrace()[0].getLineNumber());
	    	throw new Exception();
		}
	}
	
	@Test(dependsOnMethods={"verifyCartInCheckoutpage"})
	public void fillInfoCheckout() throws Exception
	{
		try
		{
			ScreenShort();
		log.info("Finding the elements in checkout page");
		WebElement EmailAddressFLD = driver.findElement(By.xpath(pros.getProperty("EmailIDInfoPage").trim()));
		WebElement FirstNameFLD = driver.findElement(By.xpath(pros.getProperty("FirstNameInfoPage").trim()));
		WebElement LastNameFLD = driver.findElement(By.xpath(pros.getProperty("LastNAmeInfoPAge").trim()));
		WebElement AddressFLD = driver.findElement(By.xpath(pros.getProperty("AddressInfoPAge").trim()));
		WebElement CityFLD = driver.findElement(By.xpath(pros.getProperty("CityInfoPage").trim()));
		WebElement StateFLD = driver.findElement(By.xpath(pros.getProperty("StateFldInfoPAge").trim()));
		WebElement PostalCodeFLD = driver.findElement(By.xpath(pros.getProperty("PostalCodePAge").trim()));
		WebElement PhoneNumberFLD = driver.findElement(By.xpath(pros.getProperty("PhoneNumberPage").trim()));
		WebElement CountryDropdown = driver.findElement(By.xpath(pros.getProperty("CountryDropdown").trim()));
		Select CountrySelect = new Select(CountryDropdown);
		WebElement ShippAddrCheckbox = driver.findElement(By.xpath(pros.getProperty("ShipAddresscheckboxInfopage").trim()));
		WebElement PurchaseBTN = driver.findElement(By.xpath(pros.getProperty("PurchaseButtonInfoPAge").trim()));
		
		
		WebElement ItemCostSpan =driver.findElement(By.xpath(pros.getProperty("ItemCostInfoPage").trim()));
		WebElement TotalCostSpan=driver.findElement(By.xpath(pros.getProperty("TotalCostInfoPAge").trim()));
		
		
		log.info("Filling the information in checkout page");
		EmailAddressFLD.sendKeys("abc@gmail.com");
		FirstNameFLD.sendKeys("testfirst");
		LastNameFLD.sendKeys("testlast");
		AddressFLD.sendKeys("TestAddress");
		CityFLD.sendKeys("testcity");
		StateFLD.sendKeys("teststate");
		PostalCodeFLD.sendKeys("t1t2t3");
		CountrySelect.selectByVisibleText("Canada");
		PhoneNumberFLD.sendKeys("12345fkaj567");
		/* Assersion error in chrome becuase these fields are not in chrome
		String ItemCostInfo="$150.00";
		String TotalCostInfo="$160.00";
		log.info("Assertion for Item cost and total Cost in InfoCheckout PAge");
		
	Assert.assertEquals(ItemCostInfo, ItemCostSpan.getText().trim());
	Assert.assertEquals(TotalCostInfo, TotalCostSpan.getText().trim());
		*/
		Boolean ShipAddCheckStatus = ShippAddrCheckbox.isSelected();//.getAttribute("checked").equals("true");
		if(!ShipAddCheckStatus)
		{
			ShippAddrCheckbox.click();
		}
			
		
		PurchaseBTN.click();
		
		}
		catch(Exception e)
		{
			log.info("Error occured...."+e.getMessage()+"\n"+e.getStackTrace()+"\nLine number:"+e.getStackTrace()[0].getLineNumber());
	    	throw new Exception();
	    }
	
	}
	@Test(dependsOnMethods={"fillInfoCheckout"})
	public void TranscationResult() throws InterruptedException ,IOException
	{
		Thread.sleep(8000);
		ScreenShort();
		String TransactionResultTitle ="Transaction Results | ONLINE STORE";
		Assert.assertEquals(driver.getTitle(),TransactionResultTitle);
		WebElement CheckoutClearElement = driver.findElement(By.xpath(pros.getProperty("checkoutClearTransactiionPAge").trim()));
		int CheckoutCount = Integer.parseInt(CheckoutClearElement.getText().trim());
		Assert.assertEquals(CheckoutCount,0);
		
	}
}
			
			
			
		
	
	
	

	
		
	
	
	
	
	
	


