package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd)
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		if (isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			System.out.println("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			System.out.println("Login Passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	//Method to check weather alert is present or not
	public boolean isAlertPresent()
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String [][]getData() throws IOException
	{
		//String path = "E:/Workspace/BankingProject/inetBanking/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		
		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		System.out.println("Number of rows: " + rowNum);
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		System.out.println("Number of columns: " + colCount);

		String loginData[][] = new String[rowNum][colCount];
		
		// Outer for loop represents rows & Inner for loop represents every column of particular row
		for (int i = 1; i <= rowNum ; i++) 
		{
			for (int j = 0; j < colCount; j++)
			{
				 loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j); // 1 0
			}
		}
		return loginData;
	}
}
