package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//span[contains(text(),'Ann Joseph')]")
	WebElement userNameLabel;
	
	@FindBy(xpath ="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath ="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath ="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath ="//a[@href = '/contacts']//following-sibling::button")
	WebElement newContactsAddLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();	
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	public void clickOnContactsAddLink() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		Thread.sleep(2000);
		newContactsAddLink.sendKeys(Keys.ENTER);
	}
}
