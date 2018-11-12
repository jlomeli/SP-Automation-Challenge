package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 * @author Jesus Lomeli
 * 
 * The purpose of this class is to provide a set of easy to read and easy to use actions to each WebElement 
 *
 */
public class PageActions {

	public void clickToElement(WebElement element) {
		element.click();
	}
	
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	public void hoverOverElement(WebElement element, Actions builder) {
		
		Action hoverOverAlbum = builder.moveToElement(element)
					.build();
		
		hoverOverAlbum.perform();
	}
	
	public Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public String getElementTitle(WebElement element) {
		return element.getAttribute("title");
	}
}
