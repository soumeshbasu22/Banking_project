package com.banking.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.banking.browser.Browserfactory;
import com.banking.browser.ConfigDataProvider;
import com.banking.browser.ExcelDataProvider;
import com.banking.browser.ExcelDataProvider2;
import com.banking.pages.ObjectRepository1;
import com.banking.pages.ObjectRepository2;
import com.banking.pages.ObjectRepository3;

public class TestCases {
	WebDriver driver;
	ConfigDataProvider cdp;
	ObjectRepository1 or;
	ObjectRepository2 or1;
	ExcelDataProvider edp;
	ExtentReports report;
	ExtentTest test;
	ExcelDataProvider2 edp2;
	ObjectRepository3 or3;
	@BeforeTest
	public void setUp() {
		driver=Browserfactory.browser(driver, "Chrome", "https://demo.guru99.com/test/newtours/");
		String filepath="C:\\Users\\soumesh\\eclipse-workspace\\Bankingproject\\Reports\\newcustomer.html";
		ExtentHtmlReporter html=new ExtentHtmlReporter(filepath);
		report=new ExtentReports();
		report.attachReporter(html);
	}
	@Test
	public void login() throws Exception {
		or=new ObjectRepository1(driver);
		cdp=new ConfigDataProvider();
		or.login(cdp.getuid(), cdp.getpwd());
	}
	public void newcustomer() throws Exception{
		test=report.createTest("new customer addition");
		or1=new ObjectRepository2(driver);
		edp=new ExcelDataProvider();
		int rownum=edp.sh.getLastRowNum()-edp.sh.getFirstRowNum();
		for(int i=1;i<=rownum;i++) {
			String cname=edp.customername(i);
			String gender=edp.gender(i);
			String dob=edp.dob(i);
			String address=edp.address(i);
			String city=edp.city(i);
			String state=edp.state(i);
			String pin=edp.pin(i);
			String email=edp.mail(i);
			or1.newcust(cname, gender, dob, address, city, state, pin, email);
			try {
				if(driver.findElement(By.xpath("//*[contains(text(),'NO')]")).isDisplayed()) {
					System.out.println("yo");
					test.log(Status.FAIL, "Error in localhost");
					driver.navigate().back();
				}
				
			} catch (Exception e) {
				test.log(Status.PASS, "Test Passed");	
			}
		}edp.wb.close();
		report.flush();
	}
	public void addaccount() throws Exception {
		edp2=new ExcelDataProvider2();
		or3=new ObjectRepository3(driver);
		test=report.createTest("Add Account");
		int rownum=edp.sh.getLastRowNum()-edp.sh.getFirstRowNum();
		for(int i=1;i<=rownum;i++) {
			String custid=edp2.CustomerID(i);
			char[] c=edp2.CustomerID(i).toCharArray();
			for(int j=0;j<=4;j++) {
			if(Character.isDigit(c[j])) {
				System.out.println("it should throw an error");
			}}
			String amount=edp2.Amount(i);
			String acctype=edp2.AccountType(i);
			or3.newaccountcreation(custid, acctype, amount);
			try {
				driver.findElement(By.xpath("//*[contains(text(),'localhost')]"));
				test.log(Status.FAIL, "Error in Local Host");
			} catch (Exception e) {
				test.log(Status.PASS, "Account added");
			}
		}
	}
	public static void main(String[] args) throws Exception {
		TestCases tc=new TestCases();
		tc.setUp();
		tc.login();
		tc.newcustomer();
		tc.addaccount();
	}
}
