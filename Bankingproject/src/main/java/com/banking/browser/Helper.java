package com.banking.browser;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.utils.FileUtil;

public class Helper {
	
	//WebDriver driver;
	
	public File screenshot(WebDriver driver) throws IOException {
		File dest=new File("C:\\Users\\soumesh\\git\\Banking_project\\Bankingproject\\Screenshots\\snap.png");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,dest);
		return dest;
	}

}
