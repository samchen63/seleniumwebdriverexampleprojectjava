package pages;

import org.openqa.selenium.WebDriver;

//Parent class for all page objects
public class Page {
	
	// Base url for the entire web site
    private String BASE_URL = "https://www.planittesting.com";
    
    public WebDriver seleniumWebDriver;
    
    public Page(WebDriver seleniumWebDriver) {
    	this.seleniumWebDriver = seleniumWebDriver;
    }
    
    // Navigate to Planit Testing Australian home page
    public HomePage goToHomePage() {
        seleniumWebDriver.navigate().to(BASE_URL + "/au/Home");
        return new HomePage(seleniumWebDriver);
    }
}
