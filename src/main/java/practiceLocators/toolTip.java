package practiceLocators;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basePackage.baseClass;

public class toolTip extends baseClass{

	public toolTip() {
		PageFactory.initElements(driver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@FindBy(xpath="//iframe[@class='demo-frame']")
	WebElement frameLocater;
	
	@FindBy(id="age")
	WebElement agefield;
	
	public void tooltip1() {
		driver.switchTo().frame(frameLocater);
		js.executeScript("arguments[0].scrollIntoView()", agefield);
		String elm = agefield.getAttribute("title");
		System.out.println("Fetched title : "+elm);
		String Expected_Title = "We ask for your age only for statistical purposes.";
		Assert.assertEquals(Expected_Title, elm);
		System.out.println("we got correct titile");
	}
	
	public void toolTip2() {
		driver.switchTo().frame(frameLocater);
		js.executeScript("arguments[0].scrollIntoView()",agefield);
		Actions act = new Actions(driver);
		act.moveToElement(agefield).perform();
		String toolTipText = agefield.getText();
		System.out.println("Fetched title : "+toolTipText);
		String Expected_Title = "We ask for your age only for statistical purposes.";
		Assert.assertEquals(Expected_Title, toolTipText);
		System.out.println("we got correct titile");
	}
}
