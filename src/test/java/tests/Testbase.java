package tests;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

import BrowserFactory.LocalDriverManager;
import Resources.utility;
import pages.IndexPage;
import pages.LoginPage;
import pages.MobilePage;
import pages.MyAccountsPage;
import pages.RegistrationPage;


public class Testbase {
	
	public WebDriver driver;
	utility utils;
	IndexPage Index;
	MobilePage Mobile;
	RegistrationPage Registration;
	MyAccountsPage MyAccount; 
	LoginPage login;
	
	public static ExtentReports extent;
	//public ExtentHtmlReporter htmlReporter;
	public static ExtentTest logger;
	

	@BeforeSuite
	public void setup()
	{
		utils=new utility();
		extent = new ExtentReports("C:\\Users\\pc\\workspace1\\parallelframework\\Reposrts\\myExtentReport.html",true);
		extent
		.addSystemInfo("Host Name", "Thinksys")
		.addSystemInfo("Environment", "QA-Thinksys")
        .addSystemInfo("User Name", "Ashish Mathur");
		
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
	  //@Parameters("browser")
	  @BeforeMethod
	  public void beforeMethod() {

	 // logger=extent.startTest(this.getClass().getSimpleName()+"::"+method.getName()+"- "+browser, method.getName());
		    
	//  Browserfactory browserfactory=new Browserfactory(driver);
	  
	  WebDriver driver = LocalDriverManager.getDriver();
	  
	 // logger.log(LogStatus.PASS, "Browser Launched Successfully");
	
	  Index=new IndexPage(driver);
	  Mobile=new MobilePage(driver);
	  Registration=new RegistrationPage(driver);
	  MyAccount=new MyAccountsPage(driver);
	  login=new LoginPage(driver);
	  }
/*
	  @AfterMethod
	  public void teardownMethod(ITestResult result)
	  
		{
			if(result.getStatus()==ITestResult.FAILURE)
			{
				System.out.println("is driver null"+driver.equals(null)+":: result is: "+ result.getStatus());
				String path= utils.captureScreenshoot(driver, result.getName());
				logger.log(LogStatus.FAIL,result.getName(), logger.addScreenCapture(path));
			}
			
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				//String path=  utils.captureScreenshoot(driver, result.getName());
				logger.log(LogStatus.PASS,result.getName());
			}
			
			
			 driver.quit();
			 logger.log(LogStatus.PASS, "Browser Closed");
			 extent.endTest(logger);
		}
	  
	  */
	  
	/*  
	  @AfterSuite
	  public void afterSuite()
	  {
		  
		   extent.flush();
		   //extent.close();
		 
	  }*/
}
