package com.automationShoppingSite.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationShoppingSite.BasePackage.ShoppingTestBase;
import com.automationShoppingSite.Pages.AddToCart;
import com.automationShoppingSite.Pages.HomePage;
import com.automationShoppingSite.Pages.CartSummaryPage;
import com.automationShoppingSite.Pages.MyAccountPage;

import com.automationShoppingSite.Pages.SummaryAfterCheckout;
import com.automationShoppingSite.Pages.WomenTabPage;



public class CartSummaryTest extends ShoppingTestBase {
	HomePage homepage;
	MyAccountPage myAccount;
	WomenTabPage womenTabPage;
	
	SummaryAfterCheckout summaryafterCheckout;
	AddToCart addToCart;
	CartSummaryPage cartSummary;
	@BeforeMethod
	public void setUp() {
		intialsation();
		homepage=new HomePage();
		homepage.enterEmail(prop.getProperty("email"));
		homepage.enterPassword(prop.getProperty("password"));
		myAccount = homepage.clickSignInButton();
	}	

@Test
public void verifyIfItemDeleted() {
	womenTabPage=myAccount.clickWomenTab();
	addToCart=womenTabPage.quickViewClick();
	summaryafterCheckout=addToCart.submitAddToCart();
	
	cartSummary=summaryafterCheckout.deleteItem();
	
	
	String DeletedMsg=cartSummary.getDeletedMessageText();
	System.out.println("Deleted msg:" +DeletedMsg);
	
	Assert.assertEquals(DeletedMsg,prop.getProperty("itemDeletedMsg"),"Message not found" );
}

@AfterMethod
public void tearDown() {
	wd.quit();
}	
	



	
	
	
	

			
		

}
