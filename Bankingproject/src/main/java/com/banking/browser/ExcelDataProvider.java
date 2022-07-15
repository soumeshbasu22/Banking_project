package com.banking.browser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.bytebuddy.implementation.bind.annotation.Super;

public class ExcelDataProvider {
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public ExcelDataProvider() throws Exception{
		String filepath="C:\\Users\\soumesh\\eclipse-workspace\\Bankingproject\\ExcelData\\NewCustomerDetails.xlsx";
		FileInputStream fi=new FileInputStream(filepath);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet("Sheet1");
	}
	public String customername(int i) {
		//int rownum=sh.getLastRowNum()-sh.getFirstRowNum();
		return sh.getRow(i).getCell(0).getStringCellValue();
		
	}
	public String gender(int i) {
		//int rownum=sh.getLastRowNum()-sh.getFirstRowNum();
		return sh.getRow(i).getCell(1).getStringCellValue();
		
	}
	public String dob(int i) {
		//int rownum=sh.getLastRowNum()-sh.getFirstRowNum();
		return sh.getRow(i).getCell(2).getStringCellValue();
		
	}
	public String address(int i) {
		//int rownum=sh.getLastRowNum()-sh.getFirstRowNum();
		return sh.getRow(i).getCell(3).getStringCellValue();
		
	}
	public String city(int i) {
		//int rownum=sh.getLastRowNum()-sh.getFirstRowNum();
		return sh.getRow(i).getCell(4).getStringCellValue();
		
	}
	public String state(int i) {
		//int rownum=sh.getLastRowNum()-sh.getFirstRowNum();
		return sh.getRow(i).getCell(5).getStringCellValue();
		
	}
	public String pin(int i) {
		//int rownum=sh.getLastRowNum()-sh.getFirstRowNum();
		return sh.getRow(i).getCell(6).getStringCellValue();
		
	}
	public String mail(int i) {
		//int rownum=sh.getLastRowNum()-sh.getFirstRowNum();
		return sh.getRow(i).getCell(7).getStringCellValue();
		
	}
}
