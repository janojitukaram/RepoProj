package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base {
	public WebDriver driver;
	@Test
	public void threeTest() throws InterruptedException, IOException
	{
		System.out.println("ThreeTest");
		driver = initializeDriver();
		driver.get("https://tutorialsninja.com/demo/");
	
	}
	@AfterMethod
	public void closure()
	{
		driver.close();
	}

}
