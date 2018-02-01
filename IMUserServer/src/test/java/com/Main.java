package com;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Main {
  @Test
  public static void IMUserServerMain() throws MalformedURLException, InterruptedException {
	  //Windows配置
	  System.setProperty("webdriver.chrome.driver","F:/autotest/chrome/chromedriver/2.23/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();	
	  
	  //linux配置
	  //DesiredCapabilities chromeDC = DesiredCapabilities.chrome();
	  //WebDriver driver = new RemoteWebDriver(new URL("http://172.17.184.136:4444/wd/hub"), chromeDC);
	  driver.get("http://172.17.184.115:17011/IMUserServer/user/logout.action");	
	  driver.manage().window().maximize();
	  IMUserServer2 iMUserServer = new IMUserServer2();
		  iMUserServer.login(driver);
		  //iMUserServer.org_Basic(driver);
		  //iMUserServer.orgSet_Logo(driver);
		  iMUserServer.addUsers(driver);
		  //iMUserServer.addDept(driver);
		  Thread.sleep(10000);
		  driver.quit();
  }
  @Test
  public static void test()throws MalformedURLException, InterruptedException{
	  System.setProperty("webdriver.chrome.driver","F:/autotest/chrome/chromedriver/2.23/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  Thread.sleep(1000);	
	  driver.get("http://172.17.184.115:17011/IMUserServer/user/logout.action");	
	  driver.manage().window().maximize();
	  String windowHandles = driver.getWindowHandle().toString();
	  IMUserServer2 iMUserServer = new IMUserServer2();
	  iMUserServer.login(driver);
	  iMUserServer.addUser(driver);
	  //driver.navigate().refresh();
	  driver.navigate().back();

	  //driver.get("http://172.17.184.212:7001/IMUserServer/user/logout.action");	
	  //driver.manage().window().maximize();
  }
 
}
