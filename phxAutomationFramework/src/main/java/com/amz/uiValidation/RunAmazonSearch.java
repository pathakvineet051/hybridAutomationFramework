package com.amz.uiValidation;

import org.openqa.selenium.WebDriver;

import com.amz.pageObjects.AmazonHomePage;

import commonLibs.utils.TestBase;
import commonLibs.utils.Variables;

public class RunAmazonSearch extends TestBase {
	WebDriver driver;
	public void searchItemsinAmazon() {
		try {
			if (Variables.driverExecution.equalsIgnoreCase("Jenkins")) {
				driver = startJenkinsWebDriver(Variables.tcid, Variables.tname);

			} else {
				driver = startlocalWebDriver();

			}

			AmazonHomePage az = new AmazonHomePage(driver);

			driver.get(Variables.url);
			// az.searchItem("Watch");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
