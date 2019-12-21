package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementActions;

public class DealsPage extends BasePage{
	
	
	WebDriver driver;
	ElementActions elementactions;
	
	
	//objects
	By dealspageHeader=By.cssSelector("h1>i18n-string");
	By createdeal=By.xpath("//span[text()='Create deal']");
	By dealName=By.xpath("//input[@data-field='dealname']");
	By amount=By.xpath("//input[@data-field='amount']");
	By createButton=By.xpath("//span[text()='Create']");
	
	
	//constructor
	public DealsPage(WebDriver driver) {
		this.driver=driver;	
		elementactions= new ElementActions(this.driver);
	}
	
	
	public String getDealPageTitle() {
		String title=elementactions.waitPageTitle(Constants.DEALS_PAGE_TITLE);
		return title;
	}
	public String getDealsPageHeader() {
		String dealspageheader=elementactions.doGetText(dealspageHeader);
		return dealspageheader;
	}
	
	public void createDeal(String dealname,String Amount) {
	
		elementactions.doClick(createdeal);
		elementactions.doSendKeys(dealName, dealname);
		elementactions.doSendKeys(amount, Amount);
	
	}
	

}
