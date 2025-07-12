package practiceLOcatorTest;
import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.windowsTable;

public class windowsTableTest extends baseClass{

	public windowsTableTest() {
		super();
	}
	
	windowsTable wintable;
	
	@Test
	public void winTable() {
		wintable = new windowsTable();
		//String countryName="Zambia";
		//wintable.findCurrency(countryName);
		//wintable.findcapitals(countryName);
		wintable.dynamicTable2("Nifty Bank");
	}
}
