package com.automationShoppingSite.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationShopping.BasePackage.ShoppingTestBase;
import com.automationShoppingSite.Utils.Utils;

public class WomenTabPage extends ShoppingTestBase{
	public WomenTabPage () {
		PageFactory.initElements(wd, this);
	}
	@FindBy(css="img[title='Faded Short Sleeve T-shirts']")
	WebElement quickview;
	
	public AddToCart quickViewClick() {

		quickview.click();
		wd.switchTo().frame(0);

		return new AddToCart();
	}
	
	
	 
		
		
	}
	
	
	
		
	
	

	
	

	
	

	
	
	
	
	

