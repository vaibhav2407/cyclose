package com.cyclos.tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TestCase4 {

	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM Training\\Cyclos_Test Cases\\geckodriver.exe");
		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://ec2-13-233-153-88.ap-south-1.compute.amazonaws.com:8080/web/do/login?login=true");
		  driver.manage().window().maximize();
		  
		  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		  driver.findElement(By.id("cyclosPassword")).sendKeys("12345");
		  driver.findElement(By.xpath("//td[@colspan='2']//input[@value='Submit']")).click();
		  
		  driver.findElement(By.xpath("//span[contains(text(),'Reports')]")).click();
		  WebElement StateOverview = driver.findElement(By.xpath("//span[contains(text(),'State overview')]"));
		  Assert.assertTrue(StateOverview.isDisplayed());
		  
		  WebElement MemberList = driver.findElement(By.xpath("//span[contains(text(),'Member lists')]"));
		  Assert.assertTrue(MemberList.isDisplayed());

		  WebElement MemberReports = driver.findElement(By.xpath("//span[contains(text(),'Member reports')]"));
		  Assert.assertTrue(MemberReports.isDisplayed());
		  
		  WebElement StaticalAnalysis = driver.findElement(By.xpath("//span[contains(text(),'Statistical analysis')]"));
		  Assert.assertTrue(StaticalAnalysis.isDisplayed());
		  
		  MemberList.click();
		  if(driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).isDisplayed()) {
			  System.out.println("Member List Page is displayed.");
		  }else {
			  System.out.println("Member List Page is not displayed.");
		  }
		  
		  driver.findElement(By.id("selectAllButton")).click();
		  Thread.sleep(3000);
		  if(driver.findElement(By.id("memberName")).isSelected()) {
			  System.out.println("All Checkboxes are selected.");
		  }else {
			  System.out.println("Checkboxes are not selected.");
		  }
		  
		  driver.findElement(By.id("printReportButton")).click();
		  Thread.sleep(3000);
		  Set <String> handles =driver.getWindowHandles();
		  Iterator<String> it = handles.iterator();
		  //iterate through your windows
		  while (it.hasNext()){
		  String parent = it.next();
		  String newwin = it.next();
		  driver.switchTo().window(newwin);
		  //perform actions on new window
		  driver.manage().window().maximize();
		  Thread.sleep(3000);
		  if(driver.findElement(By.xpath("//td[@class='printTitle']")).isDisplayed()) {
			  System.out.println("Member List reports generated successfully.");
		  }else {
			  System.out.println("Member List reports not generated."); 
		  }
		  
		  driver.close();
		  driver.switchTo().window(parent);
		              }
		  
		  

	}

}
