package com.automationShoppingSite.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationShoppingSite.BasePackage.ShoppingTestBase;

public class MyAccountPage extends ShoppingTestBase{
	public MyAccountPage () {
		PageFactory.initElements(wd, this);
	}
@FindBy(className="sf-with-ul")
WebElement womenTab;

public WomenTabPage clickWomenTab() {
	womenTab.click();
	return new WomenTabPage();
	
}
}
