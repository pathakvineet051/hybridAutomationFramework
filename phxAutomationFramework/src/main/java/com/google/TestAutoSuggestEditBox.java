package com.google;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAutoSuggestEditBox {

	public static void main(String[] args) {
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize(); // maximize the browser

		driver.get("https://www.google.com/");

		// wait till web page is loaded
		new WebDriverWait(driver, 3000).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));

		// Enter "Time in" text in Search edit box and wait for 30 seconds to load the
		// results
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);

		// get all the auto populated results - using xpath
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='erkvQe']//span//b"));

		System.out.println(elements.size());
		String timeResult = "";
		// Traverse each auto-suggest result and click on the result "time in india", if
		// this suggestion is displayed.
		for (WebElement element : elements) {

			System.out.println(element.getText());

			if (element.getText().equalsIgnoreCase(" interview questions")) {
				timeResult = element.getText();
				element.click();
				break;
			}

		}

		// Display the time after clicking the result

		System.out.println("Time is: " + timeResult);
		driver.close();

	}

}
