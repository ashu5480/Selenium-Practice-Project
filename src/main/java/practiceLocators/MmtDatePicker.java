package practiceLocators;

import java.time.Duration;
import java.time.Month;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.baseClass;

public class MmtDatePicker extends baseClass {

	public MmtDatePicker() {
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//div[@class='imageSlideContainer']")
	WebElement sliderDom;

	@FindBy(xpath = "//span[@data-cy='closeModal']")
	WebElement closeModal;

	@FindBy(xpath = "//label[@for='departure']")
	WebElement departureButton;

	@FindBy(xpath = "//span[starts-with(@class,'selectedDateField ')]//span[1]")
	WebElement actualDate;

	@FindBy(xpath = "//span[starts-with(@class,'selectedDateField ')]//span[2]")
	WebElement actualMonth;

	@FindBy(xpath = "//span[starts-with(@class,'selectedDateField ')]//span[3]")
	WebElement actualYear;

	@FindBy(xpath = "//div[@class='DayPicker-Month'][1]//div[@role='columnheader']")
	WebElement calanderColumn;

	@FindBy(xpath = "//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']")
	WebElement calanderRow;

	@FindBy(xpath = "//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Body']//div[@class='DayPicker-Week'][2]//div[starts-with(@class,'DayPicker-Day')][1]")
	WebElement dateFinderLocater;

	@FindBy(xpath = "//div[@class='DayPicker-NavBar']//span[1]")
	WebElement previousBtn;

	@FindBy(xpath = "//div[@class='DayPicker-NavBar']//span[2]")
	WebElement nextBtn;

	@FindBy(xpath = "//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Caption']")
	WebElement monthYear;

	public void selectDate1(String givenDate, String givenMonth, String givenYear) {
		if (sliderDom.isDisplayed()) {
			wait.until(ExpectedConditions.visibilityOf(closeModal));
			js.executeScript("arguments[0].click()", closeModal);
		}
		js.executeScript("arguments[0].click()", departureButton);
		List<WebElement> calanderColumn = driver
				.findElements(By.xpath("//div[@class='DayPicker-Month'][1]//div[@role='columnheader']"));
		List<WebElement> calanderRow = driver.findElements(By.xpath(
				"//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']"));
		int calanderColumnCount = calanderColumn.size();
		int calanderRowCount = calanderRow.size();

		String currentMonthYear = monthYear.getText();
		String cMonth = currentMonthYear.split(" ")[0];
		String cYear = currentMonthYear.split(" ")[1];
		System.out.println("Current Month : " + cMonth + " and Current year is " + cYear);

		int monthValue = Month.valueOf(cMonth.toUpperCase()).getValue();
		int givenMonthValue = Month.valueOf(givenMonth.toUpperCase()).getValue();

		if (cMonth.equals(givenMonth) && cYear.equals(givenYear)) {
			for (int i = 1; i < calanderRowCount; i++) {
				for (int j = 1; j < calanderColumnCount; j++) {
					WebElement elm = driver.findElement(By.xpath(
							"//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']["
									+ i + "]//div[starts-with(@class,'DayPicker-Day')][" + j + "]"));
					String actualDate = elm.getText();
					System.out.println(actualDate);
					if (actualDate.equals(givenDate)) {
						elm.click();
						break;
					}
				}
			}
			System.out.println("Cllicked on date which is " + actualDate);
		} else if (monthValue < givenMonthValue) {
			while (!(monthValue == givenMonthValue)) {
				nextBtn.click();
				monthValue = Month.valueOf(cMonth.toUpperCase()).getValue();
			}
			for (int i = 1; i < calanderRowCount; i++) {
				for (int j = 1; j < calanderColumnCount; j++) {
					WebElement elm = driver.findElement(By.xpath(
							"//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']["
									+ i + "]//div[starts-with(@class,'DayPicker-Day')][" + j + "]"));
					String actualDate = elm.getText();
					System.out.println(actualDate);
					if (actualDate.equals(givenDate)) {
						elm.click();
						break;
					}
				}
			}
		}
	}

}
