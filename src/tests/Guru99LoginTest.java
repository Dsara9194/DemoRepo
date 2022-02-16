package tests;

import org.testng.annotations.Test;

import data.Guru99DataFile;
import pages.Guru99LoginPage;
import utilities.WebEventListner;
import utilities.Xls_Reader;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Guru99LoginTest {

	Guru99LoginPage LP = new Guru99LoginPage();
	Guru99DataFile DF = new Guru99DataFile();
	

	@Test(priority = 1)
	public void loginWithCorrectEmailandPassword() throws InterruptedException {

		LP.Login(DF.username, DF.password);
		Assert.assertEquals(DF.Titlepage, LP.verifyTitlePage());

	}

	@Test(priority = 2)
	public void loginWithInvaliduserAndValidPassword() throws InterruptedException {

		LP.Login(DF.InvalidUsername, DF.password);
		Assert.assertEquals(DF.errmsg, LP.readerror());

	}

	@Test(priority = 3)
	public void loginWithValiduserAndinValidPassword() throws InterruptedException {

		LP.Login(DF.username, DF.InvalidPassword);
		Assert.assertEquals(DF.errmsg, LP.readerror());

	}

	@Test(priority = 4)
	public void loginWithInvaliduserAndinValidPassword() throws InterruptedException {

		LP.Login(DF.InvalidUsername, DF.InvalidPassword);
		Assert.assertEquals(DF.errmsg, LP.readerror());
	}

	@BeforeMethod
	public void beforeMethod() {

		LP.OpenBrowser();
		LP.Loginpage();

	}

	@AfterMethod
	public void afterMethod() {

		LP.closeBrowser();

	}

}
