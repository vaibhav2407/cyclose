package com.cyclos.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TestCase5 {

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
		  
		  StaticalAnalysis.click();
		  Thread.sleep(3000);
		  if(driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).isDisplayed()) {
			  System.out.println("Statistics show page is displayed.");
		  }else {
			  System.out.println("Statistics show page is not displayed.");
		  }
		  
		  driver.findElement(By.xpath("//tbody//tr[1]//td[2]//input[1]")).click();
		  if(driver.findElement(By.xpath("//td[contains(text(),'Statistics of key developments...')]")).isDisplayed()) {
			  System.out.println("Statistics of activities… page is displayed.");
		  }else {
			  System.out.println("Statistics of activities… page is not displayed.");
		  }
		  
		  driver.findElement(By.xpath("//input[@id='selectAllButton']")).click();
		  Thread.sleep(3000);
		  if(driver.findElement(By.xpath("//input[@id='numberOfMembersCheckBox']")).isSelected()) {
			  System.out.println("All checkboxes are selected.");
		  }else {
			  System.out.println("All checkboxes are not selected.");
		  }
		  
		  driver.findElement(By.id("submitButton")).click();
		  Thread.sleep(3000);
		  if(driver.findElement(By.xpath("//td[contains(text(),'Developments in number of members')]")).isDisplayed()) {
			  System.out.println("Statistics report generated successfully.");
		  }else {
			  System.out.println("Statistics report not generated.");
		  }
		  
		  driver.close();
	}

}
