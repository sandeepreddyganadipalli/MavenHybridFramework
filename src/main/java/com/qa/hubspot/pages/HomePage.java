package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementActions;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementActions elementactions;
	// locators or object repositories
	By header = By.cssSelector("span.private-dropdown__button-label>h1");
	By accountname = By.className("account-name");
	
	By dropsdown= By.cssSelector("a#account-menu>svg");
	By profileandpref= By.className("user-info-preferences");
	
	
	By contactMainTab= By.id("nav-primary-contacts-branch");
	By contactChildTab=By.id("nav-secondary-contacts");
	
	
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
//	public void doClickDropDown() {
//		
//	}

	public ProfileAndPreferencesPage doClickProfilepref() {
		

		elementactions.doClick(dropsdown);
		
		elementactions.doClick(profileandpref);
		
		return new ProfileAndPreferencesPage(driver);
	}
}
