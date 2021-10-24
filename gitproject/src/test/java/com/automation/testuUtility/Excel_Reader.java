package com.automation.testuUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	public FileInputStream fis = null;
	   public XSSFWorkbook workbook = null;
	   public XSSFSheet sheet = null;
	   public XSSFRow row = null;
	   public XSSFCell cell = null;
	   String xlFilePath=null;
	 
	   public Excel_Reader(String xlFilePath) 
	   {
	       this.xlFilePath = xlFilePath;
	       try {
	       fis = new FileInputStream(xlFilePath);
	       workbook = new XSSFWorkbook(fis);
	       fis.close();
	       }catch(Exception e) {
	    	e.printStackTrace();   
	       }
	       }
	   public int getRowCount(String sheetName) throws IOException
	   {
		   fis=new FileInputStream(xlFilePath);
		   workbook=new XSSFWorkbook(fis);
		   
	       sheet = workbook.getSheet(sheetName);
	       int rowCount = sheet.getLastRowNum();
	       workbook.close();
	       fis.close();
	       return rowCount;
	   }
	 
	   public int getColumnCount(String sheetName,int rownum) throws IOException 
	   {
		   fis=new FileInputStream(xlFilePath);
		   workbook=new XSSFWorkbook(fis);
		   sheet = workbook.getSheet(sheetName);
	       row = sheet.getRow(rownum);
	       int colCount = row.getLastCellNum();
	       workbook.close();
	       fis.close();
	       return colCount;
	   }
	   
	   public String getCellData(String sheetname,int rownum,int colnum) throws IOException {
		   fis=new FileInputStream(xlFilePath);
		   workbook=new XSSFWorkbook(fis);
		   sheet = workbook.getSheet(sheetname);
	       row = sheet.getRow(rownum);
	       cell=row.getCell(colnum);
	       DataFormatter format=new DataFormatter();
	       String data;
	       try {
	    	   data=format.formatCellValue(cell);
	       }catch(Exception e){
	    	   data="";
	    	   e.printStackTrace();
	    	   
	       }
	       workbook.close();
	       fis.close();
	       return data;
		   
		   
		   
		   
	   }
}



