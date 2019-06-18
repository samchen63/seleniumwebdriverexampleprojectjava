package elements;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Parent class for all element objects
public class Element {
	
	 protected int TIMEOUT = 30;

     public WebDriver seleniumWebDriver;
     public By identifier;
     
     public Element(By identifier, WebDriver seleniumWebDriver) {
    	 this.seleniumWebDriver = seleniumWebDriver;
    	 this.identifier = identifier;
     }
     
     // Help method to wait for element present on the page
     public void waitForElementPresent() {
    	 WebDriverWait wait = new WebDriverWait(seleniumWebDriver, TIMEOUT);
    	 wait.until(ExpectedConditions.presenceOfElementLocated(identifier));
     }
     
     // Help method to wait for attribute value of element on the page
     public void waitForElementAttributeValue(String attribute, String value) {
    	 WebDriverWait myWait = new WebDriverWait(seleniumWebDriver, TIMEOUT);
         myWait.until(ExpectedConditions.attributeToBe(identifier, attribute, value));
     }
     
     // Help method to get text of element on the page
     public String getText() {
         return seleniumWebDriver.findElement(identifier).getText();
     }
}
