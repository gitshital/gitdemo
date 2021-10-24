package com.automation.listners;

import java.io.IOException;

//import java.io.IOException;

//import java.io.IOException;

import org.testng.ITestContext ;		
import org.testng.ITestListener ;		
import org.testng.ITestResult ;
import org.testng.Reporter;

import com.automation.testbase.Testbase;
import com.automation.testuUtility.TestUtil;

import com.relevantcodes.extentreports.LogStatus;		

public class CustomListeners extends Testbase implements ITestListener						
{		

 
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub		
    	System.out.println("on finish");
        		
    }		

    
    public void onStart(ITestContext arg0) {					
        //test=rep.startTest(arg0.getName().toUpperCase());			
        	System.out.println("on finish");

    }	
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }			
    public void onTestFailure(ITestResult arg0) {					
     			
    	System.setProperty("org.uncommons.reportng.escape-output","false");
    	try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//test.log(LogStatus.FAIL,arg0.getName().toUpperCase()+"failed with exception:"+arg0.getThrowable());
    	//test.log(LogStatus.FAIL, test.addScreenCapture(Testutill.screenshotName);	
    		
    	
    	
    	Reporter.log("<a href=\"+TestUtill.Screenshotname+\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"+TestUtill.Screenshotname+\"  height=200 width=200><img src=\"+TestUtill.Screenshotname+\"></img></a>");	
		
		//rep.endTest(test);
   		//rep.flush();
    		

    }		
    	
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

   	
    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

 
    public void onTestSuccess(ITestResult arg0) {					
//       		test.log(LogStatus.PASS,arg0.getName().toUpperCase()+ "pass");
//       		rep.endTest(test);
//       		rep.flush();
        		
    }		
}		
