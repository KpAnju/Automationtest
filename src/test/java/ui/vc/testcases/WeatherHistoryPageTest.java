package ui.vc.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import vc.base.TestBase;
import ui.vc.pages.HomePage;
import ui.vc.pages.WeatherDataSearchPage;
import ui.vc.pages.WeatherHistoryPage;

public class WeatherHistoryPageTest extends TestBase {

	HomePage homePage;
	WeatherDataSearchPage weatherDataSearchPage;
	WeatherHistoryPage weatherHistoryPage;

	public WeatherHistoryPageTest() {
		super();
	}

	@BeforeMethod
	public void initialise() {

		setUp();
		weatherHistoryPage = new WeatherHistoryPage();

		homePage = new HomePage();
		weatherDataSearchPage = homePage.goToWeatherSearchPage();
		weatherHistoryPage = weatherDataSearchPage.searchCityWeather(prop.getProperty("city"));
		
	}
	
	
	
	
	@Test(priority=1)
	  public void verifyCorrectPageforHistory() {
		Assert.assertEquals(weatherHistoryPage.validateCitySearched(),prop.getProperty("city"));
		String city = weatherHistoryPage.validateCitySearched();
		System.out.println("Weather results for "+city);
	
		 
	  }
	
	
	
	@Test(priority=2)
	  public void validateMinMaxTempPrecip() {
	      
		Assert.assertTrue(weatherHistoryPage.validateMinTemp());
		Assert.assertTrue(weatherHistoryPage.validateMaxTemp());
		Assert.assertTrue(weatherHistoryPage.validatePrecipitation());
		
	  }
	  
	  
	  
	  @AfterMethod
	  
	  public void closeMethod() {
		  driver.quit();
	  }
		
	

}
