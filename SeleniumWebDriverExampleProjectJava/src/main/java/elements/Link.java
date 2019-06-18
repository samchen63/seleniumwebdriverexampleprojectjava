package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Link extends Element {

	public Link(By identifier, WebDriver seleniumWebDriver) {
		super(identifier, seleniumWebDriver);
	}

	// Click the link
    public void click() {
        seleniumWebDriver.findElement(identifier).click();
    }
}
