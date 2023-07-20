package ui.vc.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import vc.base.TestBase;
import ui.vc.pages.HomePage;
import ui.vc.pages.WeatherDataSearchPage;

public class HomePageTest extends TestBase{
  HomePage homePage;
  WeatherDataSearchPage weatherSearchPage;
  
  public HomePageTest() {
	  super();
  }
	
	
  @BeforeMethod
  public void initialise() {
	  
	  setUp();
      homePage = new HomePage();
	
  }
  
  
  @Test(priority=1)
  public void validateHomePageTitle()
  {
	  String title = homePage.validateTitleOfPage();
	  Assert.assertEquals(title, "Weather Data & Weather API | Visual Crossing","Home Page title incorrect");
  }
   
  @Test(priority=2)
  public void weatherAPIClickTest() {
      
	  weatherSearchPage =  homePage.goToWeatherSearchPage();
  }
  
  
  
  @AfterMethod
  
  public void closeMethod() {
	  driver.quit();
  }
	
}
