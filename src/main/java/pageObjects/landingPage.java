package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	
	By login = By.xpath("//span[contains(text(),'Login')]");
	By centerText = By.xpath("//div[@class='text-center']/h2");
	By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	public WebDriver driver;
	
	
	
	public landingPage(WebDriver driver) {
		
		this.driver = driver;
	}


	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement getcenterText()
	{
		return driver.findElement(centerText);
	}
	
	public WebElement getnavBar()
	{
		return driver.findElement(navBar);
	}
}
