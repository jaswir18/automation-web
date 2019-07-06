package com.test1.test.steps;

import org.testng.annotations.Test;

import com.test1.test.utils.TestInstruement;

public class HomePageTest extends TestInstruement {

	@Test
	  public void homePage() {
		browser.homePage().visitHomePage();
	  }
	
	
}
