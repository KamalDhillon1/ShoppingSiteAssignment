package com.automationShoppingSite.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationShopping.BasePackage.ShoppingTestBase;
import com.automationShoppingSite.Utils.Utils;

public class MyAccountPage extends ShoppingTestBase {
	public MyAccountPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(className="sf-with-ul")
	WebElement womenTab;

	@FindBy(xpath="//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")
	WebElement myPersonalInformation;
	
	public WomenTabPage clickWomenTab() {
		Utils.clickOnElement(womenTab);
		return new WomenTabPage();
		
	}
	public PersonalInformation clickMyPersonalInfo() {
		Utils.clickOnElement(myPersonalInformation);
		return new PersonalInformation();
	}
}
