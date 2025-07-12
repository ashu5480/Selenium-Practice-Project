package practiceLOcatorTest;

import java.io.IOException;
import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.seleniumFileReadWrite;

public class SeleniumFileReadWriteTest extends baseClass{

	public SeleniumFileReadWriteTest() {
		super();
	}
	
	seleniumFileReadWrite seleniumFileReadWrite;
	
	
	@Test
	public void writeExcel() throws IOException, InterruptedException {
		seleniumFileReadWrite = new seleniumFileReadWrite();
		String filePath="D:\\SeleniumPractice\\Selenium_Practice\\inputFiles\\excel1.xlsx";
		String sheetName = "sheet1";
		seleniumFileReadWrite.writeInExcel(filePath, sheetName);
	}
}
