package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage {
	
	
	@FindBy(id="ptcBtnRight")
	private WebElement btnProceedToCheckOut;
	
	

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void waitForShoppingCartPage(int timeOut)
	{
		waitForElementVisible(btnProceedToCheckOut, timeOut);
	}
	
	public boolean isProductAddedToCart(String itemTitle)
	{
		return driver.findElement(By.partialLinkText(itemTitle)).isEnabled();
	}

}
