package com.plaintiff.testCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	public String urlLawsuits = "https://www.accessibility.com/digital-lawsuits";
	public static WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java Basic program\\FleetStudio\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("setup");
	}
	
	@AfterMethod
	public void screenShot(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			try
			{
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("D:\\Java Basic program\\FleetStudio\\Screenshot\\"+result.getName()+".png"));
				System.out.println("captured Failed page screenshot");
			}
			catch (Exception e)
			{
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}
		}
	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
		System.out.println("Close");
	}
}
