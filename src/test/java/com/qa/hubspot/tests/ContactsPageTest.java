package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTest {

	
	BasePage basepage;
	Properties properties;
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;

	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		properties = basepage.init_properties();
		driver = basepage.init_driver(properties);
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		contactspage=homepage.goToContactsPage();

	}
	
	@Test(priority = 1)
	public void contactsPageTitleTest() {
		String pageTitle=contactspage.getContactsPageTitle();
		System.out.println("Contatcs page title is :: "+pageTitle);
		Assert.assertEquals(pageTitle, Constants.CONTATCS_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void ContactPageHeaderTest() {
		Assert.assertTrue(contactspage.isHeaderisDisplayed());
		
		String contactspageheadertext=contactspage.getHeaderText();
		System.out.println("Contacts page header is :: "+contactspageheadertext);
		Assert.assertEquals(contactspageheadertext, Constants.CONTATCS_PAGE_HEADER);
	}
	
	@DataProvider
	public Object[][] getContactsData() {
		Object data[][]=ExcelUtil.getTestData("Contacts");
		return  data;
	}
	@Test(priority = 3,dataProvider = "getContactsData")
	public void createNewContactTest(String emailid,String firstname,String lastname,String jobtitle) {
		contactspage.createNewContact(emailid,firstname,lastname,jobtitle);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
