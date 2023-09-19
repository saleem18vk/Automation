package com.banking.utilities;

//listener class used to generate extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class Reporting extends TestListenerAdapter {
	

//	public ExtentSparkReporter htmlReporter; //ExtentHtmlReporter
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testcontext)
	{
		
		String timeStamp=new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date()); //time stamp
		String repName="Test-Report"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName); //specific location of the report
		
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
//		try {
//			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Envirinment", "QA");
		extent.setSystemInfo("User", "Saleem");
		
		htmlReporter.config().setDocumentTitle("eBanking project");	// Title of project
		
		htmlReporter.config().setReportName("Automation Report"); //Name of the Report
	//	htmlReporter.config().setTestViewChartLocation(ChartLocation.Top); //location of the chart
		
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); //create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); //send the passed information to the report with GREEN color highlighted
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); //create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); //send the passed information to the report with RED color highlighted
		
//		BaseClass bs=new BaseClass();
//		
//		String timeStamp=new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date()); //time stamp
//    	String test_name=tr.getName();
//		
//		String ScreenShotPath=null;
//		
//		
//		ScreenShotPath =bs.captureScreen(driver, test_name);
		
		
		
		String ScreenShotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f=new File(ScreenShotPath);
		
		if(f.exists())
		{
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(ScreenShotPath));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); //create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

}
