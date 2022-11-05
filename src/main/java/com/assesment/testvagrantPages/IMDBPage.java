package com.assesment.testvagrantPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IMDBPage {
	public WebDriver driver;

	public IMDBPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Element and Flow for searching Country and ReleaseDat in IMDB page
	
	@FindBy(how = How.ID,using="suggestion-search")
    public WebElement SearchInput;
	
	@FindBy(how = How.ID,using="react-autowhatever-1--item-0")
    public WebElement Search;
	
	@FindBy(how = How.XPATH,using="//*[contains(text(),'Release date')]//following::ul[1]")
    public WebElement ReleaseDate;
	
	@FindBy(how = How.XPATH,using="//*[contains(text(),'Country of origin')]//following::ul[1]")
    public WebElement Country;
	
	
	public void enterMovieName(String MovieName) {
		SearchInput.sendKeys(MovieName);
	}
	
	public void clickOnFirstSuggesstion() {
		Search.click();
	}
	
	public String getReleaseDate() {
		String releaseDate = ReleaseDate.getText();
		String [] Releasedate = releaseDate.split(" ");
		String Month = Releasedate[0];
		String Date = Releasedate[1].replace(",","");
		String Year = Releasedate[2];
		releaseDate = Date+" "+Month+" "+Year;
		return releaseDate;
	}
	
	public String getCountry() {
		return Country.getText();
	}
}
