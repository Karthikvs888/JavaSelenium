package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
//	public String baseURL  = "https://demo.guru99.com/v3/index.php";
//	public String username  = "mngr471486";
//	public String password  = "udEjuda";
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL  = readConfig.getApplicationURL();
	public String username  = readConfig.getUsername();
	public String password  = readConfig.getPassword();
	
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		if (br.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		else if (br.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		else if(br.equals("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		else
		{
			System.out.println("Enter a valid browser name");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	/*
	@AfterMethod  
    public void screenShot(ITestResult result) {
  
        // ITestResult.FAILURE is equals to result.getStatus then it enter into
        // if condition
                         
    if (ITestResult.FAILURE == result.getStatus()) {
            try 
            {
            	
            	Date d = new Date();
                String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
                
            	TakesScreenshot ts = (TakesScreenshot) driver;
        		File source = ts.getScreenshotAs(OutputType.FILE);
        		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + result.getName() + FileName);
        		FileUtils.copyFile(source, target);
        		
        	    java.util.Date date = new java.util.Date();    
                System.out.println("Successfully captured a screenshot at" + date);
            } 
            catch (Exception e)
            {
                    System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
    */
	
	public void captureScreenShot(WebDriver driver, String tname) throws IOException {
		
		Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + FileName);
		FileUtils.copyFile(source, target);
		
	    java.util.Date date = new java.util.Date();    
		System.out.println("Screenshot taken :" + tname + date);
		
		/*
		TakesScreenshot ts2 = (TakesScreenshot) driver;
		File source1 = ts2.getScreenshotAs(OutputType.FILE);
		Files.copy(source1, new File("/Screenshots/" + tname + FileName));
		java.util.Date date = new java.util.Date();    
		System.out.println("Screenshot taken :" + tname + date);		
		*/
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
