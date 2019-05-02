package com.planittesting.jupitertraining.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.planittesting.jupitertraining.model.dialogs.LoginDialog;
import com.planittesting.jupitertraining.model.dialogs.LogoutDialog;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		
	}
    public void clickContactMenu()
    {
    	driver.findElement(By.cssSelector("#nav-contact a")).click();
    }
    public LoginDialog clickLoginMenuButton()
	{
		driver.findElement(By.cssSelector("li#nav-login")).click();
		return new LoginDialog(driver.findElement(By.className("popup")));
	}
    public String getLoggedInUser()
	{
		return driver.findElement(By.cssSelector(".user")).getText();
		
	}
    public LogoutDialog clickLogOutButton()
    {
    	driver.findElement(By.className("action")).click();
    	return new LogoutDialog(driver.findElement(By.className("popup")));
    }
    public void clickShopButton()
    {
    	driver.findElement(By.cssSelector("li#nav-shop")).click();
    }
    public void clickCartButton()
    {
    	driver.findElement(By.id("nav-cart")).click();
    }
}
