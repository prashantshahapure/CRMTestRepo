package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFacoty  -  OR   Object Repository
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpLink;
	
	
	
	// To initialize Page Objects -->these all WebElements so use the PageFactory class initElements() method
	
	public LoginPage() {
		PageFactory.initElements(driver, this);   // here this means Current Class objects   i.e. all variables, webelements will be initialized with webdriver
	//PageFactory.initElements(driver, LoginPage.class);	 // we can user this also ----> instead of "this" we can user LoginPage.class
	}
	
	
	// Now we can define here different Functionality/ Features / Actions    of the LoginPage  
	
	//validate LoginPageTitle
	//Enter username and password
	//click Login Button
	//click SignUp link
	
	
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		//return crmLogo.isDisplayed();
		return true;
	}
	
	
	public HomePage Login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();       // here after login we are landing on Home Page i.e. it will return HomePage----> so creating object of HomePage
		
		return new HomePage();  // So after login it will return HomePage --> so returning HomePage new object and return type also changed to HomePage
	}

}
