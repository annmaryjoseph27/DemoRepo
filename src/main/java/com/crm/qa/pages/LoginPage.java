package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	
	//Page Factory or OR
	@FindBy(linkText = "Login")
	WebElement login;
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]")
	WebElement loginBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle(); 
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException {
		Thread.sleep(2000);
		login.click();
		Thread.sleep(2000);
		username.sendKeys(un);
		Thread.sleep(2000);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
		
	}
	
}
