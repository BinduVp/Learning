package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By login = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector(".text-center");
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	

	public WebElement getTitle() {
		// TODO Auto-generated method stub
		return driver.findElement(title);
	}
	
}
