package practiceLOcatorTest;

import java.io.IOException;

import org.testng.annotations.Test;

import basePackage.baseClass;

public class captureSSTest extends baseClass{

	public captureSSTest() {
		super();
	}
	
	practiceLocators.captureSS capSs;
	
	@Test
	public void captureSS() throws IOException {
		capSs = new practiceLocators.captureSS();
		//capSs.screenshot();
		//capSs.specificElementScreenshot();
		capSs.sepcificAreaSS();
	}
}
