package com.automation.testuUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.testbase.Testbase;

public class TestUtil extends  Testbase{
	public static String Screenpath;
	public static String Screenshotname;
	
	
	public static void captureScreenshot() throws IOException {
		
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	Screenshotname="Sample.jpg";
	FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\test_output\\html\\ "+Screenshotname));
		
		
}
}
