package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends Element {

	public Button(By identifier, WebDriver seleniumWebDriver) {
		super(identifier, seleniumWebDriver);
	}

	// Click the button
    public void click() {
        seleniumWebDriver.findElement(identifier).click();
    }
}
