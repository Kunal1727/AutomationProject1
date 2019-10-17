package com.testng.practise.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

//Study of frame handling..

public class TestDemo3 
{
	WebDriver driver;
	
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");
	  driver.manage().window().maximize();
  }
  
  @Test
  public void handleFrame() 
  {
	  //first frame on website..
	  WebElement frame1 = driver.findElement(By.name("packageListFrame"));
	  driver.switchTo().frame(frame1);
	  WebElement link1 = driver.findElement(By.linkText("com.thoughtworks.selenium"));
	  link1.click();
	  driver.switchTo().defaultContent();
	  
	  //second frame on website..
	  WebElement frame2=driver.findElement(By.name("packageFrame"));
	  driver.switchTo().frame(frame2);
	  WebElement link2 = driver.findElement(By.linkText("Selenium"));
	  link2.click();
	  driver.switchTo().defaultContent();
	  
	  //third frame on website..
	  WebElement frame3 = driver.findElement(By.name("classFrame"));
	  driver.switchTo().frame(frame3);
	  WebElement deprecatedBtn =driver.findElement(By.xpath("(//a[text()='Deprecated'])[1]"));
	  deprecatedBtn.click();
	  driver.switchTo().defaultContent();
  }
  
  @AfterTest
  public void afterTest() 
  {
	  try 
	  {
		Thread.sleep(3000);
	  } 
	  catch (InterruptedException e) 
	  {
		e.printStackTrace();
	  }
	  driver.quit();
  }

}
