package Reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {

	static String filePath=System.getProperty("user.dir"+"/Report/myReport.html");
	static ExtentReports extent=ExtentManager.getReporter(filePath);
	static ExtentTest test;
	
	static Map<Integer,ExtentTest> testMap = new HashMap();
	
	public synchronized static ExtentTest startTest(String testName, String desc){
		
		test=extent.startTest(testName,desc);
		testMap.put((int)Thread.currentThread().getId(), test);
		return test;
	}
	
	public synchronized static void endTest(ExtentTest test){
		extent.endTest(test);
		
	}
	
	public synchronized static ExtentTest getTest(){
		
		return test;
		
		
		
	} 
	
	
}
