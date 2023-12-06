package stepdefinations;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AdminPage;

public class StepDefination extends Base {

	@Given("User Lanch Chrome Browser")
	public void user_lanch_chrome_browser() throws Exception {
	    
		driver=new ChromeDriver();

		ad=new AdminPage(driver);//create object of AdminPage java class
		Thread.sleep(2000);
	}

	@When("User open url {string}")
	public void user_open_url(String url) throws Exception {
	   driver.get(url);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);


	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws Exception {
	 ad.setUsername(email);
		Thread.sleep(2000);

	 ad.setPassword(password);
		Thread.sleep(2000);

	}

	@When("User click on Login button")
	public void user_click_on_login_button() throws Exception {
	    ad.clickOnLogin();
		Thread.sleep(2000);

	}

	@Then("User verify page title should be {string}")
	public void user_verify_page_title_should_be(String title) throws Exception {
	  Assert.assertEquals(driver.getTitle(), title);
		Thread.sleep(2000);

	}

	@Then("close browser")
	public void close_browser() {
	  driver.close();
	}

	
}