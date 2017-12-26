package tests;

import org.testng.IInvokedMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentTest;

import Reports.ExtentManager;
import Reports.ExtentTestManager;

public class Testbase1 {

	String filePath;
	
	@BeforeSuite
	public static void setup(){
		String filePath=System.getProperty("User.dir")+"/Reports";
		ExtentManager extent=extent.getReporter(filePath);
	}
	
	@BeforeTest
	public static void BeforeMethod(IInvokedMethod method){
		
		ExtentTest test=ExtentTestManager.startTest(method.getTestMethod().getMethodName());
	}
	
	@AfterMethod
	public static void AfterMehod(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
		}
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			
		}
		
		ExtentTestManager.endTest(ExtentTestManager.getTest());
		
	}
		
}