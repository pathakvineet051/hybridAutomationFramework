package commonLibs.utils;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.xml.fastinfoset.sax.Properties;

public class TestBase {

	protected static String CONFIG_PROP_PATH = "";

	public static WebDriver driver;
	public static Properties props;
	public static String sessionId;
	boolean strFlag;
	public WebDriverWait wait;
	public Actions action;
	private static String screenSize = new String("");
	Logger logger = Logger.getLogger(TestBase.class);

	public static final String USERNAME = System.getenv("SAUCELAB_USER_NAME");
	public static final String ACCESSKEY = System.getenv("SAUCELAB_API_KEY");
	public static final String URL = "http://" + USERNAME + ":" + ACCESSKEY + "@ondemand.saucelabs.com:0/wd/hub";
	public static final String BUILD = System.getenv("JENKINS_BUILD_NUMBER");

	public static String getCONFIG_PROP_PATH() {
		return CONFIG_PROP_PATH;
	}

	public static void setCONFIG_PROP_PATH(String CONFIG_PROP_PATH) {
		CONFIG_PROP_PATH = CONFIG_PROP_PATH;
	}

	public void takeScreenShot(WebDriver driver) {

	}

	public WebDriver startlocalWebDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.setExperimentalOption("userAutomationExtension", false);
		chromeoptions.addArguments("--disable-extensions");
		driver = new ChromeDriver(chromeoptions);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public WebDriver startJenkinsWebDriver(String tcid, String tname) throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "Windows 10");
		caps.setCapability("chromeDriverVersion", "Windows 10");
		caps.setCapability("commonTimeout", "Windows 10");
		caps.setCapability("idleTimeout", "Windows 10");

		caps.setCapability("build", BUILD);
		caps.setCapability("taname", tname);
		caps.setCapability("tcid", tcid);

		driver = new RemoteWebDriver(new java.net.URL(URL), caps);

		return driver;
	}

	// wait Method for Explict Wait

	public void ExplictWaitForElementotAvailable(WebElement ele, WebDriver driver) {

		wait = new WebDriverWait(driver, Long.parseLong(Variables.WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void ExplictWaitForElementotClickable(WebElement ele, WebDriver driver) {

		wait = new WebDriverWait(driver, Long.parseLong(Variables.WAIT_TIME));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

}
