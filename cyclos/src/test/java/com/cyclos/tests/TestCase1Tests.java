package com.cyclos.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.cyclos.pageobjects.TestCase1PageObjects;
import com.cyclos.pageobjects.TestCase2PageObjects;

public class TestCase1Tests {
	public static WebDriver driver;
	
	@Test
	public void TC1() throws InterruptedException {
	   System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM Training\\Cyclos_Test Cases\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://ec2-13-233-153-88.ap-south-1.compute.amazonaws.com:8080/web/do/login?login=true");
		driver.manage().window().maximize();
		TestCase1PageObjects TC1 = new TestCase1PageObjects(driver);
		TC1.LoginIntoApplication("admin", "12345");
		TC1.ClickAndValidateAccountTab();
		TC1.ValidateManageCurrensyLink();
		TC1.ValidateManageAccountsLink();
		TC1.ValidateSystemAccountsLink();
		TC1.ValidateManageLoansLink();
		TC1.ValidateManageLoansPage();
		TC1.ValidateMemberLogin("manzoor");
		TC1.ValidateSearchResults();
		TC1.ValidateLoanDetailsPage();
		TC1.CloseBrowser();
	}

	
	 
}
