package com.planittesting.jupitertraining.model.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginDialog {
	
	//Root element-Base point of the page
	WebElement rootElement;
	
	public LoginDialog(WebElement rootElement)
	{
		this.rootElement=rootElement;
	}

	public void setUsername(String username)
	{
		rootElement.findElement(By.id("loginUserName")).sendKeys(username);
		
	}
	public void setPassword(String password)
	{
		rootElement.findElement(By.id("loginPassword")).sendKeys(password);
		
	}
	public void setCheckbox()
	{
		rootElement.findElement(By.id("agree")).click();
	}
    public void clickLoginButton()
    {
    	rootElement.findElement(By.cssSelector(".btn.btn-primary")).click();
    }
    
}
