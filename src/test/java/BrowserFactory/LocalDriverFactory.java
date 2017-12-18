package BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import DataProvider.ConfigDataProvider;

public class LocalDriverFactory {
	
	    public static WebDriver createInstance(String browserName) {
	        WebDriver driver = null;
	        ConfigDataProvider config=new ConfigDataProvider();
	        
	        if (browserName.toLowerCase().contains("firefox")) {
	        	System.setProperty("webdriver.gecko.driver", config.getgeckoPath());
	            driver = new FirefoxDriver();
	            
	        }
	        if (browserName.toLowerCase().contains("internet")) {
	            driver = new InternetExplorerDriver();
	            
	        }
	        if (browserName.toLowerCase().contains("chrome")) {
	        	System.setProperty("webdriver.chrome.driver", config.getchromePath());
	            driver = new ChromeDriver();
	            
	        }
	        driver.manage().window().maximize();
	        return driver;
	    }
	
}
