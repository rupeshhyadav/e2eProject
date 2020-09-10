package tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

public class base {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver intialize() throws IOException
	
	{
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/hungerbox/eclipse-workspace/log4jRupes/src/main/resources/env.properties");
		prop.load(fis);
		//String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser");
		String urlName = prop.getProperty("urlName");
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "//Users//hungerbox//Downloads//chromedriver 3");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
{
			System.out.println("headless 123");
			options.addArguments("headless");
			
			}
			driver = new ChromeDriver(options);
			
		}else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "///Users//hungerbox//Downloads//geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	    return driver;
		
	}
	
	public String getScreenShotPath(String methodName, WebDriver driver) throws IOException
	{
		
		System.out.println(methodName);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentUsersHomeDir = System.getProperty("user.dir");
		System.out.println(currentUsersHomeDir);
		String destFile = System.getProperty("user.dir")+"//reports//"+methodName+".png";
		FileUtils.copyFile(src, new File(destFile));
		return destFile;
		
		
	
	}
}
