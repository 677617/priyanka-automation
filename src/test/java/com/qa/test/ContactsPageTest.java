package com.qa.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	ContactsPage contactsPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	String sheetName="Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		TestBase.initialization();
		contactsPage=new ContactsPage();
		loginPage=new LoginPage();
		testutil=new TestUtil();
		//homePage=new HomePage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame();
		contactsPage=homePage.ClickOnContactTab();

	}

	
	@Test(priority=1)
	public void verifyContactPageLabel() {
		boolean flag=contactsPage.verfifyContactLabel();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=2)
	public void validateSelectContactbyName() {
		contactsPage.selectContactByName("Arpit Kho");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] =TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateNewcontacts(String title,String Fname,String Lname,String companyName) {
		homePage.newContactLink();	
		contactsPage.createNewContact(title,Fname,Lname,companyName);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
