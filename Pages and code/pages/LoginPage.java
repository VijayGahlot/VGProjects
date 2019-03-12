package com.mmt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmt.qa.base.BaseMMT;

public class LoginPage extends BaseMMT {

	// PageFactory -OR

	@FindBy(id = "ch_login_icon")
	WebElement loginIcon;

	@FindBy(id = "ch_login_email")
	WebElement username;

	@FindBy(id = "ch_login_password")
	WebElement password;

	@FindBy(id = "ch_login_btn")
	WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	//	takeScreenshot(loginPage);*/
	}

		public String getPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) {
		loginIcon.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();

		// HomePage object as HomePage will be reached after completing logging in
	}

}
