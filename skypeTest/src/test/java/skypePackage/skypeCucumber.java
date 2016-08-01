package skypePackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver; 

import cucumber.annotation.en.Given; 
import cucumber.annotation.en.Then; 
import cucumber.annotation.en.When; 
	
	public class skypeCucumber { 
	   WebDriver driver = null; 
	   skypePOM objLogin;
		
	   @Given("Open Login skype page") 
	   public void openSkypePage() { 
		   driver = new FirefoxDriver();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.get("https://login.skype.com/login?message=signin_continue&client_id=360605&redirect_uri=https%3A%2F%2Fsecure.skype.com%2Fportal%2Flogin%3Freturn_url%3Dhttps%253A%252F%252Fsecure.skype.com%252Fportal%252Foverview");
	   } 
	
	   //Scenario 1
	   @When("username logged in with password is pwd") 
	   public void loginSkype() { 
		   objLogin = new skypePOM(driver);
		   objLogin.loginToSkype("username", "pwd");
	   } 
		
	   @Then("I verify page title is Skype My Account") 
	   public void verifyPageTile() { 
		   if(objLogin.getLoginTitle().equalsIgnoreCase("Skype My Account")){
				System.out.println("Test pass!");			
			} else
				System.out.println("Test fail!");		
			
	      driver.close(); 
	   } 
	   
	   @Given("Open Login skype page") 
	   public void openSkypePage1() { 
		   driver = new FirefoxDriver();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.get("https://login.skype.com/login?message=signin_continue&client_id=360605&redirect_uri=https%3A%2F%2Fsecure.skype.com%2Fportal%2Flogin%3Freturn_url%3Dhttps%253A%252F%252Fsecure.skype.com%252Fportal%252Foverview");
	   } 
	
	   //Scenario 2
	   @When("I am input username is pinkgirl6103 And I am input password is null And user click Signin button") 
	   public void loginWithNoPass() { 
		   objLogin = new skypePOM(driver);
		   objLogin.loginToSkype("pinkgirl6103", "");
	   } 
		
	   @Then("I verify page title is Skype My Account") 
	   public void verifyErrorMessage1() {
		   if(objLogin.getLoginTitle().equalsIgnoreCase("Incorrect password. Please try again.")){
				System.out.println("Test pass!");			
			} else
				System.out.println("Test fail!");		
			
	      driver.close(); 
	   } 
	   
	   //Scenario 3
	   
	   @When("I am input username is null And I am input password is testpwasd And user click Signin button") 
	   public void loginWithNoUsername() { 
		   objLogin = new skypePOM(driver);
		   objLogin.loginToSkype("", "testpwasd");
	   } 
		
	   @Then("I verify error message is : You did not enter your Skype Name.") 
	   public void verifyErrorMessage2() {
		   if(objLogin.getLoginTitle().equalsIgnoreCase("You did not enter your Skype Name.")){
				System.out.println("Test pass!");			
			} else
				System.out.println("Test fail!");		
			
	      driver.close(); 
	   } 
	   
	   //Scenario 4
	   @When("I am input username is bla And I am input password is bla And user click Signin button") 
	   public void loginWithWrongAccount() { 
		   objLogin = new skypePOM(driver);
		   objLogin.loginToSkype("bla", "bla");
	   } 
		
	   @Then("I verify page error is: Signing in failed. Please double-check your Skype Name and re-enter your password.") 
	   public void verifyErrorMessage3() {
		   if(objLogin.getLoginTitle().equalsIgnoreCase("Signing in failed. Please double-check your Skype Name and re-enter your password.")){
				System.out.println("Test pass!");			
			} else
				System.out.println("Test fail!");		
			
	      driver.close(); 
	   } 
	}