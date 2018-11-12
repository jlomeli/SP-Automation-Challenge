package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import utils.PageActions;

/**
 * 
 * @author Jesus Lomeli
 *
 */
public class BasePage {
	public WebDriver driver;
	public PageActions actions;
	public Actions builder;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		//Initialize WebElements on each page
		PageFactory.initElements(driver, this);
		actions = new PageActions();
		builder = new Actions(driver);
	}
}
