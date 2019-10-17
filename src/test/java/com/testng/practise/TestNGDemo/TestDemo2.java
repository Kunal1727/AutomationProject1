package com.testng.practise.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

//How to open a single webpage in multiple browser using .xml file (parellel testing..)

public class TestDemo2 
{ 
	
  WebDriver driver;
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String browserName) 
  {
	  if(browserName.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		  driver=new ChromeDriver();  
	  }
	  else if(browserName.equals("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
		  driver=new FirefoxDriver(); 
	  }
	  else if(browserName.equals("ie"))
	  {
		  System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
		  driver=new InternetExplorerDriver(); 
	  }
	  driver.get("https://www.facebook.com/");
	  driver.manage().window().maximize();
  }
  
  @Test
  public void performLogin()
  {
	  WebElement email= driver.findElement(By.id("email"));
	  email.sendKeys("kunalwagh1163@gmail.com");
	  WebElement password= driver.findElement(By.id("pass"));
	  password.sendKeys("kunal1163");
	  WebElement loginBtn= driver.findElement(By.xpath("//input[@type='submit']"));
	  loginBtn.click();
  }
  
  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
