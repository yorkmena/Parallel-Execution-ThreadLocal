package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowserFactory.LocalDriverManager;
import pages.LoginPage;


public class LoginTestCases extends Testbase {

	public LoginTestCases() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void login()
	{
		driver=LocalDriverManager.getDriver();
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String Email="random_kp27@gmail.com";
		
		MyAccount=Index.clickOnAccount().
		clickOnLogin().
		login(Email, "123456");
		
		SoftAssert Assert=new SoftAssert();
		Assert.assertEquals(MyAccount.getContactInfo()[1], Email);
		
		
	}
	
	@Test
	public void loginWithIncorrectPassword()
	{
		driver=LocalDriverManager.getDriver();
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String Email="random_kp27@gmail.com";
		
		login=Index.clickOnAccount().
		clickOnLogin().
		loginUnsuccessful(Email, "1234567");
		
		SoftAssert Assert=new SoftAssert();
		Assert.assertEquals(login.getErrorMessage(), "Invalid login or password.");
		
	}
	
	
	
	
}
