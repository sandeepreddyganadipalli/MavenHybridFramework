package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author sganadipalli
 *
 */

public class BasePage {

	WebDriver driver;
	Properties properties;

	/**
	 * This method is used to initalize the browser driver on the basis of browser.
	 * 
	 * @return driver
	 */
	public WebDriver init_driver(Properties properties) {

		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C://Users//sganadipalli//OneDrive - DXC Production//Softwares//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C://Users//sganadipalli//OneDrive - DXC Production//Softwares//geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please define the proper browser value");

		}

		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(url);
		
		return driver;
	}

	/**
	 * This method is used to get the properties from the config properties file
	 * 
	 * @return properties
	 */
	public Properties init_properties() {

		properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(
					"C://Users//sganadipalli//Desktop//Documents//NaveenPOMSeries//src//main//java//com//qa//hubspot//config//config.properties");
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return properties;

	}

}
