package Listners;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import pages.IndexPage;
import pages.LoginPage;
import pages.MobilePage;
import pages.MyAccountsPage;
import pages.RegistrationPage;
import BrowserFactory.LocalDriverFactory;
import BrowserFactory.LocalDriverManager;
import Resources.utility;

public class WebDriverListner implements IInvokedMethodListener {
	
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            System.out.println(browserName);
            WebDriver driver = LocalDriverFactory.createInstance(browserName);
            LocalDriverManager.setWebDriver(driver);
            
          
              
        }
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {
            WebDriver driver = LocalDriverManager.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }
	}

}
