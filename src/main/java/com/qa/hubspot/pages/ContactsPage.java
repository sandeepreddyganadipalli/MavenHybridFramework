package com.qa.hubspot.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementActions;

public class ContactsPage extends BasePage {

	BasePage basepage;
	Properties properties;
	WebDriver driver;
	ElementActions elementactions;
	
	
	
	By header=By.cssSelector("h1>i18n-string");
	By createcontacts= By.xpath("//span[text()='Create contact']");
	By email=By.xpath("//input[@data-field='email']");
	By firstName=By.xpath("//input[@data-field='firstname']");
	By lastName=By.xpath("//input[@data-field='lastname']");
	By jobTitle=By.xpath("//input[@data-field='jobtitle']");
	By createContactBUtton=By.xpath("(//span[text()='Create contact'])[2]");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementactions= new ElementActions(this.driver);
	}

	public String getContactsPageTitle() {
		String pageTitle = elementactions.waitPageTitle(Constants.CONTATCS_PAGE_TITLE);
		return pageTitle;
	}

	
	public boolean isHeaderisDisplayed() {
		return elementactions.isElementDisplayed(header);
	}
	
	public String getHeaderText() {
		String headertext=elementactions.doGetText(header);
		return headertext;
	}
	
	public void createNewContact(String emailid,String Fn,String LN,String jobtitle) {
		
		elementactions.doClick(createcontacts);
		
		elementactions.doSendKeys(email, emailid);
		elementactions.doSendKeys(firstName, Fn);
		elementactions.doSendKeys(lastName, LN);
		elementactions.doSendKeys(jobTitle, jobtitle);
		
		elementactions.doClickActions(createContactBUtton);
		
	}
}
