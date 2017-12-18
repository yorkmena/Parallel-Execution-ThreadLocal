package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

WebDriver driver;
	
	public IndexPage(WebDriver driver){
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='nav']/ol/li[1]/a")
	public WebElement mobile;
	
	@FindBy(xpath="//html[@id='top']//header[@id='header']//div[@class='account-cart-wrapper']/a[@href='http://live.guru99.com/index.php/customer/account/']/span[@class='label']")
	public WebElement account;
	
	@FindBy(linkText="Register")
	public WebElement Register;
	
	@FindBy(linkText="Log In")
	public WebElement Login;
	
	
	public static void click(WebElement ele)
	{
		ele.click();
	}
	
	public void clickOnMobile()
	{
		mobile.click();
	}

	public IndexPage clickOnAccount()
	{
		account.click();
		return this;
	}
	
	public RegistrationPage clickOnRegister()
	{
		Register.click();
		return new RegistrationPage(driver);
	}
	
	public LoginPage clickOnLogin()
	{
		Login.click();
		return new LoginPage(driver);
	}
	
	public boolean isRegistrationSuccessfullMessageDisplayed()
	{
		List l=driver.findElements(By.xpath("//Span[contains(text(),'Thank you for registering with Main Website Store.')]"));
		
		if(l.size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
