package com.orikan.common;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends Base {

	Select s;
	static String actVal;

	/**
	 * Method used to handle text box
	 * 
	 * @param locator
	 * @param value
	 * @param msg
	 */
	public static void type(By locator, String value, String msg) {

		try {
			driver.findElement(locator).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method used to handle button or check box
	 * 
	 * @param locator
	 * @param msg
	 */
	public static void click(By locator, String msg) {

		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method used to enter desired text in element using Java Script Executor
	 * 
	 * @param by
	 * @param text
	 */
	public static void jsType(By by, String text) {

		try {
			WebElement ele = driver.findElement(by);
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].value='" + text + "'", ele);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method used to get text present on the locator
	 * 
	 * @param by
	 * @param locator
	 * @return
	 */
	public String getText(By by, String locator) {

		try {
			String text = driver.findElement(by).getText().trim();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * Method used to handle drop-down based on value
	 * 
	 * @param locator
	 * @param value
	 */
	public static void selectByValueDD(By locator, String value) {
		try {
			Select s = new Select(driver.findElement(locator));
			s.selectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verify expected text is present on the element
	 * 
	 * @param locator
	 * @param expVal
	 */
	public static void isTextPresentOnElement(By locator, String expVal) {
		actVal = driver.findElement(locator).getText();

		if (actVal.equals(expVal)) {
			System.out.println(expVal + " displayed.");
		} else {
			System.out.println(expVal + " not displayed.");
		}

	}

	/**
	 * Verify whether element is present in DOM
	 * 
	 * @param locator
	 * @param loatorName
	 * @return
	 */
	public static boolean isElementPresent(By locator, String loatorName) {
		boolean flag = false;
		try {
			waitForElement(locator);
			WebElement em = driver.findElement(locator);
			if (em.isDisplayed()) {
				System.out.println(loatorName + " is present in DOM");
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return flag;

	}

	/**
	 * Waits for the element to be located works as fluent wait.
	 * 
	 * @param by
	 * @return
	 */
	public static boolean fluentWait(final By by) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

				public Boolean apply(WebDriver driver) {
					return driver.findElement(by).isDisplayed();
				}
			};
			wait.until(function);
			return driver.findElement(by).isDisplayed();

		} catch (Exception e) {
			return false;

		}
	}

	/**
	 * Waits for the element to be visible works as explicit wait.
	 * 
	 * @param object
	 * @return
	 */
	public static boolean waitForElement(By object) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(object));
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Waits for the element to be click works as explicit wait
	 * 
	 * @param object
	 * @return
	 */
	public static boolean waitForElementToClickable(By object) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.pollingEvery(Duration.ofSeconds(2));
			wait.until(ExpectedConditions.elementToBeClickable(object));
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

}
