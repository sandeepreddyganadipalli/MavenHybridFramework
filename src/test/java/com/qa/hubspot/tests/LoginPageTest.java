package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.annotations.SerializedName;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;



public class LoginPageTest {

	BasePage basepage;
	Properties properties;
	WebDriver driver;
	LoginPage loginpage;

	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		properties = basepage.init_properties();
		driver = basepage.init_driver(properties);
		loginpage = new LoginPage(driver);
	}

	

	@Test(priority = 1, description ="verifying login page title test")
//	@Severity(SeverityLevel.NORMAL)
//	@Description("Test Case Description : Verify login page title test onLogin Page")
//	@Story("Story Name : To check login page title")
	public void loginPageTitleTest() {
		String pagaTItle = loginpage.getLoginPageTitle();
		System.out.println("page title is :: " + pagaTItle);
		Assert.assertEquals(pagaTItle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2,description = "verifying sign up link link test")
//	@Severity(SeverityLevel.CRITICAL)
//	@Description("Test Case Description : Verify the sing up link test")
//	@Story("Stroy Name: To check sign up link is displayed link test")
	public void signUpLinkTest() {
		Assert.assertTrue(loginpage.signUpLinkIsDisplaye());
	}

	@Test(priority = 3,description = "user able to login into application test")
//	@Severity(SeverityLevel.BLOCKER)
//	@Description("Test Case Description :user able to login into application test")
//	@Story("Story Name : user able to login into application test")
	public void loginTest() {
		loginpage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
