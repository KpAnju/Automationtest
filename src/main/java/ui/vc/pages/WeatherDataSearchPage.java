package ui.vc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vc.base.TestBase;

public class WeatherDataSearchPage extends TestBase {

	@FindBy(xpath = "//input[@id='wxlocation']")
	WebElement location;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchCity;

	@FindBy(xpath = "//span[contains(text(),'Total Weather Data')]")
	WebElement pageCaption;

	public WeatherDataSearchPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyCorrectPage() {
		return pageCaption.isDisplayed();
	}

	public WeatherHistoryPage searchCityWeather(String city) {

		location.sendKeys(city);
		searchCity.click();

		return new WeatherHistoryPage();

	}

}
