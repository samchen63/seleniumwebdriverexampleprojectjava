//-----------------------------------------------------------------------------
// <copyright file="SeleniumWebDriverContainer.java" company="Planit Testing">
//      Copyright © 2019 Planit Testing.
//      All rights reserved.
// </copyright>
// <created>10/04/2019</created>
// <author>Sam Chen</author>
//-----------------------------------------------------------------------------
package cucumbertest.stepdefinition;

import org.openqa.selenium.WebDriver;

// PicoContainer which contains selenium WebDriver and is shared between all step definition files.
public class SeleniumWebDriverContainer {
	public WebDriver seleniumWebDriver;
}
