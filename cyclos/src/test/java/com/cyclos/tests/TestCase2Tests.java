package com.cyclos.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cyclos.pageobjects.TestCase1PageObjects;
import com.cyclos.pageobjects.TestCase2PageObjects;

public class TestCase2Tests {
	public static WebDriver driver;

	@Test
	public void TC2() throws InterruptedException {
	   System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM Training\\Cyclos_Test Cases\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://ec2-13-233-153-88.ap-south-1.compute.amazonaws.com:8080/web/do/login?login=true");
		driver.manage().window().maximize();
		TestCase1PageObjects TC1 = new TestCase1PageObjects(driver);
		TestCase2PageObjects TC2 = new TestCase2PageObjects(driver);
		TC1.LoginIntoApplication("admin", "12345");
		
		TC2.ValidateMemberPaymentPage();
		TC2.ValidateMemberCredintials("manzoor");
		TC2.EnterPaymentDetails("10000", "system");
		TC2.ValidateInsufficientBalanceMessage();
		TC1.CloseBrowser();
	}
}
