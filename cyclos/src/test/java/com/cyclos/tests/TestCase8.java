package com.cyclos.tests;

import static org.testng.Assert.assertEqualsNoOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase8 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM Training\\Cyclos_Test Cases\\geckodriver.exe");
		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://ec2-13-233-153-88.ap-south-1.compute.amazonaws.com:8080/web/do/login?login=true");
		  driver.manage().window().maximize();

		driver.findElement(By.id("cyclosUsername")).sendKeys("manzoor");
		driver.findElement(By.id("cyclosPassword")).sendKeys("manzoor");
		driver.findElement(By.xpath("//td[@colspan='2']//input[@value='Submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='menuText'][contains(text(),'Account')]")).click();

		if (driver.findElement(By.xpath("//span[contains(text(),'Account Information')]")).isDisplayed()) {
			System.out.println("Account Information link is displayed.");
		} else {
			System.out.println("Account Information link is not displayed.");
		}

		if (driver.findElement(By.xpath("//span[contains(text(),'Loans')]")).isDisplayed()) {
			System.out.println("Loans link is displayed.");
		} else {
			System.out.println("Loans link is displayed.");
		}

		if (driver.findElement(By.xpath("//span[contains(text(),'Scheduled payments')]")).isDisplayed()) {
			System.out.println("Scheduled payments link is displayed.");
		} else {
			System.out.println("Scheduled payments link is not displayed.");
		}

		if (driver.findElement(By.xpath("//span[contains(text(),'Invoices')]")).isDisplayed()) {
			System.out.println("Invoices link is displayed.");
		} else {
			System.out.println("Invoices link is not displayed.");
		}

		driver.findElement(By.xpath("//span[contains(text(),'Member Payment')]")).click();
		driver.findElement(By.id("memberUsername")).sendKeys("manzoor");
		Thread.sleep(1000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.id("amount")).sendKeys("5000");
		driver.findElement(By.id("description")).sendKeys("birth day gift");
		driver.findElement(By.id("submitButton")).click();
		if (driver.findElement(By.xpath("//td[@class='label']")).isDisplayed()) {
			System.out.println("You are about to perform the following payment: with entered details is displayed.");
		} else {
			System.out
					.println("You are about to perform the following payment: with entered details is not displayed.");
		}

		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		if (driver.findElement(By.xpath("//td[@align='center']")).isDisplayed()) {
			System.out.println("The payment has been performed  message is displayed.");
		} else {
			System.out.println("The payment has been performed  message is not displayed.");
		}

		driver.findElement(By.xpath("//span[contains(text(),'Account Information')]")).click();
		if (driver.findElement(By.xpath("//td[contains(text(),'Search transactions on Member account')]"))
				.isDisplayed()) {
			System.out.println("transaction details made by member is displayed.");
		} else {
			System.out.println("transaction details made by member is not displayed.");
		}

	}

}
