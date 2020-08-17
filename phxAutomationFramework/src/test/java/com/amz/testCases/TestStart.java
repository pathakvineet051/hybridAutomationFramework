package com.amz.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amz.uiValidation.RunAmazonSearch;

public class TestStart {
	WebDriver driver;
	public static String jenkins_execution;

	@BeforeSuite
	@Parameters({ "datasheetName" })
	public static void dataSheet(String dataSheet) {
		System.setProperty("EXCELSHEET", dataSheet);
	}

	@BeforeTest
	public void check() {
		try {
			jenkins_execution = System.getProperty("jenkins_execution");
		} catch (Exception e) {
			jenkins_execution = "N";
			e.printStackTrace();
		}
	}

	@Test
	public void amazonSearch() {
		try {
			Reporter.log("Amazon Search");
			RunAmazonSearch azn = new RunAmazonSearch();
			azn.searchItemsinAmazon();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
