package ui.vc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vc.base.TestBase;

public class WeatherHistoryPage extends TestBase{
	
	
	
	 @FindBy(xpath = "//a[@id='locationDropdownMenuButton']")
	   WebElement weatherHistoryCaption;
	 
	 
	 @FindBy(xpath = "//div[contains(text(),'Max temp')]")
	   WebElement maxTemp;
	 
	 @FindBy(xpath = "//div[contains(text(),'Min temp')]")
	   WebElement minTemp;
	 
	 
	 @FindBy(xpath = "//div[contains(text(),'Total Precip')]")
	   WebElement totalPrecipitation;
	 
	 
	 
	 public WeatherHistoryPage() {
			PageFactory.initElements(driver, this);
		}
	 
	 public String validateCitySearched() {
		 return weatherHistoryCaption.getText();
		}
	 
	 
	 public boolean validateMaxTemp() {
		 return maxTemp.isDisplayed();
	 }
	 public boolean validateMinTemp() {
		 return minTemp.isDisplayed();
	 }
	 
	 public boolean validatePrecipitation() {
		 return totalPrecipitation.isDisplayed();
	 }
	 

}
