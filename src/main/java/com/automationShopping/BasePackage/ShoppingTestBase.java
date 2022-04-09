package com.automationShopping.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

import com.AuomationShopping.Logger.WebdriverEvents;
import com.automationShoppingSite.Utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShoppingTestBase {
	public static WebDriver wd;
	public static Properties prop;
	public FileInputStream file;
	public static Logger logger;
	public EventFiringWebDriver e_driver;
	public WebdriverEvents eventListner;
	public static JavascriptExecutor jse;
	
	
	
	public ShoppingTestBase() {
		try {
			prop= new Properties();
			file= new FileInputStream("src//main//java//com//automationShopping//configFile//configuration.properties");
         prop.load(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(ShoppingTestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
	logger.setLevel(Level.INFO);
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

		// Intialising Webdriver Event Listener
				e_driver = new EventFiringWebDriver(wd);
				eventListner = new WebdriverEvents();
				e_driver.register(eventListner);
				wd = e_driver;
				
				wd.manage().window().maximize();
				wd.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
				wd.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

				// Load the Page
				wd.get(prop.getProperty("URL"));

			}

			public void tearDown() {
				wd.quit();
			}

			public void waitForDocumentCompleteState(int timeOutInSeconds) {
				new WebDriverWait(wd, 15).until((ExpectedCondition<Boolean>) v -> {
					logger.info("Verifying page has loaded......");
					jse = (JavascriptExecutor) wd;
					String documentIsReady = jse.executeScript("return document.readyState").toString();
					while (true) {
						if (documentIsReady.equalsIgnoreCase("complete")) {
							logger.info("Page has loaded completely......");
							return true;
						} else {
							return false;
						}
					}
				});
			}

		}
	
	