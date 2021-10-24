package com.automation.Rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class TestProperties {

	public static void main(String[] args) throws IOException {
	System.out.println(System.getProperty("user.dir"));
		Properties config=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		Properties OR=new Properties();
FileInputStream ip=new FileInputStream("C:\\Users\\amitn\\eclipse-workspace\\LiveProject1\\"
		+ "src\\test\\resources\\properties\\OR.properties");
	OR.load(ip);
	//driver.findElement(By.cssSelector(or.getProperty("bmlbtn"))).click();
System.out.println(OR.getProperty("testsiteurl"));	
	System.out.println(config.getProperty("browser"));
	
	}

}
