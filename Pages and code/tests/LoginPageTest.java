package com.mmt.qa.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mmt.qa.ExtentReporterListener.ExtentReporterNG;
import com.mmt.qa.base.BaseMMT;
import com.mmt.qa.pages.HomePage;
import com.mmt.qa.pages.LoginPage;

@Listeners(ExtentReporterNG.class)
public class LoginPageTest extends BaseMMT {
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	// creating object of Logger class to generate own logs
	// Logger object is created at class level

	public LoginPageTest() {
		super();// Super keyword to use the Base Class constructor
	}

@BeforeClass
	public void setUp() throws IOException  {
		initialization();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)//, description= "verify Login Page title")
	public void loginPageTitle() {
		//log.info("Logging in and verifying HomePage title"); // Logger class object to generate own logs 
		String title = loginPage.getPageTitle();
		Assert.assertEquals(title, "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");

	}

	@Test(priority = 2)//, description= "verify successful Login on make my trip site with valid credentials" )
	public void loginTest() {
		//log.warn("**********Just a test warning, nothing wrong*********");//Logger class warn
		//log.fatal("**********Just a test fatal error, keep going*********"); //logger class error
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

@AfterClass public void tearDown() 
	 { 
		 driver.quit();
	 }

}
