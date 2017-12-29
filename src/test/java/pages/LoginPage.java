package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Reports.ExtentTestManager;

import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="login[username]")
	public WebElement EmailAddress;
	
	@FindBy(name="login[password]")
	public WebElement Password;
	
	@FindBy(css="button#send2>span")
	public WebElement loginButton;
	
	@FindBy(xpath="//li[@class='error-msg']//descendant::Span")
	public WebElement errorMessage;
	
	
	
	public LoginPage enterEmail(String email)
	{
		EmailAddress.sendKeys(email);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Email Entered");
		return this;
	}
	
	public LoginPage enterPassword(String password)
	{
		Password.sendKeys(password);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Password Entered");
		return this;
	}
	
	public MyAccountsPage clickOnLogin()
	{
		loginButton.click();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Login Button");
		return new MyAccountsPage(driver);
	}
	
	public MyAccountsPage login(String email, String password)
	{
		enterEmail(email);
		enterPassword(password);
		clickOnLogin();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Login Button on Login Page");
		return new MyAccountsPage(driver);
		
	}
	
	public LoginPage loginUnsuccessful(String email, String password)
	{
		enterEmail(email);
		enterPassword(password);
		clickOnLogin();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Login Button on Login Page");
		return this;
	}
	
	public String getErrorMessage()
	{
		return errorMessage.getText();
	}
}
