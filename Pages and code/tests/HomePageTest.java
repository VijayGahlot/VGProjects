package com.mmt.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mmt.qa.base.BaseMMT;
import com.mmt.qa.pages.FlightSearchPage;
import com.mmt.qa.pages.HomePage;
import com.mmt.qa.pages.LoginPage;
import com.mmt.qa.util.TestUtil;

public class HomePageTest extends BaseMMT {

	LoginPage loginPage;
	HomePage homePage;
	FlightSearchPage flightSearchPage;
	HomePage wait;
	TestUtil testUtil;
	

	public HomePageTest() {
		super();// Super keyword to use the Base Class constructor
	}

	@BeforeClass
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		flightSearchPage = new FlightSearchPage();
		testUtil = new TestUtil();
	
		
	}

	@Test(priority = 1)//, description= "verify Home Page title after logging in")
	public void HomePageTitleTest() {

		String homePageTitle = homePage.HomePageTitle();

		Assert.assertEquals(homePageTitle, "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");

	}

	@Test(priority = 2)//, description= "verify clicking on 'From' Location dropdown")
	public void clickOnFromOriginTest() throws InterruptedException {
		homePage.clickOnFromOrigin();
	}

	@Test(priority = 3)//, description= "verify selecting city 'from' in Location dropdown")
	public void GetDropDownValuesfromLocation() throws InterruptedException {

		homePage.GetDropDownValuesFrom(homePage.list, prop.getProperty("FromCity"));
		// agar hum ek hi method use kr rahe hain toh value kaise paas krenge

	}

	@Test(priority = 4)
	public void clickOnToDestinationTest() throws InterruptedException {
		homePage.clickOnToDestination();
	}

	@Test(priority = 5)//, description= "verify selecting city 'To' in Location dropdown")
	public void GetDropDownValuesToDestination() throws InterruptedException {

		homePage.GetDropDownValuesFrom(homePage.listTo, prop.getProperty("ToCity"));
	}

	@Test(priority = 6)//, description= "verify calender opens on clicking the date field")
	public void clickOnDatePickerTest() {
		homePage.clickOnDatePicker();
	}

	@Test(priority = 7)//, description="verify choosing the date of departure")
	public void testSelectFromDate() {

		String date = "10-OCTOBER-2019";
		String splitter[] = date.split("-");
		String month_year = splitter[1];
		String day = splitter[0];
		System.out.println(month_year);
		System.out.println(day);

		homePage.selectDate(homePage.monthyear, (prop.getProperty("monthyear")), homePage.Selectday,
				(prop.getProperty("Selectday")));
	}


	@Test(priority = 8)//, description="verify clicking on search button takes the user to the Flight")
	public void searchFlightButtonTest() {
		flightSearchPage = homePage.clickOnSearchBtn();
	}
	@AfterClass public void tearDown() 
	 { 
		 driver.quit();
	 }
}