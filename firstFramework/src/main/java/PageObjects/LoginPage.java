package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input#user_email")
	private WebElement email;
	
	@FindBy(css = "input#user_password")
	private WebElement pwd;
	
	@FindBy(name = "commit")
	private WebElement login;
	
	public void Login(String emailId, String password)
	{
		email.sendKeys(emailId);
		pwd.sendKeys(password);
		login.click();
	}
}
