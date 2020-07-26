package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	static WebDriver driver;

	public static WebDriver startBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zocdoc.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
	}

//	public static WebDriver goToListOfDentitsPage() {
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get(
//				"https://www.zocdoc.com/search?dr_specialty=98&reason_visit=12&address=Arlington%2C%20TX%2076018&offset=0&insurance_carrier=-1&insurance_plan=-1&filters=%7B%7D&search_query=Dentist&searchType=specialty&longitude=-97.0821162&latitude=32.6651539&city=Arlington&locationType=placemark&postalCode=76018&state=TX");
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		return driver;
//	}
}
