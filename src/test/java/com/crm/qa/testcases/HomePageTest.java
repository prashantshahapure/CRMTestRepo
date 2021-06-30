package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {

		super();
	}

	
	// NOTE:- Test cases should be separated --> independent with each other
	// before each test case --> Launch the browser and login 
	// @Test  execute your test case
	// after each test case --> close the browser
	
	// Doesnt matter 1000 testcases also
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePagetitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePagetitle, "Cogmento CRM", "Home Page title not matched");
		// Assert.assertEquals(homePagetitle, "Cogmento CRM-qa", "Home Page title not
		// matched"); // to fail the test case TITLE will not match
	}
	 
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName()); // check manually in the DOM, is it in the frame before using it
	}

	
	@Test(priority=3)
	public void verifyContactsLinkTest() throws InterruptedException {
		Thread.sleep(3000);
		contactsPage = homePage.clickOnContactsLink();
	}
}
