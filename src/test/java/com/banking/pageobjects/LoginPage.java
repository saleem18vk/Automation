package com.banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement userid;
	
	@FindBy(name="password")
	WebElement userpwd;
	
	@FindBy(name="btnLogin")
	WebElement login;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[10]/a")
	WebElement logout;
	
	
	
	public void setUser(String name)
	{
		userid.sendKeys(name);
	}
	
	public void setPwd(String pwd)
	{
		userpwd.sendKeys(pwd);
	}
	
	public void userLogin()
	{
		login.click();
	}
	
	public void userLogout()
	{
		logout.click();
	}
	
	

}
