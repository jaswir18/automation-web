package com.test1.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
	
	protected final WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visitPage(String url) {
		System.out.println("Driver in BasePage" + driver.toString());
		driver.get(url);
	}
	
	public void clickOnElement(By selector) {
		driver.findElement(selector).click();
	}

}
