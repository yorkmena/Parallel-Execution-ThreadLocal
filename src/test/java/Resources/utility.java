package Resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utility {

	public utility() {
		// TODO Auto-generated constructor stub
	}
	
	public String captureScreenshoot(WebDriver driver, String Filename)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".//Screenshots//"+Filename+System.currentTimeMillis()+".png");
	    try 
	    {
	    	FileUtils.copyFile(src, dest);
		} 
	    catch (IOException e) 
	    {	
			System.out.println("ScreenShoot not Captured --"+e.getMessage());
		}
	    
	    return dest.getAbsolutePath();
	 }


}
