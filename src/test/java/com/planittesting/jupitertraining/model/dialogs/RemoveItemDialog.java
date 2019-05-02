package com.planittesting.jupitertraining.model.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RemoveItemDialog {

	WebElement rootelement;
	
	public RemoveItemDialog(WebElement rootelement)
	{
		this.rootelement=rootelement;
	}
	public void AgreeToRemoveItem()
	{
		rootelement.findElement(By.cssSelector(".btn.btn-success")).click();
	}
	public void DismissRemoveItem()
	{
		rootelement.findElement(By.cssSelector(".btn.btn-cancel")).click();
	}
}
