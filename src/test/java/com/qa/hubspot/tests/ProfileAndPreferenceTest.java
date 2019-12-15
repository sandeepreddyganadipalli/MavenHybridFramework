package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.ProfileAndPreferencesPage;
import com.qa.hubspot.util.Constants;

public class ProfileAndPreferenceTest {
	BasePage basepage;
	Properties properties;
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	ProfileAndPreferencesPage profileandpreferences;

	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		properties = basepage.init_properties();
		driver = basepage.init_driver(properties);
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		profileandpreferences=homepage.doClickProfilepref();
	}

	@Test(priority = 1)
	public void profileAndPreferencesTitleTest() {
		String profileandpreferencestitle = profileandpreferences.getProfileAndPreferencesTitle();
		System.out.println("Profiel and Preferences Page title is " + profileandpreferencestitle);
		Assert.assertEquals(profileandpreferencestitle, Constants.PROFILE_AND_PREFERENCES_PAGTE_TITLE);
	}

	@Test(priority = 2)
	public void nameTextTest() {
		Assert.assertTrue(profileandpreferences.isNameDisplayed());

		String nametext = profileandpreferences.getName();
		System.out.println("name is :: " + nametext);
		Assert.assertEquals(nametext, properties.getProperty("name"));
	}

	@Test(priority = 3)
	public void superAdminTextTest() {
		Assert.assertTrue(profileandpreferences.isSuperAdminisDisplayed());

		String superadmintext = profileandpreferences.getSuperAdminText();
		System.out.println("Super Admin Text is :: " + superadmintext);
		Assert.assertEquals(superadmintext, Constants.SUPER_ADMIN_TEXT);
	}

	@Test(priority = 4)
	public void languageTextTest() {
		Assert.assertTrue(profileandpreferences.isLanguageisDisplayed());
		
		String languagetext=profileandpreferences.getLanguageText();
		System.out.println("Language text is ::"+languagetext);
		Assert.assertEquals(languagetext, Constants.LANGUAGE_TEXT);
	}
	
	@Test(priority = 5)
	public void DateAndNumberFormatTextTest() {
		Assert.assertTrue(profileandpreferences.isDateAndNumberFormatIsDisplayed());
		
		String dateandnumberformattext=profileandpreferences.getDateAndNumberFormatText();
		System.out.println("Date and numbe format text is ::"+dateandnumberformattext);
		Assert.assertEquals(dateandnumberformattext, Constants.DATE_AND_NUMBER_FORMAT_TEXT);
	}
	
	@Test(priority = 6)
	public void phoneNumberTextTest() {
		  Assert.assertTrue(profileandpreferences.isPhoneNumberIsDisplayed());
		  
		 String phonenumbetext= profileandpreferences.getPhoneNumberText();
		 System.out.println("phone number text is :: "+phonenumbetext);
		 Assert.assertEquals(phonenumbetext, Constants.PHONE_NUMBER_TEXT);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
