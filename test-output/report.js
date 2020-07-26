$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/java/features/availability_test.feature");
formatter.feature({
  "line": 1,
  "name": "Check Availability",
  "description": "As a user I want to check the availability dates \r\nso that I can book my appointments",
  "id": "check-availability",
  "keyword": "Feature"
});
formatter.before({
  "duration": 9474735600,
  "status": "passed"
});
formatter.before({
  "duration": 6711690800,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Check availability for booking appointments",
  "description": "",
  "id": "check-availability;check-availability-for-booking-appointments",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "the Web Browser is on the Dentist dashboard page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user check for available dates",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the website should show all the available dates for booking",
  "keyword": "Then "
});
formatter.match({
  "location": "AvailabilityTestSteps.the_Web_Browser_is_on_the_Dentist_dashboard_page()"
});
formatter.result({
  "duration": 15463690700,
  "status": "passed"
});
formatter.match({
  "location": "AvailabilityTestSteps.the_user_check_for_available_dates()"
});
formatter.result({
  "duration": 2082994800,
  "status": "passed"
});
formatter.match({
  "location": "AvailabilityTestSteps.the_website_should_show_all_the_available_dates_for_booking()"
});
formatter.result({
  "duration": 21206840300,
  "status": "passed"
});
formatter.after({
  "duration": 4965134100,
  "status": "passed"
});
});