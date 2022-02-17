package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.Loginpage;
import utilities.Xls_Reader;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {

	Loginpage lp = new Loginpage();
	DataFile df = new DataFile();

	@Test(priority = 1) // email , password, login and error msg
	public void loginWithwrongemailAndPassword() throws InterruptedException {

		 lp.Login(df.WrongEmail, df.Wrongpassword);

		Assert.assertEquals(lp.readGlobalError(), df.globalerr);
	}

	//@Test(priority = 2) // invalid email with special characters
	public void loginWithinvalidEmailId() throws InterruptedException {

		lp.Login(df.EmailWithSpecialChar, df.Wrongpassword);
		Assert.assertEquals(lp.ReadErr(), df.specialCharErr);
	}

	//@Test(priority = 3) // without email// error message
	public void loginWithEmptyEmailId() throws InterruptedException {

		lp.Login("", df.Wrongpassword);
		Assert.assertEquals(lp.ReadErr(), df.emptyEmailErr);
	}

	//@Test(priority = 4) // without password // error msg
	public void loginWithEmptyPassword() throws InterruptedException {

		lp.Login(df.WrongEmail, "");
		Assert.assertEquals(lp.ReadErr(), df.EmptypassErr);
	} 

	@BeforeMethod
	public void beforeMethod() throws IOException {
		
		
		lp.OpenBrowser();
		lp.OpenScotiaLoginPage();
		

	}

	@AfterMethod
	public void afterMethod() {
		lp.CloseBrowser();
	}

}
