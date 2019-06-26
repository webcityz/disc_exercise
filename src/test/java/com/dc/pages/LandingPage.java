package com.dc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dc.utilities.Log;
import com.dc.utilities.TestProperties;

public class LandingPage extends Page {

	private static WebDriver driver;

	@FindBy(css = ".qc-cmp-button")	WebElement ACCEPT_BUTTON;
	@FindBy(xpath = "//span[contains(@class,'dropdown__current')]")	WebElement SPORTS_DROPDOWN_LIST;
	@FindBy(css = "a.video_thumbnail:nth-child(1) > div:nth-child(2)")WebElement VIDEO_ROW1_COLUMN1;
	@FindBy(css = ".vjs-big-play-button")WebElement PLAY_BUTTON;
	@FindBy(css = "#nav > div.nav_category_v8_5 > div > div.eso-shop-link > a > span.eso-shop-link__icon")	WebElement SHOP_ICON;
	@FindBy(css = "#vjs_video_3 > div.vjs-control-bar.vjs-focus-within > button.vjs-fullscreen-control.vjs-control.vjs-button")	WebElement MAXIMISE_ICON;
	@FindBy(css = "#vjs_video_3 > div.vjs-control-bar.vjs-focus-within > button.vjs-play-control.vjs-control.vjs-button.vjs-paused")WebElement PAUSED_ICON;
	@FindBy(css = "#vjs_video_3 > div.vjs-control-bar.vjs-focus-within > button.vjs-play-control.vjs-control.vjs-button.vjs-playing")WebElement PLAYING_ICON;
	@FindBy(css = "#vjs_video_3 > div.video__skip.video__skip--skippable")WebElement SKIP_ADVERT_ICON;

	/**
	 * Constructor
	 * 
	 * @param driver - WebDriver
	 * @author reggy
	 */
	public LandingPage(WebDriver driver) {
		try {
			PageFactory.initElements(driver, this);
			setWebDriver(driver);
		} catch (Exception ex) {
			Log.error("Error instantiating a new webdriver instance: " + ex.getMessage());
		}
	}

	/**
	 * Navigates to the LandingPage
	 * 
	 * @author reggy
	 */
	public void navigateToLandingPage() {
		String sUrl = TestProperties.getTestProperty("url");
		try {
			driver.get(sUrl);
			Log.info("Navigating to: " + sUrl);
		} catch (Exception ex) {
			Log.error("Could not navigate to: " + sUrl + "\n" + ex.getMessage());
		}
	}

	/**
	 * Navigates to specified URL
	 * @param strUrl
	 */
	public void navigateToUrl(String strUrl) {
		try {
			driver.navigate().to(strUrl);
			Log.info("Navigating to: " + strUrl);
		} catch (Exception ex) {
			Log.error("could not navigate to: " + strUrl);
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
	 * 
	 * @return - WebDriver instance
	 * @author reggy
	 */
	public WebDriver getWebDriver() {
		return LandingPage.driver;
	}

	/**
	 * Checks if I Accept Button is displayed
	 * @return True or False
	 * @author reggy
	 */
	public boolean isIAcceptButtonDisplayed() {
		return isElementDisplayed(ACCEPT_BUTTON, "I ACCEPT", TestProperties.MEDIUM_WAIT);
	}

	/**
	 * Checks if the All Sports Dropdown List is displayed
	 * @return True or False
	 * @author reggy
	 */
	public boolean isAllSportsDropDownListDisplayed() {
		return isElementDisplayed(SPORTS_DROPDOWN_LIST, "All Sports DropDwn List", TestProperties.MEDIUM_WAIT);
	}

	/**
	 * Checks if the shop Icon is displayed
	 * @return True or False
	 * @author reggy
	 */
	public boolean isShopIconDisplayed() {
		return isElementDisplayed(SHOP_ICON, "Shop Icon", TestProperties.MEDIUM_WAIT);
	}

	/**
	 * Clicks on the I Accept Button
	 * @author reggy
	 */
	public void clickIAcceptButton() {
		clickButton(ACCEPT_BUTTON, "I ACCEPT");
	}

	/**
	 * Clicks on link identified by text
	 * @param strText - The text of the link
	 * @author reggy
	 */
	public void clickOnLinkByText(String strText) {
		String strTemp = driver.findElement(By.tagName("body")).getText().toLowerCase();

		while (!strTemp.contains(strText.toLowerCase())) {
			sleepFor(TestProperties.MEDIUM_WAIT);
			strTemp = driver.findElement(By.tagName("body")).getText().toLowerCase();
			Log.info("waiting for link containing: " + strText);
		}
		clickLinkByText(driver, strText);
	}

	/**
	 * Clicks on the All Sports Dropdown List
	 */
	public void clickOnAllSportsDropDownList() {
		clickElement(SPORTS_DROPDOWN_LIST, "All Sports DropDown List");
	}

	/**
	 * Selects specified item from All Sports Drop Down List
	 * @param strItem - Item to be selected
	 * @return True or False
	 * @author reggy
	 */
	public boolean selectItemFromAllSportsDropDownList(String strItem) {
		clickOnAllSportsDropDownList();

		boolean bSelect = false;
		int index = 1;
		String sItem = "";
		while (bSelect == false) {
			try {
				String strCssSelector = "#dropdown-video-list-sport > ul:nth-child(3) > li:nth-child(" + index + ")";
				sItem = driver.findElement(By.cssSelector(strCssSelector)).getText().toLowerCase();
				if (sItem.equals(strItem.toLowerCase())) {
					bSelect = true;
					driver.findElement(By.cssSelector(strCssSelector)).click();
					Log.info(strItem + " is selected from AllSports Dropdown List");
				} else {
					Log.info(sItem + " is not the required item. Next...");
					index++;
				}
			} catch (Exception ex) {
				Log.info(sItem + " is not the required item. Next...");
				index++;
			}
		}
		return bSelect;
	}

	/**
	 * Clicks on Row 1 Column 1 of the videos
	 * @return WebElement
	 */
	public WebElement selectVideo1Row1() {
		return clickElement(VIDEO_ROW1_COLUMN1, "Video On Row1 Column1");
	}

	/**
	 * Gets the title of the current page
	 * @return
	 */
	public String getCurrentPageTitle() {
		String sTitle = "";
		try {
			sTitle = getPageTitle(driver);
			Log.info("The current page title is: " + sTitle);
		} catch (Exception e) {
			Log.info("Error retrieving page title...\n" + e.getMessage());
		}
		return sTitle;
	}

	/**
	 * Clicks on the Play Icon of the Video Player
	 */
	public void playVideo() {
		actOnVideo(driver, "play");
	}

	/**
	 * Clicks on the Pause Icon of the Video Player
	 */
	public void pauseVideo() {
		actOnVideo(driver, "pause");
	}

	/**
	 * Clicks on the FullScreen Icon
	 * 
	 * @author reggy
	 * @return True or False
	 */
	public static boolean HoverAndClickVideoFullScreen() {
		boolean bExists = false;
		String xPath = "//*[@id=\"vjs_video_3\"]/div[7]/button[3]";
		String xPath2 = "//*[@id=\"vjs_video_3\"]/div[7]";
		try {
			WebElement wElement1 = driver.findElement(By.xpath(xPath));
			WebElement wElement2 = driver.findElement(By.xpath(xPath2));
			Actions action = new Actions(driver);
			action.moveToElement(wElement2).click(wElement1).build().perform();
			bExists = true;
			Log.info("Was able to click the Maximise Icon");
		} catch (Exception ex) {
			Log.error("Couldnt click the Maximise Icon: \n" + ex.getMessage());
		}
		return bExists;
	}

	public static boolean HoverAndClickVideoPlayPause() {
		boolean bExists = false;
		String xPath = "//*[@id=\"vjs_video_3\"]/div[7]/button[1]";
		String xPath2 = "//*[@id=\"vjs_video_3\"]/div[7]";

		try {
			WebElement wElement1 = driver.findElement(By.xpath(xPath));
			WebElement wElement2 = driver.findElement(By.xpath(xPath2));
			Actions action = new Actions(driver);
			action.moveToElement(wElement2).click(wElement1).build().perform();
			bExists = true;
			Log.info("Was able to click the PlayPause Icon");
		} catch (Exception ex) {
			Log.error("Couldnt click the PlayPause Icon: \n" + ex.getMessage());
		}
		return bExists;
	}
	
	public void closeBrowser() {
		driver.quit();
	}
}
