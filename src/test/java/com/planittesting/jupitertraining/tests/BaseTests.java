package com.planittesting.jupitertraining.tests;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Execution(ExecutionMode.CONCURRENT)
public class BaseTests {
	
	protected WebDriver driver;
	
	@RegisterExtension
	AfterEachProcessor afterEachProcessor = new AfterEachProcessor();
	
	@BeforeEach
	public void setupTest()
	{
		//var options = new ChromeOptions();
		//options.setHeadless(true);
		//options.addArguments("--disable-gpu","--window-size=1920,1200","--ignore-certificate-errors");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://jupiter2.cloud.planittesting.com/#/");
	}
	@AfterEach
	public void ShutDownTest()
	{
		afterEachProcessor.setDriver(driver);
		
		//driver.close();
	}

			
}
