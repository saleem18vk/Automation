package com.banking.testcase;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageobjects.LoginPage;
import com.banking.utilities.XLUtils;

public class TC_LoginPageDDT02 extends BaseClass {
	
	

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUser(user);
		logger.info("Enter Username");
		lp.setPwd(pwd);
		logger.info("Enter Password");
		lp.userLogin();
		logger.info("User Submitte");
		Thread.sleep(4000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent(); //it will focus on the main page
			Assert.assertTrue(false); //this is a failure case
			logger.info("login failed");
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.userLogout();
			Thread.sleep(4000);
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent(); 
			
		}
	}
	
	
	
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
	//	String path="D:\\Automation\\SampleProject\\src\\test\\java\\com\\banking\\testdata\\LoginData.xlsx";
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/banking/testdata/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colnum=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colnum];
		
		for (int i=1; i<rownum; i++)
		{
			for (int j=0; j<colnum; j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i,j);
			}
		}
		return logindata;
		
	}
	
}
