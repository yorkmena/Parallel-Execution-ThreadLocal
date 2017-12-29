package tests;

import java.lang.reflect.Method;

import org.testng.IInvokedMethod;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Reports.ExtentManager;
import Reports.ExtentTestManager;

public class Testbase1 {

	String filePath;
	
	@BeforeMethod
	public void beforeMethod(Method method){
		
		String filePath=System.getProperty("User.dir")+"/Reports";
		ExtentTestManager.startTest(method.getName());	
	}
	/*
	@BeforeTest
	public static void BeforeMethod(IInvokedMethod method){
		
	  ExtentTest test=ExtentTestManager.startTest(method.getTestMethod().getMethodName());
	}*/
	
	@AfterMethod
	public static void AfterMehod(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
		}
		
		else if (result.getStatus()==ITestResult.SKIP){
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
		}
		
		ExtentTestManager.endTest(ExtentTestManager.getTest());
		ExtentManager.getReporter().flush();
	}
}