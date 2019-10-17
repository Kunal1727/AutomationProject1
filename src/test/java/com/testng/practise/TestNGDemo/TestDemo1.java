package com.testng.practise.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestDemo1 
{

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("BEFORE TEST..");
  }
  
  @Test(priority=4)
  public void awake() 
  {
	  System.out.println("AWAKE..");
  }
  
  @Test(priority=3)
  public void breakFast() 
  {
	  System.out.println("BREAKFAST..");
  }
  
  @Test(priority=2)
  public void xerox() 
  {
	  System.out.println("XEROX..");
  }
  
  @Test(priority=1)
  public void zigzag() 
  {
	  System.out.println("ZIGZAG..");
  }
  
  @Test(enabled=false)//it won't run this method..
  public void run() 
  {
	  System.out.println("RUN..");
  }
  
  @AfterTest
  public void afterTest() 
  {
	  System.out.println("AFTER TEST..");
  }

}
