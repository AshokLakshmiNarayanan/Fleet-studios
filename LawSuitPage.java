package com.plaintiff.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LawSuitPage 
{
	WebDriver ldriver;
	
	public LawSuitPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	List<WebElement> plaintiff = ldriver.findElements(By.cssSelector("div.equal_content"));
	
	public ArrayList<String> getplaintiff()
	{
		ArrayList<String> pt = new ArrayList<String>();
		for(int i=0;i<plaintiff.size();i++)
		{
			pt.add(plaintiff.get(i).getText().split("Filing")[0].split("Name: ")[1].trim());
		}
		System.out.println("getplaintiff");
		return pt;
	}
	
	public ArrayList<String> getDependentName()
	{
		ArrayList<String> dn = new ArrayList<String>();
		for(int i=0;i<plaintiff.size();i++)
		{
			dn.add(plaintiff.get(i).getText().split("Defendant Name: ")[1].replace(".", "").trim());
		}
		System.out.println("getDependentName");
		return dn;
	}
	
}
