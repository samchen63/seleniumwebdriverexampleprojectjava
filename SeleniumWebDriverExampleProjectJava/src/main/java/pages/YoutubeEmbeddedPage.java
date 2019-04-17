//-----------------------------------------------------------------------------
// <copyright file="YoutubeEmbeddedPage.java" company="Planit Testing">
//      Copyright © 2019 Planit Testing.
//      All rights reserved.
// </copyright>
// <created>17/04/2019</created>
// <author>Sam Chen</author>
//-----------------------------------------------------------------------------
package pages;

import elements.Link;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class YoutubeEmbeddedPage extends Page{
	
	private String IMAGE_PATH = Paths.get("src","main","resources","images").toString();
	private int SIKULI_TIMEOUT = 5000; // 5 secconds timeout for sikuli element
	
	private Link qualityAcceleratedLink;
	private Pattern playButtonPattern;
	private Pattern pauseButtonPattern;
	private Pattern muteButtonPattern;
	private Pattern unmuteButtonPattern;
	private Pattern settingButtonPattern;
	private Pattern qualityButtonPattern;
	private Pattern fourEightZeroButtonPattern;
	private Pattern fourEightZeroSelectedButtonPattern;
	private Screen screen;
	
	// What we do page which contains an embedded youtube video
	public YoutubeEmbeddedPage(WebDriver seleniumWebDriver) {
		super(seleniumWebDriver);
		qualityAcceleratedLink = new Link(By.cssSelector("a[class='service_second_menu-list_link js-service_second_menu-list_link'][href='#header2']"), seleniumWebDriver);
		screen = new Screen();
		playButtonPattern = new Pattern(IMAGE_PATH + "/play.png");
		pauseButtonPattern = new Pattern(IMAGE_PATH + "/pause.png"); 
		muteButtonPattern = new Pattern(IMAGE_PATH + "/mute.png");
		unmuteButtonPattern = new Pattern(IMAGE_PATH + "/unmute.png");
		settingButtonPattern = new Pattern(IMAGE_PATH + "/setting.png");
		qualityButtonPattern = new Pattern(IMAGE_PATH + "/quality.png");
		fourEightZeroButtonPattern = new Pattern(IMAGE_PATH + "/480p.png");
		fourEightZeroSelectedButtonPattern = new Pattern(IMAGE_PATH + "/480pselected.png");
	}

	public void clickQualityAcceleratedLinkToYoutubeEmbeddedSection() {
		// Wait quality accelerated link present before clicking it
		qualityAcceleratedLink.waitForElementPresent();
		qualityAcceleratedLink.click();
	}
	
	public void clickPlayButtonToPlayYoutubeVideo() throws FindFailed {
		// Wait for play button and click it
		screen.wait(playButtonPattern, SIKULI_TIMEOUT);
		screen.click(playButtonPattern);
	}
	
	public void clickPauseButtonToPauseYoutubeVideo() throws FindFailed {
		// Wait for pause button and click it
		screen.wait(pauseButtonPattern, SIKULI_TIMEOUT);
		screen.click(pauseButtonPattern);
	}
	
	public void clickMuteButtonToMuteYoutubeVideo() throws FindFailed {
		// Wait for mute button and click it
		screen.wait(muteButtonPattern, SIKULI_TIMEOUT);
		screen.click(muteButtonPattern);
	}
	
	public void verifyYoutubeVideoIsMuted() throws FindFailed {
		// Wait for unmute button appearing
		screen.wait(unmuteButtonPattern, SIKULI_TIMEOUT);
	}
	
	public void clickSettingButtonToShowSettingMenu() throws FindFailed {
		// Wait for setting button and click it
		screen.wait(settingButtonPattern, SIKULI_TIMEOUT);
		screen.click(settingButtonPattern);
	}
	
	public void clickQualityButtonToShowProgressiveScanList() throws FindFailed {
		// Wait for quality button and click it
		screen.wait(qualityButtonPattern, SIKULI_TIMEOUT);
		screen.click(qualityButtonPattern);
	}
	
	public void click480pButtonToSelect480ProgressiveScan() throws FindFailed {
		// Wait for 480p button and click it
		screen.wait(fourEightZeroButtonPattern, SIKULI_TIMEOUT);
		screen.click(fourEightZeroButtonPattern);
		// Allow mouse away from setting region
		screen.wait(muteButtonPattern, SIKULI_TIMEOUT);
		screen.hover(muteButtonPattern);
	}
	
	public void verify480pSelectedForQualityOfYoutubeVideo () throws FindFailed {
		// Verify 480p selected as quality
		screen.wait(fourEightZeroSelectedButtonPattern, SIKULI_TIMEOUT);
	}
}
