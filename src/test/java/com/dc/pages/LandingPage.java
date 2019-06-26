package com.dc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dc.utilities.Log;
import com.dc.utilities.TestProperties;



public class LandingPage extends Page{

	private static WebDriver driver;
	
	@FindBy(css=".qc-cmp-button") WebElement ACCEPT_BUTTON;
	@FindBy(xpath="//span[contains(@class,'dropdown__current')]")WebElement SPORTS_DROPDOWN_LIST;
	@FindBy(css="a.video_thumbnail:nth-child(1) > div:nth-child(2)")WebElement VIDEO_ROW1_COLUMN1;
	@FindBy(css=".vjs-big-play-button")WebElement PLAY_BUTTON;
	@FindBy(css="#nav > div.nav_category_v8_5 > div > div.eso-shop-link > a > span.eso-shop-link__icon")WebElement SHOP_ICON;
	@FindBy(css="#vjs_video_3 > div.vjs-control-bar.vjs-focus-within > button.vjs-fullscreen-control.vjs-control.vjs-button")WebElement MAXIMISE_ICON;
	@FindBy(css="#vjs_video_3 > div.vjs-control-bar.vjs-focus-within > button.vjs-play-control.vjs-control.vjs-button.vjs-paused")WebElement PAUSED_ICON;
	@FindBy(css="#vjs_video_3 > div.vjs-control-bar.vjs-focus-within > button.vjs-play-control.vjs-control.vjs-button.vjs-playing")WebElement PLAYING_ICON;
	@FindBy(css="#vjs_video_3 > div.video__skip.video__skip--skippable")WebElement SKIP_ADVERT_ICON;
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
	 * Navigates to the LandingPage
	 * @author reggy
	 */
	public void navigateToLandingPage() {
		String sUrl = TestProperties.getTestProperty("url");
		try {
			driver.get(sUrl);
			Log.info("Navigating to: "+sUrl);
		} 
		catch (Exception ex) {
			Log.error("Could not navigate to: " + sUrl + "\n" + ex.getMessage());
		}
	}
	
	public void navigateToUrl(String strUrl) {
		try {
			driver.navigate().to(strUrl);
			Log.info("Navigating to: "+strUrl);
		}
		catch(Exception ex) {
			Log.error("could not navigate to: "+strUrl);
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
		return isElementDisplayed(ACCEPT_BUTTON, "I ACCEPT", TestProperties.MEDIUM_WAIT);
	}
	
	public boolean isAllSportsDropDownListDisplayed() {
		return isElementDisplayed(SPORTS_DROPDOWN_LIST, "All Sports DropDwn List", TestProperties.MEDIUM_WAIT);
	}
	
	public boolean isShopIconDisplayed() {
		return isElementDisplayed(SHOP_ICON, "Shop Icon", TestProperties.MEDIUM_WAIT);
	}
	
	public boolean isPlayButtonDisplayed() {
		return isElementDisplayed(PLAY_BUTTON, "Play Button", TestProperties.MEDIUM_WAIT);
	}
	
	public boolean isPlayingIconDisplayed() {
		return isElementDisplayed(PLAYING_ICON, "Playing Icon", TestProperties.MEDIUM_WAIT);
	}
	
	public boolean isPausedIconDisplayed() {
		return isElementDisplayed(PAUSED_ICON, "Paused Icon", TestProperties.MEDIUM_WAIT);
	}
	
	public boolean isMaximiseIconDisplayed() {
		return isElementDisplayed(MAXIMISE_ICON, "Maximise Icon", TestProperties.MEDIUM_WAIT);
	}
	
	private void clickVideoPlayerIcon(String strWhatIcon) {
		
		switch(strWhatIcon.toLowerCase()) {
		case "play":
			clickButton(PLAYING_ICON,"PLAYING ICON");
			break;
		case "pause":
			clickButton(PAUSED_ICON,"PAUSED ICON");
			break;
		case "maximize":
			clickButton(MAXIMISE_ICON,"MAXIMISE ICON");
			break;
		}
	}
	
	/**
	 * Checks for existense of specified icon
	 * @param strWhatIcon - Either Play, Pause or Maximize
	 * @return True or False
	 */
	public boolean checkVideoPlayerIcon(String strWhatIcon) {
		boolean isDisplayed = false;
		
		switch(strWhatIcon.toLowerCase()) {
		case "play":
			clickButton(PLAYING_ICON,"PLAYING ICON");
			Log.info("Play Icon is displayed");
			isDisplayed = true;
			break;
		case "pause":
			clickButton(PAUSED_ICON,"PAUSED ICON");
			Log.info("Pause Icon is displayed");
			isDisplayed = true;
			break;
		case "maximize":
			clickButton(MAXIMISE_ICON,"MAXIMISE ICON");
			Log.info("Maximize Icon is displayed");
			isDisplayed = true;
			break;
		}
		return isDisplayed;
	}
	
	public void clickIAcceptButton() {
		clickButton(ACCEPT_BUTTON,"I ACCEPT");
	}
	
	public void clickOnLinkByText(String strText) {
		String strTemp=driver.findElement(By.tagName("body")).getText().toLowerCase();
		
		while(!strTemp.contains(strText.toLowerCase())) {
			sleepFor(TestProperties.SHORT_WAIT);
			strTemp=driver.findElement(By.tagName("body")).getText().toLowerCase();
			Log.info("waiting for link containing: "+strText );
		}
		clickLinkByText(driver,strText);
	}
	
	public void clickOnAllSportsDropDownList() {
		clickElement(SPORTS_DROPDOWN_LIST,"All Sports DropDown List");
	}
	
	
	public boolean selectItemFromAllSportsDropDownList(String strItem) {
		clickOnAllSportsDropDownList();
		
		boolean bSelect = false; int index = 1;String sItem="";
		while(bSelect == false){
			try {
			String strCssSelector = "#dropdown-video-list-sport > ul:nth-child(3) > li:nth-child("+index+")";
			sItem = driver.findElement(By.cssSelector(strCssSelector)).getText().toLowerCase();
			if(sItem.equals(strItem.toLowerCase())){
				bSelect = true;
				driver.findElement(By.cssSelector(strCssSelector)).click();
				Log.info(strItem+" is selected from AllSports Dropdown List");
				}
			else {
				Log.info(sItem+" is not the required item. Next...");
				index++;
				}
			}
			catch(Exception ex) {
				Log.info(sItem+" is not the required item. Next...");
				index++;
			}
		}
		return bSelect;
	}
	
	public void clickPlayButton() {
		clickButton(PLAY_BUTTON,"Play");
	}
	
	public WebElement selectVideo1Row1() {
		return clickElement(VIDEO_ROW1_COLUMN1,"Video On Row1 Column1");
	}
	
	public String getCurrentPageTitle() {
		return getPageTitle(driver);
	}
	
	public void playVideo() {
		actOnVideo(driver,"play");
	}
	
	public void pauseVideo() {
		actOnVideo(driver,"pause");
	}
	
	public void reloadVideo() {
		actOnVideo(driver,"reload");
	}
	
	public void restartVideo() {
		actOnVideo(driver,"restart");
	}
}
