package com.planittesting.jupitertraining.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;

import com.planittesting.jupitertraining.model.pages.ContactPage;
import com.planittesting.jupitertraining.model.pages.HomePage;

public class ContactPageTests extends BaseTests{
	
	@Test
	
	public void Validatemandatoryerrors()
	{
		var homePage = new HomePage(driver);
		homePage.clickContactMenu();
		var contactPage = new ContactPage(driver);
		contactPage.clickSubmit();
		assertEquals("Forename is required", contactPage.getForenameError());
		assertEquals("Email is required", contactPage.getEmailError());
		assertEquals("Message is required", contactPage.getMessageError());
	
		contactPage.setForename("Siva");
		contactPage.setEmail("cvaa87@gmail.com");
		contactPage.setMessage("This is a test");
		assertEquals("", contactPage.getForenameError());
		assertEquals("", contactPage.getEmailError());
		assertEquals("", contactPage.getMessageError());
	}

	
	@Test
	
	public void Validatemail()
	{
		var homePage = new HomePage(driver);
		homePage.clickContactMenu();
		var contactPage = new ContactPage(driver);
		
		contactPage.setEmail("cvaa87");
		assertEquals("Please enter a valid email", contactPage.getEmailError());
	
	}

	@Test
	public void Validsubmission()
	{
		var homePage = new HomePage(driver);
		homePage.clickContactMenu();
		var contactPage = new ContactPage(driver);
		var fname="Siva";
		contactPage.setForename(fname);
		contactPage.setSurname("Prem");
		contactPage.setEmail("cvaa87@gmail.com");
		contactPage.setTelephone("0298754632");
		contactPage.setMessage("This is a test");
		contactPage.clickSubmit();
			
		assertEquals("Thanks "+fname+", we appreciate your feedback.",contactPage.getSuccessmessage());
		
	}

}
