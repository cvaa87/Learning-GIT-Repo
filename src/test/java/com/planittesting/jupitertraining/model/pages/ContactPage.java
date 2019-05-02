package com.planittesting.jupitertraining.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage
{

	public ContactPage(WebDriver driver) 
	{
		super(driver);
		
		
	}
    public void clickSubmit()
    {
    	driver.findElement(By.cssSelector(".form-actions a")).click();
    	
    }
    public String getForenameError()
    {
    	//return driver.findElements(By.id("forename-err")).getText();
    	var elements=driver.findElements(By.id("forename-err"));
    	if(elements.isEmpty())
    	{
    		return("");
    		
    	}
    	return elements.get(0).getText();
    }
    public String getEmailError()
    {
    	//return driver.findElement(By.id("email-err")).getText();
    	var elements=driver.findElements(By.id("email-err"));
    	if(elements.isEmpty())
    	{
    		return("");
    		
    	}
    	return elements.get(0).getText();
    }
    public String getMessageError()
    {
    	//return driver.findElement(By.id("message-err")).getText();
    	var elements=driver.findElements(By.id("message-err"));
    	if(elements.isEmpty())
    	{
    		return("");
    		
    	}
    	return elements.get(0).getText();
    }
    
    public void setForename(String forename)
    {
    	driver.findElement(By.id("forename")).sendKeys(forename);
    }
    public void setSurname(String surname)
    {
    	driver.findElement(By.id("surname")).sendKeys(surname);
    }
    public void setEmail(String email)
    {
    	driver.findElement(By.id("email")).sendKeys(email);
    }
    public void setTelephone(String telephone)
    {
    	driver.findElement(By.id("telephone")).sendKeys(telephone);
    }
    public void setMessage(String message)
    {
    	driver.findElement(By.id("message")).sendKeys(message);
    }
    public String getSuccessmessage()
    {
    	WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".alert.alert-success"))));
		return driver.findElement(By.cssSelector(".alert.alert-success")).getText();
    }

}


