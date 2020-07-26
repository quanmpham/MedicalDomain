Feature: Check Availability
	As a user I want to check the availability dates 
	so that I can book my appointments

Scenario: Check availability for booking appointments
Given the Web Browser is on the Dentist dashboard page
When the user check for available dates
Then the website should show all the available dates for booking