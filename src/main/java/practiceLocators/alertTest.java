package practiceLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.baseClass;

public class alertTest extends baseClass{

	public alertTest() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement alert1;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement alert2;
	
	@FindBy(xpath="//button[@class='btn btn-info']")
	WebElement alert3;
	
	@FindBy(xpath="//a[@href='#CancelTab']")
	WebElement alertwithOK;
	
	@FindBy(xpath="//a[@href='#Textbox']")
	WebElement alertWithConfirm;
	
	public void alertBoxTest() throws InterruptedException {
		/*
		 * alert1.click(); driver.switchTo().alert().accept();
		 * System.out.println("simple alert tested"); alertwithOK.click();
		 * alert2.click(); driver.switchTo().alert().accept();
		 * System.out.println("confirmation Alert : "+"OK"); alert2.click();
		 * System.out.println("confirmation Alert : "+"CANCEL"); Thread.sleep(2000);
		 */
		alertWithConfirm.click();
		alert3.click();
		driver.switchTo().alert().sendKeys("Ashu Singh");
		driver.switchTo().alert().accept();
	    System.out.println("Alert is testted Confirmaation and entered value");
	}
}
