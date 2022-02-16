package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Guru99LT {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\\\\\\\Course\\\\\\\\SeleniumJars\\\\\\\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.demo.guru99.com/V4/");
		
		  driver.findElement(By.name("uid")).sendKeys("invaliduser");
			driver.findElement(By.name("password")).sendKeys("hAbatYq");
			driver.findElement(By.name("btnLogin")).click();
			
			Thread.sleep(2000);
		

	Alert Al = driver.switchTo().alert();
	System.out.println(Al.getText());
		
		
	String expected = "User or Password is not valid";
	String actual = Al.getText();
	System.out.println(actual);
	
	 if (expected.equals(actual)) {
			System.out.println("Test Pass"); }  
		else {
			System.out.println("Test Fail");
	}

	
	Al.accept();
		
	
	/*String expectedtitle = "Guru99 Bank Manager HomePage";
	String ActualTitle = driver.getTitle();
	System.out.println(ActualTitle );
	
	 
	 * if (expectedtitle.equals(ActualTitle)) {
		System.out.println("Test Pass"); }  
	else {
		System.out.println("Test Fail");
}
	
	
driver.quit();*/
		
}

			
	
	}


