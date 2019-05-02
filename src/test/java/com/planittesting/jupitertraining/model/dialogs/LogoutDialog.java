package com.planittesting.jupitertraining.model.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoutDialog {
	

    WebElement rootElement;
	public LogoutDialog(WebElement rootElement)
	{
		
		this.rootElement=rootElement;
    }
    public void clickLogOut()
    {
    	rootElement.findElement(By.className("btn-success")).click();
    }




}

