package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	Logger log;

	@Test(dataProvider = "getLoginData")
	public void login(String email, String pass, String ExpectedResult) throws IOException {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on the My Account");
		landingPage.loginOption().click();
		log.debug("Clicked on login option from  My account dropdown");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputEmailAddress().sendKeys(email);
		log.debug("Sending email address to the email field");
		loginPage.inputPassword().sendKeys(pass);
		log.debug("Sending password to password field");
		loginPage.loginOption().click();
		log.debug("Clicked on login button ");

		AccountPage accountPage = new AccountPage(driver);
		String ActualResult = null;
		try {
			accountPage.accountbreadCrumb().isDisplayed();
			log.info("user  got logged in ");
			ActualResult = "Success";
		}
		catch (Exception e) {
			log.info("user didn't  logged in ");
			ActualResult="Failure";
		}
		
		Assert.assertEquals(ActualResult, ExpectedResult);

	}
	
	@BeforeMethod
	public void openApplication() throws IOException
	{
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("closed the browser");
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "tukarampractice@gmail.com", "1234", "Success" },
				{ "dummy@gmail.com", "dummy", "Failure" } };

		return data;
	}

}
