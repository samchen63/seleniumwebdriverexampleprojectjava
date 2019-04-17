//-----------------------------------------------------------------------------
// <copyright file="YoutubeEmbededTest.java" company="Planit Testing">
//      Copyright © 2019 Planit Testing.
//      All rights reserved.
// </copyright>
// <created>17/04/2019</created>
// <author>Sam Chen</author>
//-----------------------------------------------------------------------------
package sikulitest;

import junittest.BaseTest;

import org.junit.jupiter.api.Test;
import org.sikuli.script.FindFailed;

import pages.HomePage;
import pages.YoutubeEmbeddedPage;

/*
 * To test functionality of embedded youtube on planit testing web site
 */
public class YoutubeEmbededTest extends BaseTest {

	/* 
     * Verify embedded youtube video can be muted
     */
	@Test
	public void verifyThatUserCanMuteYoutubeVideoOnYoutubeEmbeddedPage() throws FindFailed {
		// Open the home page
        HomePage homePage = page.goToHomePage();

        // Navigate to youtube embedded page
        YoutubeEmbeddedPage youtubeEmbeddedPage = homePage.clickWhatWeDoLinkAndGoToYoutubeEmbeddedPage();
        
        // Navigate to embeded youtube section
        youtubeEmbeddedPage.clickQualityAcceleratedLinkToYoutubeEmbeddedSection();
        
        // Play youtube video
        youtubeEmbeddedPage.clickPlayButtonToPlayYoutubeVideo();
        
        // Pause youtube video
        youtubeEmbeddedPage.clickPauseButtonToPauseYoutubeVideo();
        
        // Mute youtube video
        youtubeEmbeddedPage.clickMuteButtonToMuteYoutubeVideo();
        
        // Verify youtube video is muted
        youtubeEmbeddedPage.verifyYoutubeVideoIsMuted();
	}
	
	/* 
     * Verify user can change progressive scan setting
     */
	@Test
	public void verifyThatUserCanChangeProgressiveScanSettingOfYoutubeVideoOnYoutubeEmbeddedPage() throws FindFailed {
		// Open the home page
        HomePage homePage = page.goToHomePage();

        // Navigate to youtube embedded page
        YoutubeEmbeddedPage youtubeEmbeddedPage = homePage.clickWhatWeDoLinkAndGoToYoutubeEmbeddedPage();
        
        // Navigate to embeded youtube section
        youtubeEmbeddedPage.clickQualityAcceleratedLinkToYoutubeEmbeddedSection();
        
        // Play youtube video
        youtubeEmbeddedPage.clickPlayButtonToPlayYoutubeVideo();
        
        // Pause youtube video
        youtubeEmbeddedPage.clickPauseButtonToPauseYoutubeVideo();
        
        // Change progressive scan to 480
        youtubeEmbeddedPage.clickSettingButtonToShowSettingMenu();
        youtubeEmbeddedPage.clickQualityButtonToShowProgressiveScanList();
        youtubeEmbeddedPage.click480pButtonToSelect480ProgressiveScan();
        
        //Verify 480p is selected
        youtubeEmbeddedPage.clickSettingButtonToShowSettingMenu();
        youtubeEmbeddedPage.verify480pSelectedForQualityOfYoutubeVideo();
	}
}
