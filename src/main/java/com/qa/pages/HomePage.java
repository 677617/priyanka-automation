package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	WebElement userLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsTab;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealTab;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		String homePageTitle = driver.getTitle();
		return homePageTitle;

	}

	public boolean validateHomePageLabel() {
		boolean homePageLabel = userLabel.isDisplayed();
		return homePageLabel;
	}

	public ContactsPage ClickOnContactTab() {
		contactsTab.click();

		return new ContactsPage();

	}

	public DealsPage clickonDealTab() {
		dealTab.click();
		return new DealsPage();

	}

	public void newContactLink() {
		Actions actions=new Actions(driver);
		actions.moveToElement(contactsTab).build().perform();
		newContactLink.click();

	}

	public void clickOnTaskTab() {

	}
}
