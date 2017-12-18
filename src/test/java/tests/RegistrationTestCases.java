package tests;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.IndexPage;
import pages.RegistrationPage;

public class RegistrationTestCases extends Testbase {

	@Test
	public void registration()
	{
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String email="random_"+randomStringGenerator(4)+"@gmail.com";
		System.out.println(email);
		MyAccount=Registration.registrationSuccessful("Ashish", "Middle", "Mathur", email, "123456", "123456");
		
		Assert.assertEquals(MyAccount.getsuccessfulMessage(), "Thank you for registering with Main Website Store.");
		
	}
	
	@Test
	public void registrationWithExistingEmail() throws InterruptedException
	{
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Registration=Registration.registrationUnSuccessful("Ashish", "Middle", "Mathur", "ashish@gmail.com", "123456", "123456");
		Thread.sleep(4000);
		Assert.assertEquals(Registration.getErrorMessageAfterRegistration(), "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
		
	}
	
	@Test
	public void verifyAccountInfoAfterRegistration()
	{
		driver.get("http://live.guru99.com/index.php/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String email="random_"+randomStringGenerator(4)+"@gmail.com";
		MyAccount=Registration.registrationSuccessful("Ashish", "Middle", "Mathur", email, "123456", "123456");
		
		String contactInfo[]=MyAccount.getContactInfo();
		
		SoftAssert Assert=new SoftAssert();
		Assert.assertEquals(contactInfo[0], "Ashish Middle Mathur", "Name Not Matched");
		Assert.assertEquals(contactInfo[1], email, "Emails Not Matched");
		Assert.assertAll();
		
	}
	
	public String randomStringGenerator(int length)
	{
		String characters="abcdefghijklmnopqrstuvwxyz1234567890";
		Random random=new Random();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<length;i++)
		{
		sb.append(characters.charAt(random.nextInt(characters.length())));
		}
		return sb.toString();
	}
	
	
}
