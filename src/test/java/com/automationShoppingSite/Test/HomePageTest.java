package com.automationShoppingSite.Test;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automationShoppingSite.Utils.ExcelUtils;
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

	@Test(dataProvider = "loginDataProvider")

	public void verifyUserCanLoginSuccessFully(String email, String password) {
		myaccount = homepage.clickSignInButton();

		homepage.enterEmail(email);
		homepage.enterPassword(password);
		myaccount = homepage.clickSignInButton();
		String welcomemsg = homepage.getAuthErrormsgText();
		Assert.assertEquals(welcomemsg, prop.getProperty("successmsg"), "message not found");
		
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
		myaccount = homepage.clickSignInButton();
		String emailInvalidMsg = homepage.getAuthErrormsgText();
		System.out.println("Email Invalid Error Msg:" + emailInvalidMsg);
		Assert.assertEquals(emailInvalidMsg, prop.getProperty("emailInvalidErrorMsg"));
	}

	@AfterMethod
	public void teardown() {
		wd.quit();
	}

	@DataProvider(name = "loginDataProvider")
	public String[][] readAndFeedLoginDataFromExcel() throws IOException {
		String filePath = "C:\\Users\\kkaur\\OneDrive\\Documents\\LoginsInfo.xlsx";
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		int col = ExcelUtils.getCellCount(filePath, "Sheet1", rows);
		String[][] loginData = new String[rows][col];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}
		}
		return loginData;

	}
}
