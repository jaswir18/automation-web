package com.test1.test.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test1.test.utils.BasePage;

public class HomePage extends BasePage {
	
	private By loginLink 				= By.xpath("//span[text()='Log In']");
	private By dismissOnboardingButton 	= By.cssSelector("button[data-id='tvat-confirmDiscoverProduct']");
	
	////////////////// Flight Search Section /////////////
	private By flightMenu				= By.xpath("//span[text()='Flights']");
	private By flightSubMenuOfFlight	= By.xpath("//div[@class='_2vpmC iY6Z8']/div/div/a/div[text()='Flights']");
	private By flightOriginField		= By.cssSelector("input[placeholder='Origin']");
	private By flightDestinationField	= By.cssSelector("input[placeholder='Destination']");
	private By popularCitiesAirport		= By.xpath("//span[text()='Popular Cities or Airports']");
	
	private By recommendedAirportOptions 		= By.xpath("//span[text()='Recommended Airports']/../../following-sibling::div");
	private By airportSearchresult		= By.cssSelector("div.TSlys");
	
	private By changePassengerButton	= By.xpath("//label[text()='No. of Passengers']/following-sibling::label");
	private By adultDecrementButton		= By.xpath("//span[text()='Adult']/../following-sibling::div/div[1]");
	private By adultIncrementButton		= By.xpath("//span[text()='Adult']/../following-sibling::div/div[3]");
	private By childDecrementButton		= By.xpath("//span[text()='Child']/../following-sibling::div/div[1]");
	private By childIncrementButton		= By.xpath("//span[text()='Child']/../following-sibling::div/div[3]");
	private By infantDecrementButton	= By.xpath("//span[text()='Infant']/../following-sibling::div/div[1]");
	private By infantIncrementButton	= By.xpath("//span[text()='Infant']/../following-sibling::div/div[3]");
	private By donePassengerChange		= By.xpath("//span[text()='Done']");


	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void visitHomePage() {
		visitPage("http://www.traveloka.com");
	}
	
	public void clickOnLoginLink() {
		clickOnElement(loginLink, 40);
	}
	
	public void dismissOnboarding() {
		try {
			clickOnElement(dismissOnboardingButton, 20);
		} catch (NullPointerException e) {
			System.out.println("Onboarding is not displayed");
		}
	}
	
	public void navigateToFlightsSearch() {
		clickOnElement(flightMenu, 20);
		clickOnElement(flightSubMenuOfFlight, 20);
	}
	
	public void setFlightOrigin(String airportName) {
		typeOnElement(flightOriginField, 30, airportName);
		clickOnElementAtIndex(airportSearchresult, 30, 0);
	}
	
	public void setFlightDestination(String airportName) {
		typeOnElement(flightDestinationField,30, airportName);
		clickOnElementAtIndex(airportSearchresult, 30, 0);
	}
	
	public void setNumberOfPassenger(int adultNbr, int childNbr, int intantNbr) {
		clickOnElement(changePassengerButton, 20);
		waitForElement(donePassengerChange, 30);
		setPassenger("Adult", adultNbr);
		setPassenger("Child", childNbr);
		setPassenger("Infant", intantNbr);
		clickOnElement(donePassengerChange, 20);
		delay(5000);
	}
	
	public void setPassenger(String passngerType, int numberOfPassenger) {
		for (int i=1; i <= numberOfPassenger; i++) {
			clickOnElement(By.xpath("//span[text()='"+ passngerType + "']/../following-sibling::div/div[3]"), 30);
		}
	}
	
}
