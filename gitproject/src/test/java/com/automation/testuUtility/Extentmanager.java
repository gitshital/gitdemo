package com.automation.testuUtility;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class Extentmanager {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance() {
		if(extent==null) {
			extent=new ExtentReports(System.getProperty("user.dir")+"\\", true,DisplayOrder.OLDEST_FIRST);
		
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\"
				+ "ExpentConfig\\ReportConfig.xml"));	
		
		}
		return extent;
	}
	
}
