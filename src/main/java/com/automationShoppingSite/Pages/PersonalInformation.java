package com.automationShoppingSite.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationShopping.BasePackage.ShoppingTestBase;
import com.automationShoppingSite.Utils.Utils;

public class PersonalInformation extends ShoppingTestBase {
	
	public PersonalInformation() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id="old_passwd")
	WebElement currentPaasword;
	
public void enterCurrentPassword(String currentpassword) {
		
		Utils.sendData(currentPaasword, currentpassword);
	}
	
}
