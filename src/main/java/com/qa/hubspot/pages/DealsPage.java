package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementActions;

public class DealsPage extends BasePage{
	
	
	WebDriver driver;
	ElementActions elementActions;
	
	
	//objects
	By dealspageHeader=By.cssSelector("h1>i18n-string");
	By createdeal=By.xpath("//span[text()='Create deal']");
	By dealName=By.xpath("//input[@data-field='dealname']");
	By amount=By.xpath("//input[@data-field='amount']");
	By createButton=By.xpath("//span[text()='Create']");
	
	
	//constructor
	public DealsPage(WebDriver driver) {
		this.driver=driver;	
		elementActions=new ElementActions(driver);
	}
	
	
	public String getDealPageTitle() {
		String title=elementActions.waitPageTitle(Constants.DEALS_PAGE_TITLE);
		return title;
	}
	public String getDealsPageHeader() {
		String dealspageheader=elementActions.doGetText(dealspageHeader);
		return dealspageheader;
	}
	
	public void createDeal(String dealname,String Amount) {
	
		elementActions.doClick(createdeal);
		elementActions.doSendKeys(dealName, dealname);
		elementActions.doSendKeys(amount, Amount);
	
	}
	

}
