package com.banking.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browserfactory {
	public static WebDriver browser(WebDriver driver,String browsername,String url) {
		if(browsername=="Chrome") {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\soumesh\\git\\Banking_project\\Bankingproject\\chromedriver2.exe");
			//ChromeOptions option=new ChromeOptions();
			//option.setHeadless(true);
			driver=new ChromeDriver();
			}
		else if(browsername=="headless") {
			ChromeOptions option=new ChromeOptions();
			option.setHeadless(true);
			driver=new ChromeDriver(option);
		}
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
