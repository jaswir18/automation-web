package com.test1.test.steps;

import org.testng.annotations.Test;

import com.test1.test.utils.TestInstruement;

public class PromoPageTest extends TestInstruement {
	
	
	@Test
	  public void tapAPromo() throws InterruptedException {
		  browser.promoPage().visitPromoPage();
		  browser.promoPage().tapOnFirstPromoCard();
	  }
}
