//-----------------------------------------------------------------------------
// <copyright file="Label.java" company="Planit Testing">
//      Copyright © 2019 Planit Testing.
//      All rights reserved.
// </copyright>
// <created>08/04/2019</created>
// <author>Sam Chen</author>
//-----------------------------------------------------------------------------
package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Label extends Element {

	public Label(By identifier, WebDriver seleniumWebDriver) {
		super(identifier, seleniumWebDriver);
	}
}
