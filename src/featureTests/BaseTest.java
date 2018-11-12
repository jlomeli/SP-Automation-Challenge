package featureTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;

/**
 * 
 * @author Jesus Lomeli
 *
 */
public class BaseTest {
	protected static WebDriver driver;
	protected static String baseUrl;
	protected static HomePage homePage;
	protected static SearchResultPage searchResultPage;
	
	/**
	 * This class contains the setUp and tearDown methods for out Test Suite. 
	 * These methods are in change of initialize and setup the configuration needed to executed the test and to terminate it's execution
	 */
	@BeforeSuite
	public void setUp() {
		//Configure properties of the chrome browser driver, including location which need to be change to where the chromedriver is stored on the local environment
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		baseUrl = "https://en.wikipedia.org";
		  
		homePage = new HomePage(driver);
		searchResultPage = new SearchResultPage(driver);
		  
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();
	}
	
}
