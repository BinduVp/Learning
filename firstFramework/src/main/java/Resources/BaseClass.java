package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	public WebDriver driver;
	public Properties properties;
	public WebDriver initializeDriver() throws IOException
	{
	
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties");
		
		properties = new Properties();
		properties.load(file);
		String browserName = properties.getProperty("browser");
		//String browserName = System.getProperty("browser");
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\bindu.DESKTOP-GRSEJ99\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\bindu.DESKTOP-GRSEJ99\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenshot(String testName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testName + ".png";
		
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
	
	
}
