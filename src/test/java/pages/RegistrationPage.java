package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstname")
	public WebElement firstName;
	
	@FindBy(id="middlename")
	public WebElement middleName;
	
	@FindBy(id="lastname")
	public WebElement lastName;
	
	@FindBy(id="email_address")
	public WebElement emailAddress;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="confirmation")
	public WebElement confirmPassword;
	
	@FindBy(css=".buttons-set span:nth-of-type(1) span")
	public WebElement registerButton;
	
	@FindBy(xpath="//li[@class='error-msg']//descendant::Span")
	public WebElement errorMessage;
	
	
	public RegistrationPage enterFirstName(String name)
	{
		firstName.sendKeys(name);
		return this;
	}
	
	public RegistrationPage enterMiddleName(String name)
	{
		middleName.sendKeys(name);
		return this;
	}
	
	public RegistrationPage enterLastName(String name)
	{
		lastName.sendKeys(name);
		return this;
	}
	
	public RegistrationPage enterEmailAddress(String email)
	{
		emailAddress.sendKeys(email);
		return this;
	}
	
	public RegistrationPage enterPassword(String Password)
	{
		password.sendKeys(Password);
		return this;
	}
	
	public RegistrationPage enterConfirmPassword(String ConfirmPassword)
	{
		confirmPassword.sendKeys(ConfirmPassword);
		return this;
	}
	
	public MyAccountsPage clickOnRegisterButtonforSuccessfulRegistration()
	{
		registerButton.click();
		return new MyAccountsPage(driver);	
	}
	
	public RegistrationPage clickOnRegisterButtonforUnSuccessfulRegistration()
	{
		registerButton.click();
		return this;	
	}
	
	
	public MyAccountsPage registrationSuccessful(String firstName, String middleName, String lastName, String email, String password, String confirmPassword )
	{
		new IndexPage(driver).clickOnAccount()
		.clickOnRegister()
		.enterFirstName(firstName)
		.enterMiddleName(middleName)
		.enterLastName(lastName)
		.enterEmailAddress(email)
		.enterPassword(password)
		.enterConfirmPassword(confirmPassword)
		.clickOnRegisterButtonforSuccessfulRegistration();
		
		return new MyAccountsPage(driver);
		
	}
	
	public RegistrationPage registrationUnSuccessful(String firstName, String middleName, String lastName, String email, String password, String confirmPassword)
	{
		new IndexPage(driver).clickOnAccount()
		.clickOnRegister()
		.enterFirstName(firstName)
		.enterMiddleName(middleName)
		.enterLastName(lastName)
		.enterEmailAddress(email)
		.enterPassword(password)
		.enterConfirmPassword(confirmPassword)
		.clickOnRegisterButtonforUnSuccessfulRegistration();
		
		
		return this;
		
	}
	
	public String getErrorMessageAfterRegistration()
	{
		return errorMessage.getText();
	}
}
