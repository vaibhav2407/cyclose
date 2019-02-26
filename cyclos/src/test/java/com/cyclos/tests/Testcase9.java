package com.cyclos.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Testcase9 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM Training\\Cyclos_Test Cases\\geckodriver.exe");
		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://ec2-13-233-153-88.ap-south-1.compute.amazonaws.com:8080/web/do/login?login=true");
		  driver.manage().window().maximize();

		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.id("cyclosPassword")).sendKeys("123456");
		driver.findElement(By.xpath("//td[@colspan='2']//input[@value='Submit']")).click();
		driver.findElement(By.xpath("//span[@class='menuText'][contains(text(),'Accounts')]")).click();

		if (driver.findElement(By.xpath("//span[contains(text(),'Manage Currencies')]")).isDisplayed()) {
			System.out.println("Manage Currencies link is displayed.");
		} else {
			System.out.println("Manage Currencies link is not displayed.");
		}

		if (driver.findElement(By.xpath("//span[contains(text(),'Manage Accounts')]")).isDisplayed()) {
			System.out.println("Manage Accounts link is displayed.");
		} else {
			System.out.println("Manage Accounts link is not displayed.");
		}

		if (driver.findElement(By.xpath("//span[contains(text(),'System Payment')]")).isDisplayed()) {
			System.out.println("System Payment link is displayed.");
		} else {
			System.out.println("System Payment link is not displayed.");
		}

		driver.findElement(By.xpath("//span[contains(text(),'Member Payment')]")).click();
		if (driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).isDisplayed()) {
			System.out.println("Payment system to member page is displayed.");
		} else {
			System.out.println("Payment system to member page is not displayed.");
		}

		driver.findElement(By.id("memberUsername")).sendKeys("manzoor");
		Thread.sleep(1000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.id("amount")).sendKeys("500");
		driver.findElement(By.id("description")).sendKeys("welcome");
		driver.findElement(By.id("submitButton")).click();

		if (driver.findElement(By.xpath("//td[@class='label']")).isDisplayed()) {
			System.out.println(
					"You are about to perform the following payment: message containing details is displayed.");
		} else {
			System.out.println(
					"You are about to perform the following payment: message containing details is not displayed.");
		}

		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		if (driver.findElement(By.xpath("//td[@align='center']")).isDisplayed()) {
			System.out.println("The payment has been performed  message is displayed.");
		} else {
			System.out.println("The payment has been performed  message is not displayed.");
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
		String LogoutMessage = driver.switchTo().alert().getText();
		System.out.println("Success Message: " + LogoutMessage);
		String ExpectedLogoutMessage = "Please confirm to logout";
		if (LogoutMessage.equals(ExpectedLogoutMessage)) {
			System.out.println("User loggedout successfully.");
		} else {
			System.out.println("User not loggedout.");
		}

		driver.switchTo().alert().accept();

		driver.findElement(By.id("cyclosUsername")).sendKeys("manzoor");
		driver.findElement(By.id("cyclosPassword")).sendKeys("manzoor");
		driver.findElement(By.xpath("//td[@colspan='2']//input[@value='Submit']")).click();

		if (driver.findElement(By.xpath("//span[contains(text(),'Logged user: manzoor - manzoor mehadi')]"))
				.isDisplayed()) {
			System.out.println("Logged user: manzoor - manzoor mehadi member home page is displayed.");
		} else {
			System.out.println("Logged user: manzoor - manzoor mehadi member home page is not displayed.");
		}

		driver.findElement(By.xpath("//span[@class='menuText'][contains(text(),'Account')]")).click();
		if (driver.findElement(By.xpath("//span[contains(text(),'Account Information')]")).isDisplayed()) {
			System.out.println("Account Information link is displayed.");
		} else {
			System.out.println("Account Information link is not displayed.");
		}

		if (driver.findElement(By.xpath("//span[contains(text(),'Scheduled payments')]")).isDisplayed()) {
			System.out.println("Scheduled payments link is displayed.");
		} else {
			System.out.println("Scheduled payments link is not displayed.");
		}
		
		driver.findElement(By.xpath("//span[contains(text(),'Account Information')]")).click();
		if(driver.findElement(By.xpath("//td[contains(text(),'Search transactions on Member account')]")).isDisplayed()) {
			System.out.println("transaction details made by member is displayed.");
		}else {
			System.out.println("transaction details made by member is not displayed.");
		}
		Thread.sleep(2000);
		driver.close();

	}

}
