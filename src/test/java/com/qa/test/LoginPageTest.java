package com.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;

	 Logger log=Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("launching browser");
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void validateLoginPageTitleTest() {
		log.info("************************first TestCase*********************");

		String title = loginPage.validateLoginPageTitle();
		System.out.println("abc");
		System.out.println(title);
		log.info("title is --"+title);
		log.warn("hey it is warning");
		log.fatal("");
		log.debug("");
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}

	@Test(priority = 2)
	public void validateCRMLogo() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		homepage = loginPage.login(username, password);
	}
	@Test(priority=4)
public void validatesignUpBtnTest() {
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
