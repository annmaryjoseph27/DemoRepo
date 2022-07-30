package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	@FindBy(xpath = "//span[contains(text(),'Ann Joseph')]")
	WebElement userNameLabel;

}
