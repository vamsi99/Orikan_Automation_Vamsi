package com.orikan.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class Base {
	
	
	public static WebDriver driver;
	
	
	/**
	 * Method used to invoke the browser
	 * 
	 * @param browser
	 */
	@BeforeClass
	@Parameters("browser")
	public void invokeBrowser(String browser) {

		// If the browser is Firefox, then do this

		if (browser.equalsIgnoreCase("firefox")) {

			// Initializing the firefox driver (Gecko)
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {

			// Initialize the chrome driver
			System.setProperty("webdriver.chrome.driver",
					"D:\\Orikan_Automation\\Automation\\OrikanAutomation\\src\\resource\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver();

			

		}

	}
	
	@AfterClass
	public void afterTest() {

		driver.quit();
		// getDriver().

	}

}
