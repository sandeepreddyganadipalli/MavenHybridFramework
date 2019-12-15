package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementActions;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementActions elementactions;
	// 1.define Object repositories/Page Object:: using By locator

	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.xpath("//a[@class='m-left-1']");

	// 2.define a constructor :

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementactions= new ElementActions(this.driver);
	}

	// 3.Page Actions/Methods
	@Step("getting login page title step...")
	public String getLoginPageTitle() {
		return elementactions.waitPageTitle(Constants.LOGIN_PAGE_TITLE);
	}

	@Step("login with username : {0} and password :{1} step...")
	public HomePage doLogin(String username, String pwd) {
		
		elementactions.doSendKeys(emailId, username);
		elementactions.doSendKeys(password, pwd);
		elementactions.doClick(loginButton);
	
		return new HomePage(driver);
		
	}
	@Step("verifying sign up link is displayed step...")
	public boolean signUpLinkIsDisplaye() {
		return  elementactions.isElementDisplayed(signUpLink);
		
	}

}
