package com.automationShoppingSite.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automationShopping.BasePackage.ShoppingTestBase;
import com.automationShoppingSite.Pages.AddToCart;
import com.automationShoppingSite.Pages.HomePage;
import com.automationShoppingSite.Pages.CartSummaryPage;
import com.automationShoppingSite.Pages.MyAccountPage;
import com.automationShoppingSite.Pages.PersonalInformation;

import com.automationShoppingSite.Pages.SummaryAfterCheckout;
import com.automationShoppingSite.Pages.WomenTabPage;



public class CartSummaryTest extends ShoppingTestBase {
	HomePage homepage;
	MyAccountPage myAccount;
	WomenTabPage womenTabPage;
	
	
	SummaryAfterCheckout summaryafterCheckout;
	AddToCart addToCart;
	CartSummaryPage cartSummary;
	PersonalInformation personalInfo;
	
	SoftAssert sf;
	
	
	@BeforeMethod
	public void setUp() {
		intialsation();
		homepage=new HomePage();
		homepage.enterEmail(prop.getProperty("email"));
		homepage.enterPassword(prop.getProperty("password"));
		myAccount = homepage.clickSignInButton();
		
}
	 
	  

@Test
public void verifyUserCanDeleteItem() {
	womenTabPage=myAccount.clickWomenTab();
	addToCart=womenTabPage.quickViewClick();
	summaryafterCheckout=addToCart.submitAddToCart();
	cartSummary=summaryafterCheckout.deleteItem();
	String DeletedMsg=cartSummary.getDeletedMessageText();
	System.out.println("Deleted msg:" +DeletedMsg);
	
	sf.assertEquals(DeletedMsg,prop.getProperty("itemDeletedMsg"),"Message not found" );
	
}

@Test
public void verifyPersonalInfo() {
personalInfo=myAccount.clickMyPersonalInfo();
personalInfo.enterCurrentPassword(prop.getProperty("currentPassword"));
}
@Test
public void verifySignOutBtn() {
	homepage=cartSummary.ClicklogoutBtn();
}
@AfterMethod
public void tearDown() {
	wd.quit();
}	
	



	
	
	
	

			
		

}
