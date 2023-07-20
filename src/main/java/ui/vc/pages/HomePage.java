package ui.vc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vc.base.TestBase;

public class HomePage extends TestBase{
	

   @FindBy(xpath = "//a[contains(text(),'Weather Data')]")
   WebElement weatherAPI;
   @FindBy(xpath = "//button[contains(text(),'Accept all cookies')]")
   WebElement cookieClose;
  
   
	
  public HomePage() {
		PageFactory.initElements(driver, this);
}
	

  
  public String validateTitleOfPage() {
	  return driver.getTitle();
  }
	
  public WeatherDataSearchPage goToWeatherSearchPage() {
	  cookieClose.click();
	  weatherAPI.click();
	  return new WeatherDataSearchPage();
  }
	
	
	

}
