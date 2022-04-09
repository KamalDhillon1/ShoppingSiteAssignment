package com.automationShoppingSite.Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automationShopping.BasePackage.ShoppingTestBase;
import com.automationShoppingSite.Pages.HomePage;
import com.automationShoppingSite.Pages.MyAccountPage;

public class HomePageTest extends ShoppingTestBase {


	HomePage homepage;
	MyAccountPage myaccount;
	SoftAssert sf;
	
	
	@BeforeMethod
   public void setUp() {
		intialsation();
		homepage = new HomePage();
		
   }
	@Test
	public void verifyUserGetErrorByBlankPassword() {
        homepage.enterEmail(prop.getProperty("email"));
		myaccount = homepage.clickSignInButton();
		String authErrorMsg = homepage.getAuthErrormsgText();
		System.out.println("Authetication Error Msg:" + authErrorMsg);
       Assert.assertEquals(authErrorMsg, prop.getProperty("authenticationErrorMsg"), "message not found");
      
}
	@Test
public void verifyErrorIfUserEnterInavlidEmail() {
		homepage.enterEmail(prop.getProperty("invalidemail"));
		homepage.enterPassword(prop.getProperty("password"));
		myaccount=homepage.clickSignInButton();
		String emailInvalidMsg = homepage.getAuthErrormsgText();
		System.out.println("Email Invalid Error Msg:" + emailInvalidMsg);
       Assert.assertEquals(emailInvalidMsg, prop.getProperty("emailInvalidErrorMsg"));
	}

	@AfterMethod
	public void teardown() {
		wd.quit();
	}
	}

