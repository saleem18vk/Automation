package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src =new File("./Configuration/config.properties");
	//	File src =new File("D:\\Automation\\SampleProject\\Configuration\\config.properties");
		
		try {
			FileInputStream fl=new FileInputStream(src);
			pro=new Properties();
			pro.load(fl);
		}catch(Exception e){
			System.out.println("Exception message: "+ e.getMessage());
		}
		
		
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}

}
