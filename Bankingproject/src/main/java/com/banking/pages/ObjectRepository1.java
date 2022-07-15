package com.banking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjectRepository1 {
	 WebDriver driver;
	 public static By projectname=By.xpath("//*[text()='Bank Project']");
	 public static By uid=By.xpath("//*[@name='uid']");
	 public static By pwd=By.xpath("//*[@name='password']");
	 public static By loginbtn=By.xpath("//*[@name='btnLogin']");
	 
	 public ObjectRepository1(WebDriver driver){
		 this.driver=driver;
	 }
	 public void login(String userid,String password) throws Exception {
		 driver.findElement(projectname).click();
		 Thread.sleep(12000);
		 driver.navigate().refresh();
		 driver.findElement(projectname).click();
		 driver.findElement(uid).sendKeys(userid);
		 driver.findElement(pwd).sendKeys(password);
		 driver.findElement(loginbtn).click();
		 
	 }
}
