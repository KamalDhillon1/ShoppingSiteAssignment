package com.automationShoppingSite.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShoppingTestBase {
	public static WebDriver wd;
	public static Properties prop;
	public FileInputStream file;
	Actions actions;
	
	
	public ShoppingTestBase() {
		try {
			prop= new Properties();
			file= new FileInputStream("C:\\Users\\kkaur\\eclipse-workspace\\ShoppingSite\\src\\main\\java\\com\\automationShoppingSite\\configFile\\configuration.properties");
         prop.load(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	public void intialsation() {
		
		String browserName=prop.getProperty("browser");
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			wd = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			wd = new EdgeDriver();
			break;

		default:
			System.out.println("You are not passing the correct browser name!!!!!");
			break;
		}

		
	
	wd.manage().window().maximize();
	wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	// Load the Page
			wd.get(prop.getProperty("URL"));
	}
}
