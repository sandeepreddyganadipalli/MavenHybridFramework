package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementActions;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementActions elementactions;
	// locators or object repositories
	By header = By.cssSelector("span.private-dropdown__button-label>h1");
	By accountname = By.className("account-name");
	
	By dropsdown= By.className("account-name");
	By profileandpref= By.className("user-info-preferences");
	
	
	By contactMainTab= By.id("nav-primary-contacts-branch");
	By contactChildTab=By.id("nav-secondary-contacts");
	

	By salesfropdown=By.id("nav-primary-sales-branch");
	

	//By  salesDropDown=By.linkText("Sales");
	By deals=By.linkText("Deals");
	
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementactions= new ElementActions(this.driver);
	}

	public String homePageTitle() {
		String pageTitle = elementactions.waitPageTitle(Constants.HOME_PAGE_TITLE);
		return pageTitle;
	}

	public boolean isHomePageHeaderIsVisible() {
		return elementactions.isElementDisplayed(header);
	}

	public String getHomePageHeaderText() {
		String pageTitle = elementactions.doGetText(header);
		return pageTitle;
	}

	public boolean isAccountNameIsVisible() {
		return elementactions.isElementDisplayed(accountname);
	}

	public String getAccountNameText() {
		String accountNameText = elementactions.doGetText(accountname);
		return accountNameText;
		
		
	}
	
	public ContactsPage goToContactsPage() {
		
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnContacts() {
	elementactions.doClick(contactMainTab);
		elementactions.doClick(contactChildTab);
	}
	public ProfileAndPreferencesPage goToProfilePage() {
		
		doClickProfilepref();
		return new ProfileAndPreferencesPage(driver);
	}

	private  void doClickProfilepref() {
		

		elementactions.doClick(dropsdown);
		
		elementactions.doClick(profileandpref);
		
		
	}
	
	public DealsPage goToDealPage() {
		doClickDealsPage();
		
		
		return new DealsPage(driver);
	}
	
	private void doClickDealsPage() {
		
		elementactions.doClick(salesfropdown);
		elementactions.doClick(deals);
		
	
	}
}
