package com.test1.test.utils;

import com.test1.test.Browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestInstruement {
	
	public static WebDriver driver;
	protected static Browser browser;
	
	public TestInstruement() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("web.chrome.driver", "/Users/jaswirsiregar/.rvm/gems/ruby-2.5.1/bin/chromedriver");
		driver = new ChromeDriver();
		browser = new Browser(driver);
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
	
	@AfterClass
	public void afterClass() {
	}

	

}
