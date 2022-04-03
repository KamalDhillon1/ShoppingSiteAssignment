package com.automationShoppingSite.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationShoppingSite.BasePackage.ShoppingTestBase;

public class CartSummaryPage extends ShoppingTestBase {
	public CartSummaryPage(){
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css="p[class='alert alert-warning']")
	WebElement itemDeletedMsg;
	
	
	
	public String getDeletedMessageText() {
	return itemDeletedMsg.getText();
		
	}
}


