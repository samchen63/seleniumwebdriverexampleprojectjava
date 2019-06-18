package cucumbertest.stepdefinition;

import cucumber.api.java.en.Given;	

import pages.Page;
import pages.HomePage;

public class HomePageStepDefinition extends SeleniumWebDriverContainer{
	
	public SeleniumWebDriverContainer seleniumWebDriverContainer;
	public Page page;
	public HomePage homePage;

    public HomePageStepDefinition(SeleniumWebDriverContainer seleniumWebDriverContainer) {
    	this.seleniumWebDriverContainer = seleniumWebDriverContainer;
    	page = new Page(seleniumWebDriverContainer.seleniumWebDriver);
    	homePage = new HomePage(seleniumWebDriverContainer.seleniumWebDriver);
    }
    
    // Navigate to home page
    @Given("^I have navigated to home page$")
    public void givenIHaveNavigatedToHomePage() {	
        page.goToHomePage();
    }

    // Click cart link and navigate to booking page
    @Given("^I click cart link and go to booking page$")
    public void givenIClickCartLinkAndGoToBookingPage() {
        homePage.clickCartLinkAndGoToBookingPage();
    }
}
