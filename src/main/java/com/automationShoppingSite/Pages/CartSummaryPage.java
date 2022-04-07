package com.automationShoppingSite.Pages;

import org.openqa.selenium.WebElement;

import com.automationShopping.BasePackage.ShoppingTestBase;
import com.automationShoppingSite.Utils.Utils;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartSummaryPage extends ShoppingTestBase {
	public CartSummaryPage(){
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css="p[class='alert alert-warning']")
	WebElement itemDeletedMsg;
	
	@FindBy(className ="logout")
	WebElement logoutBtn;
	
	public String getDeletedMessageText() {
		return Utils.getTextFromWebelement(itemDeletedMsg);
	}
	
	public HomePage ClicklogoutBtn() {
		Utils.clickOnElement(logoutBtn);
		return new HomePage();
		
	}
	
	
	}



