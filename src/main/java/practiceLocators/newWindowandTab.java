package practiceLocators;

import java.util.Set;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;

import basePackage.baseClass;

public class newWindowandTab extends baseClass {

	public newWindowandTab() {
		PageFactory.initElements(driver, this);
	}

	public void newWindowandWindowHandle() {
		driver.switchTo().newWindow(WindowType.WINDOW).navigate().to("https://www.facebook.com/");
		System.out.println("New Window Opened and Navigated to" + driver.getCurrentUrl());
	}
	
	public void newTabTest() {
		driver.switchTo().newWindow(WindowType.TAB).navigate().to("https://www.youtube.com");
		System.out.println("New Tab is opened : "+driver.getCurrentUrl());
		
	}
}
