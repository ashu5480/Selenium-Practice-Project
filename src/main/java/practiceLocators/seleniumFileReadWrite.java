package practiceLocators;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.baseClass;

public class seleniumFileReadWrite extends baseClass {

	public seleniumFileReadWrite() {
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@FindBy(id = "user-name")
	// @FindBy(xpath="//input[@name='uname']/ancestor::div[starts-with(@class,'mat')][1]")
	WebElement username;

	@FindBy(id = "password")
	WebElement pwd;

	@FindBy(id = "login-button")
	WebElement signInBtn;

	@FindBy(xpath = "//div[@id='login-username']/child::span[1]")
	WebElement loggedInUser;
	
	@FindBy(xpath="//div[@class='modal-content']/ancestor::ae-release-notes-modal")
	WebElement releaseNotes;

	public void writeInExcel(String filePath, String sheetName) throws IOException, InterruptedException {

		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int totalRow = sheet.getLastRowNum() + 1;
		//int totalCol = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= totalRow; i++) {
				String username = sheet.getRow(i).getCell(1).toString();
				System.out.println("Username is : " + username);
				String password = sheet.getRow(i).getCell(2).toString();
				System.out.print("Password is : " + password);

				this.username.sendKeys(username);
				pwd.sendKeys(password);
				signInBtn.click();

				System.out.println("\t");
				System.out.println("User logged in ");

				//wait.until(ExpectedConditions.visibilityOf(loggedInUser));
				//String ActualUsername = loggedInUser.getText();
				//Assert.assertEquals(ActualUsername, username);
			System.out.println();
			Thread.sleep(3000);
			break;
		}
		workbook.close();
	}
}
