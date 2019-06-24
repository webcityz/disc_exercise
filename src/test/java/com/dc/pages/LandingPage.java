package com.dc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dc.utilities.TestProperties;

import jdk.internal.jline.internal.Log;

public class LandingPage extends Page{

	private static WebDriver driver;
	
	@FindBy(css=".qc-cmp-button") WebElement ACCEPT_BUTTON;
	
	/**
	 * Constructor
	 * @param driver - WebDriver
	 * @author reggy
	 */
	public LandingPage(WebDriver driver) {
		try {
			PageFactory.initElements(driver,this);
			setWebDriver(driver);
		}
		catch(Exception ex) {
			Log.error("Error instantiating a new webdriver instance: "+ex.getMessage());
		}
	}
	
	/**
	 * Sets the webdriver instance to LandingPage driver
	 * 
	 * @param driver - WebDriver Instance
	 * @author reggy
	 */
	public void setWebDriver(WebDriver driver) {
		LandingPage.driver = driver;
	}
	
	/**
	 * Gets the WebDriver instance of LandingPage
	 * @return - WebDriver instance
	 * @author reggy
	 */
	public WebDriver getWebDriver() {
		return LandingPage.driver;
	}
	
	public boolean isIAcceptButtonDisplayed() {
		return isElementDisplayed(ACCEPT_BUTTON, "I ACCEPT", TestProperties.SHORT_WAIT);
	}
}
