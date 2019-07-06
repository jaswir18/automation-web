package com.test1.test.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test1.test.pageObject.HomePage;
import com.test1.test.utils.TestInstruement;

public class HomePageTest extends TestInstruement {

	@Test
	  public void homePage() {
		browser.homePage().visitHomePage();
	  }
	
	
}
