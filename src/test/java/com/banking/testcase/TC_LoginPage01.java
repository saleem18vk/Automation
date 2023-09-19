package com.banking.testcase;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageobjects.LoginPage;

public class TC_LoginPage01 extends BaseClass {
	
	
	
	@Test
	public void LoginTest() throws InterruptedException, IOException
	{
		
		
		LoginPage tc=new LoginPage(driver);
		
		tc.setUser(username);
		logger.info("User name enter");
		
		tc.setPwd(password);
		logger.info("password enter");
		Thread.sleep(4000);
		
		tc.userLogin();
		logger.info("login");
		Thread.sleep(4000);
		
		tc.userLogout();
		logger.info("logout");
		Thread.sleep(4000);
		
		
		System.out.println(driver.getTitle());
		logger.info("print title");
		
		
		if (driver.getTitle().equals("GTPL Bank Home Page 123fg"))
		{
			Assert.assertTrue(true);
			System.out.println("TestCase Pass");
		}else
		{  
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			System.out.println("TestCase Fail");
		}
	}
	

}
