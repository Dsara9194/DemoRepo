package pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import utilities.WebEventListner;

public class Guru99LoginPage {

	WebDriver driver;
	//EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
	//WebEventListner eventListner = new WebEventListner();
	 Properties prop ;
	 
	
	
	

	public void OpenBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\\\\\\\Course\\\\\\\\SeleniumJars\\\\\\\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		
	}

	
	public void Loginpage() {
		driver.get("https://www.demo.guru99.com/V4/");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

	}

	public void closeBrowser() {
		driver.quit();

	}

	public void Login(String email , String password) throws InterruptedException {

		driver.findElement(By.name("uid")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(2000);

	}

	public  String verifyTitlePage() {

		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		return ActualTitle;


	}
	
	

	public String readerror() {

		Alert Al = driver.switchTo().alert();
		String actual = Al.getText();
		System.out.println(actual);
		return actual;

	}
	
	
	

	
	
	
	

}
