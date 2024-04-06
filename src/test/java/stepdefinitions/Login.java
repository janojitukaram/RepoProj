package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.AccountPage;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base {
	WebDriver driver;
	LoginPage loginPage;
	
	@Given("^Navigated to login page$")
	public void Navigated_to_login_page() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@And("^Entered the username as  \"([^\"]*)\" and password  as \"([^\\\"]*)\"$")
	public void Entered_the_username_and_password(String username, String password)
	{
		loginPage = new LoginPage(driver);
		
		loginPage.inputEmailAddress().sendKeys(username);
		loginPage.inputPassword().sendKeys(password);
		
	}
	
	@Then("^Clicked on login page$")
	public void Clicked_on_login_page()
	{
		loginPage.loginOption().click();
		
	}
	
	@And("^Checke the success page")
	public void Checke_the_success_page()
	{
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.accountbreadCrumb().isDisplayed());
		
	}
	
	@After
	public void closure()
	{
		driver.close();
	}
	
	
	

}
