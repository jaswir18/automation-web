package com.test1.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("web.chrome.driver", "/Users/jaswirsiregar/.rvm/gems/ruby-2.5.1/bin/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
	}
	
	@Test
	  public void f() {
		  driver.get("http://www.traveloka.com");
	  }
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
