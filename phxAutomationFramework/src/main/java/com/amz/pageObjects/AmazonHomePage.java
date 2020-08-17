package com.amz.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.utils.TestBase;

public class AmazonHomePage extends TestBase {

	WebDriver driver;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchField;

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchItem(String input) {

		ExplictWaitForElementotClickable(searchField, driver);
		searchField.sendKeys(input);
		searchField.sendKeys(Keys.ENTER);
	}
}
