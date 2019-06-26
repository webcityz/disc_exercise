package com.dc.pages;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dc.utilities.Log;
import com.dc.utilities.TestProperties;



public class Page {

	/**
	 * Checks if specified element is displayed or not, within a specified period
	 * @param wElement - Instance of WebElement
	 * @param strElementName - Name of Element
	 * @param iTimeLimit - Maximum time limit
	 * @return True or False
	 * @author reggy
	 */
	public boolean isElementDisplayed(WebElement wElement, String strElementName,int iTimeLimit) {
		boolean isDisplayed = false; int iStartTime = 0;
		
		while(iStartTime < iTimeLimit && isDisplayed == false) {
			try {
				sleepFor(TestProperties.SHORT_WAIT);
				iStartTime = iStartTime + TestProperties.SHORT_WAIT;
				isDisplayed = wElement.isDisplayed();
				Log.info("Element for "+strElementName+" is displayed!");
			}
			catch(Exception ex) {
				Log.info("Element for "+strElementName+" is not displayed!");
			}
		}
		return isDisplayed;
	}
	
	public void actOnVideo(WebDriver driver,String strAction) {
		WebElement videoPlayer = driver.findElement(By.id("vjs_video_3"));
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		
		//Get the Source of Video that will be played in Video Player
		//String source = (String) jsExecutor.executeScript("return arguments[0].currentSrc;", videoPlayer);
		//Get the Duration of Video
		//long duration = (Long) jsExecutor.executeScript("return arguments[0].duration", videoPlayer);
		
		switch(strAction.toLowerCase()) {
		case "play":
		jsExecutor.executeScript("document.getElementById(\"vjs_video_3\").play()");
		//Play the Video
		//jsExecutor.executeScript("return arguments[0].play()", videoPlayer);
		Log.info("Playing Video...");
		sleepFor(TestProperties.MEDIUM_WAIT);
			break;
		case "pause":
		 //pause playing video 
		 jsExecutor.executeScript("document.getElementById(\"vjs_video_3\").pause()");
			//jsExecutor.executeScript("return arguments[0].pause()", videoPlayer);
			Log.info("Pausing Video...");
			sleepFor(TestProperties.SHORT_WAIT);
		 //check video is paused
		 System.out.println(jsExecutor.executeScript("document.getElementById(\"vjs_video_3\").paused"));
		   System.out.println();
		 //jsExecutor.executeScript("document.getElementById(\"video\").play()");
		 break;
		case "restart":
		 // play video from starting
		 jsExecutor.executeScript("document.getElementById(\"video\").currentTime=0");
		 Log.info("Restarting Video...");
		 sleepFor(TestProperties.MEDIUM_WAIT);
		 
		 break;
		case "reload":
		 //reload video
		 jsExecutor.executeScript("document.getElementById(\"video\").load()");
		 Log.info("Reloading Video...");
		 sleepFor(TestProperties.SHORT_WAIT);
		}
		
		sleepFor(TestProperties.MEDIUM_WAIT);
		
		//Pause the video
		jsExecutor.executeScript("arguments[0].pause()", videoPlayer);
		
		
	}
	
	/**
	 * Clicks on specified button
	 * @param eButton - WebElement of button
	 * @param sButtonName - Text on button
	 * @author reggy
	 */
	public void clickButton(WebElement eButton, String sButtonName) {
		try {
			eButton.click();
			Log.info("Clicking on button named "+sButtonName);
		}
		catch(Exception ex) {
			Log.error("Error clicking on "+sButtonName+" button \n"+ex.getMessage());
		}
	}
	
	/**
	 * Clicks on specified WebElement
	 * @param wElement - WebElement Instance
	 * @param strElementName - Name of WebElement
	 * @author reggy
	 */
	public WebElement clickElement(WebElement wElement, String strElementName) {
		try {
			isElementDisplayed(wElement,strElementName,TestProperties.MEDIUM_WAIT);
			wElement.click();
			Log.info("Clicked on element named: "+strElementName);
		}
		catch(Exception ex) {
			Log.error("Error clicking on element named: "+strElementName+"\n"+ex.getMessage());
		}
		return wElement;
	}
	
	/**
	 * Returns the title of the current page
	 * @param driver - WebDriver Instance
	 * @return Title of Current Page
	 * @author reggy
	 */
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	
	/**
	 * Clicks on a link identified by text
	 * @param driver - WebDriver instance
	 * @param strText - Text of the link
	 * @author reggy
	 */
	public void clickLinkByText(WebDriver driver,String strText) {
		try {
			WebElement wElement = driver.findElement(By.linkText(strText));
			if(wElement.isDisplayed()) {
				wElement.click();
				Log.info("Clicking on Link containing Text: "+strText);
			}
			else {
				Log.info("Could not click on Link containing text: "+strText);
			}
			
		}
		catch(Exception ex) {
			Log.error("Could not click on Link containing text: "+strText+"\n"+ex.getMessage());
		}
	}
	/**
	 * Sleeps for specified time
	 * @param iHowLong - Duration
	 * @author reggy
	 */
	public void sleepFor(int iHowLong) {
		try {
			Log.info("Sleeping for "+iHowLong+" milliseconds...");
			TimeUnit.MILLISECONDS.sleep(iHowLong);
		}
		catch(Exception ex) {
			Log.error(ex.getMessage());
		}
	}
}
