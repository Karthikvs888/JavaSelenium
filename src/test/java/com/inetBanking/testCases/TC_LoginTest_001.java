package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	/*
	@Test // Screenshot for script failure due to locator issues or some other reasons before validation is not taken hence it is recommended to use try catch block
	public void loginTest() throws IOException, InterruptedException
	{		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePag"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			//captureScreenShot(driver, "loginTest");
			//Thread.sleep(2000);
			Assert.assertTrue(false); 	
		}	
	}
	*/
	
	@Test
	public void loginTest() throws IOException, InterruptedException
	{	
		
		try {
			
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(username);
			lp.setPassword(password);
			lp.clickSubmit();
			System.out.println(driver.getTitle());
			
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			{
				Assert.assertTrue(true);
			}
		} 
		
		catch (Exception e) 
		{
			captureScreenShot(driver, "loginTest");
			Assert.assertTrue(false); 	
		}	
	}
}


