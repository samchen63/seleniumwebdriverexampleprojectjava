package junittest;

import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Page;

// Parent class for all test objects
public class BaseTest {
	
	protected WebDriver seleniumWebDriver;
    protected Page page;

    // Create selenium web driver instance and launch browser
    @BeforeEach
    public void setUp() {
        // Use Chrome as testing browser
    	System.setProperty("webdriver.chrome.driver", Paths.get("src","test","resources").toString() + "/chromedriver.exe");
    	seleniumWebDriver = new ChromeDriver();

        // Maximize browser after launching it
        seleniumWebDriver.manage().window().fullscreen();

        // Create the page object
        page = new Page(seleniumWebDriver);
    }
    
    // Release selenium web driver instance and kill the process
    @AfterEach
    public void tearDown() {
    	seleniumWebDriver.close();
    	seleniumWebDriver.quit();
    }
}
