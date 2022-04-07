package com.automationShopping.RetryLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.automationShopping.BasePackage.ShoppingTestBase;

public class RetryFailedTestCases extends ShoppingTestBase implements IRetryAnalyzer {
	int counter=1; // Intial value
	int maxCount=2; //maximum retry count
	@Override
	public boolean retry(ITestResult result) {
    logger.info("Trying failed Test Case " + counter +" times");
		
		if(counter<maxCount) {
			counter++;
			return true;
		}
		return false;
	}

}
