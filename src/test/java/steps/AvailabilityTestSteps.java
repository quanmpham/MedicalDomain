package steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.AppointmentBookingPage;
import page.AvailabilityTestPage;
import page.SideNavigationPage;
import util.BrowserFactory;

public class AvailabilityTestSteps {
	WebDriver driver;
	AvailabilityTestPage availabilityTestPage;
	SideNavigationPage sideNavigationPage;
	AppointmentBookingPage appointmentBookingPage;

	@Before
	public void beforeRun() {
		driver = BrowserFactory.startBrowser();
		availabilityTestPage = PageFactory.initElements(driver, AvailabilityTestPage.class);
		sideNavigationPage = PageFactory.initElements(driver, SideNavigationPage.class);
		appointmentBookingPage = PageFactory.initElements(driver, AppointmentBookingPage.class);

	}

	@Given("^the Web Browser is on the Dentist dashboard page$")
	public void the_Web_Browser_is_on_the_Dentist_dashboard_page() throws Exception {
		sideNavigationPage.goToDentistPage();
		appointmentBookingPage.enterPatientInformation();
	}

	@When("^the user check for available dates$")
	public void the_user_check_for_available_dates() {
		availabilityTestPage.clickOnViewAvailabilityLink();

	}

	@Then("^the website should show all the available dates for booking$")
	public void the_website_should_show_all_the_available_dates_for_booking() {
		List<String> availableTimeSlots = availabilityTestPage.getColumnDataFor("Tomorrow, Jul 22");
		for (String times : availableTimeSlots) {
			System.out.println(times);
		}

	}

//	@After
//	public void afterRun() {
//		driver.close();
//		driver.quit();
//	}
}
