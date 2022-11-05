package com.assesment.testvagrantPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {

	public WebDriver driver;

	public WikiPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Element and Flow for searching Country and ReleaseDat in wiki page
	
	@FindBy(how = How.ID,using="searchInput")
    public WebElement SearchInput;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"typeahead-suggestions\"]/div/a[1]")
    public WebElement SearchButton;
	
	@FindBy(how = How.XPATH,using="//*[contains(text(),'Release date')]//following::td[1]")
    public WebElement ReleaseDate;
	
	@FindBy(how = How.XPATH,using="//*[contains(text(),'Country')]//following::td[1]")
    public WebElement Country;
	
	
	public void enterMovieNameInSearchBox(String MovieName) {
		
		SearchInput.sendKeys(MovieName);
	}
	
	public void clickOnSearchButton() {
		SearchButton.click();
	}
	
	public String getReleaseDate() {
		String Releasedate = ReleaseDate.getText();
		return Releasedate;
	} 
	
	public String GetCountry() {
		return Country.getText();
	}
}
