package com.planittesting.jupitertraining.model.ui;

import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.planittesting.jupitertraining.model.dialogs.RemoveItemDialog;

public class Table {

	private WebElement rootelement;

	public Table(WebElement rootelement)
	{
		this.rootelement=rootelement;
	}
	
	public String FindTableCellValue(String searchcoloumn,String searchvalue,String resultcoloumn)
	{
		List<WebElement> tableheader=rootelement.findElements(By.tagName("th"));
		int searchindex=0;
		int resultindex=0;
		int i;
		for(i=0;i<tableheader.size();i++)
		{
			String c=tableheader.get(i).getText();
			if(c.contentEquals(searchcoloumn))
			{
				 searchindex=i;
			}
		
			if(c.contentEquals(resultcoloumn))
			{
				resultindex=i;
			}
			
		}
		
		List<WebElement> tablerows=rootelement.findElements(By.tagName("tr"));
		for(int j=1;j<tablerows.size();j++)
		{
			
			var coloumn = tablerows.get(j).findElements(By.tagName("td"));
		    String sc = coloumn.get(searchindex).getText();
		    if(sc.equals(searchvalue))
		    {
		    	 resultcoloumn = coloumn.get(resultindex).getText();
		    	 break;
		    }
					
			
		}
		return resultcoloumn;
	}
	
	
	public String Total()
	{
		String total=rootelement.findElement(By.cssSelector(".total")).getText();
		return total;
		
	}
	public void RemoveItemFromCart(String searchcoloumn,String searchvalue,String resultcoloumn)
	{
		List<WebElement> tableheader=rootelement.findElements(By.tagName("th"));
		int searchindex=0;
		int resultindex=0;
		int i;
		for(i=0;i<tableheader.size();i++)
		{
			String c=tableheader.get(i).getText();
			if(c.contentEquals(searchcoloumn))
			{
				 searchindex=i;
			}
		
			if(c.contentEquals(resultcoloumn))
			{
				resultindex=i;
			}
			
		}
		
		List<WebElement> tablerows=rootelement.findElements(By.tagName("tr"));
		for(int j=1;j<tablerows.size();j++)
		{
			
			var coloumn = tablerows.get(j).findElements(By.tagName("td"));
		    String sc = coloumn.get(searchindex).getText();
		    if(sc.equals(searchvalue))
		    {
		    	 coloumn.get(resultindex).findElement(By.cssSelector(".remove-item")).click();
		    	 break;
		    }
					
			
		}
		
	}
	public boolean VerifyRemoveItemFromCart(String searchcoloumn,String searchvalue)
	{
		List<WebElement> tableheader=rootelement.findElements(By.tagName("th"));
		int searchindex=0;
		int i;
		for(i=0;i<tableheader.size();i++)
		{
			String c=tableheader.get(i).getText();
			if(c.contentEquals(searchcoloumn))
			{
				 searchindex=i;
			}			
			
		}
		
		System.out.println("searchindex : "+searchindex );
		
		
		List<WebElement> tablerows=rootelement.findElements(By.tagName("tr"));
		
		System.out.println( "tablerows.size " + tablerows.size());
		for(int j=1;j<tablerows.size()-2;j++)
		{
			System.out.println(j);
			var coloumn = tablerows.get(j).findElements(By.tagName("td"));
		    String sc = coloumn.get(searchindex).getText();
		    
		    
		    if(sc.equals(searchvalue))
		    {
		    	 System.out.println(searchvalue+"is not removed from cart");
		    	 return false;
		    }
		    
			
		}
		
		System.out.println(searchvalue+" is removed from cart");
		return true;	
	}
	
}
