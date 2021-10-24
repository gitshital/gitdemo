package com.automation.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automation.testbase.Testbase;

public class Logintest extends Testbase {
	
@Test
	public void loginAsBankMngr() throws InterruptedException{
	//System.setProperty("org.uncommons.reportng.escape-output","false");
//	log.debug("inside login test");
		driver.findElement(By.cssSelector(OR.getProperty("bmlbtn"))).click();
		Thread.sleep(3000);
//		log.debug("click on mlbtn successful");
//		Reporter.log("login successful");
//		Reporter.log("capture Screenshot");
//		Reporter.log("<a href=\"C:\\Users\\amitn\\Downloads\\Sample.jpg\">Screenshot</a>");
//		Reporter.log("<br>");
//		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\amitn\\Downloads\\Sample.jpg\"  height=200 width=200><img src=\"C:\\Users\\amitn\\Downloads\\Sample.jpg\"></img></a>");	
//			
		//Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addcusbtn"))),"Element not Present");
		Assert.fail("login not successful");
	}


}
