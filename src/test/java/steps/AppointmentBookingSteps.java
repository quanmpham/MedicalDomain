package steps;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.AppointmentBookingPage;
import page.DashboardPage;
import page.SideNavigationPage;
import util.BrowserFactory;

public class AppointmentBookingSteps extends TestBase {
	WebDriver driver;
	AppointmentBookingPage appointmentBookingPage;
	SideNavigationPage sideNavigationPage;
	DashboardPage dashboardPage;
	Random rnd = new Random();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Before
	public void beforeRun() {
		driver = BrowserFactory.startBrowser();
		appointmentBookingPage = PageFactory.initElements(driver, AppointmentBookingPage.class);
		sideNavigationPage = PageFactory.initElements(driver, SideNavigationPage.class);
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	}

	@Given("^a web browser is at the Zodoc home page$")
	public void a_web_browser_is_at_the_Zodoc_home_page() {
		dashboardPage.waitForPage();
	}

	@When("^the user selects Dentist page$")
	public void the_user_selects_Dentist_page() {
		sideNavigationPage.goToDentistPage();
	}

	@Then("^the booking information page for available dentists should appear$")
	public void the_booking_information_page_for_available_dentists_should_appear() throws Exception {
		screenShot(driver, "c:\\ScreenShotFile\\DentistPage.jpg");
		appointmentBookingPage.waitForPage();
	}

	@Given("^the web browser is on the Booking Dentist information page$")
	public void the_web_browser_is_on_the_Booking_Dentist_information_page() {
		sideNavigationPage.goToDentistPage();

	}

	@When("^the user enters personal information into the Booking Top Dentists Near me$")
	public void the_user_enters_personal_information_into_the_Booking_Top_Dentists_Near_me()
			throws InterruptedException {
		appointmentBookingPage.enterPatientInformation();
	}

	@Then("^a list of dentists near me should appear$")
	public void a_list_of_dentists_near_me_should_appear() throws Exception {
		List<String> listOfDentists = appointmentBookingPage.getListOf();
		for (String names : listOfDentists) {
			System.out.println(names);
		}

		List<String> listOfNearestDentists = appointmentBookingPage.getNearestDentist();
		for (String locations : listOfNearestDentists) {
			System.out.println(locations);
		}
	}

	@After
	public void afterRun() {
		driver.close();
		driver.quit();
	}

}
