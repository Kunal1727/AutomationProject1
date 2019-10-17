package com.testng.practise.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

//Study of drag and drop in selenium and Implicit & Explicit wait..

public class TestDemo5 
{
	WebDriver driver;
	
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver","Resource/chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //implicit wait..
	  driver.get("https://jqueryui.com/droppable/");
	  driver.manage().window().maximize();
  }
  
  @Test
  public void dragNDrop() 
  {
	  WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	  driver.switchTo().frame(frame1);
	  WebElement drag =driver.findElement(By.id("draggable"));
	  //WebElement drop =driver.findElement(By.id("droppable")); //find element directly..
	  
	  //explicit wait is waiting for single webelement in seconds...
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  WebElement drop= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("droppable")));
	 
	  //perform drag and drop action using actions class..
	  Actions act= new Actions(driver);
	  act.dragAndDrop(drag, drop).perform();
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
