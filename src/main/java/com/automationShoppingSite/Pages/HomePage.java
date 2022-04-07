package com.automationShoppingSite.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationShopping.BasePackage.ShoppingTestBase;
import com.automationShoppingSite.Utils.Utils;

public class HomePage extends ShoppingTestBase {
	
	public HomePage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(id="email")
	WebElement emailInput;
	
	
	@FindBy(id="passwd")
	WebElement passwordInput;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	public void enterEmail(String email) {
	
		Utils.sendData(emailInput, email);
	}
	public void enterPassword(String password) {
		
		Utils.sendData(passwordInput, password);
	}
	public MyAccountPage clickSignInButton() {
	
		Utils.clickOnElement(signInBtn);
		return new MyAccountPage();
		
	}
}
