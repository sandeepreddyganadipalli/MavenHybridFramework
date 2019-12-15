package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementActions;

public class ProfileAndPreferencesPage extends BasePage{
	
	WebDriver driver;
	ElementActions elementactions;
	
	//locators /Object repositories
	
	By name=By.xpath("//span[@data-test-id=\"name\"]");
	By superadmin=By.xpath("//span[contains(text(),'Super Admin')]");
	By language=By.xpath("//span[@class='private-help-icon private-form__help-tooltip private-help-icon--inline']/label[contains(text(),'Language')]");
	By dateandformatnumber=By.xpath("//span[@class='private-help-icon private-form__help-tooltip private-help-icon--inline']/label[contains(text(),'Date & number format')]");
	By phonenumber=By.xpath("//label[contains(text(),'Phone number')]");
	
	By languageinputtext=By.xpath("//div[@id='UIFormControl-4']");
	By dateandformatnumberinputtext=By.xpath("//div[@id='UIFormControl-6']");
	By phonenumberinputtext=By.cssSelector("input.form-control.private-form__control.phone-text-input");
	
	
	// define constructor

	public ProfileAndPreferencesPage(WebDriver driver) {
		this.driver = driver;
		elementactions= new ElementActions(this.driver);
	}

	public String getProfileAndPreferencesTitle() {
		String profileandpreferencetitle=elementactions.waitPageTitle(Constants.PROFILE_AND_PREFERENCES_PAGTE_TITLE);
		return profileandpreferencetitle;
	}

	
	
	public boolean isNameDisplayed() {
		return elementactions.isElementDisplayed(name);
	}
	
	public String getName() {
		String nametext=elementactions.doGetText(name);
		return nametext;
	}
	
	public boolean isSuperAdminisDisplayed() {
		return elementactions.isElementDisplayed(superadmin);
	}
	public String getSuperAdminText() {
		String superadmintext=elementactions.doGetText(superadmin);
		return superadmintext;
	}
	
	public boolean isLanguageisDisplayed() {
		return elementactions.isElementDisplayed(language);
	}
	
	public String getLanguageText() {
		String languagetext=elementactions.doGetText(language);
		return languagetext;
	}
	
	public boolean isDateAndNumberFormatIsDisplayed() {
	return 	elementactions.isElementDisplayed(dateandformatnumber);
	}
	
	public String getDateAndNumberFormatText() {
		String dateandnumberformattext=elementactions.doGetText(dateandformatnumber);
		return dateandnumberformattext;
	}

	public boolean isPhoneNumberIsDisplayed() {
		return elementactions.isElementDisplayed(phonenumber);
	}
	public String getPhoneNumberText() {
		String phonenumbetext=elementactions.doGetText(phonenumber);
		return phonenumbetext;
	}

	
}
