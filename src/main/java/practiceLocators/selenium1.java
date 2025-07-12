package practiceLocators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePackage.baseClass;

public class selenium1 extends baseClass {

	public selenium1() {
		PageFactory.initElements(driver, this);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	@FindBy(name = "radioButton")
	WebElement radioBtn;

	@FindBy(id = "autocomplete")
	WebElement SuggestionCLassExample;

	@FindBy(xpath = "//ul[@id='ui-id-1']//li")
	WebElement CountryListSuggestion;
	
	@FindBy(id="dropdown-class-example")
	WebElement DrpDwn;
	
	@FindBy(id="checkBoxOption1")
	WebElement chkBox;
	
	@FindBy(id="openwindow")
	WebElement openWindowBtn;

	public void allActions() {
		radioBtn.click();
		SuggestionCLassExample.sendKeys(prop.getProperty("CountryName"));

		List<WebElement> listCountry = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));
		int CountryList = listCountry.size();
		System.out.println("Total Suggestion : " + CountryList);
		for (WebElement cntryList : listCountry) {
			String Expected_Country = prop.getProperty("CountryName");
			String Actual_Country = cntryList.getText();
			if (Expected_Country.equals(Actual_Country)) {
				CountryListSuggestion.click();
			}
		}
	}

	public void Dropdown() {
         Select sel = new Select(DrpDwn);
         sel.selectByContainsVisibleText("Option1");
	}
	
	public void checkBoxExample() {
		chkBox.click();
	}
	
	public void linkPartialLinkTest() {
		driver.findElement(By.linkText("Home")).click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.findElement(By.partialLinkText("All"));
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.findElement(By.partialLinkText("Job"));
	}
}
