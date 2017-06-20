package com.epam.driver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SetUpSelenium {
	
	private static WebDriver driver ;
	public static final int IMINTIME = 10;
	public static final int IMAXTIME = 50;
	public static final int IMIDTIME = 20;
	
	public static void initializeDriver(String browserName)
	{
		switch(Browser.valueOf(browserName.toUpperCase()))
		{
		   case FIREFOX:
			   System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
		   case CHROME:
			   System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
		   case IE:
			   System.setProperty("webdriver.ie.driver", "resources\\IEDriverServer32Bit.exe");
				driver = new InternetExplorerDriver();
				break;
			default:
				System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
				
		}
			
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static void tearUp()
	{
		if(driver!=null)
		{
			driver.close();
			driver.quit();
			driver = null;
		}
		
	}
	
	public static void goToUrl(String url)
	{
		driver.manage().timeouts().pageLoadTimeout(IMAXTIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMINTIME, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}
	public enum Browser{
		FIREFOX,CHROME,IE
	}

}
