package com.planittesting.jupitertraining.model.products;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.planittesting.jupitertraining.model.ui.Table;

public class Product {
	
	//String product_title;
	//String product_price;
	
	private WebElement e;
	
	public Product(WebElement e)
	{   
        this.e=e;
		//product_title=e.findElement(By.cssSelector(".product-title")).getText();
		//product_price=e.findElement(By.cssSelector(".product-price")).getText().replace("$","");
	}
	public Product(Optional<WebElement> findFirst) {
		// TODO Auto-generated constructor stub
	}
	public  String getTitle()
	{
		return e.findElement(By.cssSelector(".product-title")).getText();
	}
	public  double getPrice()
	{
		String product_price=e.findElement(By.cssSelector(".product-price")).getText().replace("$","");
		
		return Double.parseDouble(product_price);
		
	}
	 public void clickBuyButton()
	    {
	    	    	
	    		   e.findElement(By.cssSelector(".btn.btn-success")).click();
	    		   
	    	
	    }

}
