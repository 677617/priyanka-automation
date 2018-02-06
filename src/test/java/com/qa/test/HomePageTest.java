package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.util.TestUtil;
import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	TestUtil testutil;
	
	public HomePageTest(){
		super();
		
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage=new HomePage();
		testutil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void validateHomePageTitleTest() {
		String homePageTitle=homePage.validateHomePageTitle();
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle, "CRMPRO");
		
	}
	
	@Test(priority=2)
	public void verifyCorrectUserNameTest() {
		
		testutil.switchToFrame();
		boolean flag=homePage.validateHomePageLabel();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void clickOnContactsPageLink() {
		testutil.switchToFrame();
		contactsPage=homePage.ClickOnContactTab();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
