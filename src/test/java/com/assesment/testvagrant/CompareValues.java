package com.assesment.testvagrant;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.assesment.testvagrantPages.IMDBPage;
import com.assesment.testvagrantPages.WikiPage;

public class CompareValues extends BaseTest {
	
	@Test
	public void Comparaision() {
		driver.get(prop.getProperty("Wikiurl"));
		WikiPage wikiPage = new WikiPage(driver); 
		wikiPage.enterMovieNameInSearchBox(prop.getProperty("MovieName"));
		wikiPage.clickOnSearchButton();
		String Releasedateonwiki = wikiPage.getReleaseDate();
		String CountryonWiki = wikiPage.GetCountry();
		driver.navigate().to(prop.getProperty("IMDBurl"));
		IMDBPage imdbPage = new IMDBPage(driver);
		imdbPage.enterMovieName(prop.getProperty("MovieName"));
		imdbPage.clickOnFirstSuggesstion();
		String ReleaseDateonIMDB = imdbPage.getReleaseDate();
		String CountryonIMDB = imdbPage.getCountry();
		Assert.assertEquals(Releasedateonwiki, ReleaseDateonIMDB,"Date Mismatched");
		Assert.assertEquals(CountryonWiki,CountryonIMDB,"Country Mismatched");
		
	}
	

}
