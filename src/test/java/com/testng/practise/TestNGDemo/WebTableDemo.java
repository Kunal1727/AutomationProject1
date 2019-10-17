package com.testng.practise.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WebTableDemo 
{
	WebDriver driver;
	
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
	  driver.manage().window().maximize();
  }
  @Test
  public void webtable() 
  {
	  WebElement username= driver.findElement(By.id("txtUsername"));
	  username.sendKeys("Admin");
	  WebElement pass= driver.findElement(By.id("txtPassword"));
	  pass.sendKeys("admin123");
	  WebElement loginBtn= driver.findElement(By.id("btnLogin"));
	  loginBtn.click();
	  
	  List<WebElement>rows = driver.findElements(By.tagName("tr"));
	  try 
	  {
		Thread.sleep(1500);
	  } 
	  catch (InterruptedException e)
	  {
		e.printStackTrace();
	  }
	  
	  for(int i=1;i<rows.size();i++)
	  {
		WebElement name= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")); 
		System.out.println(name.getText());
		if(name.getText().equals("Linda Anderson"))
		{
			WebElement radio= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]"));
			radio.click();
		}
	  }
	  try 
	  {
		Thread.sleep(1500);
	  } 
	  catch (InterruptedException e)
	  {
		e.printStackTrace();
	  }
	  WebElement deleteBtn= driver.findElement(By.id("btnDelete"));
	  deleteBtn.click();
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
