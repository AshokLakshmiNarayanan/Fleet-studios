package com.plaintiff.testCases;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.plaintiff.pageObjects.LawSuitPage;

public class TC01 extends BaseClass
{
	@Test
	public void getPlaintiffDetails()
	{
		driver.get(urlLawsuits);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LawSuitPage law = new LawSuitPage(driver);
		ArrayList<String> pt = law.getplaintiff();
		ArrayList<String> dn = law.getDependentName();
		System.out.println(pt);
		System.out.println(dn);
		for(int i=0 ; i<pt.size() ; i++)
		{
			System.out.println("Plaintiff Name: "+pt.get(i));
			System.out.println("Dependent Name: "+dn.get(i));
			System.out.println("");
		}
		
		if(15 == pt.size())
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
}
