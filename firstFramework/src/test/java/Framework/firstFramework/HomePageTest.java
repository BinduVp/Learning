package Framework.firstFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;

public class HomePageTest extends Resources.BaseClass
{
	public WebDriver driver;
	public static Logger logger = LogManager.getLogger(HomePageTest.class);
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		logger.info("driver is initialised");
		
	}
	

	@Test(dataProvider = "GetData")
	
	public void basePageNavigation(String emailId, String pwd) throws IOException {
		driver.get("http://qaclickacademy.com");
		HomePage h = new HomePage(driver);
		h.getLogin().click();
		logger.debug("sing up button clicked");
		
		/*LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.email.sendKeys(emailId);
		logger.debug("email id entered");
		loginPage.pwd.sendKeys(pwd);
		logger.debug("password entered");
		loginPage.login.click();
		logger.debug("login button clicked");*/
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(emailId, pwd);
	}
	
	@DataProvider
	public Object[][] GetData()
	{
	  Object[][] data = new Object[2][2];
	  data[0][0] = "abc@gmail.com";
	  data[0][1] = "abc";
	//  data[0][2] = "Restricted user";
	  
	  
	  data[1][0] = "def@gmail.com";
	  data[1][1] = "def";
	 // data[1][2] = "Non restricted user";	
	  
	  return data;
	}
		
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
