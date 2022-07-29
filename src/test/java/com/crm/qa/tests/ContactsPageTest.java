package com.crm.qa.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	String sheetName ="Sheet1";
	
	public ContactsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		contactspage =new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickOnContactsLink();
		Thread.sleep(2000);
			}
	
	@Test(priority =1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue( contactspage.verifyContactsLabel(),"Contacts Label is not Matched");
		
	}
	
	@Test(priority =2)
	public void selectContactsTest() throws InterruptedException {	
		contactspage.selectContactsByName("AA AA");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority =3 ,dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName) throws InterruptedException {
		homepage.clickOnContactsAddLink();
		//contactspage.createNewContact( "abc", "abc");
		contactspage.createNewContact( firstName, lastName);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
