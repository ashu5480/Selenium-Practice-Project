package practiceLOcatorTest;

import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.MmtDatePicker;

public class MmtDatePickerTest extends baseClass{

	public MmtDatePickerTest() {
		super();
	}
	
	MmtDatePicker mmt;
	
	@Test
	public void selectDateTest() {
		mmt = new MmtDatePicker();
		mmt.selectDate1("9", "November", "2025");
	}
}
