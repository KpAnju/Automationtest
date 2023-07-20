package vc.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vc.util.Util;
import vc.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	@SuppressWarnings("deprecation")
	public static EventFiringWebDriver firingDriver;
	public static WebEventListener webEventListener;

	public TestBase() {
		try {
			prop = new Properties();
FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\vc\\config\\config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void setUp() {

		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}

		firingDriver = new EventFiringWebDriver(driver);

		webEventListener = new WebEventListener();
		firingDriver.register(webEventListener);
		driver = firingDriver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

}
