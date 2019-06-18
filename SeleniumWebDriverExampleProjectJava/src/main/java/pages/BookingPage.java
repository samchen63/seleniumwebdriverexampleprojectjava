package pages;

import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import elements.*;

//Booking course and service page
public class BookingPage extends Page {

	private Link addCourseLink;
    private SelectDropDown courseSelect;
    private SelectDropDown deliverySelect;
    private SelectDropDown startDateSelect;
    private Button addCourseButton;
    private Link bookedCourseTitleLink;
    private Label bookedLocationLabel;
    private Label bookedStartDateLabel;
    private Link removeCourseLink;
    private Label noItemAddedLabel;
    
	public BookingPage(WebDriver seleniumWebDriver) {
		super(seleniumWebDriver);
		addCourseLink = new Link(By.cssSelector("a[data-animation='fadeInUp'][data-open-form='.add-course']"), seleniumWebDriver);
        courseSelect = new SelectDropDown(By.id("p_lt_ctl03_pageplaceholder_p_lt_ctl01_pageplaceholder_p_lt_ctl04_CheckoutAddCourse_drpDwnCourse"), seleniumWebDriver);
        deliverySelect = new SelectDropDown(By.id("p_lt_ctl03_pageplaceholder_p_lt_ctl01_pageplaceholder_p_lt_ctl04_CheckoutAddCourse_drpDwnLocation"), seleniumWebDriver);
        startDateSelect = new SelectDropDown(By.id("p_lt_ctl03_pageplaceholder_p_lt_ctl01_pageplaceholder_p_lt_ctl04_CheckoutAddCourse_drpDwnDate"), seleniumWebDriver);
        addCourseButton = new Button(By.id("p_lt_ctl03_pageplaceholder_p_lt_ctl01_pageplaceholder_p_lt_ctl04_CheckoutAddCourse_btnAddCourse"), seleniumWebDriver);
        bookedCourseTitleLink = new Link(By.cssSelector("#p_lt_ctl03_pageplaceholder_p_lt_ctl01_pageplaceholder_p_lt_ctl03_wWPZ_wWPZ_zone_wSCC_pnlCartContent > ul > li > div > div.booking_course-list_text > h4 > a"), seleniumWebDriver);
        bookedLocationLabel = new Label(By.cssSelector("#p_lt_ctl03_pageplaceholder_p_lt_ctl01_pageplaceholder_p_lt_ctl03_wWPZ_wWPZ_zone_wSCC_shoppingCartUniView_ctl01_ctl00_chooseLoaction_divLocation > span.booking_changeable-item.no-width-limit"), seleniumWebDriver);
        bookedStartDateLabel = new Label(By.cssSelector("#p_lt_ctl03_pageplaceholder_p_lt_ctl01_pageplaceholder_p_lt_ctl03_wWPZ_wWPZ_zone_wSCC_shoppingCartUniView_ctl01_ctl00_chooseLoaction_divDates > div > span"), seleniumWebDriver);
        removeCourseLink = new Link(By.id("p_lt_ctl03_pageplaceholder_p_lt_ctl01_pageplaceholder_p_lt_ctl03_wWPZ_wWPZ_zone_wSCC_shoppingCartUniView_ctl01_ctl00_ctl00_btnRemove_hyperLink"), seleniumWebDriver);
        noItemAddedLabel = new Label(By.cssSelector("#MainSection > section > div > section > div > div.booking_top-msg.text-center.animated.fadeInUp.visible > h4"), seleniumWebDriver);
	}
	
	public void clickAddCourseLinkToPopupSelectionBar() {
        // Wait for add course link present before clicking it
        addCourseLink.waitForElementPresent();
        addCourseLink.click();
    }

	public void selectACourseByName(String courseName) {
        // Wait for course name drop down present before selecting an option
        courseSelect.waitForElementPresent();
        courseSelect.selectByText(courseName);
    }

    public void selectADeliveryLocationByName(String deliveryName) {
        // Wait for delivery location drop down enabled before selecting an option
    	deliverySelect.waitForElementPresent();
        deliverySelect.waitForElementAttributeValue("class", "custom-select");
        deliverySelect.waitForFirstOptionAvailable();
        deliverySelect.selectByText(deliveryName);
    }

    public void selectADeliveryLocationByIndex(int index) {
        // Wait for delivery location drop down enabled before selecting an option
    	deliverySelect.waitForElementPresent();
        deliverySelect.waitForElementAttributeValue("class", "custom-select");
        deliverySelect.waitForFirstOptionAvailable();
        deliverySelect.selectByIndex(index);
    }

    public void selectAStartDateByIndex(int index) {
        // Wait for start date drop down enabled or "Start Today" auto selected before selecting an option
    	startDateSelect.waitForElementPresent();
        startDateSelect.waitForElementAttributeValueOrSpecificSelection("class", "custom-select", "Start Today");
        // Select an option if "Start Today" is not auto selected
        if (!startDateSelect.getText().equals("Start Today"))
        {
        	startDateSelect.waitForFirstOptionAvailable();
            startDateSelect.selectByIndex(index);
        }
    }

    public String retrieveDynamicStartDateFromSelectedStartDateOption() {
        return startDateSelect.getSelectedOptionText();
    }

    public void clickAddCourseButtonToAddACourseIntoCart() {
        // Wait for add course link present before clicking it
        addCourseButton.waitForElementPresent();
        addCourseButton.click();
    }

    public void verifyBookedCourseTitle(String title) {
        // Wait for booked course title present before getting text from it
        bookedCourseTitleLink.waitForElementPresent();
        Assertions.assertEquals(title, bookedCourseTitleLink.getText());
    }

    public void verifyBookedLocationValue(String location) {
        // Wait for booked location label present before getting text from it
        bookedLocationLabel.waitForElementPresent();
        Assertions.assertEquals(location, bookedLocationLabel.getText());
    }

    public void verifyBookedStartDateValue(String startDate) {
        // Wait for booked start date label present before getting text from it
        bookedStartDateLabel.waitForElementPresent();
        Assertions.assertEquals(startDate, bookedStartDateLabel.getText());
    }

    public void clickRemoveCourseLinkToDeleteAddedCourse() {
        // Wait for remove course link present before clicking it
        removeCourseLink.waitForElementPresent();
        removeCourseLink.click();
    }

    public void verifyNoCourseToBeAddedIntoCart() {
        // If no item label appears, it means that all courses are removed
        noItemAddedLabel.waitForElementPresent();
    }
}
