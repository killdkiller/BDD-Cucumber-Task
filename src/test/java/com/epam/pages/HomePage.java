package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.driver.SetUpSelenium;

public class HomePage extends BasePage {
	private static final String TITLE = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
	private By lnkViewSearchResults = By.xpath("//a//*[contains(text(),'search results')]");
	
	@FindBy (id = "gh-ac")
	private WebElement txtSearchBox;
	
	@FindBy(xpath = "//input[@value='Search' and @type='submit']")
	private WebElement btnSearch;
	
	@FindBy(xpath = "(//*[@id='Results']//*[@id='ResultSetItems']//li[starts-with(@id,'item')])[1]//a")	
	private WebElement firstElement;
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public boolean isHomePagePresent()
	{
		return TITLE.equalsIgnoreCase(driver.getTitle().trim());
	}
	
	public void searchForProduct(String strProductName)
	{
		enterSearchDetails(strProductName);
		waitForElementVisible(btnSearch, SetUpSelenium.IMAXTIME);
		btnSearch.click();
		if(isElementPresent(lnkViewSearchResults))
		{
			driver.findElement(lnkViewSearchResults).click();;
		}
	}
	
	public void enterSearchDetails(String strProductName)
	{
		waitForElementVisible(txtSearchBox, SetUpSelenium.IMAXTIME);
		txtSearchBox.clear();
		txtSearchBox.sendKeys(strProductName);
	}
	public ProductDescriptionPage clickOnFirstProduct()
	{
		waitForElementEnabled(firstElement,  SetUpSelenium.IMAXTIME);
		scrollToElement(firstElement);
		firstElement.click();
		return (new ProductDescriptionPage(driver));
		
	}
}
