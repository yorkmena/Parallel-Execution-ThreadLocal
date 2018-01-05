package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Reports.ExtentManager;
import Reports.ExtentTestManager;

@Test
public class ParallelMethodsTest {
    private final String filePath = System.getProperty("User.dir")+"ParallelMethodsTest.html";
    
    @BeforeSuite
    public void beforeSuite() {
       ExtentReports extent = ExtentManager.getReporter(filePath);
    }
    
    @Test
    public void parallelTest01() {
        ExtentTest test = ExtentTestManager.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        test.log(LogStatus.INFO, "Log from threadId: " + Thread.currentThread().getId());
        test.log(LogStatus.INFO, "Log from threadId: " + Thread.currentThread().getId());
        ExtentTestManager.endTest();
    }
    
    @Test
    public void parallelTest02() {
        ExtentTest test = ExtentTestManager.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        test.log(LogStatus.ERROR, "Log from threadId: " + Thread.currentThread().getId());
        test.log(LogStatus.ERROR, "Log from threadId: " + Thread.currentThread().getId());
        ExtentTestManager.endTest();
    }
	
    @AfterMethod
    public void afterEachTest(ITestResult result) {
        if (!result.isSuccess()) {
            test.log(LogStatus.FAIL, result.getThrowable());
        }
        
        extent.endTest(test);
        extent.flush();
    }
}