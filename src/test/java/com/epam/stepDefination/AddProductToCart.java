package com.epam.stepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.epam.driver.SetUpSelenium;
import com.epam.pages.HomePage;
import com.epam.pages.ProductDescriptionPage;
import com.epam.pages.ShoppingCartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddProductToCart {
	private static final String EBAY_URL = "http://www.ebay.com/";
	private String itemTitle = "";		
	private WebDriver driver;
	private HomePage objHomePage;
	private ProductDescriptionPage objProductDescriptionPage;
	private ShoppingCartPage objShoppingCartPage;
	
	@Given("^Firefox browser is open$")
	public void firefox_browser_is_open() throws Throwable {
	    SetUpSelenium.initializeDriver("chrome");
	    driver = SetUpSelenium.getDriver();
	}
	
	@Parameters({"url"})
	@Given("^Ebay HomePage is launched$")
	public void ebay_HomePage_is_launched() throws Throwable {
		 SetUpSelenium.goToUrl(EBAY_URL);
		 objHomePage = new HomePage(driver);
		 Assert.assertTrue(objHomePage.isHomePagePresent(), "Ebay HomePage is not launched");
	}
	
	@When("^we search for Iphone 6s Gold$")
	public void weSearchForIphone_6s_Gold() throws Throwable {
		objHomePage.searchForProduct("Iphone 6s Gold");
		objProductDescriptionPage = objHomePage.clickOnFirstProduct();
		objProductDescriptionPage.waitProductDescriptionPage(SetUpSelenium.IMAXTIME);
		
	}
	
	@When("^add it to the cart$")
	public void add_it_to_the_cart() throws Throwable {
		System.out.println(objProductDescriptionPage.getProductTilte());
		itemTitle = objProductDescriptionPage.getProductTilte();
		objShoppingCartPage=objProductDescriptionPage.addProductToCart();
		objShoppingCartPage.waitForShoppingCartPage(SetUpSelenium.IMAXTIME);
	    
	}

	@Then("^Iphone 6s should be avilable in the cart$")
	public void iphone_6s_ShouldBeAvilableInTheCart() throws Throwable {
		boolean blnStatus = objShoppingCartPage.isProductAddedToCart(itemTitle);
		Assert.assertTrue(blnStatus, "Item is not added to the cart");
		driver.quit();
		driver = null;
	}

	@Given("^\"(.*?)\" browser is open$")
	public void browserIsOpen(String arg1) throws Throwable {
		  SetUpSelenium.initializeDriver(arg1);
		    driver = SetUpSelenium.getDriver();
	}

	@When("^we search for \"(.*?)\"$")
	public void weSearchFor(String arg1) throws Throwable {
		objHomePage.searchForProduct(arg1);
		objProductDescriptionPage = objHomePage.clickOnFirstProduct();
		objProductDescriptionPage.waitProductDescriptionPage(SetUpSelenium.IMAXTIME);
	}

	@Then("^\"(.*?)\" should be avilable in the cart$")
	public void shouldBeAvilableInTheCart(String arg1) throws Throwable {
		boolean blnStatus = objShoppingCartPage.isProductAddedToCart(itemTitle);
		Assert.assertTrue(blnStatus, arg1+" is not added to the cart");
		driver.quit();
		driver = null;
	}


}
