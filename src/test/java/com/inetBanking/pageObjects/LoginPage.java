package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration
	@FindBy(name="uid")
	WebElement usernameTxt;
	
	@FindBy(name="password")
	WebElement passwordTxt;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logoutBtn;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void setUsername(String username)
	{
		usernameTxt.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		passwordTxt.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		loginBtn.click();
	}
	
	public void clickLogout()
	{
		logoutBtn.click();
	}
}
