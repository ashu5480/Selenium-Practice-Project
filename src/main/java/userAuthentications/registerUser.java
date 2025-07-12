package userAuthentications;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePackage.baseClass;

public class registerUser extends baseClass {

	public registerUser() {
		PageFactory.initElements(driver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	
	@FindBy(xpath="//a[@title='Login']//span")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@title='Sign Up']//span[text()='Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//div[@class='I-qZ4M vLRlQb']//input")
	WebElement MobileNumber;
	
	@FindBy(xpath="//span[text()='CONTINUE']")
	WebElement ContinueBtn;
	
	@FindBy(xpath="//span[text()='Signup']")
	WebElement signupBtn1;
	
	@FindBy(xpath="//div[@class='eIDgeN']")
	WebElement otpValidationMsg;
	
	@FindBy(xpath="//span[text()='Please enter valid OTP']")
	WebElement validateOTP;
	
	public void signUpUser() {
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		Actions action = new Actions(driver);
		action.moveToElement(loginBtn).perform();
		
		wait.until(ExpectedConditions.visibilityOf(signUpBtn));
		js.executeScript("arguments[0].click()", signUpBtn);
		
		wait.until(ExpectedConditions.visibilityOf(MobileNumber));
		MobileNumber.sendKeys(prop.getProperty("MobileNumber"));
		
		ContinueBtn.click();
		wait.until(ExpectedConditions.visibilityOf(otpValidationMsg));
		
		String Expected_Message = "You are already registered. Please log in.";
		String Actual_Message = otpValidationMsg.getText();
		Assert.assertEquals(Expected_Message, Actual_Message);
		
		System.out.println("Otp is sent succesfully Please provide..");
		
		js.executeScript("arguments[0].click()", signupBtn1);
		boolean isVisible=false;
		try {
			wait.until(ExpectedConditions.visibilityOf(validateOTP));
			isVisible=true;
			if(isVisible==true) {
				String Actual_Message1=validateOTP.getText();
				String Expected_Message1="Please enter valid OTP";
				Assert.assertEquals(Expected_Message1, Actual_Message1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("User is registerd Succesfully..");
	}
}