package practiceLocators;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePackage.baseClass;

public class fileUPload extends baseClass{

	public fileUPload() {
		PageFactory.initElements(driver, this);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	@FindBy(xpath="//div[starts-with(@class, 'Uploader')]//span[text()='Add files']")
	WebElement fileupload;
	
	@FindBy(xpath="//input[@value='Upload']")
	WebElement btn;
	
	@FindBy(xpath="//div[@class='wpcf7-response-output']")
	WebElement successMessage;
	
	public void fileupload(String pathFile) { 
		fileupload.sendKeys(pathFile);
		btn.click();
		String Expected_Message = "Thank you for your message. It has been sent.";
		String Actual_Message =  successMessage.getText();
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		Assert.assertEquals(Actual_Message, Expected_Message);
	}
	
	public void fileUPload1(String path) throws AWTException {
		fileupload.click();
		
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("File-UPloaded Succesfully");
	}
}
