package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {

	WebDriver driver;

	public ElementActions(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		waitForElementPresen(locator);
		WebElement element = null;

		try {

			element=driver.findElement(locator);

		} catch (Exception e) {
			System.out.println("Some Exception occured while creating element" + locator);
		}
		return element;
	}

	public void waitForElementPresen(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Some Exception occured while clicking element" + locator);
		}
	}

	public void doSendKeys(By locator, String values) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(values);
		} catch (Exception e) { 
			System.out.println("Some Exception occured while sending the keys element" + locator);
		}

	}

	public String doGetText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("Some Exception occured while getting the text of the  element" + locator);
		}
		return text;
	}

	public void doClickActions(By locator) {
		try {
			Actions actions = new Actions(driver);
			WebElement element = getElement(locator);
			actions.click(element).build().perform();
		} catch (Exception e) {
			System.out.println("Some Exception occured while clicking element" + locator);
		}

	}

	public String waitPageTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Some Exception occured while getting the text of the  element" + locator);
			return false;
		}

	}
	
	public void DomoveToElement(WebElement element) {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		
	}
	
	
	
}
