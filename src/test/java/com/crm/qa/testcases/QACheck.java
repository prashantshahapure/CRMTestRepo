package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class QACheck extends TestBase{
		
		LoginPage loginPage;
		HomePage homePage;
		ContactsPage contactsPage;
		TestUtil testUtil;
		
		
		public QACheck() {
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
			//driver.quit();
		}
		
		
			
		
		@Test(priority=1)
		public void selectContactsTest() throws Exception {
			//contactsPage.selectContactsByName("prashant shaha");
			//Thread.sleep(3000);
			//driver.findElement(By.name("view")).click();
			//Thread.sleep(3000);
			//WebDriverWait wt = new WebDriverWait(driver, 10);
			//wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='prashant shaha']//parent::td//preceding-sibling::td/div[@class='ui fitted read-only checkbox']/input[@name='id' and @class='hidden']"))).click();
			WebElement el = driver.findElement(By.xpath("//a[text()='prashant shaha']//parent::td//preceding-sibling::td/div[@class='ui fitted read-only checkbox']/input[@name='id' and @class='hidden']"));
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", el);
		}
	

}
