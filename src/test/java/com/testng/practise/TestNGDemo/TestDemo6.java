package com.testng.practise.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

//Study window handling in selenium...

public class TestDemo6 
{
	WebDriver driver;
	
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
	  driver.manage().window().maximize();
  }
  
  @Test
  public void handleWindows() 
  {
	WebElement acceptCookie= driver.findElement(By.id("cookie_action_close_header"));
	acceptCookie.click();
	
	WebElement addNewWindows =driver.findElement(By.id("button1"));
	addNewWindows.click();
	
	String mainWinHandle = driver.getWindowHandle();
	Set<String> allWinHandles= driver.getWindowHandles();
	for (String win : allWinHandles) 
	{
		if(!win.equals(mainWinHandle))
		{
			driver.switchTo().window(win);
			driver.manage().window().maximize();
		}
	}
  }
  
  @AfterTest
  public void afterTest() 
  {
	  try 
	  {
		Thread.sleep(1500);
	  } 
	  catch (InterruptedException e)
	  {
		e.printStackTrace();
	  }
	  driver.quit();
  }

}
