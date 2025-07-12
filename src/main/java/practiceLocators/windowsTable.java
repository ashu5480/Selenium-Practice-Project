package practiceLocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.baseClass;

public class windowsTable extends baseClass {

	public windowsTable() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@id='countries']//tr")
	WebElement tablerow;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement dialogExpected;

	@FindBy(xpath = "//div[@role='dialog']//*[local-name()='svg']//*[local-name()='use']")
	WebElement cancelBtn;

	@FindBy(xpath = "//div[@class='text-xs leading-4']")
	WebElement niftyTable;

	@FindBy(xpath = "//div[@class='text-xs leading-4']//div[starts-with(@class, 'group')]")
	WebElement tableRow;

	@FindBy(xpath = "//div[@class='text-xs leading-4']//div[starts-with(@class, 'group')][1]/div[@class='table-row']//div[starts-with(@class,'ml-3')]")
	WebElement tableColumn;

	public void findCurrency(String country) {
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id='countries']//tr"));
		int rowSize = rowCount.size() - 1;
		System.out.println("Total Number of Rows : " + rowSize);

		List<WebElement> columnCount = driver.findElements(By.xpath("//table[@id='countries']//tr[1]//td"));
		int columnSize = columnCount.size();
		System.out.println("Total Number of column : " + columnSize);

		// Find Currency

		for (int i = 1; i <= rowSize; i++) {
			for (int j = 1; j < columnSize; j++) {
				WebElement r1 = driver
						.findElement(By.xpath("//table[@id='countries']//tr[" + (i + 1) + "]//td[" + (j + 1) + "]"));
				String CountryName = r1.getText();
				if (CountryName.equals(country)) {
					System.out.println("Found Country at :  " + (i) + "th row");
					WebElement curency = driver
							.findElement(By.xpath("//table[@id='countries']//tr[" + (i + 1) + "]//td[4]"));
					String curencyName = curency.getText();
					System.out.println("Currency of " + country + " is : " + curencyName);
				}
			}
		}

	}

	public void findcapitals(String country) {
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id='countries']//tr"));
		int rowSize = rowCount.size() - 1;
		System.out.println("Total Number of Rows : " + rowSize);

		List<WebElement> columnCount = driver.findElements(By.xpath("//table[@id='countries']//tr[1]//td"));
		int columnSize = columnCount.size();
		System.out.println("Total Number of column : " + columnSize);

		for (int i = 1; i <= rowSize; i++) {
			for (int j = 1; j < columnSize; j++) {
				WebElement r1 = driver
						.findElement(By.xpath("//table[@id='countries']//tr[" + (i + 1) + "]//td[" + (j + 1) + "]"));
				String CountryName = r1.getText();
				if (CountryName.equals(country)) {
					System.out.println("Found Country at :  " + (i) + "th row");
					WebElement capital = driver
							.findElement(By.xpath("//table[@id='countries']//tr[" + (i + 1) + "]//td[3]"));
					String curencyName = capital.getText();
					System.out.println("Capital of " + country + " is : " + curencyName);
				}
			}
		}
	}

	public void dynamicTable1() {
		// Number of columns
		List<WebElement> columnSize = driver.findElements(By.xpath("//thead//tr//th"));
		int columnCount = columnSize.size();

		// Number of Rows
		List<WebElement> rowSize = driver.findElements(By.xpath("//table//tbody//tr"));
		int rowCount = rowSize.size();

		// print all table data
		for (int i = 1; i < rowCount; i++) {
			for (int j = 1; j < columnCount; j++) {
				WebElement dataTable = driver.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[" + j + "]"));
				String tableValues = dataTable.getText();
				System.out.print("values : " + tableValues);
			}
		}
	}

	public void dynamicTable2(String SensexName) {
		if (dialogExpected.isDisplayed()) {
			cancelBtn.click();

		}

		List<WebElement> rowCount = driver.findElements(By.xpath(
				"//div[@class='text-xs leading-4']//div[starts-with(@class, 'group')]//div[starts-with(@class,'table-row')]"));
		int rowSize = rowCount.size();

		List<WebElement> columnCount = driver.findElements(By.xpath(
				"//div[@class='text-xs leading-4']//div[starts-with(@class, 'group')][1]/div[@class='table-row']//div[starts-with(@class,'ml-3')]"));
		int columnSize = columnCount.size();

		System.out.println("TotalNumber of Rows : " + rowSize + " , " + "Total Number of Column are : " + columnSize);

		for (int i = 1; i < rowSize; i++) {
			WebElement sensexName = driver
					.findElement(By.xpath("//div[@class='text-xs leading-4']//div[starts-with(@class, 'group')][" + i
							+ "]//div[@class='table-row']//div"));
			String sensexValue = sensexName.getText();
			System.out.println(sensexValue);
			if (SensexName.equals(sensexValue)) {
				WebElement tableData = driver
						.findElement(By.xpath("//div[@class='text-xs leading-4']//div[starts-with(@class, 'group')]["
								+ i + "]//div[@class='table-row']//div[starts-with(@class,'ml-3')][1]"));
				String sensexPrice = tableData.getText();
				System.out.println("Price of given " + SensexName + " is : " + sensexPrice);
				break;
			}
			continue;
		}
	}
}
