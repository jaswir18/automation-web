package com.test1.test.pageObject;

import org.openqa.selenium.WebDriver;

import com.test1.test.utils.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void visitHomePage() {
		visitPage("http://www.traveloka.com");
	}
	
}
