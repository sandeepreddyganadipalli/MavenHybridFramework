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
import com.qa.hubspot.util.Constants;

public class HomePageTest {
	BasePage basepage;
	Properties properties;
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;

	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		properties = basepage.init_properties();
		driver = basepage.init_driver(properties);
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(properties.getProperty("username"), properties.getProperty("password"));

	}

	@Test(priority = 1)
	public void homePageTitleTest() {
		String homePageTitle = homepage.homePageTitle();
		System.out.println("Homepage title is :: " + homePageTitle);
		Assert.assertEquals(homePageTitle, Constants.HOME_PAGE_TITLE);
	}


	@Test(priority = 2)
	public void homePageHeaderTextTest() {
		Assert.assertTrue(homepage.isHomePageHeaderIsVisible());
		
		String homepageheadertitle = homepage.getHomePageHeaderText();
		System.out.println("Homepage header title is " + homepageheadertitle);
		Assert.assertEquals(homepageheadertitle, Constants.HOME_PAGE_HEADER_TEXT);
	}

	@Test(priority = 3)
	public void accountNameTextTest() {
		Assert.assertTrue(homepage.isHomePageHeaderIsVisible());
		
		String accountname = homepage.getAccountNameText();
		System.out.println("Account Name Text is " + accountname);
		Assert.assertEquals(accountname, properties.getProperty("accountname"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
