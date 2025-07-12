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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.baseClass;

public class datePicker extends baseClass {

	public datePicker() {
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//*[@id='post-2661']/div[2]/div/div/div[1]/p/iframe")
	WebElement frameNavigate;

	@FindBy(xpath = "//input[@id='datepicker']")
	WebElement datePickerTest;

	@FindBy(id = "ui-datepicker-div")
	WebElement datePickerRec;

	@FindBy(xpath = "//a[@title='Prev']")
	WebElement previousBtn;

	@FindBy(xpath = "//a[@title='Next']")
	WebElement nextBtn;

	@FindBy(xpath = "//span[@class='ui-datepicker-month']")
	WebElement month;

	@FindBy(xpath = "//span[@class='ui-datepicker-year']")
	WebElement year;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']")
	WebElement datesTable;

	@FindBy(xpath = "//table[starts-with(@class,'ui-date')]//thead//tr//th")
	WebElement calanderColumn;

	@FindBy(xpath = "//table[starts-with(@class,'ui-date')]//tr")
	WebElement calanderRow;
	
	@FindBy(id="DropDown DatePicker")
	WebElement drpDownDatePicker;
	
	@FindBy(xpath="//div[@id='ui-datepicker-div']")
	WebElement datePickerTab;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement monthDropDown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement yearDropdown;
	
	
	public void selectDateDropDown(String givenDate, String givenMonth, String givenYear) {
		drpDownDatePicker.click();
		driver.switchTo().frame(frameNavigate);
		System.out.println("Switched to IFrame");
		//wait.until(ExpectedConditions.elementToBeClickable(datePickerTest));
		datePickerTest.click();
		/*
		 * System.out.println("Clicked on date picker");
		 * 
		 * wait.until(ExpectedConditions.visibilityOf(datePickerTab));
		 * 
		 * Select selMonth = new Select(monthDropDown);
		 * selMonth.selectByValue(givenMonth); Select selYear = new
		 * Select(yearDropdown); selYear.selectByVisibleText(givenYear);
		 * 
		 * List<WebElement> rowSize =
		 * driver.findElements(By.xpath("//table[starts-with(@class,'ui-date')]//tr"));
		 * int rowCount = rowSize.size();
		 * 
		 * List<WebElement> columnSize = driver.findElements(By.xpath(
		 * "//table[starts-with(@class,'ui-date')]//thead//tr//th")); int columnCount =
		 * columnSize.size();
		 * 
		 * for(int i=1; i<rowCount; i++) { for(int j=1; j<columnCount; j++) { WebElement
		 * web =
		 * driver.findElement(By.xpath("//table[starts-with(@class,'ui-date')]//tr["+i+
		 * "]//td["+j+"]")); String dateValue = web.getText();
		 * if(dateValue.equals(givenDate)) { js.executeScript("arguments[0].click()",
		 * web); } break; } }
		 */
	}

	public void selectDate(String date, String month, String years) {
		wait.until(ExpectedConditions.visibilityOf(frameNavigate));
		driver.switchTo().frame(frameNavigate);
		System.out.println("Switched to Frame");
		datePickerTest.click();

		String currentYear = year.getText();
		String currentMonth = this.month.getText();

		List<WebElement> rowCount = driver.findElements(By.xpath("//table[starts-with(@class,'ui-date')]//tr"));
		int rowSize = rowCount.size();
		List<WebElement> columnCount = driver
				.findElements(By.xpath("//table[starts-with(@class,'ui-date')]//thead//tr//th"));
		int columnSize = columnCount.size();
		
		System.out.println("Current-Year is :"+currentYear);
		System.out.println("Current Month is :"+currentMonth);
		if(currentYear.equals(years) && currentMonth.equals(month)) {
			for(int i=1; i<rowSize; i++) {
				for(int j=1; j<columnSize; j++) {
					WebElement elm = driver.findElement(By.xpath("//table[starts-with(@class,'ui-date')]//tr["+i+"]//td["+j+"]"));
					String elm_actual=elm.getText();
					if(elm_actual.equals(date)) {
						elm.click();
						System.out.println("selected date : "+elm_actual+"Data and year: "+currentMonth+" "+currentYear);
						break;
					}
				}
			}
		}else if(Integer.parseInt(currentYear) > Integer.parseInt(years)) {
			while(!currentYear.equals(years)) {
				previousBtn.click();
				currentYear = 	year.getText();
			}
			System.out.println("Choosen Desired Year"+currentYear);
			int monthValue = Month.valueOf(currentMonth.toUpperCase()).getValue();
			int expectedMonthValue = Month.valueOf(month.toUpperCase()).getValue();
			System.out.println("Current Month Value is : "+monthValue+"  "+"Expected Month Values is : "+expectedMonthValue);
			System.out.println("month value is : "+monthValue);
			if(monthValue==expectedMonthValue) {
				for(int i=1; i<rowSize; i++) {
					for(int j=1; j<columnSize; j++) {
						WebElement elm = driver.findElement(By.xpath("//table[starts-with(@class,'ui-date')]//tr["+i+"]//td["+j+"]"));
						String elm_actual=elm.getText();
						if(elm_actual.equals(date)) {
							elm.click();
							System.out.println("selected date : "+elm_actual+"Data and year: "+monthValue+" "+currentYear);
							break;
						}
					}
				}
			}
			else if(monthValue>expectedMonthValue) {
				while(!(monthValue==expectedMonthValue)) {
					previousBtn.click();
					String monthV = this.month.getText();
					monthValue = Month.valueOf(monthV.toUpperCase()).getValue();
				}
				System.out.println("Choosen Desired Month which is : "+monthValue);
				for(int i=1; i<rowSize; i++) {
					for(int j=1; j<columnSize; j++) {
						WebElement elm = driver.findElement(By.xpath("//table[starts-with(@class,'ui-date')]//tr["+i+"]//td["+j+"]"));
						String elm_actual=elm.getText();
						if(elm_actual.equals(date)) {
							elm.click();
							System.out.println("selected date : "+elm_actual+"Data and year: "+monthValue+" "+currentYear);
							break;
						}
					}
				}
			}
		}
	}
}
