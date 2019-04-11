//-----------------------------------------------------------------------------
// <copyright file="Link.java" company="Planit Testing">
//      Copyright © 2019 Planit Testing.
//      All rights reserved.
// </copyright>
// <created>26/03/2019</created>
// <author>Sam Chen</author>
//-----------------------------------------------------------------------------
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
