package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	static Properties p;
	public ConfigDataProvider()
	{	
		
		File f =new File("./configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(f);
			p=new Properties();
			p.load(fis);
			
		} 
		catch (Exception e)
		{
		System.out.println("Custom Exception- cannot load properties file"+e.getMessage());
		}		
	}
	
	public String getvalue(String key)	
	{
		return p.getProperty(key);
	}
	
	public  String getUrl()
	{
		return p.getProperty("url");	
	}	
	
	public String getchromePath()
	{
		String os=System.getProperty("os.name");
		if (os.startsWith("w"))
			return p.getProperty("chromepath");

		else
			return p.getProperty("chromepath_linux");
	}
	
	public String getgeckoPath()
	{
		String os=System.getProperty("os.name");
		if (os.startsWith("w"))
			return p.getProperty("firefoxpath");
		else
		return p.getProperty("firefoxpath_linux");
	}
	
	public String getIEPath()
	{
		return System.getProperty("User.dir")+p.getProperty("IEPath");
	}
	
}
