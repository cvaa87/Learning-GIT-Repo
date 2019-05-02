package com.planittesting.jupitertraining.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.planittesting.jupitertraining.model.dialogs.RemoveItemDialog;
import com.planittesting.jupitertraining.model.pages.CartPage;
import com.planittesting.jupitertraining.model.pages.HomePage;
import com.planittesting.jupitertraining.model.pages.ShopPage;
import com.planittesting.jupitertraining.model.products.CompareByTitle;
import com.planittesting.jupitertraining.model.products.Product;
import com.planittesting.jupitertraining.model.ui.Table;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;


public class ShopPageTests extends BaseTests {
	
	@Test
	@Disabled
	public void VerifyPriceOfToys()
	{
		var homePage = new HomePage(driver);
		homePage.clickShopButton();
		var shopPage = new ShopPage(driver);
		String toyname = "Funny Cow";
		double toyprice = 9.99;
		var product = shopPage.getProduct(new CompareByTitle(toyname));
		assertEquals(toyprice, product.getPrice());
		
		
	}
    
	@Test
	@Disabled
	public void CountInCart()
	{
		var homePage = new HomePage(driver);
		homePage.clickShopButton();
		var shopPage = new ShopPage(driver);
		String toyname = "Funny Cow";
		var product = shopPage.getProduct(new CompareByTitle(toyname));
		int numberoftoys=3;
    	for(int i=0;i< numberoftoys;i++)
    	{
		product.clickBuyButton();
    	}
		assertEquals(numberoftoys, shopPage.cartCount());
	}
	
	
	@Test
	@Disabled
	public void VerifyPriceInTable()
	{
		var homePage = new HomePage(driver);
		homePage.clickShopButton();
		var shopPage = new ShopPage(driver);
		String toyname = "Smiley Bear";
		var product = shopPage.getProduct(new CompareByTitle(toyname));
		Double pp_price= product.getPrice();
		product.clickBuyButton();
		homePage.clickCartButton();
	    CartPage cp=new CartPage(driver);
		cp.getProductPrice(toyname);
	    assertEquals(pp_price,cp.getProductPrice(toyname));
		
    	
	}
	
	@Test
	@Disabled
	public void VerifySubTotal()
	{
		var homePage = new HomePage(driver);
		homePage.clickShopButton();
		var shopPage = new ShopPage(driver);
		String toyname = "Smiley Bear";
		var product = shopPage.getProduct(new CompareByTitle(toyname));
		int numberoftoys=2;
		for(int i=0;i< numberoftoys;i++)
    	{
		product.clickBuyButton();
		}  	  	
    	double expectedtotal=27.98;  	   	
    	homePage.clickCartButton();
	    CartPage cp=new CartPage(driver);
		assertEquals(expectedtotal,cp.getProductSubTotal(toyname));
			
	}
	@Test
	@Disabled
	public void VerifyTotal()
	{
		var homePage = new HomePage(driver);
		homePage.clickShopButton();
		var shopPage = new ShopPage(driver);
		
		String toyname = "Smiley Bear";
		var product = shopPage.getProduct(new CompareByTitle(toyname));
		//Double pp_price= product.getPrice();
		int numberoftoys=2;
		double Etotal=0;
    	for(int i=0;i< numberoftoys;i++)
    	{
		product.clickBuyButton();
		Etotal+=(product.getPrice());
    	}
    	
    	toyname = "Funny Cow";
		product = shopPage.getProduct(new CompareByTitle(toyname));
		//pp_price= product.getPrice();
		numberoftoys=2;
    	for(int i=0;i< numberoftoys;i++)
    	{
		product.clickBuyButton();
		Etotal+=(product.getPrice());
    	}    		   	
    	homePage.clickCartButton();
	    CartPage cp=new CartPage(driver);
		assertEquals(Etotal,cp.getTotal());
		
	}
	@Test
	@Disabled
	public void RemoveItemInCart()
	{
		var homePage = new HomePage(driver);
		homePage.clickShopButton();
		var shopPage = new ShopPage(driver);
		
		String toyname = "Smiley Bear";
		var product = shopPage.getProduct(new CompareByTitle(toyname));
		//Double pp_price= product.getPrice();
		int numberoftoys=2;
		for(int i=0;i< numberoftoys;i++)
    	{
		product.clickBuyButton();
    	}
    	homePage.clickCartButton();
	    CartPage cp=new CartPage(driver);
	    cp.RemoveCartItem(toyname);
	    cp.RemoveItemPopUp().AgreeToRemoveItem();
	        	
	}
	@Test
	public void VerifyRemovedItemNotInCart()
	{
		var homePage = new HomePage(driver);
		homePage.clickShopButton();
		var shopPage = new ShopPage(driver);
		
		String toyname = "Smiley Bear";
		var product = shopPage.getProduct(new CompareByTitle(toyname));
		int numberoftoys=2;
		for(int i=0;i< numberoftoys;i++)
    	{
		product.clickBuyButton();
    	}
		
		toyname = "Funny Cow";
		product = shopPage.getProduct(new CompareByTitle(toyname));
		numberoftoys=2;
    	for(int i=0;i< numberoftoys;i++)
    	{
		product.clickBuyButton();
		
    	}    		   	
		
    	toyname = "Fluffy Bunny";
		product = shopPage.getProduct(new CompareByTitle(toyname));
		numberoftoys=2;
    	for(int i=0;i< numberoftoys;i++)
    	{
		product.clickBuyButton();
		
    	}  
		
    	homePage.clickCartButton();
	    CartPage cp=new CartPage(driver);
	    cp.RemoveCartItem("Smiley Bear");
	    cp.RemoveItemPopUp().AgreeToRemoveItem();
	    assertTrue(cp.VerifyItemRemoved());
	        	
	}
}
