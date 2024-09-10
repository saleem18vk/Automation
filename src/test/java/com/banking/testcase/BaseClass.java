package com.banking.testcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utilities.ReadConfig;


//BaseClass
public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password= readconfig.getPassword();
	
	

	
//	public String baseURL="https://demo.guru99.com/V1/index.php";
//	public String username="mngr526039";
//	public String password="dYvypag";

	
	
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String brw)

	{	
		logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");

		if(brw.equals("chrome"))
		{

		//	System.setProperty("webdriver.chrome.driver","D:\\Automation\\SampleProject\\Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver","D:\\Automation\\SampleProject\\SampleProject\\Drivers\\chromedriver.exe");

			//  System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());

			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}else if(brw.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Automation\\SampleProject\\Drivers\\geckodriver.exe");
			
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		logger.info("Browser oppend");

	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	public void captureScreen( WebDriver driver, String test_name)throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"/Screenshots/"+ test_name+".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot Taken");

	}
	
	//Generate random String
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return (generatedstring);
	}
	public String randomstring1()
	{
		String generatedstring1=RandomStringUtils.randomAlphabetic(9);
		return (generatedstring1);
	}
	
	//Generate random number
	public String randomnum()
	{
		String generatedstring2=RandomStringUtils.randomNumeric(9);
		return (generatedstring2);
	}

}
