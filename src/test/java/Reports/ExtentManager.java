package Reports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
	String filePath=System.getProperty("User.dir")+"/Reports";
	
	public synchronized static ExtentReports getReporter(String filePath){
		
		if(extent==null){
			extent=new ExtentReports(filePath);
		}
		return extent;
	}
	
	public synchronized static ExtentReports getReporter(){
		
		return extent;
	}
	
}