package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	public WebDriver driver;
	@Test
	public void twoTest() throws IOException, InterruptedException
	{
		System.out.println("TwoTest");
		driver = initializeDriver();
		driver.get("https://tutorialsninja.com/demo/");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
