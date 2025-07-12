package practiceLOcatorTest;

import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.waits;

public class waitTest extends baseClass {

	public waitTest() {
		super();
	}
	
	waits waits;
	
	@Test
	public void testWaits() {
		this.waits = new waits();
		this.waits.fluentwait();
	}
}
