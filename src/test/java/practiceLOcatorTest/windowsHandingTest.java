package practiceLOcatorTest;

import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.windowsHandling;

public class windowsHandingTest extends baseClass{

	public windowsHandingTest() {
		super();
	}
	
	windowsHandling win;
	
	
	/*
	 * public void windtest() { win = new windowsHandling(); String
	 * email="singhashu772@gmail.com"; String pwd = "Ashu@1997";
	 * win.windowHandleTest(email, pwd); }
	 */
	
	@Test
	public void naukriLogin() {
		win = new windowsHandling();
		win.naukriLogin("singhashu772@gmail.com", "Ashu@1997");
	}
	
}
