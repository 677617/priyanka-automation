package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;

	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verfifyContactLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactByName(String Name) {
		driver.findElement(By.xpath("//a[text()='"+ Name +"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
	}
	
	public void createNewContact(String title,String fN,String lN,String company) {
		Select select =new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
				
		firstName.sendKeys(fN);
		lastName.sendKeys(lN);
		companyName.sendKeys(company);
		
		saveBtn.click();
	}
}
