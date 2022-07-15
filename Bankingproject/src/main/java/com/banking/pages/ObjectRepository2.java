package com.banking.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectRepository2 {
	WebDriver driver;
	By newcustlink=By.xpath("//*[text()='New Customer']");
	By cname=By.xpath("//*[@onkeyup='validatecustomername();']");
	By gender=By.xpath("//*[@name='rad1']");
	By dob=By.cssSelector("input[name='dob']");
	By address=By.cssSelector("textarea[name='addr']");
	By city=By.cssSelector("input[name='city']");
	By state=By.xpath("//*[@name='state']");
	By pin=By.xpath("//*[@name='pinno']");
	By mail=By.xpath("//*[@name='emailid']");
	By submit=By.xpath("//*[@name='sub']");
	
	public ObjectRepository2(WebDriver driver){
		this.driver=driver;
	}
	
	public void newcust(String Cname,String Gender,String DOB,String Address,String City,String State,String PIN,String Email) throws Exception {
		driver.findElement(newcustlink).click();
		driver.findElement(cname).sendKeys(Cname);
		List<WebElement>gend=driver.findElements(gender);
		if(Gender=="male") {
			gend.get(0).click();
		}
		else {
			gend.get(1).click();
		}
		driver.findElement(dob).sendKeys(DOB);
		driver.findElement(address).sendKeys(Address);
		driver.findElement(city).sendKeys(City);
		driver.findElement(state).sendKeys(State);
		driver.findElement(pin).sendKeys(PIN);
		driver.findElement(By.xpath("//*[@name='telephoneno']")).sendKeys("9007685670");
		driver.findElement(mail).sendKeys(Email);
		driver.findElement(submit).click();
		
		
		
	}
}
