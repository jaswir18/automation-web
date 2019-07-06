package com.test1.test.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test1.test.utils.BasePage;

public class PromoPage extends BasePage {

	  public PromoPage(WebDriver driver) {
		super(driver);
	}

	public void visitPromoPage() {
		  driver.get("https://www.traveloka.com/en-id/promotion");
	  }

	public void tapOnFirstPromoCard()throws InterruptedException {
		driver.findElement(By.cssSelector("span.btn-secondary.btn-block")).click();
		 Thread.sleep(5000);
	}
}
