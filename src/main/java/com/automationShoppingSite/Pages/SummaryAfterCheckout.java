package com.automationShoppingSite.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationShoppingSite.BasePackage.ShoppingTestBase;

public class SummaryAfterCheckout extends ShoppingTestBase{
	
	public SummaryAfterCheckout () {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css="i[class='icon-trash']")
	WebElement deleteIcon;
	
	public CartSummaryPage deleteItem() {
		deleteIcon.click();
		return new CartSummaryPage();
		
	}

}
