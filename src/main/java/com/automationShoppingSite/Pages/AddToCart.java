package com.automationShoppingSite.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationShopping.BasePackage.ShoppingTestBase;
import com.automationShoppingSite.Utils.Utils;

public class AddToCart extends ShoppingTestBase {

	public AddToCart() {

		PageFactory.initElements(wd, this);

	}
	

	@FindBy(id="add_to_cart")
	WebElement addToCart;
	
	
	
	public SummaryAfterCheckout submitAddToCart() {
		addToCart.submit();
		return new SummaryAfterCheckout();
	}
	

	}

