package com.tutorialsninja.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	
	 public static String timestamp() {
			Date date=new Date();
			String timestamp = date.toString().replace(" ","_").replace(":", "_");
			return "Rajesh"+timestamp+"@gmail.com";
			
			}
	 
	 public static Object[][] exceldata(String sheetname) { 
		  
		  File excelfile= new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\tutorials\\qa\\testdata\\Tutorialsninja (2).xlsx");
		 XSSFWorkbook workbook = null;
		 
		try {
			FileInputStream fis = new FileInputStream(excelfile);
	     	workbook = new XSSFWorkbook(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
	    short columns = sheet.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[rows][columns];
	
	 for(int i=0;i<rows;i++) { 
		
		XSSFRow row = sheet.getRow(i+1);
		 
		 for (int j = 0; j < columns; j++) {
			XSSFCell cell = row.getCell(j);
		CellType celltype = cell.getCellType();
		
		switch (celltype) {
		
		case STRING:
			data[i][j]=cell.getStringCellValue();
			break;
		case NUMERIC:
			
			data[i][j]=Integer.toString((int)cell.getNumericCellValue());
			break;
		case BOOLEAN:
			data[i][j]=cell.getBooleanCellValue();
			break;
		   }
		}
	 }
	return data;
  }
}
