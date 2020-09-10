package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.landingPage;

public class assertValidation extends base {
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(assertValidation.class.getName());
	
	@BeforeTest
	public void preRun() throws IOException 
	{ 
		driver = intialize();
		driver.get("http://www.qaclickacademy.com/");
		log.info("url opened successfully");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("browser closed");
	}
	@Test
	public void validateText()
	{
		landingPage lp = new landingPage(driver);
		String cText = lp.getcenterText().getText();
		String eText = "FEATURED COURSESQW";
		System.out.println(cText);
		Assert.assertEquals(cText, eText);
		log.info("text matched");
			
	}

}
