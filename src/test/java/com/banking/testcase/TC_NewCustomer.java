package com.banking.testcase;


import org.testng.annotations.Test;

import com.banking.pageobjects.LoginPage;
import com.banking.pageobjects.NewCustomer;

public class TC_NewCustomer extends BaseClass {
	
	@Test
	public void AddNewCustomer() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUser(username);
		lp.setPwd(password);
		lp.userLogin();
		
		Thread.sleep(2000);
		
		NewCustomer addcust=new NewCustomer(driver);
		
		addcust.clickNewCustomer();
		addcust.customerNmae("Jai");
		addcust.gEnder();
		addcust.dateOfBirth("05", "15", "2000");
		addcust.aDdress("HYD");
		addcust.custCity("HYD");
		addcust.custState("HYD");
		addcust.pinCode("525254");
//		addcust.phoneNumber("9000000000");
		
		String num="9"+randomnum();
		addcust.phoneNumber(num);
		
		
		String email=randomstring()+"@gmail.com";
		addcust.eMail(email);
//		addcust.eMail("jai123@gmail.com");
		
		Thread.sleep(10000);
		
		addcust.custSbubmit();
		
		Thread.sleep(5000);
		
				
	}
}
