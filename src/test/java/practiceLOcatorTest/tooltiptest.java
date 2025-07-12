package practiceLOcatorTest;

import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.toolTip;

public class tooltiptest extends baseClass {

	public tooltiptest() {
		super();
	}
	
	toolTip toolTip;
	
	@Test
	public void tooTest() {
		this.toolTip = new toolTip();
		this.toolTip.toolTip2();
	}
}
