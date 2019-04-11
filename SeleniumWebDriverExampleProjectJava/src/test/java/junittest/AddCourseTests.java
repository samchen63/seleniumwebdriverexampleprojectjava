//-----------------------------------------------------------------------------
// <copyright file="AddCourseTests.java" company="Planit Testing">
//      Copyright © 2019 Planit Testing.
//      All rights reserved.
// </copyright>
// <created>09/04/2019</created>
// <author>Sam Chen</author>
//-----------------------------------------------------------------------------
package junittest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import pages.BookingPage;
import pages.HomePage;

/*
 * To test functionality of adding courses from Planit Testing web site
 */
public class AddCourseTests extends BaseTest {
	
	/* 
     * This is a scenario based test case to verify course details after adding a course on booking page 
     * by entering course name, delivery location and start date.
     */
	@Test
	public void verifyThatACourseCanBeAddedIntoCartOnBookingPage() {
        String courseName = "ISTQB Foundation Certificate";
        String location = "Sydney";

        // Open the home page
        HomePage homePage = page.goToHomePage();

        // Navigate to booking page
        BookingPage bookingPage = homePage.clickCartLinkAndGoToBookingPage();

        // Add a course by entering specific course name, delivery location and first start date
        bookingPage.clickAddCourseLinkToPopupSelectionBar();
        bookingPage.selectACourseByName(courseName);
        bookingPage.selectADeliveryLocationByName(location);
        bookingPage.selectAStartDateByIndex(1);

        // Save selected first available start date
        String selectedStartDateValue = bookingPage.retrieveDynamicStartDateFromSelectedStartDateOption();

        // Verify details of that booked course
        bookingPage.clickAddCourseButtonToAddACourseIntoCart();
        bookingPage.verifyBookedCourseTitle(courseName);
        bookingPage.verifyBookedLocationValue(location);
        bookingPage.verifyBookedStartDateValue(selectedStartDateValue);
    }
	
	/*
     * This is a data driven test case to verify that all available courses can be added on booking page
     * A CSV file contains all available course names which are retrieved during test
     */
    @Test
    public void verifyAllAvailableCoursesFromCourseListCanBeAdded() {
        // Open the home page
        HomePage homePage = page.goToHomePage();

        // Navigate to booking page
        BookingPage bookingPage = homePage.clickCartLinkAndGoToBookingPage();

        // Read course name from a CSV file
        Path pathToFile = Paths.get("src","test","resources", "CourseList.csv");
        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {

        	String courseName;
        	// Keep reading course name until the BufferedReader reaches the end of file
        	while ((courseName = br.readLine()) != null)
        	{
        		// Add a course by course name from CSV file and verify course name, then delete it and repeat the cycle
        		bookingPage.clickAddCourseLinkToPopupSelectionBar();
        		bookingPage.selectACourseByName(courseName);
        		bookingPage.selectADeliveryLocationByIndex(1);
        		bookingPage.selectAStartDateByIndex(1);
        		bookingPage.clickAddCourseButtonToAddACourseIntoCart();
        		bookingPage.verifyBookedCourseTitle(courseName);
        		bookingPage.clickRemoveCourseLinkToDeleteAddedCourse();
        		bookingPage.verifyNoCourseToBeAddedIntoCart();
        	}
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
