package page;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AppointmentBookingPage extends BasePage {
	WebDriver driver;

	public AppointmentBookingPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Dentists Near Me')]")
	WebElement AppointmentBookingPageTitle;
	@FindBy(how = How.NAME, using = "patient-powered-search-input")
	WebElement PatientInputField;
	@FindBy(how = How.NAME, using = "location-picker-input")
	WebElement LocationInputField;
	@FindBy(how = How.XPATH, using = "//div[@class='sc-gqjmRU gpOMfP']/child::div")
	WebElement AutofillSearchElement;
	@FindBy(how = How.XPATH, using = "//input[@class='f9jwpk-1 fBBevw sc-13ns3b1-0 fbmdad']")
	WebElement InsuranceCarrierPlanField;
	@FindBy(how = How.XPATH, using = "//li[@class='kqqjkj-2 fsBdMa']")
	WebElement ChooseInsuranceLaterOption;
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement SearchForDoctorsButton;

	public void waitForPage() {
		waitForElement(AppointmentBookingPageTitle, driver);
	}

	public void enterPatientInformation() throws InterruptedException {
		String textToSelect = "dentist";
		PatientInputField.sendKeys("dentist");
		Thread.sleep(2000);
		List<WebElement> optionsToSelect = driver.findElements(By.xpath("//div[@class='sc-gqjmRU gpOMfP']/child::div"));
		for (WebElement options : optionsToSelect) {
			if (options.getText().equalsIgnoreCase(textToSelect)) {
				System.out.println("Trying to select" + textToSelect);
				options.click();
				break;
			}
		}

		LocationInputField.sendKeys("Arlington, TX 76018");
		driver.findElement(By.xpath("//div[@data-test='location-picker-option-0']")).submit();

//		Thread.sleep(3000);
//		InsuranceCarrierPlanField.click();
//		driver.findElement(By.xpath(
//				"//*[@id=\"header\"]/div/section/div[2]/div[4]/section/div/form/div[3]/div/div/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/span"))
//				.click();

//		WebElement insuranceCarrierField = driver
//				.findElement(By.xpath("//input[@class='f9jwpk-1 fBBevw sc-13ns3b1-0 fbmdad']"));
//		List<WebElement> insuranceOptionsList = insuranceCarrierField.findElements(By.tagName("li"));
//		for (WebElement li : insuranceOptionsList) {
//			if (li.getText().equalsIgnoreCase("I'll choose my insurance later")) {
//				li.click();
//				break;
//			}
//		}

		SearchForDoctorsButton.click();
	}

	public List<String> getListOf() {
		List<String> list = new ArrayList<String>();
		List<WebElement> columnDataElement = driver
				.findElements(By.xpath("//div[@data-test='profList']/descendant::h3[@itemprop='name']"));
		for (int i = 0; i < columnDataElement.size(); i++) {
			list.add(i, columnDataElement.get(i).getText());
		}
		return list;
	}

	public List<String> getNearestDentist() {
		List<String> list = new LinkedList<String>();
		List<WebElement> columnLocationElements = driver.findElements(By.xpath(
				"//div[@data-test='profList']/descendant::div[@data-test='doctor-card-info-location-distance']"));
		for (int i = 0; i < columnLocationElements.size(); i++) {
			list.add(i, columnLocationElements.get(i).getText());
		}
		return list;
	}

}
