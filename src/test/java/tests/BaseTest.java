package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	private static Properties propData = new Properties();

	protected static WebDriver driver;

	protected String username;
	protected String password;
	protected String account;
	protected String url;

	/* Loading properties */
	protected void loadProps() throws IOException {
		InputStream reader = new FileInputStream("src/test/resources/prop.properties");
		propData.load(reader);
	}

	/* Init driver */
	public WebDriver initializeDriver() {

		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "/Users/nikola/Documents/Workspace/Selenium/chromedriver");
			driver = new ChromeDriver();
		}
		driver.get(url);
		return driver;
	}

	/* Get properties and initialize driver , setup implicit wait */
	@BeforeTest(alwaysRun = true)
	public void setupTesting() throws IOException {

		this.loadProps();

		username = propData.getProperty("username");
		password = propData.getProperty("password");
		account = propData.getProperty("account");
		url = propData.getProperty("url");

		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/* Tear Down */
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
