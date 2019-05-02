package com.planittesting.jupitertraining.tests;

import org.junit.jupiter.api.Test;

import com.planittesting.jupitertraining.model.pages.HomePage;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;

public class LoginTests extends BaseTests {
	
	@Test
	
	public void ValidateLogin()
	{
		var homePage = new HomePage(driver);
		var loginDialog=homePage.clickLoginMenuButton();
		var username="Siva";
		loginDialog.setUsername(username);
		loginDialog.setPassword("letmein");
		loginDialog.setCheckbox();
		loginDialog.clickLoginButton();
		assertEquals(username, homePage.getLoggedInUser());
		var logoutDialog = homePage.clickLogOutButton();
		logoutDialog.clickLogOut();
	}

}
