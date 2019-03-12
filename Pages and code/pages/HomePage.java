package com.mmt.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.mmt.qa.base.BaseMMT;


public class HomePage extends BaseMMT {

	@FindBy(xpath = "//input[@id='hp-widget__sfrom']")
	WebElement fromOrigin;

	@FindBy(xpath = "//ul[contains(@class, ' hp-widget__sfrom')]//li//div//p//span[@class='autoCompleteItem__label']")
	public List<WebElement> list;
	// li will create an object and will store all the li's in the ul
	/*@CacheLookUp can be used to store this element in browser cache in case of 
	@before after method it will save a great deal of time
	but if page dom is changed aur page has been refreshed the cache will be corrupted but if page content has not been changed
	 this will make the script more powerful
	*/

	@FindBy(xpath = "//input[@id='hp-widget__sTo']")
	WebElement toDestination;

	@FindBy(xpath = "//ul[contains(@class, 'ui-widget-content hp-widget__sTo')]//li//div//span[@class='autoCompleteItem__label']")
	public List<WebElement> listTo;

	@FindBy(xpath = "//input[@id='hp-widget__depart']")
	public WebElement datePicker;

	@FindBy(xpath = "//div[@class='ui-datepicker-title']/span[1]")
	public List<WebElement> monthyear;
	// month ka hai march

	@FindBy(xpath = "//div[contains(@class,'ui-datepicker-multi-2')]/div[2]/table/tbody/tr/td/a")
	public List<WebElement> Selectday;

	@FindBy(xpath = "//div[contains(@class,'ui-datepicker-multi-2')]/div[2]/div/a/span[@class='ui-icon ui-icon-circle-triangle-e']")
	public WebElement nextArrow;

	@FindBy(xpath = "//button[@id='searchBtn']")
	WebElement searchBtn;

	// Initializing Home page objects
	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String HomePageTitle() {
		return driver.getTitle();
	}

	/*
	 * public void HandleAlert() {
	 * 
	 * Alert alert= driver.switchTo().alert(); System.out.println(alert.getText());
	 * alert.dismiss(); }
	 */

	public void clickOnFromOrigin() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(fromOrigin)).click();
		Thread.sleep(0500);

	}

	public void clickOnToDestination() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(toDestination)).click();
		Thread.sleep(0500);
	}

	public void GetDropDownValuesFrom(List<WebElement> el, String city) throws InterruptedException {

		for (int i = 0; i < el.size(); i++) {
			System.out.println(el.get(i).getText());
			if (el.get(i).getText().contains(city)) {
				el.get(i).click();
				break;

			}
			Thread.sleep(1000);
		}

	}

	public void clickOnDatePicker() {
		datePicker.click();
	}

	public void selectDate(List<WebElement> elements, String monthyear, List<WebElement> days, String Selectday) {

		for (int i = 0; i < elements.size(); i++) {
			System.out.println(elements.get(i).getText());
			// Selecting the month
			if (elements.get(i).getText().equals(monthyear)) {
				// Selecting the date

				for (WebElement d : days) {
					System.out.println(d.getText());
					if (d.getText().equals(Selectday)) {
						d.click();

						return;

					}
				}

			}

		}

		nextArrow.click();

		selectDate(elements, monthyear, days, Selectday);

	}

	public FlightSearchPage clickOnSearchBtn() {
		searchBtn.click();
		return new FlightSearchPage();

	}

}
