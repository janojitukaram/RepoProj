package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-email")
	WebElement inputEmailAddress;
	
	public WebElement inputEmailAddress()
	{
		return inputEmailAddress;
	}
	
	@FindBy(id="input-password")
	WebElement inputPassword;
	
	public WebElement inputPassword()
	{
		return inputPassword;
	}

	@FindBy(xpath="//*[@value='Login']")
	WebElement loginOption;
	
	public WebElement loginOption()
	{
		return loginOption;
	}
}
