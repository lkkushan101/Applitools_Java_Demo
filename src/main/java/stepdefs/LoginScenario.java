package stepdefs;

import java.util.concurrent.TimeUnit;
import Utility.AppliToolsEyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import PageFactory.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class LoginScenario {
	     WebDriver driver;

	    Login objLogin;

	    HomePage objHomePage;
	
	    AppliToolsEyes applEye = new AppliToolsEyes();
	    
	@Given("^I have user name and password$")
	public void i_have_user_name_and_password() throws Throwable {
		   applEye.setAPIKey("d98KRpwEL5RjJM110nZP15za103rgm41hxmeUve48vCxgj84110");
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        applEye.startTest(driver, "Sample Test", "Testing Login");
	      
	        driver.get("http://demo.guru99.com/V4/index.php");
	   
	  
	}
	@When("^I successfully login$")
	public void i_successfully_login() throws Throwable {
	  
		
	
		    objLogin = new Login(driver);

		    //Verify login page title

		   
		    
		    String loginPageTitle = objLogin.getLoginTitle();

		    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

		    //login to application
		    applEye.setCheckPointWindow("loginWindow");
		    objLogin.loginToGuru99("mngr176797", "jaseteb");
		   

	   
	}
	
	@Then("^I should navigate to the home page$")
	public void i_should_navigate_to_the_home_page() throws Throwable {
		 

		    //Verify home page

		    objHomePage = new HomePage(driver);

		    //Verify home page
		    applEye.setCheckPointWindow("MainWindow");
		    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("mngr176797"));
		    applEye.closeEyes();
		    driver.close();
		  

	
	}

}
