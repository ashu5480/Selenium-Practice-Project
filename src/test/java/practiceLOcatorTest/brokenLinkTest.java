package practiceLOcatorTest;

import java.io.IOException;

import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.brokenLink;

public class brokenLinkTest extends baseClass {

	public brokenLinkTest() {
		super();
	}
	
	brokenLink brokenlink;
	
	@Test
	public void brokenLinkTests() throws IOException {
		brokenlink = new brokenLink();
		brokenlink.brokenLinkTest();
		brokenlink.brokenLinkImage();
	}
}
