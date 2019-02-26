package com.cyclos.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestCase6 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM Training\\Cyclos_Test Cases\\geckodriver.exe");
		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://ec2-13-233-153-88.ap-south-1.compute.amazonaws.com:8080/web/do/login?login=true");
		  driver.manage().window().maximize();
		  
		  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		  driver.findElement(By.id("cyclosPassword")).sendKeys("123456");
		  driver.findElement(By.xpath("//td[@colspan='2']//input[@value='Submit']")).click();
		  
		  driver.findElement(By.xpath("//input[@id='memberUsername']")).sendKeys("manzoor");
		  Thread.sleep(1000);
		  Actions a = new Actions(driver);
		  a.sendKeys(Keys.ENTER).build().perform();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//tbody//tr[4]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")).click();
		  if(driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).isDisplayed()) {
			  System.out.println("Advertisements of selected member page with existing advertisement details is displayed.");
		  }else {
			  System.out.println("Advertisements of selected member page with existing advertisement details is not displayed.");
		  }
		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@id='newButton']")).click();
		  if(driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).isDisplayed()) {
			  System.out.println("New Advertisement Page is displayed.");
		  }else {
			  System.out.println("New Advertisement Page is not displayed.");
		  }

		  driver.findElement(By.name("ad(title)")).sendKeys("new offer");
		  Select s = new Select(driver.findElement(By.name("ad(category)")));
		  s.selectByVisibleText("Example ad category");
		  
		  driver.findElement(By.name("ad(price)")).sendKeys("7");
		  driver.findElement(By.id("notExpirableCheck")).click();
		  Thread.sleep(1000);
		  a.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB).build().perform();
		 /* WebElement description = driver.findElement(By.xpath("//body[@class='cke_show_borders']//p"));
		  a.moveToElement(description).build().perform();*/
		  a.sendKeys("new offer for member").build().perform();
		  
		  driver.findElement(By.xpath("//input[@id='saveButton']")).click();
		  String SuccessMessage = driver.switchTo().alert().getText();
		  System.out.println("Success Message: "+SuccessMessage);
		  String ExpectedMessage = "Advertisement inserted";
		  if(SuccessMessage.equals(ExpectedMessage)) {
			  System.out.println("Advertisement inserted successfully.");
		  }else {
			  System.out.println("Advertisement not inserted.");
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
		  Thread.sleep(1000);
		  driver.findElement(By.id("cyclosUsername")).sendKeys("manzoor");
		  Thread.sleep(1000);
		  driver.findElement(By.id("cyclosPassword")).sendKeys("manzoor");
		  driver.findElement(By.xpath("//td[@colspan='2']//input[@value='Submit']")).click();
		  
		  driver.findElement(By.xpath("//span[contains(text(),'Personal')]")).click();
		  if(driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).isDisplayed()) {
			  System.out.println("Profile sub link is displayed.");
		  }else {
			  System.out.println("Profile sub link is not displayed.");
		  }
		  
		  if(driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).isDisplayed()) {
			  System.out.println("Messages sub link is displayed.");
		  }else {
			  System.out.println("Messages sub link is not displayed.");
		  }
		  
		  if(driver.findElement(By.xpath("//span[contains(text(),'Advertisements')]")).isDisplayed()) {
			  System.out.println("Advertisements sub link is displayed.");
		  }else {
			  System.out.println("Advertisements sub link is not displayed.");
		  }
		  
		  driver.findElement(By.xpath("//span[contains(text(),'Advertisements')]")).click();
		  if(driver.findElement(By.xpath("//td[contains(text(),'My advertisements')]")).isDisplayed()) {
			  System.out.println("Advertisement added by admin is displayed.");
		  }else {
			  System.out.println("Advertisement added by admin is not displayed."); 
		  }
		  Thread.sleep(2000);
		  
		  driver.close();
		  
	}
	

}
