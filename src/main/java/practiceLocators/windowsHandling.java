package practiceLocators;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.baseClass;

public class windowsHandling extends baseClass {

	public windowsHandling() {
		PageFactory.initElements(driver, this);
	}

	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	@FindBy(xpath="//span[text()='Continue with Google']")
	WebElement googleLogin;
	
	@FindBy(id="identifierId")
	WebElement emailId;
	
	@FindBy(xpath="//button[starts-with(@class,'VfPpkd')]//span[text()='Next']")
	WebElement nxtBtn;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement pswd;
	
	@FindBy(xpath="//a[@title='Jobseeker Login']")
	WebElement naukriLogin;
	
	@FindBy(xpath="//div[@class='drawer-wrapper ']")
	WebElement naukriLoginPopup;
	
	@FindBy(xpath="//div[@class='social-media']")
	WebElement signInGoogle;
	
	@FindBy(id="identifierId")
	WebElement email;
	
	@FindBy(name="Passwd")
	WebElement pswd1;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextBtn;
	
	/*
	 * public void windowHandleTest(String email, String pwd) { String parentWin =
	 * driver.getWindowHandle(); System.out.println("This is our Parent Window" +
	 * parentWin); googleLogin.click(); Set<String> winHandles =
	 * driver.getWindowHandles(); System.out.println("All Windows Handle"
	 * +winHandles);
	 * 
	 * for (String winhan : winHandles) { if(!parentWin.equals(winhan)) {
	 * driver.switchTo().window(winhan);
	 * System.out.println("Switched to google window handle");
	 * emailId.sendKeys(email); nxtBtn.click(); pswd.sendKeys(pwd); nxtBtn.click();
	 * break; } } driver.switchTo().window(parentWin);
	 * System.out.println("Switched to Parent Window"); }
	 */
	
	public void naukriLogin(String email, String pwd) {
		String parentWind = driver.getWindowHandle();
		js.executeScript("arguments[0].click()", naukriLogin);
		wait.until(ExpectedConditions.visibilityOf(naukriLoginPopup));
		System.out.println("Naviageted to Naukri Login Popup");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(signInGoogle));
			signInGoogle.click();
			System.out.println("Clicked on SignIn with Google");
		} catch (Exception e) {
			System.err.println("Sign In with google is not clickable");
			e.printStackTrace();
			return;
		}
		wait.until(driver->driver.getWindowHandles().size()>1);
		Set<String> winhan = driver.getWindowHandles();
		for(String winhandle : winhan) {
			if(!parentWind.equals(winhandle)) {
				driver.switchTo().window(winhandle);
				System.out.println("Switched to google sign in Page..");
				try {
					this.email.sendKeys(email);
					nextBtn.click();
					pswd1.sendKeys(pwd);
					nextBtn.click();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Not able to Interact");
				}
				break;
			}
		}
		driver.switchTo().window(parentWind);
		System.out.println("Switched to Parent Window");
	}
}
