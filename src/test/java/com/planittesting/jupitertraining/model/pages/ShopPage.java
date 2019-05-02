package com.planittesting.jupitertraining.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.planittesting.jupitertraining.model.products.CompareByTitle;
import com.planittesting.jupitertraining.model.products.CompareProduct;
import com.planittesting.jupitertraining.model.products.Product;

public class ShopPage extends BasePage {

	public ShopPage(WebDriver driver) {
		super(driver);
		
	}
    public Product getProduct(CompareProduct cp)
    {
    	var elements=driver.findElements(By.cssSelector(".product"));
    
    	 return new Product(elements.stream().filter(e->cp.Compare(new Product(e))).findFirst().orElseThrow());
    }
   
    public int cartCount()
    { 
    	String count=driver.findElement(By.cssSelector(".cart-count")).getText();
    	return Integer.parseInt(count);
    }
}
