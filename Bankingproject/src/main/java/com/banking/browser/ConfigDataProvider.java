package com.banking.browser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	String filepath="C:\\Users\\soumesh\\git\\Banking_project\\Bankingproject\\Configuration\\config.txt";
	
	public String getuid() throws Exception {
		FileInputStream fis=new FileInputStream(filepath);
		pro=new Properties();
		pro.load(fis);
		return pro.getProperty("uid");
	}
	public String getpwd() throws Exception {
		FileInputStream fis=new FileInputStream(filepath);
		pro=new Properties();
		pro.load(fis);
		return pro.getProperty("pwd");
	}

}
