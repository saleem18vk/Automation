package com.banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRM_Login {

	
WebDriver ldriver;
	
	public HRM_Login (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@name='txtUsername']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='txtPassword']")
	WebElement userpwd;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement userlogin;
	
	
	@FindBy(xpath="(//span[contains(text(),'HR Administration')])[1]")
	WebElement HRadmin;
	
	@FindBy(xpath="//i[normalize-space()='add']")
	WebElement adduser;
	
	@FindBy(xpath="//input[@id='selectedEmployee_value']")
	WebElement addemployename;
	
	@FindBy(xpath="//input[@id='user_name']")
	WebElement employeusername;
	
	@FindBy(xpath="//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button")
	WebElement adminroll;
	
	@FindBy(xpath="//span[normalize-space()='Global Admin']")
	WebElement selectadminroll;
	
	
	public void setUser(String name)
	{
		username.sendKeys(name);
	}
	
	public void setPassword(String name)
	{
		userpwd.sendKeys(name);
	}
	
	public void setLogin()
	{
		userlogin.click();
	}
	
	public void clickHRAdmin()
	{
		HRadmin.click();;
	}
	
	public void clickAddUser()
	{
		adduser.click();;
	}
	
	public void employeName(String nme)
	{
		addemployename.sendKeys(nme);
	}
	
	public void employeUserName(String user)
	{
		employeusername.sendKeys(user);
	}
	
	public void adminRoll()
	{
		adminroll.click();
	}
	
	public void selectAdminRoll()
	{
		selectadminroll.click();
	}
	
}
