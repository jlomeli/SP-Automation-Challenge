package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Jesus Lomeli
 *
 */
public class HomePage extends BasePage{
	/**
	 * Locate all elements on the Home Page
	 */
	@FindBy (id = "searchInput")
	WebElement searchInputField;
	
	@FindBy (id = "searchButton")
	WebElement searchButton;
	
	/**
	 * Constructor for HomePage class
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Enter search term on search box
	 * @param searchTerm
	 */
	public void enterSearchTerm(String searchTerm) {
		actions.enterText(searchInputField, searchTerm);
	}
	
	/**
	 * Click the search button
	 */
	public void clickSearchButton() {
		actions.clickToElement(searchButton);
	}
	
	/**
	 * Method to retrieve current page title
	 * @param driver
	 * @return page title
	 */
	public String getPageTittle(WebDriver driver) {
		return driver.getTitle();
	}
	
}
