package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowserFactory.LocalDriverManager;
import pages.IndexPage;
import pages.LoginPage;
import pages.MobilePage;
import pages.MyAccountsPage;
import pages.RegistrationPage;

public class Login {
	
	IndexPage Index;
	MyAccountsPage MyAccount;
	LoginPage login;
	
	public Login() {
	
	}
	
	@Test
	public void login()
	{
		WebDriver driver=LocalDriverManager.getDriver();
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String Email="random_kp27@gmail.com";
		Index=new IndexPage(driver);
		MyAccount=Index.clickOnAccount().
		clickOnLogin().
		login(Email, "123456");
		
		SoftAssert Assert=new SoftAssert();
		Assert.assertEquals(MyAccount.getContactInfo()[1], Email);
	
	}
	
	@Test
	public void loginWithIncorrectPassword()
	{
		WebDriver driver=LocalDriverManager.getDriver();
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String Email="random_kp27@gmail.com";
		Index=new IndexPage(driver);
		login=Index.clickOnAccount().
		clickOnLogin().
		loginUnsuccessful(Email, "1234567");
		
		SoftAssert Assert=new SoftAssert();
		Assert.assertEquals(login.getErrorMessage(), "Invalid login or password.");
		
	}
	
}
