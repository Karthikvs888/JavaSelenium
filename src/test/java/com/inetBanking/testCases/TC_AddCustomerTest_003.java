package com.inetBanking.testCases;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		
		try 
		{
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(username);
			lp.setPassword(password);
			lp.clickSubmit();
			
			Thread.sleep(3000);
			
			AddCustomerPage addcust = new AddCustomerPage(driver);
			
			addcust.clickAddNewCustomer(); // After this click manually close the ad
			
			Robot robot = new Robot();	
	        robot.mouseMove(800, 200); // move mouse point to specific location	
	        robot.delay(1500);        // delay is to make code wait for mentioned milliseconds before executing next step	
	        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click	
	        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click	
			
			addcust.custName("Pavan");
			addcust.custgender("male");
			addcust.custdob("10","15","1985");
			Thread.sleep(5000);
			addcust.custaddress("INDIA");
			addcust.custcity("HYD");
			addcust.custstate("AP");
			addcust.custpinno("5000074");
			addcust.custtelephoneno("987890091");
			
			String email=randomestring()+"@gmail.com";
			addcust.custemailid(email);
			addcust.custpassword("abcdef");
			addcust.custsubmit();
			
			Thread.sleep(3000);
					
			boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
			
			if(res==true)
			{
				Assert.assertTrue(true);
				
			}
		} 
		catch (Exception e)
		{
			captureScreenShot(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}

}
