package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.driver.SetUpSelenium;

public class ProductDescriptionPage extends BasePage {

	@FindBy(xpath="//a[normalize-space(text())='Add to cart']")
	private WebElement btnAddToCart;
	
	@FindBy(xpath="//a[normalize-space(text())='Buy It Now']")
	private WebElement btnBuyItNow;
	
	@FindBy(id="itemTitle")
	private WebElement ProductTitle;
	
	public ProductDescriptionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getProductTilte()
	{
		waitForElementVisible(ProductTitle, SetUpSelenium.IMAXTIME);
		return ProductTitle.getText().trim();
	}
	
	public ShoppingCartPage addProductToCart()
	{
		waitForElementVisible(btnAddToCart, SetUpSelenium.IMAXTIME);
		btnAddToCart.click();
		return (new ShoppingCartPage(driver));
	}
	
	public void waitProductDescriptionPage(int timeOut)
	{
		waitForElementVisible(btnAddToCart, timeOut);
	}

}
