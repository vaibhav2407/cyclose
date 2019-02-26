package com.cyclos.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase10 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM Training\\Cyclos_Test Cases\\geckodriver.exe");
		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://ec2-13-233-153-88.ap-south-1.compute.amazonaws.com:8080/web/do/login?login=true");
		  driver.manage().window().maximize();
		  
		  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		  driver.findElement(By.id("cyclosPassword")).sendKeys("123456");
		  driver.findElement(By.xpath("//td[@colspan='2']//input[@value='Submit']")).click();
		  
		  driver.findElement(By.id("memberUsername")).sendKeys("manzoor");
		  Thread.sleep(1000);
		  Actions a = new Actions(driver);
		  a.sendKeys(Keys.ENTER).build().perform();
		  Thread.sleep(3000);
		  if(driver.findElement(By.xpath("//td[contains(text(),'Profile of manzoor mehadi')]")).isDisplayed()) {
			  System.out.println("Profile of manzoor mehadi is displayed.");
		  }else {
			  System.out.println("Profile of manzoor mehadi is not displayed.");
		  }
		  
		  driver.findElement(By.xpath("//tbody//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[4]//input[1]")).click();
		  if(driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).isDisplayed()) {
			  System.out.println("Grant loan to manzoor mehadi page is displayed");
		  }else {
			  System.out.println("Grant loan to manzoor mehadi page is not displayed"); 
		  }
		  
		  driver.findElement(By.id("amount")).sendKeys("100000");
		  driver.findElement(By.id("description")).sendKeys("home loan");
		  driver.findElement(By.xpath("//input[@value='Submit']")).click();
		  Thread.sleep(3000);
		  String LoanDetails = driver.findElement(By.xpath("//td[@class='label']")).getText();
		  System.out.println("Loan Details Label--> "+LoanDetails);
		  
		  String ExpLabel = "You are about to grant the following loan:";
		  if(LoanDetails.contains(LoanDetails)) {
			  System.out.println("You are about to grant the following loan: with loan details is displayed.");
		  }else {
			  System.out.println("You are about to grant the following loan: with loan details is not displayed."); 
		  }
		  
		  driver.findElement(By.xpath("//input[@value='Submit']")).click();
		  Thread.sleep(2000);
		  String SuccessMessage = driver.switchTo().alert().getText();
		  System.out.println("Grant Loan Success Message: "+SuccessMessage);
		  String ExpSuccMessage = "The loan was successfully granted";
		  if(SuccessMessage.equals(ExpSuccMessage)) {
			  System.out.println("The loan was successfully granted message is displayed.");
		  }else {
			  System.out.println("The loan was successfully granted message is not displayed.");
		  }
		  
		  driver.switchTo().alert().accept();
		  
		  driver.findElement(By.xpath("//tbody//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")).click();
		  
		  if(driver.findElement(By.xpath("//td[contains(text(),'Loans of manzoor mehadi')]")).isDisplayed()) {
			  System.out.println("Details of Loans granted to all member is displayed.");
		  }else {
			  System.out.println("Details of Loans granted to all member is not displayed.");
		  }
		  
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
		  
		  driver.findElement(By.id("cyclosUsername")).sendKeys("manzoor");
		  driver.findElement(By.id("cyclosPassword")).sendKeys("manzoor");
		  driver.findElement(By.xpath("//td[@colspan='2']//input[@value='Submit']")).click();
		  
		  if(driver.findElement(By.xpath("//span[contains(text(),'Logged user: manzoor - manzoor mehadi')]")).isDisplayed()) {
			  System.out.println("Logged user: manzoor - manzoor mehadi member home page is displayed.");
		  }else {
			  System.out.println("Logged user: manzoor - manzoor mehadi member home page is not displayed.");
		  }

		  driver.findElement(By.xpath("//span[@class='menuText'][contains(text(),'Account')]")).click();
		  if(driver.findElement(By.xpath("//span[contains(text(),'Account Information')]")).isDisplayed()) {
			 System.out.println("Account Information link is displayed."); 
		  }else {
			  System.out.println("Account Information link is not displayed."); 
		  }
		  
		  if(driver.findElement(By.xpath("//span[contains(text(),'Loans')]")).isDisplayed()) {
			  System.out.println("Loans link is displayed.");  
		  }else {
			  System.out.println("Loans link is not displayed.");  
		  }
		  
		  driver.findElement(By.xpath("//span[contains(text(),'Loans')]")).click();
		  if(driver.findElement(By.xpath("//td[contains(text(),'My loans')]")).isDisplayed()) {
			  System.out.println("Loans granted by admin is displayed.");
		  }else {
			  System.out.println("Loans granted by admin is not displayed.");
		  }
		  
		  Thread.sleep(2000);
		  driver.close();
	}

}
