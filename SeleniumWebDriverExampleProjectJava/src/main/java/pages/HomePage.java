package pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;

import elements.Link;

//Planit Testing Australian home page
public class HomePage extends Page{

	private Link bookingLink;
	private Link whatWeDoLink;
	
	public HomePage(WebDriver seleniumWebDriver) {
		super(seleniumWebDriver);
		 bookingLink = new Link(By.id("cartAnchorId"), seleniumWebDriver);
		 whatWeDoLink = new Link(By.id("p_lt_ctl02_MegaMenu_whatWeDoLink"), seleniumWebDriver);
	}

	public BookingPage clickCartLinkAndGoToBookingPage() {
        // Wait for booking link present before clicking it
        bookingLink.waitForElementPresent();
        bookingLink.click();
        return new BookingPage(seleniumWebDriver);
    }
	
	public YoutubeEmbeddedPage clickWhatWeDoLinkAndGoToYoutubeEmbeddedPage() {
		// Wait for what we do link present before clicking it
		whatWeDoLink.waitForElementPresent();
		whatWeDoLink.click();
		return new YoutubeEmbeddedPage(seleniumWebDriver);
	}
}
