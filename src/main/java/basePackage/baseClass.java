package basePackage;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class baseClass {

	public static WebDriver driver;
	public static Properties prop;

	public baseClass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"D:\\SeleniumPractice\\Selenium_Practice\\src\\main\\resource\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void Initialized() {
		String BrowserName = prop.getProperty("BrowserName");
		if (BrowserName.equals("google")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-popup-blocking");
	        options.setAcceptInsecureCerts(true);
	        options.addArguments("--ignore-certificate-errors");
	        driver = new ChromeDriver(options);
			System.out.println("Google Chrome Driver is Initialized");
		} else if (BrowserName.equals("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox Driver Initialized");
		} else if (BrowserName.equals("edge")) {
			driver = new EdgeDriver();
			System.out.println("Edge Driver Initialized");
		} else {
			System.out.println("Driver Not Found");
		}
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/*
	 * @AfterMethod public void Screeshot() throws IOException { TakesScreenshot ts
	 * = (TakesScreenshot)driver; File src = ts.getScreenshotAs(OutputType.FILE);
	 * File des = new
	 * File("D:\\SeleniumPractice\\Selenium_Practice\\screenshot\\s"+i+".png");
	 * FileUtils.copyFile(src, des); }
	 */
	
	  @AfterTest public void closeWeb() { driver.quit(); }
	 
}
