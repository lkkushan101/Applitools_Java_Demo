package stepdefs;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import PageFactory.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class LoginScenarioTables {
	  WebDriver driver;

	    Login objLogin;

	    HomePage objHomePage;
	@Given("^Im in the guru bank login page$")
	public void im_in_the_guru_bank_login_page() throws Throwable {
		    driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get("http://demo.guru99.com/V4/index.php");
	    
	}

	@When("^I enter <userName> and <password>$")
	public void i_enter_userName_and_password(DataTable userCredentials) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		  List<String> data = userCredentials.asList(String.class);
	     
		  objLogin = new Login(driver);
     	  String loginPageTitle = objLogin.getLoginTitle();
     	  Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		  objLogin.loginToGuru99(data.get(2), data.get(3));
	}

	@Then("^I should able to navigate to the home page$")
	public void i_should_able_to_navigate_to_the_home_page() throws Throwable {

	  
	    objHomePage = new HomePage(driver);

	    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("mngr176797"));
	    driver.close();
	  
	 
	}
}
