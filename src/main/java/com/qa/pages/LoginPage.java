package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement logo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean validateCRMImage() {
		boolean flag = logo.isDisplayed();
		return flag;
	}
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public void validateSignUpPageBtn() {
		signUpBtn.click();
		
	}
}
