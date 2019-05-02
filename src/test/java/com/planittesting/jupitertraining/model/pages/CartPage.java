package com.planittesting.jupitertraining.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.planittesting.jupitertraining.model.dialogs.RemoveItemDialog;
import com.planittesting.jupitertraining.model.ui.Table;

public class CartPage extends BasePage {

	public Table cartTable;
	public CartPage(WebDriver driver) {
		super(driver);
	
	cartTable= new Table(driver.findElement(By.cssSelector(".table.table-striped.cart-items")));
		
	}

	public double getProductPrice(String toyname)
	{
		var price = Double.parseDouble((cartTable.FindTableCellValue("Item",toyname,"Price")).replace("$", ""));
		return price;
		//return Double.parseDouble(price.replace("$", ""));
		
	     
	}
	public double getProductSubTotal(String toyname)
	{
		var subtotal = Double.parseDouble(cartTable.FindTableCellValue("Item",toyname,"Subtotal").replace("$","")); 
		return subtotal;
	}
    public double getTotal()
    {
    	var total = Double.parseDouble(cartTable.Total().replace("Total:",""));
    	return total;
    }
    public void RemoveCartItem(String toyname)
    {
    	cartTable.RemoveItemFromCart("Item", toyname, "Actions");
    	    	
    }
    public RemoveItemDialog RemoveItemPopUp()
    {
    	return new RemoveItemDialog(driver.findElement(By.cssSelector(".popup.modal.hide.ng-scope.in")));
    }
    public String getCartEmptyMessage()
    {
    	 return driver.findElement(By.cssSelector(".alert")).getText();
    }
    public boolean VerifyItemRemoved()
    {
    	var result = cartTable.VerifyRemoveItemFromCart("Item","Smiley Bear");
    	return result;
    }
}
