package cucumbertest.stepdefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebDriverHook extends SeleniumWebDriverContainer {
	
	public SeleniumWebDriverContainer seleniumWebDriverContainer;
	public WebDriver seleniumWebDriver;
    
    // Constructor
    public SeleniumWebDriverHook(SeleniumWebDriverContainer seleniumWebDriverContainer) {
    	this.seleniumWebDriverContainer = seleniumWebDriverContainer;
    }
    
    // Create selenium web driver instance and launch browser for each test case
    @Before
    public void beforeScenario() {
    	// Use Chrome as testing browser
    	System.setProperty("webdriver.chrome.driver", Paths.get("src","test","resources").toString() + "/chromedriver.exe");
    	seleniumWebDriver = new ChromeDriver();
    	
    	// Maximize browser after launching it
        seleniumWebDriver.manage().window().fullscreen(); 
        
        // Assign object to selenium web driver container for dependency injection
        seleniumWebDriverContainer.seleniumWebDriver = seleniumWebDriver;
    } 
 
    // Release selenium web driver instance and kill the process
    @After
    public void afterScenario() {
    	seleniumWebDriver.close();
    	seleniumWebDriver.quit();
    }
}
