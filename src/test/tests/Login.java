package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;

public class Login extends base
{
	public static Logger log = LogManager.getLogger(Login.class.getName());
	
	@BeforeTest
	public void preRun() throws IOException 
	{
		driver = intialize();
		
		log.info("url opened successfully");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("browser closed");
	}
	
	@Test(dataProvider="getData")
	public void loginCase(String un, String pwd) throws IOException
	{
		
		driver.get("http://www.qaclickacademy.com/");
		landingPage lp = new landingPage(driver);
		lp.getLogin().click();
		log.info("clicked login button successfully");
		loginPage l = new loginPage(driver);
		l.getEmail().sendKeys(un);
		l.getpwd().sendKeys(pwd);
		log.info(un + " " + pwd);
		l.getsubmit().click();
		
	}
	@DataProvider
	public Object[][] getData(){
		{
			Object[][] data = new Object[2][2];
			data[0][0] = "rupesh@hungerbox.com";
			data[0][1] = "123";
			data[1][0] = "rupesh1@hungerbox.com";
			data[1][1] = "123";
			return data;
		}
	}

}

