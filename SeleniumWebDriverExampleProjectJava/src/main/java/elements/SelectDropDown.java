//-----------------------------------------------------------------------------
// <copyright file="SelectDropDown.java" company="Planit Testing">
//      Copyright © 2019 Planit Testing.
//      All rights reserved.
// </copyright>
// <created>08/04/2019</created>
// <author>Sam Chen</author>
//-----------------------------------------------------------------------------
package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropDown extends Element {

	public SelectDropDown(By identifier, WebDriver seleniumWebDriver) {
		super(identifier, seleniumWebDriver);
	}

	// Select option by option's text
    public void selectByText(String text) {
        Select select = new Select(seleniumWebDriver.findElement(identifier));
        select.selectByVisibleText(text);
    }
    
    // Select option by option's position 
    public void selectByIndex(int index) {
    	Select select = new Select(seleniumWebDriver.findElement(identifier));
        select.selectByIndex(index);
    }
    
    // Retrieve value of selected text
    public String getSelectedOptionText() {
    	Select select = new Select(seleniumWebDriver.findElement(identifier));
        return select.getFirstSelectedOption().getText();
    }
    
    // Help method to wait for a combination of conditions (attribute value and option's text)
    public void waitForElementAttributeValueOrSpecificSelection(String attribute, String value, String text) {
    	WebDriverWait myWait = new WebDriverWait(seleniumWebDriver, TIMEOUT);
        myWait.until(ExpectedConditions.or(ExpectedConditions.attributeToBe(identifier, attribute, value),ExpectedConditions.textToBe(identifier, text)));
    }
    
    // Help method to wait for first option available
    public void waitForFirstOptionAvailable() {
    	WebDriverWait myWait = new WebDriverWait(seleniumWebDriver, TIMEOUT);
    	String id = seleniumWebDriver.findElement(identifier).getAttribute("id");
    	String childSelector = "#" + id + " > option:nth-child(2)";
    	myWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(childSelector)));
    }
}
