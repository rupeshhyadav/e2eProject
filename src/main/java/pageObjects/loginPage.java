package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver;
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By email = By.id("user_email");
	By pwd = By.id("user_password");
	By submit = By.xpath("//input[@type='submit']");
	

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getpwd()
	{
		return driver.findElement(pwd);
	}
	public WebElement getsubmit()
	{
		return driver.findElement(submit);
	}
}
