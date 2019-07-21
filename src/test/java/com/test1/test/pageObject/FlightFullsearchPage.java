package com.test1.test.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test1.test.utils.BasePage;

public class FlightFullsearchPage extends BasePage {
	
	public FlightFullsearchPage(WebDriver driver) {
		super(driver);
	}

	private By changeSearchButton			= By.cssSelector("#changeSearchButton");
	
	public void isOnFlightFullsearchPage() {
		waitForElement(changeSearchButton, 30);
	}

}
