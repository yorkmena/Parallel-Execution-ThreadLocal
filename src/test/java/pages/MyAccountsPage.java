package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountsPage {

WebDriver driver;
	
	public MyAccountsPage(WebDriver driver){
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(className="welcome-msg")
	public WebElement WelcomeMessage;
	
	@FindBy(xpath="//li[@class='success-msg']//descendant::Span")
	public WebElement successfulMessage;
	
	@FindBy(xpath="//div[@class='box-account box-info']//descendant::p")
	public WebElement contactInfo;
	
	public String getWelcomeMessageName()
	{
		return WelcomeMessage.getText();	
	}
	
	public String getsuccessfulMessage()
	{
		return successfulMessage.getText();
	}
	
	public String[] getContactInfo()
	{
		return contactInfo.getText().toString().split("\\r?\\n");
	}
	
	
}
