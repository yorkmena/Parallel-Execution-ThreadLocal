package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		return this;
	}
	
	public LoginPage enterPassword(String password)
	{
		Password.sendKeys(password);
		return this;
	}
	
	public MyAccountsPage clickOnLogin()
	{
		loginButton.click();
		return new MyAccountsPage(driver);
	}
	
	public MyAccountsPage login(String email, String password)
	{
		enterEmail(email);
		enterPassword(password);
		clickOnLogin();
		return new MyAccountsPage(driver);
		
	}
	
	public LoginPage loginUnsuccessful(String email, String password)
	{
		enterEmail(email);
		enterPassword(password);
		clickOnLogin();
		return this;
		
	}
	
	public String getErrorMessage()
	{
		return errorMessage.getText();
	}
}
