package com.dc.stepdefinitions;

import java.util.List;

import org.testng.Assert;

import com.dc.pages.LandingPage;
import com.dc.utilities.BaseLine;
import com.dc.utilities.TestProperties;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Fixtures extends BaseLine{
	
	LandingPage lp = new LandingPage(getDriver());
	
	@Given("^I am Eurosport Customer$")
	public void i_am_Eurosport_Customer() throws Throwable {
		setTestName(getMethodName(2), executionStartTime());
		
		lp.navigateToLandingPage();
		
		if(lp.isIAcceptButtonDisplayed() == true) {
			lp.clickIAcceptButton();
			}
		}

	@Given("^On Videos Hub Page$")
	public void on_Videos_Hub_Page() throws Throwable {
		setTestName(getMethodName(2), executionStartTime());
		
		lp.isShopIconDisplayed();
		
		lp.navigateToUrl("https://video.eurosport.co.uk/");
		
		lp.sleepFor(TestProperties.LONG_WAIT);
		
		lp.clickOnLinkByText("News Videos");
		
		String sTitle = lp.getCurrentPageTitle();
		Assert.assertEquals("Video Eurosport UK",sTitle);
		}

	@When("^I select to watch the videos from Tennis Section$")
	public void i_select_to_watch_the_videos_from_Tennis_Section() throws Throwable {
		setTestName(getMethodName(2), executionStartTime());
		
	    lp.isAllSportsDropDownListDisplayed();
	    
	    lp.selectItemFromAllSportsDropDownList("Tennis");//Bug: The dropdown doesnt filter tennis videos from other categories
	    
	    lp.navigateToUrl("https://video.eurosport.co.uk/tennis");//Workround for now
	    
	    lp.selectVideo1Row1();

		}

	@Then("^the selected video is playing$")
	public void the_selected_video_is_playing() throws Throwable {
		setTestName(getMethodName(2), executionStartTime());
	    
		lp.pauseVideo();
		}

	@Then("^the following player controls are displayed$")
	public void the_following_player_controls_are_displayed(DataTable data) throws Throwable {
		setTestName(getMethodName(2), executionStartTime());

		List<List<String>> list = data.raw();
		
		for(int x=0;x < list.size(); x++) {
			boolean bCheck = false;
			String strCheck = list.get(x).get(0);
			
			switch(strCheck.toLowerCase()) {
			case "play":
				bCheck = LandingPage.HoverAndClickVideoPlayPause();
				lp.sleepFor(TestProperties.MEDIUM_WAIT);
				break;
			case "pause":
				bCheck = LandingPage.HoverAndClickVideoPlayPause();
				lp.sleepFor(TestProperties.MEDIUM_WAIT);
				break;
			case "maximize":
				bCheck = LandingPage.HoverAndClickVideoFullScreen();
				lp.sleepFor(TestProperties.MEDIUM_WAIT);
				break;
				}
			Assert.assertEquals(bCheck, true);
			}
		lp.closeBrowser();
		}


}
