package userAuthentications;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePackage.baseClass;

public class loginUser extends baseClass {

	public loginUser() {
		PageFactory.initElements(driver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	@FindBy(xpath="//a[@title='Login']//span")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='I-qZ4M vLRlQb']//input")
	WebElement MobileNumber;
	
	@FindBy(xpath="//button[text()='Request OTP']")
	WebElement requestOtpBtn;
	
	@FindBy(xpath="//div[@class='XDRRi5']")
	WebElement OtpField;
	
	@FindBy(xpath="//div[@class='eIDgeN']")
	WebElement otpValidationMsg;
	
	@FindBy(xpath="//button[text()='Verify']")
	WebElement verifyOTP;
	
	@FindBy(xpath="//div[@class='eIDgeN']")
	WebElement otpValidation;
	
	public void login() {
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		js.executeScript("arguments[0].click()", loginBtn);
		MobileNumber.sendKeys(prop.getProperty("MobileNumber"));
		requestOtpBtn.click();
		wait.until(ExpectedConditions.visibilityOf(otpValidationMsg));
		
		String Expected_Message = "Verification code sent to "+prop.getProperty("MobileNumber");
		String Actual_Message = otpValidationMsg.getText();
		Assert.assertEquals(Expected_Message, Actual_Message);
		verifyOTP.click();
		boolean isVisible=false;
		try {
			wait.until(ExpectedConditions.visibilityOf(otpValidation));
			isVisible=true;
			if(isVisible==true) {
				String getMessage = otpValidation.getText();
				Assert.assertEquals(getMessage, "OTP is incorrect", "Please Provide Correct OTP..");	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
