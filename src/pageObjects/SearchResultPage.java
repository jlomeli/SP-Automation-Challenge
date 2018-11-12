package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Jesus Lomeli
 *
 */
public class SearchResultPage extends BasePage{
	/**
	 * Locate all elements on the Search Result Article Page
	 */
	@FindBy (id = "firstHeading")
	WebElement articleTitleField;
	
	@FindBy (id = "External_links")
	WebElement externalLinksSectionTitle;
	
	@FindBy (xpath = "//th[contains(text(),'Studio albums')]")
	WebElement studioAlbumsTableRow;
	
	@FindBy (xpath = "//*[@class='nowraplinks vcard hlist collapsible expanded navbox-inner mw-collapsible mw-made-collapsible']//tbody//tr[3]//td[1]//div[1]//ul[1]//child::li")
	List<WebElement> studioAlbumsList;
	
	@FindBy (xpath = "//*[@class='nowraplinks vcard hlist collapsible expanded navbox-inner mw-collapsible mw-made-collapsible']//a[@title='Reputation (Taylor Swift album)'][contains(text(),'Reputation')]")
	WebElement reputationStudioAlbumLink;
	
	/**
	 * Constructor for SearchResultPage class
	 * @param driver
	 */
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Method to retrieve current page title
	 * @param driver
	 * @return page title
	 */
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	/**
	 * Retrieve search result article main title
	 * @return article title
	 */
	public String getArticleTitle() {
		return actions.getElementText(articleTitleField);		
	}
	
	/**
	 * Retrieve External Links section title
	 * @return External Links section title
	 */
	public String getArticleSectionTitle() {
		return actions.getElementText(externalLinksSectionTitle);
	}
	
	/**
	 * Retrieve Studio Albums table row text
	 * @return  Studio Albums table row text
	 */
	public String getStudioAlbumRowText() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", studioAlbumsTableRow);
		
		return actions.getElementText(studioAlbumsTableRow);
	}
	
	/**
	 * Compares Studio Albums list with expected Studio Albums list
	 * @param expectedAlbumsList
	 * @return true if lists are equal
	 */
	public Boolean verifyStudioAlbumsList(List<String> expectedAlbumsList) {
		List<String> castAlbumsList = new ArrayList<String>(6);
		
		for(WebElement actualAlbum : studioAlbumsList) {
			castAlbumsList.add(actualAlbum.getText());			
		}
		
		if(castAlbumsList.equals(expectedAlbumsList)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retrieve "Reputation" album tooltip
	 * @return "Reputation" album tooltip text
	 */
	public String getStudioAlbumToolTip() {
		String toolTipText = "";
		
		toolTipText = actions.getElementTitle(reputationStudioAlbumLink);

		return toolTipText;
	}
	
	/**
	 * Verify if "Reputation" album Tooltip is displayed
	 * @return True if "Reputation" album Tooltip is displayed
	 */
	public Boolean isStudioAlbumToolTipDisplayed() {
		
		actions.hoverOverElement(reputationStudioAlbumLink, builder);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement toolTipElement = driver.findElement(By.xpath("//a[@class='mwe-popups-extract']//p"));
		return actions.isElementDisplayed(toolTipElement);
	}
}
