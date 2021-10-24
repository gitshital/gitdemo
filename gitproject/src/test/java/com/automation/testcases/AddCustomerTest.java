package com.automation.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;

//import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.testbase.Testbase;
//import com.automation.testuUtility.ExcelReader;


public class AddCustomerTest extends Testbase{

	@Test (dataProvider="getData")
	public void addCustomer(String firstname,String lastname,String postcode,String alerttext){
	driver.findElement(By.cssSelector(OR.getProperty("addcusbtn"))).click();
	
	driver.findElement(By.cssSelector(OR.getProperty("firstname"))).clear();
	driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstname);
	
	driver.findElement(By.cssSelector(OR.getProperty("lastname"))).clear();
	driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastname);
	
	//driver.findElement(By.cssSelector(OR.getProperty("postcode"))).clear();
	driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postcode);
	
	driver.findElement(By.cssSelector(OR.getProperty("add"))).click();
	
	Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	String text=alert.getText();
	
	Assert.assertTrue(alert.getText().contains(alerttext));;
	if(text.equals(alerttext)) {
	Assert.assertTrue(true);
	}
	alert.accept();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException  {
	//String path=System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\Copy of DataProvider.xlsx";
	//ExcelReader reader=new ExcelReader(path);
	
	String sheetname="AddCustomerTest";
	
	int rows=excel.getRowCount(sheetname);
	int cols=excel.getColumnCount(sheetname,1);
	
	Object[][] data=new Object[rows][cols];
	
	for(int rownum=1;rownum<=rows;rownum++) {
		for(int colnum=0;colnum<cols;colnum++) {
		data[rownum-1][colnum]=excel.getCellData(sheetname,rownum,colnum);	
		}
	}
		return data;
	}
		
		
		
		
		
	}

