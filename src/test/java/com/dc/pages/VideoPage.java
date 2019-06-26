package com.dc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dc.utilities.Log;

public class VideoPage extends Page{
	private static WebDriver driver;

	public VideoPage(WebDriver driver) {
		try {
			PageFactory.initElements(driver,this);
			setWebDriver(driver);
		}
		catch(Exception ex) {
			Log.error("Error instantiating a new webdriver instance: "+ex.getMessage());
		}
	}
	/**
	 * Sets the webdriver instance to VideoPage driver
	 * 
	 * @param driver - WebDriver Instance
	 * @author reggy
	 */
	public void setWebDriver(WebDriver driver) {
		VideoPage.driver = driver;
	}
	
	/**
	 * Gets the WebDriver instance of VideoPage
	 * @return - WebDriver instance
	 * @author reggy
	 */
	public WebDriver getWebDriver() {
		return VideoPage.driver;
	}
}
