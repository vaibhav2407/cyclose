package com.cyclos.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase7 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM Training\\Cyclos_Test Cases\\geckodriver.exe");
		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://ec2-13-233-153-88.ap-south-1.compute.amazonaws.com:8080/web/do/login?login=true");
		  driver.manage().window().maximize();
		  
		  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		  driver.findElement(By.id("cyclosPassword")).sendKeys("123456");
		  driver.findElement(By.xpath("//td[@colspan='2']//input[@value='Submit']")).click();
		  
		  driver.findElement(By.xpath("//span[@class='menuText'][contains(text(),'Accounts')]")).click();
		  driver.findElement(By.xpath("//span[contains(text(),'Manage Loans')]")).click();
		  driver.findElement(By.id("memberUsername")).sendKeys("manzoor");
		  Thread.sleep(1000);
		  Actions a = new Actions(driver);
		  a.sendKeys(Keys.ENTER).build().perform();
		  driver.findElement(By.xpath("//input[@value='Search']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//tbody//tbody//tr[2]//td[7]//img[1]")).click();
		  driver.findElement(By.id("amountText")).sendKeys("500");
		  driver.findElement(By.xpath("//input[@value='Repay']")).click();
		  
		  String AmountConfirm = driver.switchTo().alert().getText();
		  System.out.println("Amount Confirmation Message: "+AmountConfirm);
		  
		  String ExpectedMessage ="Are you sure to repay 500 units? Please, click ok to proceed";
		  if(AmountConfirm.contains(ExpectedMessage)) {
			  System.out.println("Amount Confirmation alert is displayed.");
		  }else {
			  System.out.println("Amount Confirmation alert is not displayed.");
		  }
		  
		  driver.switchTo().alert().accept();
		  
		  String AmountConfirmationMessage = driver.switchTo().alert().getText();
		  System.out.println("Amount Confirmation message: "+AmountConfirmationMessage);
		  
		  String ExpeMessage = "The repayment was succesfully";
		  if(AmountConfirmationMessage.equals(ExpeMessage)) {
			  System.out.println("Repayment successfully done.");
		  }else {
			  System.out.println("Repayment successfully not done.");
		  }
		  
		  driver.switchTo().alert().accept();
		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
		  String LogoutMessage = driver.switchTo().alert().getText();
		  System.out.println("Success Message: "+LogoutMessage);
		  String ExpectedLogoutMessage = "Please confirm to logout";
		  if(LogoutMessage.equals(ExpectedLogoutMessage)) {
			  System.out.println("User loggedout successfully.");
		  }else {
			  System.out.println("User not loggedout.");
		  }
		  
		  driver.switchTo().alert().accept();
		  
		  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		  driver.findElement(By.id("cyclosPassword")).sendKeys("123456");
		  driver.findElement(By.xpath("//td[@colspan='2']//input[@value='Submit']")).click();
		  
		  driver.findElement(By.id("memberUsername")).sendKeys("manzoor");
		  a.sendKeys(Keys.ENTER).build().perform();
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//tbody//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")).click();
		  
	}

}
