package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	 WebDriver driver ; 
	 Properties prop ;
	 
	 // at this time driver is null so we cannt create the web elemnt like this
	 
	 /*public WebElement emailBox =  driver.findElement(By.id("usernameInput-input"));
	 public WebElement passwordBox = driver.findElement(By.id("password-input"));
	 public WebElement LoginButton =  driver.findElement(By.id("signIn"));
	 public WebElement globalerr =  driver.findElement(By.id("globalError"));
	 public WebElement generalerr = driver.findElement(By.className("Error__container"));*/
	 
	 @FindBy (id = "usernameInput-input" )
	 public WebElement emailBox;
	  
	 @FindBy (id = "password-input" )
	 public WebElement passwordBox;
	 
	 @FindBy (id = "signIn" )
	 public WebElement LoginButton;
	 
	 @FindBy (id = "globalError" )
	 public WebElement globalerr; 
	 
	 @FindBy (className = "Error__text" )
	 public WebElement generalerr; 
	 
	 
	 public void OpenBrowser() throws IOException {
		 
		 FileInputStream f = new FileInputStream("C:\\Course\\Testing\\prop.properties");
			
			prop = new Properties();
			prop.load(f);
			
			String Browser = prop.getProperty("browser");
		
			
			if(Browser.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Course\\SeleniumJars\\geckodriver.exe");
				 driver = new FirefoxDriver();
				} else { 
					System.setProperty("webdriver.chrome.driver", "C:\\Course\\SeleniumJars\\chromedriver.exe");
		driver = new ChromeDriver();
				} 
			PageFactory.initElements(driver, this);
 
				
	 }
	 
	 public void OpenScotiaLoginPage () {
		 
		 driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=w9oP3-m8HrE&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoidzlvUDMtbThIckUiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYzNjA5MDM1MSwiaWF0IjoxNjM2MDg5MTUxLCJqdGkiOiIyZTA0OTNkMy1mZjNkLTRmMDctYTRlMy1kNWNlZDMyYzY3YjkiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.T7oh_zeM9qViIHBOEXwO3U3i9KFRw6DgUlls0iByuONz9Hs8bWcmxcglTQylAo4NxVuYEXNrfRaIh36zvu-_MsIJSVNFpik-4JF-gdpp832Qzj_15W9kU_qW897LXUZKjnlA7Rs_iYIEEH9Y7P-pUnVoL6vJf5_F9lGGpv5yLsPWT3LcmKgs6k2mKlsHuBHWQY7lR4gKcLcKxsORezuRYwFDDfqDnImFTXCwWGiWQQ5iyB1cWkAmzSOabEuUgLI9JN8dPfmnbD48w09CWjNQDph7VMQtNs0X6T0kHKkZXq7I_RISBtzqImrTXrFT0LI5G0kzMt4PZElkiAJ_cXcCcg&preferred_environment="); 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	 
	 public void CloseBrowser() {
		  driver.quit(); 
	 }
	 
	 public void Login(String email, String password) throws InterruptedException {
		 
		emailBox.sendKeys(email);
		passwordBox.sendKeys(password);
		LoginButton.click();
		 Thread.sleep(2000);	 
	 }
	 
	 public String readGlobalError () {
		 String actualerr = globalerr.getText();
		   System.out.println(actualerr);
		return actualerr; 
	 }
	  
	 public String ReadErr() {
		 String actualerr = generalerr.getText();
		   System.out.println(actualerr);
		return actualerr;
	 }
	 
	 
	 

}
