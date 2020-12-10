package org.automation.pages;

import java.io.IOException;

import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUsername(String username) throws IOException
	{
		driver.findElement(By.xpath(Utility.fetchLocatorValue("login_username_xpath"))).sendKeys(username);
		
	}
	
	public void enterPassword(String password) throws IOException
	{
		driver.findElement(By.xpath(Utility.fetchLocatorValue("login_password_xpath"))).sendKeys(password);
	}
	
	public void clickSignin() throws IOException
	{
		driver.findElement(By.xpath(Utility.fetchLocatorValue("login_button_xpath"))).click();
	}
	


}
