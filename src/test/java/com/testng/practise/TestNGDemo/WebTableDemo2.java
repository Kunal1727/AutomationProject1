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

public class WebTableDemo2 
{
	WebDriver driver;
	
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.navigate().to("http://toolsqa.com/automation-practice-table/");
	  driver.manage().window().maximize();
  }
  
  @Test
  public void displayTable() 
  { 
	  String structure = null,country = null,height = null,built = null,rank = null;
	  String country1 = null,city1=null,height1 = null,built1 = null, rank1 = null;
	  List<WebElement> rows =driver.findElements(By.xpath("//table/tbody/tr"));
	  //System.out.println(rows.size());
	  for(int i=1;i<=rows.size();i++)
	  {
		  WebElement city = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
		  //System.out.println(city.getText());
		  if(city.getText().equals("Dubai"))
		  {
			structure =driver.findElement(By.xpath("//table/tbody/tr["+i+"]/th")).getText();
			country=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
			height=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
			built=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();
			rank=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText();
		  }
		  
		  WebElement structureElement = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/th"));
		  if(structureElement.getText().equals("Clock Tower Hotel"))
		  {
			  country1=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
			  city1=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText();
			  height1=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
			  built1=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();
			  rank1=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText();
		  }
	  }
	  
	  System.out.println("Dubai Details = "+structure+" "+country+" "+height+" "+built+" "+rank);
	  System.out.println("Clock tower hotel Details = "+country1+" "+city1+" "+height1+" "+built1+" "+rank1);
	  
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
