package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	
	@FindBy(xpath = "//div[text() ='Contacts']")
	WebElement contactsPageLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Ann Joseph')]")
	WebElement userNameLabel;
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "last_name")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@class ='search']//parent::div[@name ='company']")
	WebElement companyName;
	
	@FindBy(xpath = "//button[@class ='ui linkedin button']")
	WebElement saveButton;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsPageLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(userNameLabel).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text() ='"+name+"']//parent::td//preceding-sibling::td//div[@class ='ui fitted read-only checkbox']//input")).sendKeys(Keys.ENTER);
	}
	public void createNewContact(String fName, String lName) throws InterruptedException {
		//Select select = new Select(driver.findElement(By.xpath("//*[@name='category']//parent::div[@class='ui field']")));
		//select.selectByVisibleText(category);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		//companyName.sendKeys(Company);
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);
	}
}
