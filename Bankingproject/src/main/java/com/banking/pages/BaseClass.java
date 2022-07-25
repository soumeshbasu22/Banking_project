package com.banking.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

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
	@BeforeClass
	public void setUp() {
		driver=Browserfactory.browser(driver, "Chrome", "https://demo.guru99.com/test/newtours/");
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
		test=report.createTest("Report on Success");
		System.out.println(result.getStatus());
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed");
			Thread.sleep(4000);
			help.screenshot(driver);
		}report.flush();
	}

}
