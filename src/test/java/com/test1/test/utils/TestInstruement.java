package com.test1.test.utils;

import com.test1.test.Browser;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestInstruement {
	
	public static WebDriver driver;
	protected static Browser browser;
	
	public TestInstruement() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeSuite
	public void beforeSuite(ITestContext context) {
		System.setProperty("web.chrome.driver", "/Users/jaswirsiregar/.rvm/gems/ruby-2.5.1/bin/chromedriver");
		driver = new ChromeDriver();
		context.setAttribute("webDriver", driver);
		browser = new Browser(driver);
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterMethod(ITestContext context, ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
        	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        	LocalDateTime now = LocalDateTime.now();
        	String fileName = String.format("Screenshot_%s.jpg", dtf.format(now));
        	String suiteName = context.getCurrentXmlTest().getSuite().getName();
            String testMethodName = result.getMethod().getMethodName();
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File targetFile = new File("./screenshots/" + fileName );
            try {
                FileUtils.copyFile(srcFile, targetFile);
                System.out.println("Screenshot taken and saved to : " + targetFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
	
	@AfterSuite
	public void afterSuite() {
		
		driver.quit();
	}

}
