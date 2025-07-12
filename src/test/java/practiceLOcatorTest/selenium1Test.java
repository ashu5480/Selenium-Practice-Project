package practiceLOcatorTest;

import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.selenium1;

public class selenium1Test extends baseClass{

	public selenium1Test() {
		super();
	}
	
	selenium1 sel1;
	
	
	public void allActiontest() {
		sel1 = new selenium1();
		sel1.allActions();
	}
	
	public void selectDropDown() {
		sel1=new selenium1();
		sel1.Dropdown();
	}
	
	@Test
	public void linkPartialTest() {
		sel1=new selenium1();
		sel1.linkPartialLinkTest();
	}
}
