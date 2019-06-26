package com.dc.stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import com.dc.pages.LandingPage;
import com.dc.utilities.BaseLine;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Fixtures extends BaseLine{
	
	LandingPage lp = new LandingPage(getDriver());
	
	@Given("^I am Eurosport Customer$")
	public void i_am_Eurosport_Customer() throws Throwable {
		
		lp.navigateToLandingPage();
		
		
		 
		if(lp.isIAcceptButtonDisplayed() == true) {
			lp.clickIAcceptButton();
			}
		}

	@Given("^On Videos Hub Page$")
	public void on_Videos_Hub_Page() throws Throwable {
		lp.isShopIconDisplayed();
		
		lp.navigateToUrl("https://video.eurosport.co.uk/");
		
		lp.clickOnLinkByText("News Videos");
		
		String sTitle = lp.getCurrentPageTitle();
		Assert.assertEquals("Video Eurosport UK",sTitle);
		}

	@When("^I select to watch the videos from Tennis Section$")
	public void i_select_to_watch_the_videos_from_Tennis_Section() throws Throwable {
	    lp.isAllSportsDropDownListDisplayed();
	    
	    lp.selectItemFromAllSportsDropDownList("Tennis");
	    
	    lp.selectVideo1Row1();
	    	    
	    //lp.playVideo();

		}

	@Then("^the selected video is playing$")
	public void the_selected_video_is_playing() throws Throwable {
		
	    
	    lp.playVideo();
	    System.out.println("");

		}

	@Then("^the following player controls are displayed$")
	public void the_following_player_controls_are_displayed(DataTable arg1) throws Throwable {
		boolean bPlay = false, bPause = false, bMaximise = false;
		
		//lp.clickVideoPlayerIcon("maximize");
		
		bPlay = lp.isPlayButtonDisplayed();
		bPause = lp.isPlayButtonDisplayed();
		bMaximise = lp.isMaximiseIconDisplayed();
		System.out.println("");
			
		//assertEquals(lp.isMaximiseIconDisplayed(),true);

		}


}
