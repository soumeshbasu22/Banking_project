package com.banking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ObjectRepository3 {
	WebDriver driver;
	By custid=By.cssSelector("input[name='cusid']");
	By acctype=By.cssSelector("select[name='selaccount']");
	By amount=By.xpath("//input[@name='inideposit']");
	By submitbut=By.xpath("//input[@name='button2']");
	//By addacclink=By.cssSelector("a[href='addAccount.php']");
	By addacclink=By.xpath("//*[text()='New Account']");
	public ObjectRepository3(WebDriver driver) {
		this.driver=driver;
	}
	public void newaccountcreation(String customerid,String accounttype,String amountini) {
		driver.findElement(addacclink).click();
		driver.findElement(custid).sendKeys(customerid);
		Select sel=new Select(driver.findElement(acctype));
		sel.selectByValue(accounttype);
		driver.findElement(amount).sendKeys(amountini);
		driver.findElement(submitbut).click();
		
	}
}
