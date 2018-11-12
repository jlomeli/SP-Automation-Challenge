package featureTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

/**
 * 
 * @author Jesus Lomeli
 *
 */
public class Tests extends BaseTest{
	/**
	 * Verify Wikipedia home page is displayed correctly
	 */
	@Test(priority = 0)
	public void verifyHomePage() {
		String expectedPageTitle = "Wikipedia, the free encyclopedia";
		
		//Verify Home Page is displayed correctly
		assertEquals(homePage.getPageTittle(driver), expectedPageTitle);
	}
	
	/**
	 * Enters "Taylor Swift" search term and correct article is displayed
	 */
	@Test(priority = 1)
	public void searchArticle() {
		String expectedArticleTitle = "Taylor Swift";
		
		//Enter search term and click the search button 
		homePage.enterSearchTerm("Taylor Swift");
		homePage.clickSearchButton();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Verify Taylor Swift article is displayed correctly
		assertEquals(searchResultPage.getArticleTitle(), expectedArticleTitle);
	}
	
	/**
	 * Verify "Studio album" section contains ‘Taylor Swift’, ‘Fearless’, ‘Speak Now’,‘Red’, ’1989’, ‘Reputation’ albums
	 */
	@Test(priority = 2)
	public void verifyArticleSection() {
		List<String> expectedAlbums = new ArrayList<String>(6);
		
		//Add Studio Albums to List to compare with WebElement
		expectedAlbums.add("Taylor Swift");
		expectedAlbums.add("Fearless");
		expectedAlbums.add("Speak Now");
		expectedAlbums.add("Red");
		expectedAlbums.add("1989");
		expectedAlbums.add("Reputation");
		
		//Verify "Studio albums" row is displayed
		assertEquals(searchResultPage.getStudioAlbumRowText(), "Studio albums");
		
		//Verify content from "Studio Albums" row matches
		assertTrue(searchResultPage.verifyStudioAlbumsList(expectedAlbums));
	}
	
	/**
	 * Verify Tooltip for "Reputation" album is displayed when hover over link
	 */
	@Test(priority = 3)
	public void verifyStudioAlbumToolTip() {
		String expectedToolTip = "Reputation (Taylor Swift album)";
		
		//Verify "Reputation" Tooltip text is correct
		assertEquals(searchResultPage.getStudioAlbumToolTip(), expectedToolTip);
		
		//Verify "Reputation Tooltip is displayed
		assertTrue(searchResultPage.isStudioAlbumToolTipDisplayed());
	}

}
