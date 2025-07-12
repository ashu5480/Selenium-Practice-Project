package practiceLOcatorTest;

import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.datePicker;

public class datePickerTest extends baseClass{

	public datePickerTest() {
		super();
	}
	
	datePicker datePicker;
	
	@Test
	public void datePickers() {
		datePicker = new datePicker();
		//datePicker.selectDate("28", "June", "2020");
		datePicker.selectDateDropDown("28","July","2025");
	}
}
