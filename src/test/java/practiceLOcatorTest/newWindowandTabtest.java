package practiceLOcatorTest;

import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.newWindowandTab;

public class newWindowandTabtest extends baseClass {

	public newWindowandTabtest(){
		super();
	}
	
	newWindowandTab newWindowandTab;
	
	@Test
	public void newWindowsTabTest() {
		this.newWindowandTab = new newWindowandTab();
		//this.newWindowandTab.newWindowandWindowHandle();
		this.newWindowandTab.newTabTest();
	}
}
