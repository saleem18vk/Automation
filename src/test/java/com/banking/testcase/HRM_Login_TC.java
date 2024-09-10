package com.banking.testcase;

import java.io.IOException;


import org.testng.annotations.Test;

import com.banking.pageobjects.HRM_Login;

public class HRM_Login_TC extends BaseClass {
	
//	WebDriver driver;
	
	@Test
	public void HRM_LoginTest() throws InterruptedException, IOException
	{
		
		
		HRM_Login tc=new HRM_Login(driver);
		
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		tc.setUser(username);
		logger.info("User name enter");
		
		tc.setPassword(password);
		logger.info("password enter");
		Thread.sleep(4000);
		
		tc.setLogin();
		logger.info("login");
		Thread.sleep(4000);
		
		tc.clickHRAdmin();
		logger.info("Click HR Admin");
		Thread.sleep(20000);
		
		tc.clickAddUser();
		logger.info("Click Add User");
		Thread.sleep(4000);
		
		tc.employeName("Aaliyah Haq");
		logger.info("Enter Employe name");
		Thread.sleep(4000);
		
		tc.employeUserName("munna");
		logger.info("Enter Employe User name");
		Thread.sleep(4000);
		
		
		// explicit wait - to wait for the compose button to be click-able
//		WebDriverWait wait = new WebDriverWait(driver, 30)
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Default ESS')]")));
		
		
		
		tc.adminRoll();
		logger.info("Click adminroll");
		Thread.sleep(6000);
		
		tc.selectAdminRoll();
		logger.info("Select adminRoll");
		Thread.sleep(6000);
		
		
		
	}

}
