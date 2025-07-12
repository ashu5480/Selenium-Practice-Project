package practiceLOcatorTest;

import java.awt.AWTException;

import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.fileUPload;

public class fileUPloadTest extends baseClass {

	public fileUPloadTest() {
		super();
	}
	
	fileUPload fileupload;
	
	
	public void fileUPload1() {
		String filPath = "C:\\Users\\ashutosh.singh\\OneDrive - AutomationEdge Pvt. Ltd\\Documents\\Selenium-Questions.txt";
		fileupload = new fileUPload();
		fileupload.fileupload(filPath);
	}
	
	@Test
	public void fileUPload2() throws AWTException {
		String filPath = "C:\\Users\\ashutosh.singh\\OneDrive - AutomationEdge Pvt. Ltd\\Documents\\Selenium-Questions.txt";
		fileupload = new fileUPload();
		fileupload.fileUPload1(filPath);
	}
}
