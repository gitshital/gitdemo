package com.automation.testbase;


import java.io.FileInputStream;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.automation.testuUtility.Excel_Reader;
//import com.automation.testuUtility.Extentmanager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream ip;
	public static FileInputStream io;
	
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static Excel_Reader excel=new Excel_Reader("C:\\Users\\amitn\\eclipse-workspace\\LiveProject1\\src\\test\\resources\\excel\\Copy of DataProvider.xlsx");
	public static WebDriverWait wait;
	//public ExtentReports rep=Extentmanager.getInstance();
	//public ExtentTest test;
	@BeforeSuite
	public void setUp() throws Exception {
		if(driver==null) {
		 ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		config.load(ip);
	log.debug("config file loaded");
	
	 io=new FileInputStream("C:\\Users\\amitn\\eclipse-workspace\\LiveProject1\\"
	 		+ "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(io);
log.debug("OR loaded");
		
		}	
	if (config.getProperty("browser").equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",
						    "C:\\Users\\amitn\\Desktop\\chromedriver.exe");
	   driver=new ChromeDriver();
		//System.out.println("Browser lounched successfully");
//		log.debug("Browser launch");
			}

//			else if (config.getProperty("browser").equals("Firefox")) {
//				System.setProperty("webdriver.gecko.driver", "gecko.exe");
//				driver=new FirefoxDriver();
//			}
			driver.get(config.getProperty("testsiteurl"));
			System.out.println("open url");
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitwait")),TimeUnit.SECONDS);
		wait=new WebDriverWait(driver,5);
	}
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
		
		return true;
	}catch(NoSuchElementException e) {
		return false;
	}
	
	}
	
	
	
 
@AfterSuite
	public void tearDown() {
	if(driver!=null) {
		driver.quit();}
		
	}

}
