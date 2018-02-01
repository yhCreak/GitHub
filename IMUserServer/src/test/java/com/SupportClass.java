package com;

import java.util.Random;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SupportClass {
	static String excelPath = "F:/autotest/Excel/employees.xlsx";
  @Test
  public  String getFixLenthString(int strLength) {  
      
	    Random rm = new Random();  
	      
	    // 获得随机数  
	    int pross = (int)((1 + rm.nextDouble()) * Math.pow(10, strLength));  
	  
	    // 将获得的获得随机数转化为字符串  
	    String fixLenthString = String.valueOf(pross);  
	  
	    // 返回固定的长度的随机数  
	    return fixLenthString.substring(1, strLength + 1);  
	}
  @Test
  public String myAssert(String actual,String expected,String successMessage,String failMessage){
	  
	  if ((expected == null) && (actual == null))
		  return failMessage+"fail,both are null";
	  else if ((expected != null) && (expected.equals(actual))){
		  return successMessage+"success,expected<"+expected+">actual<"+actual+">";
	  }
	  else{
		  return failMessage+"fail,,expected<"+expected+">actual<"+actual+">";
	  }
	  
  }
  @Test
  public String myAssertNot(String after,String before,String successMessage,String failMessage){
	  
	  if (after == null)
		  return failMessage+"fail,after is null";
	  else if (before!=after){
		  return successMessage+"success,before<"+before+">after<"+after+">";
	  }
	  else{
		  return failMessage+"fail,before<"+before+">after<"+after+">";
	  }
	  
  }
  @Test
  public void myAssert(String actual,String expected){
	  myAssert(actual,expected,null,null);
  }
  @Test
  public void message(String message){
	  System.out.println(message);
  }
  public boolean isAlertPresent(WebDriver driver){  
      try  
      {  
          driver.switchTo().alert();  
          return true;  
      }     
      catch (NoAlertPresentException Ex)  
      {  
          return false;  
      }   
  }

}
