package skypePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	public class skypePOM {

			WebDriver driver;
			By userName = By.name("username");
			By password = By.name("password");
			By login = By.id("signIn");
			By titleText =By.className("pageTitle");
			By errorsMessage = By.id("unrecognizedCredentialError");
			
			public skypePOM(WebDriver driver){
				this.driver = driver;
			}
			//Set user name in textbox
			public void setUserName(String strUserName){
				driver.findElement(userName).sendKeys(strUserName);;
			}
			
			//Set password in password textbox
			public void setPassword(String strPassword){
				 driver.findElement(password).sendKeys(strPassword);
			}
			
			//Click on login button
			public void clickLogin(){
					driver.findElement(login).click();
			}
			
			//Get the title of Login Page
			public String getLoginTitle(){
			 return	driver.findElement(titleText).getText();
			}
			
			
			
			public String getErrorsMessage(){
			 return	driver.findElement(errorsMessage).getText();
			}
			
			
			
			public void loginToSkype(String strUserName,String strPasword){
				//Fill user name
				this.setUserName(strUserName);
				//Fill password
				this.setPassword(strPasword);
				//Click Login button
				this.clickLogin();		
				
			}
		}