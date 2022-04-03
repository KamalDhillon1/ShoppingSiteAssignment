package com.automationShoppingSite.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationShoppingSite.BasePackage.ShoppingTestBase;

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
		emailInput.sendKeys(email);
	}
	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}
	public MyAccountPage clickSignInButton() {
		signInBtn.click();
		return new MyAccountPage();
		
	}
}
