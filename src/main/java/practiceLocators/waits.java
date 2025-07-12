package practiceLocators;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.baseClass;

public class waits extends baseClass{

	public waits() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[starts-with(@class,'text-5xl')]")
	WebElement valueVisibility;
	
	public void implicitewait() {
		System.out.println("Started Timer to see wait time");
		long startTime = System.currentTimeMillis();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		long endTime = System.currentTimeMillis();
		System.out.println("Total taken time : "+(endTime-startTime)+" ms ");
		System.out.println("Dome has waited for 20 seconds ");
	}
	
	public void explicteWait() {
		System.out.println("Started Timer to see Implicite wait time taken");
		long start_time=System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(valueVisibility));
		long end_time = System.currentTimeMillis();
		System.out.println("Total Time Taken : "+(end_time-start_time)+" ms ");
	}
	
	public void fluentwait() {
		System.out.println("Started Timer to see Implicite wait time taken");
		long start_time=System.currentTimeMillis();
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(valueVisibility));
		long end_time = System.currentTimeMillis();
		System.out.println("Total Time Taken : "+(end_time-start_time));
	}
}
