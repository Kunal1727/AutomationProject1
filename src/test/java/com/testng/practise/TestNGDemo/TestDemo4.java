package com.testng.practise.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

//Study of Actions class and Alerts in selenium..
//It is used when we want to hover mouse on any dropdown and select an item from it..

public class TestDemo4 
{
	WebDriver driver;

  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.get("https://court.mah.nic.in/courtweb/index.php");
	  driver.manage().window().maximize();
  }
  
  @Test
  public void actionClass() 
  {
	  WebElement eng = driver.findElement(By.xpath("//a[text()='English']"));
	  eng.click();
	  
	  try 
	  {
		Thread.sleep(2000);
	  } 
	  catch (InterruptedException e) 
	  {
		e.printStackTrace();
	  }
	  
	  WebElement cs = driver.findElement(By.xpath("//a[text()='Case Status']"));
	  WebElement fn = driver.findElement(By.xpath("//a[text()='Filing Number']")); 
	  
	  Actions act = new Actions(driver);
	  act.moveToElement(cs).pause(Duration.ofSeconds(2)).moveToElement(fn).click().build().perform();
	  
	  try 
	  {
		Thread.sleep(2000);
	  } 
	  catch (InterruptedException e) 
	  {
		e.printStackTrace();
	  }
	  
	  Alert alt = driver.switchTo().alert();
	  alt.accept();
	  
	  try 
	  {
		Thread.sleep(2000);
	  } 
	  catch (InterruptedException e) 
	  {
		e.printStackTrace();
	  }
	  
	  WebElement distList = driver.findElement(By.id("sess_dist_code"));
	  Select selectDist= new Select(distList);
	  selectDist.selectByVisibleText("Sangli-सांगली ");
  }
  
  @AfterTest
  public void afterTest()
  {
	  try 
	  {
		Thread.sleep(2000);
	  } 
	  catch (InterruptedException e)
	  {
		e.printStackTrace();
	  }
	  driver.quit();
  }

}
