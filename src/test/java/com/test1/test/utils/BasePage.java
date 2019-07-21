package com.test1.test.utils;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected final WebDriver driver;
	private Wait<WebDriver> wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void visitPage(String url) {
		System.out.println("Driver in BasePage" + driver.toString());
		driver.get(url);
	}
	
	public void clickOnElement(WebElement element, int timeout) {
		WebElement elm = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.elementToBeClickable(element));
		for (int i = 0; i < timeout;) {
			try {
				elm.click();
				break;
			} catch (WebDriverException e) {
				delay(1000);
				i++;
			}
		}
	}
	
	public void clickOnElement(By selector) {
		driver.findElement(selector).click();
	}
	
	public void clickOnElement(By locator, int timeout) {
		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(locator));
		for (int i = 0; i < timeout;) {
			try {
				element.click();
				break;
			} catch (WebDriverException e) {
				delay(1000);
				i++;
			}
		}
	}
	
	public void clickOnElementAtIndex(By locator, int timeout, int index) {
		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).get(index);
		for (int i = 0; i < timeout;) {
			try {
				element.click();
				break;
			} catch (WebDriverException e) {
				delay(1000);
				i++;
			}
		}
	}
	
	public void typeOnElement(By locator, int timeout, String textToType) {
		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.elementToBeClickable(locator));
		// also wait until the element is interactable
		for (int i = 0; i < timeout;) {
			try {
				element.clear();
				element.sendKeys(textToType);
				break;
			} catch (InvalidElementStateException e) {
				delay(1000);
				i++;
			}
		}
	}
	
	public void delay(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
	public void waitForElement(By locator, int timeout) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public List<WebElement> getMultipleElement(By locator, int timeout) {
		return (List<WebElement>) (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public String getTextFromElement(By locator, int timeout) {
		return (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
	}

}
