package StepDefinitions;

import org.junit.runner.RunWith;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import Resources.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinition extends BaseClass {
	
	    @Given("^Initialize the browser with chrome$")
	    public void initialize_the_browser_with_chrome() throws Throwable {
	    	driver= initializeDriver();
	    }

	    @When("^user enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String emailId, String password) throws Throwable {
	    	LoginPage loginPage = new LoginPage(driver);
			loginPage.Login(emailId, password);
	    }

	    @Then("^Verify that user is successfully logged in$")
	    public void verify_that_user_is_successfully_logged_in() throws Throwable {
	        System.out.println("logged in!!");
	    }

	    @And("^navigate to \"([^\"]*)\"$")
	    public void navigate_to_something(String strArg1) throws Throwable {
	    	driver.get(strArg1);
	    }

	    @And("^click on login link in home page$")
	    public void click_on_login_link_in_home_page() throws Throwable {
	    	HomePage h = new HomePage(driver);
			h.getLogin().click();
	    }

	    @And("^close browsers$")
	    public void close_browsers() throws Throwable {
	    	driver.close();
	    }

}


