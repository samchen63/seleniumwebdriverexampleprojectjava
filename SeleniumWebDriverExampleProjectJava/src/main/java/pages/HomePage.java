//-----------------------------------------------------------------------------
// <copyright file="HomePage.java" company="Planit Testing">
//      Copyright © 2019 Planit Testing.
//      All rights reserved.
// </copyright>
// <created>08/04/2019</created>
// <author>Sam Chen</author>
//-----------------------------------------------------------------------------
package pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;

import elements.Link;

//Planit Testing Australian home page
public class HomePage extends Page{

	private Link bookingLink;
	
	public HomePage(WebDriver seleniumWebDriver) {
		super(seleniumWebDriver);
		 this.bookingLink = new Link(By.id("cartAnchorId"), seleniumWebDriver);
	}

	public BookingPage clickCartLinkAndGoToBookingPage() {
        // Wait for booking link present before clicking it
        bookingLink.waitForElementPresent();
        bookingLink.click();
        return new BookingPage(seleniumWebDriver);
    }
}
