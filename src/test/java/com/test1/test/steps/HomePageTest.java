package com.test1.test.steps;

import org.testng.annotations.Test;

import com.test1.test.utils.TestInstruement;

public class HomePageTest extends TestInstruement {

	@Test(enabled = false)
	  public void login() throws InterruptedException {
		browser.homePage().visitHomePage();
		browser.homePage().dismissOnboarding();
		browser.homePage().clickOnLoginLink();
	  }
	
	@Test
	public void searchFlights() {
		browser.homePage().visitHomePage();
		browser.homePage().dismissOnboarding();
		browser.homePage().navigateToFlightsSearch();
		browser.homePage().setFlightOrigin("Jakarta");
		browser.homePage().setFlightDestination("Surabaya");
		browser.homePage().setNumberOfPassenger(3, 2, 1);
	}
	
	
}
