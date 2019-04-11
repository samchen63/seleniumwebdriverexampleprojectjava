//-----------------------------------------------------------------------------
// <copyright file="BookingPageStepDefinition.java" company="Planit Testing">
//      Copyright © 2019 Planit Testing.
//      All rights reserved.
// </copyright>
// <created>10/04/2019</created>
// <author>Sam Chen</author>
//-----------------------------------------------------------------------------
package cucumbertest.stepdefinition;

import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;

import pages.BookingPage;

public class BookingPageStepDefinition extends SeleniumWebDriverContainer {
	
	public SeleniumWebDriverContainer seleniumWebDriverContainer;
	public BookingPage bookingPage;
    public String selectedStartDateValue;

	public BookingPageStepDefinition(SeleniumWebDriverContainer seleniumWebDriverContainer) {
        this.seleniumWebDriverContainer = seleniumWebDriverContainer;
        bookingPage = new BookingPage(seleniumWebDriverContainer.seleniumWebDriver);
    }
    
    // Click add course link
    @When("^I click add course link on booking page$")
    public void whenIClickAddCourseLinkOnBookingPage() {
        bookingPage.clickAddCourseLinkToPopupSelectionBar();
    }

    // Select a course from drop down by course name
    @When("^I select a course \"([^\"]*)\" on booking page$")
    public void whenISelectACourseOnBookingPage(String coursename) {
        bookingPage.selectACourseByName(coursename);
    }

    // Select a course from drop down, course name is from example table
    @When("^I select a course \"([^\"]*)\" from example on booking page$")
    public void whenISelectACourseFromExampleOnBookingPage(String coursename) {
        bookingPage.selectACourseByName(coursename);
    }

    // Select a delivery location from drop down by location name
    @When("^I select a delivery location \"([^\"]*)\" on booking page$")
    public void whenISelectADeliveryLocationOnBookingPage(String location) {
        bookingPage.selectADeliveryLocationByName(location);
    }

    // Select a delivery location from drop down by position of option
    @When("^I select option (\\d+) in delivery location on booking page$")
    public void whenISelectOptionInDeliveryLocationOnBookingPage(int index) {
        bookingPage.selectADeliveryLocationByIndex(index);
    }

    // Select a start date from drop down by position of option
    // And save selected value of start date for further use
    @When("^I select option (\\d+) in start date on booking page$")
    public void whenISelectOptionInStartDateOnBookingPage(int index) {
        bookingPage.selectAStartDateByIndex(index);
        selectedStartDateValue = bookingPage.retrieveDynamicStartDateFromSelectedStartDateOption();
    }

    // Click add course button
    @When("^I click add course button on booking page$")
    public void whenIClickAddCourseButtonOnBookingPage() {
        bookingPage.clickAddCourseButtonToAddACourseIntoCart();
    }

    // Verify title of booked course after adding a course
    @Then("^the booked course title should be \"([^\"]*)\" on booking page$")
    public void thenTheBookedCourseTitleShouldBeOnBookingPage(String courseName) {
        bookingPage.verifyBookedCourseTitle(courseName);
    }

    // Verify title of booked course after adding a course, course name is from example table
    @Then("^the booked course title should be \"([^\"]*)\" from example on booking page$")
    public void thenTheBookedCourseTitleShouldBeFromExampleOnBookingPage(String courseName) {
        bookingPage.verifyBookedCourseTitle(courseName);
    }

    // Verify delivery location after adding a course
    @Then("^the booked delivery location should be \"([^\"]*)\" on booking page$")
    public void thenTheBookedDeliveryLocationShouldBeOnBookingPage(String location) {
        bookingPage.verifyBookedLocationValue(location);
    }

    // Verify selected start date by using pre-saved start date
    @Then("^the booked start date should be first option on booking page$")
    public void thenTheBookedStartDateShouldBeFirstOptionOnBookingPage() {
        bookingPage.verifyBookedStartDateValue(selectedStartDateValue);
    }

    // Click remove course link
    @When("^I click remove course link on booking page$")
    public void whenIClickRemoveCourseLinkOnBookingPage() {
        bookingPage.clickRemoveCourseLinkToDeleteAddedCourse();
    }

    // Verify no added course appearing on booking page
    @Then("^no course should be added on booking page$")
    public void thenNoCourseShouldBeAddedOnBookingPage() {
        bookingPage.verifyNoCourseToBeAddedIntoCart();
    }
}
