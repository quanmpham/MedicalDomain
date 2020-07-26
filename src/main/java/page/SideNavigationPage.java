package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SideNavigationPage {
	WebDriver driver;

	public SideNavigationPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='sc-13g8ros-4 itXloS']")
	WebElement DentistPage;

	public void goToDentistPage() {
		DentistPage.click();
	}

	public void goToListOfDentistsAvailablePage() {
		driver.get(
				"https://www.zocdoc.com/search?dr_specialty=98&reason_visit=12&address=Arlington%2C%20TX%2076018&offset=0&insurance_carrier=-1&insurance_plan=-1&filters=%7B%7D&search_query=Dentist&searchType=specialty&longitude=-97.0821162&latitude=32.6651539&city=Arlington&locationType=placemark&postalCode=76018&state=TX");

	}
}
