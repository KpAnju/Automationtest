package ui.vc.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import vc.base.TestBase;
import ui.vc.pages.HomePage;
import ui.vc.pages.WeatherDataSearchPage;
import ui.vc.pages.WeatherHistoryPage;

public class WeatherDataSearchPageTest extends TestBase {
	WeatherDataSearchPage weatherDataSearchpage;
	WeatherHistoryPage weatherHistoryPage;
	HomePage homePage;

	public WeatherDataSearchPageTest() {
		super();
	}

	@BeforeMethod
	public void initialise() {

		setUp();
		homePage = new HomePage();
		weatherDataSearchpage = homePage.goToWeatherSearchPage();

	}

	@Test(priority = 1)
	public void verifyCorrectPageforSearch() {
		Assert.assertTrue(weatherDataSearchpage.verifyCorrectPage());

	}

	@Test(priority = 2)
	public void valideateNavigationToHistoryPage() {

		String city = prop.getProperty("city");

		if (!city.isEmpty()) {
			weatherHistoryPage = weatherDataSearchpage.searchCityWeather(prop.getProperty("city"));
		} else
			System.out.println("Please enter the location to proceed");
		
		
	}

	@AfterMethod

	public void closeMethod() {
		driver.quit();
	}

}
