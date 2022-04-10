package com.automationShoppingSite.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationShopping.BasePackage.ShoppingTestBase;
import com.automationShoppingSite.Pages.HomePage;
import com.automationShoppingSite.Pages.MyAccountPage;
import com.automationShoppingSite.Pages.PersonalInformation;

public class MyAccountPageTest extends ShoppingTestBase {
	
	HomePage homepage;
	MyAccountPage myAccount;
	PersonalInformation personalInfo;

	@BeforeMethod
	public void setUp() {
		intialsation();
		homepage=new HomePage();
		homepage.enterEmail(prop.getProperty("email"));
		homepage.enterPassword(prop.getProperty("password"));
		myAccount = homepage.clickSignInButton();
	}
	
	@Test
	public void verifyPersonalInfo() {
	personalInfo=myAccount.clickMyPersonalInfo();
	personalInfo.enterCurrentPassword(prop.getProperty("currentPassword"));
	}
}


	

	

	
	


