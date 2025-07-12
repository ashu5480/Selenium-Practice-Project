package practiceLOcatorTest;

import org.testng.annotations.Test;

import basePackage.baseClass;
import practiceLocators.mouseActions;

public class mouseActiontest extends baseClass {

	public mouseActiontest() {
		super();
	}
	
	mouseActions mouActions;
	
	@Test
	public void mouseActiontests() {
		mouActions = new mouseActions();
		mouActions.dragDrop();
		mouActions.mouseHower();
		mouActions.doubliClick();
		mouActions.rightClick();
	}
}
