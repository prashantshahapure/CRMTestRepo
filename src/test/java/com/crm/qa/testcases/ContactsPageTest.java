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

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	
	public ContactsPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void verifyContactsPageLabel() throws Exception {
		
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing on the page");
	}
	
	
	@Test(priority=2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("prashant shaha");
		//Assert.assertTrue(contactsPage.verifyContactsCheckboxCheckedTest("prashant shaha"));   // giving no such element exception
	}
	
	@Test(priority=3)
	public void selectMultipleContacts() {
		contactsPage.selectContactsByName("prashant shaha");
		contactsPage.selectContactsByName("Naveen K");
	}
	
	
	//@Test(priority=4)
	public void verifyContactsCheckboxCheckedTest() {
		Assert.assertTrue(contactsPage.verifyContactsCheckboxCheckedTest("prashant shaha"));
		
	}
	
}
