package com.test1.test;

import org.openqa.selenium.WebDriver;

import com.test1.test.pageObject.HomePage;
import com.test1.test.pageObject.PromoPage;

public class Browser {
	
	protected final WebDriver driver;
	
	public Browser(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage homePage() {
		return new HomePage(driver);
	}
	
	public PromoPage promoPage() {
		return new PromoPage(driver);
	}

}
