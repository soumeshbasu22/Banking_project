package com.banking.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.banking.browser.Browserfactory;
import com.banking.browser.Helper;
import com.banking.testcases.TestCases;

public class BaseClass {
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	public TestCases tc;
	Helper help;
	@Parameters("url")
	@BeforeClass
	public void setUp(String url) {
		driver=Browserfactory.browser(driver,"Chrome",url);
		String filepath="C:\\Users\\soumesh\\git\\Banking_project\\Bankingproject\\Reports\\newcustomer.html";
		ExtentHtmlReporter html=new ExtentHtmlReporter(filepath);
		report=new ExtentReports();
		report.attachReporter(html);
	}
	@AfterClass
	public void tearDown() {
		Browserfactory.quitBrowser(driver);
	}
	@AfterMethod
	public void teardownMethod(ITestResult result) throws Exception {
		tc=new TestCases();
		help=new Helper();
		
		System.out.println(result.getStatus());
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed");
			Thread.sleep(4000);
			
		}
			else {
				test.log(Status.FAIL, "Test failed");
				help.screenshot(driver);
			}
		report.flush();
	}

}
