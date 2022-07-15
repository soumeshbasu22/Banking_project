package com.banking.browser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider2 {
public XSSFWorkbook wb;
public XSSFSheet sh;
public ExcelDataProvider2() throws Exception {
	String filepath="C:\\Users\\soumesh\\eclipse-workspace\\Bankingproject\\ExcelData\\NewAccount.xlsx";
	FileInputStream fis=new FileInputStream(filepath);
	wb=new XSSFWorkbook(fis);
	sh=wb.getSheet("Sheet1");
}
public  String CustomerID(int i) {
	return sh.getRow(i).getCell(0).getStringCellValue();
}
public String AccountType(int i) {
	return sh.getRow(i).getCell(1).getStringCellValue();
}
public String Amount(int i) {
	return sh.getRow(i).getCell(2).getStringCellValue();
}
}
