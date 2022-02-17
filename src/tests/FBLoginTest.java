package tests;

import org.testng.annotations.Test;

import pages.FBLoginPage;
import utilities.Xls_Reader;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class FBLoginTest {
 
 FBLoginPage lp = new FBLoginPage();
 
 Xls_Reader read = new Xls_Reader("C:\\Course\\Testing\\LoginTest.xlsx");
 
	WebDriver driver ; 
	String wrongemail = read.getCellData("Sheet1", 0, 1);
	String wrongpassword= read.getCellData("Sheet1", 0, 2);
	String expectederrr = read.getCellData("Sheet1", 1, 9);
	
	@Test
  public void LoginWithWrongEmailAndPassword () throws InterruptedException {
		
	
		lp.Login(wrongemail, wrongpassword);
		Assert.assertEquals(expectederrr, lp.readerr());
		
  }
 
	
	@BeforeMethod
  public void beforeMethod() {
		
	lp.OpenBrowser();
	lp.OpenFBPage();
  }

	@AfterMethod
  public void afterMethod() {
		lp.closeFBPage();
		
  }

}
