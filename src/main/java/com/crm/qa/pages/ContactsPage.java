package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']/input")
	WebElement company;
	
	// select status  dropdown  but there is no select TAG
	//div[@name='status']
	
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	
	// Initialize PageFactory Elements 
	public ContactsPage(){
		PageFactory.initElements(driver, this);    // here we are not calling super() class constructor, that will be in TEST classes
	}

		
	public boolean verifyContactsLabel() throws Exception {
		Thread.sleep(3000);
		return contactsLabel.isDisplayed();
	}
	
	
	// selecting checkbox  --> this is a dynamic selection --> we just need to pass text value and then it will select Checkbox related to that particular text
	
	public void selectContactsByName(String name) {
		//contactsLabel.click();
		//driver.findElement(By.xpath("//a[text()='prashant shaha']//parent::td//preceding-sibling::td/div[@class='ui fitted read-only checkbox']/input[@name='id' and @class='hidden']")).click();
		
		WebElement el = driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td/div[@class='ui fitted read-only checkbox']/input[@name='id' and @class='hidden']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", el);
			
	}
	
	public boolean verifyContactsCheckboxCheckedTest(String name) {
		//contactsLabel.click();
		//driver.findElement(By.xpath("//a[text()='prashant shaha']//parent::td//preceding-sibling::td/div[@class='ui fitted read-only checkbox']/input[@name='id' and @class='hidden']")).click();
		
		WebElement el = driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td/div[@class='ui fitted read-only checkbox']/input[@name='id' and @class='hidden']"));
		
		return el.isSelected();
		
			
	}
	
	public void createNewContact(String fname, String lname, String comp) {
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
	
}
