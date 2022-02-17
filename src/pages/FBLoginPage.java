package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FBLoginPage {
 WebDriver driver ; 
	  
 public void OpenBrowser() {
		 
		 System.setProperty("webdriver.gecko.driver", "C:\\\\Course\\\\SeleniumJars\\\\geckodriver.exe");
		  driver = new FirefoxDriver(); 

}
 
 public void OpenFBPage () {
	 
	    driver.get("https://www.facebook.com/");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   
 }
 
 public void closeFBPage () {
	 driver.quit();
 }
 
 public void Login(String email, String password) throws InterruptedException {
	 driver.findElement(By.id("email")).sendKeys(email);
	 driver.findElement(By.name("pass")).sendKeys(password);
	 driver.findElement(By.name("login")).click();
	 Thread.sleep(2000);
 }
 
 public String readerr() {
	
	 String actualerr = driver.findElement(By.className("_9ay7")).getText();
	 System.out.println(actualerr);
	return actualerr;
 }
}
