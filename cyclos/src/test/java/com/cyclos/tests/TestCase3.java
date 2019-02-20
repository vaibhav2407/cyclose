package com.cyclos.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestCase3 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		 System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM Training\\Cyclos_Test Cases\\geckodriver.exe");
		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://ec2-13-233-153-88.ap-south-1.compute.amazonaws.com:8080/web/do/login?login=true");
		  driver.manage().window().maximize();
		  
		  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		  driver.findElement(By.id("cyclosPassword")).sendKeys("12345");
		  driver.findElement(By.xpath("//td[@colspan='2']//input[@value='Submit']")).click();
		  
		  driver.findElement(By.xpath("//span[@class='menuText'][contains(text(),'Messages')]")).click();
		  WebElement MesagesSub = driver.findElement(By.xpath("//span[@class='subMenuText'][contains(text(),'Messages')]"));
		  Assert.assertTrue(MesagesSub.isDisplayed());
		  
		  WebElement MessageCateg = driver.findElement(By.xpath("//span[contains(text(),'Message Categories')]"));
		  Assert.assertTrue(MessageCateg.isDisplayed());

		  WebElement SMSM = driver.findElement(By.xpath("//span[contains(text(),'SMS mailings')]"));
		  Assert.assertTrue(SMSM.isDisplayed());
		  MesagesSub.click();
		  
		  if(driver.findElement(By.xpath("//td[contains(text(),'Message list')]")).isDisplayed()) {
			  System.out.println("Messages List section is displayed.");
		  }else {
			  System.out.println("Messages List Section is not displayed.");
		  }
		  
		  WebElement MessageBox = driver.findElement(By.id("messageBoxSelect"));
		  Select s = new Select(MessageBox);
		  s.selectByVisibleText("Sent items");
		  
		  driver.findElement(By.id("newButton")).click();
		  if(driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).isDisplayed()) {
			  System.out.println("Send Messages section displayed.");
		  }else {
			  System.out.println("Send Messages section is not displayed");
		  }
		  
		  driver.findElement(By.id("memberUsername")).sendKeys("manzoor");
		  Thread.sleep(1000);
		  Actions a = new Actions(driver);
		  a.sendKeys(Keys.ENTER).build().perform();
		  
		  String ExpectedMemName = "manzoor mehadi";
		  String ActualMemName = driver.findElement(By.id("memberName")).getAttribute("value");
		  System.out.println("Member Name -->"+ActualMemName);
		  Assert.assertEquals(ActualMemName, ExpectedMemName);
		  Thread.sleep(1000);
		  driver.findElement(By.id("subjectText")).sendKeys("loan repayment");
		  a.sendKeys(Keys.TAB).build().perform();
		  
		  StringSelection message = new StringSelection("loan repayment");
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(message, null);
		  Robot r = new Robot();
		  r.keyPress(KeyEvent.VK_CONTROL);
		  r.keyPress(KeyEvent.VK_V);
		  r.keyRelease(KeyEvent.VK_V);
		  r.keyRelease(KeyEvent.VK_CONTROL);
		  
		  driver.findElement(By.xpath("//input[@value='Submit']")).click();
		  Thread.sleep(2000);
		  
		  String SuccessMessage = driver.switchTo().alert().getText();
		  System.out.println("Success Message: "+ SuccessMessage);
		  
		  driver.switchTo().alert().accept();
		  
		  String ExpectedMessage = "The message was successfully sent";
		  if(SuccessMessage.equals(ExpectedMessage)) {
			  System.out.println("Message sent successfully.");
		  }else {
			  System.out.println("Message not sent.");
		  }
		  
		  String ExpMessage = "manzoor";
		  /*List<WebElement> tablesCount = driver.findElements(By.tagName("table"));
			 System.out.println("Tables Count -->"+ tablesCount.size());
			 List<WebElement> RowsCount = tablesCount.get(1).findElements(By.tagName("tr"));
			 System.out.println("Rows Count --> "+RowsCount.size());
			 List<WebElement> ColumnsCount = RowsCount.get(1).findElements(By.tagName("td"));
			 System.out.println("Coulmns Count --> "+ ColumnsCount.size());
			 String MessageSentTo = ColumnsCount.get(2).getText();
			 System.out.println("Message Sent To -->"+ MessageSentTo);*/
		  Thread.sleep(2000);
		  String MessageSentTo = driver.findElement(By.xpath("//tbody//tbody//tr[2]//td[4]//a[1]")).getText();
		  System.out.println("Message Sent To -->"+MessageSentTo);
			 
		  if(MessageSentTo.equals(ExpMessage)){
			  System.out.println("Sent Message is displayed in search results page.");
		  }else {
			  System.out.println("Sent Message is not displayed in search results page.");
		  }
		  driver.close();
		 
	}

}
