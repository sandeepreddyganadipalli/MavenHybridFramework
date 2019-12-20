package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.DealsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcelUtil;

public class DealsPageTest {

	BasePage basepage;
	WebDriver driver;
	Properties properties;
	LoginPage loginpage;
	HomePage homepage;
	DealsPage dealspage;

	@BeforeMethod
	public void setup() {
		properties = basepage.init_properties();
		driver = basepage.init_driver(properties);
		homepage = loginpage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		homepage.doClickDealsPage();
	}

	@Test
	public void titleTest() {
		String title = dealspage.getDealPageTitle();
		System.out.println("Deals page title is :: " + title);
		Assert.assertEquals(title, Constants.DEALS_PAGE_TITLE);

	}

	@Test
	public void dealsPageHeaderTest() {
		String header = dealspage.getDealsPageHeader();
		System.out.println("Deals page heaser is :: " + header);
		Assert.assertEquals(header, Constants.DEALS_PAGE_HEADER);

	}

	@DataProvider
	public Object[][] getDealsData() {

		Object[][] dealsdata = ExcelUtil.getTestData("Deals");
		return dealsdata;
	}

	@Test(dataProvider = "getDealsData")
	public void createDealTest(String DN, String AMT) {
		dealspage.createDeal(DN, AMT);
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
