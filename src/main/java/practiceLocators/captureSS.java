package practiceLocators;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.baseClass;

public class captureSS extends baseClass {

	public captureSS() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="logo-events")
	WebElement specifElm;
	
	@FindBy(xpath="//iframe")
	WebElement iframeLocate;
	
	@FindBy(xpath="//a[text()='Tooltips']")
	WebElement specificElm1;
	
	public void screenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("D:\\SeleniumPractice\\Selenium_Practice\\screenshot\\s1.png");
		FileUtils.copyFile(src, file);	
	}
	
	public void specificElementScreenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Src = specifElm.getScreenshotAs(OutputType.FILE);
		File file = new File("D:\\SeleniumPractice\\Selenium_Practice\\screenshot\\s2.png");
		FileUtils.copyFile(Src, file);
	}
	
	public void sepcificAreaSS() throws IOException {
		driver.switchTo().frame(iframeLocate);
		File src = specificElm1.getScreenshotAs(OutputType.FILE);
		File file = new File("D:\\SeleniumPractice\\Selenium_Practice\\screenshot\\s3.png");
		FileUtils.copyFile(src, file);
	}
}
