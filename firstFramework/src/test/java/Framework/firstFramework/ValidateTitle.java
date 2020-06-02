package Framework.firstFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.config.Loggers;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;

public class ValidateTitle extends Resources.BaseClass 
{
	public WebDriver driver;
	public static Logger logger = LogManager.getLogger(ValidateTitle.class);
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		logger.info("driver is initialised");
		driver.get("http://qaclickacademy.com");
		logger.info("Navigated to home page");
	}
	@Test
	public void basePageNavigation() throws IOException
	{		
		
		HomePage h = new HomePage(driver);
		
	    Assert.assertEquals(h.getTitle().getText(), "Featured course12");
	    logger.info("Successfully validated title text");
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
	
}
