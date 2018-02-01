package com;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
public class IMUserServer2 {
	SupportClass sc = new SupportClass();
  //登录
  @Test
  public static void login(WebDriver driver){
	  try{
		Thread.sleep(2000);	
	  WebElement username = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/input"));
	  username.sendKeys("13674609982");
		Thread.sleep(1000);	
	  WebElement password = driver.findElement(By.id("password"));
	  password.sendKeys("123456");
		Thread.sleep(1000);	
	  WebElement yzm = driver.findElement(By.id("yzm"));
	  yzm.sendKeys("1111");
	  WebElement btnLogin = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[4]/button"));
	  btnLogin.click();
	  Thread.sleep(1000);	
	  if(driver.findElement(By.xpath("//body/div[1]/div[1]/h1[1]/img")) != null){
		  System.out.println("登录成功");
	  }else{
		  System.out.println("登录失败,请检查用户名或密码是否正确");
	  } 
	  }catch(Exception e){
		  e.printStackTrace();
		  System.out.println("登录失败");
		  driver.navigate().refresh();
	  }
  }
  //基本信息
  @Test
  public static void org_Basic(WebDriver driver){
	  try{
		  
	  Thread.sleep(1000);	
	  //切换表单
	  driver.switchTo().frame("right_iframe");
	  Thread.sleep(1000);	
	  //定位省份元素
	  WebElement provinceBlank = driver.findElement(By.xpath("//body/div[1]/form[1]/div[4]/div[1]/ul[1]/li[2]/input[2]"));
	  provinceBlank.click();
	  Thread.sleep(1000);
	  //选择省份
	  WebElement province = driver.findElement(By.xpath("//body/div[2]/a[2]"));
	  province.click();
	  Thread.sleep(1000);
	  //定位城市元素
	  WebElement cityBlank = driver.findElement(By.xpath("//body/div[1]/form[1]/div[4]/div[1]/ul[1]/li[3]/input[2]"));
	  cityBlank.click();
	  Thread.sleep(1000);
	  //选择城市
	  WebElement city = driver.findElement(By.xpath("//body/div[3]/a[2]"));
	  city.click();
	  Thread.sleep(1000);
	  //
	  WebElement linkman = driver.findElement(By.xpath("//body/div[1]/form[1]/div[4]/div[1]/ul[3]/li[2]/input[2]"));
	  linkman.sendKeys("联系人");
	  Thread.sleep(1000);
	  //皮肤颜色
	  WebElement pcSkin = driver.findElement(By.xpath("//body/div[1]/form[1]/div[6]/div[1]/ul[1]/li[2]"));
	  pcSkin.click();
	  Thread.sleep(1000);
	  //保存
	  WebElement save = driver.findElement(By.xpath("//body/div[1]/form[1]/div[7]/input"));
	  save.click();
	  Thread.sleep(1000);
	  //转到警告并确定
	  driver.switchTo().alert().accept();
	  Thread.sleep(2000);
	  System.out.println("编辑基本信息成功");
	  //关闭浏览器
	  //driver.quit();
	  }catch(Exception e){
		  e.printStackTrace();
		  System.out.println("编辑基本信息失败");
		  driver.navigate().refresh();
	  }
  }
  //机构logo
  @Test
  public void orgSet_Logo(WebDriver driver){
	  try{
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();
	  WebElement orgLogo = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/h3[2]/a"));
	  orgLogo.click();
	  Thread.sleep(1000);
	  driver.switchTo().frame("right_iframe");
	  WebElement uploadImg = driver.findElement(By.xpath("//body/div[1]/form[1]/div[3]/div[1]/input[5]"));
	  uploadImg.sendKeys("F:/autotest/PNG/autotest1.png");
	  
	  Thread.sleep(1000);
	  //driver.switchTo().frame("right_iframe");
	  WebElement save = driver.findElement(By.xpath("//body/div[1]/form[1]/div[3]/input"));
	  save.click();
	  Thread.sleep(1000);
	  //转到警告并确定
	  driver.switchTo().alert().accept();
	  Thread.sleep(2000);
	  System.out.println("设置logo成功");
	  //关闭浏览器
	  //driver.quit();
	  }catch(Exception e){
		  e.printStackTrace();
		  System.out.println("设置logo失败");
		  driver.navigate().refresh();
	  }
  }
//添加部门
  @Test
  public void addDept(WebDriver driver){
	  try{
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();
	  WebElement orgFrame = driver.findElement(By.xpath("//body/div[2]/div[1]/ul[1]/li[3]/a"));
	  orgFrame.click();
	  
	  Thread.sleep(1000);
	  WebElement addOrg = driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/h2[1]/span[1]/a[1]/img[1]"));
	  addOrg.click();
	  
	  Thread.sleep(1000);
	  WebElement addOrgInfo = driver.findElement(By.xpath("//body/div[3]/form[1]/ul[1]/li[3]/input"));
	  addOrgInfo.sendKeys(sc.getFixLenthString(5));
	  
	  Thread.sleep(1000);
	  WebElement save = driver.findElement(By.xpath("//body/div[3]/form[1]/ul[3]/li[1]/input[1]"));
	  save.click();
	  
	  Thread.sleep(1000);
	  driver.switchTo().alert().accept();
	  
	  System.out.println("添加部门成功");
	  }catch(Exception e){
		  e.printStackTrace();
		  System.out.println("添加部门失败");
		  driver.navigate().refresh();
	  }
  }
  //添加用户
  @Test
  public void addUser(WebDriver driver) throws InterruptedException{
	  try{
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();
	  WebElement orgFrame = driver.findElement(By.xpath("//body/div[2]/div[1]/ul[1]/li[3]/a"));
	  orgFrame.click();
	  //第一个部门
	  WebElement dept = driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/a"));
	  dept.click();
	  Thread.sleep(1000);
	  driver.switchTo().frame("right_iframe");
	  //同步员工按钮
	  //WebElement tbUser = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/a[1]"));
	  //导入员工按钮
	  //WebElement drUser = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/a[2]"));
	  //导出员工按钮
	  //WebElement dcUser = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/a[3]"));
	  //添加员工按钮
	  WebElement addUser = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/a[4]"));
	  addUser.click();
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();
	  WebElement userNum = driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[1]/li[3]/input"));
	  userNum.sendKeys("autotest");
	  WebElement userName= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[2]/li[3]/input"));
	  userName.sendKeys("test1");
	  WebElement logoinPassword= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[3]/li[3]/input"));
	  logoinPassword.sendKeys("123456");
	  WebElement cid= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[4]/li[3]/input"));
	  cid.sendKeys("123123123123123123");
	  WebElement userStation= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[5]/li[3]/input"));
	  userStation.sendKeys("QA");
	  WebElement phoneNum= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[6]/li[3]/input"));
	  phoneNum.sendKeys("138"+sc.getFixLenthString(8));
	  WebElement email= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[7]/li[3]/input"));
	  email.sendKeys("123123@qq.com");
	  //WebElement deptment= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[8]/li[3]/input"));
	  //deptment.click();
	  WebElement sex= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[10]/li[3]/select[1]/option[2]"));
	  sex.click();
	  WebElement saveUser= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[11]/li[1]/input[1]"));
	  saveUser.click();
	  Thread.sleep(1000);
	  driver.switchTo().alert().accept();
	  System.out.println("添加用户成功");
	  }catch(Exception e){
		  e.printStackTrace();
		  System.out.println("添加用户失败");
		  driver.navigate().refresh();
		  //login(driver);
	  }
  }
//添加用户
  @Test
  public void addUsers(WebDriver driver) throws InterruptedException{
	  try{
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();
	  WebElement orgFrame = driver.findElement(By.xpath("//body/div[2]/div[1]/ul[1]/li[3]/a"));
	  orgFrame.click();
	  //第一个部门
	  WebElement dept = driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/a"));
	  dept.click();
	  Thread.sleep(1000);
	  
	  //同步员工按钮
	  //WebElement tbUser = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/a[1]"));
	  //导入员工按钮
	  //WebElement drUser = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/a[2]"));
	  //导出员工按钮
	  //WebElement dcUser = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/a[3]"));
	  //添加员工按钮

	  for(int i=4;i<10;i++){
	  driver.switchTo().frame("right_iframe");
	  WebElement addUser = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/a[4]"));
	  addUser.click();
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();
	  WebElement userNum = driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[1]/li[3]/input"));
	  userNum.sendKeys("autotest"+i);
	  WebElement userName= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[2]/li[3]/input"));
	  userName.sendKeys("autotest"+i);
	  WebElement logoinPassword= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[3]/li[3]/input"));
	  logoinPassword.sendKeys("123456");
	  //WebElement cid= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[4]/li[3]/input"));
	  //cid.sendKeys("123123123123123123");
	  WebElement userStation= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[5]/li[3]/input"));
	  userStation.sendKeys("QA");
	  WebElement phoneNum= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[6]/li[3]/input"));
	  phoneNum.sendKeys("138"+sc.getFixLenthString(8));
	  //WebElement email= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[7]/li[3]/input"));
	  //email.sendKeys("123123@qq.com");
	  //WebElement deptment= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[8]/li[3]/input"));
	  //deptment.click();
	  //WebElement sex= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[10]/li[3]/select[1]/option[2]"));
	  //sex.click();
	  WebElement saveUser= driver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/ul[11]/li[1]/input[1]"));
	  saveUser.click();
	  Thread.sleep(1000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(2000);
	  }
	  System.out.println("添加用户成功");
	  }catch(Exception e){
		  e.printStackTrace();
		  System.out.println("添加用户失败");
		  driver.navigate().refresh();
		  //login(driver);
	  }
  }
}
