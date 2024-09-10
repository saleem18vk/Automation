package com.banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	
WebDriver ldriver;
	
	public NewCustomer (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH,using="//html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement Clic_kNewCustomer;
	
	@FindBy(how=How.XPATH,using="//input[@name='name']")
	@CacheLookup
	WebElement Customer_Nmae;
	
	@FindBy(how=How.XPATH,using="//input[@name='rad1'][1]")
	@CacheLookup
	WebElement Gender;
	
	@FindBy(how=How.XPATH,using="//input[@name='rad1'][1]")
	@CacheLookup
	WebElement DOB;
	
	@FindBy(how=How.XPATH,using="//textarea[@name='addr']")
	@CacheLookup
	WebElement Address;
	
	@FindBy(how=How.XPATH,using="//input[@name='city']")
	@CacheLookup
	WebElement City;
	
	@FindBy(how=How.XPATH,using="//input[@name='state']")
	@CacheLookup
	WebElement State;
	
	@FindBy(how=How.XPATH,using="//input[@name='pinno']")
	@CacheLookup
	WebElement ZipCode;
	
	@FindBy(how=How.XPATH,using="//input[@name='telephoneno']")
	@CacheLookup
	WebElement PhoneNum;
	
	@FindBy(how=How.XPATH,using="//input[@name='emailid']")
	@CacheLookup
	WebElement Email;
	
	@FindBy(how=How.XPATH,using="//input[@value='Submit']")
	@CacheLookup
	WebElement Sbubmit;
	
	public void clickNewCustomer()
	{
		Clic_kNewCustomer.click();
	}
	
	public void customerNmae(String nme)
	{
		Customer_Nmae.sendKeys(nme);
	}
	
	public void gEnder()
	{
		Gender.click();
	}
	
	public void dateOfBirth(String mm, String dd, String yyyy )
	{
		DOB.sendKeys(mm);
		DOB.sendKeys(dd);
		DOB.sendKeys(yyyy);
	}
	
	public void aDdress(String adrs)
	{
		Address.sendKeys(adrs);
	}
	
	public void custCity(String cty)
	{
		City.sendKeys(cty);
	}
	
	public void custState(String st)
	{
		State.sendKeys(st);
	}
	
	public void pinCode(String poc)
	{
		//Note: pin code accepting integer values only, 
		//we need to convert integer to String by using ..String.valueOf() method
		ZipCode.sendKeys(String.valueOf(poc));
	}
	
	public void phoneNumber(String pn)
	{
		PhoneNum.sendKeys(pn);
	}
	
	public void eMail(String eml)
	{
		Email.sendKeys(eml);
	}
	
	public void custSbubmit()
	{
		Sbubmit.click();
	}
	
}
