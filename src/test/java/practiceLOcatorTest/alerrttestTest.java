package practiceLOcatorTest;

import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.alertTest;

public class alerrttestTest extends baseClass {

	public alerrttestTest() {
		super();
	}
	
	alertTest alertTest;
	
	@Test
	public void alertTesting() throws InterruptedException {
		alertTest = new alertTest();
		alertTest.alertBoxTest();
	}
}
